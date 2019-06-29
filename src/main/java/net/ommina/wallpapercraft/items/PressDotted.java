package net.ommina.wallpapercraft.items;

import net.minecraft.item.Item;
import net.ommina.wallpapercraft.Wallpapercraft;

public class PressDotted extends Item {

    public PressDotted () {
        super( new Item.Properties()
             .maxStackSize( 1 )
             .group( Wallpapercraft.TAB ) );

        setRegistryName( "pressdotted" );

    }

}
