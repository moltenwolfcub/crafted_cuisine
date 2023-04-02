package com.moltenwolfcub.craftedcuisine.data.world;

import java.util.Map;

import com.moltenwolfcub.craftedcuisine.CraftedCuisine;
import com.moltenwolfcub.craftedcuisine.init.AllEntityTypes;
import com.moltenwolfcub.craftedcuisine.init.AllTags;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.Structure.StructureSettings;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

public class ModStructureProvider {
    public static final ResourceKey<Structure> BLACKSTONE_FORTRESS_KEY = registerKey("blackstone_fortress");
    
    public static void bootstrap(BootstapContext<Structure> bootstapContext) {
        HolderGetter<Biome> biomeRegistryLookup = bootstapContext.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> poolRegistryLookup = bootstapContext.lookup(Registries.TEMPLATE_POOL);

        bootstapContext.register(
            BLACKSTONE_FORTRESS_KEY,
            new JigsawStructure(
                new StructureSettings(
                    biomeRegistryLookup.getOrThrow(AllTags.Biomes.HAS_BLACKSTONE_FORTRESS),
                    Map.of(MobCategory.MONSTER, new StructureSpawnOverride(
                        StructureSpawnOverride.BoundingBoxType.PIECE,
                        WeightedRandomList.create(new SpawnerData(AllEntityTypes.CLOAK, 1, 1, 1))
                    )),
                    GenerationStep.Decoration.SURFACE_STRUCTURES,
                    TerrainAdjustment.BEARD_THIN
                ),
                poolRegistryLookup.getOrThrow(ModTemplatePoolProvider.BLACKSTONE_START_KEY),
                7,
                ConstantHeight.of(VerticalAnchor.absolute(0)),
                false,
                Heightmap.Types.WORLD_SURFACE_WG
            )
        );
    }

    public static ResourceKey<Structure> registerKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(CraftedCuisine.MODID, name));
    }
}
