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
import net.ommina.wallpapercraft.sounds.ModSoundType;

import javax.annotation.Nullable;

public class DecorativeBlockPatterned extends BreakableBlock implements IDecorativeBlock {

    private final String pattern;
    private final String colour;
    private final String suffix;

    public DecorativeBlockPatterned( final String pattern, final String colour, final int suffix, final Material material, final ToolType toolType, final SoundType soundType, final int light ) {

        super( Block.Properties.create( material )
             .sound( soundType )
             .harvestTool( toolType )
             .harvestLevel( 0 )
             .hardnessAndResistance( 1.5f )
             .func_235861_h_()                              // https://github.com/MinecraftForge/MinecraftForge/issues/6906#issuecomment-653921871
             .func_235838_a_( ( p_235464_0_ ) -> light )
        );

        this.pattern = pattern;
        this.colour = colour;
        this.suffix = "-" + suffix;

        setRegistryName( getName() );

    }

    //region Overrides
    public String getName() {
        return getName( this.pattern, this.colour, this.suffix );
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
            return SoundType.STONE;

        final PlayerEntity player = (PlayerEntity) entity;

        if ( player.getHeldItemMainhand().isEmpty() )
            return SoundType.STONE;

        if ( player.getHeldItemMainhand().getItem() == ModItems.PAINTBRUSH || player.getHeldItemMainhand().getItem() instanceof PressColour )
            return ModSoundType.STONE;

        return SoundType.STONE;

    }

    @Override
    public void onBlockClicked( final BlockState state, final World world, final BlockPos pos, final PlayerEntity player ) {

        BlockState block = null;

        if ( player.getHeldItemMainhand().getItem() == ModItems.PAINTBRUSH )
            block = getIncrementedBlockColour();

        if ( player.getHeldItemMainhand().getItem() instanceof PressColour )
            block = getBlockFromColourPress( (PressColour) player.getHeldItemMainhand().getItem() );

        if ( block == null )
            return;

        if ( !world.isRemote )
            world.setBlockState( pos, block, 3 );

    }
//endregion Overrides

    private BlockState getIncrementedBlockColour() {

        Block block = (Block) ModBlocks.BLOCKS.get( getName( this.pattern, ModBlocks.getNextColour( this.colour, 1 ), this.suffix ) );

        if ( block == null )
            block = (Block) ModBlocks.BLOCKS.get( getName( this.pattern, ModBlocks.getNextColour( this.colour, 2 ), this.suffix ) );

        if ( block == null )
            return null;

        return block.getDefaultState();

    }

    private BlockState getBlockFromColourPress( final PressColour pressColour ) {

        final Block block = (Block) ModBlocks.BLOCKS.get( getName( this.pattern, pressColour.getColour(), this.suffix ) );

        if ( block == null )
            return null;

        return block.getDefaultState();

    }

    private String getName( final String pattern, final String colour, final String suffix ) {
        return pattern + colour + suffix;
    }

}
