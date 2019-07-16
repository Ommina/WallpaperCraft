package net.ommina.wallpapercraft.items;

public class PressBrick extends PressPattern {

    public static final String VARIANT = "brick";
    public static final String NAME = "press" + VARIANT;

    public PressBrick() {
        super( VARIANT );
        setRegistryName( NAME );

    }

}
