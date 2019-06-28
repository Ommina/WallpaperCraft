package net.ommina.wallpapercraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class DecorativeBlock extends Block {

    public DecorativeBlock ( final String registryName, final Material material, final SoundType soundType, final int light ) {

        super( Properties.create( material )
             .sound( soundType )
             .hardnessAndResistance( 2.0f )
             .lightValue( light )

        );

        setRegistryName( registryName );

    }

}
