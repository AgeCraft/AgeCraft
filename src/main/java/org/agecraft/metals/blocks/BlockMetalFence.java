package org.agecraft.metals.blocks;

import java.text.MessageFormat;
import java.util.List;

import org.agecraft.metals.Metal;
import org.agecraft.metals.Metals;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

public class BlockMetalFence extends BlockMetalBlock {

    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");

    @Override
    public BlockState createBlockState() {
        return new BlockState(this, NORTH, EAST, SOUTH, WEST, Metals.property);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return Metals.registry.getID(state.getValue(Metals.property));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(Metals.property, Metals.registry.getName(meta));
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
        return state.withProperty(NORTH, canConnectTo(world, state, pos.north())).withProperty(EAST, canConnectTo(world, state, pos.east())).withProperty(SOUTH, canConnectTo(world, state, pos.south())).withProperty(WEST, canConnectTo(world, state, pos.west()));
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isPassable(IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess world, BlockPos pos, EnumFacing side) {
        return true;
    }

    public boolean canConnectTo(IBlockAccess world, IBlockState state, BlockPos pos) {
        IBlockState other = world.getBlockState(pos);
        Block block = other.getBlock();
        if (block instanceof BlockMetalFence) {
            return state.getValue(Metals.property).equals(other.getValue(Metals.property));
        }
        return block != Blocks.barrier && block.getMaterial().isOpaque() && block.isFullCube() ? block.getMaterial() != Material.gourd : false;
    }

    @Override
    public void addCollisionBoxesToList(World world, BlockPos pos, IBlockState state, AxisAlignedBB mask, List<AxisAlignedBB> list, Entity entity) {
        boolean connectMinX = canConnectTo(world, state, pos.west());
        boolean connectMaxX = canConnectTo(world, state, pos.east());
        boolean connectMinZ = canConnectTo(world, state, pos.north());
        boolean connectMaxZ = canConnectTo(world, state, pos.south());
        float minX = 0.375F;
        float maxX = 0.625F;
        float minZ = 0.375F;
        float maxZ = 0.625F;

        if (connectMinZ) {
            minZ = 0.0F;
        }
        if (connectMaxZ) {
            maxZ = 1.0F;
        }
        if (connectMinZ || connectMaxZ) {
            setBlockBounds(minX, 0.0F, minZ, maxX, 1.5F, maxZ);
            super.addCollisionBoxesToList(world, pos, state, mask, list, entity);
        }
        minZ = 0.375F;
        maxZ = 0.625F;
        if (connectMinX) {
            minX = 0.0F;
        }
        if (connectMaxX) {
            maxX = 1.0F;
        }
        if (connectMinX || connectMaxX || !connectMinZ && !connectMaxZ) {
            setBlockBounds(minX, 0.0F, minZ, maxX, 1.5F, maxZ);
            super.addCollisionBoxesToList(world, pos, state, mask, list, entity);
        }
        if (connectMinZ) {
            minZ = 0.0F;
        }
        if (connectMaxZ) {
            maxZ = 1.0F;
        }
        setBlockBounds(minX, 0.0F, minZ, maxX, 1.0F, maxZ);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        boolean connectMinZ = canConnectTo(world, state, pos.north());
        boolean connectMaxZ = canConnectTo(world, state, pos.south());
        boolean connectMinX = canConnectTo(world, state, pos.west());
        boolean connectMaxX = canConnectTo(world, state, pos.east());
        float minX = 0.375F;
        float maxX = 0.625F;
        float minZ = 0.375F;
        float maxZ = 0.625F;

        if (connectMinX) {
            minX = 0.0F;
        }
        if (connectMaxX) {
            maxX = 1.0F;
        }
        if (connectMinZ) {
            minZ = 0.0F;
        }
        if (connectMaxZ) {
            maxZ = 1.0F;
        }
        setBlockBounds(minX, 0.0F, minZ, maxX, 1.0F, maxZ);
    }

    @Override
    public String getLocalizedName(int meta) {
        return MessageFormat.format(getLocalizedName(), LanguageRegistry.instance().getStringLocalization(getUnlocalizedName(meta)));
    }

    @Override
    public String getUnlocalizedName() {
        return "agecraft.metals.blocks.fence";
    }
    
    @Override
    public String getUnlocalizedName(int meta) {
        return "agecraft.metals." + Metals.registry.getName(meta);
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
        for (Metal metal : Metals.registry) {
            if (metal != null && metal.hasDoor) {
                list.add(new ItemStack(item, 1, metal.id));
            }
        }
    }
}
