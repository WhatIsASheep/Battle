package us.whatisasheep.battle.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("battle.fly")){
                if (player.getAllowFlight()) {
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Flight Disabled");
                }else{
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Flight Enabled");
                }
            } else {
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You do not have permission to do this command!");
            }

        }

        return true;
    }
}
