package com.moltenwolfcub.crafted_cuisine.datagen;

import java.util.function.BiConsumer;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.function.EnchantRandomlyLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.function.SetPotionLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;

public class ModChestLootTableProvider extends SimpleFabricLootTableProvider {

    private static final Identifier BARK_CHEST = new Identifier(CraftedCuisine.MODID, "chests/bark_chest");

    //blackstone_fortress
    private static final Identifier DEFAULT_CHEST = new Identifier(CraftedCuisine.MODID, "chests/blackstone_fortress_basic");
    private static final Identifier ARMORY_CHEST = new Identifier(CraftedCuisine.MODID, "chests/blackstone_fortress_armory");
    private static final Identifier LAVA_CHEST = new Identifier(CraftedCuisine.MODID, "chests/blackstone_fortress_lava");
    private static final Identifier THRONE_CHEST = new Identifier(CraftedCuisine.MODID, "chests/blackstone_fortress_throne");
    private static final Identifier TOWER_CHEST = new Identifier(CraftedCuisine.MODID, "chests/blackstone_fortress_tower");
    private static final Identifier STORAGE_CHEST = new Identifier(CraftedCuisine.MODID, "chests/blackstone_fortress_storage");
    private static final Identifier BUILDING_CHEST = new Identifier(CraftedCuisine.MODID, "chests/blackstone_fortress_building");
    private static final Identifier RESOURCES_CHEST = new Identifier(CraftedCuisine.MODID, "chests/blackstone_fortress_resources");
    private static final Identifier RICH_CHEST = new Identifier(CraftedCuisine.MODID, "chests/blackstone_fortress_rich");
    private static final Identifier PRISON_CHEST = new Identifier(CraftedCuisine.MODID, "chests/blackstone_fortress_prison");

