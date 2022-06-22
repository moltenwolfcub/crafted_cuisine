package com.moltenwolfcub.crafted_cuisine.datagen;

import java.util.function.Supplier;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.ModBlocks;
import com.moltenwolfcub.crafted_cuisine.init.ModItems;

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

            add("tooltip.crafted_cuisine.bark_remover", "Press §e§nSHIFT§r for more info!");
            add("tooltip.crafted_cuisine.bark_remover.shift", "Left click on a log to strip it and drop the corresponding bark item!");

            add("itemGroup.crafted_cuisine", "Create Food");

            add("subtitles.item.blow_torch.use", "Blow Torch burns");

            add("fluid.crafted_cuisine.caramel_fluid", "Caramel");


            add("container." + CraftedCuisine.MODID + ".carameliser", "Caramelizer");
            add("container." + CraftedCuisine.MODID + ".auto_blowtorch", "Auto Blowtorch");

            add("gui." + CraftedCuisine.MODID + ".jei.category.caramelising", "Caramelizing");
            add("gui." + CraftedCuisine.MODID + ".jei.category.blowtorching", "Blowtorching");
            add("gui." + CraftedCuisine.MODID + ".jei.category.flower_seperating", "Flower Seperating");
            add("gui." + CraftedCuisine.MODID + ".jei.category.bark_seperation", "Bark Seperation");

            add("gui." + CraftedCuisine.MODID + ".jei.info.bark", "Bark can be obtained by stripping the appropriate log type with the Bark Stripper. Bark can be crafted back onto a stripped log.\n(See Bark Stripper for more info)");
            add("gui." + CraftedCuisine.MODID + ".jei.info.bark_stripper", "The Bark Stripper works in a similar way to the vanilla stripping function of an Axe. The difference here is that it instead drops a bark item for the type of Log Stripped.");
        }


        private void addBlocks() {
            addBlock(ModBlocks.SAW_DUST, "Saw Dust");
            addBlock(ModBlocks.AUTO_BLOWTORCH, "Auto Blowtorch");
            addBlock(ModBlocks.CARAMELISER, "Caramelizer");

            addCinnamonPrefixBlock(ModBlocks.CINNAMON_LOG, "Log");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_WOOD, "Wood");
            addBlock(ModBlocks.STRIPPED_CINNAMON_LOG, "Stripped Cinnamon Log");
            addBlock(ModBlocks.STRIPPED_CINNAMON_WOOD, "Stripped Cinnamon Wood");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_PLANKS, "Planks");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_SLAB, "Slab");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_STAIRS, "Stairs");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_FENCE, "Fence");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_FENCE_GATE, "Fence Gate");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_BUTTON, "Button");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_PRESSURE_PLATE, "Pressure Plate");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_DOOR, "Door");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_TRAPDOOR, "Trapdoor");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_SIGN, "Sign");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_LEAVES, "Leaves");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_SAPLING, "Sapling");
            addBlock(ModBlocks.POTTED_CINNAMON_SAPLING, "Potted Cinnamon Sapling");

            addBlock(ModBlocks.PINK_ROSE, "Pink Rose");
            addBlock(ModBlocks.POTTED_PINK_ROSE, "Potted Pink Rose");
            addBlock(ModBlocks.FLOWER_STEM, "Flower Stem");
            addBlock(ModBlocks.POTTED_FLOWER_STEM, "Potted Flower Stem");

            addPetalCarpet(ModBlocks.RED_ROSE_CARPET, "Red");
            addPetalCarpet(ModBlocks.ORANGE_ROSE_CARPET, "Orange");
            addPetalCarpet(ModBlocks.YELLOW_ROSE_CARPET, "Yellow");
            addPetalCarpet(ModBlocks.LIME_ROSE_CARPET, "Lime");
            addPetalCarpet(ModBlocks.GREEN_ROSE_CARPET, "Green");
            addPetalCarpet(ModBlocks.LIGHT_BLUE_ROSE_CARPET, "Light Blue");
            addPetalCarpet(ModBlocks.CYAN_ROSE_CARPET, "Cyan");
            addPetalCarpet(ModBlocks.BLUE_ROSE_CARPET, "Blue");
            addPetalCarpet(ModBlocks.PURPLE_ROSE_CARPET, "Purple");
            addPetalCarpet(ModBlocks.MAGENTA_ROSE_CARPET, "Magenta");
            addPetalCarpet(ModBlocks.PINK_ROSE_CARPET, "Pink");
            addPetalCarpet(ModBlocks.BLACK_ROSE_CARPET, "Black");
            addPetalCarpet(ModBlocks.GRAY_ROSE_CARPET, "Gray");
            addPetalCarpet(ModBlocks.LIGHT_GRAY_ROSE_CARPET, "Light Gray");
            addPetalCarpet(ModBlocks.WHITE_ROSE_CARPET, "White");
            addPetalCarpet(ModBlocks.BROWN_ROSE_CARPET, "Brown");

            addBlock(ModBlocks.LEMON_TREE, "Lemon Tree");
            addBlock(ModBlocks.LIME_TREE, "Lime Tree");
            addBlock(ModBlocks.ORANGE_TREE, "Orange Tree");

            addBlock(ModBlocks.REINFORCED_BLACKSTONE, "Block of Reinforced Blackstone");
            addBlock(ModBlocks.REINFORCED_BLACKSTONE_DOOR, "Reinforced Blackstone Door");
            addBlock(ModBlocks.REINFORCED_BLACKSTONE_LADDER, "Reinforced Blackstone Ladder");
            addBlock(ModBlocks.REINFORCED_BLACKSTONE_ROD, "Reinforced Blackstone Rod");
        }

        private void addItems() {
            addItem(ModItems.BARK_REMOVER, "Bark Stripper");
            addItem(ModItems.BLOW_TORCH, "Blow Torch");
            addItem(ModItems.WHISK, "Whisk");
            addItem(ModItems.FLOWER_SEPERATOR, "Secateurs");

            addItem(ModItems.CARAMEL_BUCKET, "Caramel Bucket");

            addItem(ModItems.CINNAMON, "Cinnamon Stick");
            addItem(ModItems.CRUSHED_CINNAMON, "Crushed Cinnamon");
            addItem(ModItems.EGG_WHITE, "Egg White");
            addItem(ModItems.EGG_YOLK, "Egg Yolk");
            addItem(ModItems.RAW_MERINGUE, "Raw Meringue");
            addItem(ModItems.BUTTER, "Butter");
            addItem(ModItems.CREAM, "Cream");

            addRosePetal(ModItems.RED_ROSE_PETAL, "Red");
            addRosePetal(ModItems.ORANGE_ROSE_PETAL, "Orange");
            addRosePetal(ModItems.YELLOW_ROSE_PETAL, "Yellow");
            addRosePetal(ModItems.LIME_ROSE_PETAL, "Lime");
            addRosePetal(ModItems.GREEN_ROSE_PETAL, "Green");
            addRosePetal(ModItems.LIGHT_BLUE_ROSE_PETAL, "Light Blue");
            addRosePetal(ModItems.CYAN_ROSE_PETAL, "Cyan");
            addRosePetal(ModItems.BLUE_ROSE_PETAL, "Blue");
            addRosePetal(ModItems.PURPLE_ROSE_PETAL, "Purple");
            addRosePetal(ModItems.MAGENTA_ROSE_PETAL, "Magenta");
            addRosePetal(ModItems.PINK_ROSE_PETAL, "Pink");
            addRosePetal(ModItems.BLACK_ROSE_PETAL, "Black");
            addRosePetal(ModItems.GRAY_ROSE_PETAL, "Gray");
            addRosePetal(ModItems.LIGHT_GRAY_ROSE_PETAL, "Light Gray");
            addRosePetal(ModItems.WHITE_ROSE_PETAL, "White");
            addRosePetal(ModItems.BROWN_ROSE_PETAL, "Brown");

            addItem(ModItems.OAK_BARK, "Oak Bark");
            addItem(ModItems.BIRCH_BARK, "Birch Bark");
            addItem(ModItems.SPRUCE_BARK, "Spruce Bark");
            addItem(ModItems.JUNGLE_BARK, "Jungle Bark");
            addItem(ModItems.ACACIA_BARK, "Acacia Bark");
            addItem(ModItems.DARK_OAK_BARK, "Dark Oak Bark");
            addItem(ModItems.CRIMSON_BARK, "Crimson Bark");
            addItem(ModItems.WARPED_BARK, "Warped Bark");
            addItem(ModItems.CINNAMON_BARK, "Cinnamon Bark");
            addItem(ModItems.PAPER_PULP, "Paper Pulp");

            addItem(ModItems.SUGAR_ROSE_PETAL, "Sugar Coated Rose Petal");
            addItem(ModItems.MERINGUE, "Meringue");
            addItem(ModItems.LEMON, "Lemon");
            addItem(ModItems.LIME, "Lime");
            addItem(ModItems.ORANGE, "Orange");
            addItem(ModItems.BLOOD_ORANGE, "Blood Orange");
            addItem(ModItems.CARAMEL, "Caramel");

            addItem(ModItems.REINFORCED_BLACKSTONE_INGOT, "Reinforced Blackstone Ingot");
            addItem(ModItems.REINFORCED_BLACKSTONE_NUGGET, "Reinforced Blackstone Nugget");

            addItem(ModItems.REINFORCED_BLACKSTONE_SWORD, "Reinforced Blackstone Sword");
            addItem(ModItems.REINFORCED_BLACKSTONE_PICKAXE, "Reinforced Blackstone Pickaxe");
            addItem(ModItems.REINFORCED_BLACKSTONE_AXE, "Reinforced Blackstone Axe");
            addItem(ModItems.REINFORCED_BLACKSTONE_SHOVEL, "Reinforced Blackstone Shovel");
            addItem(ModItems.REINFORCED_BLACKSTONE_HOE, "Reinforced Blackstone Hoe");

            addItem(ModItems.REINFORCED_BLACKSTONE_BOOTS, "Reinforced Blackstone Boots");
            addItem(ModItems.REINFORCED_BLACKSTONE_LEGGINGS, "Reinforced Blackstone Leggings");
            addItem(ModItems.REINFORCED_BLACKSTONE_CHESTPLATE, "Reinforced Blackstone Chestplate");
            addItem(ModItems.REINFORCED_BLACKSTONE_HELMET, "Reinforced Blackstone Helmet");
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
