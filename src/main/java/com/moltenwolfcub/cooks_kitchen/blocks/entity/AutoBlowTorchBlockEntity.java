package com.moltenwolfcub.cooks_kitchen.blocks.entity;

import java.util.Optional;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.moltenwolfcub.cooks_kitchen.init.ModBlockEntities;
import com.moltenwolfcub.cooks_kitchen.init.ModTags;
import com.moltenwolfcub.cooks_kitchen.recipe.AutoBlowTorchRecipe;
import com.moltenwolfcub.cooks_kitchen.screen.AutoBlowtorchMenu;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class AutoBlowTorchBlockEntity extends BlockEntity implements MenuProvider {

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
    public Component getDisplayName() {
        return new TextComponent("Auto Blowtorch");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new AutoBlowtorchMenu(containerId, inventory, this, this.data);
    }
    
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
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
        Item inTorchSlot = entity.itemHandler.getStackInSlot(1).getItem();

        return Registry.ITEM.getHolderOrThrow(Registry.ITEM.getResourceKey(inTorchSlot).get()).is(ModTags.Items.BLOW_TORCHES);
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
}
