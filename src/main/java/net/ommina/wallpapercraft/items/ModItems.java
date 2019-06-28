package net.ommina.wallpapercraft.items;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.ommina.wallpapercraft.blocks.ModBlocks;

public class ModItems {

    public static void register ( final RegistryEvent.Register<Item> event ) {

        // String list = "";

        for ( String s : ModBlocks.BLOCKS.keySet() ) {

            //list += (new ResourceLocation( s ).getPath() + System.lineSeparator());

            event.getRegistry().register( new BlockItem( ModBlocks.BLOCKS.get( s ), new Item.Properties() ).setRegistryName( s ) );

        }


        // System.out.println( " ***** " );
        // System.out.println( list );

    }

}
