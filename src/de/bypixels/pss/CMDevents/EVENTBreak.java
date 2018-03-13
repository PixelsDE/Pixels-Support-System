/*    */
package de.bypixels.pss.CMDevents;
/*    */
/*    */

import de.bypixels.pss.commands.CMDBuild;

import de.bypixels.pss.pss.Main;
import de.bypixels.pss.util.Messages;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

/*    */ public class EVENTBreak implements org.bukkit.event.Listener
        /*    */ {
    /*    */   private Main plugin;

    public EVENTBreak(Main plugin)
    /*    */ {
        /* 17 */
        this.plugin = plugin;
        /*    */
    }



    @EventHandler
    public void onBreak(BlockBreakEvent event)
    /*    */ {
        /* 23 */
        Player player = event.getPlayer();
        /* 24 */
        if (!CMDBuild.buildlist.contains(player))
            /*    */ {
            event.setCancelled(true);
            String msg = Main.prefix + Messages.cfg.getString("build5").replace("%block%", event.getBlock().getType().toString());
            /* 42 */
            player.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            event.setCancelled(true);
        }else{

        }
        /*    */
    }

    @EventHandler
    /*    */ public void onPlace(BlockPlaceEvent event)
    /*    */ {
        /* 33 */        event.setCancelled(true);
        Player player = event.getPlayer();
        /* 34 */
        if (!CMDBuild.buildlist.contains(player))
            /*    */ {
            /* 36 */
            event.setCancelled(true);
            /*    */
        }
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\CMDEvents\EVENTBreak.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */