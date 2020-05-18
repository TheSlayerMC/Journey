package net.journey.entity.mob.boss;

import net.journey.blocks.tileentity.TileEntityJourneyChest;
import net.journey.entity.MobStats;
import net.journey.init.JourneySounds;
import net.journey.init.blocks.JourneyBlocks;
import net.journey.init.items.JourneyItems;
import net.journey.init.items.JourneyWeapons;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityEssenceBoss;
import org.jetbrains.annotations.NotNull;

public class EntityNetherBeast extends EntityEssenceBoss {

    private int attackTimer;

    public EntityNetherBeast(World par1World) {
        super(par1World);
        addAttackingAI();
        setSize(2.0F, 2.5F);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return JourneySounds.BEAST_OF_THE_NETHER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource d) {
        return JourneySounds.BEAST_OF_THE_NETHER_HURT;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.attackTimer > 0) --this.attackTimer;
        if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(5) == 0) {
            int i = MathHelper.floor(this.posX);
            int j = MathHelper.floor(this.posY - 0.20000000298023224D);
            int k = MathHelper.floor(this.posZ);

            if (!world.isAirBlock(new BlockPos(i, j, k))) {
                IBlockState iblockstate = this.world.getBlockState(new BlockPos(i, j, k));
                this.world.spawnParticle(EnumParticleTypes.BLOCK_CRACK, this.posX + (this.rand.nextFloat() - 0.5D) * this.width, this.getEntityBoundingBox().minY + 0.1D, this.posZ + (this.rand.nextFloat() - 0.5D) * this.width, 4.0D * (this.rand.nextFloat() - 0.5D), 0.5D, (this.rand.nextFloat() - 0.5D) * 4.0D, Block.getStateId(iblockstate));
            }
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity e) {
        this.attackTimer = 5;
        this.world.setEntityState(this, (byte) 4);
        boolean flag = e.attackEntityFrom(DamageSource.causeMobDamage(this), (float) getAttackDamage());
        if (flag) {
            e.motionY += 1.0000000059604645D;
            e.setFire(10 + rand.nextInt(10));
        }
        this.playSound(SoundEvents.ENTITY_IRONGOLEM_ATTACK, 1.0F, 1.0F);
        return flag;
    }

    @Override
    public void onDeath(DamageSource damage) {
		/*if(damage.getEntity() instanceof EntityPlayer) {
			EntityPlayer p = (EntityPlayer)damage.getEntity();
			p.triggerAchievement(JourneyAchievements.achievementNetherBeast); {
			}
		}*/
        this.world.setBlockState(new BlockPos((int) Math.floor(this.posX + 0), ((int) Math.floor(this.posY + 1)), ((int) Math.floor(this.posZ + 0))), JourneyBlocks.trophyNetherBeast.getStateFromMeta(5));
        this.world.setBlockState(new BlockPos((int) Math.floor(this.posX + 0), ((int) Math.floor(this.posY + 0)), ((int) Math.floor(this.posZ + 0))), JourneyBlocks.journeyChest.getStateFromMeta(5));
        TileEntityJourneyChest te = (TileEntityJourneyChest) world.getTileEntity(new BlockPos((int) Math.floor(this.posX + 0), ((int) Math.floor(this.posY + 0)), ((int) Math.floor(this.posZ + 0))));
        switch (rand.nextInt(2)) {
            case 0:
                te.setInventorySlotContents(15, new ItemStack(JourneyItems.eucaPortalPiece, 1));
                te.setInventorySlotContents(1, new ItemStack(JourneyWeapons.netherBeastSword, 1));
                break;
            case 1:
                te.setInventorySlotContents(1, new ItemStack(JourneyItems.eucaPortalPiece, 2));
                te.setInventorySlotContents(10, new ItemStack(JourneyWeapons.netherBeastSword, 1));
                break;
        }
    }

    @Override
    public @NotNull EntitySettings getEntitySettings() {
        return MobStats.NETHER_BEAST;
    }
}