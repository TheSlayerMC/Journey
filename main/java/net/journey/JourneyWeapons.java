package net.journey;

import net.journey.entity.projectile.EntityAquaticKnife;
import net.journey.entity.projectile.EntityBloodKnife;
import net.journey.entity.projectile.EntityBoilingPiercer;
import net.journey.entity.projectile.EntityCharredKnife;
import net.journey.entity.projectile.EntityConjuring;
import net.journey.entity.projectile.EntityCorbaPiercer;
import net.journey.entity.projectile.EntityDarknessArrow;
import net.journey.entity.projectile.EntityDemonicBomb;
import net.journey.entity.projectile.EntityDepthsPiercer;
import net.journey.entity.projectile.EntityDoomsBringer;
import net.journey.entity.projectile.EntityEarthen;
import net.journey.entity.projectile.EntityEnlightenment;
import net.journey.entity.projectile.EntityEucaPiercer;
import net.journey.entity.projectile.EntityEyeBlaster;
import net.journey.entity.projectile.EntityFireBall;
import net.journey.entity.projectile.EntityFireBomb;
import net.journey.entity.projectile.EntityFloroWater;
import net.journey.entity.projectile.EntityFrostbittenPiercer;
import net.journey.entity.projectile.EntityFrostyPiercer;
import net.journey.entity.projectile.EntityFrozenPiercer;
import net.journey.entity.projectile.EntityGreenpace;
import net.journey.entity.projectile.EntityHellstone;
import net.journey.entity.projectile.EntityIceBall;
import net.journey.entity.projectile.EntityLightningBall;
import net.journey.entity.projectile.EntityMoltenKnife;
import net.journey.entity.projectile.EntityNetherPlasma;
import net.journey.entity.projectile.EntityNethicPiercer;
import net.journey.entity.projectile.EntityOvergrown;
import net.journey.entity.projectile.EntityRock;
import net.journey.entity.projectile.EntitySizzlingKnife;
import net.journey.entity.projectile.EntitySkyPiercer;
import net.journey.entity.projectile.EntitySunsetPiercer;
import net.journey.entity.projectile.EntityWithic;
import net.journey.entity.projectile.EntityWizardsStar;
import net.journey.items.ItemBattleAxe;
import net.journey.items.ItemCreativeHammer;
import net.journey.items.ItemGun;
import net.journey.items.ItemHammer;
import net.journey.items.ItemPiercer;
import net.journey.items.ItemStaff;
import net.journey.items.ItemTeleport;
import net.journey.items.ItemThrowable;
import net.journey.items.ItemThrowableArrow;
import net.journey.items.ItemWand;
import net.journey.items.bows.BlazingBow;
import net.journey.items.bows.CharredBow;
import net.journey.items.bows.CoreExpender;
import net.journey.items.bows.DarkEnforcer;
import net.journey.items.bows.DarkTerraBow;
import net.journey.items.bows.DarknessBow;
import net.journey.items.bows.DeathPiercerBow;
import net.journey.items.bows.DepthsBow;
import net.journey.items.bows.FlameBow;
import net.journey.items.bows.FlamingBow;
import net.journey.items.bows.FluffyBow;
import net.journey.items.bows.FrostbittenBow;
import net.journey.items.bows.FrostyBow;
import net.journey.items.bows.FrozenBow;
import net.journey.items.bows.FusionBow;
import net.journey.items.bows.GolemBow;
import net.journey.items.bows.LavenderBow;
import net.journey.items.bows.LoggersBow;
import net.journey.items.bows.MantleBow;
import net.journey.items.bows.OvergrownBow;
import net.journey.items.bows.OverseerBow;
import net.journey.items.bows.PoisonBow;
import net.journey.items.bows.RocsWing;
import net.journey.items.bows.RoyalBow;
import net.journey.items.bows.ScaleBow;
import net.journey.items.bows.SpringBow;
import net.journey.items.bows.StaringBow;
import net.journey.items.bows.StarlightBow;
import net.journey.items.bows.TerralightBow;
import net.journey.items.bows.TerrianBow;
import net.journey.items.bows.WastefulBow;
import net.journey.items.bows.WoodlandBow;
import net.journey.items.swords.ItemBubbleSword;
import net.journey.items.swords.ItemFireHealthSword;
import net.journey.items.swords.ItemFireSword;
import net.journey.items.swords.ItemFireWitherSword;
import net.journey.items.swords.ItemFreezeSword;
import net.journey.items.swords.ItemHealthSword;
import net.journey.items.swords.ItemLoggersSword;
import net.journey.items.swords.ItemNightvisionHealthSword;
import net.journey.items.swords.ItemNightvisionSword;
import net.journey.items.swords.ItemPoisionSword;
import net.journey.items.swords.ItemPoisonHealthSword;
import net.journey.items.swords.ItemRegenSword;
import net.journey.items.swords.ItemStunSword;
import net.journey.items.swords.ItemStunWitherSword;
import net.journey.items.swords.ItemWitherSword;
import net.journey.util.JourneyToolMaterial;
import net.minecraft.item.Item;
import net.slayer.api.item.ItemModSword;

