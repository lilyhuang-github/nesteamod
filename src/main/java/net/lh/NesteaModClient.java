package net.lh;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.lh.entity.ModEntities;
import net.lh.entity.client.*;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class NesteaModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(){

        EntityRendererRegistry.register(ModEntities.Rat, RatRenderer::new);
        EntityRendererRegistry.register(ModEntities.NesteaRat, NesteaRatRenderer::new);
        EntityRendererRegistry.register(ModEntities.HostileRat, EvilRatRenderer::new);
        EntityRendererRegistry.register(ModEntities.RatZombie, ZombieEntityRenderer::new);
//
//        RatRenderer
//        EntityRendererRegistry.register(ModEntities.NesteaRat,
//                (dispatcher, context) -> new RatRenderer(context, "rat_mob.png")
//                );
//        EntityRendererRegistry.register(ModEntities.NesteaRat,
//                (dispatcher, context) -> new RatRenderer(context, "rat_mob.png")
//        );

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RAT, RatModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.NESTEARAT, RatModel::getTexturedModelData);
    }
}
