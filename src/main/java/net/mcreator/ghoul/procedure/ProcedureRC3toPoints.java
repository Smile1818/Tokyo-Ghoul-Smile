package net.mcreator.ghoul.procedure;

import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.GhoulVariables;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureRC3toPoints extends ElementsGhoul.ModElement {
	public ProcedureRC3toPoints(ElementsGhoul instance) {
		super(instance, 103);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure RC3toPoints!");
			return;
		}
		World world = (World) dependencies.get("world");
		if (((GhoulVariables.MapVariables.get(world).There) >= 3)) {
			GhoulVariables.MapVariables.get(world).Points = (double) ((GhoulVariables.MapVariables.get(world).Points) + 1);
			GhoulVariables.MapVariables.get(world).syncData(world);
			GhoulVariables.MapVariables.get(world).There = (double) ((GhoulVariables.MapVariables.get(world).There) - 3);
			GhoulVariables.MapVariables.get(world).syncData(world);
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			int i = (int) entity.posX;
			int j = (int) entity.posY;
			int k = (int) entity.posZ;
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
