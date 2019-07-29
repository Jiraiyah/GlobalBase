package jiraiyah.globalbase;

import jiraiyah.globalbase.infrastructure.bases.GenericItemGroup;
import jiraiyah.globalbase.inits.BaseItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
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

    public static final ItemGroup DUST_TAB = new ItemGroup(Reference.MODID) {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(BaseItems.Dusts.ALUMITE);
        }
    };

    public static final ItemGroup GEAR_TAB = new ItemGroup(Reference.MODID) {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(BaseItems.Gears.ALUMITE);
        }
    };

    public static final ItemGroup INGOT_TAB = new ItemGroup(Reference.MODID) {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(BaseItems.Ingots.ALUMITE);
        }
    };

    public static final ItemGroup NUGGET_TAB = new ItemGroup(Reference.MODID) {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(BaseItems.Nuggets.ALUMITE);
        }
    };

    public static final ItemGroup PLATE_TAB = new ItemGroup(Reference.MODID) {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(BaseItems.Plates.ALUMITE);
        }
    };

    public static final ItemGroup REINFORCED_TAB = new ItemGroup(Reference.MODID) {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(BaseItems.Reinforced.ALUMITE);
        }
    };

    public static final ItemGroup ROD_TAB = new ItemGroup(Reference.MODID) {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(BaseItems.Rods.ALUMITE);
        }
    };

    public Main()
    {
        INSTANCE = this;
		//PROXY = DistExecutor.runForDist(() -> () -> new Client(), () -> () -> new Server());
        MinecraftForge.EVENT_BUS.register(this);
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
