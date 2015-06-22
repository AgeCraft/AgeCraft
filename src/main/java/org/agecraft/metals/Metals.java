package org.agecraft.metals;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.agecraft.ACComponent;
import org.agecraft.ACComponentClient;
import org.agecraft.ItemBlockClass;
import org.agecraft.core.items.ItemBlockMetadata;
import org.agecraft.metals.blocks.BlockMetalBlock;
import org.agecraft.registry.PropertyRegistry;
import org.agecraft.registry.Registry;

public class Metals extends ACComponent {
	
	public static Registry<Metal> registry;
	public static PropertyRegistry property;
	
	public static Block ore;
	
	@ItemBlockClass(ItemBlockMetadata.class)
	public static Block block;
	
	public static Block blockPillar;
	public static Block fence;
	public static Block fenceGate;
	public static Block door;
	public static Block trapdoor;
	public static Block ladder;
	public static Block designBlock;
	public static Block fluid;

	public static Item ingot;
	public static Item gem;
	public static Item stick;
	public static Item nugget;
	public static Item dust;
	public static Item bucket;
	
	public Metals() {
		super("metals");
		registry = new Registry<Metal>("registry", 64);
	}

	@Override
	public void preInit() {
		// register metals
		registry.register(new Metal(0, "copper", OreType.METAL, 3.0F, 5.0F, 1, 5.0F, 10.0F, new ItemStack(ore, 1, 0), 1, 1, false, true, true, true, true, true, 0, 0, 0, 0xC9571C, 8, 15, 0, 96));
		registry.register(new Metal(1, "tin", OreType.METAL, 3.0F, 5.0F, 1, 5.0F, 10.0F, new ItemStack(ore, 1, 1), 1, 1, false, true, true, true, true, true, 0, 0, 0, 0xABABAB, 8, 10, 0, 96));
		registry.register(new Metal(2, "bronze", OreType.METAL, 3.0F, 5.0F, 1, 5.0F, 10.0F, new ItemStack(ore, 1, 2), 1, 1, false, false, true, true, true, true, 0, 0, 0, 0x764F37, 0, 0, 0, 0));
		registry.register(new Metal(3, "silver", OreType.METAL, 3.0F, 5.0F, 6, 5.0F, 10.0F, new ItemStack(ore, 1, 3), 1, 1, false, true, true, true, true, true, 0, 0, 0, 0xD7D7D7, 6, 5, 0, 64));
		registry.register(new Metal(4, "iron", OreType.METAL, 3.0F, 5.0F, 3, 5.0F, 10.0F, new ItemStack(ore, 1, 4), 1, 1, false, true, true, true, true, true, 0, 0, 0, 0xEFEFEF, 8, 15, 0, 64));
		registry.register(new Metal(5, "gold", OreType.METAL, 3.0F, 5.0F, 7, 5.0F, 10.0F, new ItemStack(ore, 1, 5), 1, 1, false, true, true, true, true, true, 0, 0, 0, 0xFDFD51, 6, 2, 0, 32));
		registry.register(new Metal(6, "zinc", OreType.METAL, 3.0F, 5.0F, 4, 5.0F, 10.0F, new ItemStack(ore, 1, 6), 1, 1, false, true, true, true, true, true, 0, 0, 0, 0xE0DACE, 12, 15, 0, 96));
		registry.register(new Metal(7, "nickel", OreType.METAL, 3.0F, 5.0F, 3, 5.0F, 10.0F, new ItemStack(ore, 1, 7), 1, 1, false, true, true, true, true, true, 0, 0, 0, 0x8E9F9F, 8, 5, 0, 64));
		registry.register(new Metal(8, "aluminium", OreType.METAL, 3.0F, 5.0F, 2, 5.0F, 10.0F, new ItemStack(ore, 1, 8), 1, 1, false, true, true, true, true, true, 0, 0, 0, 0xCECECE, 8, 5, 10, 64));
		registry.register(new Metal(9, "platinum", OreType.METAL, 3.0F, 5.0F, 5, 5.0F, 10.0F, new ItemStack(ore, 1, 9), 1, 1, false, true, true, true, true, true, 0, 0, 0, 0xC0C0C0, 4, 3, 0, 16));
		registry.register(new Metal(10, "lead", OreType.METAL, 3.0F, 5.0F, 5, 5.0F, 10.0F, new ItemStack(ore, 1, 10), 1, 1, false, true, true, true, true, true, 0, 0, 0, 0x454552, 6, 5, 0, 96));
		registry.register(new Metal(11, "steel", OreType.METAL, 3.0F, 5.0F, 6, 5.0F, 10.0F, new ItemStack(ore, 1, 11), 1, 1, false, false, true, true, true, true, 0, 0, 0, 0x7B7B7B, 0, 0, 0, 0));
		registry.register(new Metal(12, "cobalt", OreType.METAL, 3.0F, 5.0F, 7, 5.0F, 10.0F, new ItemStack(ore, 1, 12), 1, 1, false, true, true, true, true, true, 0, 0, 0, 0x30A0CD, 8, 4, 0, 52));
		registry.register(new Metal(13, "mithril", OreType.METAL, 3.0F, 5.0F, 8, 5.0F, 10.0F, new ItemStack(ore, 1, 13), 1, 1, false, true, true, true, true, true, 0, 0, 0, 0x004A8A, 6, 1, 0, 14));
		registry.register(new Metal(14, "adamantite", OreType.METAL, 3.0F, 5.0F, 9, 5.0F, 10.0F, new ItemStack(ore, 1, 14), 1, 1, false, true, true, true, true, true, 0, 0, 0, 0x4E8155, 4, 1, 0, 16));
		registry.register(new Metal(15, "tungsten", OreType.METAL, 3.0F, 5.0F, 10, 5.0F, 10.0F, new ItemStack(ore, 1, 15), 1, 1, false, true, true, true, true, true, 0, 0, 0, 0x444444, 4, 5, 0, 16));
		registry.register(new Metal(16, "uranium", OreType.METAL, 3.0F, 5.0F, 5, 5.0F, 10.0F, new ItemStack(ore, 1, 16), 1, 1, false, true, true, true, false, true, 0, 0, 0, 0x00B12C, 4, 6, 0, 96));

		// register gems
		registry.register(new Metal(32, "coal", OreType.GEM, 3.0F, 5.0F, 0, 5.0F, 10.0F, new ItemStack(gem, 1, 32), 1, 1, true, true, true, true, false, true, 0, 5, 5, 0x0D0D0D, 16, 15, 0, 128));
		registry.register(new Metal(33, "amethyst", OreType.GEM, 3.0F, 5.0F, 9, 5.0F, 10.0F, new ItemStack(gem, 1, 33), 1, 1, true, true, true, true, false, true, 0, 0, 0, 0xA575C7, 8, 2, 0, 26));
		registry.register(new Metal(34, "berylRed", OreType.GEM, 3.0F, 5.0F, 4, 5.0F, 10.0F, new ItemStack(gem, 1, 34), 1, 1, true, true, true, true, false, true, 0, 0, 0, 0xF76B6B, 5, 1, 0, 16));
		registry.register(new Metal(35, "berylYellow", OreType.GEM, 3.0F, 5.0F, 4, 5.0F, 10.0F, new ItemStack(gem, 1, 35), 1, 1, true, true, true, true, false, true, 0, 0, 0, 0xFDD24E, 6, 2, 10, 64));
		registry.register(new Metal(36, "berylBlue", OreType.GEM, 3.0F, 5.0F, 4, 5.0F, 10.0F, new ItemStack(gem, 1, 36), 1, 1, true, true, true, true, false, true, 0, 0, 0, 0x6A8BFD, 6, 2, 10, 32));
		registry.register(new Metal(37, "berylGreen", OreType.GEM, 3.0F, 5.0F, 4, 5.0F, 10.0F, new ItemStack(gem, 1, 37), 1, 1, true, true, true, true, false, true, 0, 0, 0, 0x54E36A, 6, 1, 0, 16));
		registry.register(new Metal(38, "diamond", OreType.GEM, 3.0F, 5.0F, 10, 5.0F, 10.0F, new ItemStack(gem, 1, 38), 1, 1, true, true, true, true, false, true, 0, 0, 0, 0x87E5E1, 8, 1, 0, 16));
		registry.register(new Metal(39, "emerald", OreType.GEM, 3.0F, 5.0F, 9, 5.0F, 10.0F, new ItemStack(gem, 1, 39), 1, 1, true, true, true, true, false, true, 0, 0, 0, 0x48E073, 6, 1, 0, 16));
		registry.register(new Metal(40, "jade", OreType.GEM, 3.0F, 5.0F, 8, 5.0F, 10.0F, new ItemStack(gem, 1, 40), 1, 1, true, true, true, true, false, true, 0, 0, 0, 0x07E1AA, 6, 1, 0, 16));
		registry.register(new Metal(41, "lapisLazuli", OreType.GEM, 3.0F, 5.0F, 7, 5.0F, 10.0F, new ItemStack(gem, 1, 41), 4, 8, true, true, true, true, false, true, 0, 0, 0, 0x1542CC, 6, 2, 0, 28));
		registry.register(new Metal(42, "onyx", OreType.GEM, 3.0F, 5.0F, 10, 5.0F, 10.0F, new ItemStack(gem, 1, 42), 1, 1, true, true, true, true, false, true, 0, 0, 0, 0x2D2D2D, 10, 3, 0, 16));
		registry.register(new Metal(43, "opal", OreType.GEM, 3.0F, 5.0F, 4, 5.0F, 10.0F, new ItemStack(gem, 1, 43), 1, 1, true, true, true, true, false, true, 0, 0, 0, 0x7E90ED, 8, 2, 0, 32));
		registry.register(new Metal(44, "quartz", OreType.GEM, 3.0F, 5.0F, 10, 5.0F, 10.0F, new ItemStack(gem, 1, 44), 1, 1, true, true, true, true, false, true, 0, 0, 0, 0xF0EEE8, 8, 3, 0, 32));
		registry.register(new Metal(45, "ruby", OreType.GEM, 3.0F, 5.0F, 6, 5.0F, 10.0F, new ItemStack(gem, 1, 45), 1, 1, true, true, true, true, false, true, 0, 0, 0, 0xD8484, 6, 1, 0, 16));
		registry.register(new Metal(46, "sapphire", OreType.GEM, 3.0F, 5.0F, 6, 5.0F, 10.0F, new ItemStack(gem, 1, 46), 1, 1, true, true, true, true, false, true, 0, 0, 0, 0x4860BC, 6, 1, 0, 16));
		registry.register(new Metal(47, "tigerEye", OreType.GEM, 3.0F, 5.0F, 8, 5.0F, 10.0F, new ItemStack(gem, 1, 47), 1, 1, true, true, true, true, false, true, 0, 0, 0, 0x892604, 8, 3, 20, 96));
		registry.register(new Metal(48, "topaz", OreType.GEM, 3.0F, 5.0F, 6, 5.0F, 10.0F, new ItemStack(gem, 1, 48), 1, 1, true, true, true, true, false, true, 0, 0, 0, 0xD8CF48, 8, 2, 40, 128));
		registry.register(new Metal(49, "turquoise", OreType.GEM, 3.0F, 5.0F, 4, 5.0F, 10.0F, new ItemStack(gem, 1, 49), 1, 1, true, true, true, true, false, true, 0, 0, 0, 0x6AD6CE, 8, 1, 0, 32));
		registry.register(new Metal(50, "redstone", OreType.GEM, 3.0F, 5.0F, 5, 5.0F, 10.0F, new ItemStack(dust, 1, 50), 4, 5, true, true, false, true, false, true, 15, 0, 0, 0xE3260C, 8, 8, 0, 26));
		registry.register(new Metal(51, "salt", OreType.GEM, 3.0F, 5.0F, 0, 5.0F, 10.0F, new ItemStack(dust, 1, 51), 1, 1, true, true, false, false, false, true, 0, 0, 0, 0xD8D2D4, 12, 12, 20, 128));
		registry.register(new Metal(52, "sulphur", OreType.GEM, 3.0F, 5.0F, 6, 5.0F, 10.0F, new ItemStack(dust, 1, 52), 1, 1, true, true, false, false, false, true, 0, 0, 0, 0xF4D41F, 12, 12, 20, 128));
		registry.register(new Metal(53, "charcoal", OreType.GEM, 3.0F, 5.0F, 0, 5.0F, 10.0F, new ItemStack(gem, 1, 53), 1, 1, true, false, true, true, false, true, 0, 5, 5, 0x0D0D0D, 16, 15, 0, 128));
		
		// initialize properties
		property = new PropertyRegistry<Metal>("metalType", registry);
		
		// initialize blocks
		block = new BlockMetalBlock();
	}

	@Override
	public void init() {
		
	}

	@Override
	public void postInit() {
		
	}
	
	@Override
	public Object getGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public ACComponentClient getComponentClient() {
		return null;
	}
}
