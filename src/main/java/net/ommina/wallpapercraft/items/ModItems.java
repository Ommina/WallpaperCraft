package net.ommina.wallpapercraft.items;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;
import net.ommina.wallpapercraft.Wallpapercraft;
import net.ommina.wallpapercraft.blocks.ModBlocks;

@ObjectHolder( Wallpapercraft.MODID )
public class ModItems {

    public static void register( final RegistryEvent.Register<Item> event ) {

        ModBlocks.BLOCKS.keySet().stream().sorted().forEachOrdered( s -> {
            event.getRegistry().register( new DecorativeItem( ModBlocks.BLOCKS.get( s ), new Item.Properties().group( Wallpapercraft.TAB ) ).setRegistryName( s ) );
        } );

        for( String s : ModBlocks.PATTERNS )
            event.getRegistry().register( new PressPattern( s ) );

        for( String s : ModBlocks.COLOURS )
            event.getRegistry().register( new PressColour( s ) );

        for( int i = 0; i <= 14; i++ )
            event.getRegistry().register( new PressVariant( Integer.toString( i ) ) );

        event.getRegistry().register( new Item( new Item.Properties().group( Wallpapercraft.TAB ).maxStackSize( 64 ) ).setRegistryName( "pressblank" ) );

    }

}
