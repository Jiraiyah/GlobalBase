package jiraiyah.globalbase;

import jiraiyah.globalbase.infrastructure.bases.GenericItemGroup;
import net.minecraft.util.ResourceLocation;
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

    public static final GenericItemGroup DUST_TAB = new GenericItemGroup(Reference.Items.DUST_PREFIX);
    public static final GenericItemGroup GEAR_TAB = new GenericItemGroup(Reference.Items.GEAR_PREFIX);
    public static final GenericItemGroup INGOT_TAB = new GenericItemGroup(Reference.Items.INGOT_PREFIX);
    public static final GenericItemGroup NUGGET_TAB = new GenericItemGroup(Reference.Items.NUGGET_PREFIX);
    public static final GenericItemGroup PLATE_TAB = new GenericItemGroup(Reference.Items.PLATE_PREFIX);
    public static final GenericItemGroup REINFORCED_TAB = new GenericItemGroup(Reference.Items.REINFORCED_PREFIX);
    public static final GenericItemGroup ROD_TAB = new GenericItemGroup(Reference.Items.ROD_PREFIX);

    public Main()
    {
        INSTANCE = this;
		//PROXY = DistExecutor.runForDist(() -> () -> new Client(), () -> () -> new Server());
    }
	
	public static String getVersion() {
        return getVersion(false);
    }

    public static String getVersion(boolean correctInDev)
    {
        Optional<? extends ModContainer> o = ModList.get().getModContainerById(Reference.MODID);
        if (o.isPresent()) {
            String str = o.get().getModInfo().getVersion().toString();
            if (correctInDev && "NONE".equals(str))
                return Reference.VERSION;
            return str;
        }
        return "0.0.0";
    }
	
	public static boolean isDevBuild()
    {
        String version = getVersion(false);
        return "NONE".equals(version);
    }

    public static ResourceLocation getId(String path) {
        return new ResourceLocation(Reference.MODID, path);
    }
}
