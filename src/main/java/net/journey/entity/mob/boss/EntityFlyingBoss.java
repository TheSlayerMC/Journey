package net.journey.entity.mob.boss;

import net.journey.api.entity.IEssenceBoss;
import net.journey.init.JourneySounds;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModFlying;

public abstract class EntityFlyingBoss extends EntityModFlying implements IEssenceBoss {

    private int deathTicks;

    public EntityFlyingBoss(World par1World) {
        super(par1World);
        isImmuneToFire = true;
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    public final float getModHealth() {
        return super.getHealth();
    }

    @Override
    public SoundEvent setDeathSound() {
        return JourneySounds.BOSS_DEATH;
    }

    @Override
    public float getSoundVolume() {
        return 10.0F;
    }

    @Override
    public float getModMaxHealth() {
        return getMaxHealth();
    }
    
    public double setFollowRange() {
        return MobStats.boss_follow;
    }

    @Override
    protected void onDeathUpdate() {
        {
            float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
            float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
            float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            this.world.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, this.posX + f, this.posY + 2.0D + f1, this.posZ + f2, 0.0D, 0.0D, 0.0D);
            this.world.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, this.posX + f, this.posY + 1.0D + f1, this.posZ + f2, 0.0D, 0.0D, 0.0D);
            this.world.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, this.posX + f, this.posY + 3.0D + f1, this.posZ + f2, 0.0D, 0.0D, 0.0D);
            this.world.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, this.posX + f, this.posY + 2.5D + f1, this.posZ + f2, 0.0D, 0.0D, 0.0D);
            this.world.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, this.posX + f, this.posY + 1.5D + f1, this.posZ + f2, 0.0D, 0.0D, 0.0D);
            this.world.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, this.posX + f, this.posY + 3.5D + f1, this.posZ + f2, 0.0D, 0.0D, 0.0D);

            this.world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX + 0.0D + f, this.posY + 1.0D + f1, this.posZ + f2, 0.0D, 0.0D, 0.0D);
            this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX + 0.0D + f, this.posY + 3.0D + f1, this.posZ + f2, 0.0D, 0.0D, 0.0D);
            this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX + 0.0D + f, this.posY + 1.0D + f1, this.posZ + f2, 0.0D, 0.0D, 0.0D);
            this.world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX + 0.0D + f, this.posY + 1.0D + f1, this.posZ + f2, 0.0D, 0.0D, 0.0D);
            this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX + 0.0D + f, this.posY + 3.0D + f1, this.posZ + f2, 0.0D, 0.0D, 0.0D);
            this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX + 0.0D + f, this.posY + 1.0D + f1, this.posZ + f2, 0.0D, 0.0D, 0.0D);
        }

        int i;
        int j;

        if (!this.world.isRemote) {
            {
                i = 1000;

                while (i > 0) {
                    j = EntityXPOrb.getXPSplit(i);
                    i -= j;
                    this.world.spawnEntity(new EntityXPOrb(this.world, this.posX, this.posY, this.posZ, j));
                }
            }
        }
        this.renderYawOffset = this.rotationYaw += 20.0F;
        {
            i = 2000;

            while (i > 0) {
                j = EntityXPOrb.getXPSplit(i);
                i -= j;
                this.world.spawnEntity(new EntityXPOrb(this.world, this.posX, this.posY, this.posZ, j));
            }
            this.setDead();
        }
    }
}
