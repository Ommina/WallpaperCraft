package net.ommina.wallpapercraft.items;

public class PressRippled extends PressPattern {

    public static final String VARIANT = "rippled";
    public static final String NAME = "press" + VARIANT;

    public PressRippled() {
        super( VARIANT );
        setRegistryName( NAME );
    }

}
