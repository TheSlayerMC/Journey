package net.journey.entity.mob.euca;

import net.journey.api.entity.JEntityMob;
import net.journey.entity.MobStats;
import net.journey.init.JourneySounds;
import net.journey.util.JourneyLootTables;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class EntityGoldbot extends JEntityMob {

    public EntityGoldbot(World par1World) {
        super(par1World);
        addAttackingAI();
        setSize(0.7F, 1.2F);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return JourneySounds.ROBOT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource d) {
        return JourneySounds.ROBOT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return JourneySounds.ROBOT_DEATH;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return JourneyLootTables.GOLDBOT;
    }

    @Override
    public @NotNull EntitySettings getEntitySettings() {
        return MobStats.GOLDBOT;
    }
}