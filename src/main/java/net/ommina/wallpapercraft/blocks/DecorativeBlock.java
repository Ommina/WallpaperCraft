package net.ommina.wallpapercraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class DecorativeBlock extends Block {

    private final String variant;
    private final String colour;
    private final String suffix;

    public DecorativeBlock( final String variant, final String colour, final int suffix, final Material material, final SoundType soundType, final int light ) {

        super( Properties.create( material )
             .sound( soundType )
             .hardnessAndResistance( 2.0f )
             .lightValue( light )

        );

        this.variant = variant;
        this.colour = colour;
        this.suffix = "-" + suffix;

        setRegistryName( getName() );

    }

    public String getName() {
        return this.variant + this.colour + this.suffix;
    }

    public String getVariant() {
        return this.variant;
    }

    public String getColour() {
        return this.colour;
    }

    public String getSuffix() {
        return this.suffix;
    }

}
