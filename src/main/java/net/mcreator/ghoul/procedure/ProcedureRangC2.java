package net.mcreator.ghoul.procedure;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.ghoul.GhoulVariables;
import net.mcreator.ghoul.ElementsGhoul;

import java.util.Iterator;

@ElementsGhoul.ModElement.Tag
public class ProcedureRangC2 extends ElementsGhoul.ModElement {
	public ProcedureRangC2(ElementsGhoul instance) {
		super(instance, 78);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure RangC2!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure RangC2!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if ((entity instanceof EntityPlayer)) {
			if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
					? ((EntityPlayerMP) entity).getAdvancements()
							.getProgress(
									((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("ghoul:welcomeghoul")))
							.isDone()
					: false)) {
				if (((GhoulVariables.MapVariables.get(world).RC) >= 10)) {
					if (entity instanceof EntityPlayerMP) {
						Advancement _adv = ((MinecraftServer) ((EntityPlayerMP) entity).mcServer).getAdvancementManager()
								.getAdvancement(new ResourceLocation("ghoul:ghoulcrang"));
						AdvancementProgress _ap = ((EntityPlayerMP) entity).getAdvancements().getProgress(_adv);
						if (!_ap.isDone()) {
							Iterator _iterator = _ap.getRemaningCriteria().iterator();
							while (_iterator.hasNext()) {
								String _criterion = (String) _iterator.next();
								((EntityPlayerMP) entity).getAdvancements().grantCriterion(_adv, _criterion);
							}
						}
					}
					GhoulVariables.MapVariables.get(world).Rang = (String) "C";
					GhoulVariables.MapVariables.get(world).syncData(world);
				}
			}
			if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
					? ((EntityPlayerMP) entity).getAdvancements()
							.getProgress(((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("ghoul:ccgadv")))
							.isDone()
					: false)) {
				if (((GhoulVariables.MapVariables.get(world).RC) >= 10)) {
					if (entity instanceof EntityPlayerMP) {
						Advancement _adv = ((MinecraftServer) ((EntityPlayerMP) entity).mcServer).getAdvancementManager()
								.getAdvancement(new ResourceLocation("ghoul:ccgrangc"));
						AdvancementProgress _ap = ((EntityPlayerMP) entity).getAdvancements().getProgress(_adv);
						if (!_ap.isDone()) {
							Iterator _iterator = _ap.getRemaningCriteria().iterator();
							while (_iterator.hasNext()) {
								String _criterion = (String) _iterator.next();
								((EntityPlayerMP) entity).getAdvancements().grantCriterion(_adv, _criterion);
							}
						}
					}
					GhoulVariables.MapVariables.get(world).Rang = (String) "C";
					GhoulVariables.MapVariables.get(world).syncData(world);
				}
			}
		}
	}
}
