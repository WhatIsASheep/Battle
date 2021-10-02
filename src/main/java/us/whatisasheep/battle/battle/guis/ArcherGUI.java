package us.whatisasheep.battle.battle.guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ArcherGUI implements Listener {

    public void openArcherInventory(Player player) {
        //Creates the GUI
        Inventory inventory = Bukkit.createInventory(player, 36, ChatColor.GRAY + "Archer");

        //Creates filler items
        ItemStack empty = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta emptymeta = empty.getItemMeta();
        emptymeta.setDisplayName(" ");
        empty.setItemMeta(emptymeta);

        //Back item
        ItemStack back = new ItemStack(Material.BARRIER, 1);
        ItemMeta backmeta = back.getItemMeta();
        backmeta.setDisplayName(ChatColor.DARK_RED + "Back");
        back.setItemMeta(backmeta);

        //Helm
        ItemStack helm = new ItemStack(Material.IRON_HELMET, 1);
        //Chest
        ItemStack chest = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        //Legs
        ItemStack legs = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        //Boots
        ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        //Sword
        ItemStack sword = new ItemStack(Material.WOODEN_SWORD, 1);
        //Bow
        ItemStack bow = new ItemStack(Material.BOW,1);
        ItemMeta bowmeta = bow.getItemMeta();
        bowmeta.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
        bowmeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bow.setItemMeta(bowmeta);
        //Arrow
        ItemStack arrow = new ItemStack(Material.ARROW, 1);

        for(int inv = 0; inv < 36; inv++) {
            if(inv == 10) {
                inventory.setItem(inv, helm);
            }else if (inv == 11) {
                inventory.setItem(inv, chest);
            }else if (inv == 12) {
                inventory.setItem(inv, legs);
            }else if (inv == 13) {
                inventory.setItem(inv, boots);
            }else if (inv == 19) {
                inventory.setItem(inv, sword);
            }else if (inv == 20) {
                inventory.setItem(inv, bow);
            }else if (inv == 21) {
                inventory.setItem(inv, arrow);
            }else if (inv == 35) {
                inventory.setItem(inv, back);
            }else {
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
        } else if (event.getView().getTitle().equals(ChatColor.GRAY + "Archer")) {
            event.setCancelled(true);

            if (event.getCurrentItem().getType().equals(Material.BARRIER)) {
                new ClassGUI().openPvPInventory(player);
            }
        }
    }

}