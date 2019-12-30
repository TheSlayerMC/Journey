package net.journey.dimension.depths;

import net.journey.dimension.DimensionHelper;
import net.journey.dimension.base.BaseWorldProvider;
import net.journey.dimension.cloudia.BiomeProviderCloudia;
import net.journey.util.Config;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldProviderDepths extends BaseWorldProvider {

    public WorldProviderDepths() {
        super(new BiomeProviderSingle(DimensionHelper.depths));
    }

    @Override
	public void init() {
        nether = false;
        this.hasSkyLight = true;
    }
    
    @Override
    public String getSaveFolder() {
    	return "Depths";
    }

    @Override
    public float getCloudHeight() {
        return 128.0F;
    }
    
    @Override
    public int getHeight() {
        return 128;
    }

    @Override
    public int getActualHeight() {
        return 128;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkProviderDepths(this.world, this.world.getSeed());
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public float calculateCelestialAngle(long var1, float var3) {
        return 0.3F; 
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

	@Override
	public DimensionType getDimensionType() {
		return DimensionHelper.depthsType;
		
	}
}