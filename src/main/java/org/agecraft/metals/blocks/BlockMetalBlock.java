package org.agecraft.metals.blocks;

import java.util.List;

import org.agecraft.ACCreativeTabs;
import org.agecraft.core.blocks.BlockLocalizedMetadata;
import org.agecraft.metals.Metal;
import org.agecraft.metals.Metals;

import com.ibm.icu.text.MessageFormat;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

public class BlockMetalBlock extends BlockLocalizedMetadata {

    public static enum EnumMetalBlockType implements IStringSerializable {
        NORMAL, BRICKS, SMALL_BRICKS, CIRCLE;

        @Override
        public String getName() {
            return toString().toLowerCase();
        }
    }

    public static PropertyEnum<EnumMetalBlockType> type = PropertyEnum.create("type", EnumMetalBlockType.class, EnumMetalBlockType.values());

    public BlockMetalBlock() {
        super(Material.iron, Metals.registry.size());
        setStepSound(Block.soundTypeMetal);
        setCreativeTab(ACCreativeTabs.metals);
    }

    @Override
    public BlockState createBlockState() {
        return new BlockState(this, type, Metals.property);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return Metals.registry.getID((String) state.getValue(Metals.property)) << 2 | ((EnumMetalBlockType) state.getValue(type)).ordinal();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(Metals.property, Metals.registry.getName((meta >> 2) & 63)).withProperty(type, EnumMetalBlockType.values()[meta & 3]);
    }

    @Override
    public String getLocalizedName(int meta) {
        return MessageFormat.format(LanguageRegistry.instance().getStringLocalization(getUnlocalizedName() + "." + EnumMetalBlockType.values()[meta & 3].getName()), super.getLocalizedName(meta));
    }

    @Override
    public String getUnlocalizedName() {
        return "agecraft.metals.blocks.block";
    }

    @Override
    public String getUnlocalizedName(int meta) {
        return "agecraft.metals." + Metals.registry.getName((meta >> 2) & 63);
    }

    @Override
    public boolean canProvidePower() {
        return false;
    }
    
//    @Override
//    public boolean isNormalCube() {
//        return getMaterial().isOpaque() && isFullCube();
//    }
//
//    @Override
//    public boolean isNormalCube(IBlockAccess blockAccess, BlockPos pos) {
//        return getMaterial().isOpaque() && isFullCube() && Metals.registry.get(blockAccess.getBlockState(pos).getValue(Metals.property)).redstonePower == 0;
//    }
//    
//    @Override
//    public boolean isSideSolid(IBlockAccess world, BlockPos pos, EnumFacing side) {
//        return true;
//    }
//    
//    @Override
//    public boolean shouldCheckWeakPower(IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
//        return Metals.registry.get(blockAccess.getBlockState(pos).getValue(Metals.property)).redstonePower != 0;
//    }

//    @Override
//    public int isProvidingWeakPower(IBlockAccess blockAccess, BlockPos pos, IBlockState state, EnumFacing side) {
//        return Metals.registry.get(state.getValue(Metals.property)).redstonePower;
//    }

    @Override
    public int getFireSpreadSpeed(IBlockAccess blockAccess, BlockPos pos, EnumFacing face) {
        return Metals.registry.get(blockAccess.getBlockState(pos).getValue(Metals.property)).fireSpreadSpeed;
    }

    @Override
    public int getFlammability(IBlockAccess blockAccess, BlockPos pos, EnumFacing face) {
        return Metals.registry.get(blockAccess.getBlockState(pos).getValue(Metals.property)).flammability;
    }

    @Override
    public float getBlockHardness(World world, BlockPos pos) {
        return Metals.registry.get(world.getBlockState(pos).getValue(Metals.property)).blockHardness;
    }

    @Override
    public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
        return Metals.registry.get(world.getBlockState(pos).getValue(Metals.property)).blockResistance / 5.0F;
    }

    @Override
    public String getHarvestTool(IBlockState state) {
        return "pickaxe";
    }

    @Override
    public int getHarvestLevel(IBlockState state) {
        return Metals.registry.get(state.getValue(Metals.property)).harvestLevel;
    }

	@Override
    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
        for (Metal metal : Metals.registry) {
            if (metal != null && metal.hasBlock) {
                for (int j = 0; j < 4; j++) {
                    list.add(new ItemStack(item, 1, metal.id << 2 | j));
                }
            }
        }
    }
}
