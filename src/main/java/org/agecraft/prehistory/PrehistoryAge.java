package org.agecraft.prehistory;

import org.agecraft.ACComponentClient;
import org.agecraft.Age;
import org.agecraft.AgeClient;

public class PrehistoryAge extends Age {
	
	public PrehistoryAge(int id) {
		super(id, "prehistory");
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
	public ACComponentClient getComponentClient() {
		return AgeClient.prehistory;
	}
}
