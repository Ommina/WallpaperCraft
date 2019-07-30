package net.ommina.wallpapercraft.server;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.ommina.wallpapercraft.IProxy;

@OnlyIn( Dist.DEDICATED_SERVER )
public final class ServerProxy implements IProxy {

    @Override
    public void init() {
    }

    @Override
    public World getClientWorld() {
        throw new IllegalStateException( "Only run this on the client!" );
    }

    @Override
    public PlayerEntity getClientPlayer() {
        throw new IllegalStateException( "Only run this on the client!" );
    }

}