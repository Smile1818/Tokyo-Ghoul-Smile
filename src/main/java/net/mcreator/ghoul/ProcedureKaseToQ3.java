package net.mcreator.ghoul.procedure;

import net.minecraft.util.EnumHand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.item.ItemKase3;
import net.mcreator.ghoul.item.ItemCustomQuinque;
import net.mcreator.ghoul.ElementsGhoul;

import java.util.Random;

@ElementsGhoul.ModElement.Tag
public class ProcedureKaseToQ3 extends ElementsGhoul.ModElement {
	public ProcedureKaseToQ3(ElementsGhoul instance) {
		super(instance, 129);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure KaseToQ3!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure KaseToQ3!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity instanceof EntityLivingBase) {
			ItemStack _setstack = new ItemStack(ItemCustomQuinque.block, (int) (1));
			_setstack.setCount(1);
			((EntityLivingBase) entity).setHeldItem(EnumHand.MAIN_HAND, _setstack);
			if (entity instanceof EntityPlayerMP)
				((EntityPlayerMP) entity).inventory.markDirty();
		}
		if (itemstack.attemptDamageItem((int) ((itemstack).hasTagCompound() ? (itemstack).getTagCompound().getDouble("TagQ3") : -1), new Random(),
				null)) {
			itemstack.shrink(1);
			itemstack.setItemDamage(0);
		}
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemKase3.block, (int) (1)).getItem(), -1, (int) 1, null);
	}
}
