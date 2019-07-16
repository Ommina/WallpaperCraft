package net.ommina.wallpapercraft.items;

public class PressFrostedGlass extends PressPattern {

    public static final String VARIANT = "frostedglass";
    public static final String NAME = "press" + VARIANT;

    public PressFrostedGlass() {
        super( VARIANT );
        setRegistryName( NAME );
    }

}
