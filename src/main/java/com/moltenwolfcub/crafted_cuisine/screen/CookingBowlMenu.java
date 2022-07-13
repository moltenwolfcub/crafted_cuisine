package com.moltenwolfcub.crafted_cuisine.screen;

import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllMenuTypes;
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
import net.minecraft.world.item.ItemStack;

public class CookingBowlMenu extends ModAbstractContainerMenu {

    public CookingBowlMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(
            containerId,
            inv,
            new SimpleContainer(18),
            new SimpleContainerData(0),
            ContainerLevelAccess.NULL
        );
    }

    public CookingBowlMenu(int containerId, Inventory inv, Container container, ContainerData data, ContainerLevelAccess access) {
        super(AllMenuTypes.COOKING_BOWL.get(), containerId, AllBlocks.COOKING_BOWL.get(), data, access);
        checkContainerSize(inv, 18);

        for(int y = 0; y < 3; ++y) {
            for(int x = 0; x < 3; ++x) {
               this.addSlot(new IngredientSlot(container, x + y * 3, 17 + x * 18, 17 + y * 18));
               this.addSlot(new ResultSlot(container, 9 + x + y * 3, 107 + x * 18, 17 + y * 18));
            }
        }


        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        addDataSlots(data);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotClickedId) {
        ItemStack itemstack = ItemStack.EMPTY;
        
        return itemstack;
    }
    
}
