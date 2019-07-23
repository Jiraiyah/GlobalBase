package jiraiyah.gb.infrastructure.proxies;
import jiraiyah.gb.Main;
import jiraiyah.gb.infrastructure.interfaces.IProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import javax.annotation.Nullable;

import static jiraiyah.gb.Main.*;

public class SideProxy implements IProxy
{
	
	private MinecraftServer server = null;
	
	SideProxy() {
		LOGGER.debug("Global Base ---> SideProxy init");
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::imcEnqueue);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::imcProcess);
		
		//FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, GemsBlocks::registerAll);
        //FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(ContainerType.class, GemsContainers::registerAll);
        //FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Enchantment.class, GemsEnchantments::registerAll);
        //FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(EntityType.class, GemsEntities::registerAll);
        //FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, GemsItems::registerAll);
        //FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Effect.class, GemsEffects::registerEffects);
        //FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Potion.class, GemsEffects::registerPotions);
        //FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(SoundEvent.class, GemsSounds::registerAll);
        //FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(TileEntityType.class, GemsTileEntities::registerAll);

        MinecraftForge.EVENT_BUS.addListener(this::serverAboutToStart);
	}
	
	private void commonSetup(FMLCommonSetupEvent event) {
		LOGGER.debug("Global Base ---> Common Setup");
	}
	
	private void imcEnqueue(InterModEnqueueEvent event) {
		LOGGER.debug("Global Base ---> IMC Enqueue");
	}
	
	private void imcProcess(InterModProcessEvent event) {
		LOGGER.debug("Global Base ---> IMC Process");
	}
	
	private void serverAboutToStart(FMLServerAboutToStartEvent event) {
		LOGGER.debug("Global Base ---> Server About To Start");
		server = event.getServer();
	}
	
	@Override
    public MinecraftServer getServer() {
        return server;
    }
}