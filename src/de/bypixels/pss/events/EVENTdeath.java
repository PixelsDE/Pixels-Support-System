package de.bypixels.pss.events;

// Project: PSS 
// Package: de.bypixels.pss.events 
// Made by PixelsDE 
// Date: 06.02.2018 
// Copyright PixelsDE 

import de.bypixels.pss.util.Settings;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class EVENTdeath implements Listener{

    @EventHandler
    public void onDie(PlayerDeathEvent e){
        Player p = e.getEntity();
        if (Settings.cfg.getBoolean("autorespawn") == true){

        }
    }


}
