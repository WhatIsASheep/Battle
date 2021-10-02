package us.whatisasheep.battle.battle.listners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.Random;

public class OnDeathRespawn implements Listener {

    @EventHandler
    public void onRespawnRandom (PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        Random rand = new Random();
        int random = rand.nextInt(11);

        if (random == 1) {
            event.setRespawnLocation(new Location(player.getWorld(), -33.5, 35, -25.5));
        } else if (random == 2) {
            event.setRespawnLocation(new Location(player.getWorld(), -59.5, 35, -18.5));
        } else if (random == 3) {
            event.setRespawnLocation(new Location(player.getWorld(), -28.5, 35, -10.5));
        } else if (random == 4) {
            event.setRespawnLocation(new Location(player.getWorld(), -47.5, 40, -27.5));
        } else if (random == 5) {
            event.setRespawnLocation(new Location(player.getWorld(), -55.5, 36, -24.5));
        } else if (random == 6) {
            event.setRespawnLocation(new Location(player.getWorld(), -49.5, 35, -38.5));
        } else if (random == 7) {
            event.setRespawnLocation(new Location(player.getWorld(), -48.5, 35, -17.5));
        } else if (random == 8) {
            event.setRespawnLocation(new Location(player.getWorld(), -50.5, 35, -11.5));
        } else if (random == 9) {
            event.setRespawnLocation(new Location(player.getWorld(), -64.5, 35, -33.5));
        } else if (random == 10) {
            event.setRespawnLocation(new Location(player.getWorld(), -65.5, 40, -22.5));
        } else {
            event.setRespawnLocation(new Location(player.getWorld(), -26.5, 35, -35.5));
        }
    }
    @EventHandler
    public void onDeath (PlayerDeathEvent event) {
        Player player = event.getEntity();

        if (player.getKiller() != null ){
            event.setDeathMessage(ChatColor.GRAY + player.getDisplayName() + " was killed by " + player.getKiller().getDisplayName() + "!");

        } else {
            event.setDeathMessage(ChatColor.GRAY + player.getDisplayName() + " did not even die to a player... that's embarrassing.");

        }
        event.setKeepInventory(true);
        event.setKeepLevel(true);
        event.getDrops().clear();


    }

}
