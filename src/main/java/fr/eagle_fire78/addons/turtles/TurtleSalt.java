package fr.eagle_fire78.addons.turtles;

import com.pam.harvestcraft.BlockPamSink;
import com.pam.harvestcraft.ItemRegistry;

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
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class TurtleSalt implements ITurtleUpgrade {

	private static final ItemStack item = new ItemStack(ItemsMod.turtleSaltUpgrade);
	
	@Override
	public int getUpgradeID() {

		return Reference.UPGRADE_SALT;
		
	}

	@Override
	public String getUnlocalisedAdjective() {

		return "turtleUpgrade.salt";
		
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
			
			x += Facing.offsetsXForSide[direction];
			y += Facing.offsetsYForSide[direction];
			z += Facing.offsetsZForSide[direction];
			
			Block block = world.getBlock(x, y, z);
			
			if (block instanceof BlockPamSink) {
				
				TurtleUtil.addToInv(turtle, new ItemStack(ItemRegistry.saltItem));
				
				return TurtleCommandResult.success();
				
			} else if (block instanceof BlockStaticLiquid) {
				
				world.setBlockToAir(x, y, z);
				
				TurtleUtil.addToInv(turtle, new ItemStack(ItemRegistry.saltItem));
				
				return TurtleCommandResult.success();
				
			} else {
				
				return TurtleCommandResult.failure("No sink or water in this direction");
				
			}
			
		default:
			
			return TurtleCommandResult.failure("An unknown error has occurred, please tell the mod author or not because support is anoying :D");
			
		}
		
	}

	@Override
	public IIcon getIcon(ITurtleAccess turtle, TurtleSide side) {

		return item.getItem().getIconFromDamage(1);
		
	}

	@Override
	public void update(ITurtleAccess turtle, TurtleSide side) {
		
	}

}
