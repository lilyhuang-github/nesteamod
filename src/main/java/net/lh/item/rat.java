//package net.lh.item;
//
//import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
//import net.lh.entity.custom.RatEntity;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.entity.BlockEntity;
//import net.minecraft.block.entity.Spawner;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.SpawnReason;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.ItemUsageContext;
//import net.minecraft.server.world.ServerWorld;
//import net.minecraft.util.ActionResult;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Direction;
//import net.minecraft.world.World;
//import net.minecraft.world.event.GameEvent;
//
//import java.util.Objects;
//
//public class rat extends Item {
//    public rat() {
//        super(new FabricItemSettings());
//    }
//    public rat(Settings settings) {
//        super(settings);
//    }
//
//    @Override
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
//            entityType = EntityType<RatEntity> rat;
//            spawner.setEntityType(entityType, world.getRandom());
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
//
//}
