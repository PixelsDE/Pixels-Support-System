/*    */ package de.bypixels.pss.events;
/*    */ 
/*    */ import de.bypixels.pss.pss.Main;
/*    */ import org.bukkit.Material;
/*    */
/*    */ import org.bukkit.Sound;
import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.inventory.InventoryClickEvent;
/*    */
/*    */

/*    */
/*    */ public class InvClickWork implements org.bukkit.event.Listener
/*    */ {
/*    */   private Main plugin;
/*    */   
/*    */   public InvClickWork(Main plugin)
/*    */   {
/* 18 */     this.plugin = plugin;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onClick(InventoryClickEvent event)
/*    */   {
/* 24 */     if (event.getClickedInventory().getTitle().equalsIgnoreCase("§bPlayers"))
/*    */     {
/* 26 */       event.setCancelled(true);
/* 27 */       if (event.getCurrentItem().getType().equals(Material.ANVIL))
/*    */       {
/* 29 */         if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aOpen Workbench"))
/*    */         {
/* 31 */           event.setCancelled(true);
/* 32 */           Player player = (Player)event.getWhoClicked();
/* 33 */           event.getWhoClicked().closeInventory();

                player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1,1);
/* 34 */           player.openWorkbench(null, true);
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 39 */         event.setCancelled(true);
/* 40 */         Player player = (Player)event.getWhoClicked();
/* 41 */         player.updateInventory();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\de.bypixels.de.bypixels.pss.pss.Events\InvClickWork.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */