package net.mcreator.ghoul.procedure;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.gui.GuiGuiSkilsHalhGhoul2;
import net.mcreator.ghoul.gui.GuiGuiSkilsGhoul;
import net.mcreator.ghoul.gui.GuiGuiSkillsHalhGhoul;
import net.mcreator.ghoul.GhoulVariables;
import net.mcreator.ghoul.Ghoul;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureOpenSkils extends ElementsGhoul.ModElement {
	public ProcedureOpenSkils(ElementsGhoul instance) {
		super(instance, 135);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OpenSkils!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure OpenSkils!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure OpenSkils!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure OpenSkils!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure OpenSkils!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
				? ((EntityPlayerMP) entity).getAdvancements()
						.getProgress(((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("ghoul:halhghoul")))
						.isDone()
				: false)) {
			if (((GhoulVariables.MapVariables.get(world).Use_Kagune) == (false))) {
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).openGui(Ghoul.instance, GuiGuiSkillsHalhGhoul.GUIID, world, x, y, z);
			}
			if (((GhoulVariables.MapVariables.get(world).Use_Kagune) == (true))) {
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).openGui(Ghoul.instance, GuiGuiSkilsHalhGhoul2.GUIID, world, x, y, z);
			}
		}
		if ((!(((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
				? ((EntityPlayerMP) entity).getAdvancements()
						.getProgress(((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("ghoul:halhghoul")))
						.isDone()
				: false))) {
			if (((GhoulVariables.MapVariables.get(world).Use_Kagune) == (false))) {
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).openGui(Ghoul.instance, GuiGuiSkilsGhoul.GUIID, world, x, y, z);
			}
			if (((GhoulVariables.MapVariables.get(world).Use_Kagune) == (true))) {
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).openGui(Ghoul.instance, GuiGuiSkilsHalhGhoul2.GUIID, world, x, y, z);
			}
		}
	}
}
