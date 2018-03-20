/*    */
package de.bypixels.pss.commands;
/*    */
/*    */

import de.bypixels.pss.pss.Main;
import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;
import org.bukkit.ChatColor;
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
/*    */ public class CMDPlayers implements CommandExecutor
        /*    */ {
    /*    */
    /* 20 */   public static boolean getPlayers = true;
    /*    */   private Main plugin;

    /*    */
    /*    */
    public CMDPlayers(Main plugin)
    /*    */ {
        /* 17 */
        this.plugin = plugin;
        /*    */
    }

    /*    */
    /*    */
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    /*    */ {
        /* 24 */
        /* 25 */
        if (cmd.getName().equalsIgnoreCase("players")) {
            if (Settings.cfg.getBoolean("player") == true) {
                /* 26 */
                if ((sender instanceof Player)) {
                    /* 27 */
                    Player p = (Player) sender;
                    /* 28 */
                    if (p.hasPermission("pss.players")) {
                        /* 29 */
                        if (args.length == 0) {
                            /* 30 */
                            if (getPlayers) {
                                /* 31 */
                                getPlayers = false;
                                /* 32 */
                                String msg = Main.prefix + Messages.cfg.getString("players2");
                                /* 33 */
                                p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*    */
                            }
                            /*    */
                            else
                                /*    */ {
                                /* 37 */
                                getPlayers = true;
                                /* 38 */
                                String msg = Main.prefix + Messages.cfg.getString("players1");
                                /* 39 */
                                p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*    */
                            }
                            /*    */
                        } else {
                            {
                                /* 45 */
                                String msg = Main.prefix + Messages.cfg.getString("arguments");
                                /* 46 */
                                p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*    */
                            }
                        }
                        /*    */
                    }
                    /*    */
                    else
                        /*    */ {
                        /* 45 */
                        String msg = Main.prefix + Messages.cfg.getString("permissions");
                        /* 46 */
                        p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /*    */
                    }
                    /*    */
                } else {
                    /* 50 */
                    String msg = Main.prefix + Messages.cfg.getString("player");
                    /* 51 */
                    org.bukkit.Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    /*    */
                }
                /*    */
            }
            /*    */
        }
        /*    */
        /*    */
        /*    */
        /*    */
        /* 59 */
        return false;
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Commands\CMDPlayers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */