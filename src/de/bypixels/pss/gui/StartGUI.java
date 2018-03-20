/*    */
package de.bypixels.pss.gui;
/*    */
/*    */

import de.bypixels.pss.pss.Main;
import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
/*    */ public class StartGUI
        /*    */ implements CommandExecutor
        /*    */ {
    /*    */   private Main plugin;

    /*    */
    /*    */
    public StartGUI(Main plugin)
    /*    */ {
        /* 25 */
        this.plugin = plugin;
        /*    */
    }

    /*    */
    /*    */
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
    /*    */ {
        /* 30 */
        if (command.getName().equalsIgnoreCase("gui")) {
            /* 31 */
            if (Settings.cfg.getBoolean("gui") == true) {
                if ((commandSender instanceof Player)) {
                    /* 32 */
                    Player p = (Player) commandSender;
                    /* 33 */

                    /* 34 */
                    if (p.hasPermission("pss.gui")) {
                        Inventory inv = Bukkit.createInventory(null, 9, "§6Pixels Support System");
                        /* 36 */
                        ItemStack i = new ItemStack(Material.PAPER);
                        /* 37 */
                        ItemMeta im = i.getItemMeta();
                        /* 38 */
                        im.setDisplayName("§6Plugin by PixelsDE");
                        /* 39 */
                        i.setItemMeta(im);
                        /* 40 */
                        inv.setItem(4, i);
                        /* 41 */
                        ItemStack ii1 = new ItemStack(Material.DIAMOND);
                        /* 42 */
                        ItemMeta iim1 = ii1.getItemMeta();
                        /* 43 */
                        iim1.setDisplayName("§5Player");
                        /* 44 */
                        ii1.setItemMeta(iim1);
                        /* 45 */
                        inv.setItem(1, ii1);
                        /* 46 */
                        ItemStack ii2 = new ItemStack(Material.SIGN);
                        /* 47 */
                        ItemMeta iim2 = ii2.getItemMeta();
                        /* 48 */
                        iim2.setDisplayName("§aServer");
                        /* 49 */
                        ii2.setItemMeta(iim2);
                        /* 50 */
                        inv.setItem(7, ii2);
                        /*    */
                        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
                        ItemMeta glassmeta = glass.getItemMeta();
                        glassmeta.setDisplayName("§a ");
                        glass.setItemMeta(glassmeta);

                        for (int a = 0; a < inv.getSize(); a++) {
                            if (inv.getItem(a) == null) {

                                inv.setItem(a, glass);
                            }
                        }
                        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1, 1);
                        p.openInventory(inv);
                    } else {
                        /* 54 */
                        String msg = Main.prefix + Messages.cfg.getString("permissions");
                        /* 55 */
                        p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /* 56 */

                        /*    */
                    }
                    /*    */
                } else {
                    /* 59 */
                    String msg1 = Main.prefix + Messages.cfg.getString("player");
                    /* 64 */
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                    /* 61 */

                    /*    */
                }
                /*    */
            } else {
                /* 64 */

                /*    */
            }
            /*    */
        }
        /* 69 */
        return false;
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Gui\StartGUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */