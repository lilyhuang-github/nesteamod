package net.lh.entity.client;

import net.lh.NesteaMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer RAT =
            new EntityModelLayer(new Identifier(NesteaMod.MOD_ID, "rat"), "main");
}
