package net.ommina.wallpapercraft.items;

public class PressDotted extends PressPattern {

    public static final String VARIANT = "dotted";
    public static final String NAME = "press" + VARIANT;

    public PressDotted() {
        super( VARIANT );
        setRegistryName( NAME );
    }

}
