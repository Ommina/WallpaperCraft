package net.ommina.wallpapercraft.items;

public class PressVariant extends Press {

    public PressVariant( final String variant ) {
        super( "-" + variant );

        setRegistryName( "pressvariant" + variant );
    }

}
