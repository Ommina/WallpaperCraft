package net.ommina.wallpapercraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;
import net.ommina.wallpapercraft.Wallpapercraft;

import java.util.HashMap;
import java.util.Map;

public class ModBlocks {

    public static final String[] COLOURS = { "blue", "brown", "cyan", "gray", "green", "purple", "red", "yellow" };
    public static final String[] PATTERNS = { "auralamp", "solid", "brick", "checkeredwool", "clay", "colouredbrick",
         "damask", "diagonallydotted", "dotted", "fancytiles", "floral", "frostedglass",
         "jewel", "rippled", "stamp", "stonebrick", "stonelamp", "striped", "texturedglass", "tintedglass", "woodplank", "wool" };

    public static final Map<String, DecorativeBlock> BLOCKS = new HashMap<String, DecorativeBlock>();

    @ObjectHolder( "wallpapercraft:testglass" ) public static Block TESTGLASS;

    public static void register( final RegistryEvent.Register<Block> event ) {

        // Light Emitting
        registerColouredBlocks( event, "auralamp", Material.ROCK, SoundType.LANTERN, true );
        registerColouredBlocks( event, "stonelamp", Material.ROCK, SoundType.LANTERN, true );

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

        //Blocks.GLASS

        Block b = new GlassBlock( Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS).func_226896_b_());
        b.setRegistryName( Wallpapercraft.getId( "testglass" ) );
        event.getRegistry().register( b );

    }

    private static void registerColouredBlocks( final RegistryEvent.Register<Block> event, final String variant, final Material material, final SoundType soundType, final boolean isLight ) {

        for ( String s : COLOURS ) {

            final int suffixCount = s.equals( "cyan" ) ? 9 : 14;

            for ( int suffix = 0; suffix <= suffixCount; suffix++ ) {

                final DecorativeBlock block;
                final int light = isLight ? 15 : 0;

                if ( material == Material.GLASS )
                    block = new DecorativeBlockGlass( variant, s, suffix, material, soundType, light );
                else
                    block = new DecorativeBlockPatterned( variant, s, suffix, material, soundType, light );

                event.getRegistry().register( block );

                BLOCKS.put( block.getName(), block );

            }
        }

    }

}
