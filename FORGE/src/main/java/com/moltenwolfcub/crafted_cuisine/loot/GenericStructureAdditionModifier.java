package com.moltenwolfcub.crafted_cuisine.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class GenericStructureAdditionModifier extends LootModifier {
    public static final Supplier<Codec<GenericStructureAdditionModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> LootModifier.codecStart(inst).and(inst.group(
                    ForgeRegistries.ITEMS.getCodec().fieldOf("addition").forGetter(m -> m.addition),
                    Codec.FLOAT.fieldOf("addition_chance").forGetter(m -> m.addition_chance),
                    Codec.INT.fieldOf("max_count").forGetter(m -> m.max_count),
                    Codec.INT.fieldOf("min_count").forGetter(m -> m.min_count)
            )).apply(inst, GenericStructureAdditionModifier::new))
    );


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
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        int countToAdd = min_count;

        while (true) {
            if (context.getRandom().nextFloat() > this.addition_chance || countToAdd >= max_count) {
                break;
            }
            countToAdd += 1;
        }

        generatedLoot.add(new ItemStack(addition, countToAdd));
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
