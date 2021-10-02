package us.whatisasheep.battle;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import us.whatisasheep.battle.battle.BattleGame;
import us.whatisasheep.battle.battle.BattleGameManager;
import us.whatisasheep.battle.battle.cmds.BattleCMDs;
import us.whatisasheep.battle.battle.guis.*;
import us.whatisasheep.battle.battle.listners.OnDeathRespawn;
import us.whatisasheep.battle.battle.listners.OnInteractDrop;
import us.whatisasheep.battle.battle.listners.OnJoinLeave;
import us.whatisasheep.battle.cmds.EnderChest;
import us.whatisasheep.battle.cmds.Fly;

import java.util.ArrayList;
import java.util.UUID;

public class Battle extends JavaPlugin {
    private BattleGame battleGame;
    private static Battle instance;
    private ArrayList<UUID> battlePlayers = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;

        BattleGameManager.getInstance().scheduleQueueCheck();

        //COMMANDS
        getCommand("EnderChest").setExecutor(new EnderChest());
        getCommand("Fly").setExecutor(new Fly());
        getCommand("Battle").setExecutor(new BattleCMDs());

        //LISTENERS
        getServer().getPluginManager().registerEvents(new BattleGUI(), this);
        getServer().getPluginManager().registerEvents(new ClassGUI(), this);
        getServer().getPluginManager().registerEvents(new SwordsmanGUI(), this);
        getServer().getPluginManager().registerEvents(new ArcherGUI(), this);
        getServer().getPluginManager().registerEvents(new TankGUI(), this);
        getServer().getPluginManager().registerEvents(new OnJoinLeave(), this);
        getServer().getPluginManager().registerEvents(new OnInteractDrop(), this);
        getServer().getPluginManager().registerEvents(new OnDeathRespawn(), this);

        //Sends a message to the console that the plugin has been enabled.
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Battle: Plugin Enabled");
    }

    @Override
    public void onDisable() {
        instance = null;

        //Sends a message to the console that the plugin has been disabled.
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "Battle: Plugin Disabled");
    }

    public static Battle getInstance() {
        return instance;

    }

    public ArrayList<UUID> getBattlePlayers() {
        return battlePlayers;
    }
}
