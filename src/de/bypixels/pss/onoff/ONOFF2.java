/*     */
package de.bypixels.pss.onoff;
/*     */
/*     */

import de.bypixels.pss.pss.Main;
import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListPingEvent;

import java.io.IOException;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */

/*     */
/*     */ public class ONOFF2 implements org.bukkit.event.Listener
        /*     */ {
    /*     */
    /*  27 */   public  static boolean pvp = true;
    /*  28 */   public java.util.ArrayList<Player> setpvp = new java.util.ArrayList();
    /*     */   private Main plugin;

    /*     */
    /*     */
    public ONOFF2(Main plugin)
    /*     */ {
        /*  24 */
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
        /*  33 */
        if (event.getWhoClicked().hasPermission("pss.gui")) {
            try {
                if (event.getClickedInventory().getTitle().equalsIgnoreCase("§bServer"))
                    /*     */ {
                    /*  35 */
                    event.setCancelled(true);
                    /*  36 */
                    if (event.getCurrentItem().hasItemMeta()) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aWhitelist On"))
                            /*     */ {
                            /*  38 */
                            event.setCancelled(true);
                            /*  39 */
                            Player player = (Player) event.getWhoClicked();
                            /*  40 */
                            Bukkit.getServer().setWhitelist(true);
                            /*  41 */
                            Bukkit.getWhitelistedPlayers().add(player);
                            /*  42 */
                            Bukkit.reloadWhitelist();
                            /*  43 */
                            player.updateInventory();
                            /*     */
                            /*  45 *//*  43 */
                            String msg = Main.prefix + Messages.cfg.getString("whitelist1");
                            /*  46 */
                            ((Player) event.getWhoClicked()).getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /*     */
                        }
                        /*  48 */
                        else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cWhitelist Off"))
                            /*     */ {
                            /*  50 */
                            event.setCancelled(true);
                            /*  51 */
                            Player player = (Player) event.getWhoClicked();
                            /*  52 */
                            Bukkit.getServer().setWhitelist(false);
                            /*  53 */
                            Bukkit.getWhitelistedPlayers().remove(player);
                            /*  54 */
                            Bukkit.reloadWhitelist();
                            /*  55 */
                            player.updateInventory();
                            /*  56 */
                            String msg = Main.prefix + Messages.cfg.getString("whitelist2");
                            /*  57 */
                            ((Player) event.getWhoClicked()).getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /*  }   */
                        }
                    }
                    /*     */
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            /*     }*/
        }
    }

    /*     */
    /*     */
    @EventHandler
    /*     */ public void onClick2(InventoryClickEvent event)
    /*     */ {
        try {
            /*  65 */
            if (event.getClickedInventory().getTitle().equalsIgnoreCase("§bServer"))
                /*     */ {
                /*  67 */
                if (event.getWhoClicked().hasPermission("pss.gui")) {
                    try {
                        event.setCancelled(true);
                        /*  68 */
                        if (event.getCurrentItem().hasItemMeta()) {
                            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMaintenance-Mode On")) {
                                /*  70 */
                                event.setCancelled(true);
                                /*     */
                                /*  72 */
                                Settings.cfg.set("workmode", true);
                                Main.wartung = true;
                                try {
                                    Settings.cfg.save(Settings.file);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                /*     */
                                /*  74 */
                                Player player = (Player) event.getWhoClicked();
                                /*  75 */
                                player.updateInventory();
                                /*     */
                                /*  77 /*  43 */
                                String msg = Main.prefix + Messages.cfg.getString("maintenance1");
                                /*  78 */
                                ((Player) event.getWhoClicked()).getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*     */
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
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
    /*     */
    @EventHandler
    /*     */ public void onClick3(InventoryClickEvent event)
    /*     */ {
        /*  86 */
        try {
            if (event.getClickedInventory().getTitle().equalsIgnoreCase("§bServer"))
                /*     */ {

                Player player = (Player)event.getWhoClicked();

                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1,1);

                if (event.getWhoClicked().hasPermission("pss.gui")) {
                    /*  88 */
                    if (event.getCurrentItem().hasItemMeta()) {
                        event.setCancelled(true);
                        /*  89 */
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cMaintenance-Mode Off"))
                            /*     */ {
                            /*  91 */
                            event.setCancelled(true);
                            /*     */
                            /*  93 */
                            Settings.cfg.set("workmode", false);
                            Main.wartung = false;
                            try {
                                Settings.cfg.save(Settings.file);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            /*  94 */

                            /*     */
                            /*  96 */
                            player.updateInventory();
                            /*/*  77 /*  43 */
                            String msg = Main.prefix + Messages.cfg.getString("maintenance2");
                            /*  98 */
                            ((Player) event.getWhoClicked()).getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /*     */
                        }
                        /*     */
                    }
                }
                /*    } */
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*     */
    /*     */
    @EventHandler
    public void onPing(ServerListPingEvent event)
    /*     */ {
        try {
            /* 106 */
            if (Main.wartung == true) {
                /* 108 */
                String msg = Messages.cfg.getString("motd");
                event.setMotd(ChatColor.translateAlternateColorCodes('&', msg));
                /* 110 */
                event.setMaxPlayers(0);
                /* 111 */
                return;
                /*     */
            } else {

                event.setMaxPlayers(Settings.cfg.getInt("players"));
                /* 115 */
                event.setMotd(ChatColor.translateAlternateColorCodes('&', Settings.cfg.getString("motd")));
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    @EventHandler
    /*     */ public void onEnter(PlayerJoinEvent event)
    /*     */ {
        /* 131 */
        try {
            Player p = event.getPlayer();
            /* 132 */
            if (p.hasPermission("pss.bypass")) {
                if (Main.wartung == true) {
                    String msg = Main.prefix + Messages.cfg.getString("motd");
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                }
            } else {
                /* 134 */
                if (Main.wartung == true) {

                    String msg = Main.prefix + Messages.cfg.getString("motd");
                    /* 138 */
                    event.getPlayer().kickPlayer(ChatColor.translateAlternateColorCodes('&', msg));
                }
                /*     */
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*     */
    }

    /*     */


    /*     */
    @EventHandler
    /*     */ public void onClick4(InventoryClickEvent event) {
        /* 145 */
        try {

            if (event.getClickedInventory().getTitle().equalsIgnoreCase("§bServer"))
                /*     */ {
                /* 147 */
                if (event.getWhoClicked().hasPermission("pss.gui")) {
                    event.setCancelled(true);
                    /* 148 */
                    if (event.getCurrentItem().hasItemMeta()) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aServer-PvP On"))
                            /*     */ {
                            /* 150 */
                            Player player = (Player) event.getWhoClicked();
                            /*     */
                            /* 152 */
                            String msg = Main.prefix + Messages.cfg.getString("pvp1");
                            /* 153 */
                            player.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /*     */
                            /* 155 */
                            this.setpvp.add(player);
                            /* 156 */
                            event.setCancelled(true);
                            /*     */
                            /* 158 */
                            this.pvp = true;
                            /* 159 */
                            player.updateInventory();
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
    /*     */
    @EventHandler
    /*     */ public void onClick5(InventoryClickEvent event)
    /*     */ {
        /* 168 */
        try {
            if (event.getClickedInventory().getTitle().equalsIgnoreCase("§bServer"))
                /*     */ {
                /* 170 */
                if (event.getWhoClicked().hasPermission("pss.gui")) {
                    event.setCancelled(true);
                    /* 171 */
                    if (event.getCurrentItem().hasItemMeta()) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cServer-PvP Off"))
                            /*     */ {
                            /*     */
                            /* 174 */
                            Player player = (Player) event.getWhoClicked();
                            /*     */
                            /* 176 */
                            String msg = Main.prefix + Messages.cfg.getString("pvp2");
                            /* 177 */
                            player.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /* 178 */
                            event.setCancelled(true);
                            /*     */
                            /*     */
                            /*     */
                            /* 182 */
                            this.pvp = false;
                            /*     */
                            /* 184 */
                            player.updateInventory();
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
    /*     */ public void onDamage(EntityDamageByEntityEvent event)
    /*     */ {


        try {
            if ((event.getDamager() instanceof Player))
                /*     */ {
                /* 194 */


                /* 195 */
                Player typ = (Player) event.getDamager();
                /* 196 */
                if (this.pvp != true)
                    /*     */ {
                    /* 198 */
                    event.setCancelled(true);
                    /* 199 */
                    event.setDamage(0.0D);
                    /*     */
                }
                /*     */
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*     */
    }
    /*     */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\OnOff\ONOFF2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */