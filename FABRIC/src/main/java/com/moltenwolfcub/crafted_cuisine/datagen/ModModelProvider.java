package com.moltenwolfcub.crafted_cuisine.datagen;

import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        registerSimpleItems(itemModelGenerator);
        registerHandheldItems(itemModelGenerator);
        registerBlockItems(itemModelGenerator);

        // withExistingParent(
        //     getItemPath(AllItems.CLOAK_SPAWN_EGG), new ResourceLocation("item/template_spawn_egg"));

        // withExistingParent(
        //     getItemPath(AllBlockItems.CINNAMON_BUTTON), 
        //     new ResourceLocation("block/button_inventory"))
        // .texture("texture", new ResourceLocation(
        //         CraftedCuisine.MODID, "block/" + getItemPath(AllBlockItems.CINNAMON_PLANKS))
        // );

        // withExistingParent(
        //     getItemPath(AllBlockItems.CINNAMON_FENCE), 
        //     new ResourceLocation("block/fence_inventory"))
        // .texture("texture", new ResourceLocation(
        //         CraftedCuisine.MODID, "block/" + getItemPath(AllBlockItems.CINNAMON_PLANKS))
        // );

        // withExistingParent(
        //     getItemPath(AllBlockItems.LEMON_TREE),
        //     new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_inventory"))
        // .texture("stem", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_stem"))
        // .texture("leaves", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_leaves"))
        // .texture("fruit", new ResourceLocation(CraftedCuisine.MODID, "block/lemon_tree_fruit_3"));

        // withExistingParent(
        //     getItemPath(AllBlockItems.LIME_TREE),
        //     new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_inventory"))
        // .texture("stem", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_stem"))
        // .texture("leaves", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_leaves"))
        // .texture("fruit", new ResourceLocation(CraftedCuisine.MODID, "block/lime_tree_fruit_3"));

        // withExistingParent(
        //     getItemPath(AllBlockItems.ORANGE_TREE),
        //     new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_inventory"))
        // .texture("stem", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_stem"))
        // .texture("leaves", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_leaves"))
        // .texture("fruit", new ResourceLocation(CraftedCuisine.MODID, "block/orange_tree_fruit_3"));
    }

    private void registerSimpleItems(ItemModelGenerator modelGen) {
        modelGen.register(AllItems.OAK_BARK, Models.GENERATED);
        modelGen.register(AllItems.BIRCH_BARK, Models.GENERATED);
        modelGen.register(AllItems.SPRUCE_BARK, Models.GENERATED);
        modelGen.register(AllItems.JUNGLE_BARK, Models.GENERATED);
        modelGen.register(AllItems.ACACIA_BARK, Models.GENERATED);
        modelGen.register(AllItems.DARK_OAK_BARK, Models.GENERATED);
        modelGen.register(AllItems.CRIMSON_BARK, Models.GENERATED);
        modelGen.register(AllItems.WARPED_BARK, Models.GENERATED);
        modelGen.register(AllItems.CINNAMON_BARK, Models.GENERATED);
        modelGen.register(AllItems.UNKNOWN_BARK, Models.GENERATED);

        modelGen.register(AllItems.LEMON, Models.GENERATED);
        modelGen.register(AllItems.LIME, Models.GENERATED);
        modelGen.register(AllItems.ORANGE, Models.GENERATED);
        modelGen.register(AllItems.BLOOD_ORANGE, Models.GENERATED);
        modelGen.register(AllItems.MERINGUE, Models.GENERATED);
        modelGen.register(AllItems.CARAMEL, Models.GENERATED);

        modelGen.register(AllItems.RED_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.ORANGE_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.YELLOW_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.LIME_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.GREEN_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.BLUE_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.CYAN_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.LIGHT_BLUE_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.PURPLE_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.MAGENTA_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.PINK_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.BLACK_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.GRAY_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.LIGHT_GRAY_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.WHITE_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.BROWN_ROSE_PETAL, Models.GENERATED);
        modelGen.register(AllItems.SUGAR_ROSE_PETAL, Models.GENERATED);

        // modelGen.register(AllBlockItems.CINNAMON_SAPLING, Models.GENERATED);
        // modelGen.register(AllItems.CINNAMON_SIGN, Models.GENERATED);
        // modelGen.register(AllBlockItems.CINNAMON_DOOR, Models.GENERATED);
        modelGen.register(AllItems.CINNAMON, Models.GENERATED);

        // modelGen.register(AllBlockItems.FLOWER_STEM, Models.GENERATED);
        // modelGen.register(AllBlockItems.PINK_ROSE, Models.GENERATED);

        modelGen.register(AllItems.RAW_MERINGUE, Models.GENERATED);
        modelGen.register(AllItems.EGG_WHITE, Models.GENERATED);
        modelGen.register(AllItems.EGG_YOLK, Models.GENERATED);
        modelGen.register(AllItems.CRUSHED_CINNAMON, Models.GENERATED);
        modelGen.register(AllItems.BUTTER, Models.GENERATED);
        modelGen.register(AllItems.CREAM, Models.GENERATED);

        modelGen.register(AllItems.PAPER_PULP, Models.GENERATED);
        // modelGen.register(AllBlockItems.SAW_DUST, Models.GENERATED);

        // modelGen.register(AllItems.CARAMEL_BUCKET, Models.GENERATED);

        modelGen.register(AllItems.REINFORCED_BLACKSTONE_INGOT, Models.GENERATED);
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_NUGGET, Models.GENERATED);
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_STICK, Models.GENERATED);
        // modelGen.register(AllItems.REINFORCED_BLACKSTONE_SHARD, Models.GENERATED);

        // modelGen.register(AllBlockItems.REINFORCED_BLACKSTONE_DOOR, Models.GENERATED);
        // modelGen.register(AllBlockItems.REINFORCED_BLACKSTONE_LADDER, Models.GENERATED, "block");
        // modelGen.register(AllBlockItems.REINFORCED_BLACKSTONE_LEVER, Models.GENERATED, "block");
        // modelGen.register(AllBlockItems.REINFORCED_BLACKSTONE_BARS, Models.GENERATED, "block");

        modelGen.register(AllItems.REINFORCED_BLACKSTONE_BOOTS, Models.GENERATED);
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_LEGGINGS, Models.GENERATED);
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_CHESTPLATE, Models.GENERATED);
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_HELMET, Models.GENERATED);
    }

    private void registerHandheldItems(ItemModelGenerator modelGen) {
        // handheldItem(AllItems.BLOW_TORCH);
        // handheldItem(AllItems.BARK_REMOVER);
        // handheldItem(AllItems.WHISK);
        // handheldItem(AllItems.FLOWER_SEPERATOR);
        
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_SWORD, Models.HANDHELD);
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_PICKAXE, Models.HANDHELD);
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_AXE, Models.HANDHELD);
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_SHOVEL, Models.HANDHELD);
        modelGen.register(AllItems.REINFORCED_BLACKSTONE_HOE, Models.HANDHELD);
    }

    private void registerBlockItems(ItemModelGenerator modelGen) {
        // blockItem(AllBlockItems.AUTO_BLOWTORCH);
        // blockItem(AllBlockItems.CARAMELISER);

        // blockItem(AllBlockItems.RED_ROSE_CARPET);
        // blockItem(AllBlockItems.ORANGE_ROSE_CARPET);
        // blockItem(AllBlockItems.YELLOW_ROSE_CARPET);
        // blockItem(AllBlockItems.LIME_ROSE_CARPET);
        // blockItem(AllBlockItems.GREEN_ROSE_CARPET);
        // blockItem(AllBlockItems.BLUE_ROSE_CARPET);
        // blockItem(AllBlockItems.CYAN_ROSE_CARPET);
        // blockItem(AllBlockItems.LIGHT_BLUE_ROSE_CARPET);
        // blockItem(AllBlockItems.PURPLE_ROSE_CARPET);
        // blockItem(AllBlockItems.MAGENTA_ROSE_CARPET);
        // blockItem(AllBlockItems.PINK_ROSE_CARPET);
        // blockItem(AllBlockItems.BLACK_ROSE_CARPET);
        // blockItem(AllBlockItems.GRAY_ROSE_CARPET);
        // blockItem(AllBlockItems.LIGHT_GRAY_ROSE_CARPET);
        // blockItem(AllBlockItems.WHITE_ROSE_CARPET);
        // blockItem(AllBlockItems.BROWN_ROSE_CARPET);

        // blockItem(AllBlockItems.CINNAMON_FENCE_GATE);
        // blockItem(AllBlockItems.CINNAMON_LEAVES);
        // blockItem(AllBlockItems.CINNAMON_LOG);
        // blockItem(AllBlockItems.CINNAMON_WOOD);
        // blockItem(AllBlockItems.STRIPPED_CINNAMON_LOG);
        // blockItem(AllBlockItems.STRIPPED_CINNAMON_WOOD);
        // blockItem(AllBlockItems.CINNAMON_PLANKS);
        // blockItem(AllBlockItems.CINNAMON_PRESSURE_PLATE);
        // blockItem(AllBlockItems.CINNAMON_SLAB);
        // blockItem(AllBlockItems.CINNAMON_STAIRS);
        // blockItem(AllBlockItems.CINNAMON_TRAPDOOR, "cinnamon_trapdoor_bottom");

        // blockItem(AllBlockItems.REINFORCED_BLACKSTONE_TRAPDOOR, "reinforced_blackstone_trapdoor_bottom");
        // blockItem(AllBlockItems.REINFORCED_BLACKSTONE);
        // blockItem(AllBlockItems.REINFORCED_BLACKSTONE_ROD);
        // blockItem(AllBlockItems.REINFORCED_BLACKSTONE_GRAVEL);
    }
    
}
