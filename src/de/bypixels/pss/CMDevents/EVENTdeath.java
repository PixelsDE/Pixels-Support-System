package de.bypixels.pss.CMDevents;
// Made by PixelsDE 
// Project: PSS
// Copyright PixelsDE
// youtube.com/bypixels
// Date: 02.02.2018
// Package: de.bypixels.pss.CMDevents
// Created by: Daniel

import de.bypixels.pss.commands.CMDdeathmessage;
import de.bypixels.pss.pss.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class EVENTdeath implements Listener{
    /*    */   private Main plugin;
    /*    */
    /*    */   public EVENTdeath(Main plugin)
    /*    */   {
        /* 28 */     this.plugin = plugin;
        /*    */   }
    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player p = (Player) e.getEntity();
        if (CMDdeathmessage.deathmessage == false){
            e.setDeathMessage(null);
        }else{
            if (CMDdeathmessage.deathmessage == true){

            }
        }
    }


}
