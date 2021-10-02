package us.whatisasheep.battle.battle.listners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import us.whatisasheep.battle.Battle;

public class OnJoinLeave implements Listener {

    @EventHandler
    public void onJoin (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Location onJoin = new Location(Bukkit.getWorld("world"), -50.5, 50, -23.5);

        player.teleport(onJoin);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setGameMode(GameMode.ADVENTURE);

    }

    @EventHandler
    public void onLeave (PlayerQuitEvent event) {
        Player player = event.getPlayer();

        Battle.getInstance().getBattlePlayers().remove(player.getUniqueId());

        player.getInventory().clear();


    }

}
