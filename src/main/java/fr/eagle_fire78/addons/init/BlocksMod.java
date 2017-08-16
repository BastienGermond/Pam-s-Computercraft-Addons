package fr.eagle_fire78.addons.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.eagle_fire78.addons.Main;
import fr.eagle_fire78.addons.TestBlock;
import net.minecraft.block.Block;

public class BlocksMod {

	public static Block testBlock;
	
	public static void init(){
		
		testBlock = new TestBlock().setCreativeTab(Main.tab).setHardness(4.5F);
	
		registerBlocks();
		
	}
	
	public static void registerBlocks() {
		
		GameRegistry.registerBlock(testBlock, testBlock.getUnlocalizedName().substring(5));
		
	}
	
}
