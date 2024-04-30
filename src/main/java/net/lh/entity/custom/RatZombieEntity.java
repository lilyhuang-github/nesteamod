package net.lh.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

public class RatZombieEntity extends ZombieEntity {
    public RatZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }
}
