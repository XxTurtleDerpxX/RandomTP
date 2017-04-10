package me.iTurtleDerp.RandomTP;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomTP extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		getLogger().info("RandomTP Enabled");
	}

	@Override
	public void onDisable()
	{
		getLogger().info("RandomTP Disabled");
	}

	public boolean onCommand(CommandSender theSender, Command cmd, String commandLabel, String[] args)
	{
		Server server = getServer();
		ConsoleCommandSender console = server.getConsoleSender();
		if(!(theSender instanceof Player))
		{
			console.sendMessage(ChatColor.RED + "You have to be a player to use this command!");
		} 
		if(theSender instanceof Player)
		{	
			Player player = (Player) theSender;
			if(commandLabel.equalsIgnoreCase("randomtp"))
			{
				if(player.hasPermission("randomtp.tp"))
				{			
					int randomX = (int)(1000 + Math.random() * 1001);
					int randomZ = (int)(1000 + Math.random() * 1001);
					int randomY = player.getWorld().getHighestBlockYAt(randomX, randomZ);

					Location randomLocation = new Location(player.getWorld(), randomX, randomY, randomZ);
					player.teleport(randomLocation);
					player.sendMessage(ChatColor.GOLD + "You were teleported to X: " + randomX + " Y: " + randomY + " Z: " + randomZ);
				}
				else player.sendMessage(ChatColor.RED + "You don't have permission to randomly teleport!");
			} else {
				if(commandLabel.equalsIgnoreCase("rtp"))
				{
					if(player.hasPermission("randomtp.tp"))
					{			
						int randomX = (int)(1000 + Math.random() * 1001);
						int randomZ = (int)(1000 + Math.random() * 1001);
						int randomY = player.getWorld().getHighestBlockYAt(randomX, randomZ);

						Location randomLocation = new Location(player.getWorld(), randomX, randomY, randomZ);
						player.teleport(randomLocation);
						player.sendMessage(ChatColor.GOLD + "You were teleported to X: " + randomX + " Y: " + randomY + " Z: " + randomZ);
					}
					else player.sendMessage(ChatColor.RED + "You don't have permission to randomly teleport!");
				}
			}
			return true;
		}
		return true;
	}
}