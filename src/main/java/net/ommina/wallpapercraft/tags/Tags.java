package net.ommina.wallpapercraft.tags;

import net.minecraft.world.item.Item;
import net.minecraft.tags.Tag;
import net.minecraft.tags.ItemTags;
import net.ommina.wallpapercraft.Wallpapercraft;

public class Tags {

    public static final Tag.Named<Item> TAG_PRESS_PATTERN = getTags( "press_pattern" );
    public static final Tag.Named<Item> TAG_PRESS_COLOUR = getTags( "press_colour" );
    public static final Tag.Named<Item> TAG_PRESS_VARIANT = getTags( "press_variant" );
    //public static final Tag<Item> TAG_DECORATIVE_ITEM = getTags( "decorative_item" );

    private static Tag.Named<Item> getTags( final String path ) {
        return ItemTags.bind( Wallpapercraft.getId( path ).toString() );
    }

}
