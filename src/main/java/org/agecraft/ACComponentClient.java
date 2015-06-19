package org.agecraft;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.agecraft.core.AgeCraftCoreClient;

@SideOnly(Side.CLIENT)
public abstract class ACComponentClient {

	public static AgeCraftCoreClient core = new AgeCraftCoreClient(ACComponent.core);
	
	public ACComponentClient(ACComponent component) {
		
	}
	
	public abstract void preInit();

	public abstract void init();

	public abstract void postInit();
}
