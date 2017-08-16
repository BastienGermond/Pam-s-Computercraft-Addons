package fr.eagle_fire78.addons.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.eagle_fire78.addons.items.TurtlePamsUpgrade;
import fr.eagle_fire78.addons.items.TurtleSaltUpgrade;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemsMod {

	public static Item turtlePamsUpgrade;
	public static Item turtleSaltUpgrade;
	
	public static void init(){
		
		turtlePamsUpgrade = new TurtlePamsUpgrade();
		turtleSaltUpgrade = new TurtleSaltUpgrade();
		
		registerItems();
		
	}
	
	public static void registerItems() {
		
		GameRegistry.registerItem(turtlePamsUpgrade, turtlePamsUpgrade.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(turtleSaltUpgrade, turtleSaltUpgrade.getUnlocalizedName().substring(5));
	
	}
	
}
