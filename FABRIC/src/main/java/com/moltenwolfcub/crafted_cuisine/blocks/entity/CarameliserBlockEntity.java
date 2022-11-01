package com.moltenwolfcub.crafted_cuisine.blocks.entity;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.blocks.CarameliserBlock;
import com.moltenwolfcub.crafted_cuisine.blocks.entity.util.ImplementedInventory;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockEntities;
import com.moltenwolfcub.crafted_cuisine.screen.CarameliserScreenHandler;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.impl.content.registry.FuelRegistryImpl;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CarameliserBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    public static final int SLOT_WATER = 0;
    public static final int SLOT_INPUT_FIRST = 1;
    public static final int SLOT_INPUT_SECOND = 2;
    public static final int SLOT_INPUT_THIRD = 3;
    public static final int SLOT_FUEL = 4;
    public static final int SLOT_OUTPUT = 5;

    public final int slotCount = 6;

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(slotCount, ItemStack.EMPTY);

    protected final PropertyDelegate data;
    private int progress = 0;
    private int maxProgress = 100;
    private int waterMiliBuckets = 0;
    private int maxWaterMiliBuckets = 1000;
    private int litDuration = 0;
    private int litTime = 0;

    private boolean shouldChange = false;


    public CarameliserBlockEntity(BlockPos pos, BlockState state) {
        super(AllBlockEntities.CARAMELISER, pos, state);

        this.data = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return CarameliserBlockEntity.this.progress;
                    case 1: return CarameliserBlockEntity.this.maxProgress;
                    case 2: return CarameliserBlockEntity.this.waterMiliBuckets;
                    case 3: return CarameliserBlockEntity.this.maxWaterMiliBuckets;
                    case 4: return CarameliserBlockEntity.this.litTime;
                    case 5: return CarameliserBlockEntity.this.litDuration;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch(index) {
                    case 0: CarameliserBlockEntity.this.progress = value; break;
                    case 1: CarameliserBlockEntity.this.maxProgress = value; break;
                    case 2: CarameliserBlockEntity.this.waterMiliBuckets = value; break;
                    case 3: CarameliserBlockEntity.this.maxWaterMiliBuckets = value; break;
                    case 4: CarameliserBlockEntity.this.litTime = value; break;
                    case 5: CarameliserBlockEntity.this.litDuration = value; break;
                }
                
            }

            @Override
            public int size() {
                return 6;
            }
            
        };
    }


    @Override
    public Text getDisplayName() {
        return new TranslatableText("container." + CraftedCuisine.MODID + ".carameliser");
    }

    @Override
    public ScreenHandler createMenu(int containerId, PlayerInventory inventory, PlayerEntity player) {
        return new CarameliserScreenHandler(containerId, inventory, this, this.data, ScreenHandlerContext.create(inventory.player.world, this.getPos()));
    }

    // @Nonnull
    // @Override
    // public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
    //     if (!this.remove && side != null && cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
    //         if (side == Direction.UP)
    //             return handlers[0].cast();
    //         else if (side == Direction.DOWN)
    //             return handlers[1].cast();
    //         else
    //             return handlers[2].cast();
    //     } 
    //     return super.getCapability(cap, side);
    // }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound tag) {
        Inventories.writeNbt(tag, inventory);
        tag.putInt("carameliser.progress", progress);
        tag.putInt("carameliser.water_milibuckets", waterMiliBuckets);
        tag.putInt("carameliser.lit_time", litTime);
        super.writeNbt(tag);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("carameliser.progress");
        waterMiliBuckets = nbt.getInt("carameliser.water_milibuckets");
        litTime = nbt.getInt("carameliser.lit_time");
        litDuration = getBurnDuration(inventory.get(SLOT_FUEL));
    }

    public static void tick(World level, BlockPos pos, BlockState state, CarameliserBlockEntity blockEntity) {
        boolean lit = blockEntity.isLit();
        checkWater(blockEntity);
        if (blockEntity.isLit()) {
            --blockEntity.litTime;
        }

        if(hasRecipe(blockEntity)) {
            blockEntity.progress++;
            blockEntity.shouldChange = true;
            if (blockEntity.progress > blockEntity.maxProgress) {
                craftItem(blockEntity);
            }
        } else {
            blockEntity.reduceProgress(blockEntity);
            blockEntity.shouldChange = true;
        }

        if (lit != blockEntity.isLit()) {
            blockEntity.shouldChange = true;
            state = state.with(CarameliserBlock.FULL, Boolean.valueOf(blockEntity.isLit()));
            level.setBlockState(pos, state, Block.NOTIFY_ALL);
        }

        if (blockEntity.shouldChange) {
            markDirty(level, pos, state);
        }
    }

    private static void craftItem(CarameliserBlockEntity entity) {

        /*Optional<CarameliserRecipe>*/boolean match = getRecipies(entity);

        if (match/*.isPresent()*/) {
            reduceWater(entity);
            entity.removeStack(SLOT_INPUT_FIRST,1);
            entity.removeStack(SLOT_INPUT_SECOND,1);
            entity.removeStack(SLOT_INPUT_THIRD,1);
    
            entity.setStack(SLOT_OUTPUT, new ItemStack(
                /*TODO match.get().getResultItem().getItem()*/Items.STONE, entity.getStack(SLOT_OUTPUT).getCount() + 1
            ));
    
            entity.progress = 0;
        }
    }

    private static boolean hasRecipe(CarameliserBlockEntity entity) {

        ItemStack fuelStack = entity.getStack(SLOT_FUEL);

        if (!entity.getStack(SLOT_INPUT_FIRST).isEmpty() && 
            !entity.getStack(SLOT_INPUT_SECOND).isEmpty() && 
            !entity.getStack(SLOT_INPUT_THIRD).isEmpty()) {
            if (entity.isLit()) {
                return hasRecipePredicates(entity);
            } else if (entity.getBurnDuration(fuelStack) > 0 && hasRecipePredicates(entity)) {
                entity.litTime = entity.getBurnDuration(fuelStack);
                entity.litDuration = entity.litTime;

                ItemStack newStack = new ItemStack(fuelStack.getItem(), fuelStack.getCount() -1);
                entity.setStack(SLOT_FUEL, newStack);

                return hasRecipePredicates(entity);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static boolean hasRecipePredicates(CarameliserBlockEntity entity) {
        /*Optional<CarameliserRecipe>*/boolean match = getRecipies(entity);

        return match/*.isPresent()*/ && outputNotFull(entity) && itemFitsInOutput(entity, new ItemStack(Items.STONE, 1)/*match.get().getResultItem()*/) && hasWater(entity);
    }

    private static /*Optional<CarameliserRecipe>*/boolean getRecipies(CarameliserBlockEntity entity) {
        // World world = entity.world;

        // SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        // for (int slot = 0; slot < entity.inventory.size(); slot++) {
        //     inventory.setStack(slot, entity.getStack(slot));
        // }
        // return world.getRecipeManager().getFirstMatch(CarameliserRecipe.Type.INSTANCE, inventory, world);
        return entity.getStack(SLOT_INPUT_FIRST).isOf(Items.IRON_INGOT) && entity.getStack(SLOT_INPUT_SECOND).isOf(Items.COBBLESTONE);
        
    }


    private static boolean hasWater(CarameliserBlockEntity entity) {
        return entity.waterMiliBuckets > 249;
    }
   
    private static void reduceWater(CarameliserBlockEntity entity) {
        if (entity.waterMiliBuckets >= 250) {
            entity.waterMiliBuckets -= 250;
        }
    }

    private static void checkWater(CarameliserBlockEntity entity) {
        ItemStack waterStack = entity.getStack(SLOT_WATER);

        int bucketWaterIncrease = 1000;
        int bottleWaterIncrease = 250;

        if (waterStack.getItem() == Items.WATER_BUCKET) {
            addWater(entity, bucketWaterIncrease);
        } else if (PotionUtil.getPotion(waterStack) == Potions.WATER) {
            addWater(entity, bottleWaterIncrease);
        }
    }

    private static void addWater(CarameliserBlockEntity entity, int amount) {
        ItemStack waterStack = entity.getStack(SLOT_WATER);

        if (entity.waterMiliBuckets + amount <= entity.maxWaterMiliBuckets) {
            entity.waterMiliBuckets += amount;
            entity.setStack(SLOT_WATER, new ItemStack(waterStack.getItem(), waterStack.getCount() - 1));
        }
    }


    public int getBurnDuration(ItemStack stack) {
        if (stack.isEmpty()) {
            return 0;
        } else {
            return ((FuelRegistryImpl) FuelRegistry.INSTANCE).getFuelTimes().getOrDefault(stack.getItem(), 0);
        }
    }

    private boolean isLit() {
        return this.litTime > 0;
    }


    private static boolean outputNotFull(CarameliserBlockEntity entity) {
        return entity.getStack(SLOT_OUTPUT).getCount() < entity.getStack(SLOT_OUTPUT).getMaxCount();
    }

    private static boolean itemFitsInOutput(CarameliserBlockEntity entity, ItemStack output) {
        return entity.getStack(SLOT_OUTPUT).getItem() == output.getItem() || entity.getStack(SLOT_OUTPUT).isEmpty();
    }

    private void reduceProgress(CarameliserBlockEntity entity) {
        if (entity.progress > 0) {
            --entity.progress;
        } else {
            resetProgress(entity);
        }
    }

    private void resetProgress(CarameliserBlockEntity entity) {
        entity.progress = 0;
    }
}
