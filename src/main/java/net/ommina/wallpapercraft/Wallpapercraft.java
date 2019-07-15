package net.ommina.wallpapercraft;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.ommina.wallpapercraft.blocks.ModBlocks;
import net.ommina.wallpapercraft.client.ClientProxy;
import net.ommina.wallpapercraft.items.ModItems;
import net.ommina.wallpapercraft.recipes.PressCraftingRecipe;
import net.ommina.wallpapercraft.server.ServerProxy;
import net.ommina.wallpapercraft.util.Proxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod( "wallpapercraft" )
public class Wallpapercraft {

    public static final Proxy PROXY = DistExecutor.runForDist( () -> ClientProxy::new, () -> ServerProxy::new );
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "wallpapercraft";

    public static final ItemGroup TAB = new CreativeTab();


    public Wallpapercraft() {
        MinecraftForge.EVENT_BUS.register( this );
        //FMLJavaModLoadingContext.get().getModEventBus().addListener( this::clientSetupEvent );
    }

    public static ResourceLocation getId( String path ) {

        return new ResourceLocation( MODID, path );

    }

    //TODO: 'Jewel', 'Stamp' lack colour variants, and will need their own recipe handing
    //TODO: Glass blocks are not transparent

    //private void clientSetupEvent( final FMLClientSetupEvent event ) {

    //    MouseScrollHandler.init();

    //}

    /*

    private void setup( final FMLCommonSetupEvent event ) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void enqueueIMC( final InterModEnqueueEvent event ) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC( final InterModProcessEvent event ) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }


    */


    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber( bus = Mod.EventBusSubscriber.Bus.MOD )
    public static class RegistryEvents {

        @SubscribeEvent
        public static void registerSerials( RegistryEvent.Register<IRecipeSerializer<?>> event ) {

            IRecipeSerializer.register( PressCraftingRecipe.NAME.toString(), PressCraftingRecipe.SERIALIZER );

        }

        @SubscribeEvent
        public static void onBlocksRegistry( final RegistryEvent.Register<Block> event ) {

            ModBlocks.register( event );
        }

        @SubscribeEvent
        public static void onItemsRegistry( final RegistryEvent.Register<Item> event ) {

            ModItems.register( event );

        }

    }

}
