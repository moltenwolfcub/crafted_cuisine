package com.moltenwolfcub.cooks_kitchen.blocks.entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.moltenwolfcub.cooks_kitchen.init.ModBlockEntities;
import com.moltenwolfcub.cooks_kitchen.init.ModItems;
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
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
    private static final int[] SLOTS_FOR_UP = new int[]{1, 2, 3};
    private static final int[] SLOTS_FOR_DOWN = new int[]{5};
    private static final int[] SLOTS_FOR_SIDES = new int[]{0, 4};
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


    public CarameliserBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CARAMELISER_BLOCK_ENTITY.get(), pos, state);
    }


    @Override
    public Component getDefaultName() {
        return new TextComponent("Carameliser");
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new CarameliserMenu(containerId, inventory, this, new SimpleContainerData(0), ContainerLevelAccess.create(inventory.player.level, this.getBlockPos()));
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
        if (slotId == 5) { //output
            return false;
        } else if (slotId != 0 && slotId != 4) { //input
            return true;
        } else if (slotId == 0) { //water
            return stack.is(Items.WATER_BUCKET);
        } else {
            return stack.is(Items.COAL);//ForgeHooks.getBurnTime(stack, this.recipeType) > 0;
        }
    }

    @Override
    public boolean canTakeItemThroughFace(int slotId, ItemStack stack, Direction dir) {
        return true;
    }
   

    public static void tick(Level level, BlockPos pos, BlockState state, CarameliserBlockEntity blockEntity) {
        if(hasRecipe(blockEntity) && outputNotFull(blockEntity)) {
            craftItem(blockEntity);
        }
    }

    private static void craftItem(CarameliserBlockEntity entity) {

        entity.itemHandler.extractItem(0,1, false);
        entity.itemHandler.extractItem(1,1, false);
        entity.itemHandler.extractItem(2,1, false);
        entity.itemHandler.extractItem(3,1, false);
        entity.itemHandler.extractItem(4,1, false);

        entity.itemHandler.setStackInSlot(5, new ItemStack(ModItems.CARAMEL.get(), entity.itemHandler.getStackInSlot(5).getCount() + 1));
    }

    private static boolean hasRecipe(CarameliserBlockEntity entity) {
        boolean hasFirstInupt = entity.itemHandler.getStackInSlot(1).getItem() == Items.SUGAR;
        boolean hasSecondInput = entity.itemHandler.getStackInSlot(2).getItem() == ModItems.CREAM.get();
        boolean hasThirdInput = entity.itemHandler.getStackInSlot(3).getItem() == ModItems.BUTTER.get();

        boolean hasWater = entity.itemHandler.getStackInSlot(0).getItem() == Items.WATER_BUCKET;
        boolean hasFuel = entity.itemHandler.getStackInSlot(4).getItem() == Items.COAL;//ForgeHooks.getBurnTime(entity.itemHandler.getStackInSlot(4), entity.recipeType) > 0;

        return hasFirstInupt && hasSecondInput && hasThirdInput && hasWater && hasFuel;
    }

    private static boolean outputNotFull(CarameliserBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(5).getCount() < entity.itemHandler.getStackInSlot(5).getMaxStackSize();
    }
}
