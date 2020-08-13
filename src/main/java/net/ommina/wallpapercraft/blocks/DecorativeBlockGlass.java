package net.ommina.wallpapercraft.blocks;

import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DecorativeBlockGlass extends AbstractGlassBlock implements IDecorativeBlock {

    private final String pattern;
    private final String colour;
    private final String suffix;

    public DecorativeBlockGlass( final String pattern, final String colour, final int suffix, final Material material, final ToolType toolType, final SoundType soundType, final int light ) {

        super( Block.Properties.create( material )
             .sound( soundType )
             .harvestTool( toolType )
             .harvestLevel( 0 )
             .hardnessAndResistance( 0.3f )
             .notSolid()
             .setRequiresTool()
             .setLightLevel( ( p_235464_0_ ) -> light )
        );

        this.pattern = pattern;
        this.colour = colour;
        this.suffix = "-" + suffix;

        setRegistryName( getName() );

    }

    //region Overrides
    public String getName() {
        return this.pattern + this.colour + this.suffix;
    }

    public String getPattern() {
        return this.pattern;
    }

    public String getColour() {
        return this.colour;
    }

    public String getSuffix() {
        return this.suffix;
    }
//endregion Overrides


}
