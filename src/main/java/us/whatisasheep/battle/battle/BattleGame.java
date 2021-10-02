package us.whatisasheep.battle.battle;


import org.bukkit.Bukkit;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import us.whatisasheep.battle.Battle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class BattleGame implements Listener {

    Plugin plugin = Battle.getInstance();
    ArrayList<UUID> uuids = new ArrayList<>();
    HashMap<UUID,Integer> killsMap = new HashMap<>();

    //Object ination (aka calls this first in a new game)
    public BattleGame(Player player1, Player player2){
        initPlayers(player1, player2);
        Bukkit.getPluginManager().registerEvents(this, plugin);
        constantRunnable();
        start();
    }

    private void initPlayers(Player player1, Player player2){
        uuids.add(player1.getUniqueId());
        uuids.add(player2.getUniqueId());
        killsMap.put(player1.getUniqueId(), 0);
        killsMap.put(player2.getUniqueId(), 0);
    }

    public void start() {
        uuids.forEach(uuid -> {
            Player player = Bukkit.getPlayer(uuid);
            Random rand = new Random();
            int start_point = rand.nextInt(11);

            if (player != null) {

                if (start_point == 1) {
                    player.teleport(new Location(player.getWorld(), -33.5, 35, -25.5));
                } else if (start_point == 2) {
                    player.teleport(new Location(player.getWorld(), -59.5, 35, -18.5));
                } else if (start_point == 3) {
                    player.teleport(new Location(player.getWorld(), -28.5, 35, -10.5));
                } else if (start_point == 4) {
                    player.teleport(new Location(player.getWorld(), -47.5, 40, -27.5));
                } else if (start_point == 5) {
                    player.teleport(new Location(player.getWorld(), -55.5, 36, -24.5));
                } else if (start_point == 6) {
                    player.teleport(new Location(player.getWorld(), -49.5, 35, -38.5));
                } else if (start_point == 7) {
                    player.teleport(new Location(player.getWorld(), -48.5, 35, -17.5));
                } else if (start_point == 8) {
                    player.teleport(new Location(player.getWorld(), -50.5, 35, -11.5));
                } else if (start_point == 9) {
                    player.teleport(new Location(player.getWorld(), -64.5, 35, -33.5));
                } else if (start_point == 10) {
                    player.teleport(new Location(player.getWorld(), -65.5, 40, -22.5));
                } else {
                    player.teleport(new Location(player.getWorld(), -26.5, 35, -35.5));
                }

                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Let the battle begin!");

            }
        });
    }
    public void win(Player winner, Player loser){
        if (winner != null) {
            winner.teleport(new Location(Bukkit.getWorld("world"), -50.5, 50, -23.5));
            winner.getInventory().clear();
        }
        if (loser != null) {
            loser.teleport(new Location(Bukkit.getWorld("world"), -50.5, 50, -23.5));
            loser.getInventory().clear();
        }
        Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "The winner is " + winner.getDisplayName() + "!");
        BattleGameManager.getInstance().deleteGame(this);
    }
    public void constantRunnable(){
         new BukkitRunnable(){

             @Override
             public void run() {

                 uuids.forEach(uuid -> {
                     Player player = Bukkit.getPlayer(uuid);
                     player.setFoodLevel(20);
                     player.spigot().respawn();

                 });

             }
         }.runTaskTimer(plugin, 0L, 10L);
    }

    public ArrayList<UUID> getUuids() {
        return uuids;
    }


    private void addKill(Player player){
        int newKills = killsMap.get(player.getUniqueId()) + 1;
        killsMap.put(player.getUniqueId(), newKills);
    }

    private void checkWin(Player winner, Player loser){

        if (killsMap.get(winner.getUniqueId()) >= 3){
            new BukkitRunnable() {
                @Override
                public void run() {
                    win(winner, loser);
                }
            }.runTaskLater(plugin, 10L);
        }
    }

    private boolean checkInRange(double number, double max, double min) {
        return (number <= max) && (number >= min);
    }

    @EventHandler
    public void onRespawnRandom (PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if (!uuids.contains(player.getUniqueId())){
            return;
        }
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
        } else  {
            event.setRespawnLocation(new Location(player.getWorld(), -26.5, 35, -35.5));
        }
    }

    @EventHandler
    public void onDeath (PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (!uuids.contains(player.getUniqueId())){
            return;
        }

        if (player.getKiller() != null ){
            event.setDeathMessage(ChatColor.GRAY + player.getDisplayName() + " was killed by " + player.getKiller().getDisplayName() + "!");
            addKill(player.getKiller());
            checkWin(player.getKiller(), player);
        } else {
            event.setDeathMessage(ChatColor.GRAY + player.getDisplayName() + " did not even die to a player... that's embarrassing.");

        }
        event.setKeepInventory(true);
        event.setKeepLevel(true);
        event.getDrops().clear();


    }

}
