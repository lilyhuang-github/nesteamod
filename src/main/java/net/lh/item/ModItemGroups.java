package net.lh.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lh.NesteaMod;
import net.lh.potion.teapotion;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
//    public static final ItemGroup NESTEA_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(NesteaMod.MOD_ID, "nestea"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.nestea")).icon(() -> new ItemStack(ModItems.Nestea)).entries((displayContext, entries) -> {
//
//    }));
    public static final ItemGroup NESTEA_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(NesteaMod.MOD_ID, "nestea"),
        FabricItemGroup.builder().displayName(Text.translatable("itemgroup.nesteamod"))
                .icon(() -> new ItemStack(ModItems.Nestea)).entries((displayContext, entries) -> {
                    entries.add(ModItems.TeaLeaf);
                    entries.add(ModItems.Nestea);
                    entries.add(ModItems.emptyCan);
                    entries.add(ModItems.rat);
//                    entries.add(ModItems.Tea);
//                    entries.add(teapotion.TEA);
//                    entries.add(teapotion.Tea);


                }).build());
    public static void registerItemGroups(){
        NesteaMod.LOGGER.info("Registering mod item groups for " + NesteaMod.MOD_ID);
    }
}
