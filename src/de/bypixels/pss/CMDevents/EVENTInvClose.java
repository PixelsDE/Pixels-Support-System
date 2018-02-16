/*    */
package de.bypixels.pss.CMDevents;
/*    */
/*    */

import de.bypixels.pss.commands.CMDchest;
import de.bypixels.pss.pss.Main;
import de.bypixels.pss.util.Messages;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */

/*    */
/*    */ public class EVENTInvClose
        /*    */ implements Listener
        /*    */ {
    /*    */   private Main plugin;

    /*    */
    /*    */
    public EVENTInvClose(Main plugin)
    /*    */ {
        /* 20 */
        this.plugin = plugin;
        /*    */
    }

    /*    */
    /*    */
    @EventHandler
    /*    */ public void onClose(InventoryCloseEvent event)
    /*    */ {
        /* 26 */
        if ((event.getPlayer() instanceof Player))
            /*    */ {
            /* 28 */
            Player p = (Player) event.getPlayer();
            /* 29 */
            if (event.getInventory().getName().equalsIgnoreCase("§bBackpack"))
                /*    */ {
                /* 31 */
                String msg = Main.prefix +Messages.cfg.getString("chest2");
                /* 32 */
                CMDchest.saveChest(p, event.getInventory());
                /* 33 */
                p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                /* 34 */
                return;
                /*    */
            }
            /*    */
        }
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\CMDEvents\EVENTInvClose.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */