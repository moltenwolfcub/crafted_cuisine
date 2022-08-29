package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.blocks.*;
import com.moltenwolfcub.crafted_cuisine.blocks.util.FlammableDoorBlock;
import com.moltenwolfcub.crafted_cuisine.blocks.util.FlammableFenceBlock;
import com.moltenwolfcub.crafted_cuisine.blocks.util.FlammableFenceGateBlock;
import com.moltenwolfcub.crafted_cuisine.blocks.util.FlammableLeavesBlock;
import com.moltenwolfcub.crafted_cuisine.blocks.util.FlammablePlanksBlock;
import com.moltenwolfcub.crafted_cuisine.blocks.util.FlammablePressurePlateBlock;
import com.moltenwolfcub.crafted_cuisine.blocks.util.FlammableRotatedPillarBlock;
import com.moltenwolfcub.crafted_cuisine.blocks.util.FlammableSlabBlock;
import com.moltenwolfcub.crafted_cuisine.blocks.util.FlammableStairBlock;
import com.moltenwolfcub.crafted_cuisine.blocks.util.FlammableTrapDoorBlock;
import com.moltenwolfcub.crafted_cuisine.blocks.util.FlammableWoodenButtonBlock;
import com.moltenwolfcub.crafted_cuisine.blocks.util.ModStandingSignBlock;
import com.moltenwolfcub.crafted_cuisine.blocks.util.ModWallSignBlock;
import com.moltenwolfcub.crafted_cuisine.world.feature.tree.CinnamonTreeGrower;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CraftedCuisine.MODID);


    public static final RegistryObject<Block> SAW_DUST = BLOCKS.register("saw_dust", 
        ()-> new SnowLayerBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).strength(0.5f).sound(SoundType.SAND)));


    public static final RegistryObject<Block> CINNAMON_LOG = BLOCKS.register("cinnamon_log", 
        ()-> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> CINNAMON_WOOD = BLOCKS.register("cinnamon_wood", 
        ()-> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> STRIPPED_CINNAMON_LOG = BLOCKS.register("stripped_cinnamon_log", 
        ()-> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_CINNAMON_WOOD = BLOCKS.register("stripped_cinnamon_wood", 
        ()-> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> CINNAMON_PLANKS = BLOCKS.register("cinnamon_planks",
        () -> new FlammablePlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> CINNAMON_STAIRS = BLOCKS.register("cinnamon_stairs",
        () -> new FlammableStairBlock(()-> AllBlocks.CINNAMON_PLANKS.get().defaultBlockState(),
            BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

    public static final RegistryObject<Block> CINNAMON_SLAB = BLOCKS.register("cinnamon_slab",
        () -> new FlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
    
    public static final RegistryObject<Block> CINNAMON_FENCE = BLOCKS.register("cinnamon_fence",
        () -> new FlammableFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    
    public static final RegistryObject<Block> CINNAMON_FENCE_GATE = BLOCKS.register("cinnamon_fence_gate",
        () -> new FlammableFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));
    
    public static final RegistryObject<Block> CINNAMON_BUTTON = BLOCKS.register("cinnamon_button",
        () -> new FlammableWoodenButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()));

    public static final RegistryObject<Block> CINNAMON_PRESSURE_PLATE = BLOCKS.register("cinnamon_pressure_plate",
        () -> new FlammablePressurePlateBlock(Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)));

    public static final RegistryObject<Block> CINNAMON_DOOR = BLOCKS.register("cinnamon_door",
        () -> new FlammableDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()));

    public static final RegistryObject<Block> CINNAMON_TRAPDOOR = BLOCKS.register("cinnamon_trapdoor",
        () -> new FlammableTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()));

    public static final RegistryObject<Block> CINNAMON_WALL_SIGN = BLOCKS.register("cinnamon_wall_sign",
        () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), AllWoodTypes.CINNAMON));

    public static final RegistryObject<Block> CINNAMON_SIGN = BLOCKS.register("cinnamon_sign",
        () -> new ModStandingSignBlock  (BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), AllWoodTypes.CINNAMON));

    public static final RegistryObject<Block> CINNAMON_LEAVES = BLOCKS.register("cinnamon_leaves",
        () -> new FlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> CINNAMON_SAPLING = BLOCKS.register("cinnamon_sapling",
        () -> new SaplingBlock(new CinnamonTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> POTTED_CINNAMON_SAPLING = BLOCKS.register("potted_cinnamon_sapling",
        () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CINNAMON_SAPLING, BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING).noOcclusion()));

    
    public static final RegistryObject<Block> PINK_ROSE = BLOCKS.register("pink_rose",
        () -> new FlowerBlock(MobEffects.SATURATION, 0, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));

    public static final RegistryObject<Block> POTTED_PINK_ROSE = BLOCKS.register("potted_pink_rose",
        () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PINK_ROSE, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));

    public static final RegistryObject<Block> FLOWER_STEM = BLOCKS.register("flower_stem",
        () -> new FlowerBlock(MobEffects.SATURATION, 0, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));

    public static final RegistryObject<Block> POTTED_FLOWER_STEM = BLOCKS.register("potted_flower_stem",
        () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FLOWER_STEM, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));


    public static final RegistryObject<Block> RED_ROSE_CARPET = BLOCKS.register("red_rose_carpet",
        () -> new RosePetalCarpetBlock(DyeColor.RED, BlockBehaviour.Properties.of(Material.LEAVES, DyeColor.RED)));

    public static final RegistryObject<Block> ORANGE_ROSE_CARPET = BLOCKS.register("orange_rose_carpet",
        () -> new RosePetalCarpetBlock(DyeColor.ORANGE, BlockBehaviour.Properties.of(Material.LEAVES, DyeColor.ORANGE)));
    
    public static final RegistryObject<Block> YELLOW_ROSE_CARPET = BLOCKS.register("yellow_rose_carpet",
        () -> new RosePetalCarpetBlock(DyeColor.YELLOW, BlockBehaviour.Properties.of(Material.LEAVES, DyeColor.YELLOW)));
    
    public static final RegistryObject<Block> LIME_ROSE_CARPET = BLOCKS.register("lime_rose_carpet",
        () -> new RosePetalCarpetBlock(DyeColor.LIME, BlockBehaviour.Properties.of(Material.LEAVES, DyeColor.LIME)));
    
    public static final RegistryObject<Block> GREEN_ROSE_CARPET = BLOCKS.register("green_rose_carpet",
        () -> new RosePetalCarpetBlock(DyeColor.GREEN, BlockBehaviour.Properties.of(Material.LEAVES, DyeColor.GREEN)));
    
    public static final RegistryObject<Block> LIGHT_BLUE_ROSE_CARPET = BLOCKS.register("light_blue_rose_carpet",
        () -> new RosePetalCarpetBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.of(Material.LEAVES, DyeColor.LIGHT_BLUE)));
    
    public static final RegistryObject<Block> CYAN_ROSE_CARPET = BLOCKS.register("cyan_rose_carpet",
        () -> new RosePetalCarpetBlock(DyeColor.CYAN, BlockBehaviour.Properties.of(Material.LEAVES, DyeColor.CYAN)));
    
    public static final RegistryObject<Block> BLUE_ROSE_CARPET = BLOCKS.register("blue_rose_carpet",
        () -> new RosePetalCarpetBlock(DyeColor.BLUE, BlockBehaviour.Properties.of(Material.LEAVES, DyeColor.BLUE)));
    
    public static final RegistryObject<Block> PURPLE_ROSE_CARPET = BLOCKS.register("purple_rose_carpet",
        () -> new RosePetalCarpetBlock(DyeColor.PURPLE, BlockBehaviour.Properties.of(Material.LEAVES, DyeColor.PURPLE)));

    public static final RegistryObject<Block> MAGENTA_ROSE_CARPET = BLOCKS.register("magenta_rose_carpet",
        () -> new RosePetalCarpetBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.of(Material.LEAVES, DyeColor.MAGENTA)));

    public static final RegistryObject<Block> PINK_ROSE_CARPET = BLOCKS.register("pink_rose_carpet",
        () -> new RosePetalCarpetBlock(DyeColor.PINK, BlockBehaviour.Properties.of(Material.LEAVES, DyeColor.PINK)));

    public static final RegistryObject<Block> BLACK_ROSE_CARPET = BLOCKS.register("black_rose_carpet",
        () -> new RosePetalCarpetBlock(DyeColor.BLACK, BlockBehaviour.Properties.of(Material.LEAVES, DyeColor.BLACK)));
    
    public static final RegistryObject<Block> GRAY_ROSE_CARPET = BLOCKS.register("gray_rose_carpet",
        () -> new RosePetalCarpetBlock(DyeColor.GRAY, BlockBehaviour.Properties.of(Material.LEAVES, DyeColor.GRAY)));
    
    public static final RegistryObject<Block> LIGHT_GRAY_ROSE_CARPET = BLOCKS.register("light_gray_rose_carpet",
        () -> new RosePetalCarpetBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.of(Material.LEAVES, DyeColor.LIGHT_GRAY)));
    
    public static final RegistryObject<Block> WHITE_ROSE_CARPET = BLOCKS.register("white_rose_carpet",
        () -> new RosePetalCarpetBlock(DyeColor.WHITE, BlockBehaviour.Properties.of(Material.LEAVES, DyeColor.WHITE)));
    
    public static final RegistryObject<Block> BROWN_ROSE_CARPET = BLOCKS.register("brown_rose_carpet",
        () -> new RosePetalCarpetBlock(DyeColor.BROWN, BlockBehaviour.Properties.of(Material.LEAVES, DyeColor.BROWN)));

    
    public static final RegistryObject<Block> LEMON_TREE = BLOCKS.register("lemon_tree",
        ()-> new FruitTreeBlock(BlockBehaviour.Properties.of(Material.PLANT).strength(0.5f).sound(SoundType.AZALEA), AllItems.LEMON));

    public static final RegistryObject<Block> LIME_TREE = BLOCKS.register("lime_tree",
        ()-> new FruitTreeBlock(BlockBehaviour.Properties.copy(LEMON_TREE.get()), AllItems.LIME));

    public static final RegistryObject<Block> ORANGE_TREE = BLOCKS.register("orange_tree",
        ()-> new FruitTreeBlock(BlockBehaviour.Properties.copy(LEMON_TREE.get()), AllItems.ORANGE, true, AllItems.BLOOD_ORANGE));

    
    public static final RegistryObject<Block> REINFORCED_BLACKSTONE = BLOCKS.register("reinforced_blackstone",
        ()-> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(5.5f, 6)));

    public static final RegistryObject<Block> REINFORCED_BLACKSTONE_DOOR = BLOCKS.register("reinforced_blackstone_door",
        () -> new DoorBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(5.5F).sound(SoundType.METAL).noOcclusion()));
        
    public static final RegistryObject<Block> REINFORCED_BLACKSTONE_LADDER = BLOCKS.register("reinforced_blackstone_ladder",
        () -> new LadderBlock(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(0.5F).noOcclusion()));

    public static final RegistryObject<Block> REINFORCED_BLACKSTONE_ROD = BLOCKS.register("reinforced_blackstone_rod",
        ()-> new BlackstoneRodBlock(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_BLACK).instabreak().noOcclusion().lightLevel((s)-> { return 14; })));
    
    public static final RegistryObject<Block> REINFORCED_BLACKSTONE_LEVER = BLOCKS.register("reinforced_blackstone_lever",
        ()-> new LeverBlock(BlockBehaviour.Properties.copy(Blocks.LEVER).strength(0.6f)));

    public static final RegistryObject<Block> REINFORCED_BLACKSTONE_BARS = BLOCKS.register("reinforced_blackstone_bars",
        ()-> new IronBarsBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(5.5F, 6.0F).sound(SoundType.STONE).noOcclusion()));

    public static final RegistryObject<Block> REINFORCED_BLACKSTONE_TRAPDOOR = BLOCKS.register("reinforced_blackstone_trapdoor",
        ()-> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(5.0F).noOcclusion().isValidSpawn(AllBlocks::never)));

    public static final RegistryObject<Block> REINFORCED_BLACKSTONE_GRAVEL = BLOCKS.register("reinforced_blackstone_gravel",
        ()-> new BlackstoneGravelBlock(918049, BlockBehaviour.Properties.copy(Blocks.GRAVEL).strength(0.65f)));


    public static final RegistryObject<Block> AUTO_BLOWTORCH = BLOCKS.register("auto_blowtorch",
        ()-> new AutoBlowTorchBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(2f).sound(SoundType.METAL).noOcclusion().requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CARAMELISER = BLOCKS.register("carameliser",
        ()-> new CarameliserBlock(BlockBehaviour.Properties.of(Material.METAL).strength(2f).sound(SoundType.METAL).noOcclusion().requiresCorrectToolForDrops()));


    
    /**
     * Copied from the vanilla {@link Blocks} class
     * used for "is valid spawn" check
     * @return a {@link Boolean} of false
     */
    public static Boolean never(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> type) {
        return false;
    }
}
