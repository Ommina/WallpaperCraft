package net.ommina.wallpapercraft.items;

public class PressTintedGlass extends PressPattern {

    public static final String VARIANT = "tintedglass";
    public static final String NAME = "press" + VARIANT;

    public PressTintedGlass() {
        super( VARIANT );
        setRegistryName( NAME );
    }

}
