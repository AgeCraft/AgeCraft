package org.agecraft;

import org.agecraft.core.AgeCraftCoreClient;
import org.agecraft.metals.MetalsClient;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract class ACComponentClient {

    public static AgeCraftCoreClient core = new AgeCraftCoreClient(ACComponent.core);
    public static MetalsClient metals = new MetalsClient(ACComponent.metals);

    public ACComponentClient(ACComponent component) {

    }

    public abstract void preInit();

    public abstract void init();

    public abstract void postInit();

    public abstract Object getGuiElement(int id, EntityPlayer player, World world, int x, int y, int z);
}
