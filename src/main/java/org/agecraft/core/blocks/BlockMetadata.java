package org.agecraft.core.blocks;

import java.util.Arrays;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

public class BlockMetadata extends BlockBasic {

    private String[] harvestTool;
    private int[] harvestLevel;

    public BlockMetadata(Material material, int maxMetadata) {
        super(material);
        this.harvestTool = new String[maxMetadata];
        this.harvestLevel = new int[maxMetadata];
        Arrays.fill(harvestLevel, -1);
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    public String getLocalizedName(int meta) {
        return LanguageRegistry.instance().getStringLocalization(getUnlocalizedName(meta));
    }

    public String getUnlocalizedName(int meta) {
        return getUnlocalizedName();
    }

    @Override
    public String getHarvestTool(IBlockState state) {
        return harvestTool[getMetaFromState(state)];
    }

    @Override
    public int getHarvestLevel(IBlockState state) {
        return harvestLevel[getMetaFromState(state)];
    }

    @Override
    public void setHarvestLevel(String toolClass, int level, IBlockState state) {
        int meta = getMetaFromState(state);
        this.harvestTool[meta] = toolClass;
        this.harvestLevel[meta] = level;
    }
}
