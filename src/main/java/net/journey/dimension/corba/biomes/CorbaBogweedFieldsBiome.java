package net.journey.dimension.corba.biomes;

import net.journey.dimension.base.biome.EnumBiomeColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CorbaBogweedFieldsBiome extends CorbaSwampBiome {

	public CorbaBogweedFieldsBiome(BiomeProperties properties, IBlockState topBlock, IBlockState fillerBlock) {
		super(properties, topBlock, fillerBlock);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getGrassColorAtPos(BlockPos pos) {
		double d0 = GRASS_COLOR_NOISE.getValue((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D);
		return this.getModdedBiomeGrassColor(d0 < -0.1D ? EnumBiomeColor.CORBA_SWAMP.getInt() : EnumBiomeColor.CORBA_SWAMP_2.getInt());
	}
}
