/*    */ package de.bypixels.pss.util;
/*    */ 
/*    */ import com.avaje.ebeaninternal.server.core.Message;
import de.bypixels.pss.pss.Main;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.InputStreamReader;
/*    */
/*    */ import java.net.HttpURLConnection;
/*    */ import java.net.URL;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */
/*    */
/*    */

/*    */
/*    */ public class Autoupdater
/*    */ {
/*    */   private static Main plugin;
/*    */   
/*    */   public Autoupdater(Main plugin)
/*    */   {
/* 21 */     this.plugin = plugin;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void checkUpdate(String resourceId)
/*    */   {
/* 28 */     if (Settings.cfg.getBoolean("autoupdater") == true) {
/*    */       try
/*    */       {
/* 31 */         HttpURLConnection con = (HttpURLConnection)new URL("http://www.spigotmc.org/api/general.php").openConnection();
/* 32 */         con.setDoOutput(true);
/* 33 */         con.setRequestMethod("POST");
/* 34 */         con.getOutputStream().write(("key=98BE0FE67F88AB82B4C197FAF1DC3B69206EFDCC4D3B80FC83A00037510B99B4&resource=" + resourceId)
/* 35 */           .getBytes("UTF-8"));
/* 36 */         String version = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();
/* 37 */         if (!version.equals(Main.getPlugin().getDescription().getVersion())) {
/* 38 */           String msg = Main.prefix+Messages.cfg.getString("Autoupdate");
/* 39 */           Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
/*    */         }
/*    */         else {
/* 42 */             String msg =Main.prefix+ Messages.cfg.getString("Autoupdate_True");
/* 43 */           Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
/*    */         }
/*    */       } catch (Exception ex) {
/* 46 */         String msg =Main.prefix+ Messages.cfg.getString("Autoupdate_Error");

/* 47 */         Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Util\Autoupdater.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */