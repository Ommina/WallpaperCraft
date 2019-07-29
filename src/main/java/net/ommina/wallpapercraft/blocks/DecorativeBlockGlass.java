package net.ommina.wallpapercraft.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

public class DecorativeBlockGlass extends DecorativeBlockPatterned {

    public DecorativeBlockGlass( final String variant, final String colour, final int suffix, final Material material, final SoundType soundType, final int light ) {
        super( variant, colour, suffix, material, soundType, light );
    }

    @Nonnull
    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean propagatesSkylightDown( BlockState state, IBlockReader reader, BlockPos pos ) {
        return true;
    }

    @Override
    public boolean causesSuffocation( BlockState state, IBlockReader worldIn, BlockPos pos ) {
        return false;
    }

    @Override
    public boolean canEntitySpawn( BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type ) {
        return false;
    }

    @Override
    public boolean isNormalCube( BlockState state, IBlockReader worldIn, BlockPos pos ) {
        return false;
    }

    @OnlyIn( Dist.CLIENT )
    @Override
    public boolean isSideInvisible( BlockState state, BlockState adjacentBlockState, Direction side ) {

        return adjacentBlockState.getBlock() == this || super.isSideInvisible( state, adjacentBlockState, side );
    }

}
