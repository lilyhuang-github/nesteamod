package net.lh.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class Nestea extends Item {
    public Nestea() {
        super(new FabricItemSettings().food(ModFoodComponent.nestea));
    }
    public Nestea(Settings settings) {
        super(new FabricItemSettings().food(ModFoodComponent.nestea));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        PlayerEntity playerEntity;
        PlayerEntity playerEntity2 = playerEntity = user instanceof PlayerEntity ? (PlayerEntity)user : null;

        if (playerEntity == null || !playerEntity.getAbilities().creativeMode) {
            if (stack.isEmpty()) {
                return new ItemStack(ModItems.emptyCan);
            }
            if (playerEntity != null) {
                playerEntity.getInventory().insertStack(new ItemStack(ModItems.emptyCan));
            }
        }
        user.emitGameEvent(GameEvent.DRINK);
        return super.finishUsing(stack, world, user);
    }
}
