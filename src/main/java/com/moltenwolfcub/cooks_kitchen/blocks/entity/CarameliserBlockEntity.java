package com.moltenwolfcub.cooks_kitchen.blocks.entity;

import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.moltenwolfcub.cooks_kitchen.init.ModBlockEntities;
import com.moltenwolfcub.cooks_kitchen.recipe.CarameliserRecipe;
import com.moltenwolfcub.cooks_kitchen.screen.CarameliserMenu;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

public class CarameliserBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer {
    public static final int SLOT_WATER = 0;
    public static final int SLOT_INPUT_FIRST = 1;
    public static final int SLOT_INPUT_SECOND = 2;
    public static final int SLOT_INPUT_THIRD = 3;
    public static final int SLOT_FUEL = 4;
    public static final int SLOT_OUTPUT = 5;
    
    private static final int[] SLOTS_FOR_UP = new int[]{SLOT_INPUT_FIRST, SLOT_INPUT_SECOND, SLOT_INPUT_THIRD};
    private static final int[] SLOTS_FOR_DOWN = new int[]{SLOT_OUTPUT};
    private static final int[] SLOTS_FOR_SIDES = new int[]{SLOT_WATER, SLOT_FUEL};
    LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

    public final int slotCount = 6;
    // private final RecipeType<TheCaramliserRecipeThatIsntMadeYet> recipeType;

