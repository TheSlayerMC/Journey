package net.journey.client.render;

import net.journey.blocks.tileentity.*;
import net.journey.client.render.base.*;
import net.journey.client.render.block.*;
import net.journey.client.render.mob.*;
import net.journey.client.render.mob.base.*;
import net.journey.client.render.model.item.ModelObsidianBoat;
import net.journey.client.render.model.mob.boil.*;
import net.journey.client.render.model.mob.boss.*;
import net.journey.client.render.model.mob.cloudia.*;
import net.journey.client.render.model.mob.corba.*;
import net.journey.client.render.model.mob.depths.*;
import net.journey.client.render.model.mob.end.ModelEnderCrawler;
import net.journey.client.render.model.mob.end.ModelEnderLeaper;
import net.journey.client.render.model.mob.euca.*;
import net.journey.client.render.model.mob.frozen.*;
import net.journey.client.render.model.mob.nether.*;
import net.journey.client.render.model.mob.overworld.ModelWraith;
import net.journey.client.render.model.mob.overworld.*;
import net.journey.client.render.model.mob.overworld.cold.ModelBlizzard;
import net.journey.client.render.model.mob.overworld.desert.ModelDunewerm;
import net.journey.client.render.model.mob.overworld.desert.ModelSandCrawler;
import net.journey.client.render.model.mob.overworld.desert.ModelSpyclops;
import net.journey.client.render.model.mob.overworld.jungle.ModelJungleGolem;
import net.journey.client.render.model.mob.overworld.jungle.ModelJungleSpider;
import net.journey.client.render.model.mob.overworld.jungle.ModelJungleTurtle;
import net.journey.client.render.model.mob.overworld.underground.ModelCaveling;
import net.journey.client.render.model.mob.overworld.underground.ModelCavurn;
import net.journey.client.render.model.mob.overworld.underground.ModelStonewalker;
import net.journey.client.render.model.mob.overworld.underground.npc.ModelRockiteGolem;
import net.journey.client.render.model.mob.senterian.ModelSentryBlock;
import net.journey.client.render.model.mob.senterian.ModelSentryLord;
import net.journey.client.render.model.mob.senterian.ModelSentryStalker;
import net.journey.client.render.model.mob.senterian.ModelSentryWalker;
import net.journey.client.render.model.mob.terrania.mob.*;
import net.journey.client.render.model.mob.terrania.npc.ModelTerranianTrader;
import net.journey.entity.item.EntityMagicExplosive;
import net.journey.entity.item.EntityObsidianBoat;
import net.journey.entity.mob.boiling.*;
import net.journey.entity.mob.boiling.npc.EntityBoilTrader;
import net.journey.entity.mob.boiling.npc.EntityEscapedConvict;
import net.journey.entity.mob.boss.*;
import net.journey.entity.mob.buddy.EntitySpiritLurker;
import net.journey.entity.mob.cloudia.*;
import net.journey.entity.mob.cloudia.npc.EntityStarlightBlacksmith;
import net.journey.entity.mob.cloudia.npc.EntityStarlightVillager;
import net.journey.entity.mob.corba.*;
import net.journey.entity.mob.corba.npc.EntityOvergrownMerchant;
import net.journey.entity.mob.corba.npc.EntityRedTordo;
import net.journey.entity.mob.corba.npc.EntityTheHooded;
import net.journey.entity.mob.corba.npc.EntityTordo;
import net.journey.entity.mob.depths.*;
import net.journey.entity.mob.depths.npc.EntityStaringGuardian;
import net.journey.entity.mob.end.EntityEnderCrawler;
import net.journey.entity.mob.end.EntityEnderLeaper;
import net.journey.entity.mob.euca.*;
import net.journey.entity.mob.euca.npc.EntityAlloyMender;
import net.journey.entity.mob.frozen.*;
import net.journey.entity.mob.frozen.npc.EntityFrozenMerchant;
import net.journey.entity.mob.nether.*;
import net.journey.entity.mob.overworld.*;
import net.journey.entity.mob.overworld.cold.EntityBlizzard;
import net.journey.entity.mob.overworld.jungle.EntityJungleGolem;
import net.journey.entity.mob.overworld.jungle.EntityJungleSpider;
import net.journey.entity.mob.overworld.jungle.EntityJungleTurtle;
import net.journey.entity.mob.overworld.npc.EntityBlacksmith;
import net.journey.entity.mob.overworld.npc.EntityMage;
import net.journey.entity.mob.overworld.underground.*;
import net.journey.entity.mob.overworld.underground.npc.EntityRockiteGolem;
import net.journey.entity.mob.pet.EntityEucaHopper;
import net.journey.entity.mob.pet.EntityPetRobot;
import net.journey.entity.mob.pet.EntityShiverwolf;
import net.journey.entity.mob.pet.EntityTamedRoc;
import net.journey.entity.mob.senterian.mob.*;
import net.journey.entity.mob.terrania.mob.*;
import net.journey.entity.mob.terrania.npc.EntityTerranianEnchanter;
import net.journey.entity.mob.terrania.npc.EntityTerranianTrader;
import net.journey.entity.projectile.*;
import net.journey.entity.projectile.arrow.EntityDarknessArrow;
import net.journey.entity.projectile.arrow.EntityEssenceArrow;
import net.journey.entity.projectile.knife.*;
import net.journey.entity.projectile.launcher.*;
import net.journey.entity.projectile.piercer.*;
import net.journey.entity.projectile.staff.*;
import net.journey.entity.projectile.throwable.EntityDemonicBomb;
import net.journey.entity.projectile.throwable.EntityFireBomb;
import net.journey.entity.projectile.throwable.EntityMagicBomb;
import net.journey.entity.projectile.throwable.EntityMagicPot;
import net.journey.entity.util.EntityBossCrystal;
import net.journey.entity.util.EntitySentacoin;
import net.journey.entity.util.EntitySentacoinBag;
import net.journey.init.items.JourneyWeapons;
import net.journey.util.EnumHexColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.model.ModelSnowMan;
import net.minecraft.client.renderer.entity.RenderTippedArrow;
import net.minecraft.init.Items;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import ru.timeconqueror.timecore.client.render.model.TimeModelLoader;

