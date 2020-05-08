package net.journey.dimension.depths;

import javax.annotation.Nullable;

import net.journey.dimension.base.BaseWorldProvider;
import net.journey.dimension.base.DimensionHelper;
import net.journey.init.JourneySounds;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.EnumHelperClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderDepths extends BaseWorldProvider {

    public WorldProviderDepths() {
        super(new BiomeProviderSingle(DimensionHelper.depths));
    }

    @Override
    public void init() {
        nether = false;
        this.hasSkyLight = true;
    }
    
    @Nullable
    @SideOnly(Side.CLIENT)
    @Override
    public MusicTicker.MusicType getMusicType() {
        return EnumHelperClient.addMusicType("null", JourneySounds.EMPTY, 0, 1);
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
        return new ChunkProviderDepths(this.world, this.world.getSeed(), world.getWorldInfo().getGeneratorOptions());
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