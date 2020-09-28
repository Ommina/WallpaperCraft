package net.ommina.wallpapercraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.ommina.wallpapercraft.items.ModItems;
import net.ommina.wallpapercraft.items.PressColour;
import net.ommina.wallpapercraft.items.PressVariant;

public interface IDecorativeBlock {

    String getPostfix();

    String getNameForRegistry();

    String getPattern();

    String getColour();

    String getSuffix();

    default void onBlockClicked( final BlockState state, final World world, final BlockPos pos, final PlayerEntity player ) {

        Block block = Blocks.AIR;

        if ( player.getHeldItemMainhand().getItem() == ModItems.PAINTBRUSH )
            block = InWorldHelper.getIncrementedBlockColour( this );
        else if ( player.getHeldItemMainhand().getItem() instanceof PressColour )
            block = InWorldHelper.getBlockFromColourPress( this, (PressColour) player.getHeldItemMainhand().getItem() );
        else if ( player.getHeldItemMainhand().getItem() instanceof PressVariant )
            block = InWorldHelper.getBlockFromVariantPress( this, (PressVariant) player.getHeldItemMainhand().getItem() );

        if ( block == Blocks.AIR )
            return;

        if ( !world.isRemote )
            world.setBlockState( pos, block.getDefaultState(), 3 );

    }

}
