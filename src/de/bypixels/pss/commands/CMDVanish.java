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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

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
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class CMDVanish
        /*    */ implements CommandExecutor
        /*    */ {
    /*    */
    /* 29 */   public static List<Player> vanishList = new ArrayList();
    /*    */


    /*    */   private Main plugin;

    /*    */
    /*    */
    public CMDVanish(Main plugin)
    /*    */ {
        /* 26 */
        this.plugin = plugin;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    /*    */ {
        /* 36 */
        if (cmd.getName().equalsIgnoreCase("vanish")) {
            /* 37 */     if (Settings.cfg.getBoolean("vanish") == true) {
            if ((sender instanceof Player)) {
                /* 38 */
                Player player = (Player) sender;
                /* 39 */

                    /* 40 */
                    if (player.hasPermission("pss.hide")) {
                        /* 41 */


                        if (args.length == 0) {
                            /* 42 */
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                /* 44 */
                                if (!this.plugin.hide.contains(player)) {
                                    /* 45 */
                                    this.plugin.hide.add(player);
                                    /* 46 */
                                    String msg = Main.prefix + Messages.cfg.getString("vanish1");
                                    /* 47 */
                                    player.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                    /* 48 */
                                    vanishList.add(player);
                                    /* 49 */
                                    players.hidePlayer(player);
                                    /* 50 */
                                    player.showPlayer(players);
                                    /* 51 */

                                    /*    */
                                    /* 53 */

                                    /*    */
                                    /*    */
                                    /* 56 */
                                    return false;
                                    /*    */
                                } else {


                                    /*    */
                                    /* 59 */
                                    this.plugin.hide.remove(player);
                                    /* 60 */
                                    players.showPlayer(player);
                                    /* 61 */
                                    String msg = Main.prefix + Messages.cfg.getString("vanish2");
                                    /* 62 */
                                    player.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                    /*    */

                                    player.showPlayer(players);
                                    /* 67 */
                                    players.showPlayer(player);
                                    /* 68 */
                                    this.plugin.hide.remove(player);
                                    /* 69 */
                                    return false;

                                }
                            }
                        } else if (args.length == 1) {

                            Player target = Bukkit.getPlayer(args[1]);
                            for (Player all : Bukkit.getOnlinePlayers()) {

                                if (this.plugin.hide.contains(target)) {
                                    this.plugin.hide.remove(target);

                                    String msg = Main.prefix + Messages.cfg.getString("hide4").replace("%player%", target.getName());
                                    /* 76 */
                                    player.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                    String msg1 = Main.prefix + Messages.cfg.getString("vanish2");
                                    /* 62 */
                                    target.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                    all.showPlayer(target);
                                } else if (!this.plugin.hide.contains(target)) {
                                    this.plugin.hide.add(target);
                                    String msg = Settings.cfg.getString("Prefix") + Messages.cfg.getString("hide3").replace("%player%", target.getName());
                                    /* 76 */
                                    String msg1 = Settings.cfg.getString("Prefix")+ Messages.cfg.getString("vanish1");
                                    /* 62 */
                                    target.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                    player.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                    all.hidePlayer(target);
                                }
                            }
                        }
                    } else {
                        /* 75 */
                        String msg =Settings.cfg.getString("Prefix") + Messages.cfg.getString("permissions");
                        /* 76 */
                        player.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /*    */
                    }
                    /*    */
                }else{
                if (args.length == 1) {
                    if (Bukkit.getPlayer(args[0]) != null) {
                        Player target = Bukkit.getPlayer(args[1]);
                        for (Player all : Bukkit.getOnlinePlayers()) {

                            if (this.plugin.hide.contains(target)) {
                                this.plugin.hide.remove(target);

                                String msg = Settings.cfg.getString("Prefix") + Messages.cfg.getString("hide4").replace("%player%", target.getName());
                                /* 76 */
                                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                String msg1 = Settings.cfg.getString("Prefix")+ Messages.cfg.getString("vanish2");
                                /* 62 */
                                target.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                all.showPlayer(target);
                            } else if (!this.plugin.hide.contains(target)) {
                                this.plugin.hide.add(target);
                                String msg = Settings.cfg.getString("Prefix") + Messages.cfg.getString("hide3").replace("%player%", target.getName());
                                /* 76 */
                                String msg1 = Settings.cfg.getString("Prefix") + Messages.cfg.getString("vanish1");
                                /* 62 */
                                target.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                all.hidePlayer(target);
                            }
                        }
                    }else{
                        String msg =Settings.cfg.getString("Prefix")+ Messages.cfg.getString("online");
                        /* 48 */                 Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    }
                }else{
                    String msg =Settings.cfg.getString("Prefix")+ Messages.cfg.getString("arguments");
                    /* 48 */                 Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                }
            }
                /*    */
            }
            /*    */
            else {

            }
            /*    */
        }
        /*    */
        /*    */
        /*    */
        /* 88 */
        return false;
        /*    */
    }
    /*    */
}
