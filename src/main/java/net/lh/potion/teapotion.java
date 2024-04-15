package net.lh.potion;

import net.lh.NesteaMod;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class teapotion {
    public static Potion TEA;
    public static Potion registerPotion(String name){
//        return Registry.register(Registry.P )
//        return Registry.register()
        return Registry.register(Registries.POTION, new Identifier(NesteaMod.MOD_ID, name),
new Potion(new StatusEffectInstance(null, 0,0))
//            new Potion(new StatusEffectInstance(NesteaMod.FREEZE, 200, 0))
                );
    }
    public static void registerPotion(){
       TEA =  registerPotion("tea");
    }


}
