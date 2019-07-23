package jiraiyah.gb.infrastructure.bases;

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

    public void setIcon(Block block)
    {
        this.block = block;
    }

    public void setIcon(Item item)
    {
        this.item = item;
    }

    @Override
    public ItemStack createIcon()
    {
        if(item != null)
            return new ItemStack(item);
        if (block != null)
            return new ItemStack(block);

        return super.getIcon();
    }

    @Override
    public String getTabLabel()
    {
        return label;
    }
}