package net.lh.entity.custom.CustomGoal;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.World;

public class ExplosionGoal extends Goal {
    @Override
    public boolean canStart() {
//        this = this.entity.world.getClosestPlayerToEntity(this.entity, 10.0D);
//        return this.target != null && this.target.isAlive();
        return true;
    }

    @Override
    public void start() {
        super.start();

//        this.().createExplosion((Entity) this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 2.0F, true, World.ExplosionSourceType.MOB);
    }
}
