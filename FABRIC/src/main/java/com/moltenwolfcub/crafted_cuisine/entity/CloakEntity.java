 package com.moltenwolfcub.crafted_cuisine.entity;

 import com.moltenwolfcub.crafted_cuisine.init.AllSounds;

 import net.minecraft.entity.EntityType;
 import net.minecraft.entity.ai.goal.*;
 import net.minecraft.entity.attribute.DefaultAttributeContainer;
 import net.minecraft.entity.attribute.EntityAttributes;
 import net.minecraft.entity.damage.DamageSource;
 import net.minecraft.entity.mob.HostileEntity;
 import net.minecraft.entity.mob.VindicatorEntity;
 import net.minecraft.entity.mob.WitchEntity;
 import net.minecraft.entity.player.PlayerEntity;
 import net.minecraft.sound.SoundEvent;
 import net.minecraft.sound.SoundEvents;
 import net.minecraft.world.World;
 import software.bernie.geckolib3.core.IAnimatable;
 import software.bernie.geckolib3.core.PlayState;
 import software.bernie.geckolib3.core.builder.AnimationBuilder;
 import software.bernie.geckolib3.core.controller.AnimationController;
 import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
 import software.bernie.geckolib3.core.manager.AnimationData;
 import software.bernie.geckolib3.core.manager.AnimationFactory;

 public class CloakEntity extends HostileEntity implements IAnimatable {
     private static final double MAX_HEALTH = 32;
     private static final double ATTACK_DAMAGE = 4.75;
     private static final double ATTACK_KNOCKBACK = 0.25;
     private static final double KNOCKBACK_RESISTANCE = 0.2;
     private static final double SPEED = 0.3;
     private static final double ARMOR = 3;

     private final AnimationFactory factory = new AnimationFactory(this);

     public CloakEntity(EntityType<? extends HostileEntity> entityType, World level) {
         super(entityType, level);
         this.experiencePoints = 12;
     }

     public static DefaultAttributeContainer.Builder setAttributes() {
         return HostileEntity.createHostileAttributes()
             .add(EntityAttributes.GENERIC_MAX_HEALTH, MAX_HEALTH)
             .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, ATTACK_DAMAGE)
             .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, SPEED)
             .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, ATTACK_KNOCKBACK)
             .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, KNOCKBACK_RESISTANCE)
             .add(EntityAttributes.GENERIC_ARMOR, ARMOR);
     }

     @Override
     protected void initGoals() {
         this.goalSelector.add(0, new SwimGoal(this));
         this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
         this.targetSelector.add(3, new ActiveTargetGoal<>(this, WitchEntity.class, true));
         this.targetSelector.add(3, new ActiveTargetGoal<>(this, VindicatorEntity.class, true));
         this.goalSelector.add(3, new MeleeAttackGoal(this, 1.3D, true));
         this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D));
         this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
         this.goalSelector.add(8, new LookAroundGoal(this));
     }


     @Override
     public void registerControllers(AnimationData data) {
         data.addAnimationController(new AnimationController<>(
             this, "controller", 0, this::predicate));
     }

     private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
         if (event.isMoving()) {
             event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cloak.walk", true));
             return PlayState.CONTINUE;
         }

         event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.cloak.idle", true));
         return PlayState.CONTINUE;
     }

     @Override
     public AnimationFactory getFactory() {
         return this.factory;
     }


     @Override
     protected SoundEvent getAmbientSound() {
         return AllSounds.CLOAK_IDLE;
     }

     @Override
     protected SoundEvent getHurtSound(DamageSource source) {
         return SoundEvents.BLOCK_SCULK_SENSOR_BREAK;
     }

     @Override
     protected SoundEvent getDeathSound() {
         return SoundEvents.ENTITY_PILLAGER_DEATH;
     }

     @Override
     protected float getSoundVolume() {
         return 0.2f;
     }
    
 }
