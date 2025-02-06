
package net.mcreator.ghoul.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;

import net.mcreator.ghoul.creativetab.TabTokyoGhoul;
import net.mcreator.ghoul.ElementsGhoul;

import java.util.List;

import com.google.common.collect.Multimap;

@ElementsGhoul.ModElement.Tag
public class ItemKakune extends ElementsGhoul.ModElement {
	@GameRegistry.ObjectHolder("ghoul:kakune")
	public static final Item block = null;
	public ItemKakune(ElementsGhoul instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("ghoul:kakune", "inventory"));
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			setMaxDamage(0);
			maxStackSize = 1;
			setUnlocalizedName("kakune");
			setRegistryName("kakune");
			setCreativeTab(TabTokyoGhoul.tab);
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getMaxItemUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
			return 1.5F;
		}

		@Override
		public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot slot) {
			Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(slot);
			if (slot == EntityEquipmentSlot.MAINHAND) {
				multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
						new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Item modifier", (double) 6, 0));
				multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Item modifier", -2.4, 0));
			}
			return multimap;
		}

		@Override
		public boolean canHarvestBlock(IBlockState state, ItemStack stack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add("Kakune!");
		}
	}
}
