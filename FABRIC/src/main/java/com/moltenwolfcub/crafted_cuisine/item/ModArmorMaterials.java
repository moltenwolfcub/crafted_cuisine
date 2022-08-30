package com.moltenwolfcub.crafted_cuisine.item;

import java.util.function.Supplier;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;


// public enum ModArmorMaterials implements ArmorMaterial {
    // REINFORCED_BLACKSTONE("reinforced_blackstone", 15, new int[]{2, 4, 5, 2}, 20, AllSounds.EQUIP_REINFORCED_BLACKSTONE,
    //     0.0F, 0.1F, () -> Ingredient.of(AllItems.REINFORCED_BLACKSTONE_INGOT.get()));

    // private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    // private final String name;
    // private final int durabilityMultiplier;
    // private final int[] slotProtections;
    // private final int enchantmentValue;
    // private final SoundEvent sound;
    // private final Supplier<SoundEvent> soundSup;
    // private final float toughness;
    // private final float knockbackResistance;
    // private final LazyLoadedValue<Ingredient> repairIngredient;

    // ModArmorMaterials(String name, int durability, int[] protection, int enchantability, SoundEvent sound, float toughness, float kbRes, Supplier<Ingredient> repair) {
    //     this.name = name;
    //     this.durabilityMultiplier = durability;
    //     this.slotProtections = protection;
    //     this.enchantmentValue = enchantability;
    //     this.sound = sound;
    //     this.soundSup = null;
    //     this.toughness = toughness;
    //     this.knockbackResistance = kbRes;
    //     this.repairIngredient = new LazyLoadedValue<>(repair);
    // }

    // ModArmorMaterials(String name, int durability, int[] protection, int enchantability, Supplier<SoundEvent> sound, float toughness, float kbRes, Supplier<Ingredient> repair) {
    //     this.name = name;
    //     this.durabilityMultiplier = durability;
    //     this.slotProtections = protection;
    //     this.enchantmentValue = enchantability;
    //     this.soundSup = sound;
    //     this.sound = null;
    //     this.toughness = toughness;
    //     this.knockbackResistance = kbRes;
    //     this.repairIngredient = new LazyLoadedValue<>(repair);
    // }

    // public int getDurabilityForSlot(EquipmentSlot pSlot) {
    //     return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier;
    // }

    // public int getDefenseForSlot(EquipmentSlot pSlot) {
    //     return this.slotProtections[pSlot.getIndex()];
    // }

    // public int getEnchantmentValue() {
    //     return this.enchantmentValue;
    // }

    // public SoundEvent getEquipSound() {
    //     if (this.soundSup != null) {
    //         return this.soundSup.get();
    //     }
    //     return this.sound;
    // }

    // public Ingredient getRepairIngredient() {
    //     return this.repairIngredient.get();
    // }

    // public String getName() {
    //     return CraftedCuisine.MODID + ":" + this.name;
    // }

    // public float getToughness() {
    //     return this.toughness;
    // }

    // public float getKnockbackResistance() {
    //     return this.knockbackResistance;
    // }
// }
