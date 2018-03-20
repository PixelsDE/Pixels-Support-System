/*    */ package de.bypixels.pss.commands;
/*    */ 
/*    */ import de.bypixels.pss.pss.Main;
/*    */
/*    */ import java.io.IOException;
import java.util.ArrayList;
/*    */ import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;
import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */
/*    */
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class CMDunmute implements CommandExecutor
/*    */ {
/*    */   private Main plugin;
/*    */   
/*    */   public CMDunmute(Main plugin)
/*    */   {
/* 21 */     this.plugin = plugin;
/*    */   }
/*    */   
/* 24 */   public static ArrayList<Player> muted = new ArrayList();
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
/*    */   {
/* 28 */     if (command.getName().equalsIgnoreCase("unmute")) {
             if (Settings.cfg.getBoolean("unmute") == true) {
/* 29 */       if ((sender instanceof Player)) {
/* 30 */         Player p = (Player)sender;
/* 31 *
/* 32 */           if (p.hasPermission("pss.mute")) {
/* 33 */             if (args.length == 1) {
/* 34 */               Player mute = Bukkit.getPlayer(args[0]);
/* 35 */               if (mute != null) {
/* 36 */                 if (CMDMute.muted.contains(mute) || CMDMute.cfg.getBoolean(mute.getName()) == true) {
/* 37 */                   CMDMute.muted.remove(mute);
                                     CMDMute.cfg.set(mute.getName(), false);
                                     try {
                                         CMDMute.cfg.save(CMDMute.file);
                                     } catch (IOException e) {
                                         e.printStackTrace();
                                     }
/* 38 */                    String msg1 =Main.prefix+ Messages.cfg.getString("unmute1").replace("%player%", mute.getName());
/* 39 */                     String msg2 =Main.prefix+ Messages.cfg.getString("unmute2");
/* 40 */                   p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
/* 41 */                   mute.sendMessage(ChatColor.translateAlternateColorCodes('&', msg2));
/*    */                 }
/*    */               } else {
/* 44 */                    String msg =Main.prefix+ Messages.cfg.getString("notserver");
/* 45 */                 p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
/*    */               }
/*    */             } else {
/* 48 */                String msg =Main.prefix+ Messages.cfg.getString("mute3");
/* 49 */               p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
/*    */             }
/*    */           }
/*    */           else
/*    */           {
/* 54 */                String msg =Main.prefix+ Messages.cfg.getString("permissions");
/* 55 */             System.out.println(ChatColor.translateAlternateColorCodes('&', msg));
/*    */           }
/*    */         }else{


                if (args.length == 1) {
                    /* 59 */
                    if (Bukkit.getPlayer(args[0]) != null){
                        Player mute = Bukkit.getPlayer(args[0]);
                        /* 35 */
                        if (mute != null) {
                            /* 36 */
                            if (CMDMute.muted.contains(mute)) {
                                /* 37 */
                                CMDMute.cfg.set(mute.getName(), false);
                                try {
                                    CMDMute.cfg.save(CMDMute.file);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                CMDMute.muted.remove(mute);
                                /* 38 */
                                String msg1 = Main.prefix + Messages.cfg.getString("unmute1").replace("%player%", mute.getName());
                                /* 39 */
                                String msg2 = Main.prefix + Messages.cfg.getString("unmute2");
                                /* 40 */
                                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                /* 41 */
                                mute.sendMessage(ChatColor.translateAlternateColorCodes('&', msg2));
                                /*    */
                            }
                            /*    */
                        } else {
                            /* 44 */
                            String msg = Main.prefix + Messages.cfg.getString("notserver");
                            /* 45 */
                            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /*    */
                        }
                        /*    */}else{
                        String msg =Main.prefix+ Messages.cfg.getString("online");
                        /* 48 */                 Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    }
                }else{
                    String msg =Main.prefix+ Messages.cfg.getString("arguments");
                    /* 48 */                 Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                }


            }
/*    */       } else {

    }
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Commands\CMDunmute.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */