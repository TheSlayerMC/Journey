package net.journey.blocks;

import java.util.List;
import java.util.Random;

import net.journey.JourneyItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.block.BlockMod;

public class BlockAncientBlock extends BlockMod {

	
	public BlockAncientBlock(String name, String f) {
		super(EnumMaterialTypes.STONE, name, f, 0.4F);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return null;
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> drops = super.getDrops(world, pos, state, fortune);
		Item gem = JourneyItems.ancientPiece_1;
		switch(rand.nextInt(4)) {
		case 0:
			gem = JourneyItems.ancientPiece_1;
			break;
		case 1:
			gem = JourneyItems.ancientPiece_2;
			break;
		case 2:
			gem = JourneyItems.ancientPiece_3;
			break;
		case 3:
			gem = JourneyItems.ancientPiece_4;
			break;
		}
		if(rand.nextInt(8) == 0) {
			gem = JourneyItems.untitled_disk;
		}
		drops.add(new ItemStack(gem, rand.nextInt(1) + 1));
		return drops;
	}
}