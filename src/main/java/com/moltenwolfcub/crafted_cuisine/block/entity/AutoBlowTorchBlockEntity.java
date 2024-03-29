package com.moltenwolfcub.crafted_cuisine.block.entity;

import java.util.Optional;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.block.entity.util.ImplementedInventory;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockEntities;
import com.moltenwolfcub.crafted_cuisine.init.AllTags;
import com.moltenwolfcub.crafted_cuisine.recipe.AutoBlowTorchRecipe;
import com.moltenwolfcub.crafted_cuisine.screen.AutoBlowtorchMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class AutoBlowTorchBlockEntity extends BaseContainerBlockEntity implements ImplementedInventory {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(3, ItemStack.EMPTY);

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 20;

    public AutoBlowTorchBlockEntity(BlockPos pos, BlockState state) {
        super(AllBlockEntities.AUTO_BLOWTORCH, pos, state);

        this.data = new ContainerData() {

            public int get(int index) {
                return switch (index) {
                    case 0 -> AutoBlowTorchBlockEntity.this.progress;
                    case 1 -> AutoBlowTorchBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> AutoBlowTorchBlockEntity.this.progress = value;
                    case 1 -> AutoBlowTorchBlockEntity.this.maxProgress = value;
                }
                
            }

            @Override
            public int getCount() {
                return 2;
            }
            
        };
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public @NotNull Component getDefaultName() {
        return Component.translatable("container." + CraftedCuisine.MODID + ".auto_blowtorch");
    }

    @Override
    public @NotNull AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new AutoBlowtorchMenu(containerId, inventory, this, this.data, ContainerLevelAccess.create(inventory.player.level, this.getBlockPos()));
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        ContainerHelper.saveAllItems(nbt, inventory);
        nbt.putInt("auto_blowtorch.progress", progress);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        ContainerHelper.loadAllItems(nbt, inventory);
        progress = nbt.getInt("auto_blowtorch.progress");
    }

    private void resetProgress() {
        this.progress = 0;
    }
    
    public static void tick(Level level, BlockPos pos, BlockState state, AutoBlowTorchBlockEntity blockEntity) {
        if(level.isClientSide()) {
            return;
        }
        
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

    private static void craftItem(AutoBlowTorchBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.inventory.size());

        for (int slot = 0; slot < entity.inventory.size(); slot++) {
            inventory.setItem(slot, entity.inventory.get(slot));
        }

        if (level == null) {
            throw new NullPointerException("level can't be null");
        }
        Optional<AutoBlowTorchRecipe> match = level.getRecipeManager().getRecipeFor(AutoBlowTorchRecipe.Type.INSTANCE, inventory, level);

        if(hasRecipe(entity)) {
            ItemStack inputSlot = entity.getItem(0);
            ItemStack remainder = inputSlot.getRecipeRemainder();
            inputSlot.shrink(1);
            if (inputSlot.isEmpty()) {
                entity.setItem(0, remainder == null ? ItemStack.EMPTY : remainder);
            }

            if (entity.getItem(1).isDamageableItem()) {
                entity.getItem(1).hurt(1, RandomSource.create(), null);
            }

            entity.setItem(2, new ItemStack(match.get().getResultItem(level.registryAccess()).getItem(), entity.getItem(2).getCount() + 1));

            entity.resetProgress();   
        }
    }

    private static boolean hasRecipe(AutoBlowTorchBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.inventory.size());
        for (int slot = 0; slot < entity.inventory.size(); slot++) {
            inventory.setItem(slot, entity.getItem(slot));
        }

        if (level == null) {
            throw new NullPointerException("level can't be null");
        }
        Optional<AutoBlowTorchRecipe> match = level.getRecipeManager().getRecipeFor(AutoBlowTorchRecipe.Type.INSTANCE, inventory, level);

        boolean hasRecipeItems = match.isPresent();

        return hasRecipeItems && hasBlowtochItem(entity) && canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem(level.registryAccess()));
    }

    private static boolean hasBlowtochItem(AutoBlowTorchBlockEntity entity) {
        ItemStack inTorchSlot = entity.inventory.get(1);

        return inTorchSlot.is(AllTags.Items.BLOW_TORCHES);
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(2).getItem() == output.getItem() || inventory.getItem(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
    }
}
