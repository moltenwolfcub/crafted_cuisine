package com.moltenwolfcub.cooks_kitchen.datagen;

import com.moltenwolfcub.cooks_kitchen.CooksKitchen;
import com.moltenwolfcub.cooks_kitchen.init.ModBlocks;

import net.minecraft.core.Direction;
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
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
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
