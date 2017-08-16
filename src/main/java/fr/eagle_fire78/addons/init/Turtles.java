package fr.eagle_fire78.addons.init;

import java.util.ArrayList;

import dan200.computercraft.api.ComputerCraftAPI;
import fr.eagle_fire78.addons.reference.Reference;
import fr.eagle_fire78.addons.turtles.TurtlePams;
import fr.eagle_fire78.addons.turtles.TurtleSalt;

public class Turtles {

	public static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void register() {
		
		ComputerCraftAPI.registerTurtleUpgrade(new TurtlePams());
		list.add(Reference.UPGRADE_PAMS);
		
		ComputerCraftAPI.registerTurtleUpgrade(new TurtleSalt());
		list.add(Reference.UPGRADE_SALT);
		
	}
	
}
