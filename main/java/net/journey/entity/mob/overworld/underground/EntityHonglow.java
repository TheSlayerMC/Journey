package net.journey.entity.mob.overworld.underground;

import net.journey.JourneyItems;
import net.journey.JourneySounds;
import net.journey.entity.MobStats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityHonglow extends EntityModMob {

	public EntityHonglow(World par1World) {
		super(par1World);
		addAttackingAI();
		this.setSize(1.0F, 2.0F);
	}
	
    public int getBrightnessForRender(float p_70070_1_)
    {
        return 15728880;
    }
    
    public float getBrightness(float p_70013_1_) {
        return 20.0F;
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
		return JourneySounds.HONGO;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource sourceIn) {
		return JourneySounds.HONGO_HURT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return JourneySounds.HONGO_HURT;
	}

	@Override
	public void onDeath(DamageSource d) {
		super.onDeath(d);
		if(d.getImmediateSource() instanceof EntityPlayer) {
			EntityPlayer p = (EntityPlayer)d.getImmediateSource();
			//p.triggerAchievement(JourneyAchievements.achievementCave);
		}
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 40.0D && super.getCanSpawnHere() && 
				this.world.getBlockState(new BlockPos(this.posX, this.posY-1, this.posZ)).getBlock() == Blocks.STONE;
	}

	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(1) == 0) dropItem(JourneyItems.redHonglowShroom, 1);
		super.dropFewItems(b, j);
		if(rand.nextInt(5) == 0) dropItem(JourneyItems.redHonglowShroom, 2);
		super.dropFewItems(b, j);
	}

	@Override
	public Item getDropItem() {
		return null;
	}
}