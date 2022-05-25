package com.moltenwolfcub.cooks_kitchen.screen;

import com.moltenwolfcub.cooks_kitchen.init.ModBlocks;
import com.moltenwolfcub.cooks_kitchen.init.ModMenuTypes;
import com.moltenwolfcub.cooks_kitchen.screen.slot.FuelSlot;
import com.moltenwolfcub.cooks_kitchen.screen.slot.IngredientSlot;
import com.moltenwolfcub.cooks_kitchen.screen.slot.ModResultSlot;
import com.moltenwolfcub.cooks_kitchen.screen.slot.WaterSlot;

import net.minecraft.network.FriendlyByteBuf;
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
import net.minecraft.world.level.Level;

public class CarameliserMenu extends AbstractContainerMenu {
    private final Level level;
    private final ContainerData data;
    private final ContainerLevelAccess access;

    public CarameliserMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(
            containerId,
            inv,
            new SimpleContainer(6),
            new SimpleContainerData(0),
            ContainerLevelAccess.NULL
        );
    }

    public CarameliserMenu(int containerId, Inventory inv, Container container, ContainerData data, ContainerLevelAccess access) {
        super(ModMenuTypes.CARAMELISER_MENU.get(), containerId);
        checkContainerSize(inv, 6);
        this.level = inv.player.level;
        this.data = data;
        this.access = access;

        this.addSlot(new WaterSlot(container, 0, 8, 53));
        this.addSlot(new IngredientSlot(container, 1, 32, 9));
        this.addSlot(new IngredientSlot(container, 2, 32, 31));
        this.addSlot(new IngredientSlot(container, 3, 32, 53));
        this.addSlot(new FuelSlot(this, container, 4, 80, 61));
        this.addSlot(new ModResultSlot(container, 5, 134, 33));

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        addDataSlots(data);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotClickedId) {
        return super.quickMoveStack(player, slotClickedId);
    }


    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, ModBlocks.CARAMELISER.get());
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
        return stack.is(Items.COAL);//net.minecraftforge.common.ForgeHooks.getBurnTime(stack, this.recipeType) > 0;
    } 
}
