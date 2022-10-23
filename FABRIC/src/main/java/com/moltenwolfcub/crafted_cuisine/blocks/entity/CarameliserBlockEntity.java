package com.moltenwolfcub.crafted_cuisine.blocks.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class CarameliserBlockEntity {//extends BaseContainerBlockEntity implements WorldlyContainer {
    // public static final int SLOT_WATER = 0;
    // public static final int SLOT_INPUT_FIRST = 1;
    // public static final int SLOT_INPUT_SECOND = 2;
    // public static final int SLOT_INPUT_THIRD = 3;
    // public static final int SLOT_FUEL = 4;
    // public static final int SLOT_OUTPUT = 5;
    
    // private static final int[] SLOTS_FOR_UP = new int[]{SLOT_INPUT_FIRST, SLOT_INPUT_SECOND, SLOT_INPUT_THIRD};
    // private static final int[] SLOTS_FOR_DOWN = new int[]{SLOT_OUTPUT};
    // private static final int[] SLOTS_FOR_SIDES = new int[]{SLOT_WATER, SLOT_FUEL};
    // LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

    // public final int slotCount = 6;
    // private final RecipeType<CarameliserRecipe> recipeType = ModEventBusEvents.CARAMELISER_RECIPE;

    // private final ItemStackHandler itemHandler = new ItemStackHandler(slotCount) {
    //     @Override
    //     protected void onContentsChanged(int slot) {
    //         setChanged();
    //     }
    // };
    // private LazyOptional<ItemStackHandler> lazyItemHandler = LazyOptional.empty();

    // protected final ContainerData data;
    // private int progress = 0;
    // private int maxProgress = 100;
    // private int waterMiliBuckets = 0;
    // private int maxWaterMiliBuckets = 1000;
    // private int litDuration = 0;
    // private int litTime = 0;

    // private boolean shouldChange = false;


    public CarameliserBlockEntity(BlockPos pos, BlockState state) {
        // super(AllBlockEntities.CARAMELISER.get(), pos, state);

        // this.data = new ContainerData() {
        //     public int get(int index) {
        //         switch (index) {
        //             case 0: return CarameliserBlockEntity.this.progress;
        //             case 1: return CarameliserBlockEntity.this.maxProgress;
        //             case 2: return CarameliserBlockEntity.this.waterMiliBuckets;
        //             case 3: return CarameliserBlockEntity.this.maxWaterMiliBuckets;
        //             case 4: return CarameliserBlockEntity.this.litTime;
        //             case 5: return CarameliserBlockEntity.this.litDuration;
        //             default: return 0;
        //         }
        //     }

        //     @Override
        //     public void set(int index, int value) {
        //         switch(index) {
        //             case 0: CarameliserBlockEntity.this.progress = value; break;
        //             case 1: CarameliserBlockEntity.this.maxProgress = value; break;
        //             case 2: CarameliserBlockEntity.this.waterMiliBuckets = value; break;
        //             case 3: CarameliserBlockEntity.this.maxWaterMiliBuckets = value; break;
        //             case 4: CarameliserBlockEntity.this.litTime = value; break;
        //             case 5: CarameliserBlockEntity.this.litDuration = value; break;
        //         }
                
        //     }

        //     @Override
        //     public int getCount() {
        //         return 6;
        //     }
            
        // };
    }


    // @Override
    // public Component getDefaultName() {
    //     return new TranslatableComponent("container." + CraftedCuisine.MODID + ".carameliser");
    // }

    // @Override
    // public AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
    //     return new CarameliserMenu(containerId, inventory, this, this.data, ContainerLevelAccess.create(inventory.player.level, this.getBlockPos()));
    // }

    // @Nonnull
    // @Override
    // public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
    //     if (!this.remove && side != null && cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
    //         if (side == Direction.UP)
    //             return handlers[0].cast();
    //         else if (side == Direction.DOWN)
    //             return handlers[1].cast();
    //         else
    //             return handlers[2].cast();
    //     } 
    //     return super.getCapability(cap, side);
    // }

    // @Override
    // public void onLoad() {
    //     super.onLoad();
    //     lazyItemHandler = LazyOptional.of(() -> itemHandler);
    // }

    // @Override
    // public void invalidateCaps()  {
    //     super.invalidateCaps();
    //     lazyItemHandler.invalidate();
    // }

    // @Override
    // protected void saveAdditional(@NotNull CompoundTag tag) {
    //     tag.put("inventory", itemHandler.serializeNBT());
    //     tag.putInt("carameliser.progress", progress);
    //     tag.putInt("carameliser.water_milibuckets", waterMiliBuckets);
    //     tag.putInt("carameliser.lit_time", litTime);
    //     super.saveAdditional(tag);
    // }

    // @Override
    // public void load(CompoundTag nbt) {
    //     super.load(nbt);
    //     itemHandler.deserializeNBT(nbt.getCompound("inventory"));
    //     progress = nbt.getInt("carameliser.progress");
    //     waterMiliBuckets = nbt.getInt("carameliser.water_milibuckets");
    //     litTime = nbt.getInt("carameliser.lit_time");
    //     litDuration = getBurnDuration(itemHandler.getStackInSlot(SLOT_FUEL));
    // }

    // public void drops() {
    //     SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
    //     for (int i = 0; i < itemHandler.getSlots(); i++) {
    //         inventory.setItem(i, itemHandler.getStackInSlot(i));
    //     }

    //     Containers.dropContents(this.level, this.worldPosition, inventory);
    // }

    // @Override
    // public int getContainerSize() {
    //     return slotCount;
    // }

    // @Override
    // public boolean isEmpty() {
    //     for(int i = 0; i < this.getContainerSize(); i++) {
    //         ItemStack itemstack = this.itemHandler.getStackInSlot(i);
    //         if (!itemstack.isEmpty()) {
    //             return false;
    //         }
    //     }
  
    //     return true;
    // }

    // @Override
    // public ItemStack getItem(int slotId) {
    //     return this.itemHandler.getStackInSlot(slotId);
    // }

    // @Override
    // public ItemStack removeItem(int slotId, int count) {
    //     ItemStack itemstack = removeItem(this.itemHandler, slotId, count);
    //     if (!itemstack.isEmpty()) {
    //         this.setChanged();
    //     }
    //     return itemstack;
    // }

    // @Override
    // public ItemStack removeItemNoUpdate(int slotId) {
    //     return takeItem(this.itemHandler, slotId);
    // }

    // public static ItemStack removeItem(ItemStackHandler items, int slotId, int count) {
    //     return slotId >= 0 && slotId < 6 && !items.getStackInSlot(slotId).isEmpty() && count > 0 ? items.getStackInSlot(slotId).split(count) : ItemStack.EMPTY;
    // }
 
    // public static ItemStack takeItem(ItemStackHandler items, int slotId) {
    //     items.setStackInSlot(slotId, ItemStack.EMPTY);
    //     return slotId >= 0 && slotId < 6 ? items.getStackInSlot(slotId) : ItemStack.EMPTY;
    // }
 
    // @Override
    // public void setItem(int slotId, ItemStack stack) {
    //     this.itemHandler.setStackInSlot(slotId, stack);
        
    //     if (stack.getCount() > this.getMaxStackSize()) {
    //        stack.setCount(this.getMaxStackSize());
    //     }
  
    // }

    // @Override
    // public boolean stillValid(Player player) {
    //     if (this.level.getBlockEntity(this.worldPosition) != this) {
    //        return false;
    //     } else {
    //         return player.distanceToSqr(
    //             (double)this.worldPosition.getX() + 0.5D, 
    //             (double)this.worldPosition.getY() + 0.5D, 
    //             (double)this.worldPosition.getZ() + 0.5D
    //         ) <= 64.0D;
    //     }
    // }

    // @Override
    // public void clearContent() {
    //     for(int slot = 0; slot < getContainerSize(); slot++) {
    //         this.itemHandler.setStackInSlot(slot, ItemStack.EMPTY);
    //     }
    // }

    // @Override
    // public int[] getSlotsForFace(Direction dir) {
    //     if (dir == Direction.DOWN) {
    //        return SLOTS_FOR_DOWN;
    //     } else {
    //        return dir == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
    //     }
    // }

    // @Override
    // public boolean canPlaceItemThroughFace(int slotId, ItemStack stack, Direction dir) {
    //     if (slotId == SLOT_OUTPUT) { //output
    //         return false;
    //     } else if (slotId != SLOT_WATER && slotId != SLOT_FUEL) { //input
    //         return true;
    //     } else if (slotId == SLOT_WATER) { //water
    //         return stack.is(Items.WATER_BUCKET) || PotionUtils.getPotion(stack) == Potions.WATER;
    //     } else {
    //         return ForgeHooks.getBurnTime(stack, this.recipeType) > 0;
    //     }
    // }

    // @Override
    // public boolean canTakeItemThroughFace(int slotId, ItemStack stack, Direction dir) {
    //     return true;
    // }
   

    // public static void tick(Level level, BlockPos pos, BlockState state, CarameliserBlockEntity blockEntity) {
    //     boolean lit = blockEntity.isLit();
    //     checkWater(blockEntity);
    //     if (blockEntity.isLit()) {
    //         --blockEntity.litTime;
    //     }

    //     if(hasRecipe(blockEntity)) {
    //         blockEntity.progress++;
    //         blockEntity.shouldChange = true;
    //         if (blockEntity.progress > blockEntity.maxProgress) {
    //             craftItem(blockEntity);
    //         }
    //     } else {
    //         blockEntity.reduceProgress(blockEntity);
    //         blockEntity.shouldChange = true;
    //     }

    //     if (lit != blockEntity.isLit()) {
    //         blockEntity.shouldChange = true;
    //         state = state.setValue(CarameliserBlock.FULL, Boolean.valueOf(blockEntity.isLit()));
    //         level.setBlock(pos, state, 3);
    //     }

    //     if (blockEntity.shouldChange) {
    //         setChanged(level, pos, state);
    //     }
    // }

    // private static void craftItem(CarameliserBlockEntity entity) {

    //     Optional<CarameliserRecipe> match = getRecipies(entity);

    //     if (match.isPresent()) {
    //         reduceWater(entity);
    //         entity.itemHandler.extractItem(SLOT_INPUT_FIRST,1, false);
    //         entity.itemHandler.extractItem(SLOT_INPUT_SECOND,1, false);
    //         entity.itemHandler.extractItem(SLOT_INPUT_THIRD,1, false);
    
    //         entity.itemHandler.setStackInSlot(SLOT_OUTPUT, new ItemStack(
    //             match.get().getResultItem().getItem(), entity.itemHandler.getStackInSlot(SLOT_OUTPUT).getCount() + 1
    //         ));
    
    //         entity.progress = 0;
    //     }
    // }

    // private static boolean hasRecipe(CarameliserBlockEntity entity) {

    //     ItemStack fuelStack = entity.itemHandler.getStackInSlot(SLOT_FUEL);

    //     if (!entity.itemHandler.getStackInSlot(SLOT_INPUT_FIRST).isEmpty() && 
    //         !entity.itemHandler.getStackInSlot(SLOT_INPUT_SECOND).isEmpty() && 
    //         !entity.itemHandler.getStackInSlot(SLOT_INPUT_THIRD).isEmpty()) {
    //         if (entity.isLit()) {
    //             return hasRecipePredicates(entity);
    //         } else if (entity.getBurnDuration(fuelStack) > 0 && hasRecipePredicates(entity)) {
    //             entity.litTime = entity.getBurnDuration(fuelStack);
    //             entity.litDuration = entity.litTime;

    //             ItemStack newStack = new ItemStack(fuelStack.getItem(), fuelStack.getCount() -1);
    //             entity.itemHandler.setStackInSlot(SLOT_FUEL, newStack);

    //             return hasRecipePredicates(entity);
    //         } else {
    //             return false;
    //         }
    //     } else {
    //         return false;
    //     }
    // }

    // private static boolean hasRecipePredicates(CarameliserBlockEntity entity) {
    //     Optional<CarameliserRecipe> match = getRecipies(entity);

    //     return match.isPresent() && outputNotFull(entity) && ItemFitsInOutput(entity, match.get().getResultItem()) && hasWater(entity);
    // }

    // private static Optional<CarameliserRecipe> getRecipies(CarameliserBlockEntity entity) {
    //     Level level = entity.level;

    //     SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
    //     for (int slot = 0; slot < entity.itemHandler.getSlots(); slot++) {
    //         inventory.setItem(slot, entity.itemHandler.getStackInSlot(slot));
    //     }
    //     return level.getRecipeManager().getRecipeFor(CarameliserRecipe.Type.INSTANCE, inventory, level);
        
    // }


    // private static boolean hasWater(CarameliserBlockEntity entity) {
    //     return entity.waterMiliBuckets > 249;
    // }
   
    // private static void reduceWater(CarameliserBlockEntity entity) {
    //     if (entity.waterMiliBuckets >= 250) {
    //         entity.waterMiliBuckets -= 250;
    //     }
    // }

    // private static void checkWater(CarameliserBlockEntity entity) {
    //     ItemStack waterStack = entity.itemHandler.getStackInSlot(SLOT_WATER);

    //     int bucketWaterIncrease = 1000;
    //     int bottleWaterIncrease = 250;

    //     if (waterStack.getItem() == Items.WATER_BUCKET) {
    //         addWater(entity, bucketWaterIncrease);
    //     } else if (PotionUtils.getPotion(waterStack) == Potions.WATER) {
    //         addWater(entity, bottleWaterIncrease);
    //     }
    // }

    // private static void addWater(CarameliserBlockEntity entity, int amount) {
    //     ItemStack waterStack = entity.itemHandler.getStackInSlot(SLOT_WATER);

    //     if (entity.waterMiliBuckets + amount <= entity.maxWaterMiliBuckets) {
    //         entity.waterMiliBuckets += amount;
    //         entity.itemHandler.setStackInSlot(SLOT_WATER, new ItemStack(waterStack.getItem(), waterStack.getCount() - 1));
    //     }
    // }


    // public int getBurnDuration(ItemStack stack) {
    //     if (stack.isEmpty()) {
    //         return 0;
    //     } else {
    //         return net.minecraftforge.common.ForgeHooks.getBurnTime(stack, recipeType);
    //     }
    // }

    // private boolean isLit() {
    //     return this.litTime > 0;
    // }


    // private static boolean outputNotFull(CarameliserBlockEntity entity) {
    //     return entity.itemHandler.getStackInSlot(SLOT_OUTPUT).getCount() < entity.itemHandler.getStackInSlot(SLOT_OUTPUT).getMaxStackSize();
    // }

    // private static boolean ItemFitsInOutput(CarameliserBlockEntity entity, ItemStack output) {
    //     return entity.itemHandler.getStackInSlot(SLOT_OUTPUT).getItem() == output.getItem() || entity.itemHandler.getStackInSlot(SLOT_OUTPUT).isEmpty();
    // }

    // private void reduceProgress(CarameliserBlockEntity entity) {
    //     if (entity.progress > 0) {
    //         --entity.progress;
    //     } else {
    //         resetProgress(entity);
    //     }
    // }

    // private void resetProgress(CarameliserBlockEntity entity) {
    //     entity.progress = 0;
    // }
}
