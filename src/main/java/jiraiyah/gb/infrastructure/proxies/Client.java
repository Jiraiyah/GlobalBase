package jiraiyah.gb.infrastructure.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import javax.annotation.Nullable;

import static jiraiyah.gb.Main.LOGGER;

public class Client extends SideProxy {
    public Client() {
        LOGGER.debug("Global Base ---> SideProxy.Client init");

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
    }

    private void clientSetup(FMLClientSetupEvent event) {
        LOGGER.debug("Global Base ---> Client Setup");
        // register renderer for entities, tile entities, and register containers
        // EXAMPLE :
        //GemsEntities.registerRenderers(event);
        //GemsTileEntities.registerRenderers(event);
        //GemsContainers.registerScreens(event);
    }

    @Nullable
    @Override
    public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
    }
}
