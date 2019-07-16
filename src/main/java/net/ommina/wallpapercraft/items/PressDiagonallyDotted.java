package net.ommina.wallpapercraft.items;

public class PressDiagonallyDotted extends PressPattern {

    public static final String VARIANT = "diagonallydotted";
    public static final String NAME = "press" + VARIANT;

    public PressDiagonallyDotted() {
        super( VARIANT );
        setRegistryName( NAME );
    }

}
