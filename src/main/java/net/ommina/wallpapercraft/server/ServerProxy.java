package net.ommina.wallpapercraft.server;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.ommina.wallpapercraft.IProxy;

@OnlyIn( Dist.DEDICATED_SERVER )
public final class ServerProxy implements IProxy {

    @Override
    public void init() {
    }

    @Override
    public Level getClientWorld() {
        throw new IllegalStateException( "Only run this on the client!" );
    }

    @Override
    public Player getClientPlayer() {
        throw new IllegalStateException( "Only run this on the client!" );
    }

}