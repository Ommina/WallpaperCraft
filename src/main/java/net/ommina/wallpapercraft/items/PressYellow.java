package net.ommina.wallpapercraft.items;

public class PressYellow extends PressColour {

    public static final String COLOUR = "yellow";
    public static final String NAME = "press" + COLOUR;

    public PressYellow() {
        super( COLOUR );
        setRegistryName( NAME );
    }

}
