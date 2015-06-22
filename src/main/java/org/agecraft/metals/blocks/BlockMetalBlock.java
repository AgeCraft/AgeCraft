package org.agecraft.metals.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.agecraft.ACCreativeTabs;
import org.agecraft.core.blocks.BlockMetadata;
import org.agecraft.metals.Metal;
import org.agecraft.metals.Metals;

import com.ibm.icu.text.MessageFormat;

public class BlockMetalBlock extends BlockMetadata {
	
	public BlockMetalBlock() {
		super(Material.iron, Metals.registry.size());
		setStepSound(Block.soundTypeMetal);
		setCreativeTab(ACCreativeTabs.metals);
	}
	
	@Override
	public BlockState createBlockState() {
		return new BlockState(this, Metals.property);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return Metals.registry.getID((String) state.getValue(Metals.property));
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(Metals.property, Metals.registry.getName(meta));
	}
	
	@Override
	public String getLocalizedName(int meta) {
		return MessageFormat.format(getLocalizedName(), super.getLocalizedName(meta));
	}
	
	@Override
	public String getUnlocalizedName() {
		return "agecraft.metals.blocks.block";
	}
	
	@Override
	public String getUnlocalizedName(int meta) {
		return "agecraft.metals." + Metals.registry.getName(meta);
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for(Metal metal : Metals.registry) {
			if(metal != null) {
				list.add(new ItemStack(item, 1, metal.id));
			}
		}
	}
}
