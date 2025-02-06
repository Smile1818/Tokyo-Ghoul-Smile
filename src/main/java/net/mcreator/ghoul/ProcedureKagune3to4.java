package net.mcreator.ghoul.procedure;

import net.minecraft.util.EnumHand;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.item.ItemKagune4;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureKagune3to4 extends ElementsGhoul.ModElement {
	public ProcedureKagune3to4(ElementsGhoul instance) {
		super(instance, 165);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Kagune3to4!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer) {
			Scoreboard _sc = ((EntityPlayer) entity).getWorldScoreboard();
			ScoreObjective _so = _sc.getObjective("Time");
			if (_so == null) {
				_so = _sc.addScoreObjective("Time", ScoreCriteria.DUMMY);
			}
			Score _scr = _sc.getOrCreateScore(((EntityPlayer) entity).getGameProfile().getName(), _so);
			_scr.setScorePoints((int) ((new Object() {
				public int getScore(String score) {
					if (entity instanceof EntityPlayer) {
						Scoreboard _sc = ((EntityPlayer) entity).getWorldScoreboard();
						ScoreObjective _so = _sc.getObjective(score);
						if (_so != null) {
							Score _scr = _sc.getOrCreateScore(((EntityPlayer) entity).getGameProfile().getName(), _so);
							return _scr.getScorePoints();
						}
					}
					return 0;
				}
			}.getScore("Time")) + 2));
		}
		if (((new Object() {
			public int getScore(String score) {
				if (entity instanceof EntityPlayer) {
					Scoreboard _sc = ((EntityPlayer) entity).getWorldScoreboard();
					ScoreObjective _so = _sc.getObjective(score);
					if (_so != null) {
						Score _scr = _sc.getOrCreateScore(((EntityPlayer) entity).getGameProfile().getName(), _so);
						return _scr.getScorePoints();
					}
				}
				return 0;
			}
		}.getScore("Time")) >= 20)) {
			if (entity instanceof EntityLivingBase) {
				ItemStack _setstack = new ItemStack(ItemKagune4.block, (int) (1));
				_setstack.setCount(1);
				((EntityLivingBase) entity).setHeldItem(EnumHand.MAIN_HAND, _setstack);
				if (entity instanceof EntityPlayerMP)
					((EntityPlayerMP) entity).inventory.markDirty();
			}
		}
	}
}
