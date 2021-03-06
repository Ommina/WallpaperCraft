package net.ommina.wallpapercraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;
import net.ommina.wallpapercraft.items.ModItems;
import net.ommina.wallpapercraft.items.PressColour;
import net.ommina.wallpapercraft.items.PressVariant;
import net.ommina.wallpapercraft.sounds.ModSoundType;

import javax.annotation.Nullable;

public class DecorativeCarpet extends DecorativeBlockPatterned implements IDecorativeBlock {

    protected static final VoxelShape SHAPE = Block.makeCuboidShape( 0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D );

    private static final String POSTFIX = "_carpet";

    private final DyeColor color;

    public DecorativeCarpet( final String pattern, final String colour, final int suffix, final DyeColor dyeColor, final Material material, final ToolType toolType, final SoundType soundType, final float hardness, final int light ) {
        super( pattern, colour, suffix, material, toolType, soundType, hardness, light );

        this.color = dyeColor;

    }

    //region Overrides

    @Override
    public SoundType getSoundType( final BlockState state, final IWorldReader world, final BlockPos pos, @Nullable final Entity entity ) {

        if ( !(entity instanceof PlayerEntity) )
            return SoundType.CLOTH;

        final PlayerEntity player = (PlayerEntity) entity;

        if ( player.getHeldItemMainhand().isEmpty() )
            return SoundType.CLOTH;

        if ( player.getHeldItemMainhand().getItem() == ModItems.PAINTBRUSH || player.getHeldItemMainhand().getItem() instanceof PressColour || player.getHeldItemMainhand().getItem() instanceof PressVariant )
            return ModSoundType.BLOCK_CHANGE;

        return SoundType.CLOTH;

    }

    @Override
    public String getPostfix() {
        return POSTFIX;
    }

    @Override
    public String getNameForRegistry() {
        return this.pattern + this.colour + this.suffix + POSTFIX;
    }

    @Override
    public BlockState updatePostPlacement( final BlockState blockState, final Direction direction, final BlockState blockState1, final IWorld world, final BlockPos blockPos, final BlockPos blockPos1 ) {
        return !blockState.isValidPosition( world, blockPos ) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement( blockState, direction, blockState1, world, blockPos, blockPos1 );
    }

    @Override
    public boolean isValidPosition( final BlockState blockState, final IWorldReader worldReader, final BlockPos blockPos ) {
        return !worldReader.isAirBlock( blockPos.down() );
    }

    @Override
    public VoxelShape getShape( final BlockState state, final IBlockReader blockReader, final BlockPos blockPos, final ISelectionContext selectionContext ) {
        return SHAPE;
    }
//endregion Overrides

    public DyeColor getColor() {
        return this.color;
    }

}
