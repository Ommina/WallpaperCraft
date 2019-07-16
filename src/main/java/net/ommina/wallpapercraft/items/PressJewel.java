package net.ommina.wallpapercraft.items;

public class PressJewel extends PressPattern {

    public static final String VARIANT = "jewel";
    public static final String NAME = "press" + VARIANT;

    public PressJewel() {
        super( VARIANT );
        setRegistryName( NAME );
    }

}
