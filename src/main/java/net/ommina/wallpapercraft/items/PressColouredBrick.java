package net.ommina.wallpapercraft.items;

import net.minecraft.item.Item;
import net.ommina.wallpapercraft.Wallpapercraft;

public class PressColouredBrick extends Item {

    public static final String NAME = "presscolouredbrick";

    public PressColouredBrick () {
        super( new Item.Properties()
             .maxStackSize( 1 )
             .group( Wallpapercraft.TAB ) );

        setRegistryName( NAME );

    }

}
