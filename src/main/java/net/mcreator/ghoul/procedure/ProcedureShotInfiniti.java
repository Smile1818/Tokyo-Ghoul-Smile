package net.mcreator.ghoul.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.item.ItemShot;
import net.mcreator.ghoul.item.ItemKaguneToka;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureShotInfiniti extends ElementsGhoul.ModElement {
	public ProcedureShotInfiniti(ElementsGhoul instance) {
		super(instance, 53);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ShotInfiniti!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((new ItemStack(ItemKaguneToka.block, (int) (1))
				.getItem() == ((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem())) {
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemShot.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
		if ((new ItemStack(ItemKaguneToka.block, (int) (1))
				.getItem() == ((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem())) {
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemShot.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
	}
}
