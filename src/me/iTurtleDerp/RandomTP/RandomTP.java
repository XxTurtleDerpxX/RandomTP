package me.iTurtleDerp.RandomTP;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomTP extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		getLogger().info("RandomTP Enabling");
	}

	@Override
	public void onDisable()
	{
		getLogger().info("RandomTP Disabling");
	}

	public boolean onCommand(CommandSender theSender, Command cmd, String commandLabel, String[] args)
	{
		Player player = (Player) theSender;
		
		if(commandLabel.equalsIgnoreCase("randomtp"))
		{
			if(player.hasPermission("randomtp.tp"))
			{			
			int randomX = (int) (Math.random() * 1000);
			int randomZ = (int) (Math.random() * 1000);
			int randomY = player.getWorld().getHighestBlockYAt(randomX, randomZ);
			
			Location randomLocation = new Location(player.getWorld(), randomX, randomY, randomZ);
			player.teleport(randomLocation);
			player.sendMessage(ChatColor.GOLD + "You were teleported to X: " + randomX + "Y: " + randomY + "Z: " + randomZ);
			}
			else player.sendMessage(ChatColor.RED + "You don't have permission to randomly teleport!");
		}

		return true;
	}




	//<   >   <=   =>   !=   ==   %   +   -   /   *

	// || &&
}
