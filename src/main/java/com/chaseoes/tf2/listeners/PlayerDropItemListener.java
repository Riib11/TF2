package com.chaseoes.tf2.listeners;


import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import com.chaseoes.tf2.GameUtilities;
import com.chaseoes.tf2.utilities.Localizer;

public class PlayerDropItemListener implements Listener {

    @SuppressWarnings("deprecation")
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onItemDrop(PlayerDropItemEvent event) {
        if (GameUtilities.getUtilities().getGamePlayer(event.getPlayer()).isIngame()) {
            ItemStack[] armor = event.getPlayer().getInventory().getArmorContents();
            event.getPlayer().sendMessage(Localizer.getLocalizer().loadPrefixedMessage("CANT-DROP-ITEMS-INGAME"));
            event.setCancelled(true);
            event.getPlayer().getInventory().setArmorContents(armor);
            event.getPlayer().updateInventory();
        }
    }

}
