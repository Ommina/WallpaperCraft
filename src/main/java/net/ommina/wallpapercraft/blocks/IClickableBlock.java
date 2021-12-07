package net.ommina.wallpapercraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.ommina.wallpapercraft.items.ModItems;
import net.ommina.wallpapercraft.items.PressColour;
import net.ommina.wallpapercraft.items.PressVariant;

public interface IClickableBlock {

    default void onBlockClicked( final BlockState state, final Level world, final BlockPos pos, final Player player ) {

        Block block = Blocks.AIR;

        if ( player.getMainHandItem().getItem() == ModItems.PAINTBRUSH )
            block = InWorldHelper.getIncrementedBlockColour( (IDecorativeBlock) this );
        else if ( player.getMainHandItem().getItem() instanceof PressColour )
            block = InWorldHelper.getBlockFromColourPress( (IDecorativeBlock) this, (PressColour) player.getMainHandItem().getItem() );
        else if ( player.getMainHandItem().getItem() instanceof PressVariant )
            block = InWorldHelper.getBlockFromVariantPress( (IDecorativeBlock) this, (PressVariant) player.getMainHandItem().getItem() );

        if ( block == Blocks.AIR )
            return;

        if ( !world.isClientSide )
            world.setBlock( pos, block.defaultBlockState(), 3 );

    }

}