public class JourneyWeapons {

	public static Item demonicBomb;
	public static Item fireBomb;
	public static Item boilingPiercer;
	public static Item nethicPiercer;
	public static Item frozenPiercer;
	public static Item eucaPiercer;
	public static Item depthsPiercer;
	public static Item corbaPiercer;
	public static Item frostbittenPiercer;
	public static Item frostyPiercer;
	public static Item sunsetPiercer;
	public static Item skyPiercer;
	
	public static Item moltenKnife;
	public static Item aquaticKnife;
	public static Item bloodKnife;
	public static Item charredKnife;
	public static Item sizzlingKnife;
	
	public static Item flameBow;
	public static Item poisonBow;
	public static Item darknessBow;
	public static Item frozenBow;
	public static Item staringBow;
	public static Item deathPiercerBow;
	public static Item fusionBow;
	public static Item springBow;
	public static Item starlightBow;
	public static Item wastefulBow;
	public static Item flamingBow;
	public static Item blazingBow;
	public static Item darkEnforcer;
	public static Item depthsBow;
	public static Item frostbittenBow;
	public static Item frostyBow;
	public static Item charredBow;
	public static Item fluffyBow;
	public static Item golemBow;
	public static Item loggersBow;
	public static Item overgrownBow;
	public static Item overseerBow;
	public static Item woodlandBow;
	public static Item rocsWing;
	public static Item scaleBow;
	public static Item mantleBow;
	public static Item coreExpender;
	public static Item royalBow;
	public static Item darkTerraBow;
	public static Item lavenderBow;
	public static Item terralightBow;
	public static Item terrianBow;

	public static Item fireWand;
	public static Item iceWand;
	public static Item lightningWand;

	public static Item hammerCreative;
	public static Item earthenHammer;
	public static Item flamingHammer;
	public static Item nethicHammer;
	public static Item withicHammer;
	public static Item royalHammer;
	public static Item overgrownHammer;
	public static Item rockyHammer;
	public static Item crystalizedHammer;
	
	public static Item rockyBattleaxe;
	public static Item crystalizedBattleaxe;
	public static Item backBiter;
	public static Item dawnBreaker;
	public static Item tempestBattleaxe;
	public static Item bronzedBattleaxe;
	public static Item celestiteBattleaxe;
	public static Item storumBattleaxe;
	public static Item celekiumBattleaxe;
	public static Item thunderbirdBattleaxe;
	 
	public static ItemStaff staffOfCrystal;
	public static ItemStaff staffOfDivineStone;
	public static ItemStaff staffOfHellstone;
	public static ItemStaff doomsBringer;
	public static ItemStaff conjuringStaff;
	public static ItemStaff staffOfEnlightenment;
	public static ItemStaff staffOfGreenpace;
	public static ItemStaff wizardsStar;
	public static Item teleportationStaff;
	public static ItemStaff overgrownStaff;
	
	public static Item chaosCannon;
	public static Item rockLauncher;
	public static Item netherPlasma;
	public static Item oceanPlasma;
	public static Item forestPlasma;
	public static Item eyeBlaster;
	
