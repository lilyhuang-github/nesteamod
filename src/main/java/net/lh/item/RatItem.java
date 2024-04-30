package net.lh.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lh.NesteaMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.Spawner;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;

public class RatItem extends Item {
    public RatItem(){
        super(new FabricItemSettings());
    }

    public RatItem(Settings settings) {
        super(settings);
    }
//        @Override
//    public ActionResult useOnBlock(ItemUsageContext context) {
//        EntityType<?> entityType;
//        World world = context.getWorld();
//        if (!(world instanceof ServerWorld)) {
//            return ActionResult.SUCCESS;
//        }
//        ItemStack itemStack = context.getStack();
//        BlockPos blockPos = context.getBlockPos();
//        Direction direction = context.getSide();
//        BlockState blockState = world.getBlockState(blockPos);
//        BlockEntity blockEntity = world.getBlockEntity(blockPos);
//        if (blockEntity instanceof Spawner) {
//            Spawner spawner = (Spawner)((Object)blockEntity);
////            entityType = EntityType<RatEntity> rat;
////            entityType = EntityTy
////            public static final EntityType<RabbitEntity> RABBIT =
////    EntityType.register("rabbit",
////    EntityType.Builder.create(RabbitEntity::new, SpawnGroup.CREATURE).
////    setDimensions(0.4f, 0.5f).
////    maxTrackingRange(8));
////            public static final EntityType<Rat> RAT = EntityType.register("rat")
////                    spawner.setEntityType(EntityType< NesteaMod. >, world.getRandom());
//            world.updateListeners(blockPos, blockState, blockState, Block.NOTIFY_ALL);
//            world.emitGameEvent((Entity)context.getPlayer(), GameEvent.BLOCK_CHANGE, blockPos);
//            itemStack.decrement(1);
//            return ActionResult.CONSUME;
//        }
//        BlockPos blockPos2 = blockState.getCollisionShape(world, blockPos).isEmpty() ? blockPos : blockPos.offset(direction);
//        entityType = EntityType.RABBIT;
//        if (entityType.spawnFromItemStack((ServerWorld)world, itemStack, context.getPlayer(), blockPos2, SpawnReason.SPAWN_EGG, true, !Objects.equals(blockPos, blockPos2) && direction == Direction.UP) != null) {
//            itemStack.decrement(1);
//            world.emitGameEvent((Entity)context.getPlayer(), GameEvent.ENTITY_PLACE, blockPos);
//        }
//        return ActionResult.CONSUME;
//    }

}
