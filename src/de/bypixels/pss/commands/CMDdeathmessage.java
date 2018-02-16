package de.bypixels.pss.commands;
// Made by PixelsDE 
// Project: PSS
// Copyright PixelsDE
// youtube.com/bypixels
// Date: 02.02.2018
// Package: de.bypixels.pss.commands
// Created by: Daniel

import de.bypixels.pss.pss.Main;
import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CMDdeathmessage implements CommandExecutor {
    public static boolean deathmessage = true;
    /*    */   private Main plugin;

    /*    */
    /*    */
    public CMDdeathmessage(Main plugin)
    /*    */ {
        /* 17 */
        this.plugin = plugin;
        /*    */
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("deathmessage")) {
            if (Settings.cfg.getBoolean("deathmessage") == true) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    if (p.hasPermission("pss.deathmessage")) {


                        if (deathmessage == true) {
                            deathmessage = false;
                            String msg = Main.prefix + Messages.cfg.getString("deathmessage1");
                            /* 39 */
                            p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        } else {
                            if (deathmessage == false) {
                                deathmessage = true;
                                String msg = Main.prefix + Messages.cfg.getString("deathmessage2");
                                /* 39 */
                                p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            }
                        }
                    } else {
                        String msg = Main.prefix + Messages.cfg.getString("permissions");
                        /* 66 */
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    }
                } else {


                    if (deathmessage == true) {
                        deathmessage = false;
                        String msg = Main.prefix + Messages.cfg.getString("deathmessage1");
                        /* 39 */
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    } else {
                        if (deathmessage == false) {
                            deathmessage = true;
                            String msg = Main.prefix + Messages.cfg.getString("deathmessage2");
                            /* 39 */
                            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        }
                    }

                }
            }

        }


        return false;
    }

}
