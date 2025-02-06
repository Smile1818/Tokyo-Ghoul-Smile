package net.mcreator.ghoul.procedure;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Score;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ProcedureUseKommand1 extends ElementsGhoul.ModElement {
	public ProcedureUseKommand1(ElementsGhoul instance) {
		super(instance, 125);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure UseKommand1!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure UseKommand1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityPlayer && !world.isRemote) {
			((EntityPlayer) entity).sendStatusMessage(new TextComponentString(
					(("(\u0415\u0441\u043B\u0438 0 \u0442\u043E \u041B\u0435\u0432\u044B\u0439, \u0415\u0441\u043B\u0438 1 \u0442\u043E \u041F\u0440\u0430\u0432\u044B\u0439 )\u0413\u043B\u0430\u0437:")
							+ "" + ((new Object() {
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
							}.getScore("eye"))))),
					(false));
		}
	}
}
