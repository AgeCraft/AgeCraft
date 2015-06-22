package org.agecraft.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.agecraft.ACComponent;
import org.agecraft.ACComponentClient;

@SideOnly(Side.CLIENT)
public class AgeCraftCoreClient extends ACComponentClient {

    public AgeCraftCoreClient(ACComponent component) {
        super(component);
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
}
