package org.agecraft;

import java.lang.reflect.Field;

import com.google.common.base.CaseFormat;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ACCommonProxy implements IGuiHandler {

    public void preInit() {
        MinecraftForge.EVENT_BUS.register(new ACEventHandler());

        for (ACComponent component : ACComponent.components) {
            component.preInit();

            String componentName = component.name + "_";

            for (Field field : component.getClass().getFields()) {
                try {
                    String fieldName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field.getName());
                    Object obj = field.get(component);
                    if (obj instanceof Block) {
                        Block block = (Block) obj;
                        block.setUnlocalizedName(componentName + fieldName);
                        ItemBlockClass annotation = field.getAnnotation(ItemBlockClass.class);
                        if (annotation != null) {
                            registerBlock(block, annotation.value(), componentName + fieldName);
                        } else {
                            registerBlock(block, null, componentName + fieldName);
                        }
                    } else if (obj instanceof Item) {
                        Item item = (Item) obj;
                        item.setUnlocalizedName(componentName + fieldName);
                        registerItem(item, componentName + fieldName);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerBlock(Block block, Class<? extends ItemBlock> itemClass, String name) {
        if (itemClass == null) {
            GameRegistry.registerBlock(block, name);
        } else {
            GameRegistry.registerBlock(block, itemClass, name);
        }
    }

    public void registerItem(Item item, String name) {
        GameRegistry.registerItem(item, name);
    }

    public void init() {
        for (ACComponent component : ACComponent.components) {
            component.init();
        }
    }

    public void postInit() {
        for (ACComponent component : ACComponent.components) {
            component.postInit();
        }
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        for (ACComponent component : ACComponent.components) {
            Object obj = component.getGuiElement(id, player, world, x, y, z);
            if (obj != null) {
                return obj;
            }
        }
        return null;
    }
}
