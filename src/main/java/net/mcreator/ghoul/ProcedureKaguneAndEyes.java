package net.mcreator.ghoul.procedure;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.item.ItemKaguneToka;
import net.mcreator.ghoul.item.ItemKagune;
import net.mcreator.ghoul.item.ItemHalhGhoulEyeR;
import net.mcreator.ghoul.item.ItemHalhGhoulEyeL;
import net.mcreator.ghoul.item.ItemGurman;
import net.mcreator.ghoul.item.ItemEyesghoul1;
import net.mcreator.ghoul.item.ItemCustomKagune;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureKaguneAndEyes extends ElementsGhoul.ModElement {
	public ProcedureKaguneAndEyes(ElementsGhoul instance) {
		super(instance, 99);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure KaguneAndEyes!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(ItemKagune.block, (int) (1)).getItem())
				|| ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(ItemKaguneToka.block, (int) (1)).getItem())
						|| ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
								.getItem() == new ItemStack(ItemGurman.block, (int) (1)).getItem())
								|| (((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
										.getItem() == new ItemStack(ItemCustomKagune.block, (int) (1)).getItem()))))) {
			if (entity instanceof EntityPlayer) {
				((EntityPlayer) entity).inventory.armorInventory.set(3, new ItemStack(ItemEyesghoul1.helmet, (int) (1)));
				if (entity instanceof EntityPlayerMP)
					((EntityPlayerMP) entity).inventory.markDirty();
			}
			/* @ItemStack */} else {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemHalhGhoulEyeL.helmet, (int) (1)).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemEyesghoul1.helmet, (int) (1)).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemHalhGhoulEyeR.helmet, (int) (1)).getItem(), -1, (int) 1, null);
		}
	}
}
