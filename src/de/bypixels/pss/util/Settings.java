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

public class Settings {

    public static File file = new File("plugins/Pixels-Support-System/config.yml");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void setSettings() {

        cfg.addDefault("Prefix", "&7[&6PSS&7] ");
        cfg.addDefault("lag", true);
        cfg.addDefault("clearlag", true);
        cfg.addDefault("deathmessage", true);
        cfg.addDefault("godmode", true);
        cfg.addDefault("players", true);
        cfg.addDefault("vanish", true);
        cfg.addDefault("mute", true);
        cfg.addDefault("unmute", true);
        cfg.addDefault("show", true);
        cfg.addDefault("maintenance", true);
        cfg.addDefault("workmode", false);
        cfg.addDefault("joinmessage", true);
        cfg.addDefault("autorespawn", true);
        cfg.addDefault("pvp", true);
        cfg.addDefault("config", true);
        cfg.addDefault("autoupdater", true);
        cfg.addDefault("players", 150);
        cfg.addDefault("motd", "This is a Server");
        cfg.addDefault("invsee", true);
        cfg.addDefault("lag", true);
        cfg.addDefault("msg", true);
        cfg.addDefault("player", true);
        cfg.addDefault("ping", true);
        cfg.addDefault("info", true);
        cfg.addDefault("heal", true);
        cfg.addDefault("socialspy", true);
        cfg.addDefault("gm", true);
        cfg.addDefault("fly", true);
        cfg.addDefault("crash", true);
        cfg.addDefault("chest", true);
        cfg.addDefault("chat", true);
        cfg.addDefault("build", true);
        cfg.addDefault("gui", true);

        try {
            cfg.options().copyDefaults(true);
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
