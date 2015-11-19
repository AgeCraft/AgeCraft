package org.agecraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.ilexiconn.llibrary.common.config.ConfigHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ACReference.MOD_ID, name = ACReference.NAME, version = ACReference.VERSION, acceptedMinecraftVersions = ACReference.MC_VERSION, dependencies = ACReference.DEPENDENCIES)
public class AgeCraft {

    @Instance(ACReference.MOD_ID)
    public static AgeCraft instance;

    @SidedProxy(clientSide = ACReference.CLIENT_PROXY, serverSide = ACReference.SERVER_PROXY)
    public static ACCommonProxy proxy;

    public static Logger log = LogManager.getLogger(ACReference.MOD_ID);

    public static ACConfigHandler configHandler;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        FMLInterModComms.sendMessage("llibrary", "update-checker", ACReference.UPDATE_URL);

        ConfigHelper.registerConfigHandler(ACReference.MOD_ID, event.getSuggestedConfigurationFile(), configHandler = new ACConfigHandler());
        
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }
}
