package org.agecraft.core.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

public interface IBlockDirectional {

    EnumFacing getDirection(IBlockAccess world, BlockPos pos, IBlockState state);
}
