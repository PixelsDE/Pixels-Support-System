/*    */
package de.bypixels.pss.CMDevents;
/*    */
/*    */

import de.bypixels.pss.pss.Main;
import de.bypixels.pss.util.Messages;

import net.minecraft.server.v1_12_R1.PacketPlayOutExplosion;
import net.minecraft.server.v1_12_R1.Vec3D;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Collections;
import java.util.Iterator;

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
/*    */
/*    */

/*    */
/*    */ public class EVENTCrash implements Listener
        /*    */ {
    /*    */   private Main plugin;

    /*    */
    /*    */
    public EVENTCrash(Main plugin)
    /*    */ {
        /* 28 */
        this.plugin = plugin;
        /*    */
    }

    /*    */    @EventHandler
    public void onnotuse(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory().getTitle().equalsIgnoreCase("bPlayers")) {
            if (p.hasPermission("pss.gui")) {
                e.setCancelled(true);

                if (e.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)) {
                    e.setCancelled(true);
                    p.updateInventory();
                }
            }
        }
    }
    /*    */
    @EventHandler
    /*    */ public void onClick(InventoryClickEvent event)
    /*    */ {
        /* 34 */
        if (event.getClickedInventory().getTitle().equalsIgnoreCase("§bServer"))
            /*    */ {
            /* 36 */if (event.getWhoClicked().hasPermission("pss.gui")){
            event.setCancelled(true);
            /* 37 */
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cCrash all Players!"))
                /*    */ {
                /* 39 */
                for (Player all : Bukkit.getOnlinePlayers()) {
                    /* 43 */
                    if (!all.equals(event.getWhoClicked())) {
                        ((CraftPlayer) all).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Float.MAX_VALUE, Collections.EMPTY_LIST, new Vec3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)));
                        /* 44 */
                        String msg = Main.prefix + Messages.cfg.getString("crash3");
                        /* 45 */
                        Player p = (Player) event.getWhoClicked();
                        /* 46 */
                        p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /* 47 */
                        return;
                        /*    */
                    }
                    /*   [ */
                }
            }

            /*   } */}
        }
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\CMDEvents\EVENTCrash.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */