package net.ommina.wallpapercraft.items;

public class PressDamask extends PressPattern {

    public static final String VARIANT = "damask";
    public static final String NAME = "press" + VARIANT;

    public PressDamask() {
        super( VARIANT );
        setRegistryName( NAME );

    }

}
