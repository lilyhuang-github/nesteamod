package net.lh.entity.client;

import net.lh.entity.animation.ModAnimations;
import net.lh.entity.custom.RatEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class RatModel<T extends RatEntity> extends SinglePartEntityModel<T> {
	private final ModelPart legs;
	private final ModelPart rat;
	private final ModelPart head;

	public RatModel(ModelPart root) {
		this.legs = root.getChild("legs");
		this.rat = root.getChild("rat");
		this.head = rat.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData legs = modelPartData.addChild("legs", ModelPartBuilder.create().uv(25, 18).cuboid(-6.0F, -3.0F, 4.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(2.0F, -3.0F, -7.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 4).cuboid(-6.0F, -3.0F, -7.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 8).cuboid(2.0F, -3.0F, 4.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData toes = legs.addChild("toes", ModelPartBuilder.create().uv(0, 29).cuboid(-6.0F, -1.0F, 3.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(24, 26).cuboid(2.0F, -1.0F, 3.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(12, 26).cuboid(2.0F, -1.0F, -8.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 26).cuboid(-6.0F, -1.0F, -8.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rat = modelPartData.addChild("rat", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -7.0F, -8.0F, 12.0F, 4.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData head = rat.addChild("head", ModelPartBuilder.create().uv(0, 18).cuboid(2.0F, -8.0F, -10.0F, 2.0F, 3.0F, 0.0F, new Dilation(0.0F))
		.uv(8, 32).cuboid(-4.0F, -8.0F, -10.0F, 2.0F, 3.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 18).cuboid(-5.0F, -6.0F, -12.0F, 10.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData tail = rat.addChild("tail", ModelPartBuilder.create().uv(12, 29).cuboid(-1.0F, -6.0F, 13.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(20, 29).cuboid(-1.0F, -6.0F, 11.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(28, 29).cuboid(-1.0F, -6.0F, 9.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(30, 22).cuboid(-1.0F, -6.0F, 7.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 32).cuboid(-1.0F, -6.0F, 5.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		legs.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		rat.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return rat;
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);

		this.animateMovement(ModAnimations.WALK, limbAngle, limbDistance, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.IDLE, animationProgress,1f );
	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}
}