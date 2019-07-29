package jiraiyah.globalbase.infrastructure.bases;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GenericItemGroup extends ItemGroup
{
    private Block block = null;
    private Item item = null;
    private String label;

    public GenericItemGroup(String label)
    {
        super(label);
        this.label = label;
    }

    public GenericItemGroup setIcon(Block block)
    {
        this.block = block;
        return this;
    }

    public GenericItemGroup setIcon(Item item)
    {
        this.item = item;
        return this;
    }

    @Override
    public ItemStack createIcon()
    {
        if(item != null)
            return new ItemStack(item);
        if (block != null)
            return new ItemStack(block);

        return null;
    }

    @Override
    public String getTabLabel()
    {
        return label;
    }
}