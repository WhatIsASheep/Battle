package us.whatisasheep.battle.battle.listners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class OnInteractDrop implements Listener {



    @EventHandler
    public void onInteract (PlayerInteractEvent event){
        if (!event.getPlayer().getDisplayName().equals("WhatIsASheep")){

            if (event.getClickedBlock() == null){
                return;
            }

            if (event.getClickedBlock().getType().equals(Material.SPRUCE_TRAPDOOR)) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType().equals(Material.BARREL)) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType().equals(Material.STONECUTTER)) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType().equals(Material.FURNACE)) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType().equals(Material.CRAFTING_TABLE)) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType().equals(Material.CHEST)) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType().equals(Material.TRAPPED_CHEST)) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType().equals(Material.ENCHANTING_TABLE)) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType().equals(Material.LECTERN)) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType().equals(Material.COMPOSTER)) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType().equals(Material.STONE_PRESSURE_PLATE)) {
                event.setCancelled(true);
            }
            if (event.getClickedBlock().getType().equals(Material.SPRUCE_PRESSURE_PLATE)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDrop (PlayerDropItemEvent event){
        ArrayList<Material> blocked = new ArrayList<Material>();
        //Swords
        blocked.add(Material.IRON_SWORD);
        blocked.add(Material.STONE_SWORD);
        blocked.add(Material.WOODEN_SWORD);
        //Chain
        blocked.add(Material.CHAINMAIL_HELMET);
        blocked.add(Material.CHAINMAIL_CHESTPLATE);
        blocked.add(Material.CHAINMAIL_LEGGINGS);
        blocked.add(Material.CHAINMAIL_BOOTS);
        //Iron
        blocked.add(Material.IRON_HELMET);
        blocked.add(Material.IRON_CHESTPLATE);
        blocked.add(Material.IRON_LEGGINGS);
        blocked.add(Material.IRON_BOOTS);
        //Bow & Arrow
        blocked.add(Material.BOW);
        blocked.add(Material.ARROW);
        if (blocked.contains(event.getItemDrop().getItemStack().getType())){
            event.setCancelled(true);
        }
    }
}
