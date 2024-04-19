package net.lh.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.lh.NesteaMod;
import net.lh.entity.custom.RatEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static void registerModEntities() {
        NesteaMod.LOGGER.info("Registering entities for " + NesteaMod.MOD_ID);
    }
    public static final EntityType<RatEntity> Rat = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(NesteaMod.MOD_ID, "rat"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RatEntity::new)
                            .dimensions(EntityDimensions.fixed(1f, 1f)).build());

//    public static final EntityType<RatEntity> Rat = Registry.register(Registries.ENTITY_TYPE,
//            new Identifier(NesteaMod.MOD_ID, "rat"),
//            EntityType.Builder.create(EntityType.Builder(RatEntity::new)., SpawnGroup.CREATURE)
//            );

}
