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
/*     */ public class InvClick3
/*     */   implements Listener
/*     */ {
/*     */   private Main plugin;
/*     */   
/*     */   public InvClick3(Main plugin)
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
            p.playSound(e.getWhoClicked().getLocation(), Sound.LEVEL_UP, 1, 1);
        }
/*  32 */       e.setCancelled(true);
/*  33 */       if (e.getCurrentItem().getType().equals(Material.DIAMOND))
/*     */       {
/*  35 */         e.setCancelled(true);
/*  36 */         e.getWhoClicked().closeInventory();
/*  37 */         Inventory inv1 = Bukkit.createInventory(e.getWhoClicked(), 54, "§bPlayers");
/*  38 */         ItemStack i2 = new ItemStack(Material.DIAMOND);
/*  39 */         ItemMeta im2 = i2.getItemMeta();
/*  40 */         im2.setDisplayName("§6Administration");
/*  41 */         i2.setItemMeta(im2);
/*  42 */         inv1.setItem(4, i2);
/*     */         
/*  44 */         ItemStack i3 = new ItemStack(Material.POTION);
/*  45 */         ItemMeta im3 = i3.getItemMeta();
/*  46 */         im3.setDisplayName("§aVanish");
/*  47 */         i3.setItemMeta(im3);
/*  48 */         inv1.setItem(10, i3);
/*     */         
/*  50 */         ItemStack i5 = new ItemStack(Material.STORAGE_MINECART);
/*  51 */         ItemMeta im5 = i5.getItemMeta();
/*  52 */         im5.setDisplayName("§aFly");
/*  53 */         i5.setItemMeta(im5);
/*  54 */         inv1.setItem(19, i5);
/*     */         
/*  56 */         ItemStack i6 = new ItemStack(Material.GOLDEN_APPLE);
/*  57 */         ItemMeta im6 = i6.getItemMeta();
/*  58 */         im6.setDisplayName("§aHealing-Mode");
/*  59 */         i6.setItemMeta(im6);
/*  60 */         inv1.setItem(28, i6);
/*     */         
/*  62 */         ItemStack i8 = new ItemStack(Material.WORKBENCH);
/*  63 */         ItemMeta im8 = i8.getItemMeta();
/*  64 */         im8.setDisplayName("§aGamemode");
/*  65 */         i8.setItemMeta(im8);
/*  66 */         inv1.setItem(37, i8);
/*     */         
/*  68 */         ItemStack i9 = new ItemStack(Material.ANVIL);
/*  69 */         ItemMeta im9 = i9.getItemMeta();
/*  70 */         im9.setDisplayName("§aOpen Workbench");
/*  71 */         i9.setItemMeta(im9);
/*  72 */         inv1.setItem(8, i9);
/*     */         
/*  74 */         ItemStack i10 = new ItemStack(Material.IRON_DOOR);
/*  75 */         ItemMeta im10 = i10.getItemMeta();
/*  76 */         im10.setDisplayName("§cBack");
/*  77 */         i10.setItemMeta(im10);
/*  78 */         inv1.setItem(0, i10);
/*     */         
/*  80 */         Wool wool1 = new Wool(DyeColor.LIME);
/*  81 */         ItemStack i17 = wool1.toItemStack(1);
/*  82 */         ItemMeta im17 = i17.getItemMeta();
/*  83 */         im17.setDisplayName("§aVanish On");
/*  84 */         i17.setItemMeta(im17);
/*  85 */         inv1.setItem(12, i17);
/*     */         
/*  87 */         ItemStack i9999 = new ItemStack(Material.REDSTONE);
/*  88 */         ItemMeta im9999 = i9999.getItemMeta();
/*  89 */         im9999.setDisplayName("§aTP and Kill-All");
/*  90 */         i9999.setItemMeta(im9999);
/*  91 */         inv1.setItem(46, i9999);
/*     */         
/*  93 */         Wool wool2 = new Wool(DyeColor.SILVER);
/*  94 */         ItemStack i18 = wool2.toItemStack(1);
/*  95 */         ItemMeta im18 = i18.getItemMeta();
/*  96 */         im18.setDisplayName("§c");
/*  97 */         i18.setItemMeta(im18);
/*  98 */         inv1.setItem(13, i18);
/*     */         
/* 100 */         Wool wool3 = new Wool(DyeColor.RED);
/* 101 */         ItemStack i99 = wool3.toItemStack(1);
/* 102 */         ItemMeta im99 = i99.getItemMeta();
/* 103 */         im99.setDisplayName("§cVanish Off");
/* 104 */         i99.setItemMeta(im99);
/* 105 */         inv1.setItem(14, i99);
/*     */         
/* 107 */         Wool wool4 = new Wool(DyeColor.LIME);
/* 108 */         ItemStack i110 = wool4.toItemStack(1);
/* 109 */         ItemMeta im110 = i110.getItemMeta();
/* 110 */         im110.setDisplayName("§aFly On");
/* 111 */         i110.setItemMeta(im110);
/* 112 */         inv1.setItem(21, i110);
/*     */         
/* 114 */         Wool wool5 = new Wool(DyeColor.SILVER);
/* 115 */         ItemStack i111 = wool5.toItemStack(1);
/* 116 */         ItemMeta im111 = i111.getItemMeta();
/* 117 */         im111.setDisplayName("§7");
/* 118 */         i111.setItemMeta(im111);
/* 119 */         inv1.setItem(22, i111);
/*     */         
/* 121 */         Wool wool6 = new Wool(DyeColor.RED);
/* 122 */         ItemStack i112 = wool6.toItemStack(1);
/* 123 */         ItemMeta im112 = i112.getItemMeta();
/* 124 */         im112.setDisplayName("§cFly Off");
/* 125 */         i112.setItemMeta(im112);
/* 126 */         inv1.setItem(23, i112);
/*     */         
/* 128 */         Wool wool7 = new Wool(DyeColor.LIME);
/* 129 */         ItemStack i113 = wool7.toItemStack(1);
/* 130 */         ItemMeta im113 = i113.getItemMeta();
/* 131 */         im113.setDisplayName("§aHeal Yourself");
/* 132 */         i113.setItemMeta(im113);
/* 133 */         inv1.setItem(30, i113);
/*     */         
/* 135 */         Wool wool8 = new Wool(DyeColor.SILVER);
/* 136 */         ItemStack i114 = wool8.toItemStack(1);
/* 137 */         ItemMeta im114 = i114.getItemMeta();
/* 138 */         im114.setDisplayName("§c");
/* 139 */         i114.setItemMeta(im114);
/* 140 */         inv1.setItem(31, i114);
/*     */         
/* 142 */         Wool wool9 = new Wool(DyeColor.RED);
/* 143 */         ItemStack i115 = wool9.toItemStack(1);
/* 144 */         ItemMeta im115 = i115.getItemMeta();
/* 145 */         im115.setDisplayName("§cHeal All");
/* 146 */         i115.setItemMeta(im115);
/* 147 */         inv1.setItem(32, i115);
/*     */         
/* 149 */         Wool wool10 = new Wool(DyeColor.LIME);
/* 150 */         ItemStack i116 = wool10.toItemStack(1);
/* 151 */         ItemMeta im116 = i116.getItemMeta();
/* 152 */         im116.setDisplayName("§aGamemode On");
/* 153 */         i116.setItemMeta(im116);
/* 154 */         inv1.setItem(39, i116);
/*     */         
/* 156 */         Wool wool11 = new Wool(DyeColor.SILVER);
/* 157 */         ItemStack i117 = wool11.toItemStack(1);
/* 158 */         ItemMeta im117 = i117.getItemMeta();
/* 159 */         im117.setDisplayName("§c");
/* 160 */         i117.setItemMeta(im117);
/* 161 */         inv1.setItem(40, i117);
/*     */         
/* 163 */         Wool wool12 = new Wool(DyeColor.RED);
/* 164 */         ItemStack i118 = wool12.toItemStack(1);
/* 165 */         ItemMeta im118 = i118.getItemMeta();
/* 166 */         im118.setDisplayName("§cGamemode Off");
/* 167 */         i118.setItemMeta(im118);
/* 168 */         inv1.setItem(41, i118);
/*     */         
/* 170 */         Wool wool1111 = new Wool(DyeColor.LIME);
/* 171 */         ItemStack i1111 = wool1111.toItemStack(1);
/* 172 */         ItemMeta im1111 = i1111.getItemMeta();
/* 173 */         im1111.setDisplayName("§aTP-All to you");
/* 174 */         i1111.setItemMeta(im1111);
/* 175 */         inv1.setItem(48, i1111);
/*     */         
/* 177 */         Wool wool1112 = new Wool(DyeColor.SILVER);
/* 178 */         ItemStack i1112 = wool1112.toItemStack(1);
/* 179 */         ItemMeta im1112 = i1112.getItemMeta();
/* 180 */         im1112.setDisplayName("§c");
/* 181 */         i1112.setItemMeta(im1112);
/* 182 */         inv1.setItem(49, i1112);
/*     */         
/* 184 */         Wool wool1113 = new Wool(DyeColor.RED);
/* 185 */         ItemStack i1113 = wool1113.toItemStack(1);
/* 186 */         ItemMeta im11113 = i1113.getItemMeta();
/* 187 */         im11113.setDisplayName("§cKill-All Online Players");
/* 188 */         i1113.setItemMeta(im11113);
/* 189 */         inv1.setItem(50, i1113);
            ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
            ItemMeta glassmeta = glass.getItemMeta();
            glassmeta.setDisplayName("§a ");
            glass.setItemMeta(glassmeta);

            for (int a = 0; a < inv1.getSize(); a++) {
                if (inv1.getItem(a) == null) {

                    inv1.setItem(a, glass);
                }
            }  Player p = (Player)e.getWhoClicked();
            p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1,1);
/* 191 */         e.getWhoClicked().openInventory(inv1);
/*     */       }
/*     */       else
/*     */       {
/* 195 */         e.setCancelled(true);
/* 196 */         Player player = (Player)e.getWhoClicked();
/* 197 */         player.updateInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\de.bypixels.de.bypixels.pss.pss.Events\InvClick3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */