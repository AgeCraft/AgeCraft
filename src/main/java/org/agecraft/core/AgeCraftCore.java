package org.agecraft.core;

import org.agecraft.ACComponent;
import org.agecraft.ACComponentClient;

public class AgeCraftCore extends ACComponent {
	
	public AgeCraftCore() {
		super("core");
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
		return ACComponentClient.core;
	}
}
