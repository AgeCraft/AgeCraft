package org.agecraft.core;

import org.agecraft.ACComponent;
import org.agecraft.ACComponentClient;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
    @SideOnly(Side.CLIENT)
    public ACComponentClient getComponentClient() {
        return ACComponentClient.core;
    }
}
