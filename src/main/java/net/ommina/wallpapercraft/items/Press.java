package net.ommina.wallpapercraft.items;

import net.minecraft.world.item.Item;
import net.ommina.wallpapercraft.Wallpapercraft;

public abstract class Press extends Item {

    private String variant;

    public Press( String variant ) {
        super( new Item.Properties()
             .stacksTo( 1 )
             .tab( Wallpapercraft.TAB ) );

        this.variant = variant;
    }

    public String getVariant() {
        return this.variant;
    }

}
