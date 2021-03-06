package com.moltenwolfcub.crafted_cuisine.datagen;

import java.util.function.Supplier;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllEffects;
import com.moltenwolfcub.crafted_cuisine.init.AllEntityTypes;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider {
    
    public class EnUs extends LanguageProvider {

        public EnUs(DataGenerator gen) {
            super(gen, CraftedCuisine.MODID, "en_us");
        }

        @Override
        protected void addTranslations() {
            addItems();
            addBlocks();
            addGui();
            addSubtitles();
            addTooltips();

            add(AllEntityTypes.CLOAK.get(), "Cloak");
            add("itemGroup." + CraftedCuisine.MODID, "Crafted Cuisine");
            add("fluid." + CraftedCuisine.MODID + ".caramel_fluid", "Caramel");
            add(AllEffects.INVERTED_MOVEMENT.get(), "Dizziness");


        }


        private void addBlocks() {
            addBlock(AllBlocks.SAW_DUST, "Saw Dust");
            addBlock(AllBlocks.AUTO_BLOWTORCH, "Auto Blowtorch");
            addBlock(AllBlocks.CARAMELISER, "Caramelizer");

            addCinnamonPrefixBlock(AllBlocks.CINNAMON_LOG, "Log");
            addCinnamonPrefixBlock(AllBlocks.CINNAMON_WOOD, "Wood");
            addBlock(AllBlocks.STRIPPED_CINNAMON_LOG, "Stripped Cinnamon Log");
            addBlock(AllBlocks.STRIPPED_CINNAMON_WOOD, "Stripped Cinnamon Wood");
            addCinnamonPrefixBlock(AllBlocks.CINNAMON_PLANKS, "Planks");
            addCinnamonPrefixBlock(AllBlocks.CINNAMON_SLAB, "Slab");
            addCinnamonPrefixBlock(AllBlocks.CINNAMON_STAIRS, "Stairs");
            addCinnamonPrefixBlock(AllBlocks.CINNAMON_FENCE, "Fence");
            addCinnamonPrefixBlock(AllBlocks.CINNAMON_FENCE_GATE, "Fence Gate");
            addCinnamonPrefixBlock(AllBlocks.CINNAMON_BUTTON, "Button");
            addCinnamonPrefixBlock(AllBlocks.CINNAMON_PRESSURE_PLATE, "Pressure Plate");
            addCinnamonPrefixBlock(AllBlocks.CINNAMON_DOOR, "Door");
            addCinnamonPrefixBlock(AllBlocks.CINNAMON_TRAPDOOR, "Trapdoor");
            addCinnamonPrefixBlock(AllBlocks.CINNAMON_SIGN, "Sign");
            addCinnamonPrefixBlock(AllBlocks.CINNAMON_LEAVES, "Leaves");
            addCinnamonPrefixBlock(AllBlocks.CINNAMON_SAPLING, "Sapling");
            addBlock(AllBlocks.POTTED_CINNAMON_SAPLING, "Potted Cinnamon Sapling");

            addBlock(AllBlocks.PINK_ROSE, "Pink Rose");
            addBlock(AllBlocks.POTTED_PINK_ROSE, "Potted Pink Rose");
            addBlock(AllBlocks.FLOWER_STEM, "Flower Stem");
            addBlock(AllBlocks.POTTED_FLOWER_STEM, "Potted Flower Stem");

            addPetalCarpet(AllBlocks.RED_ROSE_CARPET, "Red");
            addPetalCarpet(AllBlocks.ORANGE_ROSE_CARPET, "Orange");
            addPetalCarpet(AllBlocks.YELLOW_ROSE_CARPET, "Yellow");
            addPetalCarpet(AllBlocks.LIME_ROSE_CARPET, "Lime");
            addPetalCarpet(AllBlocks.GREEN_ROSE_CARPET, "Green");
            addPetalCarpet(AllBlocks.LIGHT_BLUE_ROSE_CARPET, "Light Blue");
            addPetalCarpet(AllBlocks.CYAN_ROSE_CARPET, "Cyan");
            addPetalCarpet(AllBlocks.BLUE_ROSE_CARPET, "Blue");
            addPetalCarpet(AllBlocks.PURPLE_ROSE_CARPET, "Purple");
            addPetalCarpet(AllBlocks.MAGENTA_ROSE_CARPET, "Magenta");
            addPetalCarpet(AllBlocks.PINK_ROSE_CARPET, "Pink");
            addPetalCarpet(AllBlocks.BLACK_ROSE_CARPET, "Black");
            addPetalCarpet(AllBlocks.GRAY_ROSE_CARPET, "Gray");
            addPetalCarpet(AllBlocks.LIGHT_GRAY_ROSE_CARPET, "Light Gray");
            addPetalCarpet(AllBlocks.WHITE_ROSE_CARPET, "White");
            addPetalCarpet(AllBlocks.BROWN_ROSE_CARPET, "Brown");

            addBlock(AllBlocks.LEMON_TREE, "Lemon Tree");
            addBlock(AllBlocks.LIME_TREE, "Lime Tree");
            addBlock(AllBlocks.ORANGE_TREE, "Orange Tree");

            addBlock(AllBlocks.REINFORCED_BLACKSTONE, "Block of Reinforced Blackstone");
            addBlock(AllBlocks.REINFORCED_BLACKSTONE_DOOR, "Reinforced Blackstone Door");
            addBlock(AllBlocks.REINFORCED_BLACKSTONE_TRAPDOOR, "Reinforced Blackstone Trapdoor");
            addBlock(AllBlocks.REINFORCED_BLACKSTONE_LADDER, "Reinforced Blackstone Ladder");
            addBlock(AllBlocks.REINFORCED_BLACKSTONE_ROD, "Reinforced Blackstone Rod");
            addBlock(AllBlocks.REINFORCED_BLACKSTONE_LEVER, "Reinforced Blackstone Lever");
            addBlock(AllBlocks.REINFORCED_BLACKSTONE_BARS, "Reinforced Blackstone Bars");
            addBlock(AllBlocks.REINFORCED_BLACKSTONE_GRAVEL, "Reinforced Blackstone Gravel");
        }

        private void addItems() {
            addItem(AllItems.BARK_REMOVER, "Bark Stripper");
            addItem(AllItems.BLOW_TORCH, "Blow Torch");
            addItem(AllItems.WHISK, "Whisk");
            addItem(AllItems.FLOWER_SEPERATOR, "Secateurs");

            addItem(AllItems.CLOAK_SPAWN_EGG, "Cloak Spawn Egg");

            addItem(AllItems.CARAMEL_BUCKET, "Caramel Bucket");

            addItem(AllItems.CINNAMON, "Cinnamon Stick");
            addItem(AllItems.CRUSHED_CINNAMON, "Crushed Cinnamon");
            addItem(AllItems.EGG_WHITE, "Egg White");
            addItem(AllItems.EGG_YOLK, "Egg Yolk");
            addItem(AllItems.RAW_MERINGUE, "Raw Meringue");
            addItem(AllItems.BUTTER, "Butter");
            addItem(AllItems.CREAM, "Cream");

            addRosePetal(AllItems.RED_ROSE_PETAL, "Red");
            addRosePetal(AllItems.ORANGE_ROSE_PETAL, "Orange");
            addRosePetal(AllItems.YELLOW_ROSE_PETAL, "Yellow");
            addRosePetal(AllItems.LIME_ROSE_PETAL, "Lime");
            addRosePetal(AllItems.GREEN_ROSE_PETAL, "Green");
            addRosePetal(AllItems.LIGHT_BLUE_ROSE_PETAL, "Light Blue");
            addRosePetal(AllItems.CYAN_ROSE_PETAL, "Cyan");
            addRosePetal(AllItems.BLUE_ROSE_PETAL, "Blue");
            addRosePetal(AllItems.PURPLE_ROSE_PETAL, "Purple");
            addRosePetal(AllItems.MAGENTA_ROSE_PETAL, "Magenta");
            addRosePetal(AllItems.PINK_ROSE_PETAL, "Pink");
            addRosePetal(AllItems.BLACK_ROSE_PETAL, "Black");
            addRosePetal(AllItems.GRAY_ROSE_PETAL, "Gray");
            addRosePetal(AllItems.LIGHT_GRAY_ROSE_PETAL, "Light Gray");
            addRosePetal(AllItems.WHITE_ROSE_PETAL, "White");
            addRosePetal(AllItems.BROWN_ROSE_PETAL, "Brown");

            addItem(AllItems.OAK_BARK, "Oak Bark");
            addItem(AllItems.BIRCH_BARK, "Birch Bark");
            addItem(AllItems.SPRUCE_BARK, "Spruce Bark");
            addItem(AllItems.JUNGLE_BARK, "Jungle Bark");
            addItem(AllItems.ACACIA_BARK, "Acacia Bark");
            addItem(AllItems.DARK_OAK_BARK, "Dark Oak Bark");
            addItem(AllItems.CRIMSON_BARK, "Crimson Bark");
            addItem(AllItems.WARPED_BARK, "Warped Bark");
            addItem(AllItems.CINNAMON_BARK, "Cinnamon Bark");
            addItem(AllItems.UNKNOWN_BARK, "Unknown Bark");
            addItem(AllItems.PAPER_PULP, "Paper Pulp");

            addItem(AllItems.SUGAR_ROSE_PETAL, "Sugar Coated Rose Petal");
            addItem(AllItems.MERINGUE, "Meringue");
            addItem(AllItems.LEMON, "Lemon");
            addItem(AllItems.LIME, "Lime");
            addItem(AllItems.ORANGE, "Orange");
            addItem(AllItems.BLOOD_ORANGE, "Blood Orange");
            addItem(AllItems.CARAMEL, "Caramel");

            addItem(AllItems.REINFORCED_BLACKSTONE_INGOT, "Reinforced Blackstone Ingot");
            addItem(AllItems.REINFORCED_BLACKSTONE_NUGGET, "Reinforced Blackstone Nugget");
            addItem(AllItems.REINFORCED_BLACKSTONE_STICK, "Reinforced Blackstone Rod");
            addItem(AllItems.REINFORCED_BLACKSTONE_SHARD, "Reinforced Blackstone Shard");

            addItem(AllItems.REINFORCED_BLACKSTONE_SWORD, "Reinforced Blackstone Sword");
            addItem(AllItems.REINFORCED_BLACKSTONE_PICKAXE, "Reinforced Blackstone Pickaxe");
            addItem(AllItems.REINFORCED_BLACKSTONE_AXE, "Reinforced Blackstone Axe");
            addItem(AllItems.REINFORCED_BLACKSTONE_SHOVEL, "Reinforced Blackstone Shovel");
            addItem(AllItems.REINFORCED_BLACKSTONE_HOE, "Reinforced Blackstone Hoe");

            addItem(AllItems.REINFORCED_BLACKSTONE_BOOTS, "Reinforced Blackstone Boots");
            addItem(AllItems.REINFORCED_BLACKSTONE_LEGGINGS, "Reinforced Blackstone Leggings");
            addItem(AllItems.REINFORCED_BLACKSTONE_CHESTPLATE, "Reinforced Blackstone Chestplate");
            addItem(AllItems.REINFORCED_BLACKSTONE_HELMET, "Reinforced Blackstone Helmet");
        }

        private void addGui() {
            add("container." + CraftedCuisine.MODID + ".carameliser", "Caramelizer");
            add("container." + CraftedCuisine.MODID + ".auto_blowtorch", "Auto Blowtorch");

            add("gui." + CraftedCuisine.MODID + ".jei.category.caramelising", "Caramelizing");
            add("gui." + CraftedCuisine.MODID + ".jei.category.blowtorching", "Blowtorching");
            add("gui." + CraftedCuisine.MODID + ".jei.category.flower_seperating", "Flower Seperating");
            add("gui." + CraftedCuisine.MODID + ".jei.category.bark_seperation", "Bark Seperation");
        }

        private void addSubtitles() {
            add("subtitles." + CraftedCuisine.MODID + ".item.blow_torch.use", "Blow Torch burns");
            add("subtitles." + CraftedCuisine.MODID + ".entity.cloak_idle", "Cloak Breaths");
            add("subtitles." + CraftedCuisine.MODID + ".item.armor.equip_reinforced_blackstone", "Reinforced Blackstone Armor Clanks");
        }

        private void addTooltips() {
            add("tooltip." + CraftedCuisine.MODID + ".item.lemon_tree_drop", "??7A drop from the Lemon Tree.");
            add("tooltip." + CraftedCuisine.MODID + ".item.lime_tree_drop", "??7A drop from the Lime Tree.");
            add("tooltip." + CraftedCuisine.MODID + ".item.orange_tree_drop", "??7A drop from the Orange Tree.");
            add("tooltip." + CraftedCuisine.MODID + ".item.orange_tree_drop.rare", "??7A rare drop from the Orange Tree.");
            add("tooltip." + CraftedCuisine.MODID + ".item.unknown_bark", "This dropped from Bark stripping a log without a bark.");
        }


        public void addRosePetal(Supplier<? extends Item> item, String color) {
            addItem(item, color + " Rose Petal");
        }

        public void addCinnamonPrefixBlock(Supplier<? extends Block> block, String name) {
            addBlock(block, "Cinnamon " + name);
        }
        
        public void addPetalCarpet(Supplier<? extends Block> block, String color) {
            addBlock(block, color + " Rose Petal Carpet");
        }
    }
}
