package net.lh.entity.client;

import net.lh.NesteaMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import javax.swing.text.html.parser.Entity;

public class ModModelLayers {
    public static final EntityModelLayer RAT =
            new EntityModelLayer(new Identifier(NesteaMod.MOD_ID, "rat"), "main");
    public static final EntityModelLayer NESTEARAT =
            new EntityModelLayer(new Identifier(NesteaMod.MOD_ID, "nestearat"), "main");
}
