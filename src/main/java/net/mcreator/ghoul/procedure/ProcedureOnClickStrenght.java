package net.mcreator.ghoul.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.GhoulVariables;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureOnClickStrenght extends ElementsGhoul.ModElement {
	public ProcedureOnClickStrenght(ElementsGhoul instance) {
		super(instance, 104);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OnClickStrenght!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure OnClickStrenght!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (((GhoulVariables.MapVariables.get(world).Points) >= 1)) {
			GhoulVariables.MapVariables.get(world).Sila = (double) ((GhoulVariables.MapVariables.get(world).Sila) + 1);
			GhoulVariables.MapVariables.get(world).syncData(world);
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				ProcedureOnClickStrenge2.executeProcedure($_dependencies);
			}
			GhoulVariables.MapVariables.get(world).Points = (double) ((GhoulVariables.MapVariables.get(world).Points) - 1);
			GhoulVariables.MapVariables.get(world).syncData(world);
		}
	}
}
