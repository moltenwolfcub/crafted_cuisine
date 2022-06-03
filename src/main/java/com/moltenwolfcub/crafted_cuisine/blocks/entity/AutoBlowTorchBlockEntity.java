package com.moltenwolfcub.crafted_cuisine.blocks.entity;

import java.util.Optional;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.moltenwolfcub.crafted_cuisine.init.ModBlockEntities;
import com.moltenwolfcub.crafted_cuisine.init.ModTags;
import com.moltenwolfcub.crafted_cuisine.recipe.AutoBlowTorchRecipe;
import com.moltenwolfcub.crafted_cuisine.screen.AutoBlowtorchMenu;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

public class AutoBlowTorchBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer {
    private static final int[] SLOTS_FOR_UP = new int[]{0};
    private static final int[] SLOTS_FOR_DOWN = new int[]{2};
    private static final int[] SLOTS_FOR_SIDES = new int[]{1};
    LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);


    private final ItemStackHandler itemHandler = new ItemStackHandler(3) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        };
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 20;

    public AutoBlowTorchBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.AUTO_BLOWTORCH_BLOCK_ENTITY.get(), pos, state);

        this.data = new ContainerData() {
            public int get(int index) {
                switch (index) {
                    case 0: return AutoBlowTorchBlockEntity.this.progress;
                    case 1: return AutoBlowTorchBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch(index) {
                    case 0: AutoBlowTorchBlockEntity.this.progress = value; break;
                    case 1: AutoBlowTorchBlockEntity.this.maxProgress = value; break;
                }
                
            }

            @Override
            public int getCount() {
                return 2;
            }
            
        };
    }

    @Override
    public Component getDefaultName() {
        return new TextComponent("Auto Blowtorch");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new AutoBlowtorchMenu(containerId, inventory, this, this.data, ContainerLevelAccess.create(inventory.player.level, this.getBlockPos()));
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
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("auto_blowtorch.progress", progress);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("auto_blowtorch.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }
    
    public static void tick(Level level, BlockPos pos, BlockState state, AutoBlowTorchBlockEntity blockEntity) {
        if(hasRecipe(blockEntity)) {
            blockEntity.progress++;

            level.addParticle(
                ParticleTypes.SOUL_FIRE_FLAME, 
                pos.getX() + 0.5D,
                pos.getY() + 0.6D,
                pos.getZ() + 0.5D,
                0.0D, 
                0.0D,
                0.0D
            );

            setChanged(level, pos, state);
            if (blockEntity.progress > blockEntity.maxProgress) {
                craftItem(blockEntity);
            }

        } else {
            blockEntity.resetProgress();
            setChanged(level, pos, state);
        }
    }

    private static boolean hasRecipe(AutoBlowTorchBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int slot = 0; slot < entity.itemHandler.getSlots(); slot++) {
            inventory.setItem(slot, entity.itemHandler.getStackInSlot(slot));
        }

        Optional<AutoBlowTorchRecipe> match = level.getRecipeManager().getRecipeFor(AutoBlowTorchRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem()) && hasBlowtochItem(entity);
    }

    private static boolean hasBlowtochItem(AutoBlowTorchBlockEntity entity) {
        ItemStack inTorchSlot = entity.itemHandler.getStackInSlot(1);

        return inTorchSlot.is(ModTags.Items.BLOW_TORCHES);
    }

    private static void craftItem(AutoBlowTorchBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());

        for (int slot = 0; slot < entity.itemHandler.getSlots(); slot++) {
            inventory.setItem(slot, entity.itemHandler.getStackInSlot(slot));
        }

        Optional<AutoBlowTorchRecipe> match = level.getRecipeManager().getRecipeFor(AutoBlowTorchRecipe.Type.INSTANCE, inventory, level);

        if(match.isPresent()) {
            entity.itemHandler.extractItem(0,1, false);
            entity.itemHandler.getStackInSlot(1).hurt(1, new Random(), null);

            entity.itemHandler.setStackInSlot(2, new ItemStack(match.get().getResultItem().getItem(), entity.itemHandler.getStackInSlot(2).getCount() + 1));

            entity.resetProgress();

            BlockPos particlePos = entity.getBlockPos();

            showParticles(level, particlePos, 1, 5);     
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(2).getItem() == output.getItem() || inventory.getItem(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
    }

    private static void showParticles(Level level, BlockPos pos, int particleSpawnCountFlame, int particleSpawnCountSmoke) {

        Random random = level.getRandom();
        
        for (int i = 0; i < particleSpawnCountFlame ; i++){
            
            level.addParticle(
                ParticleTypes.SOUL_FIRE_FLAME, 
                pos.getX() + random.nextDouble(0.4D, 0.6D),
                pos.getY() + 0.2D,
                pos.getZ() + random.nextDouble(0.2D, 0.3D),
                0.0D, 
                0.02D,
                0.0D
            );
        }

        for (int i = 0; i < particleSpawnCountSmoke ; i++){

            level.addParticle(
                ParticleTypes.SMOKE, 
                pos.getX() + random.nextDouble(0.1D, 0.9D),
                pos.getY() + random.nextDouble(0.1D, 0.9D),
                pos.getZ() + random.nextDouble(0.1D, 0.9D),
                0.0D, 
                0.02D, 
                0.0D
            );
        }
    }

    @Override
    public int getContainerSize() {
        return 3;
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
       return slotId >= 0 && slotId < 3 && !items.getStackInSlot(slotId).isEmpty() && count > 0 ? items.getStackInSlot(slotId).split(count) : ItemStack.EMPTY;
    }

    public static ItemStack takeItem(ItemStackHandler items, int slotId) {
        items.setStackInSlot(slotId, ItemStack.EMPTY);
        return slotId >= 0 && slotId < 3 ? items.getStackInSlot(slotId) : ItemStack.EMPTY;
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
        if (slotId == 2) {
           return false;
        } else if (slotId != 1) {
           return true;
        } else {
            return stack.is(ModTags.Items.BLOW_TORCHES);
        }
    }

    @Override
    public boolean canTakeItemThroughFace(int slotId, ItemStack stack, Direction dir) {
        return true;
    }
}
