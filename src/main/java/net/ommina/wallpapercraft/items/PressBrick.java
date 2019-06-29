package net.ommina.wallpapercraft.items;

import net.minecraft.item.Item;
import net.ommina.wallpapercraft.Wallpapercraft;

public class PressBrick extends Item {

    public PressBrick () {
        super( new Item.Properties()
             .maxStackSize( 1 )
             .group( Wallpapercraft.TAB ) );

        setRegistryName( "pressrick" );

    }

}
