package net.ommina.wallpapercraft.items;

public class PressCheckered extends Press {

    public static final String VARIANT = "checkeredwool";
    public static final String NAME = "press" + VARIANT;

    public PressCheckered() {
        super( VARIANT );
        setRegistryName( NAME );
    }

}
