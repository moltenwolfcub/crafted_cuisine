package com.moltenwolfcub.craftedcuisine.data.world;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.moltenwolfcub.craftedcuisine.CraftedCuisine;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class ModTemplatePoolProvider {
    public static final ResourceKey<StructureTemplatePool> BLACKSTONE_START_KEY = registerKey("blackstone_fortress/start_pool");
    public static final ResourceKey<StructureTemplatePool> BLACKSTONE_END_KEY = registerKey("blackstone_fortress/end_pool");
    public static final ResourceKey<StructureTemplatePool> BLACKSTONE_PRISONER_KEY = registerKey("blackstone_fortress/entities/prisoner");
    public static final ResourceKey<StructureTemplatePool> BLACKSTONE_LEFT_KEY = registerKey("blackstone_fortress/left_pool");
    public static final ResourceKey<StructureTemplatePool> BLACKSTONE_RIGHT_KEY = registerKey("blackstone_fortress/right_pool");

    public static void bootstrap(BootstapContext<StructureTemplatePool> bootstapContext) {
        HolderGetter<StructureProcessorList> processorRegistryLookup = bootstapContext.lookup(Registries.PROCESSOR_LIST);
        HolderGetter<StructureTemplatePool> poolRegistryLookup = bootstapContext.lookup(Registries.TEMPLATE_POOL);

        Holder.Reference<StructureTemplatePool> emptyPool = poolRegistryLookup.getOrThrow(Pools.EMPTY);
        Holder.Reference<StructureProcessorList> blackstoneFortressProcessor = processorRegistryLookup.getOrThrow(ModProcessorListProvider.BLACKSTONE_FORTRESS_KEY);


        register(bootstapContext, BLACKSTONE_START_KEY, new StructureTemplatePool(emptyPool, ImmutableList.of(
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/start/basic_corridor", blackstoneFortressProcessor), 1)
        ), StructureTemplatePool.Projection.RIGID));

        register(bootstapContext, BLACKSTONE_END_KEY, new StructureTemplatePool(emptyPool, ImmutableList.of(
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/end/throne_room", blackstoneFortressProcessor), 1)
        ), StructureTemplatePool.Projection.RIGID));

        register(bootstapContext, BLACKSTONE_LEFT_KEY, new StructureTemplatePool(emptyPool, ImmutableList.of(
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/left/blackstone_pile", blackstoneFortressProcessor), 7),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/left/portal", blackstoneFortressProcessor), 3),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/left/armory", blackstoneFortressProcessor), 1),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/left/storage_room", blackstoneFortressProcessor), 5),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/left/ore_dig_site", processorRegistryLookup.getOrThrow(ModProcessorListProvider.DIG_SITE_KEY)), 4),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/left/quad_spawner", processorRegistryLookup.getOrThrow(ModProcessorListProvider.COBWEB_AIR_KEY)), 5),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/left/prison_cell", blackstoneFortressProcessor), 3),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/left/empty", blackstoneFortressProcessor), 1),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/left/barracks", blackstoneFortressProcessor), 6)
        ), StructureTemplatePool.Projection.RIGID));

        register(bootstapContext, BLACKSTONE_RIGHT_KEY, new StructureTemplatePool(emptyPool, ImmutableList.of(
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/right/blackstone_pile", blackstoneFortressProcessor), 7),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/right/portal", blackstoneFortressProcessor), 3),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/right/armory", blackstoneFortressProcessor), 1),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/right/storage_room", blackstoneFortressProcessor), 5),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/right/ore_dig_site", processorRegistryLookup.getOrThrow(ModProcessorListProvider.DIG_SITE_KEY)), 4),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/right/quad_spawner", processorRegistryLookup.getOrThrow(ModProcessorListProvider.COBWEB_AIR_KEY)), 5),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/right/prison_cell", blackstoneFortressProcessor), 3),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/right/empty", blackstoneFortressProcessor), 1),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/right/barracks", blackstoneFortressProcessor), 6)
        ), StructureTemplatePool.Projection.RIGID));


        register(bootstapContext, BLACKSTONE_PRISONER_KEY, new StructureTemplatePool(emptyPool, ImmutableList.of(
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/mobs/vindicator", blackstoneFortressProcessor), 1),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/mobs/witch", blackstoneFortressProcessor), 1)
        ), StructureTemplatePool.Projection.RIGID));

    }


    public static ResourceKey<StructureTemplatePool> registerKey(String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, new ResourceLocation(CraftedCuisine.MODID, name));
    }

    public static void register(BootstapContext<StructureTemplatePool> bootstapContext, ResourceKey<StructureTemplatePool> resourceKey, StructureTemplatePool structureTemplatePool) {
        bootstapContext.register(resourceKey, structureTemplatePool);
    }
    
}
