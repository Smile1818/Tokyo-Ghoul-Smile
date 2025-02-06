package net.mcreator.ghoul.procedure;

import net.minecraft.world.World;

import net.mcreator.ghoul.GhoulVariables;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureRcxpp1 extends ElementsGhoul.ModElement {
	public ProcedureRcxpp1(ElementsGhoul instance) {
		super(instance, 84);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Rcxpp1!");
			return;
		}
		World world = (World) dependencies.get("world");
		GhoulVariables.MapVariables.get(world).RC = (double) ((GhoulVariables.MapVariables.get(world).RC) + 5);
		GhoulVariables.MapVariables.get(world).syncData(world);
	}
}
