package net.journey.items.interactive;

import java.util.List;

import net.journey.client.ItemDescription;
import net.journey.client.server.EssenceProvider;
import net.journey.client.server.IEssence;
import net.journey.entity.projectile.piercer.EntityEssenceShuriken;
import net.journey.init.JourneyTabs;
import net.journey.util.PotionEffects;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemMod;

public class ItemCursedTomb extends ItemMod {

	public ItemCursedTomb(String name, String f) {
		super(name, f);
		setCreativeTab(JourneyTabs.WEAPONS);
		setMaxDamage(32);
		setMaxStackSize(1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
		ItemStack stack = player.getHeldItem(handIn);
		IEssence mana = player.getCapability(EssenceProvider.ESSENCE_CAP, null);		
		try {
			if(mana.useEssence(3)) {
				if(!world.isRemote) {
					player.addPotionEffect(PotionEffects.setPotionEffect(PotionEffects.levitate, 100, 1));
					stack.damageItem(1, player);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(handIn));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack i, World worldIn, List<String> l, ITooltipFlag flagIn) {
		l.add("Levitates user for 5 seconds");
		l.add("Uses 3 Essence");
		l.add(i.getMaxDamage() - i.getItemDamage() + SlayerAPI.Colour.DARK_GREEN + " Uses remaining");
	}
}