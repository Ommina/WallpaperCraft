package net.ommina.wallpapercraft.items;

import net.minecraft.item.Item;
import net.ommina.wallpapercraft.Wallpapercraft;

public abstract class Press extends Item {

    private String variant;

    public Press( String variant ) {
        super( new Item.Properties()
             .maxStackSize( 1 )
             .group( Wallpapercraft.TAB ) );

        this.variant = variant;

    }

    public String getVariant() {
        return this.variant;
    }

}
