
package net.mcreator.ghoul.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.ghoul.procedure.ProcedureQ2ToKase;
import net.mcreator.ghoul.creativetab.TabTokyoGhoul;
import net.mcreator.ghoul.ElementsGhoul;

import java.util.Set;
import java.util.HashMap;

import com.google.common.collect.Multimap;

@ElementsGhoul.ModElement.Tag
public class ItemQuinque2 extends ElementsGhoul.ModElement {
	@GameRegistry.ObjectHolder("ghoul:quinque2")
	public static final Item block = null;
	public ItemQuinque2(ElementsGhoul instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemSword(EnumHelper.addToolMaterial("QUINQUE2", 1, 500, 4f, 6f, 2)) {
			@Override
			public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot slot) {
				Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(slot);
				if (slot == EntityEquipmentSlot.MAINHAND) {
					multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
							new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double) this.getAttackDamage(), 0));
					multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(),
							new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4, 0));
				}
				return multimap;
			}

			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("sword", 1);
				return ret.keySet();
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {
				ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = retval.getResult();
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("itemstack", itemstack);
					ProcedureQ2ToKase.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setUnlocalizedName("quinque2").setRegistryName("quinque2").setCreativeTab(TabTokyoGhoul.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("ghoul:quinque2", "inventory"));
	}
}
