package com.moltenwolfcub.crafted_cuisine.entity;

import com.moltenwolfcub.crafted_cuisine.init.AllSounds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class CloakEntity extends Monster {
    private static final double MAX_HEALTH = 32;
    private static final double ATTACK_DAMAGE = 4.75;
    private static final double ATTACK_KNOCKBACK = 0.25;
    private static final double KNOCKBACK_RESISTANCE = 0.2;
    private static final double SPEED = 0.3;
    private static final double ARMOR = 3;

    public CloakEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.xpReward = 12;
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
            .add(Attributes.MAX_HEALTH, MAX_HEALTH)
            .add(Attributes.ATTACK_DAMAGE, ATTACK_DAMAGE)
            .add(Attributes.MOVEMENT_SPEED, SPEED)
            .add(Attributes.ATTACK_KNOCKBACK, ATTACK_KNOCKBACK)
            .add(Attributes.KNOCKBACK_RESISTANCE, KNOCKBACK_RESISTANCE)
            .add(Attributes.ARMOR, ARMOR);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Witch.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Vindicator.class, true));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.3D, true));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return AllSounds.CLOAK_IDLE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.SCULK_SENSOR_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.PILLAGER_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 0.2f;
    }

}
