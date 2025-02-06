package net.mcreator.ghoul.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.GhoulVariables;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureOnClickHealth extends ElementsGhoul.ModElement {
	public ProcedureOnClickHealth(ElementsGhoul instance) {
		super(instance, 105);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OnClickHealth!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure OnClickHealth!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (((GhoulVariables.MapVariables.get(world).Points) >= 1)) {
			GhoulVariables.MapVariables.get(world).hp = (double) ((GhoulVariables.MapVariables.get(world).hp) + 1);
			GhoulVariables.MapVariables.get(world).syncData(world);
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				ProcedureOnClickHealth2.executeProcedure($_dependencies);
			}
			GhoulVariables.MapVariables.get(world).Points = (double) ((GhoulVariables.MapVariables.get(world).Points) - 1);
			GhoulVariables.MapVariables.get(world).syncData(world);
		}
	}
}
