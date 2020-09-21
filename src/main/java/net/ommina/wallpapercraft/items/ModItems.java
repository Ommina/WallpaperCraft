package net.ommina.wallpapercraft.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;
import net.ommina.wallpapercraft.Wallpapercraft;
import net.ommina.wallpapercraft.blocks.ModBlocks;

@ObjectHolder( Wallpapercraft.MODID )
public class ModItems {

    @ObjectHolder( "solidgray-0" ) public static Item BASE_ITEM;
    @ObjectHolder( "paintbrush" ) public static Item PAINTBRUSH;

    @ObjectHolder( "pressclay" ) public static Item PRESS_CLAY;
    @ObjectHolder( "presswoodplank" ) public static Item PRESS_WOOD_PLANK;
    @ObjectHolder( "presscolouredbrick" ) public static Item PRESS_COLOURED_BRICK;
    @ObjectHolder( "presssolid" ) public static Item PRESS_SOLID;
    @ObjectHolder( "pressstonebrick" ) public static Item PRESS_STONE_BRICK;
    @ObjectHolder( "pressstriped" ) public static Item PRESS_STRIPED;

    public static void register( final RegistryEvent.Register<Item> event ) {

        ModBlocks.BLOCKS.keySet().stream().sorted().forEachOrdered( s ->
             event.getRegistry().register( new DecorativeItem( (Block) ModBlocks.BLOCKS.get( s ), new Item.Properties().group( Wallpapercraft.TAB ) ).setRegistryName( s ) )
        );

        for ( String s : ModBlocks.PATTERNS )
            event.getRegistry().register( new PressPattern( s ) );

        for ( String s : ModBlocks.COLOURS )
            event.getRegistry().register( new PressColour( s ) );

        for ( int i = 0; i <= 14; i++ )
            event.getRegistry().register( new PressVariant( Integer.toString( i ) ) );

        event.getRegistry().register( new Item( new Item.Properties().group( Wallpapercraft.TAB ).maxStackSize( 64 ) ).setRegistryName( "pressblank" ) );
        event.getRegistry().register( new Item( new Item.Properties().group( Wallpapercraft.TAB ).maxStackSize( 1 ) ).setRegistryName( "paintbrush" ) );
        event.getRegistry().register( new BlockItem( ForgeRegistries.BLOCKS.getValue( Wallpapercraft.getId( ("compressed") ) ), new Item.Properties().group( Wallpapercraft.TAB ).maxStackSize( 64 ) ).setRegistryName( "compressed" ) );
        event.getRegistry().register( new BlockItem( ForgeRegistries.BLOCKS.getValue( Wallpapercraft.getId( ("hardened") ) ), new Item.Properties().group( Wallpapercraft.TAB ).maxStackSize( 64 ) ).setRegistryName( "hardened" ) );

    }

    public static DecorativeItem get( final String pattern, final String colour, final int suffix, final String postfix ) {
        return (DecorativeItem) ForgeRegistries.ITEMS.getValue( Wallpapercraft.getId( pattern + colour + "-" + suffix + postfix ) );
    }

    public static DecorativeItem get( final ResourceLocation location ) {
        return (DecorativeItem) ForgeRegistries.ITEMS.getValue( location );
    }

}