	public static Item hellstoneSword;
	public static Item shadiumSword;
	public static Item celestiumSword;
	public static Item luniumSword;
	public static Item flairiumSword;
	public static Item desSword;
	public static Item sapphireSword;
	public static Item gorbiteSword;
	public static Item orbaditeSword;
	public static Item poisonSword;
	public static Item cloudSlicer;
	public static Item dragonsTooth;
	public static Item netherBeastSword;
	public static Item witheringBeastSword;
	public static Item calciaSword;
	public static Item championsSword;
	public static Item theWraith;
	public static Item bubbleSword;
	public static Item boilingBlade;
	public static Item loggersSword;
	public static Item naturesBlade;
	public static Item depthsDarksword;
	public static Item depthsSlayer;
	public static Item snowShoveler;
	public static Item frostySword;
	public static Item frostbittenSword;
	public static Item treeHugger;
	public static Item coreMender;
	public static Item royalBlade;
	public static Item royalStabber;
	public static Item rocSword;
	public static Item swordOfTheThunderbird;
	public static Item bloodwieldSword;
	public static Item charredBlade;
	public static Item sizzlerSword;
	public static Item fluffyBlade;
	public static Item golemSword;
	public static Item thunderblade;
	public static Item sentrySword;
	public static Item crystalBlade;
	public static Item starlightBlade;
	public static Item koriteSword;
	public static Item storonSword;
	public static Item mekyumSword;
	public static Item pedalSword;
	public static Item withicBlade;
	public static Item reinforcedCrystalSword;
	public static Item reinforcedStoneSword;
	public static Item terralightBlade;
	public static Item terranaSword;
	public static Item terrolicaSword;
	public static Item voliteSword;
	public static Item kingsSword;
	public static Item demonicSword;
	public static Item vinestrandBlade;
	public static Item darkPineSword;
	public static Item healersBlade;
	public static Item terronicBlade;
	public static Item developerSword;
	
