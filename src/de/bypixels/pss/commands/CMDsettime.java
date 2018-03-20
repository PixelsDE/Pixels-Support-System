package de.bypixels.pss.commands;
// Made by PixelsDE /
// Minecraft-Developer /
// Copyright PixelsDE /
// youtube.com/bypixels /

import de.bypixels.pss.pss.Main;
import de.bypixels.pss.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.WeatherType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;

public class CMDsettime implements CommandExecutor{

    private Main plugin;

    public CMDsettime(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("settime")){
            if (sender instanceof Player){
                Player p = (Player)sender;
                if (p.hasPermission("pss.settime")){
                    if (args.length == 1){
                        if (args[0].equalsIgnoreCase("day")){

                            setTimeDay(p);

                        }else if (args[0].equalsIgnoreCase("night")){

                            setTimeNight(p);
                        }else{

                        }
                    }else if (args.length == 2){

                        Player target = Bukkit.getPlayer(args[1]);

                        if (args[0].equalsIgnoreCase("day")){

                 setTimeDay(target);

                        }else if (args[0].equalsIgnoreCase("night")){

                          setTimeNight(target);
                        }else{

                        }


                    }else{
                        String msg = Main.prefix + Messages.cfg.getString("arguments");
                        /* 46 */
                        p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    }
                }else{
                    String msg = Main.prefix + Messages.cfg.getString("permissions");
                    /* 56 */
                    p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                }
            }else{
                String msg = Main.prefix + Messages.cfg.getString("player");
                /* 60 */
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }
        }
        return false;
    }




    public void setTimeNight(Player p){
        p.setPlayerTime(16000, true);
        p.setPlayerWeather(WeatherType.CLEAR);
        String msg = Main.prefix + Messages.cfg.getString("Time_Night");
        /* 46 */
        p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }

    public void setTimeDay(Player p){
        p.setPlayerTime(6000, true);
        p.setPlayerWeather(WeatherType.CLEAR);
        String msg = Main.prefix + Messages.cfg.getString("Time_Night");
        /* 46 */
        p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }
}
