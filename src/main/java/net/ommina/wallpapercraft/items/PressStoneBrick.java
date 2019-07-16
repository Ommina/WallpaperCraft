package net.ommina.wallpapercraft.items;

public class PressStoneBrick extends PressPattern {

    public static final String VARIANT = "stonebrick";
    public static final String NAME = "press" + VARIANT;

    public PressStoneBrick() {
        super( VARIANT );
        setRegistryName( NAME );
    }

}
