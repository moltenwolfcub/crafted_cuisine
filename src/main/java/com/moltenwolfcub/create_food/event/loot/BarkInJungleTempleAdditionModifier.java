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

    protected BarkInJungleTempleAdditionModifier(LootItemCondition[] conditionsIn, Item addition) {
        super(conditionsIn);
        this.addition = addition;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        generatedLoot.add(new ItemStack(addition, 1));
        if (context.getRandom().nextFloat() > 0.3) {
            generatedLoot.add(new ItemStack(addition, 1));
        }
        if (context.getRandom().nextFloat() > 0.2) {
            generatedLoot.add(new ItemStack(addition, 1));
        }
        if (context.getRandom().nextFloat() > 0.1) {
            generatedLoot.add(new ItemStack(addition, 1));
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<BarkInJungleTempleAdditionModifier> {

        @Override
        public BarkInJungleTempleAdditionModifier read(ResourceLocation name, JsonObject object,
                LootItemCondition[] conditionsIn) {
            Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(
                GsonHelper.getAsString(object, "addition")));
                return new BarkInJungleTempleAdditionModifier(conditionsIn, addition);
        }

        @Override
        public JsonObject write(BarkInJungleTempleAdditionModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            return json;
        }
        
    }
}
