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
import us.whatisasheep.battle.Battle;

import java.util.ArrayList;

public class ClassGUI implements Listener {

    public void openPvPInventory(Player player) {
        //Creates the GUI
        Inventory inventory = Bukkit.createInventory(player, 27, ChatColor.GRAY + "Choose a Class");

        //Creates filler items
        ItemStack empty = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta emptymeta = empty.getItemMeta();
        emptymeta.setDisplayName(" ");
        empty.setItemMeta(emptymeta);

        //Swordsman
        ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta swordmeta = sword.getItemMeta();
        swordmeta.setDisplayName(ChatColor.AQUA  + "Swordsman");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Left Click: To get the " + ChatColor.AQUA + "Swordsman" + ChatColor.GRAY + " Class.");
        lore.add(ChatColor.GRAY + "Right Click: To view the " + ChatColor.AQUA + "Swordsman" + ChatColor.GRAY + " Class.");
        swordmeta.setLore(lore);
        sword.setItemMeta(swordmeta);

        //Archer
        ItemStack archer = new ItemStack(Material.BOW, 1);
        ItemMeta archermeta = archer.getItemMeta();
        archermeta.setDisplayName(ChatColor.GREEN  + "Archer");
        ArrayList<String> lore2 = new ArrayList<String>();
        lore2.add(ChatColor.GRAY + "Left Click: To get the " + ChatColor.GREEN + "Archer" + ChatColor.GRAY + " Class.");
        lore2.add(ChatColor.GRAY + "Right Click: To view the " + ChatColor.GREEN + "Archer" + ChatColor.GRAY + " Class.");
        archermeta.setLore(lore2);
        archer.setItemMeta(archermeta);

        //Tank
        ItemStack tank = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemMeta tankmeta = tank.getItemMeta();
        tankmeta.setDisplayName(ChatColor.RED  + "Tank");
        ArrayList<String> lore3 = new ArrayList<String>();
        lore3.add(ChatColor.GRAY + "Left Click: To get the " + ChatColor.RED + "Tank" + ChatColor.GRAY + " Class.");
        lore3.add(ChatColor.GRAY + "Right Click: To view the " + ChatColor.RED + "Tank" + ChatColor.GRAY + " Class.");
        tankmeta.setLore(lore3);
        tank.setItemMeta(tankmeta);

        for(int inv = 0; inv < 27; inv++) {
            if(inv == 11) {
                inventory.setItem(inv, sword);
            }else if (inv == 13) {
                inventory.setItem(inv, archer);
            }else if (inv == 15) {
                inventory.setItem(inv, tank);
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
        } else if (event.getView().getTitle().equals(ChatColor.GRAY + "Choose a Class")) {
            event.setCancelled(true);
            //Swordsman
            if (event.getCurrentItem().getType().equals(Material.IRON_SWORD)) {
                if (event.isLeftClick()){
                    //UNBREAKABLE HELM
                    ItemStack helm = new ItemStack(Material.CHAINMAIL_HELMET);
                    ItemMeta helmmeta = helm.getItemMeta();
                    helmmeta.setUnbreakable(true);
                    helm.setItemMeta(helmmeta);
                    player.getInventory().setHelmet(new ItemStack(helm));
                    //UNBREAKABLE CHESTPLATE
                    ItemStack plate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                    ItemMeta platemeta = plate.getItemMeta();
                    platemeta.setUnbreakable(true);
                    plate.setItemMeta(platemeta);
                    player.getInventory().setChestplate(new ItemStack(plate));
                    //UNBREAKABLE LEGS
                    ItemStack leg = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                    ItemMeta legmeta = leg.getItemMeta();
                    legmeta.setUnbreakable(true);
                    leg.setItemMeta(legmeta);
                    player.getInventory().setLeggings(new ItemStack(leg));
                    //UNBREAKABLE BOOTS
                    ItemStack boot = new ItemStack(Material.CHAINMAIL_BOOTS);
                    ItemMeta bootmeta = boot.getItemMeta();
                    bootmeta.setUnbreakable(true);
                    boot.setItemMeta(bootmeta);
                    player.getInventory().setBoots(new ItemStack(boot));
                    //UNBREAKABLE SWORD
                    ItemStack sword = new ItemStack(Material.IRON_SWORD);
                    ItemMeta swordmeta = sword.getItemMeta();
                    swordmeta.setUnbreakable(true);
                    sword.setItemMeta(swordmeta);
                    player.getInventory().addItem(new ItemStack(sword));
                }
                if (event.isRightClick()){
                    new SwordsmanGUI().openSwordInventory(player);
                }

            }
            //Archer
            if (event.getCurrentItem().getType().equals(Material.BOW)) {
                if (event.isLeftClick()){
                    //UNBREAKABLE HELM
                    ItemStack helm = new ItemStack(Material.IRON_HELMET);
                    ItemMeta helmmeta = helm.getItemMeta();
                    helmmeta.setUnbreakable(true);
                    helm.setItemMeta(helmmeta);
                    player.getInventory().setHelmet(new ItemStack(helm));
                    //UNBREAKABLE CHESTPLATE
                    ItemStack plate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                    ItemMeta platemeta = plate.getItemMeta();
                    platemeta.setUnbreakable(true);
                    plate.setItemMeta(platemeta);
                    player.getInventory().setChestplate(new ItemStack(plate));
                    //UNBREAKABLE LEGS
                    ItemStack leg = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                    ItemMeta legmeta = leg.getItemMeta();
                    legmeta.setUnbreakable(true);
                    leg.setItemMeta(legmeta);
                    player.getInventory().setLeggings(new ItemStack(leg));
                    //UNBREAKABLE BOOTS
                    ItemStack boot = new ItemStack(Material.CHAINMAIL_BOOTS);
                    ItemMeta bootmeta = boot.getItemMeta();
                    bootmeta.setUnbreakable(true);
                    boot.setItemMeta(bootmeta);
                    player.getInventory().setBoots(new ItemStack(boot));
                    //UNBREAKABLE SWORD
                    ItemStack sword = new ItemStack(Material.WOODEN_SWORD);
                    ItemMeta swordmeta = sword.getItemMeta();
                    swordmeta.setUnbreakable(true);
                    sword.setItemMeta(swordmeta);
                    player.getInventory().addItem(new ItemStack(sword));
                    //UNBREAKABLE BOW
                    ItemStack bow = new ItemStack(Material.BOW);
                    ItemMeta bowmeta = bow.getItemMeta();
                    bowmeta.setUnbreakable(true);
                    bowmeta.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                    bowmeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    bow.setItemMeta(bowmeta);
                    player.getInventory().addItem(new ItemStack(bow));
                    //ARROW
                    ItemStack arrow = new ItemStack(Material.ARROW);
                    player.getInventory().addItem(new ItemStack(arrow));
                }
                if (event.isRightClick()){
                    new ArcherGUI().openArcherInventory(player);
                }

            }
            //Tank
            if (event.getCurrentItem().getType().equals(Material.IRON_CHESTPLATE)) {
                if (event.isLeftClick()){
                    //UNBREAKABLE HELM
                    ItemStack helm = new ItemStack(Material.CHAINMAIL_HELMET);
                    ItemMeta helmmeta = helm.getItemMeta();
                    helmmeta.setUnbreakable(true);
                    helm.setItemMeta(helmmeta);
                    player.getInventory().setHelmet(new ItemStack(helm));
                    //UNBREAKABLE CHESTPLATE
                    ItemStack plate = new ItemStack(Material.IRON_CHESTPLATE);
                    ItemMeta platemeta = plate.getItemMeta();
                    platemeta.setUnbreakable(true);
                    plate.setItemMeta(platemeta);
                    player.getInventory().setChestplate(new ItemStack(plate));
                    //UNBREAKABLE LEGS
                    ItemStack leg = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                    ItemMeta legmeta = leg.getItemMeta();
                    legmeta.setUnbreakable(true);
                    leg.setItemMeta(legmeta);
                    player.getInventory().setLeggings(new ItemStack(leg));
                    //UNBREAKABLE BOOTS
                    ItemStack boot = new ItemStack(Material.IRON_BOOTS);
                    ItemMeta bootmeta = boot.getItemMeta();
                    bootmeta.setUnbreakable(true);
                    boot.setItemMeta(bootmeta);
                    player.getInventory().setBoots(new ItemStack(boot));
                    //UNBREAKABLE SWORD
                    ItemStack sword = new ItemStack(Material.STONE_SWORD);
                    ItemMeta swordmeta = sword.getItemMeta();
                    swordmeta.setUnbreakable(true);
                    sword.setItemMeta(swordmeta);
                    player.getInventory().addItem(new ItemStack(sword));
                }
                if (event.isRightClick()){
                    new TankGUI().openTankInventory(player);
                }

            }
            if (event.isLeftClick() && !event.getCurrentItem().getType().equals(Material.BLACK_STAINED_GLASS_PANE)) {
                if (!Battle.getInstance().getBattlePlayers().contains(player.getUniqueId())) {
                    player.closeInventory();
                    if (Battle.getInstance().getBattlePlayers().size() >= 2) {
                        player.sendMessage(ChatColor.RED + "Game is full!");
                    } else {
                        Battle.getInstance().getBattlePlayers().add(player.getUniqueId());
                        player.sendMessage(ChatColor.GREEN + "Added you to the queue!");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You are already in the queue!");
                }
            }
        }
    }

}

