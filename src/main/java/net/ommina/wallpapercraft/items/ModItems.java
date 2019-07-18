package net.ommina.wallpapercraft.items;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;
import net.ommina.wallpapercraft.Wallpapercraft;
import net.ommina.wallpapercraft.blocks.ModBlocks;

import java.util.HashMap;
import java.util.Map;

@ObjectHolder( Wallpapercraft.MODID )
public class ModItems {

    public static Map<String, Item> ITEMS = new HashMap<String, Item>();

    public static void register( final RegistryEvent.Register<Item> event ) {

        ModBlocks.BLOCKS.keySet().stream().sorted().forEachOrdered( s -> {
            final Item item = new DecorativeItem( ModBlocks.BLOCKS.get( s ), new Item.Properties().group( Wallpapercraft.TAB ) ).setRegistryName( s );
            event.getRegistry().register( item );
            ITEMS.put( item.getRegistryName().getPath(), item );
        } );

        for( String s : ModBlocks.PATTERNS ) {
            final Item item = new PressPattern( s );
            event.getRegistry().register( item );
            ITEMS.put( item.getRegistryName().getPath(), item );
        }

        for( String s : ModBlocks.COLOURS ) {
            final Item item = new PressColour( s );
            event.getRegistry().register( item );
            ITEMS.put( item.getRegistryName().getPath(), item );
        }

        for( int i = 0; i <= 14; i++ ) {
            final Item item = new PressVariant( Integer.toString( i ) );
            event.getRegistry().register( item );
            ITEMS.put( item.getRegistryName().getPath(), item );
        }

    }

}
