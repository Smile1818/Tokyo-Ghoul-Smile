package net.mcreator.ghoul.procedure;

import net.minecraft.util.EnumHand;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.item.ItemKase4;
import net.mcreator.ghoul.item.ItemCustomQuinque2;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureQ4ToKase extends ElementsGhoul.ModElement {
	public ProcedureQ4ToKase(ElementsGhoul instance) {
		super(instance, 132);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Q4ToKase!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure Q4ToKase!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		{
			ItemStack _stack = (itemstack);
			if (!_stack.hasTagCompound())
				_stack.setTagCompound(new NBTTagCompound());
			_stack.getTagCompound().setDouble("TagQ4", (itemstack.getItemDamage()));
		}
		if (entity instanceof EntityLivingBase) {
			ItemStack _setstack = new ItemStack(ItemKase4.block, (int) (1));
			_setstack.setCount(1);
			((EntityLivingBase) entity).setHeldItem(EnumHand.MAIN_HAND, _setstack);
			if (entity instanceof EntityPlayerMP)
				((EntityPlayerMP) entity).inventory.markDirty();
		}
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemCustomQuinque2.block, (int) (1)).getItem(), -1, (int) 1, null);
	}
}
