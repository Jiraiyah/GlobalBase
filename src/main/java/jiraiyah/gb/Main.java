package jiraiyah.gb;

import jiraiyah.gb.infrastructure.interfaces.IProxy;
import jiraiyah.gb.infrastructure.proxies.Client;
import jiraiyah.gb.infrastructure.proxies.Server;
import jiraiyah.gb.infrastructure.proxies.SideProxy;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.Random;

// The value here should match an entry in the META-INF/mods.toml file
@SuppressWarnings("WeakerAccess")
@Mod(Reference.MODID)
public class Main
{
    public static final Logger LOGGER = LogManager.getLogger();
	public static final Random random = new Random();
	
	public static Main INSTANCE;
	public static IProxy PROXY;

    public Main() {
        INSTANCE = this;
		PROXY = DistExecutor.runForDist(() -> () -> new Client(), () -> () -> new Server());
    }
	
	public static String getVersion() {
        return getVersion(false);
    }

    public static String getVersion(boolean correctInDev) {
        Optional<? extends ModContainer> o = ModList.get().getModContainerById(Reference.MODID);
        if (o.isPresent()) {
            String str = o.get().getModInfo().getVersion().toString();
            if (correctInDev && "NONE".equals(str))
                return Reference.VERSION;
            return str;
        }
        return "0.0.0";
    }
	
	public static boolean isDevBuild() {
        String version = getVersion(false);
        return "NONE".equals(version);
    }

    public static ResourceLocation getId(String path) {
        return new ResourceLocation(Reference.MODID, path);
    }
}
