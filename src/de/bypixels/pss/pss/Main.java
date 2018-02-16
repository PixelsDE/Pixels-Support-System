/*     */
package de.bypixels.pss.pss;
/*     */
/*     */

import de.bypixels.pss.CMDevents.EVENTJoin;
import de.bypixels.pss.CMDevents.EVENTPlayers;
import de.bypixels.pss.CMDevents.EVENTchat;
import de.bypixels.pss.CMDevents.EVENTdeath;
import de.bypixels.pss.commands.*;
import de.bypixels.pss.CMDevents.EVENTVanish;
import de.bypixels.pss.gui.StartGUI;
import de.bypixels.pss.onoff.ONOFF1;
import de.bypixels.pss.onoff.ONOFF2;
import de.bypixels.pss.util.Autoupdater;
import de.bypixels.pss.util.Lag;
import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

import java.io.IOException;
import java.util.ArrayList;

/*     */
/*     */ public class Main extends org.bukkit.plugin.java.JavaPlugin implements Listener
        /*     */ {
    /*     */   public static Main plugin;
    /*     */
    public static String prefix = Settings.cfg.getString("Prefix");

    /*  29 */   public static ArrayList<Player> hide = new ArrayList();

    /*  31 */   public static boolean wartung = false;

    /*     */
    public static Main getPlugin()
    /*     */ {
        /*  88 */
        return plugin;
        /*     */
    }

    public static void main(String[] args) {

    }

    /*     */
    /*     */
    public void onEnable() {
        /*  38 */
        plugin = this;


        EVENTPlayers.setCfg();
        Settings.setSettings();
        Messages.setMessages();
        CMDmute.setmutes();
        CMDchest.setbackpack();
        if (Settings.cfg.getBoolean("workmode") == true){
            wartung = true;
        }else{
            wartung = false;
        }

        if (Settings.cfg.getBoolean("pvp") == false){
            ONOFF2.pvp = false;
        }else{
            ONOFF2.pvp = true;
        }

        init();




        new Autoupdater(this).checkUpdate("41971");

        Bukkit.getConsoleSender().sendMessage("§a-> §7[§6PSS§7] §aPixels-Support-System has been enabled!");

    }

    /*     */
    public void init() {
        /*     */
        Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Lag(), 100L, 1L);
        /*  44 */
        PluginManager pm = Bukkit.getPluginManager();
        /*     */
        /*  46 */
        getCommand("gui").setExecutor(new StartGUI(this));
        /*  47 */
        getCommand("mute").setExecutor(new CMDmute(this));
        /*  48 */
        getCommand("unmute").setExecutor(new CMDunmute(this));
        /*  49 */
        getCommand("joinmessage").setExecutor(new CMDjoinmessage(this));
        /*  50 */
        getCommand("pss").setExecutor(new CMDinfo(this));

        getCommand("setcmd").setExecutor(new CMDsetcmd(this));
        /*  51 */
        getCommand("crash").setExecutor(new CMDcrash(this));
        /*  52 */
        getCommand("chest").setExecutor(new CMDchest(this));
        /*  53 */
        getCommand("invsee").setExecutor(new CMDInvsee(this));

        getCommand("config").setExecutor(new CMDreload(this));
        /*  54 */
        getCommand("show").setExecutor(new CMDshow(this));
        /*  55 */
        getCommand("hide").setExecutor(new CMDshow(this));
        /*  56 */
        getCommand("vanish").setExecutor(new CMDvanish(this));

        getCommand("pvp").setExecutor(new CMDpvp(this));
        /*  57 */
        getCommand("lag").setExecutor(new CMDlag(this));

        getCommand("clearlag").setExecutor(new CMDclearlag(this));

        getCommand("maintenance").setExecutor(new CMDmaintenancemode(this));
        /*  58 */
        getCommand("gm").setExecutor(new CMDgm(this));
        /*  59 */
        getCommand("fly").setExecutor(new CMDfly(this));
        /*  60 */
        getCommand("chat").setExecutor(new CMDchat(this));
        /*  61 */
        getCommand("heal").setExecutor(new CMDheal(this));
        /*  62 */
        getCommand("build").setExecutor(new CMDbuild(this));
        /*  63 */
        getCommand("godmode").setExecutor(new CMDgodmode(this));
        /*  64 */
        getCommand("players").setExecutor(new CMDplayers(this));
        /*     */
        getCommand("deathmessage").setExecutor(new CMDdeathmessage(this));
//
        getCommand("msg").setExecutor(new CMDmsg(this));

        getCommand("ping").setExecutor(new CMDping(this));

        getCommand("socialspy").setExecutor(new CMDsocialspy(this));
        /*  66 */
        pm.registerEvents(new de.bypixels.pss.CMDevents.EVENTInvClose(this), this);
        /*  67 */
        pm.registerEvents(new EVENTPlayers(this), this);
        /*  68 */
        pm.registerEvents(new de.bypixels.pss.events.InvClick1(this), this);
        /*  69 */
        pm.registerEvents(new de.bypixels.pss.events.InvClick2(this), this);
        /*  70 */
        pm.registerEvents(new de.bypixels.pss.events.InvClick3(this), this);
        /*  71 */
        pm.registerEvents(new de.bypixels.pss.events.InvClickBack1(this), this);
        /*  72 */
        pm.registerEvents(new de.bypixels.pss.events.InvClickBack2(this), this);
        /*  73 */
        pm.registerEvents(new de.bypixels.pss.events.InvClickWork(this), this);
        /*  74 */
        pm.registerEvents(new EVENTdeath(this), this);

        pm.registerEvents(new EVENTJoin(this), this);
        /*  75 */
        pm.registerEvents(new de.bypixels.pss.onoff.ONOFF1(this), this);
        /*  76 */
        pm.registerEvents(new de.bypixels.pss.onoff.ONOFF2(this), this);
        /*  77 */
        pm.registerEvents(new de.bypixels.pss.onoff.ONOFF3(this), this);
        /*  78 */
        pm.registerEvents(new de.bypixels.pss.CMDevents.EVENTCrash(this), this);
        /*  79 */
        pm.registerEvents(new EVENTchat(this), this);
        /*  80 */
        pm.registerEvents(new EVENTVanish(this), this);
        /*  81 */
        pm.registerEvents(new de.bypixels.pss.CMDevents.EVENTBreak(this), this);
        /*  82 */
        pm.registerEvents(new CMDgodmode(this), this);
        /*  83 */
        pm.registerEvents(this, this);


        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(Settings.file);
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(Messages.file);
        YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(CMDchest.file);
        YamlConfiguration cfg3 = YamlConfiguration.loadConfiguration(CMDmute.file);
        YamlConfiguration cfg4 = YamlConfiguration.loadConfiguration(EVENTPlayers.file);

        try {
            cfg.load(Settings.file);
            cfg1.load(Messages.file);
            cfg2.load(CMDmute.file);
            cfg3.load(CMDchest.file);
            cfg4.load(EVENTPlayers.file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

        this.prefix = Settings.cfg.getString("Prefix");
    }
    /*     */

    /*     */
    /*     */
    public void onDisable() {
        /*  92 */
        Bukkit.getConsoleSender().sendMessage("§c-> §7[§6PSS§7] §cPixels-Support-System has been disabled!");
        /*     */


    }
    /*     */

}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\PSS\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */