
package net.mcreator.ghoul.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;

import net.mcreator.ghoul.procedure.ProcedureKk13toFinal;
import net.mcreator.ghoul.ElementsGhoul;

@ElementsGhoul.ModElement.Tag
public class ItemKaguneKen10V1 extends ElementsGhoul.ModElement {
	@GameRegistry.ObjectHolder("ghoul:kaguneken10v1")
	public static final Item block = null;
	public ItemKaguneKen10V1(ElementsGhoul instance) {
		super(instance, 176);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("ghoul:kaguneken10v1", "inventory"));
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			setMaxDamage(0);
			maxStackSize = 64;
			setUnlocalizedName("kaguneken10v1");
			setRegistryName("kaguneken10v1");
			setCreativeTab(null);
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
			return 1F;
		}

		@Override
		public void onUpdate(ItemStack itemstack, World world, Entity entity, int slot, boolean par5) {
			super.onUpdate(itemstack, world, entity, slot, par5);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			if (entity instanceof EntityLivingBase && ((EntityLivingBase) entity).getHeldItemMainhand().equals(itemstack)) {
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureKk13toFinal.executeProcedure($_dependencies);
			}
		}
	}
}