    public ModChestLootTableProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator, LootContextTypes.CHEST);

    }

    @Override
    public void accept(BiConsumer<Identifier, Builder> builder) {
        addBlackstoneFortress(builder);

        builder.accept(BARK_CHEST, LootTable.builder()
            .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(1.0F, 5.0F))
                .with(ItemEntry.builder(AllItems.ACACIA_BARK).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 10.0f))))
                .with(ItemEntry.builder(AllItems.BIRCH_BARK).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 10.0f))))
                .with(ItemEntry.builder(AllItems.DARK_OAK_BARK).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 10.0f))))
                .with(ItemEntry.builder(AllItems.JUNGLE_BARK).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 10.0f))))
                .with(ItemEntry.builder(AllItems.OAK_BARK).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 10.0f))))
                .with(ItemEntry.builder(AllItems.SPRUCE_BARK).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 10.0f))))
                .with(ItemEntry.builder(AllItems.CINNAMON_BARK).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 10.0f))))
            )
        );
    }

    private static void addBlackstoneFortress(BiConsumer<Identifier, Builder> builder) {
        builder.accept(DEFAULT_CHEST, LootTable.builder()
            .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(2.0f, 6.0f))
                .with(ItemEntry.builder(Items.BLACKSTONE)
                    .weight(20)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 20f)))
                )
                .with(ItemEntry.builder(AllItems.REINFORCED_BLACKSTONE_NUGGET)
                    .weight(18)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 18f)))
                )
                .with(ItemEntry.builder(AllItems.REINFORCED_BLACKSTONE_NUGGET)
                    .weight(18)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 18f)))
                )
                .with(ItemEntry.builder(AllItems.REINFORCED_BLACKSTONE_INGOT)
                    .weight(15)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 4f)))
                )
                .with(ItemEntry.builder(AllItems.REINFORCED_BLACKSTONE_SWORD)
                    .weight(13)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                    .apply(EnchantRandomlyLootFunction.builder())
                )
                .with(ItemEntry.builder(Items.IRON_INGOT)
                    .weight(10)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 5f)))
                )
                .with(ItemEntry.builder(Items.GOLD_INGOT)
                    .weight(8)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 3f)))
                )
                .with(ItemEntry.builder(Items.EMERALD)
                    .weight(5)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 4f)))
                )
                .with(ItemEntry.builder(AllBlockItems.REINFORCED_BLACKSTONE)
                    .weight(3)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 2f)))
                )
                .with(ItemEntry.builder(Items.GILDED_BLACKSTONE)
                    .weight(2)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 2f)))
                )
                .with(ItemEntry.builder(Items.DIAMOND)
                    .weight(1)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                )
            )
        );
        builder.accept(ARMORY_CHEST, LootTable.builder()
            .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(3.0f, 5.0f))
                .with(ItemEntry.builder(AllItems.REINFORCED_BLACKSTONE_INGOT)
                    .weight(20)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2f, 10f)))
                )
                .with(ItemEntry.builder(AllItems.REINFORCED_BLACKSTONE_SWORD)
                    .weight(19)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                    .apply(EnchantRandomlyLootFunction.builder())
                )
                .with(ItemEntry.builder(AllItems.REINFORCED_BLACKSTONE_CHESTPLATE)
                    .weight(18)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                    .apply(EnchantRandomlyLootFunction.builder())
                )
                .with(ItemEntry.builder(AllItems.REINFORCED_BLACKSTONE_AXE)
                    .weight(17)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                    .apply(EnchantRandomlyLootFunction.builder())
                )
                .with(ItemEntry.builder(AllItems.REINFORCED_BLACKSTONE_NUGGET)
                    .weight(15)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3f, 20f)))
                )
                .with(ItemEntry.builder(Items.IRON_SWORD)
                    .weight(13)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                )
                .with(ItemEntry.builder(AllItems.REINFORCED_BLACKSTONE_LEGGINGS)
                    .weight(13)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                    .apply(EnchantRandomlyLootFunction.builder())
                )
                .with(ItemEntry.builder(Items.GOLDEN_SWORD)
                    .weight(13)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                    .apply(EnchantRandomlyLootFunction.builder())
                )
                .with(ItemEntry.builder(AllItems.REINFORCED_BLACKSTONE_HELMET)
                    .weight(13)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                    .apply(EnchantRandomlyLootFunction.builder())
                )
                .with(ItemEntry.builder(AllItems.REINFORCED_BLACKSTONE_BOOTS)
                    .weight(11)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                    .apply(EnchantRandomlyLootFunction.builder())
                )
                .with(ItemEntry.builder(Items.IRON_INGOT)
                    .weight(8)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 5f)))
                )
                .with(ItemEntry.builder(Items.STONE_SWORD)
                    .weight(8)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                )
                .with(ItemEntry.builder(Items.GOLD_NUGGET)
                    .weight(8)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3f, 10f)))
                )
                .with(ItemEntry.builder(Items.BLACKSTONE)
                    .weight(5)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3f, 5f)))
                )
            )
        );
        builder.accept(LAVA_CHEST, LootTable.builder()
            .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(2.0f, 4.0f))
                .with(ItemEntry.builder(Items.MAGMA_CREAM)
                    .weight(10)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2f, 13f)))
                )
                .with(ItemEntry.builder(Items.MAGMA_BLOCK)
                    .weight(8)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 3f)))
                )
                .with(ItemEntry.builder(Items.FIRE_CHARGE)
                    .weight(6)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 5f)))
                )
                .with(ItemEntry.builder(Items.LAVA_BUCKET)
                    .weight(5)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)))
                )
                .with(ItemEntry.builder(Items.POTION)
                    .weight(2)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)))
                    .apply(SetPotionLootFunction.builder(Potions.FIRE_RESISTANCE))
                )
                .with(ItemEntry.builder(Items.BLAZE_POWDER)
                    .weight(1)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)))
                )
            )
        );
        builder.accept(THRONE_CHEST, LootTable.builder()
            .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(Items.NETHERITE_INGOT)
                    .weight(49)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                )
                .with(ItemEntry.builder(Items.NETHERITE_INGOT)
                    .weight(1)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2)))
                )
            )
            .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(3, 6))
                .with(ItemEntry.builder(Items.GOLD_INGOT)
                    .weight(100)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 10)))
                )
                .with(ItemEntry.builder(Items.EMERALD)
                    .weight(95)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5)))
                )
                .with(ItemEntry.builder(Items.DIAMOND)
                    .weight(95)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 9)))
                )
                .with(ItemEntry.builder(Items.GOLDEN_APPLE)
                    .weight(80)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                )
                .with(ItemEntry.builder(Items.DIAMOND_SWORD)
                    .weight(80)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                    .apply(EnchantRandomlyLootFunction.builder())
                )
                .with(ItemEntry.builder(Items.IRON_INGOT)
                    .weight(70)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 10)))
                )
                .with(ItemEntry.builder(Items.ENCHANTED_GOLDEN_APPLE)
                    .weight(20)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                )
            )
        );
        builder.accept(TOWER_CHEST, LootTable.builder()
            .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(Items.BOW)
                    .weight(9)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                )
                .with(ItemEntry.builder(Items.CROSSBOW)
                    .weight(10)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                )
            )
            .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(2, 4))
                .with(ItemEntry.builder(Items.ARROW)
                    .weight(12)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 10)))
                )
                .with(ItemEntry.builder(Items.SPECTRAL_ARROW)
                    .weight(10)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3, 8)))
                )
                .with(ItemEntry.builder(Items.TIPPED_ARROW)
                    .weight(6)
                    .apply(SetPotionLootFunction.builder(Potions.WEAKNESS))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5)))
                )
                .with(ItemEntry.builder(Items.TIPPED_ARROW)
                    .weight(5)
                    .apply(SetPotionLootFunction.builder(Potions.SLOWNESS))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4)))
                )
                .with(ItemEntry.builder(Items.TIPPED_ARROW)
                    .weight(2)
                    .apply(SetPotionLootFunction.builder(Potions.POISON))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3)))
                )
                .with(ItemEntry.builder(Items.TIPPED_ARROW)
                    .weight(1)
                    .apply(SetPotionLootFunction.builder(Potions.HARMING))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
                )
            )
        );

        builder.accept(BUILDING_CHEST, LootTable.builder()
            .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(3, 6))
                .with(ItemEntry.builder(Items.BLACKSTONE)
                    .weight(10)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4, 16)))
                )
                .with(ItemEntry.builder(Items.POLISHED_BLACKSTONE_BRICKS)
                    .weight(7)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 8)))
                )
                .with(ItemEntry.builder(AllBlockItems.REINFORCED_BLACKSTONE_GRAVEL)
                    .weight(6)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 8)))
                )
                .with(ItemEntry.builder(Items.CRACKED_POLISHED_BLACKSTONE_BRICKS)
                    .weight(5)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 8)))
                )
                .with(ItemEntry.builder(Items.POLISHED_BLACKSTONE)
                    .weight(4)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5)))
                )
                .with(ItemEntry.builder(Items.CHISELED_POLISHED_BLACKSTONE)
                    .weight(2)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
                )
                .with(ItemEntry.builder(AllBlockItems.REINFORCED_BLACKSTONE)
                    .weight(1)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4)))
                )
            )
        );

        builder.accept(RESOURCES_CHEST, LootTable.builder()
            .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(2, 7))
                .with(ItemEntry.builder(Items.RAW_IRON)
                    .weight(15)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 8)))
                )
                .with(ItemEntry.builder(Items.RAW_COPPER)
                    .weight(13)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 5)))
                )
                .with(ItemEntry.builder(Items.IRON_INGOT)
                    .weight(10)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 4)))
                )
                .with(ItemEntry.builder(Items.RAW_GOLD)
                    .weight(8)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3)))
                )
                .with(ItemEntry.builder(Items.RAW_IRON_BLOCK)
                    .weight(7)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
                )
                .with(ItemEntry.builder(Items.COPPER_INGOT)
                    .weight(6)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 3)))
                )
                .with(ItemEntry.builder(Items.GOLD_INGOT)
                    .weight(4)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
                )
                .with(ItemEntry.builder(Items.RAW_COPPER_BLOCK)
                    .weight(3)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
                )
                .with(ItemEntry.builder(Items.QUARTZ)
                    .weight(3)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 16)))
                )
                .with(ItemEntry.builder(Items.RAW_GOLD_BLOCK)
                    .weight(1)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                )
            )
        );

        builder.accept(RICH_CHEST, LootTable.builder()
            .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(2, 5))
                .with(ItemEntry.builder(Items.LAPIS_LAZULI)
                    .weight(50)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 6)))
                )
                .with(ItemEntry.builder(Items.EMERALD)
                    .weight(30)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4)))
                )
                .with(ItemEntry.builder(Items.GOLD_BLOCK)
                    .weight(20)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
                )
                .with(ItemEntry.builder(Items.DIAMOND)
                    .weight(10)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4)))
                )
                .with(ItemEntry.builder(Items.NETHERITE_SCRAP)
                    .weight(1)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
                )
            )
        );

        builder.accept(STORAGE_CHEST, LootTable.builder()
            .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1))
                .with(EmptyEntry.Serializer().weight(20))
                .with(LootTableEntry.builder(DEFAULT_CHEST).weight(4))
                .with(LootTableEntry.builder(BUILDING_CHEST).weight(5))
                .with(LootTableEntry.builder(RESOURCES_CHEST).weight(2))
                .with(LootTableEntry.builder(RICH_CHEST).weight(1))
            )
        );

        builder.accept(PRISON_CHEST, LootTable.builder()
            .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(1, 4))
                .with(ItemEntry.builder(Items.ROTTEN_FLESH).weight(6))
                .with(ItemEntry.builder(Items.PORKCHOP).weight(4))
                .with(ItemEntry.builder(Items.SALMON).weight(4))
                .with(ItemEntry.builder(Items.IRON_NUGGET).weight(3))
                .with(ItemEntry.builder(Items.COOKED_PORKCHOP).weight(2))
                .with(ItemEntry.builder(AllBlockItems.SAW_DUST).weight(1))
            )
        );
    }

}