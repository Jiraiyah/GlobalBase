package jiraiyah.gb.infrastructure.proxies;

import jiraiyah.gb.Main;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class Server extends SideProxy {

	public static Server INSTANCE;

	public Server() {
		Main.INSTANCE.LOGGER.debug("Global Base ---> SideProxy.Server init");
		INSTANCE = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(INSTANCE::serverSetup);
	}

	private void serverSetup(FMLDedicatedServerSetupEvent event) {
		Main.INSTANCE.LOGGER.debug("Global Base ---> Server Setup");
	}
}