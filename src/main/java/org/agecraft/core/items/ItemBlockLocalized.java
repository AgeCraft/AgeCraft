package org.agecraft.core.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

public class ItemBlockLocalized extends ItemBlock {

    public ItemBlockLocalized(Block block) {
        super(block);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return LanguageRegistry.instance().getStringLocalization(getUnlocalizedNameInefficiently(stack));
    }

    @Override
    public String getUnlocalizedNameInefficiently(ItemStack stack) {
        return getUnlocalizedName(stack);
    }
}
