package org.agecraft;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ACCommonProxy {

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
						Annotation annotation = field.getAnnotation(ItemBlockClass.class);
						if(annotation != null) {
							GameRegistry.registerBlock(block, ((ItemBlockClass) annotation).value(), componentName + field.getName());
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
}
