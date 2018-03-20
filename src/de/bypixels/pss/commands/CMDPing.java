package de.bypixels.pss.commands;

import de.bypixels.pss.pss.Main;
import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;

import net.minecraft.server.v1_12_R1.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class CMDPing implements CommandExecutor {


    private Main plugin;


    public CMDPing(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("ping")) {
            if (Settings.cfg.getBoolean("ping") == true) {
            if (sender instanceof Player) {

                    Player p = (Player) sender;
                    if (p.hasPermission("pss.ping")) {

                        if (args.length == 0){
                            //Wenn er sich selbst meint!

                            String msg = Main.prefix + Messages.cfg.getString("ping1").replace("%ping%", Integer.toString(getPing(p)));
                            /* 56 */
                            p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));

                        }else if (args.length == 1){
                            Player target = Bukkit.getPlayer(args[0]);
                            String msg = Main.prefix + Messages.cfg.getString("ping2").replace("%ping%", Integer.toString(getPing(target))).replace("%player%", target.getName());
                            /* 56 */
                            p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        }else{
                            String msg = Main.prefix + Messages.cfg.getString("arguments");
                            /* 56 */
                            p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        }
                    }else{
                        String msg = Main.prefix + Messages.cfg.getString("permissions");
                        /* 56 */
                        p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    }
                }else{
                if (args.length == 1){
                    if (Bukkit.getPlayer(args[0]) != null){
                        Player target = Bukkit.getPlayer(args[0]);
                        String msg = Main.prefix + Messages.cfg.getString("ping2").replace("%ping%", Integer.toString(getPing(target))).replace("%player%", target.getName());
                        /* 56 */
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    }else{
                        String msg =Main.prefix+ Messages.cfg.getString("online");
                        /* 48 */                 Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    }
                }else{
                    String msg =Main.prefix+ Messages.cfg.getString("arguments");
                    /* 48 */                 Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                }

            }
            }else{

            }
        }


        return false;
    }


    public int getPing(Player p) {
        CraftPlayer pingc = (CraftPlayer) p;
        EntityPlayer pinge = pingc.getHandle();
        return pinge.ping;
    }
}