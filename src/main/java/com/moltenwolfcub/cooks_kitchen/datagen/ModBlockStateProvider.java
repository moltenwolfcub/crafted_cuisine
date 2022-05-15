package com.moltenwolfcub.cooks_kitchen.datagen;

import com.moltenwolfcub.cooks_kitchen.CooksKitchen;
import com.moltenwolfcub.cooks_kitchen.blocks.FruitTreeBlock;
import com.moltenwolfcub.cooks_kitchen.init.ModBlocks;

import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelBuilder.FaceRotation;
import net.minecraftforge.client.model.generators.ModelBuilder.Perspective;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, CooksKitchen.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        createParents();

        ResourceLocation cinnamon_planks = blockTexture(ModBlocks.CINNAMON_PLANKS.get());

        simpleBlock(ModBlocks.CINNAMON_PLANKS.get());
        simpleBlock(ModBlocks.CINNAMON_LEAVES.get());

        buttonBlock((ButtonBlock)ModBlocks.CINNAMON_BUTTON.get(), cinnamon_planks);
        pressurePlateBlock((PressurePlateBlock)ModBlocks.CINNAMON_PRESSURE_PLATE.get(), cinnamon_planks);
        fenceBlock((FenceBlock)ModBlocks.CINNAMON_FENCE.get(), cinnamon_planks);
        fenceGateBlock((FenceGateBlock)ModBlocks.CINNAMON_FENCE_GATE.get(), cinnamon_planks);
        slabBlock((SlabBlock)ModBlocks.CINNAMON_SLAB.get(), cinnamon_planks, cinnamon_planks);
        stairsBlock((StairBlock)ModBlocks.CINNAMON_STAIRS.get(), cinnamon_planks);
        doorBlock((DoorBlock)ModBlocks.CINNAMON_DOOR.get(), 
            new ResourceLocation(CooksKitchen.MODID, "block/cinnamon_door_bottom"), 
            new ResourceLocation(CooksKitchen.MODID, "block/cinnamon_door_top"));
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

        horizontalBlock(ModBlocks.AUTO_BLOWTORCH.get(), getAutoBlowtorchModel());
        // horizontalBlock(ModBlocks.CARAMELISER.get(), getCarameliserModel());
    }

    public void createParents() {
        createPetalCarpetParent();
    }

    public BlockModelBuilder petalCarpet(String name, ResourceLocation petal) {
        return models().singleTexture(name, new ResourceLocation(CooksKitchen.MODID, "block/petal_carpet"), "petal", petal);
    }

    public BlockModelBuilder flowerPotCross(String name, Block plant) {
        return models().withExistingParent(name, "flower_pot_cross").texture("plant", "block/" + plant.getRegistryName().getPath());
    }

    public BlockModelBuilder fruitTreeBlock(String name, String parent, String fruitTexture) {
        return models().withExistingParent(name, new ResourceLocation(CooksKitchen.MODID, parent))
        .texture("leaves", new ResourceLocation(CooksKitchen.MODID, "block/fruit_tree_leaves"))
        .texture("stem", new ResourceLocation(CooksKitchen.MODID, "block/fruit_tree_stem"))
        .texture("fruit", new ResourceLocation(CooksKitchen.MODID, fruitTexture));
    }

    public BlockModelBuilder getAutoBlowtorchModel() {
        Block block = ModBlocks.AUTO_BLOWTORCH.get();
        String name = block.getRegistryName().getPath();

        BlockModelBuilder builder = models().getBuilder(name);

        builder.texture("1", new ResourceLocation(CooksKitchen.MODID, "block/auto_blowtorch"));
        builder.texture("particle", new ResourceLocation("block/glass"));

        builder.transforms()
                .transform(Perspective.THIRDPERSON_RIGHT).rotation(75, 45, 0).translation(0, 2.5f, 0).scale(0.375f, 0.375f, 0.375f).end()
                .transform(Perspective.THIRDPERSON_LEFT).rotation(75, 315, 0).translation(0, 2.5f, 0).scale(0.375f, 0.375f, 0.375f).end()
                .transform(Perspective.FIRSTPERSON_RIGHT).rotation(0, 45, 0).scale(0.4f, 0.4f, 0.4f).end()
                .transform(Perspective.FIRSTPERSON_LEFT).rotation(0, 225, 0).scale(0.4f, 0.4f, 0.4f).end()
                .transform(Perspective.GROUND).translation(0, 3, 0).scale(0.25f, 0.25f, 0.25f).end()
                .transform(Perspective.GUI).rotation(30, 225, 0).scale(0.625f, 0.625f, 0.625f).end()
                .transform(Perspective.FIXED).scale(0.5f, 0.5f, 0.5f).end()
                .end();

            //torch
            //base
        builder.element().from(1.75f, 3f, 6.25f).to(5.25f, 3.5f, 9.75f)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(14f, 15.75f, 15.75f, 16f).texture("#1").end()
                .face(Direction.EAST).uvs(14f, 15.75f, 15.75f, 16f).texture("#1").end()
                .face(Direction.SOUTH).uvs(14f, 15.75f, 15.75f, 16f).texture("#1").end()
                .face(Direction.WEST).uvs(14f, 15.75f, 15.75f, 16f).texture("#1").end()
                .face(Direction.UP).uvs(14f, 15.75f, 15.75f, 16f).texture("#1").rotation(FaceRotation.CLOCKWISE_90).end()
                .face(Direction.DOWN).uvs(14f, 15.75f, 15.75f, 16f).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();
            //stem
        builder.element().from(2.25f, 3.5f, 6.75f).to(4.75f, 7.5f, 9.25f)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(14.25f, 13.75f, 15.5f, 15.75f).texture("#1").end()
                .face(Direction.EAST).uvs(14.25f, 13.75f, 14.5f, 15.75f).texture("#1").end()
                .face(Direction.SOUTH).uvs(14.25f, 13.75f, 15.5f, 15.75f).texture("#1").end()
                .face(Direction.WEST).uvs(15.25f, 13.75f, 15.5f, 15.75f).texture("#1").end()
                .face(Direction.UP).uvs(14.25f, 13.75f, 15.5f, 14f).texture("#1").rotation(FaceRotation.CLOCKWISE_90).end()
                .face(Direction.DOWN).uvs(14.25f, 15.5f, 15.5f, 15.75f).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();
            //top1
        builder.element().from(2.25f, 7.5f, 6.75f).to(5.25f, 8f, 9.25f)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(14f, 13.5f, 15.5f, 13.75f).texture("#1").end()
                .face(Direction.EAST).uvs(14f, 13.5f, 14.25f, 13.75f).texture("#1").end()
                .face(Direction.SOUTH).uvs(14f, 13.5f, 15.5f, 13.75f).texture("#1").rotation(FaceRotation.UPSIDE_DOWN).end()
                .face(Direction.WEST).uvs(15.5f, 13.5f, 15.25f, 13.75f).texture("#1").end()
                .face(Direction.UP).uvs(14f, 13.5f, 15.5f, 13.75f).texture("#1").rotation(FaceRotation.CLOCKWISE_90).end()
                .face(Direction.DOWN).uvs(14f, 13.5f, 15.5f, 13.75f).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();
            //top2
        builder.element().from(2.25f, 8f, 6.75f).to(5.75f, 8.5f, 9.25f)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(13.75f, 13.25f, 15.5f, 13.5f).texture("#1").end()
                .face(Direction.EAST).uvs(13.75f, 13.25f, 14f, 13.5f).texture("#1").end()
                .face(Direction.SOUTH).uvs(13.75f, 13.25f, 15.5f, 13.5f).texture("#1").rotation(FaceRotation.UPSIDE_DOWN).end()
                .face(Direction.WEST).uvs(15.25f, 13.25f, 15.5f, 13.5f).texture("#1").end()
                .face(Direction.UP).uvs(13.75f, 13.25f, 14f, 13.5f).texture("#1").rotation(FaceRotation.CLOCKWISE_90).end()
                .face(Direction.DOWN).uvs(13.75f, 13.25f, 14f, 13.5f).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();
            //top3
        builder.element().from(2.25f, 8.5f, 6.75f).to(6.25f, 9.5f, 9.25f)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(13.5f, 12.5f, 15.25f, 12.75f).texture("#1").end()
                .face(Direction.EAST).uvs(13.5f, 12.75f, 13.75f, 13.25f).texture("#1").end()
                .face(Direction.SOUTH).uvs(15.5f, 12.75f, 13.5f, 13.25f).texture("#1").end()
                .face(Direction.WEST).uvs(15.25f, 12.75f, 15.5f, 13.25f).texture("#1").end()
                .face(Direction.UP).uvs(13.5f, 12.5f, 15.25f, 12.75f).texture("#1").rotation(FaceRotation.UPSIDE_DOWN).end()
                .face(Direction.DOWN).uvs(13.5f, 12.75f, 13.75f, 13.25f).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();
            //top4
        builder.element().from(2.75f, 9.5f, 6.75f).to(6.25f, 10f, 9.25f)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(13.5f, 12.5f, 15.25f, 12.75f).texture("#1").end()
                .face(Direction.EAST).uvs(13.5f, 12.5f, 13.75f, 12.75f).texture("#1").end()
                .face(Direction.SOUTH).uvs(15.25f, 12.5f, 13.5f, 12.75f).texture("#1").end()
                .face(Direction.WEST).uvs(15f, 12.5f, 15.25f, 12.75f).texture("#1").end()
                .face(Direction.UP).uvs(13.5f, 12.5f, 15.25f, 12.75f).texture("#1").rotation(FaceRotation.UPSIDE_DOWN).end()
                .face(Direction.DOWN).uvs(13.5f, 12.5f, 13.75f, 12.75f).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();
            //top5
        builder.element().from(3.25f, 10, 6.75f).to(5.75f, 10.5f, 9.25f)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(13.75f, 12.25f, 15f, 12.5f).texture("#1").end()
                .face(Direction.EAST).uvs(13.75f, 12.25f, 14f, 12.5f).texture("#1").end()
                .face(Direction.SOUTH).uvs(15f, 12.25f, 13.75f, 12.5f).texture("#1").end()
                .face(Direction.WEST).uvs(14.75f, 12.25f, 15f, 12.5f).texture("#1").end()
                .face(Direction.UP).uvs(13.75f, 12.25f, 15f, 12.5f).texture("#1").rotation(FaceRotation.UPSIDE_DOWN).end()
                .face(Direction.DOWN).uvs(13.75f, 12.25f, 14f, 12.5f).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();
            //flame1
        builder.element().from(6.25f, 9, 6.75f).to(7.75f, 10, 9.25f)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(12.75f, 12.5f, 13.5f, 13).texture("#1").end()
                .face(Direction.EAST).uvs(12.75f, 12.5f, 13, 13).texture("#1").end()
                .face(Direction.SOUTH).uvs(13.5f, 12.5f, 12.75f, 13).texture("#1").end()
                .face(Direction.WEST).uvs(13.25f, 12.5f, 13.5f, 13).texture("#1").end()
                .face(Direction.UP).uvs(12.75f, 12.5f, 13.5f, 12.75f).texture("#1").rotation(FaceRotation.UPSIDE_DOWN).end()
                .face(Direction.DOWN).uvs(12.75f, 12.75f, 13.5f, 13).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();
            //flame2
        builder.element().from(6.75f, 8, 6.75f).to(8.75f, 9, 9.25f)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(12.25f, 13, 13.25f, 13.5f).texture("#1").end()
                .face(Direction.EAST).uvs(12.25f, 13, 12.5f, 13.5f).texture("#1").end()
                .face(Direction.SOUTH).uvs(13.25f, 13, 12.25f, 13.5f).texture("#1").end()
                .face(Direction.WEST).uvs(12.25f, 13, 13.25f, 13.5f).texture("#1").end()
                .face(Direction.UP).uvs(12.25f, 13, 13.25f, 13.5f).texture("#1").rotation(FaceRotation.UPSIDE_DOWN).end()
                .face(Direction.DOWN).uvs(12.25f, 13, 13.25f, 13.5f).texture("#1").rotation(FaceRotation.UPSIDE_DOWN).end()
                .end();
            //flame3
        builder.element().from(7.75f, 9, 6.75f).to(8.25f, 9.5f, 9.25f)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(12.5f, 12.75f, 12.75f, 13).texture("#1").end()
                .face(Direction.EAST).uvs(12.5f, 12.75f, 12.75f, 13).texture("#1").end()
                .face(Direction.SOUTH).uvs(12.75f, 12.75f, 12.5f, 13).texture("#1").end()
                .face(Direction.WEST).uvs(12.5f, 12.75f, 12.75f, 13).texture("#1").end()
                .face(Direction.UP).uvs(12.5f, 12.75f, 12.75f, 13).texture("#1").rotation(FaceRotation.UPSIDE_DOWN).end()
                .face(Direction.DOWN).uvs(12.5f, 12.75f, 12.75f, 13).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();
            //flame4
        builder.element().from(7.25f, 7.5f, 6.75f).to(8.25f, 8, 9.25f)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(12.5f, 13.5f, 13, 13.75f).texture("#1").end()
                .face(Direction.EAST).uvs(12.5f, 13.5f, 12.75f, 13.75f).texture("#1").end()
                .face(Direction.SOUTH).uvs(13, 13.5f, 12.5f, 13.75f).texture("#1").end()
                .face(Direction.WEST).uvs(12.75f, 13.5f, 13, 13.75f).texture("#1").end()
                .face(Direction.UP).uvs(12.5f, 13.5f, 13, 13.75f).texture("#1").rotation(FaceRotation.UPSIDE_DOWN).end()
                .face(Direction.DOWN).uvs(12.5f, 13.5f, 13, 13.75f).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();

            //outer
            //main
        builder.element().from(0.25f, 0.25f, 0.25f).to(15.75f, 15.75f, 15.75f)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(3.75f, 3.75f, 7.5f, 7.5f).texture("#1").end()
                .face(Direction.EAST).uvs(0, 3.75f, 3.75f, 7.5f).texture("#1").end()
                .face(Direction.SOUTH).uvs(11.25f, 3.75f, 15, 7.5f).texture("#1").end()
                .face(Direction.WEST).uvs(7.5f, 3.75f, 11.25f, 7.5f).texture("#1").end()
                .face(Direction.UP).uvs(3.75f, 0, 7.5f, 3.75f).texture("#1").rotation(FaceRotation.CLOCKWISE_90).end()
                .face(Direction.DOWN).uvs(7.5f, 0, 11.25f, 3.75f).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();

        builder.element().from(0, 0, 0).to(16, 1, 1)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(4.25f, 11.75f, 8.25f, 12).texture("#1").end()
                .face(Direction.EAST).uvs(8.25f, 11.75f, 8.5f, 12).texture("#1").end()
                .face(Direction.SOUTH).uvs(0, 11.75f, 4, 12).texture("#1").end()
                .face(Direction.WEST).uvs(4, 11.75f, 4.25f, 12).texture("#1").end()
                .face(Direction.UP).uvs(4, 7.75f, 4.25f, 11.75f).texture("#1").rotation(FaceRotation.CLOCKWISE_90).end()
                .face(Direction.DOWN).uvs(4.25f, 7.75f, 4.5f, 11.75f).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();

        builder.element().from(15, 0, 1).to(16, 1, 16)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(4, 11.75f, 4.25f, 12).texture("#1").end()
                .face(Direction.EAST).uvs(0, 11.75f, 3.75f, 12).texture("#1").end()
                .face(Direction.SOUTH).uvs(8.25f, 11.75f, 8.5f, 12).texture("#1").end()
                .face(Direction.WEST).uvs(0.25f, 11.75f, 4, 12).texture("#1").end()
                .face(Direction.UP).uvs(0.25f, 12, 4, 11.75f).texture("#1").rotation(FaceRotation.CLOCKWISE_90).end()
                .face(Direction.DOWN).uvs(0.25f, 11.75f, 4, 12).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();

        builder.element().from(0, 0, 15).to(15, 1, 16)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(4.5f, 12, 8.25f, 11.75f).texture("#1").end()
                .face(Direction.EAST).uvs(8.25f, 11.75f, 8.5f, 12).texture("#1").end()
                .face(Direction.SOUTH).uvs(0, 11.75f, 3.75f, 12).texture("#1").end()
                .face(Direction.WEST).uvs(4, 11.75f, 4.25f, 12).texture("#1").end()
                .face(Direction.UP).uvs(4, 8, 4.25f, 11.75f).texture("#1").rotation(FaceRotation.CLOCKWISE_90).end()
                .face(Direction.DOWN).uvs(4.25f, 7.75f, 4.5f, 11.5f).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();
            
        builder.element().from(0, 0, 1).to(1, 1, 15)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(3.75f, 11.75f, 4, 12).texture("#1").end()
                .face(Direction.EAST).uvs(0.25f, 11.75f, 3.75f, 12).texture("#1").end()
                .face(Direction.SOUTH).uvs(8.25f, 11.75f, 8.5f, 12).texture("#1").end()
                .face(Direction.WEST).uvs(0.25f, 11.75f, 3.75f, 12).texture("#1").end()
                .face(Direction.UP).uvs(4.5f, 11.75f, 8, 12).texture("#1").rotation(FaceRotation.CLOCKWISE_90).end()
                .face(Direction.DOWN).uvs(4.5f, 11.75f, 8, 12).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();

        builder.element().from(0, 15, 15).to(15, 16, 16)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(4.5f, 12, 8.25f, 11.75f).texture("#1").end()
                .face(Direction.EAST).uvs(8.25f, 11.75f, 8.5f, 12).texture("#1").end()
                .face(Direction.SOUTH).uvs(0, 11.75f, 3.75f, 12).texture("#1").end()
                .face(Direction.WEST).uvs(4, 11.75f, 4.25f, 12).texture("#1").end()
                .face(Direction.UP).uvs(4, 8, 4.25f, 11.75f).texture("#1").rotation(FaceRotation.CLOCKWISE_90).end()
                .face(Direction.DOWN).uvs(4.25f, 7.75f, 4.5f, 11.5f).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();
            
        builder.element().from(15, 15, 1).to(16, 16, 16)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(4, 11.75f, 4.25f, 12).texture("#1").end()
                .face(Direction.EAST).uvs(0, 11.75f, 3.75f, 12).texture("#1").end()
                .face(Direction.SOUTH).uvs(8.25f, 11.75f, 8.5f, 12).texture("#1").end()
                .face(Direction.WEST).uvs(0.25f, 11.75f, 4, 12).texture("#1").end()
                .face(Direction.UP).uvs(0.25f, 12, 4, 11.75f).texture("#1").rotation(FaceRotation.CLOCKWISE_90).end()
                .face(Direction.DOWN).uvs(0.25f, 11.75f, 4, 12).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();

        builder.element().from(0, 15, 0).to(16, 16, 1)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(4.25f, 11.75f, 8.25f, 12).texture("#1").end()
                .face(Direction.EAST).uvs(8.25f, 11.75f, 8.5f, 12).texture("#1").end()
                .face(Direction.SOUTH).uvs(0, 11.75f, 4, 12).texture("#1").end()
                .face(Direction.WEST).uvs(4, 11.75f, 4.25f, 12).texture("#1").end()
                .face(Direction.UP).uvs(4, 7.75f, 4.25f, 11.75f).texture("#1").rotation(FaceRotation.CLOCKWISE_90).end()
                .face(Direction.DOWN).uvs(4.25f, 7.75f, 4.5f, 11.75f).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();

        builder.element().from(0, 15, 1).to(1, 16, 15)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(3.75f, 11.75f, 4, 12).texture("#1").end()
                .face(Direction.EAST).uvs(0.25f, 11.75f, 3.75f, 12).texture("#1").end()
                .face(Direction.SOUTH).uvs(8.25f, 11.75f, 8.5f, 12).texture("#1").end()
                .face(Direction.WEST).uvs(0.25f, 11.75f, 3.75f, 12).texture("#1").end()
                .face(Direction.UP).uvs(4.5f, 11.75f, 8, 12).texture("#1").rotation(FaceRotation.CLOCKWISE_90).end()
                .face(Direction.DOWN).uvs(4.5f, 11.75f, 8, 12).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();

        builder.element().from(15, 1, 15).to(16, 15, 16)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(4.25f, 8, 4.5f, 11.5f).texture("#1").end()
                .face(Direction.EAST).uvs(4, 8, 4.25f, 11.5f).texture("#1").end()
                .face(Direction.SOUTH).uvs(4.25f, 8, 4.5f, 11.5f).texture("#1").end()
                .face(Direction.WEST).uvs(4, 8, 4.25f, 11.5f).texture("#1").end()
                .face(Direction.UP).uvs(8.25f, 11.75f, 8.5f, 12).texture("#1").rotation(FaceRotation.CLOCKWISE_90).end()
                .face(Direction.DOWN).uvs(4, 11.75f, 4.25f, 12).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();

        builder.element().from(15, 1, 0).to(16, 15, 1)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(4.25f, 8, 4.5f, 11.5f).texture("#1").end()
                .face(Direction.EAST).uvs(4, 8, 4.25f, 11.5f).texture("#1").end()
                .face(Direction.SOUTH).uvs(4.25f, 8, 4.5f, 11.5f).texture("#1").end()
                .face(Direction.WEST).uvs(4, 8, 4.25f, 11.5f).texture("#1").end()
                .face(Direction.UP).uvs(8.25f, 11.75f, 8.5f, 12).texture("#1").rotation(FaceRotation.CLOCKWISE_90).end()
                .face(Direction.DOWN).uvs(4, 11.75f, 4.25f, 12).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();

        builder.element().from(0, 1, 0).to(1, 15, 1)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(4.25f, 8, 4.5f, 11.5f).texture("#1").end()
                .face(Direction.EAST).uvs(4, 8, 4.25f, 11.5f).texture("#1").end()
                .face(Direction.SOUTH).uvs(4.25f, 8, 4.5f, 11.5f).texture("#1").end()
                .face(Direction.WEST).uvs(4, 8, 4.25f, 11.5f).texture("#1").end()
                .face(Direction.UP).uvs(8.25f, 11.75f, 8.5f, 12).texture("#1").rotation(FaceRotation.CLOCKWISE_90).end()
                .face(Direction.DOWN).uvs(4, 11.75f, 4.25f, 12).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();

        builder.element().from(0, 1, 15).to(1, 15, 16)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(4.25f, 8, 4.5f, 11.5f).texture("#1").end()
                .face(Direction.EAST).uvs(4, 8, 4.25f, 11.5f).texture("#1").end()
                .face(Direction.SOUTH).uvs(4.25f, 8, 4.5f, 11.5f).texture("#1").end()
                .face(Direction.WEST).uvs(4, 8, 4.25f, 11.5f).texture("#1").end()
                .face(Direction.UP).uvs(8.25f, 11.75f, 8.5f, 12).texture("#1").rotation(FaceRotation.CLOCKWISE_90).end()
                .face(Direction.DOWN).uvs(4, 11.75f, 4.25f, 12).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();

            //torchStand
        builder.element().from(1.25f, 0, 5.75f).to(5.75f, 3, 10.25f)
                .rotation().angle(0).axis(Axis.Y).origin(8, 8, 8).end()
                .face(Direction.NORTH).uvs(11.5f, 8.5f, 16, 11.5f).texture("#1").end()
                .face(Direction.EAST).uvs(11.5f, 8.5f, 16, 11.5f).texture("#1").end()
                .face(Direction.SOUTH).uvs(11.5f, 8.5f, 16, 11.5f).texture("#1").end()
                .face(Direction.WEST).uvs(11.5f, 8.5f, 16, 11.5f).texture("#1").end()
                .face(Direction.UP).uvs(11.5f, 8.5f, 16, 11.5f).texture("#1").rotation(FaceRotation.CLOCKWISE_90).end()
                .face(Direction.DOWN).uvs(11.5f, 8.5f, 16, 11.5f).texture("#1").rotation(FaceRotation.COUNTERCLOCKWISE_90).end()
                .end();
        
        return builder;
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

            ResourceLocation texture = new ResourceLocation(CooksKitchen.MODID, "block/saw_dust");

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
        .texture("particles", "#petal");
    }

}
