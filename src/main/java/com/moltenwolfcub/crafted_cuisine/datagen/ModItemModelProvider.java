package com.moltenwolfcub.crafted_cuisine.datagen;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

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
            getItemPath(AllItems.CLOAK_SPAWN_EGG.get()), new ResourceLocation("item/template_spawn_egg"));

        withExistingParent(
            getItemPath(AllBlockItems.CINNAMON_BUTTON.get()), 
            new ResourceLocation("block/button_inventory"))
        .texture("texture", new ResourceLocation(
                CraftedCuisine.MODID, "block/" + getItemPath(AllBlockItems.CINNAMON_PLANKS.get()))
        );

        withExistingParent(
            getItemPath(AllBlockItems.CINNAMON_FENCE.get()), 
            new ResourceLocation("block/fence_inventory"))
        .texture("texture", new ResourceLocation(
                CraftedCuisine.MODID, "block/" + getItemPath(AllBlockItems.CINNAMON_PLANKS.get()))
        );

        withExistingParent(
            getItemPath(AllBlockItems.LEMON_TREE.get()),
            new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_inventory"))
        .texture("stem", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_stem"))
        .texture("leaves", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_leaves"))
        .texture("fruit", new ResourceLocation(CraftedCuisine.MODID, "block/lemon_tree_fruit_3"));

        withExistingParent(
            getItemPath(AllBlockItems.LIME_TREE.get()),
            new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_inventory"))
        .texture("stem", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_stem"))
        .texture("leaves", new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_leaves"))
        .texture("fruit", new ResourceLocation(CraftedCuisine.MODID, "block/lime_tree_fruit_3"));

        withExistingParent(
            getItemPath(AllBlockItems.ORANGE_TREE.get()),
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
    private ItemModelBuilder simpleItem(Item item, String path) {
        String itemPath = getItemPath(item);

        return withExistingParent(itemPath, new ResourceLocation("item/generated"))
            .texture("layer0", new ResourceLocation(CraftedCuisine.MODID, path + "/" + itemPath));
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
        simpleItem(AllItems.OAK_BARK.get());
        simpleItem(AllItems.BIRCH_BARK.get());
        simpleItem(AllItems.SPRUCE_BARK.get());
        simpleItem(AllItems.JUNGLE_BARK.get());
        simpleItem(AllItems.ACACIA_BARK.get());
        simpleItem(AllItems.DARK_OAK_BARK.get());
        simpleItem(AllItems.CRIMSON_BARK.get());
        simpleItem(AllItems.WARPED_BARK.get());
        simpleItem(AllItems.CINNAMON_BARK.get());

        simpleItem(AllItems.LEMON.get());
        simpleItem(AllItems.LIME.get());
        simpleItem(AllItems.ORANGE.get());
        simpleItem(AllItems.BLOOD_ORANGE.get());
        simpleItem(AllItems.MERINGUE.get());
        simpleItem(AllItems.CARAMEL.get());

        simpleItem(AllItems.RED_ROSE_PETAL.get());
        simpleItem(AllItems.ORANGE_ROSE_PETAL.get());
        simpleItem(AllItems.YELLOW_ROSE_PETAL.get());
        simpleItem(AllItems.LIME_ROSE_PETAL.get());
        simpleItem(AllItems.GREEN_ROSE_PETAL.get());
        simpleItem(AllItems.BLUE_ROSE_PETAL.get());
        simpleItem(AllItems.CYAN_ROSE_PETAL.get());
        simpleItem(AllItems.LIGHT_BLUE_ROSE_PETAL.get());
        simpleItem(AllItems.PURPLE_ROSE_PETAL.get());
        simpleItem(AllItems.MAGENTA_ROSE_PETAL.get());
        simpleItem(AllItems.PINK_ROSE_PETAL.get());
        simpleItem(AllItems.BLACK_ROSE_PETAL.get());
        simpleItem(AllItems.GRAY_ROSE_PETAL.get());
        simpleItem(AllItems.LIGHT_GRAY_ROSE_PETAL.get());
        simpleItem(AllItems.WHITE_ROSE_PETAL.get());
        simpleItem(AllItems.BROWN_ROSE_PETAL.get());
        simpleItem(AllItems.SUGAR_ROSE_PETAL.get());

        simpleItem(AllBlockItems.CINNAMON_SAPLING.get());
        simpleItem(AllItems.CINNAMON_SIGN.get());
        simpleItem(AllBlockItems.CINNAMON_DOOR.get());
        simpleItem(AllItems.CINNAMON.get());

        simpleItem(AllBlockItems.FLOWER_STEM.get());
        simpleItem(AllBlockItems.PINK_ROSE.get());

        simpleItem(AllItems.RAW_MERINGUE.get());
        simpleItem(AllItems.EGG_WHITE.get());
        simpleItem(AllItems.EGG_YOLK.get());
        simpleItem(AllItems.CRUSHED_CINNAMON.get());
        simpleItem(AllItems.BUTTER.get());
        simpleItem(AllItems.CREAM.get());

        simpleItem(AllItems.PAPER_PULP.get());
        simpleItem(AllBlockItems.SAW_DUST.get());

        simpleItem(AllItems.CARAMEL_BUCKET.get());

        simpleItem(AllItems.REINFORCED_BLACKSTONE_INGOT.get());
        simpleItem(AllItems.REINFORCED_BLACKSTONE_NUGGET.get());
        simpleItem(AllItems.REINFORCED_BLACKSTONE_STICK.get());

        simpleItem(AllBlockItems.REINFORCED_BLACKSTONE_DOOR.get());
        simpleItem(AllBlockItems.REINFORCED_BLACKSTONE_LADDER.get(), "block");
        simpleItem(AllBlockItems.REINFORCED_BLACKSTONE_LEVER.get(), "block");
        simpleItem(AllBlockItems.REINFORCED_BLACKSTONE_BARS.get(), "block");

        simpleItem(AllItems.REINFORCED_BLACKSTONE_BOOTS.get());
        simpleItem(AllItems.REINFORCED_BLACKSTONE_LEGGINGS.get());
        simpleItem(AllItems.REINFORCED_BLACKSTONE_CHESTPLATE.get());
        simpleItem(AllItems.REINFORCED_BLACKSTONE_HELMET.get());
    }

    private void registerHandheldItems() {
        handheldItem(AllItems.BLOW_TORCH.get());
        handheldItem(AllItems.BARK_REMOVER.get());
        handheldItem(AllItems.WHISK.get());
        handheldItem(AllItems.FLOWER_SEPERATOR.get());

        handheldItem(AllItems.REINFORCED_BLACKSTONE_SWORD.get());
        handheldItem(AllItems.REINFORCED_BLACKSTONE_PICKAXE.get());
        handheldItem(AllItems.REINFORCED_BLACKSTONE_AXE.get());
        handheldItem(AllItems.REINFORCED_BLACKSTONE_SHOVEL.get());
        handheldItem(AllItems.REINFORCED_BLACKSTONE_HOE.get());
    }

    private void registerBlockItems() {
        blockItem(AllBlockItems.AUTO_BLOWTORCH.get());
        blockItem(AllBlockItems.CARAMELISER.get());

        blockItem(AllBlockItems.RED_ROSE_CARPET.get());
        blockItem(AllBlockItems.ORANGE_ROSE_CARPET.get());
        blockItem(AllBlockItems.YELLOW_ROSE_CARPET.get());
        blockItem(AllBlockItems.LIME_ROSE_CARPET.get());
        blockItem(AllBlockItems.GREEN_ROSE_CARPET.get());
        blockItem(AllBlockItems.BLUE_ROSE_CARPET.get());
        blockItem(AllBlockItems.CYAN_ROSE_CARPET.get());
        blockItem(AllBlockItems.LIGHT_BLUE_ROSE_CARPET.get());
        blockItem(AllBlockItems.PURPLE_ROSE_CARPET.get());
        blockItem(AllBlockItems.MAGENTA_ROSE_CARPET.get());
        blockItem(AllBlockItems.PINK_ROSE_CARPET.get());
        blockItem(AllBlockItems.BLACK_ROSE_CARPET.get());
        blockItem(AllBlockItems.GRAY_ROSE_CARPET.get());
        blockItem(AllBlockItems.LIGHT_GRAY_ROSE_CARPET.get());
        blockItem(AllBlockItems.WHITE_ROSE_CARPET.get());
        blockItem(AllBlockItems.BROWN_ROSE_CARPET.get());

        blockItem(AllBlockItems.CINNAMON_FENCE_GATE.get());
        blockItem(AllBlockItems.CINNAMON_LEAVES.get());
        blockItem(AllBlockItems.CINNAMON_LOG.get());
        blockItem(AllBlockItems.CINNAMON_WOOD.get());
        blockItem(AllBlockItems.STRIPPED_CINNAMON_LOG.get());
        blockItem(AllBlockItems.STRIPPED_CINNAMON_WOOD.get());
        blockItem(AllBlockItems.CINNAMON_PLANKS.get());
        blockItem(AllBlockItems.CINNAMON_PRESSURE_PLATE.get());
        blockItem(AllBlockItems.CINNAMON_SLAB.get());
        blockItem(AllBlockItems.CINNAMON_STAIRS.get());
        blockItem(AllBlockItems.CINNAMON_TRAPDOOR.get(), "cinnamon_trapdoor_bottom");

        blockItem(AllBlockItems.REINFORCED_BLACKSTONE_TRAPDOOR.get(), "reinforced_blackstone_trapdoor_bottom");
        blockItem(AllBlockItems.REINFORCED_BLACKSTONE.get());
        blockItem(AllBlockItems.REINFORCED_BLACKSTONE_ROD.get());
    }

}
