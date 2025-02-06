package net.mcreator.ghoul.procedure;

import net.minecraft.world.World;
import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.potion.PotionEffGhoul;
import net.mcreator.ghoul.potion.PotionCCG;
import net.mcreator.ghoul.gui.GuiMenuLevelsCCG;
import net.mcreator.ghoul.gui.GuiMenuLevels;
import net.mcreator.ghoul.Ghoul;
import net.mcreator.ghoul.ElementsGhoul;

import java.util.Collection;

@ElementsGhoul.ModElement.Tag
public class ProcedureGuiRCVar extends ElementsGhoul.ModElement {
	public ProcedureGuiRCVar(ElementsGhoul instance) {
		super(instance, 101);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GuiRCVar!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure GuiRCVar!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure GuiRCVar!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure GuiRCVar!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure GuiRCVar!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((new Object() {
			boolean check() {
				if (entity instanceof EntityLivingBase) {
					Collection<PotionEffect> effects = ((EntityLivingBase) entity).getActivePotionEffects();
					for (PotionEffect effect : effects) {
						if (effect.getPotion() == PotionEffGhoul.potion)
							return true;
					}
				}
				return false;
			}
		}.check())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).openGui(Ghoul.instance, GuiMenuLevels.GUIID, world, x, y, z);
		}
		if ((new Object() {
			boolean check() {
				if (entity instanceof EntityLivingBase) {
					Collection<PotionEffect> effects = ((EntityLivingBase) entity).getActivePotionEffects();
					for (PotionEffect effect : effects) {
						if (effect.getPotion() == PotionCCG.potion)
							return true;
					}
				}
				return false;
			}
		}.check())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).openGui(Ghoul.instance, GuiMenuLevelsCCG.GUIID, world, x, y, z);
		}
	}
}
