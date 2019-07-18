package net.ommina.wallpapercraft;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class CreativeTab extends ItemGroup {

    public CreativeTab() {
        super( "WallpaperCraft" );

    }

    @Override
    public ItemStack createIcon() {

        return new ItemStack( ForgeRegistries.ITEMS.getValue( Wallpapercraft.getId( "pressstonebrick" ) ), 1 );
    }

}
