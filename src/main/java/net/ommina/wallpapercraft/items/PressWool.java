package net.ommina.wallpapercraft.items;

import net.minecraft.item.Item;
import net.ommina.wallpapercraft.Wallpapercraft;

public class PressWool extends Item {

    public PressWool () {
        super( new Item.Properties()
             .maxStackSize( 1 )
             .group( Wallpapercraft.TAB ) );

        setRegistryName( "presswool" );

    }

}
