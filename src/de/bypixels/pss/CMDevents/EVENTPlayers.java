/*    */
package de.bypixels.pss.CMDevents;
/*    */
/*    */

import de.bypixels.pss.pss.Main;
import de.bypixels.pss.util.Settings;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;

/*    */ public class EVENTPlayers implements Listener
        /*    */ {


    /*    */
    /* 23 */   public static File file = new File("plugins/Pixels-Support-System/players.yml");
    /* 24 */   public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
               public static int joinedplayers = cfg.getInt("Players.Joined");
    /*    */   private Main plugin;

    /*    */
    /*    */
    public EVENTPlayers(Main plugin)
    /*    */ {
        /* 20 */
        this.plugin = plugin;
        /*    */
    }

    /*    */

    public static void setCfg() {

        cfg.addDefault("Players.Joined", 0);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*    */
    @EventHandler
    /* 27 */ public void onConnect(PlayerJoinEvent e) {
        if (Settings.cfg.getBoolean("player") == true) {
            /* 28 */
            Player p = e.getPlayer();


            joinedplayers = joinedplayers + 1;
            cfg.set("Players.Player." + p.getName(), "Name: " + p.getName() + ", ID: " + p.getUniqueId().toString());
            cfg.set("Players.Joined", joinedplayers);


            try {
                /* 31 */
                cfg.save(file);
                /*    */
            }
            /*    */ catch (IOException e1) {
                /* 34 */
                e1.printStackTrace();
                /*    */
            }
            /*    */
        }
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\CMDEvents\EVENTPlayers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */