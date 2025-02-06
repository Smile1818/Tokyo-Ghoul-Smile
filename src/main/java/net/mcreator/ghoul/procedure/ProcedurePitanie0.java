package net.mcreator.ghoul.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.potion.PotionEffGhoul;
import net.mcreator.ghoul.ElementsGhoul;

import java.util.Collection;

@ElementsGhoul.ModElement.Tag
public class ProcedurePitanie0 extends ElementsGhoul.ModElement {
	public ProcedurePitanie0(ElementsGhoul instance) {
		super(instance, 71);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Pitanie0!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof EntityPlayer) && (new Object() {
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
		}.check()))) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedurePitanie.executeProcedure($_dependencies);
			}
		}
	}
}
