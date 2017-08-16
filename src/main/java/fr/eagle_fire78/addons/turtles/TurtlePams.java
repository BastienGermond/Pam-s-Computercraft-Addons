package fr.eagle_fire78.addons.turtles;

import java.util.List;

import com.pam.harvestcraft.BlockPamCrop;
import com.pam.harvestcraft.BlockPamFruit;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.turtle.ITurtleAccess;
import dan200.computercraft.api.turtle.ITurtleUpgrade;
import dan200.computercraft.api.turtle.TurtleCommandResult;
import dan200.computercraft.api.turtle.TurtleSide;
import dan200.computercraft.api.turtle.TurtleUpgradeType;
import dan200.computercraft.api.turtle.TurtleVerb;
import fr.eagle_fire78.addons.init.ItemsMod;
import fr.eagle_fire78.addons.reference.Reference;
import fr.eagle_fire78.addons.util.TurtleUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCarrot;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockPotato;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class TurtlePams implements ITurtleUpgrade {

	private static final ItemStack item = new ItemStack(ItemsMod.turtlePamsUpgrade);
	
	@Override
	public int getUpgradeID() {
		
		return Reference.UPGRADE_PAMS;
	
	}

	@Override
	public String getUnlocalisedAdjective() {
		
		return "turtleUpgrade.pams";
		
	}

	@Override
	public TurtleUpgradeType getType() {

		return TurtleUpgradeType.Tool;
		
	}

	@Override
	public ItemStack getCraftingItem() {

		return item.copy();
		
	}

	@Override
	public IPeripheral createPeripheral(ITurtleAccess turtle, TurtleSide side) {
		
		return null;
		
	}
	
	@Override
	public TurtleCommandResult useTool(ITurtleAccess turtle, TurtleSide side, TurtleVerb verb, int direction) {
		
		switch (verb) {
		case Attack:
			
			return TurtleCommandResult.failure("No weapon to attack with");
		
		case Dig:
			
			ChunkCoordinates turtlePos = turtle.getPosition();
			World world = turtle.getWorld();
			
			int x = turtlePos.posX;
			int y = turtlePos.posY;
			int z = turtlePos.posZ;
			
			// Check block at coord :
			x += Facing.offsetsXForSide[direction];
			y += Facing.offsetsYForSide[direction];
			z += Facing.offsetsZForSide[direction];
			
			if (!world.isAirBlock(x, y, z)) {
				
				Block block = world.getBlock(x, y, z);
				
				// Fix issues with normal minecraft seed which drop always one seed whatever the state
				if (block instanceof BlockCarrot || block instanceof BlockPotato || block.getUnlocalizedName() == "tile.cropsh") {
					
					if (world.getBlockMetadata(x, y, z) < 7) {
						
						return TurtleCommandResult.failure("Not ripe");
						
					}
					
				}
				
				
				if (block instanceof BlockCrops) {
					
					BlockCrops crops = (BlockCrops) block;
						
					List<ItemStack> drops = crops.getDrops(world, x, y , z, world.getBlockMetadata(x, y, z), 0);
					
					if (drops.size() > 0) {
						
						TurtleUtil.addItemListToInv(drops, turtle);
						
						// Reset growth level
						world.setBlockMetadataWithNotify(x, y, z, 0, 2);
						
						return TurtleCommandResult.success();
						
					} else {
						
						return TurtleCommandResult.failure("Not ripe");
						
					}			
					
					
				} else if (block instanceof BlockPamFruit) {
					
					BlockPamFruit fruits = (BlockPamFruit) block;
					
					if (world.getBlockMetadata(x, y, z) == 2) {
					
						List<ItemStack> drops = fruits.getDrops(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
											
						TurtleUtil.addItemListToInv(drops, turtle);
						
						// Reset growth level
						world.setBlockMetadataWithNotify(x, y, z, 0, 2);
						
						return TurtleCommandResult.success();
						
					} else {
						
						return TurtleCommandResult.failure("Not ripe");
						
					}
						
				} else {
					
					return TurtleCommandResult.failure("Can't harvest with this tool");
					
				}
				
			} else {

				return TurtleCommandResult.failure("Can't harvest air. Sorry :/");
				
			}
			
		// should never happen
		default:
			
			return TurtleCommandResult.failure("An unknown error has occurred, please tell the mod author or not because support is anoying :D");
			
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(ITurtleAccess turtle, TurtleSide side) {

		return item.getItem().getIconFromDamage(0);

	}

	@Override
	public void update(ITurtleAccess turtle, TurtleSide side) {
		
		
		
	}

}
