/*    */
package de.bypixels.pss.commands;
/*    */
/*    */

import de.bypixels.pss.pss.Main;
import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class CMDMaintenanceMode
        /*    */ implements CommandExecutor
        /*    */ {
    /*    */   private Main plugin;

    /*    */
    /*    */
    public CMDMaintenanceMode(Main plugin)
    /*    */ {
        /* 20 */
        this.plugin = plugin;
        /*    */
    }

    /*    */
    /*    */
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
    /*    */ {
        /* 25 */
        if (command.getName().equalsIgnoreCase("maintenance")) {
            /* 26 */
            if (Settings.cfg.getBoolean("maintenance") == true) {
                if ((commandSender instanceof Player)) {
                    /* 27 */
                    Player p = (Player) commandSender;
                    /* 28 */

                    /* 29 */
                    if (p.hasPermission("pss.maintenance")) {
                        /* 30 */
                        if (Settings.cfg.getBoolean("workmode") != true) {
                            /* 31 */
                            Settings.cfg.set("workmode", true);
                            Main.wartung = true;
                            try {
                                Settings.cfg.save(Settings.file);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            /* 32 */
                            String msg = Main.prefix + Messages.cfg.getString("maintenance1");
                            /* 33 */
                            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /* 34 */
                            p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /* 35 */
                        } else if (Settings.cfg.getBoolean("workmode") == true) {
                            /* 36 */
                            String msg = Main.prefix + Messages.cfg.getString("maintenance2");
                            /* 37 */
                            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /* 38 */
                            p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /* 39 */
                            Settings.cfg.set("workmode", false);
                            Main.wartung = false;
                            try {
                                Settings.cfg.save(Settings.file);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            /*    */
                        }
                        /*    */
                    } else {
                        /* 42 */
                        String msg = Main.prefix + Messages.cfg.getString("permissions");
                        /* 43 */
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /*    */
                    }
                    /*    */
                } else if (Main.wartung != true) {
                    /* 47 */
                    String msg = Main.prefix + Messages.cfg.getString("maintenance1");
                    /* 48 */
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    /* 49 */
                    this.plugin.wartung = true;
                    Settings.cfg.set("workmode", true);
                    try {
                        Settings.cfg.save(Settings.file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    /* 50 */
                } else if (Main.wartung == true) {
                    /* 51 */
                    String msg = Main.prefix + Messages.cfg.getString("maintenance2");
                    /* 52 */
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    /* 53 */
                    Main.wartung = false;
                    Settings.cfg.set("workmode", false);
                    /*    */          try {
                        Settings.cfg.save(Settings.file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                /* 46 */


                /*    */
            }
            /*    */
            /* 57 */

            /*    */
        }
        return false;
    }}
    /*    */



/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Commands\CMDMaintenanceMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */