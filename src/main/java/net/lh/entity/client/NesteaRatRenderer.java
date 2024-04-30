package net.lh.entity.client;

import net.lh.NesteaMod;
import net.lh.entity.custom.RatEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class NesteaRatRenderer extends MobEntityRenderer<RatEntity, RatModel<RatEntity>> {
//    private static final Identifier TEXTURE = new Identifier(NesteaMod.MOD_ID, "textures/entity/rat_mob.png");
    public static String location = "textures/entity/";
    public static final Identifier TEXTURE = new Identifier(NesteaMod.MOD_ID, "textures/entity/nestea_rat_mob.png");
//    public void setLocation(String path){
//        TEXTURE = new Identifier(NesteaMod.MOD_ID, "textures/entity/" + path);
//
//
//    }

    public NesteaRatRenderer(EntityRendererFactory.Context context) {
        super(context, new RatModel<>(context.getPart(ModModelLayers.RAT)), 0.f);
//        setLocation(texture);
    }


    @Override
    public Identifier getTexture(RatEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(RatEntity mobEntity, float f, float g,
                       MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()){
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        }
        else{
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
