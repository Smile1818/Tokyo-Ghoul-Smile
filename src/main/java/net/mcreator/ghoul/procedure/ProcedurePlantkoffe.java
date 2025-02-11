package net.mcreator.ghoul.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

import net.mcreator.ghoul.block.BlockKoffePlant2;
import net.mcreator.ghoul.GhoulVariables;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedurePlantkoffe extends ElementsGhoul.ModElement {
	public ProcedurePlantkoffe(ElementsGhoul instance) {
		super(instance, 146);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Plantkoffe!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Plantkoffe!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Plantkoffe!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Plantkoffe!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((GhoulVariables.MapVariables.get(world).timerPlant) >= 200)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockKoffePlant2.block.getDefaultState(), 3);
		} else {
			GhoulVariables.MapVariables.get(world).timerPlant = (double) ((GhoulVariables.MapVariables.get(world).timerPlant) + 1);
			GhoulVariables.MapVariables.get(world).syncData(world);
		}
	}
}
