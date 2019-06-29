package net.ommina.wallpapercraft.items;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;
import net.ommina.wallpapercraft.Wallpapercraft;
import net.ommina.wallpapercraft.blocks.ModBlocks;

@ObjectHolder(Wallpapercraft.MODID)
public class ModItems {

    public static Item foo = new BlockItem( ModBlocks.BLOCKS.get( "auralampcyan-8" ), new Item.Properties() );

    @ObjectHolder("pressauralamp")
    public static PressAuraLamp PRESS_AURALAMP;

    @ObjectHolder(PressBlank.REG)
    public static PressBlank PRESS_BLANK;

    @ObjectHolder("pressbrick")
    public static PressBrick PRESS_BRICK;

    @ObjectHolder("presscheckered")
    public static PressCheckered PRESS_CHECKERED;

    @ObjectHolder(PressClay.REGISTRY)
    public static PressClay PRESS_CLAY;

    @ObjectHolder("presscolouredbrick")
    public static PressColouredBrick PRESS_COLOUREDBRICK;

    @ObjectHolder("pressdamask")
    public static PressDamask PRESS_DAMASK;

    @ObjectHolder("pressdiagonallydotted")
    public static PressDiagonallyDotted PRESS_DIAGONALLYDOTTED;

    @ObjectHolder("pressdotted")
    public static PressDotted PRESS_DOTTED;

    @ObjectHolder("pressfancytiles")
    public static PressFancyTiles PRESS_FANCYTILES;

    @ObjectHolder("pressfloral")
    public static PressFloral PRESS_FLORAL;

    @ObjectHolder("pressfrostedglass")
    public static PressFrostedGlass PRESS_FROSTEDGLASS;

    @ObjectHolder("pressjewel")
    public static PressJewel PRESS_JEWEL;

    @ObjectHolder("pressrippled")
    public static PressRippled PRESS_RIPPLED;

    @ObjectHolder("pressstamp")
    public static PressStamp PRESS_STAMP;

    @ObjectHolder("pressstonebrick")
    public static PressStoneBrick PRESS_STONEBRICK;

    @ObjectHolder("pressstonelamp")
    public static PressStoneLamp PRESS_STONELAMP;

    @ObjectHolder("pressstriped")
    public static PressStriped PRESS_STRIPED;

    @ObjectHolder("presstexturedglass")
    public static PressTexturedGlass PRESS_TEXTUREDGLASS;

    @ObjectHolder("presstintedglass")
    public static PressTintedGlass PRESS_TINTEDGLASS;

    @ObjectHolder("presswoodplank")
    public static PressWoodPlank PRESS_WOODPLANK;

    @ObjectHolder("presswool")
    public static PressWool PRESS_WOOL;

    public static void register ( final RegistryEvent.Register<Item> event ) {

        for ( String s : ModBlocks.BLOCKS.keySet() ) { //todo: Maybe sort these so they appear in the creative tab/tabs in some sane order
            event.getRegistry().register( new BlockItem( ModBlocks.BLOCKS.get( s ), new Item.Properties().group( Wallpapercraft.TAB ) ).setRegistryName( s ) );
        }

        event.getRegistry().registerAll(
             new PressAuraLamp(),
             new PressBlank(),
             new PressBrick(),
             new PressCheckered(),
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
    }

}
