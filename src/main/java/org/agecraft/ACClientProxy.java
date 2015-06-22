package org.agecraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
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
			if(component.getComponentClient() != null) {
				component.getComponentClient().preInit();
			}
		}
	}
	
	@Override
	public void init() {
		super.init();
		for(ACComponent component : ACComponent.components) {
			if(component.getComponentClient() != null) {
				component.getComponentClient().init();
			}
		}
	}
	
	@Override
	public void postInit() {
		super.postInit();
		for(ACComponent component : ACComponent.components) {
			if(component.getComponentClient() != null) {
				component.getComponentClient().postInit();
			}
		}
	}
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		for(ACComponent component : ACComponent.components) {
			if(component.getComponentClient() != null) {
				Object obj = component.getComponentClient().getGuiElement(id, player, world, x, y, z);
				if(obj != null) {
					return obj;
				}
			}
		}
		return null;
	}
}
