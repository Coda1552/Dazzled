package coda.overtherainbow.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BeehiveBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.Nullable;

public class GnomeHomeBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public GnomeHomeBlock(Properties p_49224_) {
        super(p_49224_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    private boolean homeContainsGnomes(Level p_49655_, BlockPos p_49656_) {
        BlockEntity blockentity = p_49655_.getBlockEntity(p_49656_);
        if (blockentity instanceof BeehiveBlockEntity) {
            BeehiveBlockEntity beehiveblockentity = (BeehiveBlockEntity)blockentity;
            return !beehiveblockentity.isEmpty();
        } else {
            return false;
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_49573_) {
        return this.defaultBlockState().setValue(FACING, p_49573_.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49646_) {
        p_49646_.add(FACING);
    }

    public RenderShape getRenderShape(BlockState p_49653_) {
        return RenderShape.MODEL;
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos p_152184_, BlockState p_152185_) {
        return new BeehiveBlockEntity(p_152184_, p_152185_);
    }

    public BlockState updateShape(BlockState p_49639_, Direction p_49640_, BlockState p_49641_, LevelAccessor p_49642_, BlockPos p_49643_, BlockPos p_49644_) {
        if (p_49642_.getBlockState(p_49644_).getBlock() instanceof FireBlock) {
            BlockEntity blockentity = p_49642_.getBlockEntity(p_49643_);
            if (blockentity instanceof BeehiveBlockEntity) {
                BeehiveBlockEntity beehiveblockentity = (BeehiveBlockEntity)blockentity;
                beehiveblockentity.emptyAllLivingFromHive((Player)null, p_49639_, BeehiveBlockEntity.BeeReleaseStatus.EMERGENCY);
            }
        }

        return super.updateShape(p_49639_, p_49640_, p_49641_, p_49642_, p_49643_, p_49644_);
    }
}
