package net.ommina.wallpapercraft;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.ommina.wallpapercraft.items.ModItems;

public class CreativeTab extends ItemGroup {

    public CreativeTab () {
        super( "WallpaperCraft" );

    }

    @Override
    public ItemStack createIcon () {

        return new ItemStack( ModItems.PRESS_STONEBRICK, 1 );
    }

}
