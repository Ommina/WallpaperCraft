package net.ommina.wallpapercraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BreakableBlock;
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

public class DecorativeBlockPatterned extends BreakableBlock implements IDecorativeBlock {

    private static final String POSTFIX = "";

    protected final String pattern;
    protected final String colour;
    protected final String suffix;

    public DecorativeBlockPatterned( final String pattern, final String colour, final int suffix, final Material material, final ToolType toolType, final SoundType soundType, final float hardness, final int light ) {

        super( Block.Properties.create( material )
             .sound( soundType )
             .harvestTool( toolType )
             .harvestLevel( 0 )
             .hardnessAndResistance( hardness )
             .setRequiresTool()                              // https://github.com/MinecraftForge/MinecraftForge/issues/6906#issuecomment-653921871
             .setLightLevel( ( l ) -> light )
        );

        this.pattern = pattern;
        this.colour = colour;
        this.suffix = "-" + suffix;

    }

    //region Overrides
    public String getName() {
        return this.pattern + this.colour + this.suffix;
    }

    public String getPostfix() {
        return POSTFIX;
    }

    public String getNameForRegistry() {
        return getName() + POSTFIX;
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
    public SoundType getSoundType( final BlockState state, final IWorldReader world, final BlockPos pos, @Nullable final Entity entity ) {

        final SoundType soundType = state.getSoundType();

        if ( !(entity instanceof PlayerEntity) )
            return soundType;

        final PlayerEntity player = (PlayerEntity) entity;

        if ( player.getHeldItemMainhand().isEmpty() )
            return soundType;

        if ( player.getHeldItemMainhand().getItem() == ModItems.PAINTBRUSH || player.getHeldItemMainhand().getItem() instanceof PressColour || player.getHeldItemMainhand().getItem() instanceof PressVariant )
            return ModSoundType.STONE;

        return soundType;

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
