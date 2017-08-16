package fr.eagle_fire78.addons.init;

import com.pam.harvestcraft.ItemRegistry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CraftingMod {

	public static void registerCraft() {
		
		GameRegistry.addRecipe(new ItemStack(ItemsMod.turtlePamsUpgrade), new Object[]{
				"HWH",
				"WLW",
				"HDH",
				'W', new ItemStack(Blocks.wool, 1, 0),
				'H', Items.iron_hoe,
				'D', new ItemStack(Items.dye, 1, 2),
				'L', Items.leather
		});
		
		GameRegistry.addRecipe(new ItemStack(ItemsMod.turtlePamsUpgrade), new Object[]{
				" B ",
				"SPS",
				" S ",
				'B', Items.bucket,
				'S', ItemRegistry.saltItem,
				'P', ItemRegistry.potItem
		});
		
	}
	
}
