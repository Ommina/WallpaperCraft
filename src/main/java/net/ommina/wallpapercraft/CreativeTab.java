package net.ommina.wallpapercraft;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class CreativeTab extends CreativeModeTab {

    public CreativeTab() {
        super( "wallpapercraft" );

    }

    @Override
    public ItemStack makeIcon() {

        return new ItemStack( ForgeRegistries.ITEMS.getValue( Wallpapercraft.getId( "pressstonebrick" ) ), 1 );
    }

}
