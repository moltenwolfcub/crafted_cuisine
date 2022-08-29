package com.moltenwolfcub.crafted_cuisine.event.loot;

import java.util.List;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class GenericStructureAdditionModifier extends LootModifier {

    private final Item addition;
    private final Float addition_chance;
    private final int max_count;
    private final int min_count;

    public GenericStructureAdditionModifier(LootItemCondition[] conditionsIn, Item addition, Float addition_chance, int max_count, int min_count) {
        super(conditionsIn);
        this.addition = addition;
        this.addition_chance = addition_chance;
        this.max_count = max_count;
        this.min_count = min_count;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        int countToAdd = min_count;

        while (true) {
            if (context.getRandom().nextFloat() > this.addition_chance || countToAdd == max_count) {
                break;
            }
            countToAdd += 1;
        }

        generatedLoot.add(new ItemStack(addition, countToAdd));
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<GenericStructureAdditionModifier> {

        @Override
        public GenericStructureAdditionModifier read(ResourceLocation name, JsonObject object,
                LootItemCondition[] conditionsIn) {

            Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(
                GsonHelper.getAsString(object, "addition")));
            Float addition_chance = GsonHelper.getAsFloat(object, "addition_chance");
            int max_count = GsonHelper.getAsInt(object, "max_count");
            int min_count = GsonHelper.getAsInt(object, "min_count");

            return new GenericStructureAdditionModifier(conditionsIn, addition, addition_chance, max_count, min_count);
        }

        @Override
        public JsonObject write(GenericStructureAdditionModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            json.addProperty("addition_chance", instance.addition_chance);
            json.addProperty("max_count", instance.max_count);
            json.addProperty("min_count", instance.min_count);
            return json;
        }
        
        
    }
}
