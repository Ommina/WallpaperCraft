package net.ommina.wallpapercraft;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.ommina.wallpapercraft.items.ModItems;

public class CreativeTab extends ItemGroup {

    public CreativeTab () {
        super( "WallpaperCraft" );

    }

    @Override
    public ItemStack createIcon () {

        return new ItemStack( ModItems.PRESS_STONEBRICK, 1 );
    }

    @Override
    public void fill ( final NonNullList<ItemStack> items ) {

        for ( ItemStack stack : items ) {

            System.out.println( "hiagain" + stack.getItem().getName() );


        }

        super.fill( items );
    }

}
