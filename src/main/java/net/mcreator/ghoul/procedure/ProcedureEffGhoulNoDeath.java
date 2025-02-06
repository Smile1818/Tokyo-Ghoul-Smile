package net.mcreator.ghoul.procedure;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.potion.PotionCCG;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureEffGhoulNoDeath extends ElementsGhoul.ModElement {
	public ProcedureEffGhoulNoDeath(ElementsGhoul instance) {
		super(instance, 106);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure EffGhoulNoDeath!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure EffGhoulNoDeath!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if ((entity instanceof EntityPlayer)) {
			if (((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
					? ((EntityPlayerMP) entity).getAdvancements()
							.getProgress(((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("ghoul:halhghoul")))
							.isDone()
					: false)
					&& (((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
							? ((EntityPlayerMP) entity).getAdvancements()
									.getProgress(((WorldServer) entity.world).getAdvancementManager()
											.getAdvancement(new ResourceLocation("ghoul:gurmanadv")))
									.isDone()
							: false))) {
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("world", world);
					ProcedureHalfGhoulEffKoukaku.executeProcedure($_dependencies);
				}
			}
			if (((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
					? ((EntityPlayerMP) entity).getAdvancements()
							.getProgress(((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("ghoul:halhghoul")))
							.isDone()
					: false)
					&& (((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
							? ((EntityPlayerMP) entity).getAdvancements()
									.getProgress(((WorldServer) entity.world).getAdvancementManager()
											.getAdvancement(new ResourceLocation("ghoul:advtoka")))
									.isDone()
							: false))) {
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("world", world);
					ProcedureHalhGhoulEffUkaku.executeProcedure($_dependencies);
				}
			}
			if (((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
					? ((EntityPlayerMP) entity).getAdvancements()
							.getProgress(((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("ghoul:halhghoul")))
							.isDone()
					: false)
					&& (((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
							? ((EntityPlayerMP) entity).getAdvancements()
									.getProgress(
											((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("ghoul:rise")))
									.isDone()
							: false))) {
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("world", world);
					ProcedureHalhGhoulEffRinkaku.executeProcedure($_dependencies);
				}
			}
			if (((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
					? ((EntityPlayerMP) entity).getAdvancements()
							.getProgress(((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("ghoul:halhghoul")))
							.isDone()
					: false)
					&& (((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
							? ((EntityPlayerMP) entity).getAdvancements()
									.getProgress(((WorldServer) entity.world).getAdvancementManager()
											.getAdvancement(new ResourceLocation("ghoul:customkaguneadv")))
									.isDone()
							: false))) {
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("world", world);
					ProcedureHalhGhoulEff2.executeProcedure($_dependencies);
				}
			}
			if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
					? ((EntityPlayerMP) entity).getAdvancements()
							.getProgress(((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("ghoul:rise")))
							.isDone()
					: false)) {
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("world", world);
					ProcedureGui.executeProcedure($_dependencies);
				}
			}
			if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
					? ((EntityPlayerMP) entity).getAdvancements()
							.getProgress(((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("ghoul:advtoka")))
							.isDone()
					: false)) {
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("world", world);
					ProcedureToka.executeProcedure($_dependencies);
				}
			}
			if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
					? ((EntityPlayerMP) entity).getAdvancements()
							.getProgress(((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("ghoul:gurmanadv")))
							.isDone()
					: false)) {
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("world", world);
					ProcedureGurmanKey.executeProcedure($_dependencies);
				}
			}
			if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
					? ((EntityPlayerMP) entity).getAdvancements()
							.getProgress(((WorldServer) entity.world).getAdvancementManager()
									.getAdvancement(new ResourceLocation("ghoul:customkaguneadv")))
							.isDone()
					: false)) {
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("world", world);
					ProcedureCustomKaguneKey.executeProcedure($_dependencies);
				}
			}
			if ((((entity instanceof EntityPlayerMP) && (entity.world instanceof WorldServer))
					? ((EntityPlayerMP) entity).getAdvancements()
							.getProgress(((WorldServer) entity.world).getAdvancementManager().getAdvancement(new ResourceLocation("ghoul:ccgadv")))
							.isDone()
					: false)) {
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureCCGEff1.executeProcedure($_dependencies);
				}
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionCCG.potion, (int) 999999999, (int) 0, (false), (false)));
			}
		}
	}

	@SubscribeEvent
	public void onEntitySpawned(EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();
		int i = (int) entity.posX;
		int j = (int) entity.posY;
		int k = (int) entity.posZ;
		World world = event.getWorld();
		java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
