package net.mcreator.ghoul.procedure;

import net.minecraft.world.World;

import net.mcreator.ghoul.GhoulVariables;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureDelitee extends ElementsGhoul.ModElement {
	public ProcedureDelitee(ElementsGhoul instance) {
		super(instance, 239);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Delitee!");
			return;
		}
		World world = (World) dependencies.get("world");
		if (((GhoulVariables.MapVariables.get(world).Gui_ccg_open1) == (true))) {
			GhoulVariables.MapVariables.get(world).Gui_ccg_open1 = (boolean) (false);
			GhoulVariables.MapVariables.get(world).syncData(world);
		}
		if (((GhoulVariables.MapVariables.get(world).Gui_ccg_open1) == (true))) {
			GhoulVariables.MapVariables.get(world).Gui_ccg_open1 = (boolean) (false);
			GhoulVariables.MapVariables.get(world).syncData(world);
		}
	}
}
