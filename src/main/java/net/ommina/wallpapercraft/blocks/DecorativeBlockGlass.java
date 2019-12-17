package net.ommina.wallpapercraft.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DecorativeBlockGlass extends DecorativeBlockPatterned {

    public DecorativeBlockGlass( final String variant, final String colour, final int suffix, final Material material, final SoundType soundType, final int light ) {
        super( variant, colour, suffix, material, soundType, light );
    }

//region Overrides
    public boolean canEntitySpawn( BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type ) {
        return false;
    }

    public boolean isNormalCube( BlockState state, IBlockReader worldIn, BlockPos pos ) {
        return false;
    }

    public boolean func_229869_c_( BlockState p_229869_1_, IBlockReader p_229869_2_, BlockPos p_229869_3_ ) {
        return false;
    }

    @OnlyIn( Dist.CLIENT )
    public boolean isSideInvisible( BlockState state, BlockState adjacentBlockState, Direction side ) {
        return adjacentBlockState.getBlock() == this || super.isSideInvisible( state, adjacentBlockState, side );
    }

    public boolean propagatesSkylightDown( BlockState state, IBlockReader reader, BlockPos pos ) {
        return true;
    }

    @OnlyIn( Dist.CLIENT )
    public float getAmbientOcclusionLightValue( BlockState p_220080_1_, IBlockReader p_220080_2_, BlockPos p_220080_3_ ) {
        return 0.2F;
    }


    @Deprecated
    public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0;
    }

//endregion Overrides

/*

    //region Overrides

    //@Nonnull
    //@Override
    //public BlockRenderLayer getRenderLayer() {
    //    return BlockRenderLayer.TRANSLUCENT;
    //}
    @Override
    public boolean canEntitySpawn( BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type ) {
        return false;
    }

    @Override
    public boolean isNormalCube( BlockState state, IBlockReader worldIn, BlockPos pos ) {
        return false;
    }

    @Override
    public BlockRenderType getRenderType( final BlockState state ) {
        return BlockRenderType.MODEL;
    }


    @OnlyIn( Dist.CLIENT )
    @Override
    public boolean isSideInvisible( BlockState state, BlockState adjacentBlockState, Direction side ) {

        return adjacentBlockState.getBlock() == this || super.isSideInvisible( state, adjacentBlockState, side );
    }

    @Override
    public boolean propagatesSkylightDown( BlockState state, IBlockReader reader, BlockPos pos ) {
        return true;
    }
//endregion Overrides

    //@Override
    //public boolean causesSuffocation( BlockState state, IBlockReader worldIn, BlockPos pos ) {
    //    return false;
    //}
*/
}
