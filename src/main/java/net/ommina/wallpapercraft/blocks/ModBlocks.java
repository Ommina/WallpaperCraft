package net.ommina.wallpapercraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BreakableBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.DyeColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ModBlocks {

    public static final String[] COLOURS = { "blue", "brown", "cyan", "gray", "green", "purple", "red", "yellow" };
    public static final String[] PATTERNS = { "auralamp", "solid", "brick", "checkeredwool", "clay", "colouredbrick",
         "damask", "diagonallydotted", "dotted", "fancytiles", "floral", "frostedglass",
         "jewel", "rippled", "stamp", "stonebrick", "stonelamp", "striped", "texturedglass", "tintedglass", "woodplank", "wool" };

    public static final Map<String, IDecorativeBlock> BLOCKS = new HashMap<String, IDecorativeBlock>();

    public static void register( final RegistryEvent.Register<Block> event ) {

        /* For non-glass blocks (ie: DecorativeBlockPatterned), the onHit sound is determined by the class itself, not the SoundType */

        // Light Emitting
        registerColouredBlocks( event, "auralamp", Material.ROCK, ToolType.PICKAXE, SoundType.LANTERN, true );
        registerColouredBlocks( event, "stonelamp", Material.ROCK, ToolType.PICKAXE, SoundType.LANTERN, true );

        // Pane in the Glass
        registerColouredBlocks( event, "frostedglass", Material.GLASS, ToolType.PICKAXE, SoundType.GLASS, false );
        registerColouredBlocks( event, "texturedglass", Material.GLASS, ToolType.PICKAXE, SoundType.GLASS, false );
        registerColouredBlocks( event, "tintedglass", Material.GLASS, ToolType.PICKAXE, SoundType.GLASS, false );

        // Wool
        registerColouredBlocks( event, "checkeredwool", Material.WOOL,  ToolType.PICKAXE, SoundType.CLOTH, false );
        registerColouredBlocks( event, "wool", Material.WOOL, ToolType.PICKAXE, SoundType.CLOTH, false );

        // Clay
        registerColouredBlocks( event, "clay", Material.CLAY, ToolType.PICKAXE, SoundType.STONE, false );

        // Wood
        registerColouredBlocks( event, "woodplank", Material.WOOD, ToolType.AXE, SoundType.WOOD, false );

        // And the rest
        registerColouredBlocks( event, "brick", Material.ROCK, ToolType.PICKAXE, SoundType.STONE, false );
        registerColouredBlocks( event, "colouredbrick", Material.ROCK, ToolType.PICKAXE, SoundType.STONE, false );
        registerColouredBlocks( event, "damask", Material.ROCK, ToolType.PICKAXE, SoundType.STONE, false );
        registerColouredBlocks( event, "diagonallydotted", Material.ROCK, ToolType.PICKAXE, SoundType.STONE, false );
        registerColouredBlocks( event, "dotted", Material.ROCK, ToolType.PICKAXE, SoundType.STONE, false );
        registerColouredBlocks( event, "fancytiles", Material.ROCK, ToolType.PICKAXE, SoundType.STONE, false );
        registerColouredBlocks( event, "floral", Material.ROCK, ToolType.PICKAXE, SoundType.STONE, false );
        registerColouredBlocks( event, "rippled", Material.ROCK, ToolType.PICKAXE, SoundType.STONE, false );
        registerColouredBlocks( event, "solid", Material.ROCK, ToolType.PICKAXE, SoundType.STONE, false );
        registerColouredBlocks( event, "stonebrick", Material.ROCK, ToolType.PICKAXE, SoundType.STONE, false );
        registerColouredBlocks( event, "striped", Material.ROCK, ToolType.PICKAXE, SoundType.STONE, false );

        // Carpets (wool textures only)
        registerCarpets( event, "wool", Material.WOOL, ToolType.PICKAXE, SoundType.CLOTH, false );

        event.getRegistry().register( new Block( Block.Properties.create( Material.ROCK ).sound( SoundType.STONE ).hardnessAndResistance( 2.0f ) ).setRegistryName( "compressed" ) );
        event.getRegistry().register( new Block( Block.Properties.create( Material.ROCK ).sound( SoundType.STONE ).hardnessAndResistance( 2.0f ) ).setRegistryName( "hardened" ) );

        setGlassTransparancy();

    }

    public static String getNextColour( final String colour, final int increment ) {

        int index = IntStream.range( 0, COLOURS.length ).filter( i -> colour.equals( COLOURS[i] ) ).findFirst().orElse( -1 );

        index += increment;

        if ( increment > 0 && index >= COLOURS.length )
            index = 0;
        else if ( increment < 0 && index < 0 )
            index = COLOURS.length - 1;

        return COLOURS[index];

    }

    private static void registerColouredBlocks( final RegistryEvent.Register<Block> event, final String pattern, final Material material, final ToolType toolType, SoundType soundType, final boolean isLight ) {

        for ( final String s : COLOURS ) {

            final int suffixCount = s.equals( "cyan" ) ? 9 : 14;

            for ( int suffix = 0; suffix <= suffixCount; suffix++ ) {

                final IDecorativeBlock block;
                final int light = isLight ? 15 : 0;

                if ( material == Material.GLASS )
                    block = new DecorativeBlockGlass( pattern, s, suffix, material, toolType, soundType, 0.3f, light );
                else
                    block = new DecorativeBlockPatterned( pattern, s, suffix, material, toolType, soundType, 1.5f, light );

                ((BreakableBlock) block).setRegistryName( block.getName() );

                event.getRegistry().register( (Block) block );

                BLOCKS.put( block.getName(), block );

            }
        }

    }

    private static void registerCarpets( final RegistryEvent.Register<Block> event, final String pattern, final Material material, final ToolType toolType, SoundType soundType, final boolean isLight ) {

        for ( final String s : COLOURS ) {

            final int suffixCount = s.equals( "cyan" ) ? 9 : 14;

            for ( int suffix = 0; suffix <= suffixCount; suffix++ ) {

                final DecorativeCarpet block = new DecorativeCarpet( pattern, s, suffix, DyeColor.WHITE, material, toolType, soundType, 0.8f, 0 );

                block.setRegistryName( block.getNameForRegistry() );

                event.getRegistry().register( block );

                BLOCKS.put( block.getName() + "_carpet", block );

            }
        }

    }

    private static void setGlassTransparancy() {

        if ( FMLEnvironment.dist != Dist.CLIENT )
            return;

        final RenderType translucentRenderType = RenderType.getTranslucent();

        BLOCKS.values().stream().filter( b -> b instanceof DecorativeBlockGlass ).forEach( b -> RenderTypeLookup.setRenderLayer( (Block) b, translucentRenderType ) );

    }

}
