package org.agecraft;

import net.ilexiconn.llibrary.common.update.UpdateHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ACReference.MOD_ID, name = ACReference.NAME, version = ACReference.VERSION, acceptedMinecraftVersions = ACReference.MC_VERSION, dependencies = ACReference.DEPENDENCIES)
public class AgeCraft {

	@Instance(ACReference.MOD_ID)
	public static AgeCraft instance;

	@SidedProxy(clientSide = ACReference.CLIENT_PROXY, serverSide = ACReference.SERVER_PROXY)
	public static ACCommonProxy proxy;

	public static Logger log = LogManager.getLogger(ACReference.MOD_ID);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		try {
			UpdateHelper.registerUpdateChecker(instance, ACReference.UPDATE_URL);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		// register render information
		proxy.registerRenderInformation();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
