package net.mcreator.ghoul.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumHand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.item.ItemShot;
import net.mcreator.ghoul.item.ItemKaguneToka;
import net.mcreator.ghoul.item.ItemKaguneKen1V1;
import net.mcreator.ghoul.item.ItemKagune0;
import net.mcreator.ghoul.item.ItemKagune;
import net.mcreator.ghoul.item.ItemGurmanAnim1v1;
import net.mcreator.ghoul.item.ItemGurman;
import net.mcreator.ghoul.item.ItemCustomKagune;
import net.mcreator.ghoul.item.ItemAnimToka1v1;
import net.mcreator.ghoul.GhoulVariables;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureKaguneKey extends ElementsGhoul.ModElement {
	public ProcedureKaguneKey(ElementsGhoul instance) {
		super(instance, 107);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure KaguneKey!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure KaguneKey!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (((GhoulVariables.MapVariables.get(world).Use_Kagune) == (true))) {
			if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
					? ((EntityPlayerMP) entity).getAdvancements()
							.getProgress(((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("ghoul:rise")))
							.isDone()
					: false)) {
				if (((entity instanceof EntityPlayer)
						? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(ItemKagune.block, (int) (1)))
						: false)) {
					if (entity instanceof EntityPlayer)
						((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemKagune.block, (int) (1)).getItem(), -1, (int) 1, null);
				} else {
					if (entity instanceof EntityLivingBase) {
						ItemStack _setstack = new ItemStack(ItemKaguneKen1V1.block, (int) (1));
						_setstack.setCount(1);
						((EntityLivingBase) entity).setHeldItem(EnumHand.MAIN_HAND, _setstack);
						if (entity instanceof EntityPlayerMP)
							((EntityPlayerMP) entity).inventory.markDirty();
					}
				}
			}
			if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
					? ((EntityPlayerMP) entity).getAdvancements()
							.getProgress(((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("ghoul:advtoka")))
							.isDone()
					: false)) {
				if (((entity instanceof EntityPlayer)
						? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(ItemKaguneToka.block, (int) (1)))
						: false)) {
					if (entity instanceof EntityPlayer)
						((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemKaguneToka.block, (int) (1)).getItem(), -1, (int) 1,
								null);
					if (entity instanceof EntityPlayer)
						((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemShot.block, (int) (1)).getItem(), -1, (int) 1000,
								null);
				} else {
					if (entity instanceof EntityLivingBase) {
						ItemStack _setstack = new ItemStack(ItemAnimToka1v1.block, (int) (1));
						_setstack.setCount(1);
						((EntityLivingBase) entity).setHeldItem(EnumHand.MAIN_HAND, _setstack);
						if (entity instanceof EntityPlayerMP)
							((EntityPlayerMP) entity).inventory.markDirty();
					}
					if (entity instanceof EntityPlayer) {
						ItemStack _setstack = new ItemStack(ItemShot.block, (int) (1));
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
					}
				}
			}
			if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
					? ((EntityPlayerMP) entity).getAdvancements()
							.getProgress(((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("ghoul:gurmanadv")))
							.isDone()
					: false)) {
				if (((entity instanceof EntityPlayer)
						? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(ItemGurman.block, (int) (1)))
						: false)) {
					if (entity instanceof EntityPlayer)
						((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemGurman.block, (int) (1)).getItem(), -1, (int) 1, null);
				} else {
					if (entity instanceof EntityLivingBase) {
						ItemStack _setstack = new ItemStack(ItemGurmanAnim1v1.block, (int) (1));
						_setstack.setCount(1);
						((EntityLivingBase) entity).setHeldItem(EnumHand.MAIN_HAND, _setstack);
						if (entity instanceof EntityPlayerMP)
							((EntityPlayerMP) entity).inventory.markDirty();
					}
				}
			}
			if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
					? ((EntityPlayerMP) entity).getAdvancements()
							.getProgress(((WorldServer) entity.world).getAdvancementManager()
									.getAdvancement(new ResourceLocation("ghoul:customkaguneadv")))
							.isDone()
					: false)) {
				if (((entity instanceof EntityPlayer)
						? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(ItemCustomKagune.block, (int) (1)))
						: false)) {
					if (entity instanceof EntityPlayer)
						((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemCustomKagune.block, (int) (1)).getItem(), -1, (int) 64,
								null);
				} else {
					if (entity instanceof EntityLivingBase) {
						ItemStack _setstack = new ItemStack(ItemKagune0.block, (int) (1));
						_setstack.setCount(1);
						((EntityLivingBase) entity).setHeldItem(EnumHand.MAIN_HAND, _setstack);
						if (entity instanceof EntityPlayerMP)
							((EntityPlayerMP) entity).inventory.markDirty();
					}
				}
			}
		}
	}
}