public class EntityRendering {

    public static void preInit() {
		RenderingRegistry.registerEntityRenderingHandler(EntitySentryKingGrenade.class, manager -> new RenderEntity2D<>(manager, Textures.getProjectileTextureLocation("sentry_king_grenade")));
		RenderingRegistry.registerEntityRenderingHandler(EntityMagmaFireball.class, manager -> new RenderEntity2D<>(manager, Textures.getProjectileTextureLocation("magma_ball")));
        RenderingRegistry.registerEntityRenderingHandler(EntityBouncingProjectile.class, manager -> new RenderEntity2D<>(manager, Textures.getProjectileTextureLocation("bouncing")));
        RenderingRegistry.registerEntityRenderingHandler(EntityRockProjectile.class, manager -> new RenderEntity2D<>(manager, Textures.getProjectileTextureLocation("rock_chunk")));
        RenderingRegistry.registerEntityRenderingHandler(EntityNetherPlasma.class, manager -> new RenderEntity2D<>(manager, Textures.getProjectileTextureLocation("plasma_ball")));
        RenderingRegistry.registerEntityRenderingHandler(EntityOceanPlasma.class, manager -> new RenderEntity2D<>(manager, Textures.getProjectileTextureLocation("plasma_ball")));
        RenderingRegistry.registerEntityRenderingHandler(EntityForestPlasma.class, manager -> new RenderEntity2D<>(manager, Textures.getProjectileTextureLocation("plasma_ball")));
        RenderingRegistry.registerEntityRenderingHandler(EntityShimmererProjectile.class, manager -> new RenderEntity2D<>(manager, Textures.getProjectileTextureLocation("shimmerer_projectile")));
        RenderingRegistry.registerEntityRenderingHandler(EntityBubbleProjectile.class, manager -> new RenderEntity2D<>(manager, Textures.getProjectileTextureLocation("bubble")));
        RenderingRegistry.registerEntityRenderingHandler(EntityDetractor.class, manager -> new RenderEntity2D<>(manager, Textures.getProjectileTextureLocation("detractor")));
        RenderingRegistry.registerEntityRenderingHandler(EntityFloroDirtProjectile.class, manager -> new RenderEntity2D<>(manager, Textures.getProjectileTextureLocation("floro_mud")));

        RenderingRegistry.registerEntityRenderingHandler(EntitySwampFly.class, manager -> new RenderEntity2DAnimated(manager,
                10,
                "swamp_fly_0",
                "swamp_fly_1",
                "swamp_fly_2",
                "swamp_fly_3"));
        RenderingRegistry.registerEntityRenderingHandler(EntityTerralight.class, manager -> new RenderEntity2DAnimated(manager,
                10,
                "terralight_0",
                "terralight_1",
                "terralight_2",
                "terralight_3"));

        RenderingRegistry.registerEntityRenderingHandler(EntitySpiritLurker.class, manager -> new RenderEntity2DAnimated(manager,
                10,
                "terralight_0",
                "terralight_1",
                "terralight_2",
                "terralight_3"));

        RenderingRegistry.registerEntityRenderingHandler(EntityLavasnake.class, manager -> new AnimatedMobRenderer<>(manager, TimeModelLoader
                .loadJsonEntityModel(Textures.getEntityModelLocation("lavasnake"))
                .setScaleMultiplier(2.0F), Textures
                .getMobTextureLocation("lavasnake")));

        RenderingRegistry.registerEntityRenderingHandler(EntityFloro.class, manager -> new AnimatedMobRenderer<>(manager, TimeModelLoader
                .loadJsonEntityModel(Textures.getEntityModelLocation("floro"))
                .setScaleMultiplier(1.6F), Textures
                .getMobTextureLocation("floro")));

        RenderingRegistry.registerEntityRenderingHandler(EntityTurducken.class, manager -> new AnimatedMobRenderer<>(manager, TimeModelLoader
                .loadJsonEntityModel(Textures.getEntityModelLocation("turducken"))
                .setScaleMultiplier(1.35F), Textures
                .getMobTextureLocation("turducken")));

        RenderingRegistry.registerEntityRenderingHandler(EntityFlungus.class, manager -> new AnimatedMobRenderer<>(manager, TimeModelLoader
                .loadJsonEntityModel(Textures.getEntityModelLocation("flungus"))
                .setScaleMultiplier(2.55F), Textures
                .getMobTextureLocation("flungus")));

        RenderingRegistry.registerEntityRenderingHandler(EntityCloudiaGuardian.class, manager -> new AnimatedMobRenderer<>(manager, TimeModelLoader
                .loadJsonEntityModel(Textures.getEntityModelLocation("cloudia_guardian"))
                .setScaleMultiplier(1.0F), Textures
                .getMobTextureLocation("cloudia_guardian")));

        RenderingRegistry.registerEntityRenderingHandler(EntityCorbanianMollusk.class, manager -> new AnimatedAgeableMobRenderer<>(manager, TimeModelLoader
                .loadJsonEntityModel(Textures.getEntityModelLocation("corbanian_mollusk"))
                .setScaleMultiplier(2.5F), Textures
                .getMobTextureLocation("corbanian_mollusk")));

        RenderingRegistry.registerEntityRenderingHandler(EntityBossCrystal.class, RenderBossCrystal::new);

    }

