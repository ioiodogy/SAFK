
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
import org.bukkit.configuration.file.*;
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
            player.sendMessage(ChatColor.YELLOW + SAFK.this.getConfig().getString("config.text"));
            player.teleport(new Location(Bukkit.getWorld("world"), SAFK.this.getConfig().getInt("config.location.X"), SAFK.this.getConfig().getInt("config.location.Y"), SAFK.this.getConfig().getInt("config.location.Z")));
            return true;
        } //If this has happened the function will return true.
            // If this hasn't happened the a value of false will be returned.
        else if(cmd.getName().equalsIgnoreCase("setafk")){
            Player player = (Player) sender;
            player.sendMessage(ChatColor.RED + "You have set the new AFK spot!");
            Location loc = player.getLocation();
            this.getConfig().set("config.location.X", loc.getBlockX());
            this.getConfig().set("config.location.Y", loc.getBlockY());
            this.getConfig().set("config.location.Z", loc.getBlockZ());
            this.saveConfig();
         return true;   
        }
        /*else if(cmd.getName().equalsIgnoreCase("afktimer")){
            
            
        return true;
        }*/
        return false;
        }
        
    }

/*
permissions:
    afk.*:
        description: Gives access to all afk commands



*/
 