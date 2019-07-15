package net.ommina.wallpapercraft;

public class MouseScrollHandler {

    /*

    public static KeyBinding scrollKey;

    private static MouseScrollHandler mouseScrollHandler;

    public MouseScrollHandler() {

        MinecraftForge.EVENT_BUS.addListener( EventPriority.LOWEST, this::onKey );
        MinecraftForge.EVENT_BUS.addListener( EventPriority.LOWEST, this::onMousie );
        MinecraftForge.EVENT_BUS.addListener( EventPriority.LOWEST, this::onScroll );

    }

    public static void init() {

        mouseScrollHandler = new MouseScrollHandler();

        scrollKey = new KeyBinding( Wallpapercraft.MODID + ".key.scrollKey", GLFW_KEY_LEFT_SHIFT, "key.categories." + Wallpapercraft.MODID );

        ClientRegistry.registerKeyBinding( scrollKey );

    }

    private void onKey( GuiScreenEvent.KeyboardKeyPressedEvent.Pre event ) {

        System.out.println( " OnKey: " + event + " keyDown: " + scrollKey.isKeyDown() );

    }

    public void onMousie( InputEvent.MouseInputEvent event ) {

        System.out.println( " onMousie: " + event + " action " + event.getAction() + " mods: " + event.getMods() + " keyDown: " + scrollKey.isKeyDown() );

    }

    private void onScroll( GuiScreenEvent.MouseScrollEvent.Post event ) {

        System.out.println( " onScroll: " + event + " keyDown: " + scrollKey.isKeyDown() );

        if( !Minecraft.isGuiEnabled() ) {

            System.out.println( "action: " + event.getScrollDelta() );

            ClientPlayerEntity player = Minecraft.getInstance().player;
            ItemStack held = player.getHeldItem( Hand.MAIN_HAND );

            if( !held.isEmpty() && held.getItem() instanceof DecorativeItem )
                System.out.println( "yay! " + held.getItem().toString() );

        }

    }
*/
}
