package com.moltenwolfcub.crafted_cuisine.screen;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.block.Block;

public abstract class ModAbstractContainerMenu extends AbstractContainerMenu {
    protected final ContainerData data;
    protected final ContainerLevelAccess access;
    protected final Block entityHolder;

    protected ModAbstractContainerMenu(MenuType<?> type, int containerId, Block entityHolder, ContainerData data, ContainerLevelAccess access) {
        super(type, containerId);
        this.data = data;
        this.access = access;
        this.entityHolder = entityHolder;
    }
    

    protected void addPlayerInventory(Inventory playerInventory) {
        for(int rowNum = 0; rowNum < 3; ++rowNum) {
            for(int columnNum = 0; columnNum < 9; ++columnNum) {
               this.addSlot(new Slot(playerInventory, columnNum + rowNum * 9 + 9, 8 + columnNum * 18, 84 + rowNum * 18));
            }
        }
    }

    protected void addPlayerHotbar(Inventory playerInventory) {
        for(int slotNum = 0; slotNum < 9; ++slotNum) {
            this.addSlot(new Slot(playerInventory, slotNum, 8 + slotNum * 18, 142));
        }
    }


    public int getScaledData(int dataSlot, int maxDataSlot, int scale) {
        int val = this.data.get(dataSlot);
        int maxVal = this.data.get(maxDataSlot);

        return maxVal != 0 && val != 0 ? val * scale / maxVal : 0;
    }

    public boolean isCrafting(int progressSlot) {
        return this.data.get(progressSlot) > 0;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(access, player, entityHolder);
    }
    
}
