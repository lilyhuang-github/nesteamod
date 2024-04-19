package net.lh.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lh.NesteaMod;
import net.lh.entity.ModEntities;
import net.lh.potion.teapotion;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.lh.item.Nestea;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class ModItems {
    public static final Item Nestea = registerItem("nestea", new Nestea());
//    public static final Item Nestea =  registerItem("nestea", new Item(new FabricItemSettings().food(ModFoodComponent.nestea)));
    public static final Item TeaLeaf = registerItem("tealeaf", new Item(new FabricItemSettings()));
    public static final Item emptyCan = registerItem("emptycan", new Item(new FabricItemSettings()));
    public static final Item rat = registerItem("rat", new Item(new FabricItemSettings()));
//    public static final Item rat = registerItem("rat", new rat(new FabricItemSettings()));



    public static final Item RAT_HELMET = registerItem("rat_helmet", new ArmorItem(ModArmorMaterials.Rat, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item RAT_CHESTPLATE = registerItem("rat_chestplate", new ArmorItem(ModArmorMaterials.Rat, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item RAT_LEGGINGS = registerItem("rat_leggings", new ArmorItem(ModArmorMaterials.Rat, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item RAT_BOOTS = registerItem("rat_boots", new ArmorItem(ModArmorMaterials.Rat, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item RAT_SPAWN_EGG = registerItem("rat_spawn_egg",
            new SpawnEggItem(ModEntities.Rat, 0xa86518, 0x3b260f, new FabricItemSettings()));

    //    public static final Item Tea = registerItem("Tea", new PotionItem(new FabricItemSettings()));
//    public static final Item tea = Registry.POTION
//Potion existingTeaPotion = Registry.POTION.get(new Identifier(NesteaMod.MOD_ID, "tea"));
//    public static final Item Tea = registerItem("Tea", new PotionItem(new FabricItemSettings().food(teapotion.TEA)));
//    Potion existingTeaPotion = Registry.POTION
    private static final void addItemToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(Nestea);
        entries.add(TeaLeaf);
        entries.add(emptyCan);
        entries.add(rat);

//        entries.add(Tea);
//        entries.add()
//        entries.add(teapotion.TEA);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(NesteaMod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        ModItemGroups.registerItemGroups();
//        teapotion.registerPotion();
        teapotion.registerPotions();
        NesteaMod.LOGGER.info("Registering mod items for " + NesteaMod.MOD_ID);
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemToIngredientItemGroup);
    };
}