    public static void init() {
        RenderingRegistry.registerEntityRenderingHandler(EntityTempleGuardian.class, new RenderBoss(new ModelMage(), 0.5F, 2.0F, Textures.templeGuardian, "templeGuardian", EnumHexColor.RED, EnumHexColor.BLACK));
        /**Projectiles*/
        RenderingRegistry.registerEntityRenderingHandler(EntityDamagingProjectile.class, new RenderStaffProjectile(Textures.basic, 1.0F, 0.2F, 0.2F));
        RenderingRegistry.registerEntityRenderingHandler(EntityDoomsBringer.class, new RenderStaffProjectile(Textures.basic, 1.2F, 0.2F, 0.2F));
        RenderingRegistry.registerEntityRenderingHandler(EntityConjuring.class, new RenderStaffProjectile(Textures.basic, 0.1F, 1.0F, 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityEnlightenment.class, new RenderStaffProjectile(Textures.basic, 0.7F, 0.0F, 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityGreenpace.class, new RenderStaffProjectile(Textures.basic, 0.6F, 1.0F, 0.0F));
        RenderingRegistry.registerEntityRenderingHandler(EntityWizardsStar.class, new RenderStaffProjectile(Textures.basic, 1.0F, 1.0F, 0.2F));
        //RenderingRegistry.registerEntityRenderingHandler(EntityFlameArrow.class, new RenderModArrow());
        //RenderingRegistry.registerEntityRenderingHandler(EntityPoisonArrow.class, new RenderModArrow());
        RenderingRegistry.registerEntityRenderingHandler(EntityDarknessArrow.class, new RenderTippedArrow(Minecraft.getMinecraft().getRenderManager())); //temporary because RenderModArrow appears to be broken
        //RenderingRegistry.registerEntityRenderingHandler(EntityFrozenArrow.class, new RenderModArrow());
        RenderingRegistry.registerEntityRenderingHandler(EntityEssenceArrow.class, new RenderEssenceArrow(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityFireBall.class, new RenderStaffProjectile(Textures.empty, 1F, 1F, 1F));
        RenderingRegistry.registerEntityRenderingHandler(EntityIceBall.class, new RenderStaffProjectile(Textures.empty, 1F, 1F, 1F));
        RenderingRegistry.registerEntityRenderingHandler(EntityTempleBall.class, new RenderStaffProjectile(Textures.templeBall, 0F, 0F, 0F));
        RenderingRegistry.registerEntityRenderingHandler(EntityLightningBall.class, new RenderStaffProjectile(Textures.empty, 1F, 1F, 1F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBoilingPiercer.class, new RenderItemProjectile(JourneyWeapons.boilingPiercer));
        RenderingRegistry.registerEntityRenderingHandler(EntityNethicPiercer.class, new RenderItemProjectile(JourneyWeapons.nethicPiercer));
        RenderingRegistry.registerEntityRenderingHandler(EntityFrozenPiercer.class, new RenderItemProjectile(JourneyWeapons.frozenPiercer));
        RenderingRegistry.registerEntityRenderingHandler(EntityEucaPiercer.class, new RenderItemProjectile(JourneyWeapons.eucaPiercer));
        RenderingRegistry.registerEntityRenderingHandler(EntityDepthsPiercer.class, new RenderItemProjectile(JourneyWeapons.depthsPiercer));
        RenderingRegistry.registerEntityRenderingHandler(EntityCorbaPiercer.class, new RenderItemProjectile(JourneyWeapons.corbaPiercer));
        RenderingRegistry.registerEntityRenderingHandler(EntityFrostbittenPiercer.class, new RenderItemProjectile(JourneyWeapons.frostbittenPiercer));
        RenderingRegistry.registerEntityRenderingHandler(EntityFrostyPiercer.class, new RenderItemProjectile(JourneyWeapons.frostyPiercer));
        RenderingRegistry.registerEntityRenderingHandler(EntitySunsetPiercer.class, new RenderItemProjectile(JourneyWeapons.sunsetPiercer));
        RenderingRegistry.registerEntityRenderingHandler(EntitySkyPiercer.class, new RenderItemProjectile(JourneyWeapons.skyPiercer));
        RenderingRegistry.registerEntityRenderingHandler(EntityMagicPot.class, new RenderItemProjectile(JourneyWeapons.magicPotOfDestruction));
        RenderingRegistry.registerEntityRenderingHandler(EntityMoltenKnife.class, new RenderItemProjectile(JourneyWeapons.moltenKnife));
        RenderingRegistry.registerEntityRenderingHandler(EntityAquaticKnife.class, new RenderItemProjectile(JourneyWeapons.aquaticKnife));
        RenderingRegistry.registerEntityRenderingHandler(EntityBloodKnife.class, new RenderItemProjectile(JourneyWeapons.bloodKnife));
        RenderingRegistry.registerEntityRenderingHandler(EntityCharredKnife.class, new RenderItemProjectile(JourneyWeapons.charredKnife));
        RenderingRegistry.registerEntityRenderingHandler(EntitySizzlingKnife.class, new RenderItemProjectile(JourneyWeapons.sizzlingKnife));
        RenderingRegistry.registerEntityRenderingHandler(EntityMagicBomb.class, new RenderItemProjectile(JourneyWeapons.magicBomb));
        RenderingRegistry.registerEntityRenderingHandler(EntityFrozenSnowball.class, new RenderItemProjectile(Items.SNOWBALL));
        RenderingRegistry.registerEntityRenderingHandler(EntityEssenceShuriken.class, new RenderItemProjectile(JourneyWeapons.essenceShuriken));
        RenderingRegistry.registerEntityRenderingHandler(EntityDemonicBomb.class, new RenderItemProjectile(JourneyWeapons.demonicBomb));
        RenderingRegistry.registerEntityRenderingHandler(EntityFireBomb.class, new RenderItemProjectile(JourneyWeapons.fireBomb));
        //RenderingRegistry.registerEntityRenderingHandler(EntityRoyalKnife.class, new RenderItemProjectile(JourneyItems.royalKnife));
        
        RenderingRegistry.registerEntityRenderingHandler(EntityPetRobot.class, new RenderSizeable(new ModelRobot(), 0.5F, 0.5F, Textures.robot));

        RenderingRegistry.registerEntityRenderingHandler(EntityEucaHopper.class, new RenderSizeable(new ModelEucaHopper(), 0.5F, 0.5F, Textures.eucaHopper));

        /**Overworld Mobs*/
        RenderingRegistry.registerEntityRenderingHandler(EntityRobot.class, new RenderModMob(new ModelRobot(), Textures.robot));
        RenderingRegistry.registerEntityRenderingHandler(EntitySpikedBeast.class, new RenderModMob(new ModelSpikedBeast(), Textures.spikedBeast));
        RenderingRegistry.registerEntityRenderingHandler(EntitySpyclops.class, new RenderModMob(new ModelSpyclops(), Textures.spyclops));
        //RenderingRegistry.registerEntityRenderingHandler(EntityInsecto.class, new RenderInsecto(new ModelInsecto()));
        //RenderingRegistry.registerEntityRenderingHandler(EntityPsyollom.class, new RenderPsyollom(new ModelPsyollom()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDepthsBeast.class, new RenderSizeable(new ModelDepthsBeast(), 0.8F, 1.5F, Textures.depthsBeast));
        RenderingRegistry.registerEntityRenderingHandler(EntityDarknessCrawler.class, new RenderModMob(new ModelDarknessCrawler(), Textures.darknessCrawler));
        RenderingRegistry.registerEntityRenderingHandler(EntityBoom.class, new RenderBoomBoom(new ModelBoomBoom(), Textures.boom));
        RenderingRegistry.registerEntityRenderingHandler(EntityBigHongo.class, new RenderModMob(new ModelBigHongo(), Textures.bigHongo));
        RenderingRegistry.registerEntityRenderingHandler(EntityMediumHongo.class, new RenderModMob(new ModelMediumHongo(), Textures.mediumHongo));
        RenderingRegistry.registerEntityRenderingHandler(EntitySmallHongo.class, new RenderModMob(new ModelSmallHongo(), Textures.smallHongo));
        //RenderingRegistry.registerEntityRenderingHandler(EntityEucaFighter.class, new RenderEucaFighter(new ModelEucaFighter()));
        RenderingRegistry.registerEntityRenderingHandler(EntityMagmaBlaze.class, new RenderModMob(new ModelBlaze(), Textures.magmaBlaze));
        //RenderingRegistry.registerEntityRenderingHandler(EntityCrisp.class, new RenderModMob(new ModelDarknessCrawler(), tex.crisp));
        //RenderingRegistry.registerEntityRenderingHandler(EntityBurntMiner.class, new RenderModBiped(new ModelBiped(), tex.burntMiner));
        RenderingRegistry.registerEntityRenderingHandler(EntityExposedFlame.class, new RenderModBiped(new ModelBiped(), Textures.exposedFlame));
        RenderingRegistry.registerEntityRenderingHandler(EntityBurningLight.class, new RenderModBiped(new ModelBiped(), Textures.burningLight));
        RenderingRegistry.registerEntityRenderingHandler(EntityMagmaGiant.class, new RenderModMob(new ModelMagmaGiant(), Textures.magmaGiant));
        //RenderingRegistry.registerEntityRenderingHandler(EntityAshHoarder.class, new RenderSizeable(new ModelDepthsBeast(), 0.8F, 1.5F, tex.ashHoarder));
        //RenderingRegistry.registerEntityRenderingHandler(EntityBurntAsh.class, new RenderSizeable(new ModelPsyollom(), 0.5F, 1.5F, tex.burntAsh));
        RenderingRegistry.registerEntityRenderingHandler(EntityReaper.class, new RenderModMob(new ModelReaper(), Textures.reaper));
        RenderingRegistry.registerEntityRenderingHandler(EntityDepthsHunter.class, new RenderSizeable(new ModelDepthsHunter(), 0.5F, 1.5F, Textures.depthsHunter));
        RenderingRegistry.registerEntityRenderingHandler(EntityEucaCharger.class, new RenderSizeable(new ModelEucaCharger(), 0.5F, 1.5F, Textures.eucaCharger));
        RenderingRegistry.registerEntityRenderingHandler(EntitySandCrawler.class, new RenderModMob(new ModelSandCrawler(), 0.5F, Textures.sandCrawler));
        RenderingRegistry.registerEntityRenderingHandler(EntityFireMage.class, new RenderModMob(new ModelMage(), Textures.fireMage));
        RenderingRegistry.registerEntityRenderingHandler(EntityIceMage.class, new RenderModMob(new ModelMageTransparent(), Textures.iceMage));
        RenderingRegistry.registerEntityRenderingHandler(EntityMage.class, new RenderModMob(new ModelMage(), Textures.mage));
        RenderingRegistry.registerEntityRenderingHandler(EntityBlacksmith.class, new RenderModBiped(new ModelBiped(), Textures.blacksmith));
        RenderingRegistry.registerEntityRenderingHandler(EntityFrozenMerchant.class, new RenderModMob(new ModelFrozenMerchant(), Textures.frozenMerchant));
        RenderingRegistry.registerEntityRenderingHandler(EntityEscapedConvict.class, new RenderModMob(new ModelEscapedConvict(), Textures.escapedConvict));
        RenderingRegistry.registerEntityRenderingHandler(EntityBoilTrader.class, new RenderModMob(new ModelBoilTrader(), Textures.boilTrader));
        RenderingRegistry.registerEntityRenderingHandler(EntityAlloyMender.class, new RenderModMob(new ModelAlloyMender(), Textures.alloyMender));
        RenderingRegistry.registerEntityRenderingHandler(EntityTordo.class, new RenderModMob(new ModelTordo(), Textures.greenTordo));
        RenderingRegistry.registerEntityRenderingHandler(EntityTheHooded.class, new RenderModMob(new ModelTheHooded(), Textures.theHooded));
        RenderingRegistry.registerEntityRenderingHandler(EntityRedTordo.class, new RenderModMob(new ModelTordo(), Textures.redTordo));
        RenderingRegistry.registerEntityRenderingHandler(EntityDuneworm.class, new RenderModMob(new ModelDunewerm(), Textures.dunewerm));
        //RenderingRegistry.registerEntityRenderingHandler(EntityDragon.class, new RenderDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityOverseer.class, new RenderModMob(new ModelOverseer(), Textures.overseer));
        RenderingRegistry.registerEntityRenderingHandler(EntitySurfaceSeer.class, new RenderModMob(new ModelOverseer(), Textures.surfaceSeer));
        RenderingRegistry.registerEntityRenderingHandler(EntityOverseerElder.class, new RenderModMob(new ModelOverseerElder(), Textures.overseerElder));
        RenderingRegistry.registerEntityRenderingHandler(EntityCloudGhost.class, new RenderModMob(new ModelCloudGhost(), Textures.cloudGhost));
        RenderingRegistry.registerEntityRenderingHandler(EntityStaringGuardian.class, new RenderModMob(new ModelStaringGuardian(), Textures.staringGuardian));
        RenderingRegistry.registerEntityRenderingHandler(EntityTreeGolem.class, new RenderModMob(new ModelTreeGolem(), Textures.treeGolem));
        RenderingRegistry.registerEntityRenderingHandler(EntityWoodCreature.class, new RenderModMob(new ModelWoodCreature(), Textures.woodCreature));
        RenderingRegistry.registerEntityRenderingHandler(EntityDynaster.class, new RenderModMob(new ModelDynaster(), Textures.dynaster));
        RenderingRegistry.registerEntityRenderingHandler(EntityGolder.class, new RenderModMob(new ModelGolder(), Textures.golder));
        RenderingRegistry.registerEntityRenderingHandler(EntityCrystalCluster.class, new RenderModMob(new ModelCrystalCluster(), Textures.crystalCluster));
        RenderingRegistry.registerEntityRenderingHandler(EntityGolditeMage.class, new RenderModMob(new ModelMage(), Textures.golditeMage));
        RenderingRegistry.registerEntityRenderingHandler(EntitySilverbot.class, new RenderModMob(new ModelSilverbot(), Textures.tinbot));
        RenderingRegistry.registerEntityRenderingHandler(EntityShimmerer.class, new RenderModMob(new ModelShimmerer(), Textures.shimmerer));
        RenderingRegistry.registerEntityRenderingHandler(EntityEnderLeaper.class, new RenderModMob(new ModelEnderLeaper(), Textures.enderLeaper));
        RenderingRegistry.registerEntityRenderingHandler(EntityFrightener.class, new RenderModMob(new ModelFrightener(), Textures.frightener));
        RenderingRegistry.registerEntityRenderingHandler(EntityHellwing.class, new RenderModMob(new ModelHellwing(), Textures.hellwing));
        RenderingRegistry.registerEntityRenderingHandler(EntityObserver.class, new RenderModMob(new ModelObserver(), Textures.observer));
        RenderingRegistry.registerEntityRenderingHandler(EntityScreamer.class, new RenderModMob(new ModelScreamer(), Textures.screamer));
        RenderingRegistry.registerEntityRenderingHandler(EntityEnderCrawler.class, new RenderModMob(new ModelEnderCrawler(), Textures.enderCrawler));
        RenderingRegistry.registerEntityRenderingHandler(EntityCaveMage.class, new RenderModMob(new ModelMage(), Textures.caveMage));
        RenderingRegistry.registerEntityRenderingHandler(EntityNatureMage.class, new RenderModMob(new ModelMage(), Textures.natureMage));
        RenderingRegistry.registerEntityRenderingHandler(EntityCavurn.class, new RenderModMob(new ModelCavurn(), Textures.cavurn));
        RenderingRegistry.registerEntityRenderingHandler(EntityCaveling.class, new RenderModMob(new ModelCaveling(), Textures.caveling));
        RenderingRegistry.registerEntityRenderingHandler(EntityGoldbot.class, new RenderModMob(new ModelGoldbot(), Textures.goldbot));
        RenderingRegistry.registerEntityRenderingHandler(EntityStonewalker.class, new RenderModMob(new ModelStonewalker(), Textures.stonewalker));
        RenderingRegistry.registerEntityRenderingHandler(EntityShiverwolf.class, new RenderModMob(new ModelShiverwolf(), Textures.shiverwolf));
        RenderingRegistry.registerEntityRenderingHandler(EntityShiveringShrieker.class, new RenderModMob(new ModelShiveringShrieker(), Textures.shiveringShrieker));
        RenderingRegistry.registerEntityRenderingHandler(EntityFrozenFrostbiter.class, new RenderModMob(new ModelFrozenFrostbiter(), Textures.frozenFrostbiter));
        RenderingRegistry.registerEntityRenderingHandler(EntityIceman.class, new RenderEntityTransparent(new ModelSnowMan(), Textures.iceman));
        RenderingRegistry.registerEntityRenderingHandler(EntityWraith.class, new RenderWraith(new ModelWraith(), Textures.wraith));
        //RenderingRegistry.registerEntityRenderingHandler(EntityTurducken.class, new RenderModMob(new ModelRoc(), Textures.turducken));
        RenderingRegistry.registerEntityRenderingHandler(EntityDarkener.class, new RenderModMob(new ModelDarkener(), Textures.darkener));
        RenderingRegistry.registerEntityRenderingHandler(EntityStarlightGolem.class, new RenderModMob(new ModelStarlightGolem(), Textures.starlightGolem));
        RenderingRegistry.registerEntityRenderingHandler(EntityIceGolem.class, new RenderIceGolem(new ModelIceGolem(), Textures.iceGolem));
        RenderingRegistry.registerEntityRenderingHandler(EntityLightener.class, new RenderModMob(new ModelLightener(), Textures.lightener));
        RenderingRegistry.registerEntityRenderingHandler(EntityDarkSorcerer.class, new RenderModMob(new ModelDarkSorcerer(), Textures.darkSorcerer));
        RenderingRegistry.registerEntityRenderingHandler(EntityStarlightTransporter.class, new RenderModMob(new ModelStarlightTransporter(), Textures.starlightTransporter));
        RenderingRegistry.registerEntityRenderingHandler(EntitySpectre.class, new RenderModMob(new ModelBiped(), Textures.spectre));
        RenderingRegistry.registerEntityRenderingHandler(EntityGreenHonglow.class, new RenderModMob(new ModelBigHongo(), Textures.greenHonglow));
        RenderingRegistry.registerEntityRenderingHandler(EntityBlueHonglow.class, new RenderModMob(new ModelBigHongo(), Textures.blueHonglow));
        RenderingRegistry.registerEntityRenderingHandler(EntityHonglow.class, new RenderModMob(new ModelBigHongo(), Textures.redHonglow));
        RenderingRegistry.registerEntityRenderingHandler(EntityStarlightVillager.class, new RenderModMob(new ModelStarlightVillager(), Textures.starlightVillager));
        RenderingRegistry.registerEntityRenderingHandler(EntityStarlightBlacksmith.class, new RenderModMob(new ModelStarlightVillager(), Textures.starlightBlacksmith));
        RenderingRegistry.registerEntityRenderingHandler(EntitySkyEel.class, new RenderModMob(new ModelSkyEel(), Textures.skyEel));
        RenderingRegistry.registerEntityRenderingHandler(EntityTerranianTrader.class, new RenderModMob(new ModelTerranianTrader(), Textures.terranianTrader));
        RenderingRegistry.registerEntityRenderingHandler(EntityTerranianEnchanter.class, new RenderModMob(new ModelTerranianTrader(), Textures.terranianEnchanter));
        RenderingRegistry.registerEntityRenderingHandler(EntityTerraScatterer.class, new RenderModMob(new ModelTerraScatterer(), Textures.terraScatterer));
        RenderingRegistry.registerEntityRenderingHandler(EntityAranaKing.class, new RenderSizeable(new ModelAranaKing(), 1.0F, 1.5F, Textures.ARANA_KING));
        RenderingRegistry.registerEntityRenderingHandler(EntityStarlightWalker.class, new RenderModMob(new ModelStarlightWalker(), Textures.starlightWalker));
        RenderingRegistry.registerEntityRenderingHandler(EntityPurplian.class, new RenderModMob(new ModelPurplian(), Textures.purplian));
        RenderingRegistry.registerEntityRenderingHandler(EntityOvergrownMerchant.class, new RenderModMob(new ModelFrozenMerchant(), Textures.overgrownMerchant));
        RenderingRegistry.registerEntityRenderingHandler(EntityTerraslug.class, new RenderModMob(new ModelTerraslug(), Textures.terraslug));
        RenderingRegistry.registerEntityRenderingHandler(EntityHellbot.class, new RenderModMob(new ModelGoldbot(), Textures.hellbot));
        RenderingRegistry.registerEntityRenderingHandler(EntityWitherspine.class, new RenderModMob(new ModelWitherspine(), Textures.witherspine));
        RenderingRegistry.registerEntityRenderingHandler(EntityHellCow.class, new RenderModMob(new ModelHellCow(), Textures.hellCow));
        RenderingRegistry.registerEntityRenderingHandler(EntityTerragrow.class, new RenderModMob(new ModelTerragrow(), Textures.terragrow));
        RenderingRegistry.registerEntityRenderingHandler(EntityTerrashroom.class, new RenderModMob(new ModelBigHongo(), Textures.terrashroom));
        RenderingRegistry.registerEntityRenderingHandler(EntityMiniGhast.class, new RenderModMob(new ModelMiniGhast(), Textures.miniGhast));
        RenderingRegistry.registerEntityRenderingHandler(EntityBlizzard.class, new RenderModMob(new ModelBlizzard(), Textures.blizzard));
        RenderingRegistry.registerEntityRenderingHandler(EntityRockiteGolem.class, new RenderModMob(new ModelRockiteGolem(), Textures.rockiteGolem));
        RenderingRegistry.registerEntityRenderingHandler(EntityInfernoBlaze.class, new RenderModMob(new ModelInfernoBlaze(), Textures.infernoBlaze));
        RenderingRegistry.registerEntityRenderingHandler(EntityHellTurtle.class, new RenderModMob(new ModelJungleTurtle(), Textures.hellTurtle));
        RenderingRegistry.registerEntityRenderingHandler(EntityJungleGolem.class, new RenderModMob(new ModelJungleGolem(), Textures.jungleGolem));

        RenderingRegistry.registerEntityRenderingHandler(EntitySentryHeart.class, new RenderSentryHeart());
        RenderingRegistry.registerEntityRenderingHandler(EntitySentryBlock.class, new RenderSentryBlock(new ModelSentryBlock(), Textures.sentryBlock));
        RenderingRegistry.registerEntityRenderingHandler(EntitySentryLord.class, new RenderSizeable(new ModelSentryLord(), 0, 0.8F, Textures.sentryLord));
        RenderingRegistry.registerEntityRenderingHandler(EntitySentryStalker.class, new RenderSizeable(new ModelSentryStalker(), 0, 0.65F, Textures.sentryStalker));
        RenderingRegistry.registerEntityRenderingHandler(EntitySentryWalker.class, new RenderSizeable(new ModelSentryWalker(), 0, 0.65F, Textures.sentryWalker));
        
        RenderingRegistry.registerEntityRenderingHandler(EntityMiniSentryLord.class, new RenderSizeable(new ModelSentryLord(), 0, 0.4F, Textures.sentryLord));
        RenderingRegistry.registerEntityRenderingHandler(EntityMiniSentryStalker.class, new RenderSizeable(new ModelSentryStalker(), 0, 0.35F, Textures.sentryStalker));
        RenderingRegistry.registerEntityRenderingHandler(EntityMiniSentryWalker.class, new RenderSizeable(new ModelSentryWalker(), 0, 0.35F, Textures.sentryWalker));
        
        RenderingRegistry.registerEntityRenderingHandler(EntityFlameLotus.class, new RenderModMob(new ModelFlameLotus(), Textures.flameLotus));
        RenderingRegistry.registerEntityRenderingHandler(EntityCloudFlower.class, new RenderModMob(new ModelFlameLotus(), Textures.cloudFlower));

        RenderingRegistry.registerEntityRenderingHandler(EntityObsidianBoat.class, new RenderModBoat(new ModelObsidianBoat(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMagicExplosive.class, new MagicExplosiveRenderer(Minecraft.getMinecraft().getRenderManager()));

        RenderingRegistry.registerEntityRenderingHandler(EntityShatterer.class, new RenderShatterer());
        RenderingRegistry.registerEntityRenderingHandler(EntityFrozenTroll.class, new RenderModMob(new ModelFrozenTroll(), Textures.frozenTroll));
        RenderingRegistry.registerEntityRenderingHandler(EntityPermafraust.class, new RenderModMob(new ModelPermafraust(), Textures.permafraust));
        RenderingRegistry.registerEntityRenderingHandler(EntityShiveringBushwalker.class, new RenderModMob(new ModelShiveringBushwalker(), Textures.shiveringBushwalker));
        RenderingRegistry.registerEntityRenderingHandler(EntityLeafBlower.class, new RenderModMob(new ModelLeafBlower(), Textures.leafBlower));

        RenderingRegistry.registerEntityRenderingHandler(EntityStinky.class, new RenderModMob(new ModelStinky(), Textures.getMobTextureLocation("stinky")));
        RenderingRegistry.registerEntityRenderingHandler(EntitySmelly.class, new RenderModMob(new ModelSmelly(), Textures.getMobTextureLocation("smelly")));

        RenderingRegistry.registerEntityRenderingHandler(EntitySpiritCrystal.class, new RenderSpiritCrystal(Minecraft.getMinecraft().getRenderManager()));

        RenderingRegistry.registerEntityRenderingHandler(EntityTerranianProtector.class, new RenderBoss(new ModelTerranianProtector(), 0.5F, 2.0F, Textures.terranianProtector, "terranianProtector", EnumHexColor.WHITE, EnumHexColor.PURPLE));
        RenderingRegistry.registerEntityRenderingHandler(EntitySoulWatcher.class, new RenderBoss(new ModelSoulWatcher(), 0.5F, 2.0F, Textures.soulWatcher, "soulWatcher", EnumHexColor.WHITE, EnumHexColor.RED));
        RenderingRegistry.registerEntityRenderingHandler(EntityNetherBeast.class, new RenderBoss(new ModelBeastOfTheNether(), 0.5F, 2.0F, Textures.netherBeast, "netherBeast", EnumHexColor.RED, EnumHexColor.DARK_RED));
        RenderingRegistry.registerEntityRenderingHandler(EntityWitheringBeast.class, new RenderBoss(new ModelWitheringBeast(), 0.5F, 2.0F, Textures.witheringBeast, "witheringBeast", EnumHexColor.WHITE, EnumHexColor.BLACK));
        RenderingRegistry.registerEntityRenderingHandler(EntityCalcia.class, new RenderCalcia(new ModelClacia(), 0.5F, 2.0F, Textures.calcia, "calcia"));
        RenderingRegistry.registerEntityRenderingHandler(EntityFourfa.class, new RenderFourfa());
        RenderingRegistry.registerEntityRenderingHandler(EntityGuardianOfDestruction.class, new RenderGuardianOfDestruction());
        RenderingRegistry.registerEntityRenderingHandler(EntityBlazier.class, new RenderBoss(new ModelBlazier(), 0.5F, 2.0F, Textures.blazier, "blazier", EnumHexColor.WHITE, EnumHexColor.ORANGE));
        RenderingRegistry.registerEntityRenderingHandler(EntitySentryKing.class, new RenderBoss(new ModelSentryKing(), 0.5F, 2.0F, Textures.sentryKing, "sentryKing", EnumHexColor.ORANGE, EnumHexColor.DARK_ORANGE));
        RenderingRegistry.registerEntityRenderingHandler(EntityThunderbird.class, new RenderBoss(new ModelRoc(), 0.5F, 2.0F, Textures.thunderbird, "thunderbird", EnumHexColor.BLUE, EnumHexColor.DARK_BLUE));
        RenderingRegistry.registerEntityRenderingHandler(EntityLogger.class, new RenderBoss(new ModelLogger(), 0.5F, 2.0F, Textures.logger, "logger", EnumHexColor.LIGHT_BROWN, EnumHexColor.DARK_BROWN));
        RenderingRegistry.registerEntityRenderingHandler(EntityCorallator.class, new RenderBoss(new ModelCorallator(), 0.5F, 2.0F, Textures.corallator, "corallator", EnumHexColor.WHITE, EnumHexColor.ORANGE));
        RenderingRegistry.registerEntityRenderingHandler(EntitySkyStalker.class, new RenderBoss(new ModelSkyStalker(), 0.5F, 2.0F, Textures.skyStalker, "skyStalker", EnumHexColor.WHITE, EnumHexColor.PINK));
        RenderingRegistry.registerEntityRenderingHandler(EntityEudor.class, new RenderBoss(new ModelEudor(), 0.5F, 2.0F, Textures.eudor, "eudor", EnumHexColor.YELLOW, EnumHexColor.ORANGE));
        RenderingRegistry.registerEntityRenderingHandler(EntityScale.class, new RenderBoss(new ModelSoulWatcher(), 0.5F, 2.0F, Textures.scale, "scale", EnumHexColor.LIGHT_BLUE, EnumHexColor.DARK_BLUE));
        RenderingRegistry.registerEntityRenderingHandler(EntityRockiteSmasher.class, new RenderRockiteSmasher());

        RenderingRegistry.registerEntityRenderingHandler(EntityTamedRoc.class, new RenderModMob(new ModelRoc(), Textures.tameRoc));
        RenderingRegistry.registerEntityRenderingHandler(EntityJungleTurtle.class, new RenderSizeable(new ModelJungleTurtle(), 0.5F, 1.5F, Textures.jungleTurtle));
        RenderingRegistry.registerEntityRenderingHandler(EntityJungleSpider.class, new RenderSizeable(new ModelJungleSpider(), 0.5F, 0.5F, Textures.jungleSpider));
        //RenderingRegistry.registerEntityRenderingHandler(EntityWraith.class, new RenderBoss(new ModelWraith(), 0.5F, 1.0F, tex.wraith, stat.wraithBossID));

        //SlayerAPI.registerItemRenderer(EssenceBlocks.netherBeastStatue, new ItemRendererStatue("netherBeastStatue"));
        //SlayerAPI.registerItemRenderer(EssenceBlocks.witheringBeastStatue, new ItemRendererStatue("witheringBeastStatue"));
        //SlayerAPI.registerItemRenderer(EssenceBlocks.enderChampionStatue, new ItemRendererStatue("enderChampionStatue"));
        //SlayerAPI.registerItemRenderer(EssenceBlocks.wraithStatue, new ItemRendererStatue("wraithStatue"));
        //SlayerAPI.registerItemRenderer(EssenceBlocks.calciaStatue, new ItemRendererStatue("calciaStatue"));
        //SlayerAPI.registerItemRenderer(EssenceBlocks.eudorStatue, new ItemRendererStatue("eudorStatue"));

        //Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getModelManager().getBlockModelShapes().registerBuiltInBlocks(EssenceBlocks.calciaStatue);
        //TileEntityItemStackRenderer.instance = new ModeledBlockInventoryRenderer(TileEntityItemStackRenderer.instance);

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBossSpawner.class, new BossSpawnerTESR());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrindstone.class, new GrindstoneRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJourneyChest.class, new JourneyChestTESR());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySummoningTable.class, new SummoningTableRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySenterianPortal.class, new SenterianPortalRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCloudAltar.class, new CloudAltarRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySenterianAltar.class, new SenterianAltarRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityObelisk.class, new ObeliskRenderer());

        //RenderingRegistry.registerBlockHandler(EssenceBlocks.celestiumOre.getRenderType(), new OreRenderer());
        //RenderingRegistry.registerBlockHandler(EssenceBlocks.mossyEssenceStone.getRenderType(), new OtherBlockRenderer());
        
        RenderingRegistry.registerEntityRenderingHandler(EntitySentacoin.class, new RenderSentacoin());
        RenderingRegistry.registerEntityRenderingHandler(EntitySentacoinBag.class, new RenderSentacoinBag());

    }
}