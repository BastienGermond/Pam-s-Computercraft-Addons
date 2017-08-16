package fr.eagle_fire78.addons;

import java.awt.Color;
import java.net.Socket;
import java.util.HashMap;

import org.squiddev.cctweaks.CCTweaks;
import org.squiddev.cctweaks.api.CCTweaksAPI;
import org.squiddev.cctweaks.api.lua.ILuaAPI;
import org.squiddev.cctweaks.api.lua.ILuaAPIFactory;
import org.squiddev.cctweaks.core.asm.TweaksLoadingPlugin.CCTweaksDummyMod;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dan200.computercraft.ComputerCraft;
import dan200.computercraft.api.ComputerCraftAPI;
import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.ILuaObject;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.core.computer.ComputerThread;
import dan200.computercraft.shared.computer.blocks.TileComputer;
import dan200.computercraft.shared.computer.core.ServerComputer;
import dan200.computercraft.shared.network.ComputerCraftPacket;
import fr.eagle_fire78.addons.init.BlocksMod;
import fr.eagle_fire78.addons.init.CraftingMod;
import fr.eagle_fire78.addons.init.ItemsMod;
import fr.eagle_fire78.addons.init.Turtles;
import fr.eagle_fire78.addons.proxy.CommonProxy;
import net.minecraft.client.model.ModelBat;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

@Mod(modid = "pamsaddons", name = "Pam's Addons", version = "1.0", dependencies = "required-after:ComputerCraft; after:harvestcraft", acceptableRemoteVersions = "*")
public class Main {
	
	@Instance("pamsaddons")
	public static Main instance;
	
	@SidedProxy(clientSide="fr.eagle_fire78.addons.proxy.ClientProxy", serverSide="fr.eagle_fire78.addons.prox.CommonProxy")
	public static CommonProxy proxy;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		System.out.println("Pre Init Addons ...");
		BlocksMod.init();
		ItemsMod.init();
		
	}
	
	public static CreativeTabs tab = new CreativeTabs("pamsaddons")
	{
	  public Item getTabIconItem()
	  {
	  	return ItemsMod.turtlePamsUpgrade;
	  }
	};
	


	@EventHandler
	public void init(FMLInitializationEvent event) {

		System.out.println("Init Pam's Addon ...");
		Turtles.register();
		CraftingMod.registerCraft();
		
	}


	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		
		
	}
	
}
