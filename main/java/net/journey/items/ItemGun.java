package net.journey.items;

import java.util.List;

import net.journey.JourneyItems;
import net.journey.JourneySounds;
import net.journey.JourneyTabs;
import net.journey.client.server.EssenceProvider;
import net.journey.client.server.IEssence;
import net.journey.entity.projectile.EntityBasicProjectile;
import net.journey.entity.projectile.EntityBouncingProjectile;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemMod;

public class ItemGun extends ItemMod {

	public int damage;
	protected Class<? extends EntityBasicProjectile> projectile; 
	public String ability;
	public ItemGun(String name, String f, int damage, String ability, Class<? extends EntityBasicProjectile> projectile) {
		super(name, f, JourneyTabs.weapons);
		this.ability = ability;
		this.projectile = projectile;
		this.damage = damage;
		setMaxStackSize(1);
		setMaxDamage(500);
		setFull3D();
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
		IEssence mana = player.getCapability(EssenceProvider.ESSENCE_CAP, null);
		ItemStack stack = player.getHeldItem(handIn);
		if(!world.isRemote) {
			if(this == JourneyItems.chaosCannon) {
				if(mana.useEssence(2)) {
					System.out.println(player);
					System.out.println(mana.getEssenceValue());
					JourneySounds.playSound(JourneySounds.CANNON, world, player);
					EntityBouncingProjectile bouncing = new EntityBouncingProjectile(world, player, damage, 4);
					bouncing.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.0F, 1.0F);
					world.spawnEntity(bouncing);
					stack.damageItem(1, player);
					return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
				}
			} else if(projectile != null) {
				JourneySounds.playSound(JourneySounds.PLASMA, world, player);
				if(mana.useEssence(2)) {
					try {
						EntityBasicProjectile shoot = projectile.getConstructor(World.class, EntityLivingBase.class, float.class).newInstance(world, player, damage);
						shoot.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
						world.spawnEntity(shoot);
						stack.damageItem(1, player);
						return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return new ActionResult<ItemStack>(EnumActionResult.PASS, stack);	
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack i, World worldIn, List<String> l, ITooltipFlag flagIn) {
		l.add("Infinite ammo");
		l.add("Uses 2 Essence");
		l.add(SlayerAPI.Colour.GOLD + "Ability: " + ability);
		l.add(SlayerAPI.Colour.AQUA + "Damage: " + damage + " ranged damage");
		l.add(i.getMaxDamage() - i.getItemDamage() + SlayerAPI.Colour.DARK_GREEN + " Uses remaining");
	}
}