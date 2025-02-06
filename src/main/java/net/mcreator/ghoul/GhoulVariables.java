package net.mcreator.ghoul;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.ByteBufUtils;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.client.Minecraft;

public class GhoulVariables {
	public static class MapVariables extends WorldSavedData {
		public static final String DATA_NAME = "ghoul_mapvars";
		public double RC = 0;
		public double Points = 0;
		public double Speed = 0;
		public double Sila = 0;
		public double hp = 0;
		public String KaguneType = "";
		public double CCGXP = 0;
		public String Rang = "";
		public double Eye = 0;
		public boolean Attak_Rize_1 = false;
		public boolean Halh_Ghoul = false;
		public double There = 0;
		public boolean Use_Kagune = false;
		public double Kakuja = 0;
		public double Ghoul_Type = 0;
		public boolean Player_Join = false;
		public double timerPlant = 0;
		public double water = 0;
		public double TimeAnim = 0;
		public String KaguneName = "";
		public boolean PlayerCCG = false;
		public boolean Gui_ccg_open1 = false;
		public boolean xDel = false;
		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void readFromNBT(NBTTagCompound nbt) {
			RC = nbt.getDouble("RC");
			Points = nbt.getDouble("Points");
			Speed = nbt.getDouble("Speed");
			Sila = nbt.getDouble("Sila");
			hp = nbt.getDouble("hp");
			KaguneType = nbt.getString("KaguneType");
			CCGXP = nbt.getDouble("CCGXP");
			Rang = nbt.getString("Rang");
			Eye = nbt.getDouble("Eye");
			Attak_Rize_1 = nbt.getBoolean("Attak_Rize_1");
			Halh_Ghoul = nbt.getBoolean("Halh_Ghoul");
			There = nbt.getDouble("There");
			Use_Kagune = nbt.getBoolean("Use_Kagune");
			Kakuja = nbt.getDouble("Kakuja");
			Ghoul_Type = nbt.getDouble("Ghoul_Type");
			Player_Join = nbt.getBoolean("Player_Join");
			timerPlant = nbt.getDouble("timerPlant");
			water = nbt.getDouble("water");
			TimeAnim = nbt.getDouble("TimeAnim");
			KaguneName = nbt.getString("KaguneName");
			PlayerCCG = nbt.getBoolean("PlayerCCG");
			Gui_ccg_open1 = nbt.getBoolean("Gui_ccg_open1");
			xDel = nbt.getBoolean("xDel");
		}

		@Override
		public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
			nbt.setDouble("RC", RC);
			nbt.setDouble("Points", Points);
			nbt.setDouble("Speed", Speed);
			nbt.setDouble("Sila", Sila);
			nbt.setDouble("hp", hp);
			nbt.setString("KaguneType", KaguneType);
			nbt.setDouble("CCGXP", CCGXP);
			nbt.setString("Rang", Rang);
			nbt.setDouble("Eye", Eye);
			nbt.setBoolean("Attak_Rize_1", Attak_Rize_1);
			nbt.setBoolean("Halh_Ghoul", Halh_Ghoul);
			nbt.setDouble("There", There);
			nbt.setBoolean("Use_Kagune", Use_Kagune);
			nbt.setDouble("Kakuja", Kakuja);
			nbt.setDouble("Ghoul_Type", Ghoul_Type);
			nbt.setBoolean("Player_Join", Player_Join);
			nbt.setDouble("timerPlant", timerPlant);
			nbt.setDouble("water", water);
			nbt.setDouble("TimeAnim", TimeAnim);
			nbt.setString("KaguneName", KaguneName);
			nbt.setBoolean("PlayerCCG", PlayerCCG);
			nbt.setBoolean("Gui_ccg_open1", Gui_ccg_open1);
			nbt.setBoolean("xDel", xDel);
			return nbt;
		}

		public void syncData(World world) {
			this.markDirty();
			if (world.isRemote) {
				Ghoul.PACKET_HANDLER.sendToServer(new WorldSavedDataSyncMessage(0, this));
			} else {
				Ghoul.PACKET_HANDLER.sendToAll(new WorldSavedDataSyncMessage(0, this));
			}
		}

		public static MapVariables get(World world) {
			MapVariables instance = (MapVariables) world.getMapStorage().getOrLoadData(MapVariables.class, DATA_NAME);
			if (instance == null) {
				instance = new MapVariables();
				world.getMapStorage().setData(DATA_NAME, instance);
			}
			return instance;
		}
	}

	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "ghoul_worldvars";
		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void readFromNBT(NBTTagCompound nbt) {
		}

		@Override
		public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
			return nbt;
		}

		public void syncData(World world) {
			this.markDirty();
			if (world.isRemote) {
				Ghoul.PACKET_HANDLER.sendToServer(new WorldSavedDataSyncMessage(1, this));
			} else {
				Ghoul.PACKET_HANDLER.sendToDimension(new WorldSavedDataSyncMessage(1, this), world.provider.getDimension());
			}
		}

		public static WorldVariables get(World world) {
			WorldVariables instance = (WorldVariables) world.getPerWorldStorage().getOrLoadData(WorldVariables.class, DATA_NAME);
			if (instance == null) {
				instance = new WorldVariables();
				world.getPerWorldStorage().setData(DATA_NAME, instance);
			}
			return instance;
		}
	}

	public static class WorldSavedDataSyncMessageHandler implements IMessageHandler<WorldSavedDataSyncMessage, IMessage> {
		@Override
		public IMessage onMessage(WorldSavedDataSyncMessage message, MessageContext context) {
			if (context.side == Side.SERVER)
				context.getServerHandler().player.getServerWorld()
						.addScheduledTask(() -> syncData(message, context, context.getServerHandler().player.world));
			else
				Minecraft.getMinecraft().addScheduledTask(() -> syncData(message, context, Minecraft.getMinecraft().player.world));
			return null;
		}

		private void syncData(WorldSavedDataSyncMessage message, MessageContext context, World world) {
			if (context.side == Side.SERVER) {
				message.data.markDirty();
				if (message.type == 0)
					Ghoul.PACKET_HANDLER.sendToAll(message);
				else
					Ghoul.PACKET_HANDLER.sendToDimension(message, world.provider.getDimension());
			}
			if (message.type == 0) {
				world.getMapStorage().setData(MapVariables.DATA_NAME, message.data);
			} else {
				world.getPerWorldStorage().setData(WorldVariables.DATA_NAME, message.data);
			}
		}
	}

	public static class WorldSavedDataSyncMessage implements IMessage {
		public int type;
		public WorldSavedData data;
		public WorldSavedDataSyncMessage() {
		}

		public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		@Override
		public void toBytes(io.netty.buffer.ByteBuf buf) {
			buf.writeInt(this.type);
			ByteBufUtils.writeTag(buf, this.data.writeToNBT(new NBTTagCompound()));
		}

		@Override
		public void fromBytes(io.netty.buffer.ByteBuf buf) {
			this.type = buf.readInt();
			if (this.type == 0)
				this.data = new MapVariables();
			else
				this.data = new WorldVariables();
			this.data.readFromNBT(ByteBufUtils.readTag(buf));
		}
	}
}
