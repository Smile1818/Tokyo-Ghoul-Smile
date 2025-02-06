package net.mcreator.ghoul.procedure;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.potion.PotionEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.init.MobEffects;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.potion.PotionEffGhoul;
import net.mcreator.ghoul.ElementsGhoul;

import java.util.Collection;

@ElementsGhoul.ModElement.Tag
public class ProcedureGhoulNotEat extends ElementsGhoul.ModElement {
	public ProcedureGhoulNotEat(ElementsGhoul instance) {
		super(instance, 63);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GhoulNotEat!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		boolean del = false;
		if ((new Object() {
			boolean check() {
				if (entity instanceof EntityLivingBase) {
					Collection<PotionEffect> effects = ((EntityLivingBase) entity).getActivePotionEffects();
					for (PotionEffect effect : effects) {
						if (effect.getPotion() == PotionEffGhoul.potion)
							return true;
					}
				}
				return false;
			}
		}.check())) {
			if (((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.APPLE, (int) (1)).getItem())
					|| ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == new ItemStack(Items.CARROT, (int) (1)).getItem())
							|| ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getItem() == new ItemStack(Items.MUSHROOM_STEW, (int) (1)).getItem())
									|| ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
											.getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem())
											|| ((((entity instanceof EntityLivingBase)
													? ((EntityLivingBase) entity).getHeldItemMainhand()
													: ItemStack.EMPTY).getItem() == new ItemStack(Items.CARROT, (int) (1)).getItem())
													|| ((((entity instanceof EntityLivingBase)
															? ((EntityLivingBase) entity).getHeldItemMainhand()
															: ItemStack.EMPTY).getItem() == new ItemStack(Items.PUMPKIN_PIE, (int) (1)).getItem())
															|| ((((entity instanceof EntityLivingBase)
																	? ((EntityLivingBase) entity).getHeldItemMainhand()
																	: ItemStack.EMPTY).getItem() == new ItemStack(Items.BAKED_POTATO, (int) (1))
																			.getItem())
																	|| ((((entity instanceof EntityLivingBase)
																			? ((EntityLivingBase) entity).getHeldItemMainhand()
																			: ItemStack.EMPTY).getItem() == new ItemStack(Items.POTATO, (int) (1))
																					.getItem())
																			|| ((((entity instanceof EntityLivingBase)
																					? ((EntityLivingBase) entity).getHeldItemMainhand()
																					: ItemStack.EMPTY).getItem() == new ItemStack(Items.GOLDEN_CARROT,
																							(int) (1)).getItem())
																					|| ((((entity instanceof EntityLivingBase)
																							? ((EntityLivingBase) entity).getHeldItemMainhand()
																							: ItemStack.EMPTY).getItem() == new ItemStack(Items.BREAD,
																									(int) (1)).getItem())
																							|| ((((entity instanceof EntityLivingBase)
																									? ((EntityLivingBase) entity)
																											.getHeldItemMainhand()
																									: ItemStack.EMPTY)
																											.getItem() == new ItemStack(Items.COOKIE,
																													(int) (1)).getItem())
																									|| ((((entity instanceof EntityLivingBase)
																											? ((EntityLivingBase) entity)
																													.getHeldItemMainhand()
																											: ItemStack.EMPTY)
																													.getItem() == new ItemStack(
																															Items.FISH, (int) (1), 0)
																																	.getItem())
																											|| ((((entity instanceof EntityLivingBase)
																													? ((EntityLivingBase) entity)
																															.getHeldItemMainhand()
																													: ItemStack.EMPTY)
																															.getItem() == new ItemStack(
																																	Items.FISH,
																																	(int) (1), 1)
																																			.getItem())
																													|| ((((entity instanceof EntityLivingBase)
																															? ((EntityLivingBase) entity)
																																	.getHeldItemMainhand()
																															: ItemStack.EMPTY)
																																	.getItem() == new ItemStack(
																																			Items.MELON,
																																			(int) (1))
																																					.getItem())
																															|| ((((entity instanceof EntityLivingBase)
																																	? ((EntityLivingBase) entity)
																																			.getHeldItemMainhand()
																																	: ItemStack.EMPTY)
																																			.getItem() == new ItemStack(
																																					Items.COOKED_FISH,
																																					(int) (1),
																																					0).getItem())
																																	|| ((((entity instanceof EntityLivingBase)
																																			? ((EntityLivingBase) entity)
																																					.getHeldItemMainhand()
																																			: ItemStack.EMPTY)
																																					.getItem() == new ItemStack(
																																							Items.COOKED_FISH,
																																							(int) (1),
																																							1).getItem())
																																			|| ((((entity instanceof EntityLivingBase)
																																					? ((EntityLivingBase) entity)
																																							.getHeldItemMainhand()
																																					: ItemStack.EMPTY)
																																							.getItem() == new ItemStack(
																																									Items.PORKCHOP,
																																									(int) (1))
																																											.getItem())
																																					|| ((((entity instanceof EntityLivingBase)
																																							? ((EntityLivingBase) entity)
																																									.getHeldItemMainhand()
																																							: ItemStack.EMPTY)
																																									.getItem() == new ItemStack(
																																											Items.COOKED_PORKCHOP,
																																											(int) (1))
																																													.getItem())
																																							|| ((((entity instanceof EntityLivingBase)
																																									? ((EntityLivingBase) entity)
																																											.getHeldItemMainhand()
																																									: ItemStack.EMPTY)
																																											.getItem() == new ItemStack(
																																													Items.BEEF,
																																													(int) (1))
																																															.getItem())
																																									|| ((((entity instanceof EntityLivingBase)
																																											? ((EntityLivingBase) entity)
																																													.getHeldItemMainhand()
																																											: ItemStack.EMPTY)
																																													.getItem() == new ItemStack(
																																															Items.COOKED_BEEF,
																																															(int) (1))
																																																	.getItem())
																																											|| ((((entity instanceof EntityLivingBase)
																																													? ((EntityLivingBase) entity)
																																															.getHeldItemMainhand()
																																													: ItemStack.EMPTY)
																																															.getItem() == new ItemStack(
																																																	Items.CHICKEN,
																																																	(int) (1))
																																																			.getItem())
																																													|| ((((entity instanceof EntityLivingBase)
																																															? ((EntityLivingBase) entity)
																																																	.getHeldItemMainhand()
																																															: ItemStack.EMPTY)
																																																	.getItem() == new ItemStack(
																																																			Items.COOKED_CHICKEN,
																																																			(int) (1))
																																																					.getItem())
																																															|| ((((entity instanceof EntityLivingBase)
																																																	? ((EntityLivingBase) entity)
																																																			.getHeldItemMainhand()
																																																	: ItemStack.EMPTY)
																																																			.getItem() == new ItemStack(
																																																					Items.RABBIT,
																																																					(int) (1))
																																																							.getItem())
																																																	|| ((((entity instanceof EntityLivingBase)
																																																			? ((EntityLivingBase) entity)
																																																					.getHeldItemMainhand()
																																																			: ItemStack.EMPTY)
																																																					.getItem() == new ItemStack(
																																																							Items.COOKED_RABBIT,
																																																							(int) (1))
																																																									.getItem())
																																																			|| ((((entity instanceof EntityLivingBase)
																																																					? ((EntityLivingBase) entity)
																																																							.getHeldItemMainhand()
																																																					: ItemStack.EMPTY)
																																																							.getItem() == new ItemStack(
																																																									Items.MUTTON,
																																																									(int) (1))
																																																											.getItem())
																																																					|| ((((entity instanceof EntityLivingBase)
																																																							? ((EntityLivingBase) entity)
																																																									.getHeldItemMainhand()
																																																							: ItemStack.EMPTY)
																																																									.getItem() == new ItemStack(
																																																											Items.COOKED_MUTTON,
																																																											(int) (1))
																																																													.getItem())
																																																							|| ((((entity instanceof EntityLivingBase)
																																																									? ((EntityLivingBase) entity)
																																																											.getHeldItemMainhand()
																																																									: ItemStack.EMPTY)
																																																											.getItem() == new ItemStack(
																																																													Items.BEETROOT,
																																																													(int) (1))
																																																															.getItem())
																																																									|| (((entity instanceof EntityLivingBase)
																																																											? ((EntityLivingBase) entity)
																																																													.getHeldItemMainhand()
																																																											: ItemStack.EMPTY)
																																																													.getItem() == new ItemStack(
																																																															Items.BEETROOT_SOUP,
																																																															(int) (1))
																																																																	.getItem()))))))))))))))))))))))))))))) {
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, (int) 300, (int) 1, (false), (false)));
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.HUNGER, (int) 300, (int) 1, (false), (false)));
			}
		}
	}

	@SubscribeEvent
	public void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		EntityPlayer entity = event.getEntityPlayer();
		int i = event.getPos().getX();
		int j = event.getPos().getY();
		int k = event.getPos().getZ();
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
