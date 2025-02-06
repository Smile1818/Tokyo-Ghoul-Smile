package net.mcreator.ghoul.procedure;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureAttakRise1 extends ElementsGhoul.ModElement {
	public ProcedureAttakRise1(ElementsGhoul instance) {
		super(instance, 115);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AttakRise1!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure AttakRise1!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure AttakRise1!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure AttakRise1!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AttakRise1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
				? ((EntityPlayerMP) entity).getAdvancements()
						.getProgress(((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("ghoul:rise"))).isDone()
				: false)) {
			entity.setPositionAndUpdate(
					((entity.world
							.rayTraceBlocks(entity.getPositionEyes(1f),
									entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 4, entity.getLook(1f).y * 4,
											entity.getLook(1f).z * 4),
									false, false, true)
							.getBlockPos().getX()) + 0),
					((entity.world
							.rayTraceBlocks(entity.getPositionEyes(1f),
									entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 2, entity.getLook(1f).y * 2,
											entity.getLook(1f).z * 2),
									false, false, true)
							.getBlockPos().getY()) + 0),
					((entity.world.rayTraceBlocks(entity.getPositionEyes(1f),
							entity.getPositionEyes(1f).addVector(entity.getLook(1f).x * 4, entity.getLook(1f).y * 4, entity.getLook(1f).z * 4), false,
							false, true).getBlockPos().getZ()) + 0));
			if (!world.isRemote) {
				world.createExplosion(null, (int) x, (int) y, (int) z, (float) 0.2, true);
			}
			if ((!(entity instanceof EntityPlayer))) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 15);
			}
		}
	}
}
