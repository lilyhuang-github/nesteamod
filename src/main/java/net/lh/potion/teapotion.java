package net.lh.potion;

import net.lh.NesteaMod;
import net.lh.item.ModItems;
//import net.lh.mixin.BrewingRecipeRegistryAccessor;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
//import net.minecraft.recipe.BrewingRecipeRegistryMixin;


public class teapotion extends Potion {
    public static Potion TEA;
    public static Potion registerPotion(String name, StatusEffectInstance effect){
//        return Registry.register(Registry.P )
//        return Registry.register()
        return Registry.register(Registries.POTION, new Identifier(NesteaMod.MOD_ID, name),
        new Potion(effect)
//            new Potion(new StatusEffectInstance(NesteaMod.FREEZE, 200, 0))
                );
    }
    public static void registerPotions(){
       TEA =  registerPotion("tea", new StatusEffectInstance(StatusEffects.SPEED, 100,3));
        registerPotionRecipe();

    }


    public static void registerPotionRecipe(){
//        BrewingRecipeRegistryMixin.
//        BrewingRecipeRegistryMixin.in
//        BrewingRecipeRegistryMixin.
//        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.EXAMPLE_POTION, Items.REDSTONE, ModPotions.LONG_EXAMPLE_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(Potions.WATER, ModItems.TeaLeaf, teapotion.TEA);
//        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(Potions.WATER, ModItems.TeaLeaf, teapotion.TEA);
//        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.WATER, ModItems.TeaLeaf, teapotion.TEA);
//        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe
    }


}
