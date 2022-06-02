package com.moltenwolfcub.crafted_cuisine.datagen;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.ModBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.ModItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, CraftedCuisine.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        registerSimpleItems();
        registerHandheldItems();
        registerBlockItems();

        withExistingParent(
            getItemPath(ModBlockItems.CINNAMON_BUTTON_BLOCK_ITEM.get()), 
            new ResourceLocation("block/button_inventory"))
        .texture("texture", new ResourceLocation(
                CraftedCuisine.MODID, "block/" + getItemPath(ModBlockItems.CINNAMON_PLANKS_BLOCK_ITEM.get()))
        );

        withExistingParent(
            getItemPath(ModBlockItems.CINNAMON_FENCE_BLOCK_ITEM.get()), 
            new ResourceLocation("block/fence_inventory"))
        .texture("texture", new ResourceLocation(
                CraftedCuisine.MODID, "block/" + getItemPath(ModBlockItems.CINNAMON_PLANKS_BLOCK_ITEM.get()))
        );

        withExistingParent(
            getItemPath(ModBlockItems.LEMON_TREE_BLOCK_ITEM.get()),
            new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_inventory"))
        .texture("stem", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_stem"))
        .texture("leaves", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_leaves"))
        .texture("fruit", new ResourceLocation(CraftedCuisine.MODID, "block/lemon_tree_fruit_3"));

        withExistingParent(
            getItemPath(ModBlockItems.LIME_TREE_BLOCK_ITEM.get()),
            new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_inventory"))
        .texture("stem", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_stem"))
        .texture("leaves", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_leaves"))
        .texture("fruit", new ResourceLocation(CraftedCuisine.MODID, "block/lime_tree_fruit_3"));

        withExistingParent(
            getItemPath(ModBlockItems.ORANGE_TREE_BLOCK_ITEM.get()),
            new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_inventory"))
        .texture("stem", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_stem"))
        .texture("leaves", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_leaves"))
        .texture("fruit", new ResourceLocation(CraftedCuisine.MODID, "block/orange_tree_fruit_3"));
    }


    private ItemModelBuilder simpleItem(Item item) {
        String itemPath = getItemPath(item);

        return withExistingParent(itemPath, new ResourceLocation("item/generated"))
            .texture("layer0", new ResourceLocation(CraftedCuisine.MODID,"item/" + itemPath));
    }

    private ItemModelBuilder handheldItem(Item item) {
        String itemPath = getItemPath(item);
        return withExistingParent(itemPath, new ResourceLocation("item/handheld"))
            .texture("layer0", new ResourceLocation(CraftedCuisine.MODID,"item/" + itemPath));
    }

    private ItemModelBuilder blockItem(Item item) {
        String itemPath = getItemPath(item);
        return withExistingParent(itemPath, new ResourceLocation(CraftedCuisine.MODID, "block/" + itemPath));
    }

    private ItemModelBuilder blockItem(Item item, String parentName) {
        String itemPath = getItemPath(item);
        return withExistingParent(itemPath, new ResourceLocation(CraftedCuisine.MODID, "block/" + parentName));
    }

    private String getItemPath(Item item){
        return item.getRegistryName().getPath();
    }
   

    private void registerSimpleItems() {
        simpleItem(ModItems.OAK_BARK.get());
        simpleItem(ModItems.BIRCH_BARK.get());
        simpleItem(ModItems.SPRUCE_BARK.get());
        simpleItem(ModItems.JUNGLE_BARK.get());
        simpleItem(ModItems.ACACIA_BARK.get());
        simpleItem(ModItems.DARK_OAK_BARK.get());
        simpleItem(ModItems.CRIMSON_BARK.get());
        simpleItem(ModItems.WARPED_BARK.get());
        simpleItem(ModItems.CINNAMON_BARK.get());

        simpleItem(ModItems.LEMON.get());
        simpleItem(ModItems.LIME.get());
        simpleItem(ModItems.ORANGE.get());
        simpleItem(ModItems.BLOOD_ORANGE.get());
        simpleItem(ModItems.MERINGUE.get());
        simpleItem(ModItems.CARAMEL.get());

        simpleItem(ModItems.RED_ROSE_PETAL.get());
        simpleItem(ModItems.ORANGE_ROSE_PETAL.get());
        simpleItem(ModItems.YELLOW_ROSE_PETAL.get());
        simpleItem(ModItems.LIME_ROSE_PETAL.get());
        simpleItem(ModItems.GREEN_ROSE_PETAL.get());
        simpleItem(ModItems.BLUE_ROSE_PETAL.get());
        simpleItem(ModItems.CYAN_ROSE_PETAL.get());
        simpleItem(ModItems.LIGHT_BLUE_ROSE_PETAL.get());
        simpleItem(ModItems.PURPLE_ROSE_PETAL.get());
        simpleItem(ModItems.MAGENTA_ROSE_PETAL.get());
        simpleItem(ModItems.PINK_ROSE_PETAL.get());
        simpleItem(ModItems.BLACK_ROSE_PETAL.get());
        simpleItem(ModItems.GRAY_ROSE_PETAL.get());
        simpleItem(ModItems.LIGHT_GRAY_ROSE_PETAL.get());
        simpleItem(ModItems.WHITE_ROSE_PETAL.get());
        simpleItem(ModItems.BROWN_ROSE_PETAL.get());
        simpleItem(ModItems.SUGAR_ROSE_PETAL.get());

        simpleItem(ModBlockItems.CINNAMON_SAPLING_BLOCK_ITEM.get());
        simpleItem(ModItems.CINNAMON_SIGN.get());
        simpleItem(ModBlockItems.CINNAMON_DOOR_BLOCK_ITEM.get());
        simpleItem(ModItems.CINNAMON.get());

        simpleItem(ModBlockItems.FLOWER_STEM_BLOCK_ITEM.get());
        simpleItem(ModBlockItems.PINK_ROSE_BLOCK_ITEM.get());

        simpleItem(ModItems.RAW_MERINGUE.get());
        simpleItem(ModItems.EGG_WHITE.get());
        simpleItem(ModItems.EGG_YOLK.get());
        simpleItem(ModItems.CRUSHED_CINNAMON.get());
        simpleItem(ModItems.BUTTER.get());
        simpleItem(ModItems.CREAM.get());

        simpleItem(ModItems.PAPER_PULP.get());
        simpleItem(ModBlockItems.SAW_DUST_BLOCK_ITEM.get());

        simpleItem(ModItems.CARAMEL_BUCKET.get());
    }

    private void registerHandheldItems() {
        handheldItem(ModItems.BLOW_TORCH.get());
        handheldItem(ModItems.BARK_REMOVER.get());
        handheldItem(ModItems.WHISK.get());
    }

    private void registerBlockItems() {
        blockItem(ModBlockItems.AUTO_BLOWTORCH_BLOCK_ITEM.get());
        blockItem(ModBlockItems.CARAMELISER_BLOCK_ITEM.get());

        blockItem(ModBlockItems.RED_ROSE_CARPET_BLOCK_ITEM.get());
        blockItem(ModBlockItems.ORANGE_ROSE_CARPET_BLOCK_ITEM.get());
        blockItem(ModBlockItems.YELLOW_ROSE_CARPET_BLOCK_ITEM.get());
        blockItem(ModBlockItems.LIME_ROSE_CARPET_BLOCK_ITEM.get());
        blockItem(ModBlockItems.GREEN_ROSE_CARPET_BLOCK_ITEM.get());
        blockItem(ModBlockItems.BLUE_ROSE_CARPET_BLOCK_ITEM.get());
        blockItem(ModBlockItems.CYAN_ROSE_CARPET_BLOCK_ITEM.get());
        blockItem(ModBlockItems.LIGHT_BLUE_ROSE_CARPET_BLOCK_ITEM.get());
        blockItem(ModBlockItems.PURPLE_ROSE_CARPET_BLOCK_ITEM.get());
        blockItem(ModBlockItems.MAGENTA_ROSE_CARPET_BLOCK_ITEM.get());
        blockItem(ModBlockItems.PINK_ROSE_CARPET_BLOCK_ITEM.get());
        blockItem(ModBlockItems.BLACK_ROSE_CARPET_BLOCK_ITEM.get());
        blockItem(ModBlockItems.GRAY_ROSE_CARPET_BLOCK_ITEM.get());
        blockItem(ModBlockItems.LIGHT_GRAY_ROSE_CARPET_BLOCK_ITEM.get());
        blockItem(ModBlockItems.WHITE_ROSE_CARPET_BLOCK_ITEM.get());
        blockItem(ModBlockItems.BROWN_ROSE_CARPET_BLOCK_ITEM.get());

        blockItem(ModBlockItems.CINNAMON_FENCE_GATE_BLOCK_ITEM.get());
        blockItem(ModBlockItems.CINNAMON_LEAVES_BLOCK_ITEM.get());
        blockItem(ModBlockItems.CINNAMON_LOG_BLOCK_ITEM.get());
        blockItem(ModBlockItems.CINNAMON_WOOD_BLOCK_ITEM.get());
        blockItem(ModBlockItems.STRIPPED_CINNAMON_LOG_BLOCK_ITEM.get());
        blockItem(ModBlockItems.STRIPPED_CINNAMON_WOOD_BLOCK_ITEM.get());
        blockItem(ModBlockItems.CINNAMON_PLANKS_BLOCK_ITEM.get());
        blockItem(ModBlockItems.CINNAMON_PRESSURE_PLATE_BLOCK_ITEM.get());
        blockItem(ModBlockItems.CINNAMON_SLAB_BLOCK_ITEM.get());
        blockItem(ModBlockItems.CINNAMON_STAIRS_BLOCK_ITEM.get());
        blockItem(ModBlockItems.CINNAMON_TRAPDOOR_BLOCK_ITEM.get(), "cinnamon_trapdoor_bottom");
    }

}
