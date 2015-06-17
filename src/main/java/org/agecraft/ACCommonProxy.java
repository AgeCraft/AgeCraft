package org.agecraft;

import net.minecraftforge.fml.common.FMLCommonHandler;

public class ACCommonProxy {

	public void preInit() {
		FMLCommonHandler.instance().bus().register(new ACEventHandler());
		
		for(ACComponent component : ACComponent.components) {
			component.preInit();
		}
	}
	
	public void init() {
		for(ACComponent component : ACComponent.components) {
			component.init();
		}
	}
	
	public void postInit() {
		for(ACComponent component : ACComponent.components) {
			component.postInit();
		}
	}
}
