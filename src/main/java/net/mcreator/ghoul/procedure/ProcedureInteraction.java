package net.mcreator.ghoul.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.gui.GuiGuiNPCccg1;
import net.mcreator.ghoul.GhoulVariables;
import net.mcreator.ghoul.Ghoul;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureInteraction extends ElementsGhoul.ModElement {
	public ProcedureInteraction(ElementsGhoul instance) {
		super(instance, 237);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Interaction!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Interaction!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Interaction!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Interaction!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Interaction!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((GhoulVariables.MapVariables.get(world).Gui_ccg_open1) == (true))) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).openGui(Ghoul.instance, GuiGuiNPCccg1.GUIID, world, x, y, z);
		}
	}
}
