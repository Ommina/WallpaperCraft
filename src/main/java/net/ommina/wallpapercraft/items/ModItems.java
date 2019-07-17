package net.ommina.wallpapercraft.items;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;
import net.ommina.wallpapercraft.Wallpapercraft;
import net.ommina.wallpapercraft.blocks.ModBlocks;

import java.util.HashMap;
import java.util.Map;

@ObjectHolder( Wallpapercraft.MODID )
public class ModItems {

    public static Map<String, Item> ITEMS = new HashMap<String, Item>();

    @ObjectHolder( PressAuraLamp.NAME )
    public static PressAuraLamp PRESS_AURALAMP;

    @ObjectHolder( PressBlank.NAME )
    public static PressBlank PRESS_SOLID;

    @ObjectHolder( PressBrick.NAME )
    public static PressBrick PRESS_BRICK;

    @ObjectHolder( PressCheckeredWool.NAME )
    public static PressCheckeredWool PRESS_CHECKEREDWOOL;

    @ObjectHolder( PressClay.NAME )
    public static PressClay PRESS_CLAY;

    @ObjectHolder( PressColouredBrick.NAME )
    public static PressColouredBrick PRESS_COLOUREDBRICK;

    @ObjectHolder( PressDamask.NAME )
    public static PressDamask PRESS_DAMASK;

    @ObjectHolder( PressDiagonallyDotted.NAME )
    public static PressDiagonallyDotted PRESS_DIAGONALLYDOTTED;

    @ObjectHolder( PressDotted.NAME )
    public static PressDotted PRESS_DOTTED;

    @ObjectHolder( PressFancyTiles.NAME )
    public static PressFancyTiles PRESS_FANCYTILES;

    @ObjectHolder( PressFloral.NAME )
    public static PressFloral PRESS_FLORAL;

    @ObjectHolder( PressFrostedGlass.NAME )
    public static PressFrostedGlass PRESS_FROSTEDGLASS;

    @ObjectHolder( PressJewel.NAME )
    public static PressJewel PRESS_JEWEL;

    @ObjectHolder( PressRippled.NAME )
    public static PressRippled PRESS_RIPPLED;

    @ObjectHolder( PressStamp.NAME )
    public static PressStamp PRESS_STAMP;

    @ObjectHolder( PressStoneBrick.NAME )
    public static PressStoneBrick PRESS_STONEBRICK;

    @ObjectHolder( PressStoneLamp.NAME )
    public static PressStoneLamp PRESS_STONELAMP;

    @ObjectHolder( PressStriped.NAME )
    public static PressStriped PRESS_STRIPED;

    @ObjectHolder( PressTexturedGlass.NAME )
    public static PressTexturedGlass PRESS_TEXTUREDGLASS;

    @ObjectHolder( PressTintedGlass.NAME )
    public static PressTintedGlass PRESS_TINTEDGLASS;

    @ObjectHolder( PressWoodPlank.NAME )
    public static PressWoodPlank PRESS_WOODPLANK;

    @ObjectHolder( PressWool.NAME )
    public static PressWool PRESS_WOOL;

    @ObjectHolder( PressBlue.NAME )
    public static PressBlue PRESS_BLUE;

    @ObjectHolder( PressBrown.NAME )
    public static PressBrown PRESS_BROWN;

    @ObjectHolder( PressCyan.NAME )
    public static PressRed PRESS_CYAN;

    @ObjectHolder( PressGray.NAME )
    public static PressGray PRESS_GRAY;

    @ObjectHolder( PressGreen.NAME )
    public static PressGreen PRESS_GREEN;

    @ObjectHolder( PressPurple.NAME )
    public static PressPurple PRESS_PURPLE;

    @ObjectHolder( PressRed.NAME )
    public static PressRed PRESS_RED;

    @ObjectHolder( PressYellow.NAME )
    public static PressYellow PRESS_YELLOW;

    //@ObjectHolder( PressVariant1.NAME )
    //public static PressVariant1 PRESS_VARIANT1;


    public static void register( final RegistryEvent.Register<Item> event ) {

        ModBlocks.BLOCKS.keySet().stream().sorted().forEachOrdered( s -> {
            final Item item = new DecorativeItem( ModBlocks.BLOCKS.get( s ), new Item.Properties().group( Wallpapercraft.TAB ) ).setRegistryName( s );
            event.getRegistry().register( item );
            ITEMS.put( item.getRegistryName().getPath(), item );
        } );

        for( int i = 0; i <= 14; i++ ) {
            final Item item = new PressVariant( Integer.toString( i ) );
            event.getRegistry().register( item );
            ITEMS.put( item.getRegistryName().getPath(), item );
        }

        event.getRegistry().registerAll(
             new PressBlank(),
             new PressAuraLamp(),
             new PressBrick(),
             new PressCheckeredWool(),
             new PressClay(),
             new PressColouredBrick(),
             new PressDamask(),
             new PressDiagonallyDotted(),
             new PressDotted(),
             new PressFancyTiles(),
             new PressFloral(),
             new PressFrostedGlass(),
             new PressJewel(),
             new PressRippled(),
             new PressStamp(),
             new PressStoneBrick(),
             new PressStoneLamp(),
             new PressStriped(),
             new PressTexturedGlass(),
             new PressTintedGlass(),
             new PressWoodPlank(),
             new PressWool()
        );

        event.getRegistry().registerAll(
             new PressBlue(),
             new PressBrown(),
             new PressCyan(),
             new PressGray(),
             new PressGreen(),
             new PressPurple(),
             new PressRed(),
             new PressYellow()
        );

        //event.getRegistry().registerAll(
        //     new PressVariant1()
        //);

    }

}
