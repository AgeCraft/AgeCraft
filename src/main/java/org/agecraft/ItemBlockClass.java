package org.agecraft;

import net.minecraft.item.ItemBlock;

public @interface ItemBlockClass {

	public Class<? extends ItemBlock> value();
}
