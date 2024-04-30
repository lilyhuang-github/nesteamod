package net.lh.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

import java.util.function.Predicate;


/*
Harmful rat mob
 */
public class EvilRatEntity extends RatEntity {
    public EvilRatEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }


    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
        this.getWorld().createExplosion((Entity) this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 2.0F, true, World.ExplosionSourceType.MOB);
//        this.getWorld().createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 2.0F, , false));
    }

    @Override
    protected void initGoals() {
//        this.goalSelector.add(2, new AttackGoal(this));
//        this.goalSelector.add(0, new BowAttackGoal<>(this, 1.0, 3, 10.0f));
        this.goalSelector.add(0, new MeleeAttackGoal(this, 2.0D, true));
        this.goalSelector.add(2, new FollowMobGoal(this, 1.0D, 10.0f, 20.0f));
//        this.goalSelector.add(2, new )

        this.goalSelector.add(1, new AvoidSunlightGoal(this));
        Predicate<Difficulty> difficultySufficientPredicate = difficulty -> {
            // Your condition to check if the difficulty is sufficient
            // For example, return true if the difficulty is HARD, false otherwise
            return difficulty == Difficulty.HARD;
        };
        this.goalSelector.add(3, new BreakDoorGoal(this, difficultySufficientPredicate));

        this.goalSelector.add(0, new SwimGoal(this));

        this.goalSelector.add(5, new EscapeDangerGoal(this, 1.25));

        //        this.goalSelector.add(2, new TemptGoal(this, 1.25, Ingredient.ofItems(ModItems.Nestea)), false);

        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1D));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 3f));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createRatAttribute(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f)
                .add(EntityAttributes.GENERIC_ARMOR, 0.0f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2);
    }



}
