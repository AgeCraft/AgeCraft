package org.agecraft;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import org.agecraft.core.ACCreativeTab;

public class ACCreativeTabs {

	//TODO: replace vanilla blocks/items with AgeCraft ones
	
	public static ACCreativeTab ageCraft = new ACCreativeTab(12, "agecraft", new ItemStack(Blocks.bookshelf));
	
	public static ACCreativeTab stone = new ACCreativeTab(13, "stone", new ItemStack(Blocks.stone));
	public static ACCreativeTab building = new ACCreativeTab(14, "building", new ItemStack(Blocks.grass));
	public static ACCreativeTab metals = new ACCreativeTab(15, "metals", new ItemStack(Blocks.iron_block));
	public static ACCreativeTab wood = new ACCreativeTab(16, "wood", new ItemStack(Blocks.planks));
	public static ACCreativeTab tools = new ACCreativeTab(17, "tools", new ItemStack(Items.iron_pickaxe));
	public static ACCreativeTab armor = new ACCreativeTab(18, "armor", new ItemStack(Items.iron_chestplate));
	public static ACCreativeTab crafting = new ACCreativeTab(19, "crafting", new ItemStack(Blocks.crafting_table));
	public static ACCreativeTab food = new ACCreativeTab(20, "food", new ItemStack(Items.bread));
	public static ACCreativeTab farming = new ACCreativeTab(21, "farming", new ItemStack(Items.wheat_seeds));
	
	public static ACCreativeTab prehistoryAge = new ACCreativeTab(22, "prehistory", new ItemStack(Blocks.dirt));
	public static ACCreativeTab agricultureAge = new ACCreativeTab(23, "agriculture", new ItemStack(Items.wheat));
	public static ACCreativeTab ancientEgyptAge;
	public static ACCreativeTab ancientChinaAge;
	public static ACCreativeTab romanGreekAge;
	public static ACCreativeTab mediavalAge;
	public static ACCreativeTab earlyModernAge;
	public static ACCreativeTab industrialAge;
	public static ACCreativeTab modernAge;
	public static ACCreativeTab futureAge;
}
