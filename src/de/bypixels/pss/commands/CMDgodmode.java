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
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */

/*     */
/*     */ public class CMDgodmode implements CommandExecutor, org.bukkit.event.Listener
        /*     */ {
    /*     */
    /*  27 */   public static ArrayList<Player> god = new ArrayList();
    /*     */   private Main plugin;

    /*     */
    /*     */
    public CMDgodmode(Main plugin)
    /*     */ {
        /*  24 */
        this.plugin = plugin;
        /*     */
    }

    /*     */
    /*     */
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    /*     */ {
        /*  31 */
        if (cmd.getName().equalsIgnoreCase("godmode"))
            /*     */ {
            /*  33 */
            if (Settings.cfg.getBoolean("godmode") == true)
                /*     */ {
                /*     */
                /*  36 */
                if ((sender instanceof Player))
                    /*     */ {
                    /*  38 */
                    Player p = (Player) sender;
                    /*  39 */
                    if (p.hasPermission("pss.godmode")) {
                        /*  40 */
                        if (args.length == 0) {
                            /*  41 */
                            if (god.contains(p)) {
                                /*  42 */
                                god.remove(p);
                                /*  43 */
                                p.setGameMode(GameMode.ADVENTURE);
                                /*  44 */
                                p.setAllowFlight(false);
                                /*  45 */
                                String msg = Main.prefix + Messages.cfg.getString("godmode2");
                                /*  46 */
                                p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*     */
                            } else {
                                /*  48 */
                                p.setAllowFlight(true);
                                /*  49 */
                                String msg = Main.prefix + Messages.cfg.getString("godmode1");
                                /*  50 */
                                p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*  51 */
                                god.add(p);
                                /*     */
                            }
                            /*  53 */
                        } else if (args.length == 1) {
                            /*  54 */
                            Player t = Bukkit.getPlayer(args[0]);
                            /*  55 */
                            if (god.contains(t)) {
                                /*  56 */
                                t.setGameMode(GameMode.ADVENTURE);
                                /*  57 */
                                String msg = Main.prefix + Messages.cfg.getString("godmode1");
                                /*  58 */
                                t.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*  59 */
                                god.remove(t);
                                /*  60 */
                                String msg1 = Main.prefix + Messages.cfg.getString("godmode4");
                                /*  61 */
                                p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                /*     */
                            } else {
                                /*  63 */
                                t.setGameMode(GameMode.CREATIVE);
                                /*  64 */
                                String msg = Main.prefix + Messages.cfg.getString("godmode1");
                                /*  65 */
                                t.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*  66 */
                                god.add(t);
                                /*  67 */
                                String msg1 = Main.prefix + Messages.cfg.getString("godmode5");
                                /*  68 */
                                p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                /*     */
                            }
                            /*     */
                        }
                        /*     */
                    }
                    /*     */
                    else
                        /*     */ {
                        /*  74 */
                        String msg = Main.prefix + Messages.cfg.getString("permissions");
                        /*  75 */
                        p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /*     */
                    }
                    /*     */
                }
                /*     */
                else {
                    if (args.length == 1) {
                        /*  79 */

                        Player t = Bukkit.getPlayer(args[0]);
                        if (t != null) {
                            /*  55 */
                            if (god.contains(t)) {
                                /*  56 */
                                t.setGameMode(GameMode.ADVENTURE);
                                /*  57 */
                                String msg = Main.prefix + Messages.cfg.getString("godmode1");
                                /*  58 */
                                t.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*  59 */
                                god.remove(t);
                                /*  60 */
                                String msg1 = Main.prefix + Messages.cfg.getString("godmode4");
                                /*  61 */
                                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                /*     */
                            } else {
                                /*  63 */
                                t.setGameMode(GameMode.CREATIVE);
                                /*  64 */
                                String msg = Main.prefix + Messages.cfg.getString("godmode1");
                                /*  65 */
                                t.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*  66 */
                                god.add(t);
                                /*  67 */
                                String msg1 = Main.prefix + Messages.cfg.getString("godmode5");
                                /*  68 */
                                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                /*     */
                            }
                        }else{
                            String msg =Main.prefix+ Messages.cfg.getString("online");
                            /* 48 */                 Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        }
                    }else{
                        /*     */  String msg4 = Main.prefix + Messages.cfg.getString("aguments");
                        /* 74 */
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg4));
                    }
                }
                /*     */
            }
            /*     */
        }
        /*     */
        /*     */
        /*     */
        /*     */
        /*  88 */
        return false;
        /*     */
    }

    /*     */
    /*     */
    @EventHandler
    /*     */ public void onDamage(EntityDamageEvent e)
    /*     */ {
        /*  94 */
        if (e.getEntity() instanceof  Player) {
            Player p = (Player) e.getEntity();
            /*  95 */
            if (god.contains(p)) {
                /*  96 */
                e.setCancelled(true);
                /*     */
            }
        /*     *
        }/}
         */
        }
    }

    /*     */
    /*     */
    /*     */
    @EventHandler
    /*     */ public void onDamage(EntityDamageByEntityEvent e)
    /*     */ {
        /* 104 */
        String msg = ChatColor.translateAlternateColorCodes('&',Main.prefix + Messages.cfg.getString("godmode5") );
        /* 105 */

            if (e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();
            /* 107 */
            if (god.contains(p))
                /*     */ {
                /* 109 */
                e.setCancelled(true);
                /*     */
                if (e.getDamager() instanceof Player) {
                    e.getDamager().sendMessage(msg);
                }
            }
                /* 111 */

                /*     */
            }
            /*     */

        /*     */
    }
    /*     */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Commands\CMDgodmode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */