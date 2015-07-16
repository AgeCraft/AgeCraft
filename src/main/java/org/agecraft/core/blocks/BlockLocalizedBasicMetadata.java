package org.agecraft.core.blocks;

import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

import org.agecraft.extendedmetadata.BlockBasicMetadata;

public class BlockLocalizedBasicMetadata extends BlockBasicMetadata {

    public BlockLocalizedBasicMetadata(Material material) {
        super(material);
    }

    @Override
    public String getLocalizedName() {
        return LanguageRegistry.instance().getStringLocalization(getUnlocalizedName());
    }

    @Override
    public String getLocalizedName(int meta) {
        return LanguageRegistry.instance().getStringLocalization(getUnlocalizedName(meta));
    }
}
