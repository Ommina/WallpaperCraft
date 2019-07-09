package net.ommina.wallpapercraft.items;

public class PressAuraLamp extends Press {

    public static final String VARIANT = "auralamp";
    public static final String NAME = "press" + VARIANT;

    public PressAuraLamp() {
        super( VARIANT );

        setRegistryName( NAME );
    }

}
