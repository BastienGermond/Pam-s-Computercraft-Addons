package fr.eagle_fire78.addons;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TestBlock extends Block {

	public TestBlock() {
		
		super(Material.rock);
		setBlockName("TestBlock");
		setBlockTextureName("pamsaddons:testblock");
		setHardness(0.5F);
	    setCreativeTab(Main.tab);
		
	}


}
