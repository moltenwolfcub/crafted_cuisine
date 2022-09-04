package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.blocks.BlackstoneGravelBlock;
import com.moltenwolfcub.crafted_cuisine.blocks.BlackstoneRodBlock;
import com.moltenwolfcub.crafted_cuisine.blocks.RosePetalCarpetBlock;
import com.moltenwolfcub.crafted_cuisine.world.feature.tree.CinnamonSaplingGenerator;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LeverBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SignBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SnowBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodenButtonBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class AllBlocks {

    public static final Block SAW_DUST = BLOCKS.register("saw_dust", 
        new SnowBlock(FabricBlockSettings.of(Material.AGGREGATE, MapColor.ORANGE).strength(0.5f).sounds(BlockSoundGroup.SAND)));


    public static final Block CINNAMON_LOG = BLOCKS.register("cinnamon_log", 
        new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));

    public static final Block CINNAMON_WOOD = BLOCKS.register("cinnamon_wood", 
        new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));

    public static final Block STRIPPED_CINNAMON_LOG = BLOCKS.register("stripped_cinnamon_log", 
        new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));

    public static final Block STRIPPED_CINNAMON_WOOD = BLOCKS.register("stripped_cinnamon_wood", 
        new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block CINNAMON_PLANKS = BLOCKS.register("cinnamon_planks",
        new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    public static final Block CINNAMON_STAIRS = BLOCKS.register("cinnamon_stairs",
        new StairsBlock(AllBlocks.CINNAMON_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)));

    public static final Block CINNAMON_SLAB = BLOCKS.register("cinnamon_slab",
        new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));
    
    public static final Block CINNAMON_FENCE = BLOCKS.register("cinnamon_fence",
        new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    
    public static final Block CINNAMON_FENCE_GATE = BLOCKS.register("cinnamon_fence_gate",
        new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE)));
    
    public static final Block CINNAMON_BUTTON = BLOCKS.register("cinnamon_button",
        new WoodenButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON).noCollision()));

    public static final Block CINNAMON_PRESSURE_PLATE = BLOCKS.register("cinnamon_pressure_plate",
        new PressurePlateBlock(ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE)));

    public static final Block CINNAMON_DOOR = BLOCKS.register("cinnamon_door",
        new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).nonOpaque()));

    public static final Block CINNAMON_TRAPDOOR = BLOCKS.register("cinnamon_trapdoor",
        new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).nonOpaque()));

    public static final Block CINNAMON_WALL_SIGN = BLOCKS.register("cinnamon_wall_sign",
        new WallSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN), AllSignTypes.CINNAMON));

    public static final Block CINNAMON_SIGN = BLOCKS.register("cinnamon_sign",
        new SignBlock(FabricBlockSettings.copyOf(Blocks.OAK_SIGN), AllSignTypes.CINNAMON));

    public static final Block CINNAMON_LEAVES = BLOCKS.register("cinnamon_leaves",
        new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));

    public static final Block CINNAMON_SAPLING = BLOCKS.register("cinnamon_sapling",
        new SaplingBlock(new CinnamonSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

    public static final Block POTTED_CINNAMON_SAPLING = BLOCKS.register("potted_cinnamon_sapling",
        new FlowerPotBlock(AllBlocks.CINNAMON_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));

    
    public static final Block PINK_ROSE = BLOCKS.register("pink_rose",
        new FlowerBlock(StatusEffects.SATURATION, 0, FabricBlockSettings.copyOf(Blocks.DANDELION).nonOpaque()));

    public static final Block POTTED_PINK_ROSE = BLOCKS.register("potted_pink_rose",
        new FlowerPotBlock(AllBlocks.PINK_ROSE, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION).nonOpaque()));

    public static final Block FLOWER_STEM = BLOCKS.register("flower_stem",
        new FlowerBlock(StatusEffects.SATURATION, 0, FabricBlockSettings.copyOf(Blocks.DANDELION).nonOpaque()));

    public static final Block POTTED_FLOWER_STEM = BLOCKS.register("potted_flower_stem",
        new FlowerPotBlock(AllBlocks.FLOWER_STEM, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION).nonOpaque()));


    public static final Block RED_ROSE_CARPET = BLOCKS.register("red_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.RED, FabricBlockSettings.of(Material.LEAVES, DyeColor.RED)));

    public static final Block ORANGE_ROSE_CARPET = BLOCKS.register("orange_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.ORANGE, FabricBlockSettings.of(Material.LEAVES, DyeColor.ORANGE)));
    
    public static final Block YELLOW_ROSE_CARPET = BLOCKS.register("yellow_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.YELLOW, FabricBlockSettings.of(Material.LEAVES, DyeColor.YELLOW)));
    
    public static final Block LIME_ROSE_CARPET = BLOCKS.register("lime_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.LIME, FabricBlockSettings.of(Material.LEAVES, DyeColor.LIME)));
    
    public static final Block GREEN_ROSE_CARPET = BLOCKS.register("green_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.GREEN, FabricBlockSettings.of(Material.LEAVES, DyeColor.GREEN)));
    
    public static final Block LIGHT_BLUE_ROSE_CARPET = BLOCKS.register("light_blue_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.LIGHT_BLUE, FabricBlockSettings.of(Material.LEAVES, DyeColor.LIGHT_BLUE)));
    
    public static final Block CYAN_ROSE_CARPET = BLOCKS.register("cyan_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.CYAN, FabricBlockSettings.of(Material.LEAVES, DyeColor.CYAN)));
    
    public static final Block BLUE_ROSE_CARPET = BLOCKS.register("blue_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.BLUE, FabricBlockSettings.of(Material.LEAVES, DyeColor.BLUE)));
    
    public static final Block PURPLE_ROSE_CARPET = BLOCKS.register("purple_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.PURPLE, FabricBlockSettings.of(Material.LEAVES, DyeColor.PURPLE)));

    public static final Block MAGENTA_ROSE_CARPET = BLOCKS.register("magenta_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.MAGENTA, FabricBlockSettings.of(Material.LEAVES, DyeColor.MAGENTA)));

    public static final Block PINK_ROSE_CARPET = BLOCKS.register("pink_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.PINK, FabricBlockSettings.of(Material.LEAVES, DyeColor.PINK)));

    public static final Block BLACK_ROSE_CARPET = BLOCKS.register("black_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.BLACK, FabricBlockSettings.of(Material.LEAVES, DyeColor.BLACK)));
    
    public static final Block GRAY_ROSE_CARPET = BLOCKS.register("gray_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.GRAY, FabricBlockSettings.of(Material.LEAVES, DyeColor.GRAY)));
    
    public static final Block LIGHT_GRAY_ROSE_CARPET = BLOCKS.register("light_gray_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.LIGHT_GRAY, FabricBlockSettings.of(Material.LEAVES, DyeColor.LIGHT_GRAY)));
    
    public static final Block WHITE_ROSE_CARPET = BLOCKS.register("white_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.WHITE, FabricBlockSettings.of(Material.LEAVES, DyeColor.WHITE)));
    
    public static final Block BROWN_ROSE_CARPET = BLOCKS.register("brown_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.BROWN, FabricBlockSettings.of(Material.LEAVES, DyeColor.BROWN)));

    
    // public static final Block LEMON_TREE = BLOCKS.register("lemon_tree",
    //     new FruitTreeBlock(FabricBlockSettings.of(Material.PLANT).strength(0.5f).sounds(BlockSoundGroup.AZALEA), AllItems.LEMON));

    // public static final Block LIME_TREE = BLOCKS.register("lime_tree",
    //     new FruitTreeBlock(FabricBlockSettings.copyOf(LEMON_TREE.get()), AllItems.LIME));

    // public static final Block ORANGE_TREE = BLOCKS.register("orange_tree",
    //     new FruitTreeBlock(FabricBlockSettings.copyOf(LEMON_TREE.get()), AllItems.ORANGE, true, AllItems.BLOOD_ORANGE));

    
    public static final Block REINFORCED_BLACKSTONE = BLOCKS.register("reinforced_blackstone",
        new Block(FabricBlockSettings.of(Material.STONE, MapColor.BLACK).requiresTool().strength(5.5f, 6)));

    public static final Block REINFORCED_BLACKSTONE_DOOR = BLOCKS.register("reinforced_blackstone_door",
        new DoorBlock(FabricBlockSettings.of(Material.STONE, MapColor.BLACK).requiresTool().strength(5.5F).sounds(BlockSoundGroup.METAL).nonOpaque()));
        
    public static final Block REINFORCED_BLACKSTONE_LADDER = BLOCKS.register("reinforced_blackstone_ladder",
        new LadderBlock(FabricBlockSettings.of(Material.DECORATION, MapColor.BLACK).requiresTool().strength(0.5F).nonOpaque()));

    public static final Block REINFORCED_BLACKSTONE_ROD = BLOCKS.register("reinforced_blackstone_rod",
        new BlackstoneRodBlock(FabricBlockSettings.of(Material.DECORATION, MapColor.BLACK).breakInstantly().nonOpaque().luminance(14)));
    
    public static final Block REINFORCED_BLACKSTONE_LEVER = BLOCKS.register("reinforced_blackstone_lever",
        new LeverBlock(FabricBlockSettings.copyOf(Blocks.LEVER).strength(0.6f)));

    public static final Block REINFORCED_BLACKSTONE_BARS = BLOCKS.register("reinforced_blackstone_bars",
        new PaneBlock(FabricBlockSettings.of(Material.METAL, MapColor.BLACK).requiresTool().strength(5.5F, 6.0F).sounds(BlockSoundGroup.STONE).nonOpaque()));

    public static final Block REINFORCED_BLACKSTONE_TRAPDOOR = BLOCKS.register("reinforced_blackstone_trapdoor",
        new TrapdoorBlock(FabricBlockSettings.of(Material.STONE, MapColor.BLACK).requiresTool().strength(5.0F).nonOpaque().allowsSpawning(AllBlocks::never)));

    public static final Block REINFORCED_BLACKSTONE_GRAVEL = BLOCKS.register("reinforced_blackstone_gravel",
        new BlackstoneGravelBlock(918049, FabricBlockSettings.copyOf(Blocks.GRAVEL).strength(0.65f)));


    // public static final Block AUTO_BLOWTORCH = BLOCKS.register("auto_blowtorch",
    //     new AutoBlowTorchBlock(FabricBlockSettings.of(Material.GLASS).strength(2f).sounds(BlockSoundGroup.METAL).nonOpaque().requiresTool()));

    // public static final Block CARAMELISER = BLOCKS.register("carameliser",
    //     new CarameliserBlock(FabricBlockSettings.of(Material.METAL).strength(2f).sounds(BlockSoundGroup.METAL).nonOpaque().requiresTool()));


    
    /**
     * Copied from the vanilla {@link Blocks} class
     * used for "is valid spawn" check
     * @return a {@link Boolean} of false
     */
    public static Boolean never(BlockState state, BlockView getter, BlockPos pos, EntityType<?> type) {
        return false;
    }



	public static void registerFlammableBlocks() {
		FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();

        instance.add(CINNAMON_LOG, 5, 5);
        instance.add(CINNAMON_WOOD, 5, 5);
        instance.add(STRIPPED_CINNAMON_LOG, 5, 5);
        instance.add(STRIPPED_CINNAMON_WOOD, 5, 5);
        instance.add(CINNAMON_PLANKS, 20, 5);
        instance.add(CINNAMON_STAIRS, 20, 5);
        instance.add(CINNAMON_SLAB, 20, 5);
        instance.add(CINNAMON_FENCE, 20, 5);
        instance.add(CINNAMON_FENCE_GATE, 20, 5);
        instance.add(CINNAMON_BUTTON, 20, 5);
        instance.add(CINNAMON_PRESSURE_PLATE, 20, 5);
        instance.add(CINNAMON_TRAPDOOR, 20, 5);
        instance.add(CINNAMON_LEAVES, 60, 30);

        instance.add(RED_ROSE_CARPET, 75, 50);
        instance.add(ORANGE_ROSE_CARPET, 75, 50);
        instance.add(YELLOW_ROSE_CARPET, 75, 50);
        instance.add(LIME_ROSE_CARPET, 75, 50);
        instance.add(GREEN_ROSE_CARPET, 75, 50);
        instance.add(LIGHT_BLUE_ROSE_CARPET, 75, 50);
        instance.add(CYAN_ROSE_CARPET, 75, 50);
        instance.add(BLUE_ROSE_CARPET, 75, 50);
        instance.add(PURPLE_ROSE_CARPET, 75, 50);
        instance.add(MAGENTA_ROSE_CARPET, 75, 50);
        instance.add(PINK_ROSE_CARPET, 75, 50);
        instance.add(BLACK_ROSE_CARPET, 75, 50);
        instance.add(GRAY_ROSE_CARPET, 75, 50);
        instance.add(LIGHT_GRAY_ROSE_CARPET, 75, 50);
        instance.add(WHITE_ROSE_CARPET, 75, 50);
        instance.add(BROWN_ROSE_CARPET, 75, 50);
	}
    public static void registerStrippableBlocks() {
        StrippableBlockRegistry.register(AllBlocks.CINNAMON_LOG, AllBlocks.STRIPPED_CINNAMON_LOG);
        StrippableBlockRegistry.register(AllBlocks.CINNAMON_WOOD, AllBlocks.STRIPPED_CINNAMON_WOOD);
    }

    private static class BLOCKS{
        //this method is in a class for the simplicity of porting the forge project
        private static final Block register(String name, Block block) {
            return Registry.register(Registry.BLOCK, new Identifier(CraftedCuisine.MODID, name), block);
        }
    }

    public static void registerBlocks() {
        CraftedCuisine.LOGGER.info("Registering Blocks for " + CraftedCuisine.MODID);
    }
}