    private final ItemStackHandler itemHandler = new ItemStackHandler(slotCount) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        };
    };
    private LazyOptional<ItemStackHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 150;
    private int waterMiliBuckets = 0;
    private int maxWaterMiliBuckets = 1000;


    public CarameliserBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CARAMELISER_BLOCK_ENTITY.get(), pos, state);

        this.data = new ContainerData() {
            public int get(int index) {
                switch (index) {
                    case 0: return CarameliserBlockEntity.this.progress;
                    case 1: return CarameliserBlockEntity.this.maxProgress;
                    case 2: return CarameliserBlockEntity.this.waterMiliBuckets;
                    case 3: return CarameliserBlockEntity.this.maxWaterMiliBuckets;
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
                }
                
            }

            @Override
            public int getCount() {
                return 4;
            }
            
        };
    }


    @Override
    public Component getDefaultName() {
        return new TextComponent("Carameliser");
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new CarameliserMenu(containerId, inventory, this, this.data, ContainerLevelAccess.create(inventory.player.level, this.getBlockPos()));
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (!this.remove && side != null && cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (side == Direction.UP)
                return handlers[0].cast();
            else if (side == Direction.DOWN)
                return handlers[1].cast();
            else
                return handlers[2].cast();
        } 
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps()  {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("carameliser.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public int getContainerSize() {
        return slotCount;
    }

    @Override
    public boolean isEmpty() {
        for(int i = 0; i < this.getContainerSize(); i++) {
            ItemStack itemstack = this.itemHandler.getStackInSlot(i);
            if (!itemstack.isEmpty()) {
                return false;
            }
        }
  
        return true;
    }

    @Override
    public ItemStack getItem(int slotId) {
        return this.itemHandler.getStackInSlot(slotId);
    }

    @Override
    public ItemStack removeItem(int slotId, int count) {
        ItemStack itemstack = removeItem(this.itemHandler, slotId, count);
        if (!itemstack.isEmpty()) {
            this.setChanged();
        }
        return itemstack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int slotId) {
        return takeItem(this.itemHandler, slotId);
    }

    public static ItemStack removeItem(ItemStackHandler items, int slotId, int count) {
        return slotId >= 0 && slotId < 6 && !items.getStackInSlot(slotId).isEmpty() && count > 0 ? items.getStackInSlot(slotId).split(count) : ItemStack.EMPTY;
    }
 
    public static ItemStack takeItem(ItemStackHandler items, int slotId) {
        items.setStackInSlot(slotId, ItemStack.EMPTY);
        return slotId >= 0 && slotId < 6 ? items.getStackInSlot(slotId) : ItemStack.EMPTY;
    }
 
    @Override
    public void setItem(int slotId, ItemStack stack) {
        this.itemHandler.setStackInSlot(slotId, stack);
        
        if (stack.getCount() > this.getMaxStackSize()) {
           stack.setCount(this.getMaxStackSize());
        }
  
    }

    @Override
    public boolean stillValid(Player player) {
        if (this.level.getBlockEntity(this.worldPosition) != this) {
           return false;
        } else {
            return player.distanceToSqr(
                (double)this.worldPosition.getX() + 0.5D, 
                (double)this.worldPosition.getY() + 0.5D, 
                (double)this.worldPosition.getZ() + 0.5D
            ) <= 64.0D;
        }
    }

    @Override
    public void clearContent() {
        for(int slot = 0; slot < getContainerSize(); slot++) {
            this.itemHandler.setStackInSlot(slot, ItemStack.EMPTY);
        }
    }

    @Override
    public int[] getSlotsForFace(Direction dir) {
        if (dir == Direction.DOWN) {
           return SLOTS_FOR_DOWN;
        } else {
           return dir == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
        }
    }

    @Override
    public boolean canPlaceItemThroughFace(int slotId, ItemStack stack, Direction dir) {
        if (slotId == SLOT_OUTPUT) { //output
            return false;
        } else if (slotId != SLOT_WATER && slotId != SLOT_FUEL) { //input
            return true;
        } else if (slotId == SLOT_WATER) { //water
            return stack.is(Items.WATER_BUCKET) || PotionUtils.getPotion(stack) == Potions.WATER;
        } else {
            return stack.is(Items.COAL);//ForgeHooks.getBurnTime(stack, this.recipeType) > 0;
        }
    }

    @Override
    public boolean canTakeItemThroughFace(int slotId, ItemStack stack, Direction dir) {
        return true;
    }
   

    public static void tick(Level level, BlockPos pos, BlockState state, CarameliserBlockEntity blockEntity) {
        checkWater(blockEntity);

        if(hasRecipe(blockEntity)) {
            blockEntity.progress++;
            setChanged(level, pos, state);
            if (blockEntity.progress > blockEntity.maxProgress) {
                craftItem(blockEntity);
            }
        } else {
            blockEntity.resetProgress();
            setChanged(level, pos, state);
        }
    }

    private static void craftItem(CarameliserBlockEntity entity) {

        Optional<CarameliserRecipe> match = getRecipies(entity);

        if (match.isPresent()) {
            reduceWater(entity);
            entity.itemHandler.extractItem(SLOT_INPUT_FIRST,1, false);
            entity.itemHandler.extractItem(SLOT_INPUT_SECOND,1, false);
            entity.itemHandler.extractItem(SLOT_INPUT_THIRD,1, false);
    
            entity.itemHandler.setStackInSlot(SLOT_OUTPUT, new ItemStack(
                match.get().getResultItem().getItem(), entity.itemHandler.getStackInSlot(SLOT_OUTPUT).getCount() + 1
            ));
    
            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(CarameliserBlockEntity entity) {

        Optional<CarameliserRecipe> match = getRecipies(entity);

        return match.isPresent() && outputNotFull(entity) && ItemFitsInOutput(entity, match.get().getResultItem())
            && hasWater(entity) && hasFuel(entity);
    }

    private static Optional<CarameliserRecipe> getRecipies(CarameliserBlockEntity entity) {
        Level level = entity.level;

        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int slot = 0; slot < entity.itemHandler.getSlots(); slot++) {
            inventory.setItem(slot, entity.itemHandler.getStackInSlot(slot));
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
        ItemStack waterStack = entity.itemHandler.getStackInSlot(SLOT_WATER);

        int bucketWaterIncrease = 1000;
        int bottleWaterIncrease = 250;

        if (waterStack.getItem() == Items.WATER_BUCKET) {
            addWater(entity, bucketWaterIncrease);
        } else if (PotionUtils.getPotion(waterStack) == Potions.WATER) {
            addWater(entity, bottleWaterIncrease);
        }
    }

    private static void addWater(CarameliserBlockEntity entity, int amount) {
        ItemStack waterStack = entity.itemHandler.getStackInSlot(SLOT_WATER);

        if (entity.waterMiliBuckets + amount <= entity.maxWaterMiliBuckets) {
            entity.waterMiliBuckets += amount;
            entity.itemHandler.setStackInSlot(SLOT_WATER, new ItemStack(waterStack.getItem(), waterStack.getCount() - 1));
        }
    }


    private static boolean hasFuel(CarameliserBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(SLOT_FUEL).getItem() == Items.COAL;
        //ForgeHooks.getBurnTime(entity.itemHandler.getStackInSlot(4), entity.recipeType) > 0;
    }


    private static boolean outputNotFull(CarameliserBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(SLOT_OUTPUT).getCount() < entity.itemHandler.getStackInSlot(SLOT_OUTPUT).getMaxStackSize();
    }

    private static boolean ItemFitsInOutput(CarameliserBlockEntity entity, ItemStack output) {
        return entity.itemHandler.getStackInSlot(SLOT_OUTPUT).getItem() == output.getItem() || entity.itemHandler.getStackInSlot(SLOT_OUTPUT).isEmpty();
    }

    private void resetProgress() {
        this.progress = 0;
    }
}
