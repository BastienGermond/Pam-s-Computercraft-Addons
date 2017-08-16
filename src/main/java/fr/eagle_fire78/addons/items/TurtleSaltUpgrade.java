package fr.eagle_fire78.addons.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.eagle_fire78.addons.Main;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class TurtleSaltUpgrade extends Item {

	public IIcon[] icons;
	
	public TurtleSaltUpgrade() {
		
		super();
		setUnlocalizedName("TurtleSaltUpgrade");
		setTextureName("pamsaddons:turtlesaltupgrade");
		setCreativeTab(Main.tab);
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.icons = new IIcon[2];

		icons[0] = iconRegister.registerIcon("pamsaddons:turtlesaltupgrade");
		icons[1] = iconRegister.registerIcon("pamsaddons:turtlesaltupgrade-1");
		
		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) {
		
		if (meta == 0) return this.icons[0];
		
		return this.icons[1];
		
	}	
	
}
