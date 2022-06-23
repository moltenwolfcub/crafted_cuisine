package com.moltenwolfcub.crafted_cuisine.datagen;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.blocks.CarameliserBlock;
import com.moltenwolfcub.crafted_cuisine.blocks.FruitTreeBlock;
import com.moltenwolfcub.crafted_cuisine.init.ModBlocks;

import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RodBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, CraftedCuisine.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        createParents();

        ResourceLocation cinnamon_planks = blockTexture(ModBlocks.CINNAMON_PLANKS.get());

        simpleBlock(ModBlocks.CINNAMON_PLANKS.get());
        simpleBlock(ModBlocks.CINNAMON_LEAVES.get());

        simpleBlock(ModBlocks.REINFORCED_BLACKSTONE.get());
        doorBlock((DoorBlock)ModBlocks.REINFORCED_BLACKSTONE_DOOR.get(), 
            new ResourceLocation(CraftedCuisine.MODID, "block/reinforced_blackstone_door_bottom"), 
            new ResourceLocation(CraftedCuisine.MODID, "block/reinforced_blackstone_door_top"));
        horizontalBlock(ModBlocks.REINFORCED_BLACKSTONE_LADDER.get(), 
            models().withExistingParent("reinforced_blackstone_ladder", "minecraft:block/ladder")
            .texture("texture", new ResourceLocation(CraftedCuisine.MODID, "block/reinforced_blackstone_ladder"))
            .texture("particle", new ResourceLocation(CraftedCuisine.MODID, "block/reinforced_blackstone_ladder"))
        );
        rodBlock((RodBlock)ModBlocks.REINFORCED_BLACKSTONE_ROD.get(), 
            models().withExistingParent("reinforced_blackstone_rod", "minecraft:block/end_rod")
            .texture("end_rod", new ResourceLocation(CraftedCuisine.MODID, "block/reinforced_blackstone_rod"))
            .texture("particle", new ResourceLocation(CraftedCuisine.MODID, "block/reinforced_blackstone_rod"))
        );
        leverBlock((LeverBlock)ModBlocks.REINFORCED_BLACKSTONE_LEVER.get(),
            models().withExistingParent("reinforced_blackstone_lever_on", "minecraft:block/lever_on")
                .texture("particle", new ResourceLocation(CraftedCuisine.MODID, "block/reinforced_blackstone"))
                .texture("base", new ResourceLocation(CraftedCuisine.MODID, "block/reinforced_blackstone"))
                .texture("lever", new ResourceLocation(CraftedCuisine.MODID, "block/reinforced_blackstone_lever")),
            models().withExistingParent("reinforced_blackstone_lever", "minecraft:block/lever")
                .texture("particle", new ResourceLocation(CraftedCuisine.MODID, "block/reinforced_blackstone"))
                .texture("base", new ResourceLocation(CraftedCuisine.MODID, "block/reinforced_blackstone"))
                .texture("lever", new ResourceLocation(CraftedCuisine.MODID, "block/reinforced_blackstone_lever"))
        );

        buttonBlock((ButtonBlock)ModBlocks.CINNAMON_BUTTON.get(), cinnamon_planks);
        pressurePlateBlock((PressurePlateBlock)ModBlocks.CINNAMON_PRESSURE_PLATE.get(), cinnamon_planks);
        fenceBlock((FenceBlock)ModBlocks.CINNAMON_FENCE.get(), cinnamon_planks);
        fenceGateBlock((FenceGateBlock)ModBlocks.CINNAMON_FENCE_GATE.get(), cinnamon_planks);
        slabBlock((SlabBlock)ModBlocks.CINNAMON_SLAB.get(), cinnamon_planks, cinnamon_planks);
        stairsBlock((StairBlock)ModBlocks.CINNAMON_STAIRS.get(), cinnamon_planks);
        doorBlock((DoorBlock)ModBlocks.CINNAMON_DOOR.get(), 
            new ResourceLocation(CraftedCuisine.MODID, "block/cinnamon_door_bottom"), 
            new ResourceLocation(CraftedCuisine.MODID, "block/cinnamon_door_top"));
        trapdoorBlock((TrapDoorBlock)ModBlocks.CINNAMON_TRAPDOOR.get(), blockTexture(ModBlocks.CINNAMON_TRAPDOOR.get()), true);
        logBlock((RotatedPillarBlock) ModBlocks.CINNAMON_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_CINNAMON_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.CINNAMON_WOOD.get(), blockTexture(ModBlocks.CINNAMON_LOG.get()), blockTexture(ModBlocks.CINNAMON_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_CINNAMON_WOOD.get(), blockTexture(ModBlocks.STRIPPED_CINNAMON_LOG.get()), blockTexture(ModBlocks.STRIPPED_CINNAMON_LOG.get()));
        signBlock((StandingSignBlock)ModBlocks.CINNAMON_SIGN.get(), (WallSignBlock)ModBlocks.CINNAMON_WALL_SIGN.get(), cinnamon_planks);

        simpleBlock(ModBlocks.RED_ROSE_CARPET.get(), petalCarpet(ModBlocks.RED_ROSE_CARPET.get().getRegistryName().getPath(), blockTexture(ModBlocks.RED_ROSE_CARPET.get())));
        simpleBlock(ModBlocks.ORANGE_ROSE_CARPET.get(), petalCarpet(ModBlocks.ORANGE_ROSE_CARPET.get().getRegistryName().getPath(), blockTexture(ModBlocks.ORANGE_ROSE_CARPET.get())));
        simpleBlock(ModBlocks.YELLOW_ROSE_CARPET.get(), petalCarpet(ModBlocks.YELLOW_ROSE_CARPET.get().getRegistryName().getPath(), blockTexture(ModBlocks.YELLOW_ROSE_CARPET.get())));
        simpleBlock(ModBlocks.LIME_ROSE_CARPET.get(), petalCarpet(ModBlocks.LIME_ROSE_CARPET.get().getRegistryName().getPath(), blockTexture(ModBlocks.LIME_ROSE_CARPET.get())));
        simpleBlock(ModBlocks.GREEN_ROSE_CARPET.get(), petalCarpet(ModBlocks.GREEN_ROSE_CARPET.get().getRegistryName().getPath(), blockTexture(ModBlocks.GREEN_ROSE_CARPET.get())));
        simpleBlock(ModBlocks.BLUE_ROSE_CARPET.get(), petalCarpet(ModBlocks.BLUE_ROSE_CARPET.get().getRegistryName().getPath(), blockTexture(ModBlocks.BLUE_ROSE_CARPET.get())));
        simpleBlock(ModBlocks.CYAN_ROSE_CARPET.get(), petalCarpet(ModBlocks.CYAN_ROSE_CARPET.get().getRegistryName().getPath(), blockTexture(ModBlocks.CYAN_ROSE_CARPET.get())));
        simpleBlock(ModBlocks.LIGHT_BLUE_ROSE_CARPET.get(), petalCarpet(ModBlocks.LIGHT_BLUE_ROSE_CARPET.get().getRegistryName().getPath(), blockTexture(ModBlocks.LIGHT_BLUE_ROSE_CARPET.get())));
        simpleBlock(ModBlocks.PURPLE_ROSE_CARPET.get(), petalCarpet(ModBlocks.PURPLE_ROSE_CARPET.get().getRegistryName().getPath(), blockTexture(ModBlocks.PURPLE_ROSE_CARPET.get())));
        simpleBlock(ModBlocks.MAGENTA_ROSE_CARPET.get(), petalCarpet(ModBlocks.MAGENTA_ROSE_CARPET.get().getRegistryName().getPath(), blockTexture(ModBlocks.MAGENTA_ROSE_CARPET.get())));
        simpleBlock(ModBlocks.PINK_ROSE_CARPET.get(), petalCarpet(ModBlocks.PINK_ROSE_CARPET.get().getRegistryName().getPath(), blockTexture(ModBlocks.PINK_ROSE_CARPET.get())));
        simpleBlock(ModBlocks.BLACK_ROSE_CARPET.get(), petalCarpet(ModBlocks.BLACK_ROSE_CARPET.get().getRegistryName().getPath(), blockTexture(ModBlocks.BLACK_ROSE_CARPET.get())));
        simpleBlock(ModBlocks.GRAY_ROSE_CARPET.get(), petalCarpet(ModBlocks.GRAY_ROSE_CARPET.get().getRegistryName().getPath(), blockTexture(ModBlocks.GRAY_ROSE_CARPET.get())));
        simpleBlock(ModBlocks.LIGHT_GRAY_ROSE_CARPET.get(), petalCarpet(ModBlocks.LIGHT_GRAY_ROSE_CARPET.get().getRegistryName().getPath(), blockTexture(ModBlocks.LIGHT_GRAY_ROSE_CARPET.get())));
        simpleBlock(ModBlocks.WHITE_ROSE_CARPET.get(), petalCarpet(ModBlocks.WHITE_ROSE_CARPET.get().getRegistryName().getPath(), blockTexture(ModBlocks.WHITE_ROSE_CARPET.get())));
        simpleBlock(ModBlocks.BROWN_ROSE_CARPET.get(), petalCarpet(ModBlocks.BROWN_ROSE_CARPET.get().getRegistryName().getPath(), blockTexture(ModBlocks.BROWN_ROSE_CARPET.get())));

        simpleBlock(ModBlocks.FLOWER_STEM.get(), models().cross(ModBlocks.FLOWER_STEM.get().getRegistryName().getPath(), blockTexture(ModBlocks.FLOWER_STEM.get())));
        simpleBlock(ModBlocks.PINK_ROSE.get(), models().cross(ModBlocks.PINK_ROSE.get().getRegistryName().getPath(), blockTexture(ModBlocks.PINK_ROSE.get())));
        simpleBlock(ModBlocks.CINNAMON_SAPLING.get(), models().cross(ModBlocks.CINNAMON_SAPLING.get().getRegistryName().getPath(), blockTexture(ModBlocks.CINNAMON_SAPLING.get())));

        simpleBlock(ModBlocks.POTTED_FLOWER_STEM.get(), flowerPotCross(ModBlocks.POTTED_FLOWER_STEM.get().getRegistryName().getPath(), ModBlocks.FLOWER_STEM.get()));
        simpleBlock(ModBlocks.POTTED_PINK_ROSE.get(), flowerPotCross(ModBlocks.POTTED_PINK_ROSE.get().getRegistryName().getPath(), ModBlocks.PINK_ROSE.get()));
        simpleBlock(ModBlocks.POTTED_CINNAMON_SAPLING.get(), flowerPotCross(ModBlocks.POTTED_CINNAMON_SAPLING.get().getRegistryName().getPath(), ModBlocks.CINNAMON_SAPLING.get()));

        fruitTreeBlock((FruitTreeBlock) ModBlocks.LEMON_TREE.get());
        fruitTreeBlock((FruitTreeBlock) ModBlocks.LIME_TREE.get());
        fruitTreeBlock((FruitTreeBlock) ModBlocks.ORANGE_TREE.get());

        sawDustBlock((SnowLayerBlock) ModBlocks.SAW_DUST.get());

        horizontalBlock(ModBlocks.AUTO_BLOWTORCH.get(), models().getExistingFile(new ResourceLocation(CraftedCuisine.MODID, "block/auto_blowtorch")));
        horizontalBlock(ModBlocks.CARAMELISER.get(), state -> state.getValue(CarameliserBlock.FULL) ? 
            models().getExistingFile(new ResourceLocation(CraftedCuisine.MODID, "block/full_carameliser")) : 
            models().getExistingFile(new ResourceLocation(CraftedCuisine.MODID, "block/carameliser"))
        );
    }

    public void createParents() {
        createPetalCarpetParent();
    }


    public BlockModelBuilder petalCarpet(String name, ResourceLocation petal) {
        return models().singleTexture(name, new ResourceLocation(CraftedCuisine.MODID, "block/petal_carpet"), "petal", petal);
    }

    public BlockModelBuilder flowerPotCross(String name, Block plant) {
        return models().withExistingParent(name, "flower_pot_cross").texture("plant", "block/" + plant.getRegistryName().getPath());
    }

    public BlockModelBuilder fruitTreeBlock(String name, String parent, String fruitTexture) {
        return models().withExistingParent(name, new ResourceLocation(CraftedCuisine.MODID, parent))
        .texture("leaves", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_leaves"))
        .texture("stem", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_stem"))
        .texture("fruit", new ResourceLocation(CraftedCuisine.MODID, fruitTexture));
    }


    public BlockModelBuilder createPetalCarpetParent(){
        return models().withExistingParent(
            "petal_carpet", 
            new ResourceLocation("block/thin_block")
            ).element()
            .from(0, 0, 0)
            .to(16, 1, 16)
            .face(Direction.DOWN)
                .uvs(0,  0, 16, 16)
                .texture("#petal")
                .cullface(Direction.DOWN)
                .end()
            .face(Direction.UP)
                .uvs(0,  0, 16, 16)
                .texture("#petal")
                .end()
        .end()
        .texture("particle", "#petal");
    }


    public void fruitTreeBlock(FruitTreeBlock block) {
        String blockName = block.getRegistryName().getPath();

        getVariantBuilder(block).forAllStates(state -> {

            DoubleBlockHalf half = state.getValue(FruitTreeBlock.HALF);
            int age = state.getValue(BlockStateProperties.AGE_5);

            int modelSuffix;
            switch (age){
                case 0: modelSuffix = 0; break;
                case 1: modelSuffix = 1; break;
                case 2: modelSuffix = 1; break;
                case 3: modelSuffix = 2; break;
                case 4: modelSuffix = 2; break;
                case 5: modelSuffix = 3; break;
                default: modelSuffix = 3; break;
            }

            String parent;
            switch (modelSuffix){
                case 0: parent = "fruit_tree_" + half.toString() + "_no_fruit"; break;
                case 1: parent = "fruit_tree_" + half.toString() + "_small_fruit"; break;
                case 2: parent = "fruit_tree_" + half.toString(); break;
                case 3: parent = "fruit_tree_" + half.toString(); break;
                default: parent = "fruit_tree_" + half.toString(); break;
            }

            ModelFile model = fruitTreeBlock(
                blockName +"_"+ half.toString() +"_"+modelSuffix,
                parent,
                modelSuffix != 0 ? "block/" + blockName + "_fruit_" + modelSuffix : "block/" + blockName + "_fruit_" + 1
            );

            return ConfiguredModel.builder().modelFile(model).build();
        });
    }

    public void sawDustBlock(SnowLayerBlock block) {
        getVariantBuilder(block).forAllStates(state -> {

            int layers = state.getValue(SnowLayerBlock.LAYERS);

            ResourceLocation texture = new ResourceLocation(CraftedCuisine.MODID, "block/saw_dust");

            ModelFile model;
            if (layers != 8){
                model = models().withExistingParent("saw_dust_" + layers*2, "block/snow_height" + layers*2)
                    .texture("texture", texture).texture("particle", texture);
            } else{
                model = models().withExistingParent("saw_dust", "block/cube_all").texture("all", texture);
            }

            return ConfiguredModel.builder().modelFile(model).build();
        });
    }

    public void rodBlock(RodBlock block, ModelFile model) {
        getVariantBuilder(block).forAllStates(state -> {
            int yrot = 0;
            int xrot = 0;

            Direction dir = state.getValue(BlockStateProperties.FACING);
            switch (dir) {
                case UP: break;
                case DOWN: xrot = 180; break;
                case NORTH: xrot = 90; break;
                case EAST: xrot = 90; yrot = 90; break;
                case SOUTH: xrot = 90; yrot = 180; break;
                case WEST: xrot = 90; yrot = 270; break;
                default: break;
            }
            return ConfiguredModel.builder().modelFile(model).rotationY(yrot).rotationX(xrot).build();
        });
    }

    public void leverBlock(LeverBlock block, ModelFile on, ModelFile off) {
        getVariantBuilder(block).forAllStates(state -> {

            Direction dir = state.getValue(LeverBlock.FACING);
            AttachFace face = state.getValue(LeverBlock.FACE);

            ModelFile model;
            int xRot = 0;
            int yRot = 0;

            model = state.getValue(LeverBlock.POWERED) ? on : off;

            yRot = ((int)dir.toYRot() + 180) % 360;

            switch (face) {
                case FLOOR: break;
                case WALL: xRot = 90; break;
                case CEILING: xRot = 180; break;
                default: break;
            }

            return ConfiguredModel.builder().modelFile(model).rotationY(yRot).rotationX(xRot).build();

        });
    }
}
