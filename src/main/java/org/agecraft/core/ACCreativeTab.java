package org.agecraft.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

public class ACCreativeTab extends CreativeTabs {

    public ItemStack stack;

    public ACCreativeTab(int index, String label, ItemStack stack) {
        super(index, label);
        this.stack = stack;
    }

    @Override
    public String getTranslatedTabLabel() {
        return LanguageRegistry.instance().getStringLocalization("agecraft.creativetab." + getTabLabel());
    }

    @Override
    public Item getTabIconItem() {
        return stack.getItem();
    }

    @Override
    public ItemStack getIconItemStack() {
        return stack;
    }
}
