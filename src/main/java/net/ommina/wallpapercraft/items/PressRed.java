package net.ommina.wallpapercraft.items;

public class PressRed extends PressColour {

    public static final String COLOUR = "red";
    public static final String NAME = "press" + COLOUR;

    public PressRed() {
        super( COLOUR );
        setRegistryName( NAME );
    }

}
