package net.ommina.wallpapercraft.items;

public class PressWoodPlank extends PressPattern {

    public static final String VARIANT = "woodplank";
    public static final String NAME = "press" + VARIANT;

    public PressWoodPlank() {
        super( VARIANT );
        setRegistryName( NAME );
    }

}
