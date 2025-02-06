package net.mcreator.ghoul.procedure;

import net.minecraft.world.World;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.GhoulVariables;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureOnClickStrenge2 extends ElementsGhoul.ModElement {
	public ProcedureOnClickStrenge2(ElementsGhoul instance) {
		super(instance, 144);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OnClickStrenge2!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure OnClickStrenge2!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (((GhoulVariables.MapVariables.get(world).Sila) >= 3)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, (int) 999999999, (int) 1, (false), (false)));
		}
		if (((GhoulVariables.MapVariables.get(world).Sila) >= 6)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, (int) 999999999, (int) 2, (false), (false)));
		}
		if (((GhoulVariables.MapVariables.get(world).Sila) >= 9)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, (int) 999999999, (int) 3, (false), (false)));
		}
		if (((GhoulVariables.MapVariables.get(world).Sila) >= 12)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, (int) 999999999, (int) 4, (false), (false)));
		}
		if (((GhoulVariables.MapVariables.get(world).Sila) >= 15)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, (int) 999999999, (int) 5, (false), (false)));
		}
		if (((GhoulVariables.MapVariables.get(world).Sila) >= 18)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, (int) 999999999, (int) 6, (false), (false)));
		}
		if (((GhoulVariables.MapVariables.get(world).Sila) >= 21)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, (int) 999999999, (int) 7, (false), (false)));
		}
		if (((GhoulVariables.MapVariables.get(world).Sila) >= 24)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, (int) 999999999, (int) 8, (false), (false)));
		}
		if (((GhoulVariables.MapVariables.get(world).Sila) >= 27)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, (int) 999999999, (int) 9, (false), (false)));
		}
		if (((GhoulVariables.MapVariables.get(world).Sila) >= 30)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, (int) 999999999, (int) 10, (false), (false)));
		}
	}
}
