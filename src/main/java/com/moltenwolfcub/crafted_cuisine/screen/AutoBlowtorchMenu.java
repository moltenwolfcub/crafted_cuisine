package com.moltenwolfcub.crafted_cuisine.screen;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllMenuTypes;
import com.moltenwolfcub.crafted_cuisine.init.AllTags;
import com.moltenwolfcub.crafted_cuisine.recipe.AutoBlowTorchRecipe;
import com.moltenwolfcub.crafted_cuisine.screen.slot.BlowtorchSlot;
import com.moltenwolfcub.crafted_cuisine.screen.slot.ModResultSlot;

import net.minecraft.world.Container;
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
import org.jetbrains.annotations.NotNull;

public class AutoBlowtorchMenu extends AbstractContainerMenu {
    private final Level level;
    private final ContainerData data;
    private final ContainerLevelAccess access;

    public AutoBlowtorchMenu(int containerId, Inventory inv) {
        this(
            containerId,
            inv,
            new SimpleContainer(3),
            new SimpleContainerData(2),
            ContainerLevelAccess.NULL
        );
    }

    public AutoBlowtorchMenu(int containerId, Inventory inv, Container container, ContainerData data, ContainerLevelAccess access) {
        super(AllMenuTypes.AUTO_BLOWTORCH, containerId);
        CraftedCuisine.LOGGER.debug(this.getType().toString());
        checkContainerSize(container, 3);
        container.startOpen(inv.player);

        this.level = inv.player.level;
        this.data = data;
        this.access = access;

        this.addSlot(new Slot(container, 0, 44, 30));
        this.addSlot(new BlowtorchSlot(container, 1, 77, 53));
        this.addSlot(new ModResultSlot(container, 2, 116, 30));

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        addDataSlots(data);
    }

    public boolean isCrafting() {
        return this.data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int progressArrowSize = 38;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }


    @Override
    public @NotNull ItemStack quickMoveStack(Player player, int slotClickedId) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slotClicked = this.slots.get(slotClickedId);

        if (slotClicked.hasItem()) {
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
                } else if (AutoBlowtorchMenu.isBlowtorch(slotClickedStack)) {
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

    public static boolean isBlowtorch(ItemStack stack) {
        return stack.is(AllTags.Items.BLOW_TORCHES);
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, AllBlocks.AUTO_BLOWTORCH);
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
