package net.ommina.wallpapercraft.sounds;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.ommina.wallpapercraft.DeferredRegistries;

//@ObjectHolder( Wallpapercraft.MODID )
public class ModSoundEvents {

    public static final RegistryObject<SoundEvent> BLOCK_CHANGE_IN_WORLD = DeferredRegistries.SOUND_EVENTS.register( "block_change", () -> new SoundEvent( new ResourceLocation( "minecraft:block.ancient_debris.hit" ) ) );

    //  @ObjectHolder( "block_change_in_world" ) public static SoundEvent BLOCK_CHANGE_INWORLD;

    //public static void register( final RegistryEvent.Register<SoundEvent> event ) {

    //    BLOCK_CHANGE_INWORLD = new SoundEvent( new ResourceLocation( "minecraft:block.ancient_debris.hit" ) ).setRegistryName( "block_change_in_world" );

    //  event.getRegistry().register( BLOCK_CHANGE_INWORLD );

    //}

}

