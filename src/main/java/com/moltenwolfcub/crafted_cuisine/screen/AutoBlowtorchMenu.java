package com.moltenwolfcub.crafted_cuisine.screen;

import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllMenuTypes;
import com.moltenwolfcub.crafted_cuisine.init.AllTags;
import com.moltenwolfcub.crafted_cuisine.recipe.AutoBlowTorchRecipe;
import com.moltenwolfcub.crafted_cuisine.screen.slot.BlowtorchSlot;
import com.moltenwolfcub.crafted_cuisine.screen.slot.IngredientSlot;
import com.moltenwolfcub.crafted_cuisine.screen.slot.ResultSlot;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AutoBlowtorchMenu extends ModAbstractContainerMenu {
    private final Level level;

    public AutoBlowtorchMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(
            containerId,
            inv,
            new SimpleContainer(3),
            new SimpleContainerData(2),
            ContainerLevelAccess.NULL
        );
    }

    public AutoBlowtorchMenu(int containerId, Inventory inv, Container container, ContainerData data, ContainerLevelAccess access) {
        super(AllMenuTypes.AUTO_BLOWTORCH.get(), containerId, AllBlocks.AUTO_BLOWTORCH.get(), data, access);
        checkContainerSize(inv, 3);
        this.level = inv.player.level;

        this.addSlot(new IngredientSlot(container, 0, 44, 30));
        this.addSlot(new BlowtorchSlot(container, 1, 77, 53));
        this.addSlot(new ResultSlot(container, 2, 116, 30));

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        addDataSlots(data);
    }

    public boolean iscrafting() {
        return isCrafting(0);
    }

    public int getScaledProgress() {
        return getScaledData(0, 1, 38);
    }


    private boolean canBeBlowtorched(ItemStack stack) {
        return this.level.getRecipeManager().getRecipeFor(AutoBlowTorchRecipe.Type.INSTANCE, new SimpleContainer(stack), this.level).isPresent();
    }
    
    public boolean isBlowtorch(ItemStack stack) {
        return stack.is(AllTags.Items.BLOW_TORCHES);
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
}
