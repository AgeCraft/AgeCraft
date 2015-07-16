package org.agecraft.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

public class BlockLocalized extends Block {

    public BlockLocalized(Material materialIn) {
        super(materialIn);
    }

    @Override
    public String getLocalizedName() {
        return LanguageRegistry.instance().getStringLocalization(getUnlocalizedName());
    }
}
