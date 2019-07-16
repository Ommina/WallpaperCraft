package net.ommina.wallpapercraft.items;

public class PressClay extends PressPattern {

    public static final String VARIANT = "clay";
    public static final String NAME = "press" + VARIANT;

    public PressClay() {
        super( VARIANT );
        setRegistryName( NAME );

    }

}
