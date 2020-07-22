package net.ommina.wallpapercraft;

import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DeferredRegistries {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create( ForgeRegistries.SOUND_EVENTS, Wallpapercraft.MODID );

    public static void setup() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DeferredRegistries.SOUND_EVENTS.register( modEventBus );

    }

}
