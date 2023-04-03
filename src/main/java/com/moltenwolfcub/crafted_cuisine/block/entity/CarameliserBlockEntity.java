package com.moltenwolfcub.crafted_cuisine.block.entity;

import java.util.Optional;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.block.CarameliserBlock;
import com.moltenwolfcub.crafted_cuisine.block.entity.util.ImplementedInventory;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockEntities;
import com.moltenwolfcub.crafted_cuisine.recipe.CarameliserRecipe;
import com.moltenwolfcub.crafted_cuisine.screen.CarameliserMenu;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.impl.content.registry.FuelRegistryImpl;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class CarameliserBlockEntity extends BaseContainerBlockEntity implements ImplementedInventory {
    public static final int SLOT_WATER = 0;
    public static final int SLOT_INPUT_FIRST = 1;
    public static final int SLOT_INPUT_SECOND = 2;
    public static final int SLOT_INPUT_THIRD = 3;
    public static final int SLOT_FUEL = 4;
    public static final int SLOT_OUTPUT = 5;

    public static final int slotCount = 6;

    private final NonNullList<ItemStack> inventory = NonNullList.withSize(slotCount, ItemStack.EMPTY);

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;
    private int waterMiliBuckets = 0;
    private int maxWaterMiliBuckets = 1000;
    private int litDuration = 0;
    private int litTime = 0;

    private boolean shouldChange = false;


    public CarameliserBlockEntity(BlockPos pos, BlockState state) {
        super(AllBlockEntities.CARAMELISER, pos, state);

        this.data = new ContainerData() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> CarameliserBlockEntity.this.progress;
                    case 1 -> CarameliserBlockEntity.this.maxProgress;
                    case 2 -> CarameliserBlockEntity.this.waterMiliBuckets;
                    case 3 -> CarameliserBlockEntity.this.maxWaterMiliBuckets;
                    case 4 -> CarameliserBlockEntity.this.litTime;
                    case 5 -> CarameliserBlockEntity.this.litDuration;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> CarameliserBlockEntity.this.progress = value;
                    case 1 -> CarameliserBlockEntity.this.maxProgress = value;
                    case 2 -> CarameliserBlockEntity.this.waterMiliBuckets = value;
                    case 3 -> CarameliserBlockEntity.this.maxWaterMiliBuckets = value;
                    case 4 -> CarameliserBlockEntity.this.litTime = value;
                    case 5 -> CarameliserBlockEntity.this.litDuration = value;
                }
                
            }

            @Override
            public int getCount() {
                return 6;
            }
            
        };
    }


    @Override
    public @NotNull Component getDefaultName() {
        return Component.translatable("container." + CraftedCuisine.MODID + ".carameliser");
    }

    @Override
    public @NotNull AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new CarameliserMenu(containerId, inventory, this, this.data, ContainerLevelAccess.create(inventory.player.level, this.getBlockPos()));
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        ContainerHelper.saveAllItems(tag, inventory);
        tag.putInt("carameliser.progress", progress);
        tag.putInt("carameliser.water_milibuckets", waterMiliBuckets);
        tag.putInt("carameliser.lit_time", litTime);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        ContainerHelper.loadAllItems(nbt, inventory);
        super.load(nbt);
        progress = nbt.getInt("carameliser.progress");
        waterMiliBuckets = nbt.getInt("carameliser.water_milibuckets");
        litTime = nbt.getInt("carameliser.lit_time");
        litDuration = getBurnDuration(inventory.get(SLOT_FUEL));
    }

    public static void tick(Level level, BlockPos pos, BlockState state, CarameliserBlockEntity blockEntity) {
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
            state = state.setValue(CarameliserBlock.FULL, blockEntity.isLit());
            level.setBlock(pos, state, Block.UPDATE_ALL);
        }

        if (blockEntity.shouldChange) {
            setChanged(level, pos, state);
        }
    }

    private static void craftItem(CarameliserBlockEntity entity) {

        Optional<CarameliserRecipe> match = getRecipies(entity);

        if (match.isPresent()) {
            reduceWater(entity);
            entity.removeItem(SLOT_INPUT_FIRST, 1);
            entity.removeItem(SLOT_INPUT_SECOND, 1);
            entity.removeItem(SLOT_INPUT_THIRD, 1);
    
            entity.setItem(SLOT_OUTPUT, new ItemStack(
                match.get().getResultItem(entity.level.registryAccess()).getItem(), entity.getItem(SLOT_OUTPUT).getCount() + 1
            ));
    
            entity.progress = 0;
        }
    }

    private static boolean hasRecipe(CarameliserBlockEntity entity) {

        ItemStack fuelStack = entity.getItem(SLOT_FUEL);

        if (!entity.getItem(SLOT_INPUT_FIRST).isEmpty() && 
            !entity.getItem(SLOT_INPUT_SECOND).isEmpty() && 
            !entity.getItem(SLOT_INPUT_THIRD).isEmpty()) {
            if (entity.isLit()) {
                return hasRecipePredicates(entity);
            } else if (CarameliserBlockEntity.getBurnDuration(fuelStack) > 0 && hasRecipePredicates(entity)) {
                entity.litTime = CarameliserBlockEntity.getBurnDuration(fuelStack);
                entity.litDuration = entity.litTime;

                ItemStack newStack = new ItemStack(fuelStack.getItem(), fuelStack.getCount() -1);
                entity.setItem(SLOT_FUEL, newStack);
                return hasRecipePredicates(entity);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static boolean hasRecipePredicates(CarameliserBlockEntity entity) {
        Optional<CarameliserRecipe> match = getRecipies(entity);

        return match.isPresent() && hasRoomInOutput(entity) && willOutputItemFit(entity, match.get().getResultItem(entity.level.registryAccess())) && hasWater(entity);
    }

    private static Optional<CarameliserRecipe> getRecipies(CarameliserBlockEntity entity) {
        Level level = entity.level;

        SimpleContainer inventory = new SimpleContainer(entity.inventory.size());
        for (int slot = 0; slot < entity.inventory.size(); slot++) {
            inventory.setItem(slot, entity.getItem(slot));
        }

        if (level == null) {
            throw new NullPointerException("level can't be null");
        }
        return level.getRecipeManager().getRecipeFor(CarameliserRecipe.Type.INSTANCE, inventory, level);
        
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
        ItemStack waterStack = entity.getItem(SLOT_WATER);

        int bucketWaterIncrease = 1000;
        int bottleWaterIncrease = 250;

        if (waterStack.getItem() == Items.WATER_BUCKET) {
            addWater(entity, bucketWaterIncrease);
        } else if (PotionUtils.getPotion(waterStack) == Potions.WATER) {
            addWater(entity, bottleWaterIncrease);
        }
    }

    private static void addWater(CarameliserBlockEntity entity, int amount) {
        ItemStack waterStack = entity.getItem(SLOT_WATER);

        if (entity.waterMiliBuckets + amount <= entity.maxWaterMiliBuckets) {
            entity.waterMiliBuckets += amount;
            entity.setItem(SLOT_WATER, new ItemStack(waterStack.getItem(), waterStack.getCount() - 1));
        }
    }


    public static int getBurnDuration(ItemStack stack) {
        if (stack.isEmpty()) {
            return 0;
        } else {
            return ((FuelRegistryImpl) FuelRegistry.INSTANCE).getFuelTimes().getOrDefault(stack.getItem(), 0);
        }
    }

    private boolean isLit() {
        return this.litTime > 0;
    }


    private static boolean hasRoomInOutput(CarameliserBlockEntity entity) {
        return entity.getItem(SLOT_OUTPUT).getCount() < entity.getItem(SLOT_OUTPUT).getMaxStackSize();
    }

    private static boolean willOutputItemFit(CarameliserBlockEntity entity, ItemStack output) {
        return entity.getItem(SLOT_OUTPUT).getItem() == output.getItem() || entity.getItem(SLOT_OUTPUT).isEmpty();
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
