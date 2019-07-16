package net.ommina.wallpapercraft.items;

public class PressBlank extends PressPattern {

    public static final String VARIANT = "solid";
    public static final String NAME = "press" + VARIANT;

    public PressBlank() {
        super( VARIANT );
        setRegistryName( NAME );
    }

}
