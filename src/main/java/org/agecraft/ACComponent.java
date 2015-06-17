package org.agecraft;

import java.util.ArrayList;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ACComponent {

	public static ArrayList<ACComponent> components = new ArrayList<ACComponent>();
	
	public String name;
	
	public ACComponent(String name) {
		this.name = name;
		
		components.add(this);
	}
	
	public abstract void preInit();

	public abstract void init();
	
	public abstract void postInit();
	
	@SideOnly(Side.CLIENT)
	public abstract ACComponentClient getComponentClient();
}
