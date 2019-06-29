package net.ommina.wallpapercraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;

import java.util.HashMap;
import java.util.Map;

public class ModBlocks {

    public static final Map<String, DecorativeBlock> BLOCKS = new HashMap<String, DecorativeBlock>();

    public static void register ( final RegistryEvent.Register<Block> event ) {

        // Light Emitting
        registerColouredBlocks( event, "auralamp", Material.ROCK, SoundType.STONE, true );
        registerColouredBlocks( event, "stonelamp", Material.ROCK, SoundType.STONE, true );

        // Pane in the Glass
        registerColouredBlocks( event, "frostedglass", Material.GLASS, SoundType.GLASS, false );
        registerColouredBlocks( event, "texturedglass", Material.GLASS, SoundType.GLASS, false );
        registerColouredBlocks( event, "tintedglass", Material.GLASS, SoundType.GLASS, false );

        // Wool
        registerColouredBlocks( event, "checkeredwool", Material.WOOL, SoundType.CLOTH, false );
        registerColouredBlocks( event, "wool", Material.WOOL, SoundType.CLOTH, false );

        // Clay
        registerColouredBlocks( event, "clay", Material.CLAY, SoundType.STONE, false );

        // Wood
        registerColouredBlocks( event, "woodplank", Material.WOOD, SoundType.WOOD, false );

        // And the rest
        registerColouredBlocks( event, "brick", Material.ROCK, SoundType.STONE, false );
        registerColouredBlocks( event, "colouredbrick", Material.ROCK, SoundType.STONE, false );
        registerColouredBlocks( event, "damask", Material.ROCK, SoundType.STONE, false );
        registerColouredBlocks( event, "diagonallydotted", Material.ROCK, SoundType.STONE, false );
        registerColouredBlocks( event, "dotted", Material.ROCK, SoundType.STONE, false );
        registerColouredBlocks( event, "fancytiles", Material.ROCK, SoundType.STONE, false );
        registerColouredBlocks( event, "floral", Material.ROCK, SoundType.STONE, false );
        registerColouredBlocks( event, "rippled", Material.ROCK, SoundType.STONE, false );
        registerColouredBlocks( event, "solid", Material.ROCK, SoundType.STONE, false );
        registerColouredBlocks( event, "stonebrick", Material.ROCK, SoundType.STONE, false );
        registerColouredBlocks( event, "striped", Material.ROCK, SoundType.STONE, false );

    }

    private static void registerColouredBlocks ( final RegistryEvent.Register<Block> event, final String prefix, final Material material, final SoundType soundType, final boolean isLight ) {

        final String[] colours = { "blue", "brown", "cyan", "gray", "green", "purple", "red", "yellow" };

        for ( String s : colours ) {

            final int variantCount = s.equals( "cyan" ) ? 9 : 14;

            for ( int variant = 0; variant <= variantCount; variant++ ) {

                final String name = prefix + s + "-" + variant;
                final DecorativeBlock block = new DecorativeBlock( name, material, soundType, isLight ? 15 : 0 );

                event.getRegistry().register( block );

                BLOCKS.put( name, block );
            }
        }


    }

}