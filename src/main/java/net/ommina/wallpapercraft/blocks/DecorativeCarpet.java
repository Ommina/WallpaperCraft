package net.ommina.wallpapercraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.ommina.wallpapercraft.items.ModItems;
import net.ommina.wallpapercraft.items.PressColour;
import net.ommina.wallpapercraft.items.PressVariant;
import net.ommina.wallpapercraft.sounds.ModSoundType;

import javax.annotation.Nullable;

public class DecorativeCarpet extends DecorativeBlockPatterned implements IDecorativeBlock {

    protected static final VoxelShape SHAPE = Block.box( 0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D );

    private static final String POSTFIX = "_carpet";

    private final DyeColor color;

    public DecorativeCarpet( final String pattern, final String colour, final int suffix, final DyeColor dyeColor, final Material material, final SoundType soundType, final float hardness, final int light ) {
        super( pattern, colour, suffix, material, soundType, hardness, light );

        this.color = dyeColor;

    }

    //region Overrides
    @Override
    public String getPostfix() {
        return POSTFIX;
    }

    @Override
    public String getNameForRegistry() {
        return this.pattern + this.colour + this.suffix + POSTFIX;
    }

    @Override
    public SoundType getSoundType( final BlockState state, final LevelReader world, final BlockPos pos, @Nullable final Entity entity ) {

        if ( !(entity instanceof Player) )
            return SoundType.WOOL;

        final Player player = (Player) entity;

        if ( player.getMainHandItem().isEmpty() )
            return SoundType.WOOL;

        if ( player.getMainHandItem().getItem() == ModItems.PAINTBRUSH || player.getMainHandItem().getItem() instanceof PressColour || player.getMainHandItem().getItem() instanceof PressVariant )
            return ModSoundType.BLOCK_CHANGE;

        return SoundType.WOOL;

    }

    @Override
    public BlockState updateShape( final BlockState blockState, final Direction direction, final BlockState blockState1, final LevelAccessor world, final BlockPos blockPos, final BlockPos blockPos1 ) {
        return !blockState.canSurvive( world, blockPos ) ? Blocks.AIR.defaultBlockState() : super.updateShape( blockState, direction, blockState1, world, blockPos, blockPos1 );
    }

    @Override
    public boolean canSurvive( final BlockState blockState, final LevelReader worldReader, final BlockPos blockPos ) {
        return !worldReader.isEmptyBlock( blockPos.below() );
    }

    @Override
    public VoxelShape getShape( final BlockState state, final BlockGetter blockReader, final BlockPos blockPos, final CollisionContext selectionContext ) {
        return SHAPE;
    }
//endregion Overrides

    public DyeColor getColor() {
        return this.color;
    }

}
