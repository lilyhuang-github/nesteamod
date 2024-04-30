package net.lh.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.lh.NesteaMod;
import net.lh.entity.custom.EvilRatEntity;
import net.lh.entity.custom.RatEntity;
import net.lh.entity.custom.RatZombieEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.lh.entity.custom.NesteaRat;

public class ModEntities {
    public static void registerModEntities() {
        NesteaMod.LOGGER.info("Registering entities for " + NesteaMod.MOD_ID);
    }
    public static final EntityType<RatEntity> Rat = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(NesteaMod.MOD_ID, "rat"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RatEntity::new)
                            .dimensions(EntityDimensions.fixed(1f, 1f)).build());
    public static final EntityType<NesteaRat> NesteaRat = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(NesteaMod.MOD_ID, "nestearat"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, NesteaRat::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());
    public static final EntityType<EvilRatEntity> HostileRat = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(NesteaMod.MOD_ID, "hostilerat"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, EvilRatEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());
    public static final EntityType<RatZombieEntity> RatZombie = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(NesteaMod.MOD_ID, "hostilerat"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, RatZombieEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());

//    public static final EntityType<RatEntity> NesteaRat = Registry.register(Registries.ENTITY_TYPE,
//            new Identifier(NesteaMod.MOD_ID, "rat"),
//            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RatEntity::new)
//                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());


//    public static final EntityType<RabbitEntity> RABBIT =
//    EntityType.register("rabbit",
//    EntityType.Builder.create(RabbitEntity::new, SpawnGroup.CREATURE).
//    setDimensions(0.4f, 0.5f).
//    maxTrackingRange(8));

//    public static final EntityType<RabbitEntity> RABBIT =
//    EntityType.register("rabbit",
//    EntityType.Builder.create(RabbitEntity::new, SpawnGroup.CREATURE).
//    setDimensions(0.4f, 0.5f).
//    maxTrackingRange(8));

//    public static final EntityType<RatEntity> Rat = Registry.register(Registries.ENTITY_TYPE,
//            new Identifier(NesteaMod.MOD_ID, "rat"),
//            EntityType.Builder.create(EntityType.Builder(RatEntity::new)., SpawnGroup.CREATURE)
//            );

}
