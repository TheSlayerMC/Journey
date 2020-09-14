package net.journey.dimension.corba.gen;

import net.journey.api.block.GroundPredicate;
import net.journey.blocks.containers.BlockJourneyChest;
import net.journey.init.blocks.JourneyBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

import java.util.Random;

public class WorldGenCorbaTotems extends WorldGenerator {

	public GroundPredicate acceptableSurface = GroundPredicate.GRASS_BLOCK;

	private int size;

	@Override
	public boolean generate(World world, Random random, BlockPos blockPos) {
		BlockPos.MutableBlockPos placePos = new BlockPos.MutableBlockPos(WorldGenAPI.findPosAboveSurface(world, WorldGenAPI.optimizeAndRandomize(blockPos, random))).move(EnumFacing.DOWN);

		if (world.getBlockState(placePos.up()) == Blocks.AIR.getDefaultState()) {
			int height = 3;
			for (int i = 0; i < height; i++) {

				size = 3;
				setBlockAndNotifyAdequately(world, placePos.add(size, i, size), JourneyBlocks.totemBase.getDefaultState());
				setBlockAndNotifyAdequately(world, placePos.add(-size, i, -size), JourneyBlocks.totemBase.getDefaultState());
				setBlockAndNotifyAdequately(world, placePos.add(size, i, -size), JourneyBlocks.totemBase.getDefaultState());
				setBlockAndNotifyAdequately(world, placePos.add(-size, i, size), JourneyBlocks.totemBase.getDefaultState());

				size = 4;
				setBlockAndNotifyAdequately(world, placePos.add(size, i, 0), JourneyBlocks.totemBase.getDefaultState());
				setBlockAndNotifyAdequately(world, placePos.add(-size, i, 0), JourneyBlocks.totemBase.getDefaultState());
				setBlockAndNotifyAdequately(world, placePos.add(0, i, -size), JourneyBlocks.totemBase.getDefaultState());
				setBlockAndNotifyAdequately(world, placePos.add(0, i, size), JourneyBlocks.totemBase.getDefaultState());

				setBlockAndNotifyAdequately(world, placePos.add(size, i + 1, 0), JourneyBlocks.totemScared.getDefaultState().withProperty(BlockJourneyChest.FACING, EnumFacing.WEST));
				setBlockAndNotifyAdequately(world, placePos.add(-size, i + 1, 0), JourneyBlocks.totemAngry.getDefaultState().withProperty(BlockJourneyChest.FACING, EnumFacing.EAST));
				setBlockAndNotifyAdequately(world, placePos.add(0, i + 1, -size), JourneyBlocks.totemSad.getDefaultState().withProperty(BlockJourneyChest.FACING, EnumFacing.SOUTH));
				setBlockAndNotifyAdequately(world, placePos.add(0, i + 1, size), JourneyBlocks.totemHappy.getDefaultState().withProperty(BlockJourneyChest.FACING, EnumFacing.NORTH));

				setBlockAndNotifyAdequately(world, placePos.add(0, 2, 0), JourneyBlocks.driedMud.getDefaultState());
			}
		}
		return true;
	}
}