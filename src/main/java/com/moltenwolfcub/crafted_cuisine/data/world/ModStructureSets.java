package com.moltenwolfcub.crafted_cuisine.data.world;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;

public class ModStructureSets {
    public static final ResourceKey<StructureSet> BLACKSTONE_FORTRESS_KEY = registerKey("blackstone_fortress");
    
    public static void bootstrap(BootstapContext<StructureSet> bootstapContext) {
        HolderGetter<Structure> structureRegistryLookup = bootstapContext.lookup(Registries.STRUCTURE);


        bootstapContext.register(
            BLACKSTONE_FORTRESS_KEY,
            new StructureSet(
                structureRegistryLookup.getOrThrow(ModStructures.BLACKSTONE_FORTRESS_KEY),
                (StructurePlacement)new RandomSpreadStructurePlacement(
                    48,
                    12,
                    RandomSpreadType.TRIANGULAR,
                    35115546
                )
            )
        );

    }


    private static ResourceKey<StructureSet> registerKey(String string) {
        return ResourceKey.create(Registries.STRUCTURE_SET, new ResourceLocation(CraftedCuisine.MODID, string));
    }
}
