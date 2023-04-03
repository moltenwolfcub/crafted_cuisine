package com.moltenwolfcub.crafted_cuisine.data.world;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.AlwaysTrueTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProcessorRule;
import net.minecraft.world.level.levelgen.structure.templatesystem.RandomBlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class ModProcessorListProvider {
    public static final ResourceKey<StructureProcessorList> BLACKSTONE_FORTRESS_KEY = registerKey("blackstone_fortress");
    public static final ResourceKey<StructureProcessorList> COBWEB_AIR_KEY = registerKey("cobweb_air");
    public static final ResourceKey<StructureProcessorList> DIG_SITE_KEY = registerKey("dig_site");
    
    public static void bootstrap(BootstapContext<StructureProcessorList> bootstapContext) {
        register(
            bootstapContext,
            BLACKSTONE_FORTRESS_KEY,
            ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                    new ProcessorRule(
                        new RandomBlockMatchTest(Blocks.DEEPSLATE_TILES, 0.6f),
                        AlwaysTrueTest.INSTANCE,
                        Blocks.CRACKED_DEEPSLATE_TILES.defaultBlockState()
                    ),
                    new ProcessorRule(
                        new RandomBlockMatchTest(Blocks.DEEPSLATE, 0.1f),
                        AlwaysTrueTest.INSTANCE,
                        Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState()
                    )
                ))
            )
        );

        register(
            bootstapContext,
            COBWEB_AIR_KEY,
            ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                    new ProcessorRule(
                        new RandomBlockMatchTest(Blocks.AIR, 0.25f),
                        AlwaysTrueTest.INSTANCE,
                        Blocks.COBWEB.defaultBlockState()
                    )
                )),
                new RuleProcessor(ImmutableList.of(
                    new ProcessorRule(
                        new RandomBlockMatchTest(Blocks.DEEPSLATE_TILES, 0.6f),
                        AlwaysTrueTest.INSTANCE,
                        Blocks.CRACKED_DEEPSLATE_TILES.defaultBlockState()
                    ),
                    new ProcessorRule(
                        new RandomBlockMatchTest(Blocks.DEEPSLATE, 0.1f),
                        AlwaysTrueTest.INSTANCE,
                        Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState()
                    )
                ))
            )
        );

        register(
            bootstapContext,
            DIG_SITE_KEY,
            ImmutableList.of(
                new RuleProcessor(ImmutableList.of(
                    new ProcessorRule(
                        new RandomBlockMatchTest(Blocks.DEEPSLATE_TILES, 0.6f),
                        AlwaysTrueTest.INSTANCE,
                        Blocks.CRACKED_DEEPSLATE_TILES.defaultBlockState()
                    ),
                    new ProcessorRule(
                        new RandomBlockMatchTest(Blocks.DEEPSLATE, 0.1f),
                        AlwaysTrueTest.INSTANCE,
                        Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState()
                    )
                )),
                new RuleProcessor(ImmutableList.of(
                    new ProcessorRule(
                        new RandomBlockMatchTest(Blocks.STONE, 0.05f),
                        AlwaysTrueTest.INSTANCE,
                        Blocks.DIAMOND_ORE.defaultBlockState()
                    ),
                    new ProcessorRule(
                        new RandomBlockMatchTest(Blocks.STONE, 0.075f),
                        AlwaysTrueTest.INSTANCE,
                        Blocks.EMERALD_ORE.defaultBlockState()
                    ),
                    new ProcessorRule(
                        new RandomBlockMatchTest(Blocks.STONE, 0.1f),
                        AlwaysTrueTest.INSTANCE,
                        Blocks.REDSTONE_ORE.defaultBlockState()
                    ),
                    new ProcessorRule(
                        new RandomBlockMatchTest(Blocks.STONE, 0.15f),
                        AlwaysTrueTest.INSTANCE,
                        Blocks.LAPIS_ORE.defaultBlockState()
                    ),
                    new ProcessorRule(
                        new RandomBlockMatchTest(Blocks.STONE, 0.175f),
                        AlwaysTrueTest.INSTANCE,
                        Blocks.GOLD_ORE.defaultBlockState()
                    ),
                    new ProcessorRule(
                        new RandomBlockMatchTest(Blocks.STONE, 0.2f),
                        AlwaysTrueTest.INSTANCE,
                        Blocks.COPPER_ORE.defaultBlockState()
                    ),
                    new ProcessorRule(
                        new RandomBlockMatchTest(Blocks.STONE, 0.26f),
                        AlwaysTrueTest.INSTANCE,
                        Blocks.IRON_ORE.defaultBlockState()
                    ),
                    new ProcessorRule(
                        new RandomBlockMatchTest(Blocks.STONE, 0.3f),
                        AlwaysTrueTest.INSTANCE,
                        Blocks.COAL_ORE.defaultBlockState()
                    )
                ))
            )
        );
    }

    public static ResourceKey<StructureProcessorList> registerKey(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(CraftedCuisine.MODID, name));
    }

    private static void register(BootstapContext<StructureProcessorList> bootstapContext, ResourceKey<StructureProcessorList> resourceKey, List<StructureProcessor> list) {
        bootstapContext.register(resourceKey, new StructureProcessorList(list));
    }
}
