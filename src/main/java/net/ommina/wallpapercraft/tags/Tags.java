package net.ommina.wallpapercraft.tags;

import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.ommina.wallpapercraft.Wallpapercraft;

public class Tags {

    public static final ITag.INamedTag<Item> TAG_PRESS_PATTERN = getTags( "press_pattern" );
    public static final ITag.INamedTag<Item> TAG_PRESS_COLOUR = getTags( "press_colour" );
    public static final ITag.INamedTag<Item> TAG_PRESS_VARIANT = getTags( "press_variant" );
    //public static final Tag<Item> TAG_DECORATIVE_ITEM = getTags( "decorative_item" );

    private static ITag.INamedTag<Item> getTags( final String path ) {
        return ItemTags.makeWrapperTag( Wallpapercraft.getId( path ).toString() );
    }

}
