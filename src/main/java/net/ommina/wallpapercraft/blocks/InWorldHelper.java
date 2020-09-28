package net.ommina.wallpapercraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.ommina.wallpapercraft.Wallpapercraft;
import net.ommina.wallpapercraft.items.PressColour;
import net.ommina.wallpapercraft.items.PressVariant;

import javax.annotation.Nullable;

public class InWorldHelper {

    @Nullable
    public static Block getIncrementedBlockColour( final IDecorativeBlock blockIn ) {

        final String sourceNamespace = ((Block) blockIn).getRegistryName().getNamespace();

        Block block = ForgeRegistries.BLOCKS.getValue( getRegistryName( sourceNamespace, blockIn.getPattern(), ModBlocks.getNextColour( blockIn.getColour(), 1 ), blockIn.getSuffix(), blockIn ) );

        if ( block == Blocks.AIR )
            block = ForgeRegistries.BLOCKS.getValue( getRegistryName( sourceNamespace, blockIn.getPattern(), ModBlocks.getNextColour( blockIn.getColour(), 2 ), blockIn.getSuffix(), blockIn ) );

        return block;

    }

    @Nullable
    public static Block getBlockFromColourPress( final IDecorativeBlock blockIn, final PressColour pressColour ) {

        final String sourceNamespace = ((Block) blockIn).getRegistryName().getNamespace();

        return ForgeRegistries.BLOCKS.getValue( getRegistryName( sourceNamespace, blockIn.getPattern(), pressColour.getColour(), blockIn.getSuffix(), blockIn ) );

    }

    @Nullable
    public static Block getBlockFromVariantPress( final IDecorativeBlock blockIn, final PressVariant pressVariant ) {

        final String sourceNamespace = ((Block) blockIn).getRegistryName().getNamespace();

        return ForgeRegistries.BLOCKS.getValue( getRegistryName( sourceNamespace, blockIn.getPattern(), blockIn.getColour(), pressVariant.getVariant(), blockIn ));

    }

    private static ResourceLocation getRegistryName( final String namespace, final String pattern, final String colour, final String suffix, final IDecorativeBlock block ) {
        return Wallpapercraft.getId( namespace, pattern + colour + suffix + block.getPostfix() );
    }

}
