package net.lh.entity.client;

import net.lh.entity.custom.RatEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class RatModel<T extends RatEntity> extends SinglePartEntityModel<T> {
	private final ModelPart bone;
	private final ModelPart bb_main;

	public RatModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create().uv(0, 1).cuboid(-1.0F, 0.0F, -2.0F, 3.0F, 0.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-1.0F, 0.0F, 1.0F, 3.0F, 0.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 2).cuboid(1.0F, 0.0F, -2.0F, 3.0F, 0.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 3).cuboid(1.0F, 0.0F, 1.0F, 3.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 24.0F, 0.0F));

		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, -5.0F, 2.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(0.0F, -1.0F, 2.0F, 0.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(RatEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return bb_main;
	}
}