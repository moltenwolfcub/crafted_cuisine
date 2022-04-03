package com.moltenwolfcub.create_food.event.loot;

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

public class BarkInJungleTempleAdditionModifier extends LootModifier {

    private final Item addition;
    private final Float chance;
    private final Integer count;

    protected BarkInJungleTempleAdditionModifier(LootItemCondition[] conditionsIn, Item addition, Float chance, Integer count) {
        super(conditionsIn);
        this.addition = addition;
        this.chance = chance;
        this.count = count;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextFloat() < this.chance) {
            generatedLoot.add(new ItemStack(addition, count));
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<BarkInJungleTempleAdditionModifier> {

        @Override
        public BarkInJungleTempleAdditionModifier read(ResourceLocation name, JsonObject object,
                LootItemCondition[] conditionsIn) {

            Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(
                GsonHelper.getAsString(object, "addition")));
            Float chance = GsonHelper.getAsFloat(object, "chance");
            Integer count = GsonHelper.getAsInt(object, "count");

                return new BarkInJungleTempleAdditionModifier(conditionsIn, addition, chance, count);
        }

        @Override
        public JsonObject write(BarkInJungleTempleAdditionModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            json.addProperty("chance", instance.chance);
            json.addProperty("count", instance.count);
            return json;
        }
        
    }
}
