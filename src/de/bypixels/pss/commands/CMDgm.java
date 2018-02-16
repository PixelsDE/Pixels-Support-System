/*    */
package de.bypixels.pss.commands;
/*    */
/*    */

import de.bypixels.pss.pss.Main;
import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class CMDgm
        /*    */ implements CommandExecutor
        /*    */ {
    /*    */   private Main plugin;

    /*    */
    /*    */
    public CMDgm(Main plugin)
    /*    */ {
        /* 21 */
        this.plugin = plugin;
        /*    */
    }

    /*    */
    /*    */
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        /* 25 */
        if (command.getName().equalsIgnoreCase("gm")) {
            /* 26 */    if (Settings.cfg.getBoolean("gm") == true) {
            if ((sender instanceof Player)) {
                /* 27 */
                Player p = (Player) sender;
                /*    */
                /* 29 */

                    /* 30 */
                    if (p.hasPermission("pss.gm"))
                        /*    */ {
                        /* 32 */
                        if (args.length == 0) {
                            /* 33 */
                            if (!p.getGameMode().equals(GameMode.CREATIVE)) {
                                /* 34 */
                                String msg = Main.prefix + Messages.cfg.getString("gamemode1");
                                /* 35 */
                                p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /* 36 */
                                p.setGameMode(GameMode.CREATIVE);
                                /* 37 */
                            } else if (p.getGameMode().equals(GameMode.CREATIVE)) {
                                /* 38 */
                                String msg = Main.prefix + Messages.cfg.getString("gamemode2");
                                /* 39 */
                                p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /* 40 */
                                p.setGameMode(GameMode.SURVIVAL);
                                /*    */
                            }
                            /* 42 */
                        } else if (args.length == 1) {
                            /* 43 */
                            Player target = Bukkit.getPlayer(args[0]);
                            /*    */
                            /* 45 */
                            if (target != null)
                                /*    */ {
                                /*    */
                                /*    */
                                /* 49 */
                                if (!target.getGameMode().equals(GameMode.CREATIVE)) {
                                    /* 50 */
                                    String msg = Main.prefix + Messages.cfg.getString("gamemode3");
                                    /* 51 */
                                    p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                    /* 52 */
                                    target.setGameMode(GameMode.CREATIVE);
                                    /* 53 */
                                } else if (target.getGameMode().equals(GameMode.CREATIVE)) {
                                    /* 54 */
                                    String msg = Main.prefix + Messages.cfg.getString("gamemode4");
                                    /* 55 */
                                    p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                    /* 56 */
                                    target.setGameMode(GameMode.SURVIVAL);
                                    /*    */
                                }
                                /*    */
                            } else {
                                /* 59 */
                                String msg = Main.prefix + Messages.cfg.getString("online");
                                /* 60 */
                                p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*    */
                            }
                            /*    */
                        }
                        /*    */
                    }
                    /*    */
                    else {
                        /* 65 */
                        String msg = Main.prefix + Messages.cfg.getString("permissions");
                        /* 66 */
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /*    */
                    }
                    /*    */
                }else{
                if (args.length == 1){
                    /* 70 */
                    Player target = Bukkit.getPlayer(args[0]);
                    /*    */
                    /* 45 */
                    if (target != null)
                        /*    */ {
                        /*    */
                        /*    */
                        /* 49 */
                        if (!target.getGameMode().equals(GameMode.CREATIVE)) {
                            /* 50 */
                            String msg = Main.prefix + Messages.cfg.getString("gamemode3");
                            /* 51 */
                            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /* 52 */
                            target.setGameMode(GameMode.CREATIVE);
                            /* 53 */
                        } else if (target.getGameMode().equals(GameMode.CREATIVE)) {
                            /* 54 */
                            String msg = Main.prefix + Messages.cfg.getString("gamemode4");
                            /* 55 */
                            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /* 56 */
                            target.setGameMode(GameMode.SURVIVAL);
                            /*    */
                        }
                        /*    */
                    } else {
                        /* 59 */
                        String msg = Main.prefix + Messages.cfg.getString("online");
                        /* 60 */
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /*    */
                    }
                    /*    */}else{
                    /*     */  String msg4 = Main.prefix + Messages.cfg.getString("aguments");
                    /* 74 */
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg4));
                }
            }
                /*    */
            } else {

            }
            /*    */
        }
        /* 74 */
        return false;
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Commands\CMDgm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */