package net.mcreator.ghoul.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.GhoulVariables;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureGhoulUseKagune extends ElementsGhoul.ModElement {
	public ProcedureGhoulUseKagune(ElementsGhoul instance) {
		super(instance, 136);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GhoulUseKagune!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure GhoulUseKagune!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (((GhoulVariables.MapVariables.get(world).Points) >= 3)) {
			GhoulVariables.MapVariables.get(world).Use_Kagune = (boolean) (true);
			GhoulVariables.MapVariables.get(world).syncData(world);
			GhoulVariables.MapVariables.get(world).Points = (double) ((GhoulVariables.MapVariables.get(world).Points) - 3);
			GhoulVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).closeScreen();
		}
	}
}
