package net.mcreator.ghoul.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.GhoulVariables;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureOnClickYes extends ElementsGhoul.ModElement {
	public ProcedureOnClickYes(ElementsGhoul instance) {
		super(instance, 224);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OnClickYes!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure OnClickYes!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		GhoulVariables.MapVariables.get(world).Gui_ccg_open1 = (boolean) (false);
		GhoulVariables.MapVariables.get(world).syncData(world);
		{
			java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
			$_dependencies.put("entity", entity);
			$_dependencies.put("world", world);
			ProcedureCCGEff2.executeProcedure($_dependencies);
		}
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).closeScreen();
	}
}
