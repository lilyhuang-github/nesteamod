package net.lh.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.lh.NesteaMod;
import net.lh.entity.ModEntities;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawn {
    public static void addEntitySpawns(){
        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(),
                SpawnGroup.CREATURE, ModEntities.Rat, 25, 5, 5

        );
        SpawnRestriction.register(ModEntities.Rat, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn
        );

        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(),
                SpawnGroup.CREATURE, ModEntities.NesteaRat, 25, 5, 5
                );
        SpawnRestriction.register(ModEntities.NesteaRat, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn
                );

        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(),
                SpawnGroup.MONSTER, ModEntities.HostileRat, 25, 5, 5);
        SpawnRestriction.register(ModEntities.HostileRat, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn
                );

//        BiomeModifications.addSpawn();
    }
}
