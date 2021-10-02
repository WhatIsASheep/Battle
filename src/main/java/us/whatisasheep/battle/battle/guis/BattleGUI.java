package us.whatisasheep.battle.battle.guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;


public class BattleGUI implements Listener {

    public void openBattleInventory(Player player) {
        //Creates the GUI
        Inventory inventory = Bukkit.createInventory(player, 27, ChatColor.GRAY + "Choose a Gamemode");

        //Creates filler items
        ItemStack empty = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta emptymeta = empty.getItemMeta();
        emptymeta.setDisplayName(" ");
        empty.setItemMeta(emptymeta);

        //Creates the PVP item in the GUI
        ItemStack pvp = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta pvpmeta = pvp.getItemMeta();
        pvpmeta.setDisplayName(ChatColor.AQUA + "Player vs Player");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "You and another player go head to head in a epic battle.");
        pvpmeta.setLore(lore);
        pvp.setItemMeta(pvpmeta);

        //Creates the PVE item in the GUI
        ItemStack pve = new ItemStack(Material.ZOMBIE_HEAD);
        ItemMeta pvemeta = pve.getItemMeta();
        pvemeta.setDisplayName(ChatColor.AQUA + "Player vs Entity");
        pve.setItemMeta(pvemeta);

        //Sets the PVP and PVE items in the GUI. If there is a blank spot a filler item is placed.
        for(int inv = 0; inv < 27; inv++) {
            if(inv == 11) {
                inventory.setItem(inv, pvp);
            } else if (inv == 15) {
                inventory.setItem(inv, pve);
            } else {
                inventory.setItem(inv, empty);
            }
        }
        player.openInventory(inventory);
    }

    @EventHandler
    public void onInventoryClick (InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getCurrentItem() == null){
            return;
        } else if (event.getView().getTitle().equals(ChatColor.GRAY + "Choose a Gamemode")){
            event.setCancelled(true);
            //PVP
            if (event.getCurrentItem().getType().equals(Material.DIAMOND_SWORD)){
                new ClassGUI().openPvPInventory(player);
                player.getInventory().clear();
            }
            //PVE
            if (event.getCurrentItem().getType().equals(Material.ZOMBIE_HEAD)){
                player.sendMessage(ChatColor.YELLOW + "Coming Soon...");
                player.closeInventory();
            }
        }
    }

}
