package net.ommina.wallpapercraft.items;

public class PressPattern extends Press {

    public PressPattern( final String pattern ) {
        super( pattern );

        setRegistryName( "press" + pattern );

    }

}
