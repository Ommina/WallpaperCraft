package net.ommina.wallpapercraft.network;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.ommina.wallpapercraft.Wallpapercraft;

public class Network {

    private static final ResourceLocation NAME = Wallpapercraft.getId( "network" );
    private static final String PROTOCOL_VERSION = "1";
    public static SimpleChannel channel;
    private static int channelId = 0;

    static {

        channel = NetworkRegistry.ChannelBuilder.named( NAME )
             .clientAcceptedVersions( PROTOCOL_VERSION::equals )
             .serverAcceptedVersions( PROTOCOL_VERSION::equals )
             .networkProtocolVersion( () -> PROTOCOL_VERSION )
             .simpleChannel();

        channel.messageBuilder( VariantScrollRequest.class, channelId++ )
             .decoder( VariantScrollRequest::fromBytes )
             .encoder( VariantScrollRequest::toBytes )
             .consumer( VariantScrollRequest::handle )
             .add();

    }

    private Network() {
    }

    public static void init() {
        // Hi!
    }

}
