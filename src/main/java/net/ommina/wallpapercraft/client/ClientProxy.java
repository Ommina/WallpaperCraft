package net.ommina.wallpapercraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.ommina.wallpapercraft.IProxy;

public class ClientProxy implements IProxy {

    @Override
    public void init() {
    }

    @Override
    public Level getClientWorld() {
        return Minecraft.getInstance().level;
    }

    @Override
    public Player getClientPlayer() {
        return Minecraft.getInstance().player;
    }

}

