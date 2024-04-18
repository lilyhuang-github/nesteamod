package net.lh;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.lh.entity.ModEntities;
import net.lh.entity.client.ModModelLayers;
import net.lh.entity.client.RatModel;
import net.lh.entity.client.RatRenderer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class NesteaModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(){

        EntityRendererRegistry.register(ModEntities.Rat, RatRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RAT, RatModel::getTexturedModelData);
    }
}
