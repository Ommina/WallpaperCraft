package net.ommina.wallpapercraft.items;

public class PressBlank extends Press {

    public static final String VARIANT = "blank";
    public static final String NAME = "press" + VARIANT;

    public PressBlank() {
        super( VARIANT );
        setRegistryName( NAME );
    }

}
