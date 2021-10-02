package us.whatisasheep.battle.battle.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.whatisasheep.battle.Battle;
import us.whatisasheep.battle.battle.guis.BattleGUI;

public class BattleCMDs implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player  = (Player) sender;

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("join")) {
                    //Opens the GUI for the player
                    new BattleGUI().openBattleInventory(player);

                }
                if (args[0].equalsIgnoreCase("leave")) {
                    if (!Battle.getInstance().getBattlePlayers().contains(player.getUniqueId())){
                        player.sendMessage(ChatColor.RED + "You are not in a queue!");
                    } else {
                        Battle.getInstance().getBattlePlayers().remove(player.getUniqueId());
                        player.sendMessage(ChatColor.RED + "You have left the queue!");
                    }

                }
            } else {
                //Opens the GUI for the player
                new BattleGUI().openBattleInventory(player);

            }

        }

        return true;
    }
}
