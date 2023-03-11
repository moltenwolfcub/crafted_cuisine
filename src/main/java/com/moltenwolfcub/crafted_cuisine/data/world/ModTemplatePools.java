package com.moltenwolfcub.crafted_cuisine.data.world;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

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

public class ModTemplatePools {
    public static final ResourceKey<StructureTemplatePool> BLACKSTONE_START_KEY = registerKey("blackstone_fortress/start_pool");
    public static final ResourceKey<StructureTemplatePool> BLACKSTONE_END_KEY = registerKey("blackstone_fortress/end_pool");
    public static final ResourceKey<StructureTemplatePool> BLACKSTONE_PRISONER_KEY = registerKey("blackstone_fortress/entities/prisoner");
    public static final ResourceKey<StructureTemplatePool> BLACKSTONE_LEFT_KEY = registerKey("blackstone_fortress/left_pool");
    public static final ResourceKey<StructureTemplatePool> BLACKSTONE_RIGHT_KEY = registerKey("blackstone_fortress/right_pool");

    public static void bootstrap(BootstapContext<StructureTemplatePool> bootstapContext) {
        HolderGetter<StructureProcessorList> processorRegistryLookup = bootstapContext.lookup(Registries.PROCESSOR_LIST);
        HolderGetter<StructureTemplatePool> poolRegistryLookup = bootstapContext.lookup(Registries.TEMPLATE_POOL);

        Holder.Reference<StructureTemplatePool> emptyPool = poolRegistryLookup.getOrThrow(Pools.EMPTY);
        Holder.Reference<StructureProcessorList> blackstoneFortressProcessor = processorRegistryLookup.getOrThrow(ModProcessorLists.BLACKSTONE_FORTRESS_KEY);


        ModTemplatePools.register(bootstapContext, BLACKSTONE_START_KEY, new StructureTemplatePool(emptyPool, ImmutableList.of(
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/blackstone_fortress", blackstoneFortressProcessor), 1)
        ), StructureTemplatePool.Projection.RIGID));

        ModTemplatePools.register(bootstapContext, BLACKSTONE_END_KEY, new StructureTemplatePool(emptyPool, ImmutableList.of(
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/end/1", blackstoneFortressProcessor), 1)
        ), StructureTemplatePool.Projection.RIGID));

        ModTemplatePools.register(bootstapContext, BLACKSTONE_LEFT_KEY, new StructureTemplatePool(emptyPool, ImmutableList.of(
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/left/1", blackstoneFortressProcessor), 7),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/left/2", blackstoneFortressProcessor), 3),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/left/3", blackstoneFortressProcessor), 1),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/left/4", blackstoneFortressProcessor), 5),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/left/5", processorRegistryLookup.getOrThrow(ModProcessorLists.DIG_SITE_KEY)), 4),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/left/6", processorRegistryLookup.getOrThrow(ModProcessorLists.COBWEB_AIR_KEY)), 5),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/left/7", blackstoneFortressProcessor), 3),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/left/8", blackstoneFortressProcessor), 1),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/left/9", blackstoneFortressProcessor), 6)
        ), StructureTemplatePool.Projection.RIGID));

        ModTemplatePools.register(bootstapContext, BLACKSTONE_RIGHT_KEY, new StructureTemplatePool(emptyPool, ImmutableList.of(
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/right/1", blackstoneFortressProcessor), 7),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/right/2", blackstoneFortressProcessor), 3),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/right/3", blackstoneFortressProcessor), 1),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/right/4", blackstoneFortressProcessor), 5),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/right/5", processorRegistryLookup.getOrThrow(ModProcessorLists.DIG_SITE_KEY)), 4),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/right/6", processorRegistryLookup.getOrThrow(ModProcessorLists.COBWEB_AIR_KEY)), 5),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/right/7", blackstoneFortressProcessor), 3),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/right/8", blackstoneFortressProcessor), 1),
            Pair.of(StructurePoolElement.single("crafted_cuisine:blackstone_fortress/right/9", blackstoneFortressProcessor), 6)
        ), StructureTemplatePool.Projection.RIGID));


        ModTemplatePools.register(bootstapContext, BLACKSTONE_PRISONER_KEY, new StructureTemplatePool(emptyPool, ImmutableList.of(
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
