package net.journey.dimension.senterian;

import net.journey.api.world.gen.TECompatibleChunkPrimer;
import net.journey.dimension.senterian.room.*;
import net.journey.dimension.senterian.room.altar.SenterianAltarRoom1;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;

import java.util.*;

public class ChunkProviderSenterian implements IChunkGenerator {

	private ArrayList<SenterianRoomBase> rooms;
	private ArrayList<SenterianRoomBase> bigRooms;
	private SenterianCeiling ceiling;
	private SenterianRoomStairs stairs;
	private SenterianRoomBase[] hallways;
	private World worldObj;
	private Random random;
	private Map<ChunkPos, Map<BlockPos, TECompatibleChunkPrimer.PrimerData>> chunkTileEntityMap;
	private Biome[] biomesForGeneration;

	public ChunkProviderSenterian(World world, long seed) {

		worldObj = world;
		random = new Random(seed);

		bigRooms = new ArrayList<>(2);
		bigRooms.add(new SenterianRoomChest());
		bigRooms.add(new SenterianAltarRoom1());
		bigRooms.add(new SenterianRoomLockedChests());

		rooms = new ArrayList<>(4);
		rooms.add(new SenterianRoomHall1());
		rooms.add(new SenterianRoomNPC());
		rooms.add(new SenterianRoomSpawner1());

		hallways = new SenterianRoomBase[]{new SenterianRoomHall2(), new SenterianRoomHall3(), new SenterianRoomMaze1(), new SenterianRoomMaze2(), new SenterianRoomSpawner2(world)};

		stairs = new SenterianRoomStairs();
		ceiling = new SenterianCeiling();
		this.chunkTileEntityMap = new HashMap<>();
	}

	@Override
	public Chunk generateChunk(int chunkX, int chunkZ) {
		TECompatibleChunkPrimer senterianChunk = new TECompatibleChunkPrimer();
		this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomes(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);

		int bottomLayer = 0;
		int secondLayer = 5;
		int thirdLayer = 10;
		int topLayer = 15;

		//Generates all rooms
		SenterianRoomBase room = (rooms.get(random.nextInt(rooms.size())));
		room.generate(senterianChunk, random, 0, topLayer, 0);

		room = (rooms.get(random.nextInt(rooms.size())));
		room.generate(senterianChunk, random, 0, thirdLayer, 0);

		room = (rooms.get(random.nextInt(rooms.size())));
		room.generate(senterianChunk, random, 0, secondLayer, 0);

		room = (rooms.get(random.nextInt(rooms.size())));
		room.generate(senterianChunk, random, 0, bottomLayer, 0);

		//Chance to generate stair room on all but top layer
		int stairRarity = 20;
		if (random.nextInt(stairRarity) == 0)
			stairs.generate(senterianChunk, random, 0, bottomLayer, 0);

		if (random.nextInt(stairRarity) == 0)
			stairs.generate(senterianChunk, random, 0, secondLayer, 0);

		if (random.nextInt(stairRarity) == 0)
			stairs.generate(senterianChunk, random, 0, thirdLayer, 0);

		//These double as a hallway and a blocker on the exit of the room next to it
		int hallwayRarity = 8;
		if (random.nextInt(hallwayRarity) == 0)
			hallways[random.nextInt(hallways.length)].generate(senterianChunk, random, 0, bottomLayer, 0);

		if (random.nextInt(hallwayRarity) == 0)
			hallways[random.nextInt(hallways.length)].generate(senterianChunk, random, 0, secondLayer, 0);

		if (random.nextInt(hallwayRarity) == 0)
			hallways[random.nextInt(hallways.length)].generate(senterianChunk, random, 0, thirdLayer, 0);

		if (random.nextInt(hallwayRarity) == 0)
			hallways[random.nextInt(hallways.length)].generate(senterianChunk, random, 0, topLayer, 0);

		ceiling.generate(senterianChunk, random, 0, 20, 0);

		//These rooms need to be generated last
		int bigRoomChance = 30;
		SenterianRoomBase br = (bigRooms.get(random.nextInt(bigRooms.size())));
		if (random.nextInt(bigRoomChance) == 0) {
			br.generate(senterianChunk, random, 0, bottomLayer, 0);
		}

		if (random.nextInt(bigRoomChance) == 0) {
			br = (bigRooms.get(random.nextInt(bigRooms.size())));
			br.generate(senterianChunk, random, 0, secondLayer, 0);
		}

		if (random.nextInt(bigRoomChance) == 0) {
			br = (bigRooms.get(random.nextInt(bigRooms.size())));
			br.generate(senterianChunk, random, 0, thirdLayer, 0);
		}

		if (random.nextInt(bigRoomChance) == 0) {
			br = (bigRooms.get(random.nextInt(bigRooms.size())));
			br.generate(senterianChunk, random, 0, topLayer, 0);
		}

		//Forces a roof over the whole room, gets generated at final set
		chunkTileEntityMap.put(new ChunkPos(chunkX, chunkZ), senterianChunk.getTileEntityMap());

		Chunk chunk = new Chunk(this.worldObj, senterianChunk, chunkX, chunkZ);
		byte[] abyte = chunk.getBiomeArray();

		for (int i = 0; i < abyte.length; ++i) {
			abyte[i] = (byte) Biome.getIdForBiome(this.biomesForGeneration[i]);
		}

		chunk.generateSkylightMap();
		return chunk;
	}

