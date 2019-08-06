package net.ommina.wallpapercraft.tags;

import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.ommina.wallpapercraft.Wallpapercraft;

public class Tags {

    public static final Tag<Item> TAG_PRESS_PATTERN = getTags( "press_pattern" );
    public static final Tag<Item> TAG_PRESS_COLOUR = getTags( "press_colour" );
    public static final Tag<Item> TAG_PRESS_VARIANT = getTags( "press_variant" );
    //public static final Tag<Item> TAG_DECORATIVE_ITEM = getTags( "decorative_item" );

    private static Tag<Item> getTags( final String path ) {

        final Tag<Item> tags = new ItemTags.Wrapper( Wallpapercraft.getId( path ) );

        return tags;

    }

}
