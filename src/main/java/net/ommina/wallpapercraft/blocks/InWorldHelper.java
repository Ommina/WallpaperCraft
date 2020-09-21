package net.ommina.wallpapercraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.ommina.wallpapercraft.items.PressColour;
import net.ommina.wallpapercraft.items.PressVariant;

public class InWorldHelper {

    public static BlockState getIncrementedBlockColour( final IDecorativeBlock blockIn ) {

        Block block = (Block) ModBlocks.BLOCKS.get( getRegistryName( blockIn.getPattern(), ModBlocks.getNextColour( blockIn.getColour(), 1 ), blockIn.getSuffix(), blockIn ) );

        if ( block == null )
            block = (Block) ModBlocks.BLOCKS.get( getRegistryName( blockIn.getPattern(), ModBlocks.getNextColour( blockIn.getColour(), 2 ), blockIn.getSuffix(), blockIn ) );

        if ( block == null )
            return null;

        return block.getDefaultState();

    }

    public static BlockState getBlockFromColourPress( final IDecorativeBlock blockIn, final PressColour pressColour ) {

        final Block block = (Block) ModBlocks.BLOCKS.get( getRegistryName( blockIn.getPattern(), pressColour.getColour(), blockIn.getSuffix(), blockIn ) );

        if ( block == null )
            return null;

        return block.getDefaultState();

    }

    public static BlockState getBlockFromVariantPress( final IDecorativeBlock blockIn, final PressVariant pressVariant ) {

        final Block block = (Block) ModBlocks.BLOCKS.get( getRegistryName( blockIn.getPattern(), blockIn.getColour(), pressVariant.getVariant(), blockIn ) );

        if ( block == null )
            return null;

        return block.getDefaultState();

    }

    private static String getRegistryName( final String pattern, final String colour, final String suffix, final IDecorativeBlock block ) {
        return pattern + colour + suffix + block.getPostfix();
    }

}
