package net.ommina.wallpapercraft.items;

public class PressColour extends Press {

    public PressColour( final String colour ) {
        super( colour );

        setRegistryName( "press" + colour );
    }

}
