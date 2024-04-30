package net.lh.entity.custom;

import net.lh.item.ModItems;
import net.minecraft.client.model.ModelPart;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;



/*
STANDARD RAT ENTITY
 */
public class RatEntity extends AnimalEntity {
    public RatEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }
    public final AnimationState idleAnimationState = new AnimationState();

    private int idleAnimationTimeout = 0;


    private void setUpAnimationStates(){
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }
    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient){
            setUpAnimationStates();
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.25));

        this.goalSelector.add(5, new AnimalMateGoal(this, 1.15));
//        this.goalSelector.add(2, new TemptGoal(this, 1.25, Ingredient.ofItems(ModItems.Nestea)), false);
        this.goalSelector.add(2, new TemptGoal(this, 1.25f, Ingredient.ofItems(ModItems.TeaLeaf), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.25d));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1D));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 3f));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createRatAttribute(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f)
                .add(EntityAttributes.GENERIC_ARMOR, 0.0f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
//        return super.isBreedingItem(Ite);
        return stack.isOf(Items.BAKED_POTATO);
    }


    @Override
    protected void drop(DamageSource source) {
        dropXp();
        dropItem(ModItems.rat);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SILVERFISH_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_DOLPHIN_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER;
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
}
