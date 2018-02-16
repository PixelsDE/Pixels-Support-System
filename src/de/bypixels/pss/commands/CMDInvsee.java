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

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */

/*    */
/*    */ public class CMDInvsee implements CommandExecutor
        /*    */ {
    /*    */   private Main plugin;

    /*    */
    /*    */
    public CMDInvsee(Main plugin)
    /*    */ {
        /* 19 */
        this.plugin = plugin;
        /*    */
    }

    /*    */
    /*    */
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    /*    */ {
        /* 24 */
        if (cmd.getName().equalsIgnoreCase("invsee")) {
            /* 25 */
            if (Settings.cfg.getBoolean("invsee") == true) {
                if ((sender instanceof Player)) {
                    /* 26 */
                    Player p = (Player) sender;
                    /* 27 */

                    /* 28 */
                    Player target = Bukkit.getPlayer(args[0]);
                    /* 29 */
                    if (p.hasPermission("pss.invsee")) {
                        /* 30 */
                        if (args.length == 1) {
                            /* 31 */
                            if (target != null) {
                                /* 32 */
                                if (p != target)
                                    /*    */ {
                                    /*    */
                                    /* 35 */
                                    p.getPlayer().openInventory(target.getInventory());
                                    /*    */
                                }
                                /*    */
                                else {
                                    /* 38 */
                                    String msg = Main.prefix + Messages.cfg.getString("invsee2");
                                    /* 39 */
                                    p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                    /*    */
                                }
                                /*    */
                            } else {
                                /* 42 */
                                String msg4 = Main.prefix + Messages.cfg.getString("online");
                                /* 43 */
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg4));
                                /*    */
                            }
                            /*    */
                        }
                        /*    */
                        else
                            /*    */ {
                            /* 48 */
                            String msg = Main.prefix + Messages.cfg.getString("invsee1");
                            /* 49 */
                            p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /*    */
                        }
                        /*    */
                    }
                    /*    */
                    else
                        /*    */ {
                        /* 54 */
                        String msg = Main.prefix + Messages.cfg.getString("permissions");
                        /* 55 */
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /*    */
                    }
                    /*    */
                    /*    */
                }else {
                    String msg = Main.prefix + Messages.cfg.getString("player");
                    /* 63 */
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                }
                /*    */
            } else {

            }
            /*    */
        }else
                /*    */ {
                /* 62 */

                /*    */
            }
            /*    */

        /* 66 */
        return false;
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Commands\CMDInvsee.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */