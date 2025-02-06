
package net.mcreator.ghoul.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.ghoul.item.ItemKoffe2;
import net.mcreator.ghoul.block.BlockKoffePlant;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class RecipeKoffine extends ElementsGhoul.ModElement {
	public RecipeKoffine(ElementsGhoul instance) {
		super(instance, 147);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockKoffePlant.block, (int) (1)), new ItemStack(ItemKoffe2.block, (int) (1)), 1F);
	}
}
