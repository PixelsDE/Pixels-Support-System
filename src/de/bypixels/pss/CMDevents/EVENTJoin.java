/*    */ package de.bypixels.pss.CMDevents;
/*    */ 
/*    */ import de.bypixels.pss.commands.CMDjoinmessage;
/*    */
import de.bypixels.pss.pss.Main;
/*    */
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.event.player.PlayerQuitEvent;
/*    */ 
/*    */ 
/*    */ public class EVENTJoin
/*    */   implements Listener
/*    */ {
/*    */   private Main plugin;
/*    */   
/*    */   public EVENTJoin(Main plugin)
/*    */   {
/* 20 */     this.plugin = plugin;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onJoin(PlayerJoinEvent event)
/*    */   {
/* 26 */     Player p = event.getPlayer();
/* 27 */     if (!CMDjoinmessage.joinp.contains(CMDjoinmessage.MSG))
/*    */     {
/* 29 */       event.setJoinMessage(null);
/*    */       
/* 31 */       return;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   @EventHandler
/*    */   public void onJoin(PlayerQuitEvent event)
/*    */   {
/* 40 */     Player p = event.getPlayer();
/* 41 */     if (!CMDjoinmessage.joinp.contains(CMDjoinmessage.MSG))
/*    */     {
/* 43 */       event.setQuitMessage(null);
/*    */       
/* 45 */       return;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\CMDEvents\EVENTJoin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */