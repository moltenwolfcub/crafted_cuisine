package com.moltenwolfcub.crafted_cuisine.item;

import java.util.Map;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableMap.Builder;
import com.moltenwolfcub.crafted_cuisine.init.ModBlocks;
import com.moltenwolfcub.crafted_cuisine.init.ModItems;
import com.moltenwolfcub.crafted_cuisine.item.util.ItemBase;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class FlowerSeperator extends ItemBase {
    private static final Builder<Block, Supplier<Item>> DropBuilder = new Builder<Block, Supplier<Item>>();
    public static Map<Block, Supplier<Item>> DROPS;

    private static final Builder<Block, BlockState> BlockConvertsBuilder = new Builder<Block, BlockState>();
    public static Map<Block, BlockState> BLOCKCONVERTS;

    public FlowerSeperator(Properties properties) {
        super(properties);

        makeDrops();
        DROPS = DropBuilder.build();
        BLOCKCONVERTS = BlockConvertsBuilder.build();
    }

    private static void makeDrops() {
        addDrop(ModBlocks.PINK_ROSE, ModItems.PINK_ROSE_PETAL);

        addDrop(Blocks.DANDELION, ModItems.YELLOW_ROSE_PETAL);
        addDrop(Blocks.POPPY, ModItems.RED_ROSE_PETAL);
        addDrop(Blocks.BLUE_ORCHID, ModItems.LIGHT_BLUE_ROSE_PETAL);
        addDrop(Blocks.ALLIUM, ModItems.MAGENTA_ROSE_PETAL);
        addDrop(Blocks.AZURE_BLUET, ModItems.LIGHT_GRAY_ROSE_PETAL);
        addDrop(Blocks.RED_TULIP, ModItems.RED_ROSE_PETAL);
        addDrop(Blocks.ORANGE_TULIP, ModItems.ORANGE_ROSE_PETAL);
        addDrop(Blocks.WHITE_TULIP, ModItems.LIGHT_GRAY_ROSE_PETAL);
        addDrop(Blocks.PINK_TULIP, ModItems.PINK_ROSE_PETAL);
        addDrop(Blocks.OXEYE_DAISY, ModItems.LIGHT_GRAY_ROSE_PETAL);
        addDrop(Blocks.CORNFLOWER, ModItems.BLUE_ROSE_PETAL);
        addDrop(Blocks.WITHER_ROSE, ModItems.BLACK_ROSE_PETAL);
        addDrop(Blocks.LILY_OF_THE_VALLEY, ModItems.WHITE_ROSE_PETAL);

        addDrop(Blocks.GRASS, Items.WHEAT_SEEDS, Blocks.AIR.defaultBlockState());
        addDrop(Blocks.SEAGRASS, Items.SEAGRASS, Blocks.WATER.defaultBlockState());
    }


    public static void addDrop(Block block, Supplier<Item> item) {
        DropBuilder.put(block, item);
    }

    public static void addDrop(Supplier<Block> block, Supplier<Item> item) {
        addDrop(block.get(), item);
    }

    public static void addDrop(Block block, Supplier<Item> item, BlockState state) {
        DropBuilder.put(block, item);
        BlockConvertsBuilder.put(block, state);
    }

    public static void addDrop(Supplier<Block> block, Supplier<Item> item, BlockState state) {
        addDrop(block.get(), item, state);
    }

    public static void addDrop(Block block, Item item) {
        addDrop(block, ()->item);
    }

    public static void addDrop(Supplier<Block> block, Item item) {
        addDrop(block.get(), item);
    }

    public static void addDrop(Block block, Item item, BlockState state) {
        addDrop(block, ()->item, state);
    }

    public static void addDrop(Supplier<Block> block, Item item, BlockState state) {
        addDrop(block.get(), item, state);
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        InteractionHand hand = context.getHand();
        Block blockClicked =  level.getBlockState(pos).getBlock();

        Supplier<Item> SuppliedDrop = DROPS.get(blockClicked);
        BlockState newBlock = BLOCKCONVERTS.get(blockClicked);

        BlockState BlockToSpawn = newBlock != null ? newBlock : ModBlocks.FLOWER_STEM.get().defaultBlockState();

        if (SuppliedDrop != null) {
            ItemStack dropStack = new ItemStack(SuppliedDrop.get());

            level.setBlockAndUpdate(pos, BlockToSpawn);
            level.playSound(player, pos, SoundEvents.GROWING_PLANT_CROP, SoundSource.BLOCKS, 1.0F, 1.0F);
            spawnDrop(dropStack, level, pos);

            hurtItem(1, player, stack, hand);

            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return super.useOn(context);
    }

    public void hurtItem(int amount, Player player, ItemStack stack, InteractionHand hand) {
        if (player != null) {
            stack.hurtAndBreak(1, player, (playerVal) -> {
                player.broadcastBreakEvent(hand);
            });
        }

    }

    public void spawnDrop(ItemStack stack, Level level, BlockPos pos){
        if (stack != null){
            ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), stack);
            level.addFreshEntity(itemEntity);
        }
    }
    
}
