package net.lh.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lh.NesteaMod;
import net.lh.potion.teapotion;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item Nestea = registerItem("nestea", new Item(new FabricItemSettings()));
    public static final Item TeaLeaf = registerItem("tealeaf", new Item(new FabricItemSettings()));
    private static final void addItemToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(Nestea);
        entries.add(TeaLeaf);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(NesteaMod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        ModItemGroups.registerItemGroups();
//        teapotion.registerPotion();
        NesteaMod.LOGGER.info("Registering mod items for " + NesteaMod.MOD_ID);
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemToIngredientItemGroup);
    };
}
