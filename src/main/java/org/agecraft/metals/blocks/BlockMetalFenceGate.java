package org.agecraft.metals.blocks;

import java.util.List;

import org.agecraft.core.blocks.BlockUpdate;
import org.agecraft.core.blocks.IBlockDirectional;
import org.agecraft.metals.Metal;
import org.agecraft.metals.Metals;

import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMetalFenceGate extends BlockMetalFence implements IBlockDirectional {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static final PropertyBool OPEN = PropertyBool.create("open");
    public static final PropertyBool POWERED = PropertyBool.create("powered");

    @Override
    public BlockState createBlockState() {
        return new BlockState(this, FACING, OPEN, POWERED, Metals.property);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return Metals.registry.getID(state.getValue(Metals.property)) << 4 | (state.getValue(POWERED) ? 8 : 0) | (state.getValue(OPEN) ? 4 : 0) | state.getValue(FACING).getHorizontalIndex();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(Metals.property, Metals.registry.getName(meta >> 4)).withProperty(POWERED, (meta & 8) != 0).withProperty(OPEN, (meta & 4) != 0).withProperty(FACING, EnumFacing.getHorizontal(meta & 3));
    }
    
    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
        return state;
    }

    @Override
    public EnumFacing getDirection(IBlockAccess world, BlockPos pos, IBlockState state) {
        return state.getValue(FACING);
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        return world.getBlockState(pos.down()).getBlock().getMaterial().isSolid() ? super.canPlaceBlockAt(world, pos) : false;
    }
    
    @Override
    public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return getStateFromMeta(meta).withProperty(FACING, placer.getHorizontalFacing()).withProperty(OPEN, false).withProperty(POWERED, false);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (state.getValue(OPEN)) {
            state = state.withProperty(OPEN, false);
            world.setBlockState(pos, state, BlockUpdate.DEFAULT);
        } else {
            EnumFacing facing = EnumFacing.fromAngle(player.rotationYaw);
            if (state.getValue(FACING) == facing.getOpposite()) {
                state = state.withProperty(FACING, facing);
            }
            state = state.withProperty(OPEN, true);
            world.setBlockState(pos, state, BlockUpdate.DEFAULT);
        }
        world.playAuxSFXAtEntity(player, state.getValue(OPEN) ? 1003 : 1006, pos, 0);
        return true;
    }

    @Override
    public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block neighborBlock) {
        if (!world.isRemote) {
            boolean powered = world.isBlockPowered(pos);

            if (powered || neighborBlock.canProvidePower()) {
                if (powered && !state.getValue(OPEN) && !state.getValue(POWERED)) {
                    state = state.withProperty(OPEN, true).withProperty(POWERED, true);
                    world.setBlockState(pos, state, BlockUpdate.DEFAULT);
                    world.playAuxSFXAtEntity(null, 1003, pos, 0);
                } else if (!powered && state.getValue(OPEN) && state.getValue(POWERED)) {
                    state = state.withProperty(OPEN, false).withProperty(POWERED, false);
                    world.setBlockState(pos, state, BlockUpdate.DEFAULT);
                    world.playAuxSFXAtEntity(null, 1006, pos, 0);
                } else if (powered != state.getValue(POWERED).booleanValue()) {
                    state = state.withProperty(POWERED, powered);
                    world.setBlockState(pos, state, BlockUpdate.DEFAULT);
                }
            }
        }
    }

    @Override
    public boolean isPassable(IBlockAccess world, BlockPos pos) {
        return world.getBlockState(pos).getValue(OPEN);
    }

    @Override
    public void addCollisionBoxesToList(World world, BlockPos pos, IBlockState state, AxisAlignedBB mask, List<AxisAlignedBB> list, Entity entity) {
        AxisAlignedBB box = getCollisionBoundingBox(world, pos, state);
        if (box != null && mask.intersectsWith(box)) {
            list.add(box);
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
        if (state.getValue(OPEN)) {
            return null;
        } else {
            EnumFacing.Axis axis = state.getValue(FACING).getAxis();
            if (axis == EnumFacing.Axis.Z) {
                return new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ() + 0.375D, pos.getX() + 1, pos.getY() + 1.5D, pos.getZ() + 0.625D);
            } else {
                return new AxisAlignedBB(pos.getX() + 0.375D, pos.getY(), pos.getZ(), pos.getX() + 0.625F, pos.getY() + 1.5F, pos.getZ() + 1);
            }
        }
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, BlockPos pos) {
        EnumFacing.Axis axis = world.getBlockState(pos).getValue(FACING).getAxis();
        if (axis == EnumFacing.Axis.Z) {
            setBlockBounds(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
        } else {
            setBlockBounds(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
        }
    }

    @Override
    public String getUnlocalizedName() {
        return "agecraft.metals.blocks.fenceGate";
    }
    
    @Override
    public String getUnlocalizedName(int meta) {
        return "agecraft.metals." + Metals.registry.getName(meta >> 4);
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
        for (Metal metal : Metals.registry) {
            if (metal != null && metal.hasDoor) {
                list.add(new ItemStack(item, 1, metal.id << 4));
            }
        }
    }
}
