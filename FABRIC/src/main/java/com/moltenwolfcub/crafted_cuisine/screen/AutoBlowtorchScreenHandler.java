package com.moltenwolfcub.crafted_cuisine.screen;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;
import com.moltenwolfcub.crafted_cuisine.init.AllScreenHandlerTypes;
import com.moltenwolfcub.crafted_cuisine.init.AllTags;
import com.moltenwolfcub.crafted_cuisine.screen.slot.BlowtorchSlot;
import com.moltenwolfcub.crafted_cuisine.screen.slot.ModResultSlot;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;

public class AutoBlowtorchScreenHandler extends ScreenHandler {
    private final World level;
    private final PropertyDelegate data;
    private final ScreenHandlerContext access;

    public AutoBlowtorchScreenHandler(int containerId, PlayerInventory inv) {
        this(
            containerId,
            inv,
            new SimpleInventory(3),
            new ArrayPropertyDelegate(2),
            ScreenHandlerContext.EMPTY
        );
    }

    public AutoBlowtorchScreenHandler(int containerId, PlayerInventory inv, Inventory container, PropertyDelegate data, ScreenHandlerContext access) {
        super(AllScreenHandlerTypes.AUTO_BLOWTORCH, containerId);
        CraftedCuisine.LOGGER.debug(this.getType().toString());
        checkSize(inv, 3);
        container.onOpen(inv.player);

        this.level = inv.player.world;
        this.data = data;
        this.access = access;

        this.addSlot(new Slot(container, 0, 44, 30));
        this.addSlot(new BlowtorchSlot(container, 1, 77, 53));
        this.addSlot(new ModResultSlot(container, 2, 116, 30));

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        addProperties(data);
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
    public ItemStack transferSlot(PlayerEntity player, int slotClickedId) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slotClicked = this.slots.get(slotClickedId);

        if (slotClicked != null && slotClicked.hasStack()) {
            ItemStack slotClickedStack = slotClicked.getStack();
            itemstack = slotClickedStack.copy();
            if (slotClickedId == 2) {
                if (!this.insertItem(slotClickedStack, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }
  
                slotClicked.onQuickTransfer(slotClickedStack, itemstack);
            } else if (slotClickedId != 1 && slotClickedId != 0) {
                if (this.canBeBlowtorched(slotClickedStack)) {
                    if (!this.insertItem(slotClickedStack, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.isBlowtorch(slotClickedStack)) {
                    if (!this.insertItem(slotClickedStack, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (slotClickedId >= 3 && slotClickedId < 30) {
                    if (!this.insertItem(slotClickedStack, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (slotClickedId >= 30 && slotClickedId < 39 && !this.insertItem(slotClickedStack, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(slotClickedStack, 3, 39, false)) {
                return ItemStack.EMPTY;
            }
  
            if (slotClickedStack.isEmpty()) {
                slotClicked.setStack(ItemStack.EMPTY);
            } else {
                slotClicked.markDirty();
            }
    
            if (slotClickedStack.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }
  
            slotClicked.onTakeItem(player, slotClickedStack);
        }
  
        return itemstack;
    }


    private boolean canBeBlowtorched(ItemStack stack) {
        // return this.level.getRecipeManager().getRecipeFor(AutoBlowTorchRecipe.Type.INSTANCE, new SimpleContainer(stack), this.level).isPresent();
        return stack.getItem() == AllItems.RAW_MERINGUE;
    }

    public boolean isBlowtorch(ItemStack stack) {
        return stack.isIn(AllTags.Items.BLOW_TORCHES);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(this.access, player, AllBlocks.AUTO_BLOWTORCH);
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
