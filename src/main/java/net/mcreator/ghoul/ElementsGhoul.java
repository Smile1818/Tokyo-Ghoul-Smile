/*
 *    MCreator note:
 *
 *    This file is autogenerated to connect all MCreator mod elements together.
 *
 */
package net.mcreator.ghoul;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.discovery.ASMDataTable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Potion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.Block;

import net.mcreator.ghoul.gui.GuiMenuLevelsCCG;
import net.mcreator.ghoul.gui.GuiMenuLevels;
import net.mcreator.ghoul.gui.GuiKoffeGui;
import net.mcreator.ghoul.gui.GuiGuiSkilsHalhGhoul2;
import net.mcreator.ghoul.gui.GuiGuiSkilsGhoul;
import net.mcreator.ghoul.gui.GuiGuiSkillsHalhGhoul;
import net.mcreator.ghoul.gui.GuiGuiNPCccg1;
import net.mcreator.ghoul.gui.GuiGuiCreator;
import net.mcreator.ghoul.gui.GuiGUIMed;
import net.mcreator.ghoul.gui.GuiGUI1;

import java.util.function.Supplier;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

public class ElementsGhoul implements IFuelHandler, IWorldGenerator {
	public final List<ModElement> elements = new ArrayList<>();
	public final List<Supplier<Block>> blocks = new ArrayList<>();
	public final List<Supplier<Item>> items = new ArrayList<>();
	public final List<Supplier<Biome>> biomes = new ArrayList<>();
	public final List<Supplier<EntityEntry>> entities = new ArrayList<>();
	public final List<Supplier<Potion>> potions = new ArrayList<>();
	public static Map<ResourceLocation, net.minecraft.util.SoundEvent> sounds = new HashMap<>();
	public ElementsGhoul() {
	}

