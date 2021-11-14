package net.ommina.wallpapercraft.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.ommina.wallpapercraft.items.ModItems;
import net.ommina.wallpapercraft.items.PressColour;
import net.ommina.wallpapercraft.items.PressVariant;

public interface IDecorativeBlock {

    String getPostfix();

    String getNameForRegistry();

    String getPattern();

    String getColour();

    String getSuffix();

    default void onBlockClicked( final BlockState state, final Level world, final BlockPos pos, final Player player ) {

        Block block = Blocks.AIR;

        if ( player.getMainHandItem().getItem() == ModItems.PAINTBRUSH )
            block = InWorldHelper.getIncrementedBlockColour( this );
        else if ( player.getMainHandItem().getItem() instanceof PressColour )
            block = InWorldHelper.getBlockFromColourPress( this, (PressColour) player.getMainHandItem().getItem() );
        else if ( player.getMainHandItem().getItem() instanceof PressVariant )
            block = InWorldHelper.getBlockFromVariantPress( this, (PressVariant) player.getMainHandItem().getItem() );

        if ( block == Blocks.AIR )
            return;

        if ( !world.isClientSide )
            world.setBlock( pos, block.defaultBlockState(), 3 );

    }

}
