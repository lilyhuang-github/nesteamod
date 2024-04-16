package net.lh.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponent {

    public static final FoodComponent nestea = new FoodComponent.Builder().hunger(1).saturationModifier(.25f)
//            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 1000, 25))
            .build();
}
