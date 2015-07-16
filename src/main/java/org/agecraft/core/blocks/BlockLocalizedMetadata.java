package org.agecraft.core.blocks;

import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

import org.agecraft.extendedmetadata.BlockMetadata;

public class BlockLocalizedMetadata extends BlockMetadata {

    public BlockLocalizedMetadata(Material material, int maxMetadata) {
        super(material, maxMetadata);
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
