package net.ommina.wallpapercraft.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;

import javax.annotation.Nonnull;

public class DecorativeBlockGlass extends DecorativeBlockPatterned {

    public DecorativeBlockGlass( final String variant, final String colour, final int suffix, final Material material, final SoundType soundType, final int light ) {
        super( variant, colour, suffix, material, soundType, light );
    }

    @Nonnull
    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

}
