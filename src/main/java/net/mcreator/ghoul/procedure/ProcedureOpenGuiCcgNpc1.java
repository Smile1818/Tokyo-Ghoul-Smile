package net.mcreator.ghoul.procedure;

import net.minecraft.world.World;

import net.mcreator.ghoul.GhoulVariables;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureOpenGuiCcgNpc1 extends ElementsGhoul.ModElement {
	public ProcedureOpenGuiCcgNpc1(ElementsGhoul instance) {
		super(instance, 222);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure OpenGuiCcgNpc1!");
			return;
		}
		World world = (World) dependencies.get("world");
		GhoulVariables.MapVariables.get(world).Gui_ccg_open1 = (boolean) (true);
		GhoulVariables.MapVariables.get(world).syncData(world);
	}
}