	@Override
	public void populate(int chunkX, int chunkZ) {
		int x = chunkX * 16;
		int z = chunkZ * 16;
		BlockPos pos = new BlockPos(x, 0, z);
		Biome biome = this.worldObj.getBiome(pos.add(16, 0, 16));
		this.random.setSeed(this.worldObj.getSeed());
		long k = this.random.nextLong() / 2L * 2L + 1L;
		long l = this.random.nextLong() / 2L * 2L + 1L;
		ChunkPos chunkpos = new ChunkPos(chunkX, chunkZ);
		this.random.setSeed((long) chunkX * k + (long) chunkZ * l ^ this.worldObj.getSeed());

		//checks all tile entitys in the world and updates (renders) them
		Map<BlockPos, TECompatibleChunkPrimer.PrimerData> tileEntityData = chunkTileEntityMap.get(chunkpos);
		if (tileEntityData != null) {
			Chunk chunk = this.worldObj.getChunk(chunkX, chunkZ);

			Iterator<Map.Entry<BlockPos, TECompatibleChunkPrimer.PrimerData>> iterator = tileEntityData.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<BlockPos, TECompatibleChunkPrimer.PrimerData> entry = iterator.next();

				BlockPos tePos = entry.getKey().add(x, 0, z);
				TECompatibleChunkPrimer.PrimerData data = entry.getValue();

				IBlockState state = chunk.getBlockState(tePos.getX(), tePos.getY(), tePos.getZ());
				TileEntity te = state.getBlock().createTileEntity(this.worldObj, state);

				this.worldObj.setTileEntity(tePos, te);

				TECompatibleChunkPrimer.TileEntityInitializer<?> tileEntityInitializer = data.getTileEntityInitializer();
				if (tileEntityInitializer != null) {
					tileEntityInitializer.process(worldObj, te, random);
				}

				iterator.remove();
			}

			chunkTileEntityMap.remove(chunkpos);
		}

		WorldEntitySpawner.performWorldGenSpawning(this.worldObj, biome, x + 8, z + 8, 16, 16, this.random);
	}

	@Override
	public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		Biome biome = this.worldObj.getBiome(pos);
		return biome.getSpawnableList(creatureType);
	}

	@Override
	public void recreateStructures(Chunk c, int x, int z) {
	}

	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) {
		return false;
	}

	@Override
	public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored) {
		return null;
	}

	@Override
	public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
		return false;
	}
}