package net.mcreator.ghoul.procedure;

import net.minecraft.world.World;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.GhoulVariables;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureOnClickSpeed2 extends ElementsGhoul.ModElement {
	public ProcedureOnClickSpeed2(ElementsGhoul instance) {
		super(instance, 143);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OnClickSpeed2!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure OnClickSpeed2!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (((GhoulVariables.MapVariables.get(world).Speed) >= 3)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SPEED, (int) 999999999, (int) 1, (false), (false)));
		}
		if (((GhoulVariables.MapVariables.get(world).Speed) >= 6)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SPEED, (int) 999999999, (int) 2, (false), (false)));
		}
		if (((GhoulVariables.MapVariables.get(world).Speed) >= 9)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SPEED, (int) 999999999, (int) 3, (false), (false)));
		}
		if (((GhoulVariables.MapVariables.get(world).Speed) >= 12)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SPEED, (int) 999999999, (int) 4, (false), (false)));
		}
		if (((GhoulVariables.MapVariables.get(world).Speed) >= 15)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SPEED, (int) 999999999, (int) 5, (false), (false)));
		}
		if (((GhoulVariables.MapVariables.get(world).Speed) >= 18)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SPEED, (int) 999999999, (int) 6, (false), (false)));
		}
		if (((GhoulVariables.MapVariables.get(world).Speed) >= 21)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SPEED, (int) 999999999, (int) 7, (false), (false)));
		}
		if (((GhoulVariables.MapVariables.get(world).Speed) >= 24)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SPEED, (int) 999999999, (int) 8, (false), (false)));
		}
		if (((GhoulVariables.MapVariables.get(world).Speed) >= 27)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SPEED, (int) 999999999, (int) 9, (false), (false)));
		}
		if (((GhoulVariables.MapVariables.get(world).Speed) >= 30)) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SPEED, (int) 999999999, (int) 10, (false), (false)));
		}
	}
}
