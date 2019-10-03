package net.ommina.wallpapercraft.util;

public class MathUtil {

    public static int clamp( final int value, final int min, final int max ) {

        if ( value < min )
            return min;
        else if ( value > max )
            return max;
        else
            return value;

    }

    public static int rollOver( final int value, final int min, final int max ) {

        if ( value < min )
            return max;
        else if ( value > max )
            return min;
        else
            return value;

    }

}
