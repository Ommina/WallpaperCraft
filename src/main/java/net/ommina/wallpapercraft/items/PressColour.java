package net.ommina.wallpapercraft.items;

public class PressColour extends Press {

    private String colour;

    public PressColour( final String colour ) {
        super( colour );

        this.colour = colour;

        setRegistryName( "press" + colour );
    }

    public String getColour() {
        return this.colour;
    }

}
