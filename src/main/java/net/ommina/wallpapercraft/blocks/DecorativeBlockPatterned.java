package net.ommina.wallpapercraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.ommina.wallpapercraft.items.ModItems;
import net.ommina.wallpapercraft.items.PressColour;
import net.ommina.wallpapercraft.items.PressVariant;
import net.ommina.wallpapercraft.sounds.ModSoundType;

import javax.annotation.Nullable;

public class DecorativeBlockPatterned extends HalfTransparentBlock implements IDecorativeBlock {

    private static final String POSTFIX = "";

    protected final String pattern;
    protected final String colour;
    protected final String suffix;

    public DecorativeBlockPatterned( final String pattern, final String colour, final int suffix, final Material material, final SoundType soundType, final float hardness, final int light ) {

        super( Block.Properties.of( material )
             .sound( soundType )
             .strength( hardness )
             .requiresCorrectToolForDrops()                              // https://github.com/MinecraftForge/MinecraftForge/issues/6906#issuecomment-653921871
             .lightLevel( ( l ) -> light )
        );

        this.pattern = pattern;
        this.colour = colour;
        this.suffix = "-" + suffix;

    }

    //region Overrides
    @Override
    public void attack( final BlockState state, final Level world, final BlockPos pos, final Player player ) {
        IDecorativeBlock.super.onBlockClicked( state, world, pos, player );
    }

    public String getPostfix() {
        return POSTFIX;
    }

    public String getNameForRegistry() {
        return this.pattern + this.colour + this.suffix + POSTFIX;
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
    public SoundType getSoundType( final BlockState state, final LevelReader world, final BlockPos pos, @Nullable final Entity entity ) {

        final SoundType soundType = state.getSoundType();

        if ( !(entity instanceof Player) )
            return soundType;

        final Player player = (Player) entity;

        if ( player.getMainHandItem().isEmpty() )
            return soundType;

        if ( player.getMainHandItem().getItem() == ModItems.PAINTBRUSH || player.getMainHandItem().getItem() instanceof PressColour || player.getMainHandItem().getItem() instanceof PressVariant )
            return ModSoundType.BLOCK_CHANGE;

        return soundType;

    }
//endregion Overrides

}
