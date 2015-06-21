package org.agecraft.core;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import org.agecraft.ACComponent;
import org.agecraft.ACComponentClient;

public class Metals extends ACComponent {

	//@ItemBlockClass(ItemBlockMetadata.class)
	public static Block ore;
	
	public static Item ingot;
	
	public Metals() {
		super("metals");
	}

	@Override
	public void preInit() {
		// ore = new BlockOre();
	}

	@Override
	public void init() {
		
	}

	@Override
	public void postInit() {
		
	}

	@Override
	public ACComponentClient getComponentClient() {
		return null;
	}
}
