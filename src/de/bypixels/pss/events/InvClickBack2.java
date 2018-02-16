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
/*    */ public class InvClickBack2 implements org.bukkit.event.Listener
/*    */ {
/*    */   private Main plugin;
/*    */   
/*    */   public InvClickBack2(Main plugin)
/*    */   {
/* 18 */     this.plugin = plugin;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onClick(InventoryClickEvent event)
/*    */   {
/* 24 */     if (event.getClickedInventory().getTitle().equalsIgnoreCase("§bPlayers"))
/*    */     {
    if (event.getWhoClicked().hasPermission("pss.gui")){
/* 26 */       event.setCancelled(true);   if (event.getCurrentItem().hasItemMeta()) {
/* 27 */       if (event.getCurrentItem().getType().equals(Material.IRON_DOOR)) {
/* 28 */         if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBack"))
/*    */         {
/* 30 */           event.setCancelled(true);
/* 31 */           event.getWhoClicked().closeInventory();
/* 32 */           Player player = (Player)event.getWhoClicked();
/* 33 */           ((Player)event.getWhoClicked()).performCommand("gui");


                    player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1,1);
/*    */         }
/*    */         else
/*    */         {
/* 37 */           event.setCancelled(true);
/* 38 */           Player player = (Player)event.getWhoClicked();
/* 39 */           ((Player)event.getWhoClicked()).performCommand("gui");
/*    */         }
/*    */       }
/*    */     }}
/*    */   }}
/*    */ }


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\de.bypixels.de.bypixels.pss.pss.Events\InvClickBack2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */