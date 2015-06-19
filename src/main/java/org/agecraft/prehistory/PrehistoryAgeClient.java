package org.agecraft.prehistory;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.agecraft.Age;
import org.agecraft.AgeClient;

@SideOnly(Side.CLIENT)
public class PrehistoryAgeClient extends AgeClient {

	public static PrehistoryAgeClient instance;
	
	public PrehistoryAgeClient(Age age) {
		super(age);
		instance = this;
	}

	@Override
	public void preInit() {
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public void postInit() {
		
	}
}
