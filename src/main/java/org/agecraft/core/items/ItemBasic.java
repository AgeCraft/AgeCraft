package org.agecraft.core.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

public class ItemBasic extends Item {

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return LanguageRegistry.instance().getStringLocalization(getUnlocalizedName(stack));
    }

    @Override
    public String getUnlocalizedNameInefficiently(ItemStack stack) {
        return getUnlocalizedName(stack);
    }
}
