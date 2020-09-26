package net.ommina.wallpapercraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.ommina.wallpapercraft.items.PressColour;
import net.ommina.wallpapercraft.items.PressVariant;

import javax.annotation.Nullable;

public class InWorldHelper {

    @Nullable
    public static Block getIncrementedBlockColour( final IDecorativeBlock blockIn ) {

        final String sourceNamespace = ((Block) blockIn).getRegistryName().getNamespace();

        Block block = ForgeRegistries.BLOCKS.getValue( getName( sourceNamespace, blockIn.getPattern(), ModBlocks.getNextColour( blockIn.getColour(), 1 ), blockIn.getSuffix() ) );

        if ( block == null )
            block = ForgeRegistries.BLOCKS.getValue( getName( sourceNamespace, blockIn.getPattern(), ModBlocks.getNextColour( blockIn.getColour(), 2 ), blockIn.getSuffix() ) );

        if ( block == null )
            return null;

        return block;

    }

    @Nullable
    public static Block getBlockFromColourPress( final IDecorativeBlock blockIn, final PressColour pressColour ) {

        final String sourceNamespace = ((Block) blockIn).getRegistryName().getNamespace();

        return ForgeRegistries.BLOCKS.getValue( getName( sourceNamespace, blockIn.getPattern(), pressColour.getColour(), blockIn.getSuffix() ) );

    }

    @Nullable
    public static Block getBlockFromVariantPress( final IDecorativeBlock blockIn, final PressVariant pressVariant ) {

        final String sourceNamespace = ((Block) blockIn).getRegistryName().getNamespace();

        return ForgeRegistries.BLOCKS.getValue( getName( sourceNamespace, blockIn.getPattern(), blockIn.getColour(), pressVariant.getVariant() ) );

    }

    private static ResourceLocation getName( final String namespace, final String pattern, final String colour, final String suffix ) {
        return new ResourceLocation( namespace, pattern + colour + suffix );
    }

}
