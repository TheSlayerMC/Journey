package net.journey.entity.mob.overworld;

import net.journey.JourneySounds;
import net.journey.entity.MobStats;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityRobot extends EntityModMob {

	public EntityRobot(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 2.3F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return MobStats.lowJourneyDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return MobStats.overworldHealth;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return JourneySounds.ROBOT;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource sourceIn) {
		return JourneySounds.ROBOT_HURT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return JourneySounds.ROBOT_HURT;
	}
	
	@Override
	public boolean getCanSpawnHere() {
		return 
			   this.world.getBlockState(new BlockPos(this.posX, this.posY-1, this.posZ)).getBlock() == Blocks.GRASS || 
			   		this.world.getBlockState(new BlockPos(this.posX, this.posY-1, this.posZ)).getBlock() == Blocks.LEAVES || 
			   			this.world.getBlockState(new BlockPos(this.posX, this.posY-1, this.posZ)).getBlock() == Blocks.SAND || 
			   				this.world.getBlockState(new BlockPos(this.posX, this.posY-1, this.posZ)).getBlock() == Blocks.DIRT;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(2) == 0) this.dropItem(Items.IRON_INGOT, 1 + rand.nextInt(1));
		if(rand.nextInt(2) == 0) this.dropItem(Items.STICK, 1 + rand.nextInt(4));
	}

	@Override
	public Item getDropItem() {
		return null;
	}
}