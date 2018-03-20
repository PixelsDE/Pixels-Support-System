/*     */ package de.bypixels.pss.events;
/*     */ 
/*     */ import de.bypixels.pss.pss.Main;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.DyeColor;
/*     */ import org.bukkit.Material;
/*     */
/*     */ import org.bukkit.Sound;
import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.material.Wool;
/*     */ 
/*     */ public class InvClick2
/*     */   implements Listener
/*     */ {
/*     */   private Main plugin;
/*     */   
/*     */   public InvClick2(Main plugin)
/*     */   {
/*  24 */     this.plugin = plugin;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onClick(InventoryClickEvent e)
/*     */   {
/*  30 */     if (e.getClickedInventory().getTitle().equalsIgnoreCase("§6Pixels Support System"))
/*     */     {
        if (e.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)) {
            Player  p = (Player) e.getWhoClicked();
           p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
        }
/*  32 */       e.setCancelled(true);
/*  33 */       if (e.getCurrentItem().getType().equals(Material.SIGN))
/*     */       {
/*  35 */         e.setCancelled(true);
/*  36 */         e.getWhoClicked().closeInventory();
/*  37 */         Inventory inv2 = Bukkit.createInventory(null, 54, "§bServer");
/*     */         
/*  39 */         ItemStack i2 = new ItemStack(Material.DIAMOND);
/*  40 */         ItemMeta im2 = i2.getItemMeta();
/*  41 */         im2.setDisplayName("§6Server");
/*  42 */         i2.setItemMeta(im2);
/*  43 */         inv2.setItem(4, i2);
/*     */         
/*  45 */         ItemStack i3 = new ItemStack(Material.PAPER);
/*  46 */         ItemMeta im3 = i3.getItemMeta();
/*  47 */         im3.setDisplayName("§aWhitelist");
/*  48 */         i3.setItemMeta(im3);
/*  49 */         inv2.setItem(10, i3);
/*     */         
/*  51 */         ItemStack i5 = new ItemStack(Material.IRON_SWORD);
/*  52 */         ItemMeta im5 = i5.getItemMeta();
/*  53 */         im5.setDisplayName("§aServer-PvP");
/*  54 */         i5.setItemMeta(im5);
/*  55 */         inv2.setItem(19, i5);
/*     */         
/*  57 */         ItemStack i6 = new ItemStack(Material.BARRIER);
/*  58 */         ItemMeta im6 = i6.getItemMeta();
/*  59 */         im6.setDisplayName("§aMaintenance-Mode");
/*  60 */         i6.setItemMeta(im6);
/*  61 */         inv2.setItem(28, i6);
/*     */         
/*  63 */         ItemStack i115 = new ItemStack(Material.SKULL_ITEM);
/*  64 */         ItemMeta im115 = i115.getItemMeta();
/*  65 */         im115.setDisplayName("§aMute-All");
/*  66 */         i115.setItemMeta(im115);
/*  67 */         inv2.setItem(37, i115);
/*     */         
/*  69 */         ItemStack i1 = new ItemStack(Material.IRON_DOOR);
/*  70 */         ItemMeta im1 = i1.getItemMeta();
/*  71 */         im1.setDisplayName("§cBack");
/*  72 */         i1.setItemMeta(im1);
/*  73 */         inv2.setItem(0, i1);
/*     */         
/*  75 */         ItemStack i99 = new ItemStack(Material.BED);
/*  76 */         ItemMeta im99 = i99.getItemMeta();
/*  77 */         im99.setDisplayName("§cCrash all Players!");
/*  78 */         i99.setItemMeta(im99);
/*  79 */         inv2.setItem(8, i99);
/*     */         
/*  81 */         Wool wool1 = new Wool(DyeColor.LIME);
/*  82 */         ItemStack i7 = wool1.toItemStack(1);
/*  83 */         ItemMeta im7 = i7.getItemMeta();
/*  84 */         im7.setDisplayName("§aWhitelist On");
/*  85 */         i7.setItemMeta(im7);
/*  86 */         inv2.setItem(12, i7);
/*     */         
/*  88 */         Wool wool2 = new Wool(DyeColor.SILVER);
/*  89 */         ItemStack i8 = wool2.toItemStack(1);
/*  90 */         ItemMeta im8 = i8.getItemMeta();
/*  91 */         im8.setDisplayName("§c");
/*  92 */         i8.setItemMeta(im8);
/*  93 */         inv2.setItem(13, i8);
/*     */         
/*  95 */         Wool wool3 = new Wool(DyeColor.RED);
/*  96 */         ItemStack i9 = wool3.toItemStack(1);
/*  97 */         ItemMeta im9 = i9.getItemMeta();
/*  98 */         im9.setDisplayName("§cWhitelist Off");
/*  99 */         i9.setItemMeta(im9);
/* 100 */         inv2.setItem(14, i9);
/*     */         
/* 102 */         Wool wool4 = new Wool(DyeColor.LIME);
/* 103 */         ItemStack i10 = wool4.toItemStack(1);
/* 104 */         ItemMeta im10 = i10.getItemMeta();
/* 105 */         im10.setDisplayName("§aServer-PvP On");
/* 106 */         i10.setItemMeta(im10);
/* 107 */         inv2.setItem(21, i10);
/*     */         
/* 109 */         Wool wool5 = new Wool(DyeColor.SILVER);
/* 110 */         ItemStack i11 = wool5.toItemStack(1);
/* 111 */         ItemMeta im11 = i11.getItemMeta();
/* 112 */         im11.setDisplayName("§c");
/* 113 */         i11.setItemMeta(im11);
/* 114 */         inv2.setItem(22, i11);
/*     */         
/* 116 */         Wool wool6 = new Wool(DyeColor.RED);
/* 117 */         ItemStack i12 = wool6.toItemStack(1);
/* 118 */         ItemMeta im12 = i12.getItemMeta();
/* 119 */         im12.setDisplayName("§cServer-PvP Off");
/* 120 */         i12.setItemMeta(im12);
/* 121 */         inv2.setItem(23, i12);
/*     */         
/* 123 */         Wool wool7 = new Wool(DyeColor.LIME);
/* 124 */         ItemStack i13 = wool7.toItemStack(1);
/* 125 */         ItemMeta im13 = i13.getItemMeta();
/* 126 */         im13.setDisplayName("§aMaintenance-Mode On");
/* 127 */         i13.setItemMeta(im13);
/* 128 */         inv2.setItem(30, i13);
/*     */         
/* 130 */         Wool wool8 = new Wool(DyeColor.SILVER);
/* 131 */         ItemStack i14 = wool8.toItemStack(1);
/* 132 */         ItemMeta im14 = i14.getItemMeta();
/* 133 */         im14.setDisplayName("§c");
/* 134 */         i14.setItemMeta(im14);
/* 135 */         inv2.setItem(31, i14);
/*     */         
/* 137 */         Wool wool111 = new Wool(DyeColor.RED);
/* 138 */         ItemStack i111 = wool111.toItemStack(1);
/* 139 */         ItemMeta im111 = i111.getItemMeta();
/* 140 */         im111.setDisplayName("§cMaintenance-Mode Off");
/* 141 */         i111.setItemMeta(im111);
/* 142 */         inv2.setItem(32, i111);
/*     */         
/* 144 */         Wool wool112 = new Wool(DyeColor.LIME);
/* 145 */         ItemStack i112 = wool112.toItemStack(1);
/* 146 */         ItemMeta im112 = i112.getItemMeta();
/* 147 */         im112.setDisplayName("§aMute-All On");
/* 148 */         i112.setItemMeta(im112);
/* 149 */         inv2.setItem(39, i112);
/*     */         
/* 151 */         Wool wool113 = new Wool(DyeColor.SILVER);
/* 152 */         ItemStack i113 = wool113.toItemStack(1);
/* 153 */         ItemMeta im113 = i113.getItemMeta();
/* 154 */         im113.setDisplayName("§c");
/* 155 */         i113.setItemMeta(im113);
/* 156 */         inv2.setItem(40, i113);
/*     */         
/* 158 */         Wool wool114 = new Wool(DyeColor.RED);
/* 159 */         ItemStack i114 = wool114.toItemStack(1);
/* 160 */         ItemMeta im114 = i114.getItemMeta();
/* 161 */         im114.setDisplayName("§cMute-All Off");
/* 162 */         i114.setItemMeta(im114);
/* 163 */         inv2.setItem(41, i114);
            ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
            ItemMeta glassmeta = glass.getItemMeta();
            glassmeta.setDisplayName("§a ");
            glass.setItemMeta(glassmeta);

            for (int a = 0; a < inv2.getSize(); a++) {
                if (inv2.getItem(a) == null) {

                    inv2.setItem(a, glass);
                }
            }  Player p = (Player)e.getWhoClicked();
            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1,1);
/* 165 */         e.getWhoClicked().openInventory(inv2);
/*     */       }
/*     */       else
/*     */       {
/* 169 */         e.setCancelled(true);
/* 170 */         Player player = (Player)e.getWhoClicked();
/* 171 */         player.updateInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\de.bypixels.de.bypixels.pss.pss.Events\InvClick2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */