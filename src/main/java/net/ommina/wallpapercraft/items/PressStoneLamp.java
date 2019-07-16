package net.ommina.wallpapercraft.items;

public class PressStoneLamp extends PressPattern {

    public static final String VARIANT = "stonelamp";
    public static final String NAME = "press" + VARIANT;

    public PressStoneLamp() {
        super( VARIANT );
        setRegistryName( NAME );
    }

}
