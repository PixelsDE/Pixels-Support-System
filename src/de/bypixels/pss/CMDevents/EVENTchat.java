/*    */
package de.bypixels.pss.CMDevents;
/*    */
/*    */

import de.bypixels.pss.commands.CMDMute;
import de.bypixels.pss.pss.Main;
import de.bypixels.pss.util.Messages;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class EVENTchat
        /*    */ implements Listener
        /*    */ {
    /*    */   private Main plugin;

    /*    */
    /*    */
    public EVENTchat(Main plugin)
    /*    */ {
        /* 20 */
        this.plugin = plugin;
        /*    */
    }

    /*    */
    /*    */
    @EventHandler
    /*    */ public void onChat(AsyncPlayerChatEvent event)
    /*    */ {
        /* 26 */
        Player p = event.getPlayer();
        /* 27 */
        if (CMDMute.muted.contains(p) || CMDMute.cfg.getBoolean(p.getName()) == true)  {
            /* 29 */
            String msg = Main.prefix + Messages.cfg.getString("mute4");
            /*    */
            /* 31 */
            event.setCancelled(true);
            /* 32 */
            event.setMessage(null);
            /* 33 */
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            /* 34 */
            event.setCancelled(true);
            /*    */
        }
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\CMDEvents\EVENTchat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */