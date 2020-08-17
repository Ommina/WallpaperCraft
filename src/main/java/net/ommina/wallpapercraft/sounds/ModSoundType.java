package net.ommina.wallpapercraft.sounds;

import net.minecraft.block.SoundType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fml.RegistryObject;
import net.ommina.wallpapercraft.DeferredRegistries;

public class ModSoundType extends SoundType {

    public static ModSoundType BLOCK_CHANGE = new ModSoundType( 1.0F, 1.0F, SoundEvents.BLOCK_STONE_BREAK, SoundEvents.BLOCK_STONE_STEP, SoundEvents.BLOCK_STONE_PLACE, DeferredRegistries.BLOCK_CHANGE_IN_WORLD, SoundEvents.BLOCK_STONE_FALL );

    private RegistryObject<SoundEvent> hitSound;

    public ModSoundType( final float volume, final float pitch, final SoundEvent breakSound, final SoundEvent stepSound, final SoundEvent placeSound, final RegistryObject<SoundEvent> hitSound, final SoundEvent fallSound ) {
        super( volume, pitch, breakSound, stepSound, placeSound, null, fallSound );

        this.hitSound = hitSound;

    }

    //region Overrides
    @Override
    public SoundEvent getHitSound() {
        return this.hitSound.get();
    }
//endregion Overrides

}
