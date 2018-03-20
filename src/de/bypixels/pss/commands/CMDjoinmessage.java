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

import java.util.ArrayList;

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
/*    */ public class CMDJoinMessage  implements CommandExecutor       {
    /*    */
    /* 25 */   public static String MSG = new String("Test");
    /* 26 */   public static ArrayList<String> joinp = new ArrayList();
    /*    */   private Main plugin;
    /*    */
    /*    */
    public CMDJoinMessage(Main plugin)
    /*    */ {
        /* 22 */
        this.plugin = plugin;
        /*    */
    }

    /*    */
    /*    */
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    /*    */ {
        /* 30 */
        if (command.getName().equalsIgnoreCase("joinmessage")) {
            /* 31 */     if (Settings.cfg.getBoolean("joinmessage") == true) {
                if ((sender instanceof Player)) {
                    /* 32 */
                    Player p = (Player) sender;
                    /* 33 */

                    /* 34 */
                    if (p.hasPermission("pss.joinmessage")) {
                        /* 35 */
                        if (!joinp.contains(MSG)) {
                            /* 36 */
                            joinp.add(MSG);
                            /* 37 */
                            String msg = Main.prefix + Messages.cfg.getString("join1");
                            /* 38 */
                            p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /* 39 */
                            return true;
                            /*    */
                        }else{
                            String msg = Main.prefix + Messages.cfg.getString("join2");
                            /* 42 */
                            joinp.remove(MSG);
                            /* 43 */
                            p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /* 44 */
                            return true;}
                        /*    */
                    }
                    /* 46 */
                    String msg = Main.prefix + Messages.cfg.getString("permissions");
                    /* 47 */
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    /*    */
                } else {

                    if (!joinp.contains(MSG)) {
                        /* 36 */
                        joinp.add(MSG);
                        /* 37 */
                        String msg = Main.prefix + Messages.cfg.getString("join1");
                        /* 38 */
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /* 39 */
                        return true;
                        /*    */
                    }else{
                        String msg = Main.prefix + Messages.cfg.getString("join2");
                        /* 42 */
                        joinp.remove(MSG);
                        /* 43 */
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /* 44 */
                        return true;}


                }
                /*    */

                /*    */
            }
            /*    */
        }
        /*    */
        /* 57 */
        return false;
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Commands\CMDjoinmessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */