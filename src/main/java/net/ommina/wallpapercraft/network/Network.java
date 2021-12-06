package net.ommina.wallpapercraft.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.ommina.wallpapercraft.Wallpapercraft;

public class Network {

    private static final ResourceLocation NAME = Wallpapercraft.getId( "network" );
    private static final String PROTOCOL_VERSION = "1";
    public static SimpleChannel channel;
    private static int channelId = 0;

    static {

        channel = NetworkRegistry.newSimpleChannel(
             NAME,
             () -> PROTOCOL_VERSION,
             PROTOCOL_VERSION::equals,
             PROTOCOL_VERSION::equals
        );

        channel.registerMessage(
             channelId++,
             VariantScrollRequest.class,
             VariantScrollRequest::toBytes,
             VariantScrollRequest::fromBytes,
             VariantScrollRequest::handle
        );

//        channel.messageBuilder( VariantScrollRequest.class, channelId++ )
//             .decoder( VariantScrollRequest::fromBytes )
//             .encoder( VariantScrollRequest::toBytes )
//             .consumer( VariantScrollRequest::handle )
//             .add();

    }

    private Network() {
    }

    public static void init() {
        // Hi!
    }

}
