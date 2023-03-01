package com.moltenwolfcub.crafted_cuisine.datagen;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.loot.GenericStructureAdditionModifier;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(DataGenerator gen) {
        super(gen, CraftedCuisine.MODID);
    }

    @Override
    protected void start() {
        addBarkToTemple(AllItems.JUNGLE_BARK.get(), 0.7f, 0, 3);
        addBarkToTemple(AllItems.OAK_BARK.get(), 0.5f, 0, 2);

        addFruitToVillageHouse(AllItems.LEMON.get(), "desert", 0.75f, 0, 5);
        addFruitToVillageHouse(AllItems.LEMON.get(), "plains", 0.5f, 0, 3);
        addFruitToVillageHouse(AllItems.LEMON.get(), "savanna", 0.8f, 1, 6);

        addFruitToVillageHouse(AllItems.LIME.get(), "desert", 0.65f, 0, 4);
        addFruitToVillageHouse(AllItems.LIME.get(), "plains", 0.35f, 0, 2);
        addFruitToVillageHouse(AllItems.LIME.get(), "savanna", 0.7f, 0, 4);

        addFruitToVillageHouse(AllItems.ORANGE.get(), "desert", 0.8f, 0, 8);
        addFruitToVillageHouse(AllItems.ORANGE.get(), "plains", 0.6f, 0, 6);
        addFruitToVillageHouse(AllItems.ORANGE.get(), "savanna", 0.9f, 1, 9);
    }

    private void addBarkToTemple(Item bark, float additionChance, int minCount, int maxCount) {
        add(Registry.ITEM.getKey(bark).getPath() + "_in_jungle_temple",
            new GenericStructureAdditionModifier(
                new LootItemCondition[] {
                    LootTableIdCondition.builder(new ResourceLocation("chests/jungle_temple")).build()
                },
                bark,
                additionChance,
                maxCount,
                minCount
            )
        );
    }

    private void addFruitToVillageHouse(Item fruit, String biome, float additionChance, int minCount, int maxCount) {
        add(Registry.ITEM.getKey(fruit).getPath() + "_in_village_"+ biome +"_house",
            new GenericStructureAdditionModifier(
                new LootItemCondition[] {
                    LootTableIdCondition.builder(new ResourceLocation("chests/village/village_"+ biome +"_house")).build()
                },
                fruit,
                additionChance,
                maxCount,
                minCount
            )
        );
    }
    
}
