package net.ommina.wallpapercraft.tags;

import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.ommina.wallpapercraft.Wallpapercraft;

import java.util.HashMap;
import java.util.Map;

public class Tags {

    public static final Map<String, Tag<Item>> TAGS = new HashMap<String, Tag<Item>>();

    public static final Tag<Item> TAG_SOLID;

    static {

        TAG_SOLID = getTags( "solid" );

    }

    private static Tag<Item> getTags( final String path ) {

        final Tag<Item> tags = new ItemTags.Wrapper( new ResourceLocation( Wallpapercraft.MODID, path ) );

        TAGS.put( path, tags );

        return tags;

    }

}
