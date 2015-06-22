package org.agecraft;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ACCommonProxy implements IGuiHandler {

	public void preInit() {
		FMLCommonHandler.instance().bus().register(new ACEventHandler());
		
		for(ACComponent component : ACComponent.components) {
			component.preInit();
			
			String componentName = "AC_" + component.name + "_";
			
			for(Field field : component.getClass().getFields()) {
				try {
					Object obj = field.get(component);
					if(obj instanceof Block) {
						Block block = (Block) obj;
						block.setUnlocalizedName(componentName + field.getName());
						ItemBlockClass annotation = field.getAnnotation(ItemBlockClass.class);
						if(annotation != null) {
							GameRegistry.registerBlock(block, annotation.value(), componentName + field.getName());
						} else {
							GameRegistry.registerBlock(block, componentName + field.getName());
						}
					} else if(obj instanceof Item) {
						Item item = (Item) obj;
						item.setUnlocalizedName(componentName + field.getName());
						GameRegistry.registerItem(item, componentName + field.getName());
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
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

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		for(ACComponent component : ACComponent.components) {
			Object obj = component.getGuiElement(id, player, world, x, y, z);
			if(obj != null) {
				return obj;
			}
		}
		return null;
	}
}
