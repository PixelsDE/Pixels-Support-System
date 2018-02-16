package de.bypixels.pss.onoff;


import de.bypixels.pss.commands.CMDvanish;
import de.bypixels.pss.pss.Main;
import de.bypixels.pss.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Iterator;


/*     */ public class ONOFF1 implements org.bukkit.event.Listener
        /*     */ {
    /*     */
    /*  25 */
    /*     */   private Main plugin;

    /*     */
    /*     */
    public ONOFF1(Main plugin)
    /*     */ {
        /*  22 */
        this.plugin = plugin;
        /*     */
    }

    /*     */
    /*     */
    @EventHandler
    public void onnotuse(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory().getTitle().equalsIgnoreCase("bPlayers")) {
            if (p.hasPermission("pss.gui")) {
                e.setCancelled(true);
                p.updateInventory();
                if (e.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)) {
                    e.setCancelled(true);
                    p.updateInventory();
                }
            }
        }
    }

    @EventHandler
    /*     */ public void onClick(InventoryClickEvent event)
        /*     */ {
        try {
            /*  30 */
            if (event.getClickedInventory().getTitle().equalsIgnoreCase("§bPlayers"))
                /*     */ {
                if (event.getWhoClicked().hasPermission("pss.gui")) {
                    /*  32 */
                    event.setCancelled(true);
                    /*  33 */                    /* 124 */
                    if (event.getCurrentItem().hasItemMeta()) {

                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGamemode On"))
                            /*     */ {
                            /*  35 */
                            event.setCancelled(true);
                            /*  36 */
                            Player player = (Player) event.getWhoClicked();
                            /*     */
                            /*  38 */
                            event.getWhoClicked().setGameMode(org.bukkit.GameMode.CREATIVE);
                            /*  39 */
                            player.updateInventory();
                            /*     */
                            /*  41 */
                            String msg = Main.prefix + Messages.cfg.getString("gamemode1");
                            /*     */
                            /*  43 */
                            ((Player) event.getWhoClicked()).getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /*     */
                            /*  45 */
                            return;
                            /*     */
                        }
                        /*  47 */
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cGamemode Off"))
                            /*     */ {
                            /*  49 */
                            event.setCancelled(true);
                            /*  50 */
                            Player player = (Player) event.getWhoClicked();
                            /*     */
                            /*  52 */
                            player.setGameMode(org.bukkit.GameMode.SURVIVAL);
                            /*  53 */
                            player.updateInventory();
                            /*  54 */
                            String msg = Main.prefix + Messages.cfg.getString("gamemode2");
                            /*  55 */
                            ((Player) event.getWhoClicked()).getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /*     */
                            /*  57 */
                            return;
                            /*     */
                        }
                        /*     */
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*     */
    }

    /*     */
    /*     */
    @EventHandler
    /*     */ public void onClick2(InventoryClickEvent event)
    /*     */ {
        try {
            /*  65 */
            if (event.getClickedInventory().getTitle().equalsIgnoreCase("§bPlayers"))
                /*     */ {
                if (event.getWhoClicked().hasPermission("pss.gui")) {
                    /*  67 */
                    event.setCancelled(true);
                    Player player = (Player)event.getWhoClicked();

                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 1,1);
                    /*  68 */                    /* 124 */
                    if (event.getCurrentItem().hasItemMeta()) {

                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFly On"))
                            /*     */ {
                            /*  70 */
                            event.setCancelled(true);
                            /*  71 */

                            /*  72 */
                            ((Player) event.getWhoClicked()).setAllowFlight(true);
                            /*  73 */
                            ((Player) event.getWhoClicked()).setFlying(true);
                            /*  74 */
                            player.updateInventory();
                            /*  75 */
                            String msg = Main.prefix + Messages.cfg.getString("fly1");
                            /*  76 */
                            ((Player) event.getWhoClicked()).getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /*  77 */
                            return;
                            /*     */
                        }
                        /*  79 */
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cFly Off"))
                            /*     */ {
                            /*  81 */
                            event.setCancelled(true);
                            /*  82 */

                            /*  83 */
                            ((Player) event.getWhoClicked()).setAllowFlight(false);
                            /*  84 */
                            ((Player) event.getWhoClicked()).setFlying(false);
                            /*  85 */
                            player.updateInventory();
                            /*  86 */
                            String msg = Main.prefix + Messages.cfg.getString("fly2");
                            /*  87 */
                            ((Player) event.getWhoClicked()).getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /*  88 */
                            return;
                            /*     */
                        }
                        /*     */
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*     */
    }

    /*     */
    /*     */
    @EventHandler
    /*     */ public void onClick3(InventoryClickEvent event)
    /*     */ {
        /*  96 */
        try {
            if (event.getClickedInventory().getTitle().equalsIgnoreCase("§bPlayers"))
                /*     */ {
                if (event.getWhoClicked().hasPermission("pss.gui")) {
                    /*  98 */
                    event.setCancelled(true);
                    /*     */
                    /* 100 */                    /* 124 */
                    if (event.getCurrentItem().hasItemMeta()) {

                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVanish On"))
                            /*     */ {
                            /* 102 */
                            Iterator localIterator = Bukkit.getServer().getOnlinePlayers().iterator();
                            /* 103 */
                            if (localIterator.hasNext())
                                /*     */ {
                                /* 105 */
                                Player players = (Player) localIterator.next();
                                /*     */
                                /* 107 */
                                event.setCancelled(true);
                                /* 108 */
                                Player player = (Player) event.getWhoClicked();
                                /*     */
                                /* 110 */

                                /*     */
                                /* 112 */
                                this.plugin.hide.add(player);
                                /*     */
                                /* 114 */
                                player.showPlayer(players);
                                /* 115 */
                                players.showPlayer(player);
                                /* 116 */
                                ((Player) event.getWhoClicked()).hidePlayer(players);
                                /* 117 */
                                player.updateInventory();
                                /* 118 */
                                String msg = Main.prefix + Messages.cfg.getString("vanish1");
                                /* 119 */
                                ((Player) event.getWhoClicked()).getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*     */
                            }
                            /*     */
                            /*     */
                            /*     */
                        } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVanish Off"))
                            /*     */ {
                            /* 126 */
                            Iterator localIterator = Bukkit.getServer().getOnlinePlayers().iterator();
                            /* 127 */
                            if (localIterator.hasNext())
                                /*     */ {
                                /* 129 */
                                Player players = (Player) localIterator.next();
                                /* 130 */
                                event.setCancelled(true);
                                /* 131 */
                                Player player = (Player) event.getWhoClicked();
                                /* 132 */
                                player.updateInventory();
                                /* 133 */
                                players.showPlayer(player);
                                /* 134 */
                                String msg = Main.prefix + Messages.cfg.getString("vanish2");
                                /* 135 */
                                ((Player) event.getWhoClicked()).getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*     */
                                /* 137 */

                                /* 138 */
                                player.showPlayer(players);
                                /* 139 */
                                players.showPlayer(player);
                                /*     */
                                /* 141 */
                                return;
                                /*     */
                            }
                            /*     */
                        }
                        /*     */
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*     */
    }


    /*     */
    /*     */
    @EventHandler
    /*     */ public void onClick9(InventoryClickEvent event)
    /*     */ {
        try {
            /* 172 */
            if (event.getClickedInventory().getTitle().equalsIgnoreCase("§bPlayers"))
                /*     */ {
                if (event.getWhoClicked().hasPermission("pss.gui")) {
                    /* 174 */
                    event.setCancelled(true);
                    /* 175 */
                    if (event.getCurrentItem().hasItemMeta()) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aHeal Yourself"))
                            /*     */ {
                            /* 177 */
                            Player player = (Player) event.getWhoClicked();
                            /* 178 */
                            player.updateInventory();
                            /* 179 */
                            String msg = Main.prefix + Messages.cfg.getString("heal1");
                            /* 180 */
                            ((Player) event.getWhoClicked()).getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /*     */
                            /* 182 */
                            player.setHealth(20.0D);
                            /*     */
                            /* 184 */
                            player.setFoodLevel(20);
                            /* 185 */
                            event.setCancelled(true);
                            /*     */
                        }
                        /*     */
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*     */
    }

    /*     */
    /*     */
    @EventHandler
    /*     */ public void onClick10(InventoryClickEvent event)
    /*     */ {
        try {
            /* 193 */
            if (event.getClickedInventory().getTitle().equalsIgnoreCase("§bPlayers"))
                /*     */ {
                if (event.getWhoClicked().hasPermission("pss.gui")) {
                    /* 195 */
                    event.setCancelled(true);
                    /* 196 */
                    if (event.getCurrentItem().hasItemMeta()) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHeal All"))
                            /*     */ {
                            /* 198 */
                            Player player = (Player) event.getWhoClicked();
                            /* 199 */
                            Iterator localIterator = Bukkit.getOnlinePlayers().iterator();
                            /* 200 */
                            if (localIterator.hasNext())
                                /*     */ {
                                /* 202 */
                                Player all = (Player) localIterator.next();
                                /* 203 */
                                all.setHealth(20.0D);
                                /* 204 */
                                player.updateInventory();
                                /* 205 */
                                String msg1 = Main.prefix + Messages.cfg.getString("heal2").replace("%player%", player.getName());
                                /* 206 */
                                String msg3 = Main.prefix + Messages.cfg.getString("heal3");
                                /* 207 */
                                ((Player) event.getWhoClicked()).getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg3));
                                /* 208 */
                                all.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                /*     */
                                /* 210 */
                                event.setCancelled(true);
                                /* 211 */
                                return;
                                /*     */
                            }
                            /*     */
                        }
                    }
                    /*     */
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*     */
    }
    /*     */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\OnOff\ONOFF1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */