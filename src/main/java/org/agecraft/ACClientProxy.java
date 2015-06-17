package org.agecraft;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ACClientProxy extends ACCommonProxy {

	@Override
	public void preInit() {
		super.preInit();
		
		AgeCraft.eventHandlerClient = new ACEventHandlerClient();
		FMLCommonHandler.instance().bus().register(AgeCraft.eventHandlerClient);
		
		for(ACComponent component : ACComponent.components) {
			component.getComponentClient().preInit();
		}
	}
	
	@Override
	public void init() {
		super.init();
		for(ACComponent component : ACComponent.components) {
			component.getComponentClient().init();
		}
	}
	
	@Override
	public void postInit() {
		super.postInit();
		for(ACComponent component : ACComponent.components) {
			component.getComponentClient().postInit();
		}
	}
}
