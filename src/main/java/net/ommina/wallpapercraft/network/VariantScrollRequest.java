package net.ommina.wallpapercraft.network;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Hand;
import net.minecraftforge.fml.network.NetworkEvent;
import net.ommina.wallpapercraft.blocks.IDecorativeBlock;
import net.ommina.wallpapercraft.blocks.ModBlocks;
import net.ommina.wallpapercraft.items.DecorativeItem;
import net.ommina.wallpapercraft.items.ModItems;
import net.ommina.wallpapercraft.util.MathUtil;

import java.util.function.Supplier;

public class VariantScrollRequest {

    private int delta;

    public VariantScrollRequest() {
    }

    public VariantScrollRequest( final int delta ) {

        this.delta = delta;

    }

    public static VariantScrollRequest fromBytes( PacketBuffer buf ) {

        VariantScrollRequest packet = new VariantScrollRequest();

        packet.delta = MathUtil.clamp( buf.readInt(), -1, 1 );

        return packet;

    }

    public static void handle( VariantScrollRequest packet, Supplier<NetworkEvent.Context> ctx ) {

        ctx.get().enqueueWork( () -> {

            final ServerPlayerEntity player = ctx.get().getSender();
            final int delta = packet.delta;

            if ( player.isCrouching() && player.getHeldItemMainhand() != ItemStack.EMPTY ) {

                ItemStack stack = player.getHeldItemMainhand();

                if ( stack.getItem() instanceof DecorativeItem ) {

                    final IDecorativeBlock block = ModBlocks.BLOCKS.get( stack.getItem().getRegistryName().getPath() );
                    final String postfix = block.getPostfix();

                    if ( block != null ) {

                        final int suffix = MathUtil.rollOver( Math.abs( Integer.parseInt( block.getSuffix() ) ) + delta, 0, block.getColour().contains( "cyan" ) ? 9 : 14 );
                        final DecorativeItem item = ModItems.get( block.getPattern(), block.getColour(), suffix, postfix );

                        if ( item != null )
                            player.setHeldItem( Hand.MAIN_HAND, new ItemStack( item, stack.getCount() ) );

                    }

                }

            }

        } );

        ctx.get().setPacketHandled( true );

    }

    public void toBytes( PacketBuffer buf ) {

        buf.writeInt( this.delta );

    }

}
