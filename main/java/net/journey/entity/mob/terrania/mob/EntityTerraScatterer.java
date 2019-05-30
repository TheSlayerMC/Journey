package net.journey.entity.mob.terrania.mob;

import net.journey.JourneyItems;
import net.journey.JourneySounds;
import net.journey.entity.MobStats;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityTerraScatterer extends EntityModMob {

	public EntityTerraScatterer(World w) {
		super(w);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return MobStats.baseJourneyDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return MobStats.terraniaHealth;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return JourneySounds.WRAITH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource sourceIn) {
		return SoundEvents.ENTITY_CREEPER_HURT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return JourneySounds.WRAITH_DEATH;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(4) == 0) dropItem(JourneyItems.lightTerrarianSoil, 4);
		if(rand.nextInt(2) == 0) dropItem(JourneyItems.lightTerrarianSoil, 2);
		super.dropFewItems(b, j);
	}

	@Override
	public Item getDropItem() {
		return null;
	}

}