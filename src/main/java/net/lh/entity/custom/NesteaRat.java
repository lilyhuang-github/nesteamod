package net.lh.entity.custom;

import net.lh.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;


/*

Special rat entity that can get milked for nestea
 */
public class NesteaRat extends RatEntity{
    public NesteaRat(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(ModItems.emptyCan) && !this.isBaby()) {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0f, 1.0f);
            ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, player, ModItems.Nestea.getDefaultStack());
            player.setStackInHand(hand, itemStack2);
            return ActionResult.success(this.getWorld().isClient);
        }
        return super.interactMob(player, hand);
    }
}
