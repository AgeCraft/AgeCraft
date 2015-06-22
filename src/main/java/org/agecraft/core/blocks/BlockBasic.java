package org.agecraft.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

public class BlockBasic extends Block {

    public BlockBasic(Material materialIn) {
        super(materialIn);
    }

    @Override
    public String getLocalizedName() {
        return LanguageRegistry.instance().getStringLocalization(getUnlocalizedName());
    }
}
