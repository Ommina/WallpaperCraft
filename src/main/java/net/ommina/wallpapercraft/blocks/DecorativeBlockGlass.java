package net.ommina.wallpapercraft.blocks;

import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.ommina.wallpapercraft.items.ModItems;
import net.ommina.wallpapercraft.items.PressColour;
import net.ommina.wallpapercraft.items.PressVariant;
import net.ommina.wallpapercraft.sounds.ModSoundType;

import javax.annotation.Nullable;

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

    @Override
    public SoundType getSoundType( BlockState state, IWorldReader world, BlockPos pos, @Nullable Entity entity ) {

        if ( !(entity instanceof PlayerEntity) )
            return SoundType.GLASS;

        final PlayerEntity player = (PlayerEntity) entity;

        if ( player.getHeldItemMainhand().isEmpty() )
            return SoundType.GLASS;

        if ( player.getHeldItemMainhand().getItem() == ModItems.PAINTBRUSH || player.getHeldItemMainhand().getItem() instanceof PressColour || player.getHeldItemMainhand().getItem() instanceof PressVariant )
            return ModSoundType.STONE;

        return SoundType.STONE;

    }

    @Override
    public void onBlockClicked( final BlockState state, final World world, final BlockPos pos, final PlayerEntity player ) {

        BlockState block = null;

        if ( player.getHeldItemMainhand().getItem() == ModItems.PAINTBRUSH )
            block = InWorldHelper.getIncrementedBlockColour( this );
        else if ( player.getHeldItemMainhand().getItem() instanceof PressColour )
            block = InWorldHelper.getBlockFromColourPress( this, (PressColour) player.getHeldItemMainhand().getItem() );
        else if ( player.getHeldItemMainhand().getItem() instanceof PressVariant )
            block = InWorldHelper.getBlockFromVariantPress( this, (PressVariant) player.getHeldItemMainhand().getItem() );

        if ( block == null )
            return;

        if ( !world.isRemote )
            world.setBlockState( pos, block, 3 );

    }
//endregion Overrides

}
