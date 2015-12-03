package org.agecraft.metals;

import org.agecraft.ACComponent;
import org.agecraft.ACComponentClient;
import org.agecraft.extendedmetadata.client.EMModelLoader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MetalsClient extends ACComponentClient {

    public MetalsClient(ACComponent component) {
        super(component);
    }

    @Override
    public void preInit() {
        
    }

    @Override
    public void init() {
        EMModelLoader.registerBlockItemModels(Metals.fenceGate, "inventory");
    }

    @Override
    public void postInit() {
        
    }

    @Override
    public Object getGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }
}
