package jiraiyah.globalbase.utils.handlers;

import jiraiyah.globalbase.Main;
import jiraiyah.globalbase.Reference;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static jiraiyah.globalbase.Reference.Items.Names.*;
import static jiraiyah.globalbase.Reference.Items.Names.GOLD;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler
{
    public static final List<Item> SUB_ITEMS = new ArrayList<>();
    public static final List<Item> ITEMS = new ArrayList<>();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();

        String[] Materials = {ALUMINIUM, ALUMINIUM_BRASS, ALUMITE, ARDITE, BAUXITE, BERYLLIUM, BLUTONIUM, BORON,
                              BRASS, BRONZE, CONDUCTIVE_IRON, CONSTANTIN, COPPER, CRUDE_STEEL, CYANIDE, DARK_STEEL,
                              DEMONIC, DAWN_STONE, DRACONIUM, ELECTRICAL_STEEL, ELECTRUM, ENCHANTED, END_STEEL, ENERGETIC_SILVER,
                              FLUXED_ELECTRUM, GLOW_STONE, GRAPHITE, INVAR, IRIDIUM, LEAD, LITHIUM, LUDICRITE, MAGNESIUM,
                              MANGANESE, MANGANESE_OXIDE, MANYULLYN, MIRION, NICKEL, OSGLOGLAS, OSMIUM, OSMIRIDIUM, PINK_SLIME,
                              PLATINUM, PULSATING_IRON, REFINED_OBSIDIAN, SILVER, SOLARIUM, STEEL, TIN, TITANIUM, THORIUM, THORIUM_OXIDE,
                              URANIUM, URANIUM_OXIDE, YELLORIUM, ZINC, ZIRCONIUM, IRON, GOLD};

        for (String name : Materials)
        {
            if(!name.equals(GLOW_STONE))
                registerItem(new Item(new Item.Properties().group(Main.DUST_TAB)), Reference.Items.DUST_PREFIX + "_" + name, registry);
            registerItem(new Item(new Item.Properties().group(Main.GEAR_TAB)), Reference.Items.GEAR_PREFIX + "_" + name, registry);
            if(!name.equals(IRON) && !name.equals(GOLD))
                registerItem(new Item(new Item.Properties().group(Main.INGOT_TAB)), Reference.Items.INGOT_PREFIX + "_" + name, registry);
            if(!name.equals(IRON) && !name.equals(GOLD))
                registerItem(new Item(new Item.Properties().group(Main.NUGGET_TAB)), Reference.Items.NUGGET_PREFIX + "_" + name, registry);
            registerItem(new Item(new Item.Properties().group(Main.PLATE_TAB)), Reference.Items.PLATE_PREFIX + "_" + name, registry);
            registerItem(new Item(new Item.Properties().group(Main.REINFORCED_TAB)), Reference.Items.REINFORCED_PREFIX + "_" + name, registry);
            registerItem(new Item(new Item.Properties().group(Main.ROD_TAB)), Reference.Items.ROD_PREFIX + "_" + name, registry);
        }
        registerItem(new Item(new Item.Properties().group(Main.INGOT_TAB)), "item_wax", registry);
    }

    /*@SubscribeEvent
    public static void registerModels(ModelRegistryEvent event)
    {
        for (Item item : SUB_ITEMS)
        {
            String[] split = Objects.requireNonNull(item.getRegistryName()).toString().split(":");
            String[] spl = split[1].split("_");
            String tmp = split[0] + ":" + spl[0] + "/" + split[1];
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(tmp, "inventory"));
        }
        for (Item item : ITEMS)
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));

        //TODO : Register Block Models
    }*/

    //TODO : Register Commands Event

    /*private static void registerItem(Item item, String name, IForgeRegistry<Item> registry, boolean isSubFolder)*/
    private static void registerItem(Item item, String name, IForgeRegistry<Item> registry)
    {
        item.setRegistryName(name);

        /*if(isSubFolder)
            SUB_ITEMS.add(item);
        else
            ITEMS.add(item);*/

        registry.register(item);
    }
}
