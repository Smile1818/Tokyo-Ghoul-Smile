package net.mcreator.ghoul.procedure;

import net.minecraft.util.EnumHand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.item.ItemQuinque2;
import net.mcreator.ghoul.item.ItemKase1;
import net.mcreator.ghoul.ElementsGhoul;

import java.util.Random;

@ElementsGhoul.ModElement.Tag
public class ProcedureKaseToQ2 extends ElementsGhoul.ModElement {
	public ProcedureKaseToQ2(ElementsGhoul instance) {
		super(instance, 119);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure KaseToQ2!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure KaseToQ2!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity instanceof EntityLivingBase) {
			ItemStack _setstack = new ItemStack(ItemQuinque2.block, (int) (1));
			_setstack.setCount(1);
			((EntityLivingBase) entity).setHeldItem(EnumHand.MAIN_HAND, _setstack);
			if (entity instanceof EntityPlayerMP)
				((EntityPlayerMP) entity).inventory.markDirty();
		}
		if (itemstack.attemptDamageItem((int) ((itemstack).hasTagCompound() ? (itemstack).getTagCompound().getDouble("TagQ2") : -1), new Random(),
				null)) {
			itemstack.shrink(1);
			itemstack.setItemDamage(0);
		}
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemKase1.block, (int) (1)).getItem(), -1, (int) 1, null);
	}
}