	public void preInit(FMLPreInitializationEvent event) {
		try {
			for (ASMDataTable.ASMData asmData : event.getAsmData().getAll(ModElement.Tag.class.getName())) {
				Class<?> clazz = Class.forName(asmData.getClassName());
				if (clazz.getSuperclass() == ElementsGhoul.ModElement.class)
					elements.add((ElementsGhoul.ModElement) clazz.getConstructor(this.getClass()).newInstance(this));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(elements);
		elements.forEach(ElementsGhoul.ModElement::initElements);
		this.addNetworkMessage(GhoulVariables.WorldSavedDataSyncMessageHandler.class, GhoulVariables.WorldSavedDataSyncMessage.class, Side.SERVER,
				Side.CLIENT);
	}

	public void registerSounds(RegistryEvent.Register<net.minecraft.util.SoundEvent> event) {
		for (Map.Entry<ResourceLocation, net.minecraft.util.SoundEvent> sound : sounds.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator cg, IChunkProvider cp) {
		elements.forEach(element -> element.generateWorld(random, chunkX * 16, chunkZ * 16, world, world.provider.getDimension(), cg, cp));
	}

	@Override
	public int getBurnTime(ItemStack fuel) {
		for (ModElement element : elements) {
			int ret = element.addFuel(fuel);
			if (ret != 0)
				return ret;
		}
		return 0;
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.player.world.isRemote) {
			WorldSavedData mapdata = GhoulVariables.MapVariables.get(event.player.world);
			WorldSavedData worlddata = GhoulVariables.WorldVariables.get(event.player.world);
			if (mapdata != null)
				Ghoul.PACKET_HANDLER.sendTo(new GhoulVariables.WorldSavedDataSyncMessage(0, mapdata), (EntityPlayerMP) event.player);
			if (worlddata != null)
				Ghoul.PACKET_HANDLER.sendTo(new GhoulVariables.WorldSavedDataSyncMessage(1, worlddata), (EntityPlayerMP) event.player);
		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.player.world.isRemote) {
			WorldSavedData worlddata = GhoulVariables.WorldVariables.get(event.player.world);
			if (worlddata != null)
				Ghoul.PACKET_HANDLER.sendTo(new GhoulVariables.WorldSavedDataSyncMessage(1, worlddata), (EntityPlayerMP) event.player);
		}
	}
	private int messageID = 0;
	public <T extends IMessage, V extends IMessage> void addNetworkMessage(Class<? extends IMessageHandler<T, V>> handler, Class<T> messageClass,
			Side... sides) {
		for (Side side : sides)
			Ghoul.PACKET_HANDLER.registerMessage(handler, messageClass, messageID, side);
		messageID++;
	}
	public static class GuiHandler implements IGuiHandler {
		@Override
		public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			if (id == GuiGUI1.GUIID)
				return new GuiGUI1.GuiContainerMod(world, x, y, z, player);
			if (id == GuiGuiCreator.GUIID)
				return new GuiGuiCreator.GuiContainerMod(world, x, y, z, player);
			if (id == GuiMenuLevels.GUIID)
				return new GuiMenuLevels.GuiContainerMod(world, x, y, z, player);
			if (id == GuiMenuLevelsCCG.GUIID)
				return new GuiMenuLevelsCCG.GuiContainerMod(world, x, y, z, player);
			if (id == GuiGUIMed.GUIID)
				return new GuiGUIMed.GuiContainerMod(world, x, y, z, player);
			if (id == GuiGuiSkillsHalhGhoul.GUIID)
				return new GuiGuiSkillsHalhGhoul.GuiContainerMod(world, x, y, z, player);
			if (id == GuiGuiSkilsHalhGhoul2.GUIID)
				return new GuiGuiSkilsHalhGhoul2.GuiContainerMod(world, x, y, z, player);
			if (id == GuiGuiSkilsGhoul.GUIID)
				return new GuiGuiSkilsGhoul.GuiContainerMod(world, x, y, z, player);
			if (id == GuiKoffeGui.GUIID)
				return new GuiKoffeGui.GuiContainerMod(world, x, y, z, player);
			if (id == GuiGuiNPCccg1.GUIID)
				return new GuiGuiNPCccg1.GuiContainerMod(world, x, y, z, player);
			return null;
		}

		@Override
		public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			if (id == GuiGUI1.GUIID)
				return new GuiGUI1.GuiWindow(world, x, y, z, player);
			if (id == GuiGuiCreator.GUIID)
				return new GuiGuiCreator.GuiWindow(world, x, y, z, player);
			if (id == GuiMenuLevels.GUIID)
				return new GuiMenuLevels.GuiWindow(world, x, y, z, player);
			if (id == GuiMenuLevelsCCG.GUIID)
				return new GuiMenuLevelsCCG.GuiWindow(world, x, y, z, player);
			if (id == GuiGUIMed.GUIID)
				return new GuiGUIMed.GuiWindow(world, x, y, z, player);
			if (id == GuiGuiSkillsHalhGhoul.GUIID)
				return new GuiGuiSkillsHalhGhoul.GuiWindow(world, x, y, z, player);
			if (id == GuiGuiSkilsHalhGhoul2.GUIID)
				return new GuiGuiSkilsHalhGhoul2.GuiWindow(world, x, y, z, player);
			if (id == GuiGuiSkilsGhoul.GUIID)
				return new GuiGuiSkilsGhoul.GuiWindow(world, x, y, z, player);
			if (id == GuiKoffeGui.GUIID)
				return new GuiKoffeGui.GuiWindow(world, x, y, z, player);
			if (id == GuiGuiNPCccg1.GUIID)
				return new GuiGuiNPCccg1.GuiWindow(world, x, y, z, player);
			return null;
		}
	}
	public List<ModElement> getElements() {
		return elements;
	}

	public List<Supplier<Block>> getBlocks() {
		return blocks;
	}

	public List<Supplier<Item>> getItems() {
		return items;
	}

	public List<Supplier<Biome>> getBiomes() {
		return biomes;
	}

	public List<Supplier<EntityEntry>> getEntities() {
		return entities;
	}

	public List<Supplier<Potion>> getPotions() {
		return potions;
	}
	public static class ModElement implements Comparable<ModElement> {
		@Retention(RetentionPolicy.RUNTIME)
		public @interface Tag {
		}
		protected final ElementsGhoul elements;
		protected final int sortid;
		public ModElement(ElementsGhoul elements, int sortid) {
			this.elements = elements;
			this.sortid = sortid;
		}

		public void initElements() {
		}

		public void init(FMLInitializationEvent event) {
		}

		public void preInit(FMLPreInitializationEvent event) {
		}

		public void generateWorld(Random random, int posX, int posZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		}

		public void serverLoad(FMLServerStartingEvent event) {
		}

		public void registerModels(ModelRegistryEvent event) {
		}

		public int addFuel(ItemStack fuel) {
			return 0;
		}

		@Override
		public int compareTo(ModElement other) {
			return this.sortid - other.sortid;
		}
	}
}
