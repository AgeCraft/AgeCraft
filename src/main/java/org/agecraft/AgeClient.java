package org.agecraft;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract class AgeClient extends ACComponentClient {

	public AgeClient(Age age) {
		super(age);
	}
}
