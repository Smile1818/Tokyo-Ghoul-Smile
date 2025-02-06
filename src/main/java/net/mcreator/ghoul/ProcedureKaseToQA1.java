package net.mcreator.ghoul.procedure;

import net.minecraft.util.EnumHand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.item.ItemQA1;
import net.mcreator.ghoul.item.ItemAK1;
import net.mcreator.ghoul.ElementsGhoul;

import java.util.Random;

@ElementsGhoul.ModElement.Tag
public class ProcedureKaseToQA1 extends ElementsGhoul.ModElement {
	public ProcedureKaseToQA1(ElementsGhoul instance) {
		super(instance, 92);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure KaseToQA1!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure KaseToQA1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity instanceof EntityLivingBase) {
			ItemStack _setstack = new ItemStack(ItemQA1.block, (int) (1));
			_setstack.setCount(1);
			((EntityLivingBase) entity).setHeldItem(EnumHand.MAIN_HAND, _setstack);
			if (entity instanceof EntityPlayerMP)
				((EntityPlayerMP) entity).inventory.markDirty();
		}
		if ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(ItemQA1.block, (int) (1)).getItem())) {
			if (itemstack.attemptDamageItem((int) ((itemstack).hasTagCompound() ? (itemstack).getTagCompound().getDouble("QA1") : -1), new Random(),
					null)) {
				itemstack.shrink(1);
				itemstack.setItemDamage(0);
			}
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemAK1.block, (int) (1)).getItem(), -1, (int) 1, null);
		}
	}
}
