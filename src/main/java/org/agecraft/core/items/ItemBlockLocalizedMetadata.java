package org.agecraft.core.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

import org.agecraft.extendedmetadata.ItemBlockMetadata;

public class ItemBlockLocalizedMetadata extends ItemBlockMetadata {

	public ItemBlockLocalizedMetadata(Block block) {
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
