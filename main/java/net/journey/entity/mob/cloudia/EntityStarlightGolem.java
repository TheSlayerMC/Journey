package net.journey.entity.mob.cloudia;

import net.journey.JourneyItems;
import net.journey.JourneySounds;
import net.journey.entity.MobStats;
import net.minecraft.block.Block;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityStarlightGolem extends EntityModMob {

	public EntityStarlightGolem(World par1World) {
		super(par1World);
		addAttackingAI();
		this.setSize((float) 2.0, 2);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return MobStats.veryHardJourneyDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return MobStats.cloudiaHealth;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return JourneySounds.EMPTY;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource sourceIn) {
		return SoundEvents.ENTITY_IRONGOLEM_HURT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_IRONGOLEM_DEATH;
	}
	
	@Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
        //this.playSound("mob.irongolem.walk", 1.0F, 1.0F);
    }
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(1) == 0) dropItem(JourneyItems.golemChunk, 1);
		if(rand.nextInt(2) == 0) dropItem(JourneyItems.golemChunk, 2);
		if(rand.nextInt(4) == 0) dropItem(JourneyItems.golemChunk, 4);
		if(rand.nextInt(40) == 0) dropItem(JourneyItems.cloudiaOrb, 1);
		super.dropFewItems(b, j);
		
	}

	@Override
	public Item getDropItem() {
		return null;
	}

}