package net.ommina.wallpapercraft;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DeferredRegistries {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create( ForgeRegistries.SOUND_EVENTS, Wallpapercraft.MODID );

    public static final RegistryObject<SoundEvent> BLOCK_CHANGE_IN_WORLD = DeferredRegistries.SOUND_EVENTS.register( "block_change_in_world", () -> new SoundEvent( new ResourceLocation( Wallpapercraft.MODID, "block_change_in_world" ) ) );

    public static void setup() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DeferredRegistries.SOUND_EVENTS.register( modEventBus );

    }

}
