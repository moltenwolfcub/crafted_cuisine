package com.moltenwolfcub.craftedcuisine.world;

import com.moltenwolfcub.craftedcuisine.world.gen.ModFlowerGeneration;
import com.moltenwolfcub.craftedcuisine.world.gen.ModOreGeneration;
import com.moltenwolfcub.craftedcuisine.world.gen.ModTreeGeneration;

public class ModWorldGeneration {

    public static void generateModWorldGen() {
        ModTreeGeneration.generateTrees();
        ModFlowerGeneration.generateFlowers();
        ModOreGeneration.generateOres();
    }
}
