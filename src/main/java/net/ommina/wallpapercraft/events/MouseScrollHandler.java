package net.ommina.wallpapercraft.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.ommina.wallpapercraft.blocks.DecorativeBlock;
import net.ommina.wallpapercraft.blocks.ModBlocks;
import net.ommina.wallpapercraft.items.DecorativeItem;
import net.ommina.wallpapercraft.network.Network;
import net.ommina.wallpapercraft.network.VariantScrollRequest;
import net.ommina.wallpapercraft.util.MathUtil;

@OnlyIn( Dist.CLIENT )
@Mod.EventBusSubscriber( bus = Mod.EventBusSubscriber.Bus.FORGE )
public class MouseScrollHandler {

    /*  //TODO: It may be worthwhile allowing the user to set a custom scroll key (or keys if we want to scroll between pattern and colour variants both).  But we'll see if there is any interest first.

    public static KeyBinding scrollKey;

    public static void init() {

        mouseScrollHandler = new MouseScrollHandler();

        scrollKey = new KeyBinding( Wallpapercraft.MODID + ".key.scrollKey", GLFW_KEY_LEFT_SHIFT, "key.categories." + Wallpapercraft.MODID );

        ClientRegistry.registerKeyBinding( scrollKey );

    }

    */

    @SubscribeEvent
    public static void onScroll( InputEvent.MouseScrollEvent event ) {

        final ClientPlayerEntity player = Minecraft.getInstance().player;
        final ItemStack held = player.getHeldItem( Hand.MAIN_HAND );

        if ( !held.isEmpty() && held.getItem() instanceof DecorativeItem && player.isSneaking() ) {

            final int delta = MathUtil.clamp( (int) Math.round( event.getScrollDelta() ), -1, 1 );

            cycleVariant( held, delta );

            event.setCanceled( true );

        }

    }

    private static void cycleVariant( ItemStack stack, int delta ) {

        final DecorativeBlock block = ModBlocks.BLOCKS.get( stack.getItem().getRegistryName().getPath() );

        if ( block != null )
            Network.channel.sendToServer( new VariantScrollRequest( delta ) );

    }

}
