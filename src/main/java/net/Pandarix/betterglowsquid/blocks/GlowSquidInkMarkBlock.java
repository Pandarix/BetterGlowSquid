package net.Pandarix.betterglowsquid.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class GlowSquidInkMarkBlock extends DirectionalBlock {

    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final IntegerProperty MODEL = IntegerProperty.create("ink_mark_model", 0, 5);

    public GlowSquidInkMarkBlock(Properties p_52591_) {
        super(p_52591_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP).setValue(MODEL, 0));
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction direction = pContext.getClickedFace();
        BlockState blockstate = pContext.getLevel().getBlockState(pContext.getClickedPos().relative(direction.getOpposite()));

        int model = 0;

        switch (direction) {
            case UP    -> model = 0;
            case DOWN  -> model = 1;
            case EAST  -> model = 2;
            case WEST  -> model = 3;
            case NORTH -> model = 4;
            case SOUTH -> model = 5;
            default    -> model = 0;
        }

        return blockstate.is(this) && blockstate.getValue(FACING) == direction ? this.defaultBlockState().setValue(FACING, direction.getOpposite()).setValue(MODEL, model) : this.defaultBlockState().setValue(FACING, direction);
    }

    public void animateTick(BlockState pState, @NotNull Level pLevel, BlockPos pPos, RandomSource pRandom) {
        Direction direction = pState.getValue(FACING);
        double d0 = (double) pPos.getX() + 0.55D - (double) (pRandom.nextFloat() * 0.1F);
        double d1 = (double) pPos.getY() + 0.55D - (double) (pRandom.nextFloat() * 0.1F);
        double d2 = (double) pPos.getZ() + 0.55D - (double) (pRandom.nextFloat() * 0.1F);
        double d3 = (double) (0.4F - (pRandom.nextFloat() + pRandom.nextFloat()) * 0.4F);
        if (pRandom.nextInt(5) == 0) {
            pLevel.addParticle(ParticleTypes.END_ROD, d0 + (double) direction.getStepX() * d3, d1 + (double) direction.getStepY() * d3, d2 + (double) direction.getStepZ() * d3, pRandom.nextGaussian() * 0.005D, pRandom.nextGaussian() * 0.005D, pRandom.nextGaussian() * 0.005D);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING).add(MODEL);
    }

    public @NotNull PushReaction getPistonPushReaction(BlockState pState) {
        return PushReaction.DESTROY;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

}