	public static void init() {
	
		
		poisonSword = new ItemPoisionSword("poisonSword", "Poison Sword", JourneyToolMaterial.POISON_SWORD);
		cloudSlicer = new ItemModSword("cloudSlicer", "Cloud Slicer", JourneyToolMaterial.CLOUD_SLICER);
		dragonsTooth = new ItemModSword("dragonsTooth", "Dragons Tooth", JourneyToolMaterial.DRAGONS_TOOTH);
		netherBeastSword = new ItemRegenSword("netherBeastSword", "Netherbeast Sword", JourneyToolMaterial.NETHER_BEAST_SWORD);
		witheringBeastSword = new ItemWitherSword("witheringBeastSword", "Witheringbeast Sword", JourneyToolMaterial.WITHERING_BEAST_SWORD);
		calciaSword = new ItemModSword("calciaSword", "Calcia Sword", JourneyToolMaterial.CALCIA_SWORD);
		championsSword = new ItemModSword("championsSword", "Champions Sword", JourneyToolMaterial.CHAMPIONS_SWORD);
		theWraith = new ItemModSword("theWraith", "The Wraith", JourneyToolMaterial.THE_WRAITH);
		bubbleSword = new ItemBubbleSword("bubbleSword", "Bubble Sword", JourneyToolMaterial.BUBBLE_SWORD);
		boilingBlade = new ItemFireSword("boilingBlade", "Boiling Blade", JourneyToolMaterial.BOILING_BLADE);
		loggersSword = new ItemLoggersSword("loggersSword", "Loggers Sword", JourneyToolMaterial.LOGGERS_SWORD);
		naturesBlade = new ItemStunWitherSword("naturesBlade", "Natures Blade", JourneyToolMaterial.NATURES_BLADE);
		depthsDarksword = new ItemStunWitherSword("depthsDarksword", "Depths Darksword", JourneyToolMaterial.DEPTHS_DARKSWORD);
		depthsSlayer = new ItemStunSword("depthsSlayer", "Depths Slayer", JourneyToolMaterial.DEPTHS_SLAYER);
		snowShoveler = new ItemStunWitherSword("snowShoveler", "Snow Shoveler", JourneyToolMaterial.SNOW_SHOVELER);
		frostySword = new ItemStunSword("frostySword", "Frosty Sword", JourneyToolMaterial.FROSTY_SWORD);
		frostbittenSword = new ItemStunSword("frostbittenSword", "Frostbitten Sword", JourneyToolMaterial.FROSTBITTEN_SWORD);
		treeHugger = new ItemPoisionSword("treeHugger", "Tree Hugger", JourneyToolMaterial.TREE_HUGGER);
		coreMender = new ItemFireSword("coreMender", "Core Mender", JourneyToolMaterial.CORE_MENDER);
		royalBlade = new ItemPoisionSword("royalBlade", "Royal Blade", JourneyToolMaterial.ROYAL_BLADE);
		royalStabber = new ItemPoisionSword("royalStabber", "Royal Stabber", JourneyToolMaterial.ROYAL_STABBER);
		rocSword = new ItemModSword("rocSword", "Roc Sword", JourneyToolMaterial.ROC_SWORD);
		swordOfTheThunderbird = new ItemModSword("swordOfTheThunderbird", "Sword of the Thunderbird", JourneyToolMaterial.SWORD_THUNDERBIRD);
		bloodwieldSword = new ItemHealthSword("bloodWieldSword", "Blood Wielder", JourneyToolMaterial.BLOODWIELD_SWORD, 1);
		charredBlade = new ItemWitherSword("charredBlade", "Charred Blade", JourneyToolMaterial.CHARRED_BLADE);
		sizzlerSword = new ItemFireWitherSword("sizzlerSword", "Sizzler Sword", JourneyToolMaterial.SIZZLER_SWORD);
		fluffyBlade = new ItemNightvisionHealthSword("fluffyBlade", "Fluffy Blade", JourneyToolMaterial.FLUFFY_BLADE);
		golemSword = new ItemModSword("golemSword", "Golem Sword", JourneyToolMaterial.GOLEM_SWORD);
		thunderblade = new ItemPoisonHealthSword("thunderblade", "Thunder Blade", JourneyToolMaterial.THUNDERBLADE, 1.5F);
		sentrySword = new ItemFireHealthSword("sentrySword", "Sentry Sword", JourneyToolMaterial.SENTRY_SWORD, 2);
		crystalBlade = new ItemModSword("crystalBlade", "Crystal Blade", JourneyToolMaterial.CRYSTAL_BLADE);
		starlightBlade = new ItemModSword("starlightBlade", "Starlight Blade", JourneyToolMaterial.STARLIGHT_BLADE);
		koriteSword = new ItemModSword("koriteSword", "Korite Sword", JourneyToolMaterial.KORITE_SWORD);
		storonSword = new ItemModSword("storonSword", "Storon Sword", JourneyToolMaterial.KORITE_SWORD);
		mekyumSword = new ItemModSword("mekyumSword", "Mekyum Sword", JourneyToolMaterial.KORITE_SWORD);
		hellstoneSword = new ItemFireSword("hellstoneSword", "Bloodcrust Sword", JourneyToolMaterial.HELLSTONE_SWORD);
		shadiumSword = new ItemFreezeSword("shadiumSword", "Shadium Sword", JourneyToolMaterial.SHADIUM_SWORD);
		celestiumSword = new ItemModSword("celestiumSword", "Celestium Sword", JourneyToolMaterial.CELESTIUM_SWORD);
		luniumSword = new ItemModSword("luniumSword", "Lunium Sword", JourneyToolMaterial.LUNIUM_SWORD);
		flairiumSword = new ItemFireSword("flairiumSword", "Flairium Sword", JourneyToolMaterial.FLAIRIUM_SWORD);
		desSword = new ItemModSword("desSword", "Des Sword", JourneyToolMaterial.DES_SWORD);
		sapphireSword = new ItemModSword("sapphireSword", "Sapphire Sword", JourneyToolMaterial.SAPPHIRE_SWORD);
		gorbiteSword = new ItemModSword("gorbiteSword", "Gorbite Sword", JourneyToolMaterial.GORBITE_SWORD);
		orbaditeSword = new ItemModSword("orbaditeSword", "Orbadite Sword", JourneyToolMaterial.ORBADITE_SWORD);
		
		pedalSword = new ItemModSword("pedalSword", "Pedal Sword", JourneyToolMaterial.PEDAL_SWORD);
		withicBlade = new ItemModSword("withicBlade", "Withic Blade", JourneyToolMaterial.WITHIC_BLADE);
		reinforcedCrystalSword = new ItemModSword("reinforcedCrystalSword", "Reinforced Crystal Sword", JourneyToolMaterial.RE_CRYSTAL_SWORD);
		reinforcedStoneSword = new ItemModSword("reinforcedStoneSword", "Reinforced Stone Sword", JourneyToolMaterial.RE_STONE_SWORD);
		terralightBlade = new ItemModSword("terralightBlade", "Terralight Blade", JourneyToolMaterial.TERRALIGHT_BLADE);
		terranaSword = new ItemModSword("terranaSword", "Terrana Sword", JourneyToolMaterial.TERRANA_SWORD);
		terrolicaSword = new ItemNightvisionSword("terrolicaSword", "Terrolica Sword", JourneyToolMaterial.TERROLICA_SWORD);
		voliteSword = new ItemModSword("voliteSword", "Volite Sword", JourneyToolMaterial.VOLITE_SWORD);
		kingsSword = new ItemFireHealthSword("kingsSword", "Kings Sword", JourneyToolMaterial.KINGS_SWORD, 1);
		demonicSword = new ItemWitherSword("demonicSword", "Wither Sword", JourneyToolMaterial.DEMONIC_SWORD);
		vinestrandBlade = new ItemPoisionSword("vinestrandBlade", "Vinestrand Blade", JourneyToolMaterial.VINESTRAND_BLADE);
		darkPineSword = new ItemWitherSword("darkPineSword", "Dark Pine Sword", JourneyToolMaterial.DARK_PINE_SWORD);
		healersBlade = new ItemHealthSword("healersBlade", "Healers Blade", JourneyToolMaterial.HEALERS_BLADE, 1);
		terronicBlade = new ItemHealthSword("terronicBlade", "Terronic Blade", JourneyToolMaterial.TERRONIC_BLADE, 2);
		developerSword = new ItemModSword("developerSword", "Creative Sword", JourneyToolMaterial.DEVELOPER_SWORD).setCreativeTab(JourneyTabs.util);
		
		rockyBattleaxe = new ItemBattleAxe("rockyBattleaxe", "Rocky Battleaxe", JourneyToolMaterial.ROCKY_BATTLEAXE);
		crystalizedBattleaxe = new ItemBattleAxe("crystalizedBattleaxe", "Crystalized Battleaxe", JourneyToolMaterial.CRYSTAL_BATTLEAXE);
		backBiter = new ItemBattleAxe("backBiter", "Back Biter", JourneyToolMaterial.BACK_BITER); 
		dawnBreaker = new ItemBattleAxe("dawnBreaker", "Dawn Breaker", JourneyToolMaterial.DAWN_BREAKER);
		tempestBattleaxe = new ItemBattleAxe("tempestBattleaxe", "Tempest Battleaxe", JourneyToolMaterial.TEMPEST_BATTLEAXE);
		bronzedBattleaxe = new ItemBattleAxe("bronzedBattleaxe", "Bronzed Battleaxe", JourneyToolMaterial.BRONZED_BATTLEAXE);
		celestiteBattleaxe = new ItemBattleAxe("celestiteBattleaxe", "Celestite Battleaxe", JourneyToolMaterial.CELESTITE_BATTLEAXE);
		storumBattleaxe = new ItemBattleAxe("storumBattleaxe", "Storum Battleaxe", JourneyToolMaterial.STORUM_BATTLEAXE);
		celekiumBattleaxe = new ItemBattleAxe("celekiumBattleaxe", "Celekium Battleaxe", JourneyToolMaterial.CELEKIUM_BATTLEAXE);
		thunderbirdBattleaxe = new ItemBattleAxe("thunderbirdBattleaxe", "Thunderbird Battleaxe", JourneyToolMaterial.THUNDERBIRD_BATTLEAXE); 
		 
		staffOfCrystal = new ItemStaff("staffOfCrystal", "Staff of Crystal", 3, 1000, 10, false, EntityIceBall.class);
		staffOfDivineStone = new ItemStaff("staffOfDivineStone", "Staff of Divine Stone", 3, 1000, 9, false, EntityRock.class);
		staffOfHellstone = new ItemStaff("staffOfHellstone", "Staff of Hellstone", 3, 1000, 7, false, EntityHellstone.class);
		doomsBringer = new ItemStaff("doomsBringer", "Dooms Bringer", 3, 1000, 12, false, EntityDoomsBringer.class);
		conjuringStaff = new ItemStaff("conjuringStaff", "Conjuring Staff", 3, 1000, 18, false, EntityConjuring.class);
		staffOfEnlightenment = new ItemStaff("staffOfEnlightenment", "Staff Of Enlightenment", 3, 1000, 14, false, EntityEnlightenment.class);
		staffOfGreenpace = new ItemStaff("staffOfGreenpace", "Staff Of Greenpace", 3, 1000, 10, false, EntityGreenpace.class);
		wizardsStar = new ItemStaff("wizardsStar", "Wizards Star", 3, 1000, 5, false, EntityWizardsStar.class);
		teleportationStaff = new ItemTeleport("teleportationStaff", "Teleportation Staff");
		overgrownStaff = new ItemStaff("overgrownStaff", "Overgrown Staff", 3, 1000, 5, false, EntityOvergrown.class);
		fireWand = new ItemWand("fireWand", "Fire Wand", true, 5, 600, 5, false, EntityFireBall.class);
		iceWand = new ItemWand("iceWand", "Ice Wand", true, 5, 600, 5, false, EntityIceBall.class);
		lightningWand = new ItemWand("lightningWand", "Lightning Wand", true, 10, 600, 5, false, EntityLightningBall.class);
		
		flameBow = new FlameBow("flameBow", 3, 384);
		poisonBow = new PoisonBow("poisonBow", 3, 384);
		darknessBow = new DarknessBow("darknessBow", 3, 384);
		frozenBow = new FrozenBow("frozenBow", 3, 384);
		staringBow = new StaringBow("staringBow", 4, 456);
		deathPiercerBow = new DeathPiercerBow("deathPiercerBow", 6, 892);
		fusionBow = new FusionBow("fusionBow", 4, 456);
		springBow = new SpringBow("springBow", 5, 384);
		starlightBow = new StarlightBow("starlightBow", 6, 384);
		wastefulBow = new WastefulBow("wastefulBow", 5, 892);
		flamingBow = new FlamingBow("flamingBow", 4, 384);
		blazingBow = new BlazingBow("blazingBow", 4, 456);
		darkEnforcer = new DarkEnforcer("darkEnforcer", 4, 384);
		depthsBow = new DepthsBow("depthsBow", 4, 892);
		frostbittenBow = new FrostbittenBow("frostbittenBow", 4, 384);
		frostyBow = new FrostyBow("frostyBow", 4, 456);
		charredBow = new CharredBow("charredBow", 5, 384);
		fluffyBow = new FluffyBow("fluffyBow", 9, 892);
		golemBow = new GolemBow("golemBow", 7, 456);
		loggersBow = new LoggersBow("loggersBow", 6, 384);
		overgrownBow = new OvergrownBow("overgrownBow", 7, 384);
		overseerBow = new OverseerBow("overseerBow", 7, 384);
		woodlandBow = new WoodlandBow("woodlandBow", 7, 456);
		rocsWing = new RocsWing("rocsWing", 6, 892);
		scaleBow = new ScaleBow("scaleBow", 7, 456);
		mantleBow = new MantleBow("mantleBow", 5, 384);
		coreExpender = new CoreExpender("coreExpender", 6, 384);
		royalBow = new RoyalBow("royalBow", 5, 384);
		darkTerraBow = new DarkTerraBow("darkTerraBow", 5, 456);
		lavenderBow = new LavenderBow("lavenderBow", 6, 892);
		terralightBow = new TerralightBow("terralightBow", 7, 384);
		terrianBow = new TerrianBow("terrianBow", 6, 384);

		hammerCreative = new ItemCreativeHammer("hammerCreative", "Hammer of Creative Spellbinding", JourneyToolMaterial.CREATIVE, false, EntityLightningBall.class);
		earthenHammer = new ItemHammer("earthenHammer", "Earthen Hammer", JourneyToolMaterial.EARTHEN_HAMMER, false, EntityEarthen.class, 4, 4, 642);
		flamingHammer = new ItemHammer("flamingHammer", "Flaming Hammer", JourneyToolMaterial.FLAMING_HAMMER, false, EntityFireBall.class, 10, 4, 1230);
		nethicHammer = new ItemHammer("nethicHammer", "Nethic Hammer", JourneyToolMaterial.NETHIC_HAMMER, false, EntityFireBall.class, 8, 4, 825);
		withicHammer = new ItemHammer("withicHammer", "Withic Hammer", JourneyToolMaterial.WITHIC_HAMMER, false, EntityWithic.class, 9, 4, 1230);
		royalHammer = new ItemHammer("royalHammer", "Royal Hammer", JourneyToolMaterial.ROYAL_HAMMER, false, EntityFireBall.class, 12, 4, 1320);
		overgrownHammer = new ItemHammer("overgrownHammer", "Overgrown Hammer", JourneyToolMaterial.OVERGROWN_HAMMER, false, EntityOvergrown.class, 12, 4, 1320);
		rockyHammer = new ItemHammer("rockyHammer", "Rocky Hammer", JourneyToolMaterial.ROCKY_HAMMER, false, EntityRock.class, 6, 4, 2230);
		crystalizedHammer = new ItemHammer("crystalizedHammer", "Crystalized Hammer", JourneyToolMaterial.CRYSTAL_HAMMER, false, EntityIceBall.class, 7, 4, 3320);

		chaosCannon = new ItemGun("chaosCannon", "Chaos Cannon", 6, "Shoots a bouncing projectile", null);
		rockLauncher = new ItemGun("rockLauncher", "Rock Launcher", 4, "Stuns mobs for 10 seconds", EntityRock.class);
		netherPlasma = new ItemGun("netherPlasma", "Nether Plasma", 10, "Burns mobs for 10 seconds", EntityNetherPlasma.class);
		oceanPlasma = new ItemGun("oceanPlasma", "Ocean Plasma", 4, "Harms mobs", EntityFloroWater.class);
		forestPlasma = new ItemGun("forestPlasma", "Forest Plasma", 4, "Poisons Mobs for 10 seconds", EntityOvergrown.class);
		eyeBlaster = new ItemGun("eyeBlaster", "Eye Blaster", 12, "Harms and burns mobs for 10 seconds", EntityEyeBlaster.class);
		
		demonicBomb = new ItemThrowable("demonicBomb", "Demonic Bomb", 4F, EntityDemonicBomb.class);
		fireBomb = new ItemThrowable("fireBomb", "Fire Bomb", 6F, EntityFireBomb.class);

		boilingPiercer = new ItemPiercer("boilingPiercer", "Boiling Piercer", 15F, 4, EntityBoilingPiercer.class);
		nethicPiercer = new ItemPiercer("nethicPiercer", "Nethic Piercer", 11F, 3, EntityNethicPiercer.class);
		frozenPiercer = new ItemPiercer("frozenPiercer", "Frozen Piercer", 9F, 2, EntityFrozenPiercer.class);
		eucaPiercer = new ItemPiercer("eucaPiercer", "Euca Piercer", 14F, 4, EntityEucaPiercer.class);
		depthsPiercer = new ItemPiercer("depthsPiercer", "Depths Piercer", 18F, 5, EntityDepthsPiercer.class);
		corbaPiercer = new ItemPiercer("corbaPiercer", "Corba Piercer", 20F, 6, EntityCorbaPiercer.class);
		frostbittenPiercer = new ItemPiercer("frostbittenPiercer", "Frostbitten Piercer", 12F, 2, EntityFrostbittenPiercer.class);
		frostyPiercer = new ItemPiercer("frostyPiercer", "Frosty Piercer", 10F, 2, EntityFrostyPiercer.class);
		sunsetPiercer = new ItemPiercer("sunsetPiercer", "Sunset Piercer", 7F, 1, EntitySunsetPiercer.class);
		skyPiercer = new ItemPiercer("skyPiercer", "Sky Piercer", 29F, 6, EntitySkyPiercer.class);

		moltenKnife = new ItemThrowableArrow("moltenKnife", "Molten Knife", 10F, 5, EntityMoltenKnife.class);
		//aquaticKnife = new ItemThrowableArrow("aquaticKnife", "Aquatic Knife", 6F, 5, EntityAquaticKnife.class);
	//	bloodKnife = new ItemThrowableArrow("bloodKnife", "Blood Knife", 6F, 5, EntityBloodKnife.class);
		//charredKnife = new ItemThrowableArrow("charredKnife", "Charred Knife", 6F, 5, EntityCharredKnife.class);
		//sizzlingKnife = new ItemThrowableArrow("sizzlingKnife", "Sizzling Knife", 6F, 5, EntitySizzlingKnife.class);
		
	}
}