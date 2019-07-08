package net.ommina.wallpapercraft.tags;

import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.ommina.wallpapercraft.Wallpapercraft;

public class Tags {

    public static final Tag<Item> TAG_SOLID = new ItemTags.Wrapper( new ResourceLocation( Wallpapercraft.MODID, "solid" ) );

}
