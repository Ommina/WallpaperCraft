package net.ommina.wallpapercraft;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.ommina.wallpapercraft.blocks.ModBlocks;
import net.ommina.wallpapercraft.client.ClientProxy;
import net.ommina.wallpapercraft.items.ModItems;
import net.ommina.wallpapercraft.network.Network;
import net.ommina.wallpapercraft.recipes.PressCraftingRecipe;
import net.ommina.wallpapercraft.server.ServerProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod( Wallpapercraft.MODID )
public class Wallpapercraft {

    public static final IProxy PROXY = DistExecutor.runForDist( () -> ClientProxy::new, () -> ServerProxy::new );
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "wallpapercraft";

    public static final CreativeModeTab TAB = new CreativeTab();

    public Wallpapercraft() {

        MinecraftForge.EVENT_BUS.register( this );

        DeferredRegistries.setup();

        FMLJavaModLoadingContext.get().getModEventBus().addListener( this::setup );

    }

    @Mod.EventBusSubscriber( bus = Mod.EventBusSubscriber.Bus.MOD )
    public static class RegistryEvents {

        @SubscribeEvent
        public static void registerSerials( final RegistryEvent.Register<RecipeSerializer<?>> event ) {
            event.getRegistry().register( PressCraftingRecipe.SERIALIZER );
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

    public static ResourceLocation getId( final String path ) {
        return new ResourceLocation( MODID, path );
    }

    public static ResourceLocation getId( final String namespace, final String path ) {

        if ( namespace == null || namespace.isEmpty() )
            return getId( path );

        return new ResourceLocation( namespace, path );

    }

    private void setup( final FMLCommonSetupEvent event ) {
        Network.init();
    }

}