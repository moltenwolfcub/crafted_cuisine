package com.moltenwolfcub.crafted_cuisine.blocks.entity;

import java.util.Arrays;

import javax.annotation.Nonnull;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockEntities;
import com.moltenwolfcub.crafted_cuisine.screen.CookingBowlMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

public class CookingBowlblockEntity extends BaseContainerBlockEntity implements WorldlyContainer {
    public static final int SLOT_COUNT = 18; 
    public static final int[] INPUT_SLOTS = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    public static final int[] OUTPUT_SLOTS = {9, 10, 11, 12, 13, 14, 15, 16, 17};
    LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN);

    private final ItemStackHandler itemHandler = new ItemStackHandler(SLOT_COUNT) {

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        };
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;


    public CookingBowlblockEntity(BlockPos pos, BlockState state) {
        super(AllBlockEntities.COOKING_BOWL.get(), pos, state);
        this.data = new SimpleContainerData(0);
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if (!this.remove && side != null && cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (side == Direction.DOWN) {
                return handlers[1].cast();
            } else {
                return handlers[0].cast();
            }
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps()  {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    protected void saveAdditional(@Nonnull CompoundTag tag) {
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
        return SLOT_COUNT;
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
        return slotId >= 0 && slotId <= SLOT_COUNT && !items.getStackInSlot(slotId).isEmpty() && count > 0 ? items.getStackInSlot(slotId).split(count) : ItemStack.EMPTY;
    }
 
    public static ItemStack takeItem(ItemStackHandler items, int slotId) {
        items.setStackInSlot(slotId, ItemStack.EMPTY);
        return slotId >= 0 && slotId <= SLOT_COUNT ? items.getStackInSlot(slotId) : ItemStack.EMPTY;
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
           return OUTPUT_SLOTS;
        } else {
           return INPUT_SLOTS;
        }
    }

    @Override
    public boolean canPlaceItemThroughFace(int slotId, ItemStack stack, Direction dir) {
        if (arrayContains(OUTPUT_SLOTS, slotId)) { //output
            return false;
        } else if (arrayContains(INPUT_SLOTS, slotId)) { //input
            return true;
        }

        return false;
    }


    public static boolean arrayContains(final int[] array, final int item) {
        return Arrays.stream(array).anyMatch(i -> i == item);
    }

    @Override
    public boolean canTakeItemThroughFace(int slotId, ItemStack stack, Direction dir) {
        return true;
    }


    @Override
    public Component getDefaultName() {
        return new TranslatableComponent("container." + CraftedCuisine.MODID + ".cooking_bowl");
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new CookingBowlMenu(containerId, inventory, this, this.data, ContainerLevelAccess.create(inventory.player.level, this.getBlockPos()));
    }

    public static void tick(Level level, BlockPos pos, BlockState state, CarameliserBlockEntity blockEntity) {
        
    }
    
}
 