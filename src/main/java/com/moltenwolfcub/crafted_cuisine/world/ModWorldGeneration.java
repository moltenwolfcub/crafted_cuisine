package com.moltenwolfcub.crafted_cuisine.world;

import com.moltenwolfcub.crafted_cuisine.world.gen.ModFlowerGeneration;
import com.moltenwolfcub.crafted_cuisine.world.gen.ModOreGeneration;
import com.moltenwolfcub.crafted_cuisine.world.gen.ModTreeGeneration;

public class ModWorldGeneration {

    public static void generateModWorldGen() {
        ModTreeGeneration.generateTrees();
        ModFlowerGeneration.generateFlowers();
        ModOreGeneration.generateOres();
    }
}
