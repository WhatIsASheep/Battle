package us.whatisasheep.battle.battle;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import us.whatisasheep.battle.Battle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class BattleGameManager {

    Plugin plugin = Battle.getInstance();
    private static BattleGameManager instance;
    private HashMap<UUID, BattleGame> battleMap = new HashMap();

    public static BattleGameManager getInstance() {

        if (instance == null){
            instance = new BattleGameManager();
        }

        return instance;
    }

    public void startNewBattleGame(Player player1, Player player2) {

        BattleGame battleGame = new BattleGame(player1, player2);

        battleMap.put(player1.getUniqueId(), battleGame);
        battleMap.put(player2.getUniqueId(), battleGame);

    }

    public BattleGame getBattleGame(Player player){

        return battleMap.get(player.getUniqueId());

    }

    public void scheduleQueueCheck() {

        new BukkitRunnable() {

            @Override
            public void run() {
                ArrayList<Player> players = new ArrayList<>();
                Battle.getInstance().getBattlePlayers().forEach(uuid -> {
                    Player player = Bukkit.getPlayer(uuid);
                    if (player == null){
                        return;
                    }
                    players.add(player);
                });
                if (players.size() == 2){
                    players.forEach(player -> {
                        Battle.getInstance().getBattlePlayers().remove(player.getUniqueId());
                    });
                    startNewBattleGame(players.get(0), players.get(1));
                }
            }
        }.runTaskTimer(plugin, 0L, 20L);

    }
    public void deleteGame(BattleGame game){

        game.getUuids().forEach(uuid -> battleMap.remove(uuid));

    }

}

