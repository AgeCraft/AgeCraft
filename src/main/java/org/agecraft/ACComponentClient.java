package org.agecraft;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract class ACComponentClient {

	public ACComponentClient(ACComponent component) {
		
	}
	
	public abstract void preInit();

	public abstract void init();

	public abstract void postInit();
}
