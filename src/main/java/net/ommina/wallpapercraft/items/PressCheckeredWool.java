package net.ommina.wallpapercraft.items;

public class PressCheckeredWool extends PressPattern {

    public static final String VARIANT = "checkeredwool";
    public static final String NAME = "press" + VARIANT;

    public PressCheckeredWool() {
        super( VARIANT );
        setRegistryName( NAME );
    }

}
