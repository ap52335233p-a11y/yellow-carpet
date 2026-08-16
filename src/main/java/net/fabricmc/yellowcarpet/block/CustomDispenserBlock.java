package net.fabricmc.yellowcarpet.block;

import net.minecraft.block.DispenserBlock;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BlockItem;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.block.DispenserBehavior;
import net.minecraft.block.Blocks;

public class CustomDispenserBlock extends DispenserBlock {
    public CustomDispenserBlock(Settings settings) {
        super(settings);
        this.registerBehavior();
    }

    private void registerBehavior() {
        DispenserBlock.registerBehavior(net.minecraft.item.Items.OAK_LOG, new DispenserBehavior() {
            @Override
            public ItemStack dispense(BlockPointer pointer, ItemStack stack) {
                ServerWorld world = pointer.world();
                BlockPos targetPos = pointer.pos().offset(pointer.state().get(FACING));
                
                if (world.isAir(targetPos) && stack.getItem() instanceof BlockItem blockItem) {
                    world.setBlockState(targetPos, blockItem.getBlock().getDefaultState());
                    stack.decrement(1);
                    return stack;
                }
                return super.dispense(pointer, stack);
            }
        });
    }
}
