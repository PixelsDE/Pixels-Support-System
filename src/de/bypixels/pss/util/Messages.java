package de.bypixels.pss.util;
// Made by PixelsDE 
// Project: PSS
// Copyright PixelsDE
// youtube.com/bypixels
// Date: 31.01.2018
// Package: de.bypixels.pss.util
// Created by: Daniel

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Messages {
    public static File file = new File("plugins/Pixels-Support-System/messages.yml");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void setMessages() {


        cfg.addDefault("arguments", "&cTomany or to Less Arguments!");
        cfg.addDefault("gamemode1", " &aYour Gamemode is now ON!");
        cfg.addDefault("gamemode2", "&cYour Gamemode is now OFF!");
        cfg.addDefault("gamemode3", "&aYou changed the Gamemode of the Player to On!");
        cfg.addDefault("gamemode4", "&cYou changed the Gamemode of the Player to Off!");
        cfg.addDefault("fly1", "&aYour Fly-Mode is now ON!");
        cfg.addDefault("fly2", "&cYour Fly-Mode is now OFF!");
        cfg.addDefault("fly3", "&aThe Player can fly now!");
        cfg.addDefault("fly4", "&cThe Player cant fly anymore!");
        cfg.addDefault("vanish1", "&aYour Vanish is now ON!");
        cfg.addDefault("vanish2", "&cYour Vanish is now OFF!");
        cfg.addDefault("vanish3", "&aThe Player &6%player &ais now in Vanish!%");
        cfg.addDefault("vanish4", "&cThe Player &6%player%&c is not longer in Vanish!");
        cfg.addDefault("system", "&bYou opened Player System!");
        cfg.addDefault("heal1", "&aYou healed yourself!");
        cfg.addDefault("heal2", "&aYou have been healed by: %player%");
        cfg.addDefault("heal3", "&aYou healed all!");
        cfg.addDefault("heal4", "&aYou healed %player%");
        cfg.addDefault("whitelist1", "&aThe Serverwhitelist is now ON!");
        cfg.addDefault("whitelist2", "&cThe Serverwhitelist is now OFF!");
        cfg.addDefault("maintenance1", "&aThe Server is now in Maintenance-Mode!");
        cfg.addDefault("maintenance2", "&cThe Server is not longer in Maintenance-Mode!");
        cfg.addDefault("motd", "&cThe Server is in Maintenance-Mode!");
        cfg.addDefault("pvp1", "&aServer-PVP is now ON!");
        cfg.addDefault("pvp2", "&cServer-PVP is now OFF!");
        cfg.addDefault("stop1", "&aEvery Player can write again!");
        cfg.addDefault("stop2", "&cEvery Player cant write anymore!");
        cfg.addDefault("tp1", "&aYou teleported every Player to you!");
        cfg.addDefault("permissions", "&cYou dont have the permissions!");
        cfg.addDefault("player", "&cYou must be a Player to do this!");
        cfg.addDefault("gui", "&cPlease enter just: &6/PSS GUI &c!");
        cfg.addDefault("join1", "&cThe Joinmessages has been turned off!");
        cfg.addDefault("join2", "&aThe Joinmessages has been turned on!");
        cfg.addDefault("online", "&cThe Player is not online!");
        cfg.addDefault("notserver", "&cThis Player is not on the Server!");
        cfg.addDefault("msg1", "&cme &r -> &6 %target% &8 %message%");
        cfg.addDefault("msg2", "&c%player% &r -> &cme &8%message%");
        cfg.addDefault("msg3", "&c%player% &r -> &c%otherplayer%&8: %message%");
        cfg.addDefault("crash1", "&cPlease just use /crash <Player>");
        cfg.addDefault("crash2", "&aYou have crashed the Player!");
        cfg.addDefault("crash3", "&aAll Players have been CRASHED!");
        cfg.addDefault("unmute1", "&aThe Player &6%player%&a has been unmuted!");
        cfg.addDefault("unmute2", "&cYou has been unmuted!");
        cfg.addDefault("mute1", "&aThe Player: &6%player%&a has been muted!");
        cfg.addDefault("mute2", "&cYou has been muted permanently!");
        cfg.addDefault("mute3", "&cPlease just enter /Mute (Player)!");
        cfg.addDefault("mute4", "&cYou are MUTED you cant write!");
        cfg.addDefault("mute5", "&cThis player is already muted!");
        cfg.addDefault("mute6", "&cAll Players has been unmuted!");
        cfg.addDefault("mute7", "&aAll Players has been muted!");
        cfg.addDefault("mute8", "&aAll Players has been unmuted!");
        cfg.addDefault("info", "&bYou are using the newest Version of Pixels-Support-System, type /pss gui to start!");
        cfg.addDefault("chest1", "&aYour opened your Backpack!");
        cfg.addDefault("chest2", "&aYour Backpack has been saved!");
        cfg.addDefault("invsee1", "&cPlease just use /invsee <Player>!");
        cfg.addDefault("invsee2", "&cYou cant open your own Inventory that way!");
        cfg.addDefault("showall1", "&aYou can now see all Players!");
        cfg.addDefault("showall2", "&aYou dont see any Players anymore!");
        cfg.addDefault("chatclear", " &aThe Chat has been cleared!");
        cfg.addDefault("config", "&aThe Files has been reloaded!");
        cfg.addDefault("build1", "&a You can build now!");
        cfg.addDefault("build2", "&cYou cant build anymore!");
        cfg.addDefault("build3", "&a The Player: &6%player% &acan build now!");
        cfg.addDefault("build4", "&cThe Player: &6%player% &ccant build anymore!");
        cfg.addDefault("build5", "&cYou cant brake the Block: &6%block%&c!");
        cfg.addDefault("worldname1", "&cYou must enter a Worldname!");
        cfg.addDefault("worldname2", "&cYou must enter a Worldname which exists!");
        cfg.addDefault("deathmessage1", "&aDeathmessages has been turned on!");
        cfg.addDefault("deathmessage2", "&cDeathmessages has been turned off!");
        cfg.addDefault("clearlag", "&aAll Entities has been removed!");
        cfg.addDefault("godmode1", "&aYour GodMode is now ON!");
        cfg.addDefault("godmode2", "&cYour GodMode is now OFF!");
        cfg.addDefault("godmode3", "&aThis Player is now in GodMode!");
        cfg.addDefault("godmode4", "&cThis Player is not longer in GodMode!");
        cfg.addDefault("godmode5", "&cYou cant hit a Player in Godmode!");
        cfg.addDefault("players1", "&aYou activated the PlayerListener!");
        cfg.addDefault("players2", "&cYou deactivated the PlayerListener!");
        cfg.addDefault("args", "&cTo many or to less Arguments!");
        cfg.addDefault("Autoupdate", "&cThe Plugin has a new Version!");
        cfg.addDefault("Update_Error", "&cCant check for updates!");
        cfg.addDefault("Update_True", "&aThe Plugin is up to date!");
        cfg.addDefault("Kill_All", "&aYou killed all Players!");
        cfg.addDefault("ping1", "&aYour Ping is: &6%ping%&a!");
        cfg.addDefault("ping2", "&aThe Ping of: &6%player%&a is: &6 %ping%&a!");
        cfg.addDefault("socialspy1", "&aYou are now in the Socialspy-Mode!");
        cfg.addDefault("socialspy2", "&cYou are not longer in the Socialspy-Mode!");
        cfg.addDefault("setcmd", "&aYou have set the Config of the Command &6%command% &ato: &6%what%&a!");


        cfg.options().copyDefaults(true);

        try {
            cfg.options().copyDefaults(true);
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
