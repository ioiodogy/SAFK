
package org.game_host.cegryphony;

import java.util.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;
/**
 *
 * @author Cale
 */
public class SAFK extends JavaPlugin {
    @Override
    public void onEnable(){
        getLogger().info("onEnable has been invoked!");
        this.saveDefaultConfig();
    }
 
    @Override
    public void onDisable() {
        getLogger().info("onDisable has been invoked!");
    }

    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(cmd.getName().equalsIgnoreCase("afk")){ // If the player typed /afk then do the following...
            Player player = (Player) sender;
            player.sendMessage(ChatColor.YELLOW + SAFK.this.getConfig().getString("text"));
            player.teleport(new Location(Bukkit.getWorld("world"), SAFK.this.getConfig().getInt("location.X"), SAFK.this.getConfig().getInt("location.Y"), SAFK.this.getConfig().getInt("location.Z")));
            return true;
        } //If this has happened the function will return true.
            // If this hasn't happened the a value of false will be returned.
        return false;
    }
}
/*
permissions:
    afk.*:
        description: Gives access to all afk commands



*/
 