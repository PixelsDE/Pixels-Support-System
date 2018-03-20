/*     */
package de.bypixels.pss.commands;
/*     */
/*     */

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

import java.util.ArrayList;
import java.util.List;


/*     */ public class CMDBuild
        /*     */ implements CommandExecutor {

    /*  32 */   public static ArrayList<Player> buildlist = new ArrayList();
    /*     */
    /*  34 *
    /*     */   private Main plugin;

    public CMDBuild(Main plugin)
        /*     */ {
        /*  26 */
        this.plugin = plugin;
        /*     */
    }


    public boolean onCommand(CommandSender Sender, Command command, String label, String[] args)
        /*     */ {
        /*  39 */
        if (command.getName().equalsIgnoreCase("build"))
            /*     */ {
            /*  41 */
            if (Settings.cfg.getBoolean("build") == true)
                /*     */ {
                /*  43 */
                if ((Sender instanceof Player)) {
                    /*  44 */
                    Player player = (Player) Sender;
                    /*  45 */
                    if (player.hasPermission("pss.build")) {
                        /*  46 */
                        if (args.length == 0) {
                            /*  47 */
                            if (!buildlist.contains(player)) {

                                buildlist.add(player);
                                /*  51 */
                                String msg = Main.prefix + Messages.cfg.getString("build1");
                                /*  52 */
                                player.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*  53 */
                                player.getPlayer().setGameMode(GameMode.CREATIVE);
                                /*     */
                            } else if (buildlist.contains(player)) {
                                /*  56 */
                                String msg = Main.prefix + Messages.cfg.getString("build2");
                                /*  57 */
                                player.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*     */
                                /*  59 */
                                player.getPlayer().setGameMode(GameMode.SURVIVAL);
                                /*  60 */

                                /*  61 */
                                buildlist.remove(player);
                                /*     */
                            }
                            /*     */
                        } else if (args.length == 1) {
                            /*  65 */
                            Player t = Bukkit.getPlayer(args[0]);
                            /*  66 */
                            if (!buildlist.contains(t)) {
                                /*  68 */

                                /*  69 */
                                buildlist.add(t);
                                /*  70 */
                                t.setGameMode(GameMode.CREATIVE);
                                String msg = Main.prefix + Messages.cfg.getString("build1");
                                /*  71 */
                                String msg1 = Main.prefix + Messages.cfg.getString("build3");
                                /*  72 */
                                t.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*  73 */
                                player.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1).replace("%player%", t.getName()));
                                /*  74 */

                                /*     */
                            }
                            /*  76 */
                            else if (buildlist.contains(t)) {
                                /*  77 */         /*  85 */
                                buildlist.remove(t);
                                String msg = Main.prefix + Messages.cfg.getString("build2");
                                /*  78 */
                                String msg1 = Main.prefix + Messages.cfg.getString("build4").replace("%player%", t.getName());
                                /*  79 */
                                t.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*  80 */
                                player.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                t.getPlayer().setGameMode(GameMode.SURVIVAL);
                            }
                            /*     */
                        }
                        /*     */
                    }
                    /*     */
                    else {
                        /*  90 */
                        String msg = Main.prefix + Messages.cfg.getString("permissions");
                        /*  91 */
                        player.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /*     */
                    }
                    /*     */
                } else {

                    if (args.length == 1) {
                        Player t = Bukkit.getPlayer(args[0]);
                        if (t != null) {
                            /*  66 */
                            if (!buildlist.contains(t)) {
                                /*  68 */

                                /*  69 */
                                buildlist.add(t);
                                /*  70 */
                                t.setGameMode(GameMode.CREATIVE);
                                String msg = Main.prefix + Messages.cfg.getString("build1");
                                /*  71 */
                                String msg1 = Main.prefix + Messages.cfg.getString("build3");
                                /*  72 */
                                t.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*  73 */
                                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1).replace("%player%", t.getName()));
                                /*  74 */

                                /*     */
                            }
                            /*  76 */
                            else if (buildlist.contains(t)) {
                                /*  77 */         /*  85 */
                                buildlist.remove(t);
                                String msg = Main.prefix + Messages.cfg.getString("build2");
                                /*  78 */
                                String msg1 = Main.prefix + Messages.cfg.getString("build4").replace("%player%", t.getName());
                                /*  79 */
                                t.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*  80 */
                                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                t.getPlayer().setGameMode(GameMode.SURVIVAL);
                            }

                        }else{

                        String msg = Main.prefix + Messages.cfg.getString("online");
                        /* 48 */
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    }
                    } else {
                        String msg1 = Main.prefix + Messages.cfg.getString("arguments");
                        /* 65 */
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                    }
                    /*     */
                }
                /*     */
            }
            /*     */
            /*     */
            /* 101 */

            /*     */
        }
        return true; /*     */
    }
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Commands\CMDBuild.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */