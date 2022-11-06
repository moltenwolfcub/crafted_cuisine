package com.moltenwolfcub.crafted_cuisine.screen;

import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllMenuTypes;
import com.moltenwolfcub.crafted_cuisine.screen.slot.FuelSlot;
import com.moltenwolfcub.crafted_cuisine.screen.slot.ModResultSlot;
import com.moltenwolfcub.crafted_cuisine.screen.slot.WaterSlot;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.impl.content.registry.FuelRegistryImpl;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;

public class CarameliserMenu extends AbstractContainerMenu {
    private final ContainerData data;
    private final ContainerLevelAccess access;

    public CarameliserMenu(int containerId, Inventory inv) {
        this(
            containerId,
            inv,
            new SimpleContainer(6),
            new SimpleContainerData(6),
            ContainerLevelAccess.NULL
        );
    }

    public CarameliserMenu(int containerId, Inventory inv, Container container, ContainerData data, ContainerLevelAccess access) {
        super(AllMenuTypes.CARAMELISER, containerId);
        checkContainerSize(container, 6);
        container.startOpen(inv.player);


        this.data = data;
        this.access = access;

        this.addSlot(new WaterSlot(container, 0, 8, 53));
        this.addSlot(new Slot(container, 1, 32, 9));
        this.addSlot(new Slot(container, 2, 32, 31));
        this.addSlot(new Slot(container, 3, 32, 53));
        this.addSlot(new FuelSlot(this, container, 4, 80, 61));
        this.addSlot(new ModResultSlot(container, 5, 134, 33));

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        addDataSlots(this.data);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotClickedId) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slotClicked = this.slots.get(slotClickedId);

        if (slotClicked != null && slotClicked.hasItem()) {
            ItemStack slotClickedStack = slotClicked.getItem();
            itemstack = slotClickedStack.copy();
            if (slotClickedId == 5) {
                if (!this.moveItemStackTo(slotClickedStack, 6, 42, true)) {
                    return ItemStack.EMPTY;
                }
  
                slotClicked.onQuickCraft(slotClickedStack, itemstack);
            } else if (slotClickedId > 5) {
                if (this.isWater(slotClickedStack)) {
                    if (!this.moveItemStackTo(slotClickedStack, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.isFuel(slotClickedStack)) {
                    if (!this.moveItemStackTo(slotClickedStack, 4, 5, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (!this.moveItemStackTo(slotClickedStack, 1, 4, false)) {
                    if (slotClickedId >= 6 && slotClickedId < 33) {
                        if (!this.moveItemStackTo(slotClickedStack, 33, 42, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (slotClickedId >= 33 && slotClickedId < 42) {
                        if (!this.moveItemStackTo(slotClickedStack, 6, 33, false)) {
                            return ItemStack.EMPTY;
                        }
                    }
                }
            } else if (!this.moveItemStackTo(slotClickedStack, 6, 42, false)) {
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


    public boolean isCrafting() {
        return this.data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int progressArrowSize = 44;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public int getScaledMilibuckets() {
        int milibuckets = this.data.get(2);
        int maxMilliBuckets = this.data.get(3);
        int waterSize = 40;

        return maxMilliBuckets != 0 && milibuckets != 0 ? milibuckets * waterSize / maxMilliBuckets : 0;
    }

    public int getScaledFuel() {
        int litTime = this.data.get(4);
        int litDuration = this.data.get(5);
        int fuelHeight = 14;

        return litDuration !=0 && litTime != 0 ? litTime * fuelHeight / litDuration : 0;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, AllBlocks.CARAMELISER);
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
   

    public boolean isFuel(ItemStack stack) {
        return ((FuelRegistryImpl) FuelRegistry.INSTANCE).getFuelTimes().containsKey(stack.getItem());
    } 

    public boolean isWater(ItemStack stack) {
        return stack.is(Items.WATER_BUCKET) || PotionUtils.getPotion(stack) == Potions.WATER;
    }
}
