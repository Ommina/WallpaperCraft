package net.ommina.wallpapercraft.items;

import net.minecraft.item.Item;
import net.ommina.wallpapercraft.Wallpapercraft;

public class PressStoneLamp extends Item {

    public static final String NAME = "pressstonelamp";

    public PressStoneLamp () {
        super( new Item.Properties()
             .maxStackSize( 1 )
             .group( Wallpapercraft.TAB ) );

        setRegistryName( NAME );

    }

}
