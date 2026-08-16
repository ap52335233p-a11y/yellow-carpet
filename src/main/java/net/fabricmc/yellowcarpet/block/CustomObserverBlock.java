package net.fabricmc.yellowcarpet.block;

import net.minecraft.block.ObserverBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.Random;
import net.minecraft.registry.tag.BlockTags;

public class CustomObserverBlock extends ObserverBlock {
    public CustomObserverBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        // Detects if the block in front is a log
        BlockPos frontPos = pos.offset(state.get(FACING));
        BlockState frontState = world.getBlockState(frontPos);

        if (frontState.isIn(BlockTags.LOGS)) {
            // Triggers custom observer behavior for tree logs
            if (!state.get(POWERED)) {
                world.setBlockState(pos, state.with(POWERED, true), 2);
                world.scheduleBlockTick(pos, this, 2);
            } else {
                world.setBlockState(pos, state.with(POWERED, false), 2);
            }
        }
        super.scheduledTick(state, world, pos, random);
    }
                                    }
