package net.ommina.wallpapercraft.items;

public class PressStriped extends PressPattern {

    public static final String VARIANT = "striped";
    public static final String NAME = "press" + VARIANT;

    public PressStriped() {
        super( VARIANT );
        setRegistryName( NAME );

    }

}
