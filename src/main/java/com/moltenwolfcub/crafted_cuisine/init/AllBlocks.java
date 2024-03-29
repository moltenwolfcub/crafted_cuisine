package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.block.*;
import com.moltenwolfcub.crafted_cuisine.entity.ModBoatType;
import com.moltenwolfcub.crafted_cuisine.world.feature.tree.CinnamonTreeGrower;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class AllBlocks {

    public static final Block SAW_DUST = AllBlocks.register("saw_dust", 
        new SnowLayerBlock(FabricBlockSettings.of(Material.SAND, MaterialColor.SAND).strength(0.5f).sounds(SoundType.SAND)));


    public static final Block CINNAMON_LOG = AllBlocks.register("cinnamon_log", 
        new RotatedPillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).drops(null)));

    public static final Block CINNAMON_WOOD = AllBlocks.register("cinnamon_wood", 
        new RotatedPillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).drops(null)));

    public static final Block STRIPPED_CINNAMON_LOG = AllBlocks.register("stripped_cinnamon_log", 
        new RotatedPillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).drops(null)));

    public static final Block STRIPPED_CINNAMON_WOOD = AllBlocks.register("stripped_cinnamon_wood", 
        new RotatedPillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).drops(null)));

    public static final Block CINNAMON_PLANKS = AllBlocks.register("cinnamon_planks",
        new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).drops(null)));

    public static final Block CINNAMON_STAIRS = AllBlocks.register("cinnamon_stairs",
        new StairBlock(CINNAMON_PLANKS.defaultBlockState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS).drops(null)));

    public static final Block CINNAMON_SLAB = AllBlocks.register("cinnamon_slab",
        new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).drops(null)));
    
    public static final Block CINNAMON_FENCE = AllBlocks.register("cinnamon_fence",
        new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).drops(null)));
    
    public static final Block CINNAMON_FENCE_GATE = AllBlocks.register("cinnamon_fence_gate",
        new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).drops(null), AllWoodTypes.CINNAMON));
    
    public static final Block CINNAMON_BUTTON = AllBlocks.register("cinnamon_button",
        new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON).drops(null).noCollision(), AllBlockSetTypes.CINNAMON, 30, true));

    public static final Block CINNAMON_PRESSURE_PLATE = AllBlocks.register("cinnamon_pressure_plate",
        new PressurePlateBlock(Sensitivity.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).drops(null), AllBlockSetTypes.CINNAMON));

    public static final Block CINNAMON_DOOR = AllBlocks.register("cinnamon_door",
        new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).drops(null).nonOpaque(), AllBlockSetTypes.CINNAMON));

    public static final Block CINNAMON_TRAPDOOR = AllBlocks.register("cinnamon_trapdoor",
        new TrapDoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).drops(null).nonOpaque(), AllBlockSetTypes.CINNAMON));

    public static final Block CINNAMON_WALL_SIGN = AllBlocks.register("cinnamon_wall_sign",
        new WallSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN).drops(null), AllWoodTypes.CINNAMON));

    public static final Block CINNAMON_SIGN = AllBlocks.register("cinnamon_sign",
        new StandingSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_SIGN).drops(null), AllWoodTypes.CINNAMON));

    public static final Block CINNAMON_LEAVES = AllBlocks.register("cinnamon_leaves",
        new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).drops(null)));

    public static final Block CINNAMON_SAPLING = AllBlocks.register("cinnamon_sapling",
        new SaplingBlock(new CinnamonTreeGrower(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).drops(null)));

    public static final Block POTTED_CINNAMON_SAPLING = AllBlocks.register("potted_cinnamon_sapling",
        new FlowerPotBlock(CINNAMON_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING).drops(null)));

    
    public static final Block PINK_ROSE = AllBlocks.register("pink_rose",
        new FlowerBlock(MobEffects.REGENERATION, 10, FabricBlockSettings.copyOf(Blocks.DANDELION).drops(null).nonOpaque()));

    public static final Block POTTED_PINK_ROSE = AllBlocks.register("potted_pink_rose",
        new FlowerPotBlock(PINK_ROSE, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION).drops(null).nonOpaque()));

    public static final Block FLOWER_STEM = AllBlocks.register("flower_stem",
        new FlowerBlock(MobEffects.CONFUSION, 12, FabricBlockSettings.copyOf(Blocks.DANDELION).drops(null).nonOpaque()));

    public static final Block POTTED_FLOWER_STEM = AllBlocks.register("potted_flower_stem",
        new FlowerPotBlock(FLOWER_STEM, FabricBlockSettings.copyOf(Blocks.POTTED_DANDELION).drops(null).nonOpaque()));


    public static final Block RED_ROSE_CARPET = AllBlocks.register("red_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.RED, FabricBlockSettings.of(Material.LEAVES, DyeColor.RED)));

    public static final Block ORANGE_ROSE_CARPET = AllBlocks.register("orange_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.ORANGE, FabricBlockSettings.of(Material.LEAVES, DyeColor.ORANGE)));
    
    public static final Block YELLOW_ROSE_CARPET = AllBlocks.register("yellow_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.YELLOW, FabricBlockSettings.of(Material.LEAVES, DyeColor.YELLOW)));
    
    public static final Block LIME_ROSE_CARPET = AllBlocks.register("lime_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.LIME, FabricBlockSettings.of(Material.LEAVES, DyeColor.LIME)));
    
    public static final Block GREEN_ROSE_CARPET = AllBlocks.register("green_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.GREEN, FabricBlockSettings.of(Material.LEAVES, DyeColor.GREEN)));
    
    public static final Block LIGHT_BLUE_ROSE_CARPET = AllBlocks.register("light_blue_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.LIGHT_BLUE, FabricBlockSettings.of(Material.LEAVES, DyeColor.LIGHT_BLUE)));
    
    public static final Block CYAN_ROSE_CARPET = AllBlocks.register("cyan_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.CYAN, FabricBlockSettings.of(Material.LEAVES, DyeColor.CYAN)));
    
    public static final Block BLUE_ROSE_CARPET = AllBlocks.register("blue_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.BLUE, FabricBlockSettings.of(Material.LEAVES, DyeColor.BLUE)));
    
    public static final Block PURPLE_ROSE_CARPET = AllBlocks.register("purple_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.PURPLE, FabricBlockSettings.of(Material.LEAVES, DyeColor.PURPLE)));

    public static final Block MAGENTA_ROSE_CARPET = AllBlocks.register("magenta_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.MAGENTA, FabricBlockSettings.of(Material.LEAVES, DyeColor.MAGENTA)));

    public static final Block PINK_ROSE_CARPET = AllBlocks.register("pink_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.PINK, FabricBlockSettings.of(Material.LEAVES, DyeColor.PINK)));

    public static final Block BLACK_ROSE_CARPET = AllBlocks.register("black_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.BLACK, FabricBlockSettings.of(Material.LEAVES, DyeColor.BLACK)));
    
    public static final Block GRAY_ROSE_CARPET = AllBlocks.register("gray_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.GRAY, FabricBlockSettings.of(Material.LEAVES, DyeColor.GRAY)));
    
    public static final Block LIGHT_GRAY_ROSE_CARPET = AllBlocks.register("light_gray_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.LIGHT_GRAY, FabricBlockSettings.of(Material.LEAVES, DyeColor.LIGHT_GRAY)));
    
    public static final Block WHITE_ROSE_CARPET = AllBlocks.register("white_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.WHITE, FabricBlockSettings.of(Material.LEAVES, DyeColor.WHITE)));
    
    public static final Block BROWN_ROSE_CARPET = AllBlocks.register("brown_rose_carpet",
        new RosePetalCarpetBlock(DyeColor.BROWN, FabricBlockSettings.of(Material.LEAVES, DyeColor.BROWN)));

    
    public static final Block LEMON_TREE = AllBlocks.register("lemon_tree",
        new FruitTreeBlock(FabricBlockSettings.of(Material.PLANT).strength(0.5f).sounds(SoundType.AZALEA)));

    public static final Block LIME_TREE = AllBlocks.register("lime_tree",
        new FruitTreeBlock(FabricBlockSettings.copyOf(LEMON_TREE).drops(null)));

    public static final Block ORANGE_TREE = AllBlocks.register("orange_tree",
        new FruitTreeBlock(FabricBlockSettings.copyOf(LEMON_TREE).drops(null)));
    

    public static final Block REINFORCED_BLACKSTONE = AllBlocks.register("reinforced_blackstone",
        new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresTool().strength(5.5f, 6)));

    public static final Block REINFORCED_BLACKSTONE_DOOR = AllBlocks.register("reinforced_blackstone_door",
        new DoorBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresTool().strength(5.5F).sounds(SoundType.METAL).nonOpaque(), BlockSetType.POLISHED_BLACKSTONE));
        
    public static final Block REINFORCED_BLACKSTONE_LADDER = AllBlocks.register("reinforced_blackstone_ladder",
        new LadderBlock(FabricBlockSettings.of(Material.DECORATION, MaterialColor.COLOR_BLACK).requiresTool().strength(0.5F).nonOpaque()));

    public static final Block REINFORCED_BLACKSTONE_ROD = AllBlocks.register("reinforced_blackstone_rod",
        new BlackstoneRodBlock(FabricBlockSettings.of(Material.DECORATION, MaterialColor.COLOR_BLACK).breakInstantly().nonOpaque().luminance(14)));
    
    public static final Block REINFORCED_BLACKSTONE_LEVER = AllBlocks.register("reinforced_blackstone_lever",
        new LeverBlock(FabricBlockSettings.copyOf(Blocks.LEVER).drops(null).strength(0.6f)));

    public static final Block REINFORCED_BLACKSTONE_BARS = AllBlocks.register("reinforced_blackstone_bars",
        new IronBarsBlock(FabricBlockSettings.of(Material.METAL, MaterialColor.COLOR_BLACK).requiresTool().strength(5.5F, 6.0F).sounds(SoundType.STONE).nonOpaque()));

    public static final Block REINFORCED_BLACKSTONE_TRAPDOOR = AllBlocks.register("reinforced_blackstone_trapdoor",
        new TrapDoorBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresTool().strength(5.0F).nonOpaque().allowsSpawning(AllBlocks::never), BlockSetType.POLISHED_BLACKSTONE));

    public static final Block REINFORCED_BLACKSTONE_GRAVEL = AllBlocks.register("reinforced_blackstone_gravel",
        new BlackstoneGravelBlock(918049, FabricBlockSettings.copyOf(Blocks.GRAVEL).drops(null).strength(0.65f)));


    public static final Block AUTO_BLOWTORCH = AllBlocks.register("auto_blowtorch",
        new AutoBlowTorchBlock(FabricBlockSettings.of(Material.GLASS).strength(2.0f).sounds(SoundType.METAL).nonOpaque().requiresTool()));

    public static final Block CARAMELISER = AllBlocks.register("carameliser",
        new CarameliserBlock(FabricBlockSettings.of(Material.METAL).strength(2.0f).sounds(SoundType.METAL).nonOpaque().requiresTool()));



    /**
     * Copied from the vanilla {@link Blocks} class
     * used for "is valid spawn" check
     * @return a {@link Boolean} of false
     */
    private static Boolean never(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> type) {
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
        StrippableBlockRegistry.register(CINNAMON_LOG, STRIPPED_CINNAMON_LOG);
        StrippableBlockRegistry.register(CINNAMON_WOOD, STRIPPED_CINNAMON_WOOD);
    }

    public static Block register(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(CraftedCuisine.MODID, name), block);
    }

    public static void registerBlocks() {
        CraftedCuisine.LOGGER.info("Registering Blocks for " + CraftedCuisine.MODID);
        ModBoatType.cinnamonBase = CINNAMON_PLANKS;
    }
}
