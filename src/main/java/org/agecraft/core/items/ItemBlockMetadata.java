package org.agecraft.core.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import org.agecraft.core.blocks.BlockMetadata;

public class ItemBlockMetadata extends ItemBlockBasic {

	private BlockMetadata block;
	
	public ItemBlockMetadata(Block block) {
		super(block);
		this.block = (BlockMetadata) block;
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	@Override
	public BlockMetadata getBlock() {
		return block;
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		return block.getLocalizedName(stack.getItemDamage());
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return block.getUnlocalizedName(stack.getItemDamage());
	}
}
