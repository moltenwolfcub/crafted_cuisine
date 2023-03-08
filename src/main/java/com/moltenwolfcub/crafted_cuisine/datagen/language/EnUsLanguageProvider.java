package com.moltenwolfcub.crafted_cuisine.datagen.language;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllEffects;
import com.moltenwolfcub.crafted_cuisine.init.AllEntityTypes;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class EnUsLanguageProvider extends FabricLanguageProvider {

    public EnUsLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        addItems(translationBuilder);
        addBlocks(translationBuilder);
        addGui(translationBuilder);
        addSubtitles(translationBuilder);
        addTooltips(translationBuilder);

        translationBuilder.add(AllEntityTypes.CLOAK, "Cloak");
        translationBuilder.add("itemGroup." + CraftedCuisine.MODID, "Crafted Cuisine");
        translationBuilder.add("fluid." + CraftedCuisine.MODID + ".caramel_fluid", "Caramel");
        translationBuilder.add(AllEffects.INVERTED_MOVEMENT, "Dizziness");
    }


    private void addBlocks(TranslationBuilder translationBuilder) {
        translationBuilder.add(AllBlocks.SAW_DUST, "Saw Dust");
        translationBuilder.add(AllBlocks.AUTO_BLOWTORCH, "Auto Blowtorch");
        translationBuilder.add(AllBlocks.CARAMELISER, "Caramelizer");

        addCinnamonPrefixBlock(translationBuilder, AllBlocks.CINNAMON_LOG, "Log");
        addCinnamonPrefixBlock(translationBuilder, AllBlocks.CINNAMON_WOOD, "Wood");
        translationBuilder.add(AllBlocks.STRIPPED_CINNAMON_LOG, "Stripped Cinnamon Log");
        translationBuilder.add(AllBlocks.STRIPPED_CINNAMON_WOOD, "Stripped Cinnamon Wood");
        addCinnamonPrefixBlock(translationBuilder, AllBlocks.CINNAMON_PLANKS, "Planks");
        addCinnamonPrefixBlock(translationBuilder, AllBlocks.CINNAMON_SLAB, "Slab");
        addCinnamonPrefixBlock(translationBuilder, AllBlocks.CINNAMON_STAIRS, "Stairs");
        addCinnamonPrefixBlock(translationBuilder, AllBlocks.CINNAMON_FENCE, "Fence");
        addCinnamonPrefixBlock(translationBuilder, AllBlocks.CINNAMON_FENCE_GATE, "Fence Gate");
        addCinnamonPrefixBlock(translationBuilder, AllBlocks.CINNAMON_BUTTON, "Button");
        addCinnamonPrefixBlock(translationBuilder, AllBlocks.CINNAMON_PRESSURE_PLATE, "Pressure Plate");
        addCinnamonPrefixBlock(translationBuilder, AllBlocks.CINNAMON_DOOR, "Door");
        addCinnamonPrefixBlock(translationBuilder, AllBlocks.CINNAMON_TRAPDOOR, "Trapdoor");
        addCinnamonPrefixBlock(translationBuilder, AllBlocks.CINNAMON_SIGN, "Sign");
        addCinnamonPrefixBlock(translationBuilder, AllBlocks.CINNAMON_LEAVES, "Leaves");
        addCinnamonPrefixBlock(translationBuilder, AllBlocks.CINNAMON_SAPLING, "Sapling");
        translationBuilder.add(AllBlocks.POTTED_CINNAMON_SAPLING, "Potted Cinnamon Sapling");

        translationBuilder.add(AllBlocks.PINK_ROSE, "Pink Rose");
        translationBuilder.add(AllBlocks.POTTED_PINK_ROSE, "Potted Pink Rose");
        translationBuilder.add(AllBlocks.FLOWER_STEM, "Flower Stem");
        translationBuilder.add(AllBlocks.POTTED_FLOWER_STEM, "Potted Flower Stem");

        addPetalCarpet(translationBuilder, AllBlocks.RED_ROSE_CARPET, "Red");
        addPetalCarpet(translationBuilder, AllBlocks.ORANGE_ROSE_CARPET, "Orange");
        addPetalCarpet(translationBuilder, AllBlocks.YELLOW_ROSE_CARPET, "Yellow");
        addPetalCarpet(translationBuilder, AllBlocks.LIME_ROSE_CARPET, "Lime");
        addPetalCarpet(translationBuilder, AllBlocks.GREEN_ROSE_CARPET, "Green");
        addPetalCarpet(translationBuilder, AllBlocks.LIGHT_BLUE_ROSE_CARPET, "Light Blue");
        addPetalCarpet(translationBuilder, AllBlocks.CYAN_ROSE_CARPET, "Cyan");
        addPetalCarpet(translationBuilder, AllBlocks.BLUE_ROSE_CARPET, "Blue");
        addPetalCarpet(translationBuilder, AllBlocks.PURPLE_ROSE_CARPET, "Purple");
        addPetalCarpet(translationBuilder, AllBlocks.MAGENTA_ROSE_CARPET, "Magenta");
        addPetalCarpet(translationBuilder, AllBlocks.PINK_ROSE_CARPET, "Pink");
        addPetalCarpet(translationBuilder, AllBlocks.BLACK_ROSE_CARPET, "Black");
        addPetalCarpet(translationBuilder, AllBlocks.GRAY_ROSE_CARPET, "Gray");
        addPetalCarpet(translationBuilder, AllBlocks.LIGHT_GRAY_ROSE_CARPET, "Light Gray");
        addPetalCarpet(translationBuilder, AllBlocks.WHITE_ROSE_CARPET, "White");
        addPetalCarpet(translationBuilder, AllBlocks.BROWN_ROSE_CARPET, "Brown");

        translationBuilder.add(AllBlocks.LEMON_TREE, "Lemon Tree");
        translationBuilder.add(AllBlocks.LIME_TREE, "Lime Tree");
        translationBuilder.add(AllBlocks.ORANGE_TREE, "Orange Tree");

        translationBuilder.add(AllBlocks.REINFORCED_BLACKSTONE, "Block of Reinforced Blackstone");
        translationBuilder.add(AllBlocks.REINFORCED_BLACKSTONE_DOOR, "Reinforced Blackstone Door");
        translationBuilder.add(AllBlocks.REINFORCED_BLACKSTONE_TRAPDOOR, "Reinforced Blackstone Trapdoor");
        translationBuilder.add(AllBlocks.REINFORCED_BLACKSTONE_LADDER, "Reinforced Blackstone Ladder");
        translationBuilder.add(AllBlocks.REINFORCED_BLACKSTONE_ROD, "Reinforced Blackstone Rod");
        translationBuilder.add(AllBlocks.REINFORCED_BLACKSTONE_LEVER, "Reinforced Blackstone Lever");
        translationBuilder.add(AllBlocks.REINFORCED_BLACKSTONE_BARS, "Reinforced Blackstone Bars");
        translationBuilder.add(AllBlocks.REINFORCED_BLACKSTONE_GRAVEL, "Reinforced Blackstone Gravel");
    }

    private void addItems(TranslationBuilder translationBuilder) {
        translationBuilder.add(AllItems.BARK_REMOVER, "Bark Stripper");
        translationBuilder.add(AllItems.BLOW_TORCH, "Blow Torch");
        translationBuilder.add(AllItems.WHISK, "Whisk");
        translationBuilder.add(AllItems.FLOWER_SEPERATOR, "Secateurs");

        translationBuilder.add(AllItems.CLOAK_SPAWN_EGG, "Cloak Spawn Egg");

        translationBuilder.add(AllItems.CARAMEL_BUCKET, "Caramel Bucket");

        translationBuilder.add(AllItems.CINNAMON, "Cinnamon Stick");
        translationBuilder.add(AllItems.CRUSHED_CINNAMON, "Crushed Cinnamon");
        translationBuilder.add(AllItems.EGG_WHITE, "Egg White");
        translationBuilder.add(AllItems.EGG_YOLK, "Egg Yolk");
        translationBuilder.add(AllItems.RAW_MERINGUE, "Raw Meringue");
        translationBuilder.add(AllItems.BUTTER, "Butter");
        translationBuilder.add(AllItems.CREAM, "Cream");

        addRosePetal(translationBuilder, AllItems.RED_ROSE_PETAL, "Red");
        addRosePetal(translationBuilder, AllItems.ORANGE_ROSE_PETAL, "Orange");
        addRosePetal(translationBuilder, AllItems.YELLOW_ROSE_PETAL, "Yellow");
        addRosePetal(translationBuilder, AllItems.LIME_ROSE_PETAL, "Lime");
        addRosePetal(translationBuilder, AllItems.GREEN_ROSE_PETAL, "Green");
        addRosePetal(translationBuilder, AllItems.LIGHT_BLUE_ROSE_PETAL, "Light Blue");
        addRosePetal(translationBuilder, AllItems.CYAN_ROSE_PETAL, "Cyan");
        addRosePetal(translationBuilder, AllItems.BLUE_ROSE_PETAL, "Blue");
        addRosePetal(translationBuilder, AllItems.PURPLE_ROSE_PETAL, "Purple");
        addRosePetal(translationBuilder, AllItems.MAGENTA_ROSE_PETAL, "Magenta");
        addRosePetal(translationBuilder, AllItems.PINK_ROSE_PETAL, "Pink");
        addRosePetal(translationBuilder, AllItems.BLACK_ROSE_PETAL, "Black");
        addRosePetal(translationBuilder, AllItems.GRAY_ROSE_PETAL, "Gray");
        addRosePetal(translationBuilder, AllItems.LIGHT_GRAY_ROSE_PETAL, "Light Gray");
        addRosePetal(translationBuilder, AllItems.WHITE_ROSE_PETAL, "White");
        addRosePetal(translationBuilder, AllItems.BROWN_ROSE_PETAL, "Brown");

        translationBuilder.add(AllItems.OAK_BARK, "Oak Bark");
        translationBuilder.add(AllItems.BIRCH_BARK, "Birch Bark");
        translationBuilder.add(AllItems.SPRUCE_BARK, "Spruce Bark");
        translationBuilder.add(AllItems.JUNGLE_BARK, "Jungle Bark");
        translationBuilder.add(AllItems.ACACIA_BARK, "Acacia Bark");
        translationBuilder.add(AllItems.DARK_OAK_BARK, "Dark Oak Bark");
        translationBuilder.add(AllItems.CRIMSON_BARK, "Crimson Bark");
        translationBuilder.add(AllItems.WARPED_BARK, "Warped Bark");
        translationBuilder.add(AllItems.CINNAMON_BARK, "Cinnamon Bark");
        translationBuilder.add(AllItems.UNKNOWN_BARK, "Unknown Bark");
        translationBuilder.add(AllItems.PAPER_PULP, "Paper Pulp");

        translationBuilder.add(AllItems.SUGAR_ROSE_PETAL, "Sugar Coated Rose Petal");
        translationBuilder.add(AllItems.MERINGUE, "Meringue");
        translationBuilder.add(AllItems.LEMON, "Lemon");
        translationBuilder.add(AllItems.LIME, "Lime");
        translationBuilder.add(AllItems.ORANGE, "Orange");
        translationBuilder.add(AllItems.BLOOD_ORANGE, "Blood Orange");
        translationBuilder.add(AllItems.CARAMEL, "Caramel");

        translationBuilder.add(AllItems.REINFORCED_BLACKSTONE_INGOT, "Reinforced Blackstone Ingot");
        translationBuilder.add(AllItems.REINFORCED_BLACKSTONE_NUGGET, "Reinforced Blackstone Nugget");
        translationBuilder.add(AllItems.REINFORCED_BLACKSTONE_STICK, "Reinforced Blackstone Rod");
        translationBuilder.add(AllItems.REINFORCED_BLACKSTONE_SHARD, "Reinforced Blackstone Shard");

        translationBuilder.add(AllItems.REINFORCED_BLACKSTONE_SWORD, "Reinforced Blackstone Sword");
        translationBuilder.add(AllItems.REINFORCED_BLACKSTONE_PICKAXE, "Reinforced Blackstone Pickaxe");
        translationBuilder.add(AllItems.REINFORCED_BLACKSTONE_AXE, "Reinforced Blackstone Axe");
        translationBuilder.add(AllItems.REINFORCED_BLACKSTONE_SHOVEL, "Reinforced Blackstone Shovel");
        translationBuilder.add(AllItems.REINFORCED_BLACKSTONE_HOE, "Reinforced Blackstone Hoe");

        translationBuilder.add(AllItems.REINFORCED_BLACKSTONE_BOOTS, "Reinforced Blackstone Boots");
        translationBuilder.add(AllItems.REINFORCED_BLACKSTONE_LEGGINGS, "Reinforced Blackstone Leggings");
        translationBuilder.add(AllItems.REINFORCED_BLACKSTONE_CHESTPLATE, "Reinforced Blackstone Chestplate");
        translationBuilder.add(AllItems.REINFORCED_BLACKSTONE_HELMET, "Reinforced Blackstone Helmet");
    }

    private void addGui(TranslationBuilder translationBuilder) {
        translationBuilder.add("container." + CraftedCuisine.MODID + ".carameliser", "Caramelizer");
        translationBuilder.add("container." + CraftedCuisine.MODID + ".auto_blowtorch", "Auto Blowtorch");

        translationBuilder.add("gui." + CraftedCuisine.MODID + ".jei.category.caramelising", "Caramelizing");
        translationBuilder.add("gui." + CraftedCuisine.MODID + ".jei.category.blowtorching", "Blowtorching");
        translationBuilder.add("gui." + CraftedCuisine.MODID + ".jei.category.flower_seperating", "Flower Seperating");
        translationBuilder.add("gui." + CraftedCuisine.MODID + ".jei.category.bark_seperation", "Bark Seperation");
    }

    private void addSubtitles(TranslationBuilder translationBuilder) {
        translationBuilder.add("subtitles." + CraftedCuisine.MODID + ".item.blow_torch.use", "Blow Torch burns");
        translationBuilder.add("subtitles." + CraftedCuisine.MODID + ".entity.cloak_idle", "Cloak Breaths");
        translationBuilder.add("subtitles." + CraftedCuisine.MODID + ".item.armor.equip_reinforced_blackstone", "Reinforced Blackstone Armor Clanks");
    }

    private void addTooltips(TranslationBuilder translationBuilder) {
        translationBuilder.add("tooltip." + CraftedCuisine.MODID + ".item.lemon_tree_drop", "§7A drop from the Lemon Tree.");
        translationBuilder.add("tooltip." + CraftedCuisine.MODID + ".item.lime_tree_drop", "§7A drop from the Lime Tree.");
        translationBuilder.add("tooltip." + CraftedCuisine.MODID + ".item.orange_tree_drop", "§7A drop from the Orange Tree.");
        translationBuilder.add("tooltip." + CraftedCuisine.MODID + ".item.orange_tree_drop.rare", "§7A rare drop from the Orange Tree.");
        translationBuilder.add("tooltip." + CraftedCuisine.MODID + ".item.unknown_bark", "This dropped from Bark stripping a log without a bark.");
    }


    public void addRosePetal(TranslationBuilder translationBuilder, Item item, String color) {
        translationBuilder.add(item, color + " Rose Petal");
    }

    public void addCinnamonPrefixBlock(TranslationBuilder translationBuilder, Block block, String name) {
        translationBuilder.add(block, "Cinnamon " + name);
    }
    
    public void addPetalCarpet(TranslationBuilder translationBuilder, Block block, String color) {
        translationBuilder.add(block, color + " Rose Petal Carpet");
    }
    
}
