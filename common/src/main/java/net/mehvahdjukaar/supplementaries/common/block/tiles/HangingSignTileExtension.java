package net.mehvahdjukaar.supplementaries.common.block.tiles;

import net.mehvahdjukaar.moonlight.api.block.WaterBlock;
import net.mehvahdjukaar.moonlight.api.client.anim.PendulumAnimation;
import net.mehvahdjukaar.moonlight.api.client.anim.SwingAnimation;
import net.mehvahdjukaar.moonlight.api.platform.PlatHelper;
import net.mehvahdjukaar.supplementaries.common.block.IRopeConnection;
import net.mehvahdjukaar.supplementaries.common.block.ModBlockProperties;
import net.mehvahdjukaar.supplementaries.configs.ClientConfigs;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

@Deprecated(forRemoval = true)
public class HangingSignTileExtension {

    private final BlockEntity parent;
    @Nullable
    private ModBlockProperties.PostType leftAttachment = null;

    @Nullable
    private ModBlockProperties.PostType rightAttachment = null;

    private final boolean isCeiling;

    private boolean canSwing = true;

    public final SwingAnimation animation;

    public HangingSignTileExtension(BlockEntity blockEntity) {
        super();
        //cheaty. will create on dedicated client on both server and client this as configs are loaded there
        if (PlatHelper.getPhysicalSide().isClient()) {
            animation = new PendulumAnimation(ClientConfigs.Blocks.HANGING_SIGN_CONFIG, this::getRotationAxis);
        } else {
            animation = null;
        }
        isCeiling = blockEntity.getBlockState().getBlock() instanceof CeilingHangingSignBlock;
        this.parent = blockEntity;

    }

    public void clientTick(Level level, BlockPos pos, BlockState state) {
        if (!canSwing) {
            animation.reset();
        } else {
            animation.tick(state.getValue(WaterBlock.WATERLOGGED));
        }
    }

    private Vector3f getRotationAxis() {
        BlockState state = parent.getBlockState();
        return state.hasProperty(WallHangingSignBlock.FACING) ?
                state.getValue(WallHangingSignBlock.FACING).getClockWise().step() :
                new Vector3f(0, 0, 1).rotateY(Mth.DEG_TO_RAD *
                        (90+RotationSegment.convertToDegrees(state.getValue(CeilingHangingSignBlock.ROTATION))));
    }


    public ModBlockProperties.PostType getRightAttachment() {
        return rightAttachment;
    }

    public ModBlockProperties.PostType getLeftAttachment() {
        return leftAttachment;
    }

    public void saveAdditional(CompoundTag tag) {
        if(!isCeiling) {
            if (leftAttachment != null) {
                tag.putByte("left_attachment", (byte) leftAttachment.ordinal());
            }
            if (rightAttachment != null) {
                tag.putByte("right_attachment", (byte) rightAttachment.ordinal());
            }
        }
        if (!canSwing) {
            tag.putBoolean("can_swing", false);
        }
    }

    public void load(CompoundTag tag) {
        if(!isCeiling) {
            if (tag.contains("left_attachment")) {
                leftAttachment = ModBlockProperties.PostType.values()[tag.getByte("left_attachment")];
            }
            if (tag.contains("right_attachment")) {
                rightAttachment = ModBlockProperties.PostType.values()[tag.getByte("right_attachment")];
            }
        }
        if (tag.contains("can_swing")) {
            canSwing = tag.getBoolean("can_swing");
        }
    }


    //just called by wall hanging sign
    public void updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level,
                            BlockPos pos, BlockPos neighborPos) {

        if(!isCeiling) {
            Direction selfFacing = state.getValue(WallHangingSignBlock.FACING);
            if (direction == selfFacing.getClockWise()) {
                rightAttachment = ModBlockProperties.PostType.get(neighborState, true);
                if(level instanceof Level l)
                   l.sendBlockUpdated(pos, state, state, Block.UPDATE_CLIENTS);
            } else if (direction == selfFacing.getCounterClockWise()) {
                leftAttachment = ModBlockProperties.PostType.get(neighborState, true);
                if(level instanceof Level l)
                  l.sendBlockUpdated(pos, state, state, Block.UPDATE_CLIENTS);
            }
        }
        if (direction == Direction.DOWN) {
            canSwing = (isCeiling && state.getValue(CeilingHangingSignBlock.ATTACHED)) || !IRopeConnection.canConnectDown(neighborState);
        }
    }

    public void updateAttachments(Level level, BlockPos pos, BlockState state) {
        if(!isCeiling) {
            Direction selfFacing = state.getValue(WallHangingSignBlock.FACING);

            rightAttachment = ModBlockProperties.PostType.get(level.getBlockState(pos.relative(selfFacing.getClockWise())), true);
            leftAttachment = ModBlockProperties.PostType.get(level.getBlockState(pos.relative(selfFacing.getCounterClockWise())), true);
        }
        BlockState below = level.getBlockState(pos.below());
        canSwing = (isCeiling && state.getValue(CeilingHangingSignBlock.ATTACHED)) || !IRopeConnection.canConnectDown(below);

    }

    public boolean canSwing() {
        return canSwing;
    }
}
