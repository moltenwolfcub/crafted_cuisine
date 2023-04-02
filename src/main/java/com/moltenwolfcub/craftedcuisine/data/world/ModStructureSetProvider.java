package com.moltenwolfcub.craftedcuisine.data.world;

import com.moltenwolfcub.craftedcuisine.CraftedCuisine;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class ModStructureSetProvider {
    public static final ResourceKey<StructureSet> BLACKSTONE_FORTRESS_KEY = registerKey("blackstone_fortress");
    
    public static void bootstrap(BootstapContext<StructureSet> bootstapContext) {
        HolderGetter<Structure> structureRegistryLookup = bootstapContext.lookup(Registries.STRUCTURE);


        bootstapContext.register(
            BLACKSTONE_FORTRESS_KEY,
            new StructureSet(
                structureRegistryLookup.getOrThrow(ModStructureProvider.BLACKSTONE_FORTRESS_KEY),
                    new RandomSpreadStructurePlacement(
                        48,
                        12,
                        RandomSpreadType.TRIANGULAR,
                        35115546
                    )
            )
        );

    }


    private static ResourceKey<StructureSet> registerKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE_SET, new ResourceLocation(CraftedCuisine.MODID, name));
    }
}
