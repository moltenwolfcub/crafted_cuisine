package com.moltenwolfcub.crafted_cuisine.blocks.entity;

import java.util.Optional;
import java.util.Random;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.blocks.entity.util.ImplementedInventory;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockEntities;
import com.moltenwolfcub.crafted_cuisine.init.AllTags;
import com.moltenwolfcub.crafted_cuisine.recipe.AutoBlowTorchRecipe;
import com.moltenwolfcub.crafted_cuisine.screen.AutoBlowtorchScreenHandler;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AutoBlowTorchBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    protected final PropertyDelegate data;
    private int progress = 0;
    private int maxProgress = 20;

    public AutoBlowTorchBlockEntity(BlockPos pos, BlockState state) {
        super(AllBlockEntities.AUTO_BLOWTORCH, pos, state);

        this.data = new PropertyDelegate() {

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
            public int size() {
                return 2;
            }
            
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText("container." + CraftedCuisine.MODID + ".auto_blowtorch");
    }

    @Override
    public ScreenHandler createMenu(int containerId, PlayerInventory inv, PlayerEntity player) {
        return new AutoBlowtorchScreenHandler(containerId, inv, this, this.data, ScreenHandlerContext.create(inv.player.world, this.getPos()));
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("auto_blowtorch.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("auto_blowtorch.progress");
    }

    private void resetProgress() {
        this.progress = 0;
    }
    
    public static void tick(World level, BlockPos pos, BlockState state, AutoBlowTorchBlockEntity blockEntity) {
        if(level.isClient()) {
            return;
        }
        
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

            markDirty(level, pos, state);
            if (blockEntity.progress > blockEntity.maxProgress) {
                craftItem(blockEntity);
            }

        } else {
            blockEntity.resetProgress();
            markDirty(level, pos, state);
        }
    }

    private static void craftItem(AutoBlowTorchBlockEntity entity) {
        World level = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());

        for (int slot = 0; slot < entity.inventory.size(); slot++) {
            inventory.setStack(slot, entity.inventory.get(slot));
        }

        Optional<AutoBlowTorchRecipe> match = level.getRecipeManager().getFirstMatch(AutoBlowTorchRecipe.Type.INSTANCE, inventory, level);

        if(hasRecipe(entity)) {
            entity.removeStack(0,1);
            if (entity.getStack(1).isDamageable()) {
                entity.getStack(1).damage(1, new Random(), null);
            }

            entity.setStack(2, new ItemStack(match.get().getOutput().getItem(), entity.getStack(2).getCount() + 1));

            entity.resetProgress();

            BlockPos particlePos = entity.getPos();

            showParticles(level, particlePos, 1, 5);     
        }
    }

    private static boolean hasRecipe(AutoBlowTorchBlockEntity entity) {
        World level = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int slot = 0; slot < entity.size(); slot++) {
            inventory.setStack(slot, entity.getStack(slot));
        }

        Optional<AutoBlowTorchRecipe> match = level.getRecipeManager().getFirstMatch(AutoBlowTorchRecipe.Type.INSTANCE, inventory, level);

        Boolean hasRecipeItems = match.isPresent();

        return hasRecipeItems && hasBlowtochItem(entity) && canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static boolean hasBlowtochItem(AutoBlowTorchBlockEntity entity) {
        ItemStack inTorchSlot = entity.inventory.get(1);

        return inTorchSlot.isIn(AllTags.Items.BLOW_TORCHES);
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output) {
        return inventory.getStack(2).getItem() == output.getItem() || inventory.getStack(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(2).getMaxCount() > inventory.getStack(2).getCount();
    }
   
    private static void showParticles(World level, BlockPos pos, int particleSpawnCountFlame, int particleSpawnCountSmoke) {

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
