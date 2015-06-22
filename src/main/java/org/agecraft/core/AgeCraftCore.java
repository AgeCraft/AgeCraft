package org.agecraft.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import org.agecraft.ACComponent;
import org.agecraft.ACComponentClient;

public class AgeCraftCore extends ACComponent {

    public AgeCraftCore() {
        super("core");
    }

    @Override
    public void preInit() {

    }

    @Override
    public void init() {

    }

    @Override
    public void postInit() {

    }

    @Override
    public Object getGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public ACComponentClient getComponentClient() {
        return ACComponentClient.core;
    }
}
