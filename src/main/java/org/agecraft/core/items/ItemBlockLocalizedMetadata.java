package org.agecraft.core.items;

import org.agecraft.extendedmetadata.ItemBlockMetadata;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemBlockLocalizedMetadata extends ItemBlockMetadata {

    public ItemBlockLocalizedMetadata(Block block) {
        super(block);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return getBlock().getLocalizedName(stack.getItemDamage());
    }

    @Override
    public String getUnlocalizedNameInefficiently(ItemStack stack) {
        return getUnlocalizedName(stack);
    }
}
