package org.agecraft.prehistory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
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
	
	@Override
	public Object getGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
}
