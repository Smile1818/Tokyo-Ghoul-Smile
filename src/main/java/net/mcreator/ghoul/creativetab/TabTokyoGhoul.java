
package net.mcreator.ghoul.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.ghoul.item.ItemKakune;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class TabTokyoGhoul extends ElementsGhoul.ModElement {
	public TabTokyoGhoul(ElementsGhoul instance) {
		super(instance, 60);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabtokyoghoul") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemKakune.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
