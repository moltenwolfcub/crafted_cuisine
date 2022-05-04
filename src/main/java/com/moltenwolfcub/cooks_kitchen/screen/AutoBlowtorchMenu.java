package com.moltenwolfcub.cooks_kitchen.screen;

import com.moltenwolfcub.cooks_kitchen.blocks.entity.AutoBlowTorchBlockEntity;
import com.moltenwolfcub.cooks_kitchen.init.ModBlocks;
import com.moltenwolfcub.cooks_kitchen.init.ModMenuTypes;
import com.moltenwolfcub.cooks_kitchen.init.ModTags;
import com.moltenwolfcub.cooks_kitchen.recipe.AutoBlowTorchRecipe;
import com.moltenwolfcub.cooks_kitchen.screen.slot.BlowtorchSlot;
import com.moltenwolfcub.cooks_kitchen.screen.slot.ModResultSlot;

import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class AutoBlowtorchMenu extends AbstractContainerMenu {
    private final AutoBlowTorchBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public AutoBlowtorchMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(2));
    }

    public AutoBlowtorchMenu(int containerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.AUTO_BLOWTORCH_MENU.get(), containerId);
        checkContainerSize(inv, 3);
        blockEntity = ((AutoBlowTorchBlockEntity) entity);
        this.level = inv.player.level;
        this.data = data;

        this.blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, 0, 44, 30));
            this.addSlot(new BlowtorchSlot(handler, 1, 77, 53));
            this.addSlot(new ModResultSlot(handler, 2, 116, 30));
        });

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        addDataSlots(data);
    }

    public boolean iscrafting() {
        return this.data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int progressArrowSize = 38;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }


    @Override
    public ItemStack quickMoveStack(Player player, int slotClickedId) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slotClicked = this.slots.get(slotClickedId);

        if (slotClicked != null && slotClicked.hasItem()) {
            ItemStack slotClickedStack = slotClicked.getItem();
            itemstack = slotClickedStack.copy();
            if (slotClickedId == 2) {
                if (!this.moveItemStackTo(slotClickedStack, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }
  
                slotClicked.onQuickCraft(slotClickedStack, itemstack);
            } else if (slotClickedId != 1 && slotClickedId != 0) {
                if (this.canBeBlowtorched(slotClickedStack)) {
                    if (!this.moveItemStackTo(slotClickedStack, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.isBlowtorch(slotClickedStack)) {
                    if (!this.moveItemStackTo(slotClickedStack, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (slotClickedId >= 3 && slotClickedId < 30) {
                    if (!this.moveItemStackTo(slotClickedStack, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (slotClickedId >= 30 && slotClickedId < 39 && !this.moveItemStackTo(slotClickedStack, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(slotClickedStack, 3, 39, false)) {
                return ItemStack.EMPTY;
            }
  
            if (slotClickedStack.isEmpty()) {
                slotClicked.set(ItemStack.EMPTY);
            } else {
                slotClicked.setChanged();
            }
    
            if (slotClickedStack.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }
  
            slotClicked.onTake(player, slotClickedStack);
        }
  
        return itemstack;
     }


    private boolean canBeBlowtorched(ItemStack stack) {
        return this.level.getRecipeManager().getRecipeFor(AutoBlowTorchRecipe.Type.INSTANCE, new SimpleContainer(stack), this.level).isPresent();
    }
    
    public boolean isBlowtorch(ItemStack stack) {
        return Registry.ITEM.getHolderOrThrow(Registry.ITEM.getResourceKey(stack.getItem()).get()).is(ModTags.Items.BLOW_TORCHES);
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, ModBlocks.AUTO_BLOWTORCH.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for(int rowNum = 0; rowNum < 3; ++rowNum) {
            for(int columnNum = 0; columnNum < 9; ++columnNum) {
               this.addSlot(new Slot(playerInventory, columnNum + rowNum * 9 + 9, 8 + columnNum * 18, 84 + rowNum * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
         for(int slotNum = 0; slotNum < 9; ++slotNum) {
            this.addSlot(new Slot(playerInventory, slotNum, 8 + slotNum * 18, 142));
        }
    }
    
}
