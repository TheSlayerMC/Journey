package net.journey.entity.mob.nether;

import net.journey.JourneyItems;
import net.journey.JourneySounds;
import net.journey.entity.MobStats;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityHellbot extends EntityModMob {

	public EntityHellbot(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 1.2F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return MobStats.baseJourneyDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return MobStats.highNetherHealth;
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
		return JourneySounds.ROBOT_DEATH;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(5) == 0) dropItem(JourneyItems.flamingSpring, 1);
		if(rand.nextInt(80) == 0) dropItem(JourneyItems.flamingSprocket, 1);
		if(rand.nextInt(10) == 0) dropItem(JourneyItems.flamingSpring, 2);
		if(rand.nextInt(80) == 0) dropItem(JourneyItems.flamingSprocket, 2);
		super.dropFewItems(b, j);
	}

	@Override
	public Item getDropItem() {
		return null;
	}
}