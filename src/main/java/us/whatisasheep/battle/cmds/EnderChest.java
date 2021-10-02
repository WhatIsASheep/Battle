package us.whatisasheep.battle.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderChest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("battle.enderchest")){
                player.openInventory(player.getEnderChest());
                player.sendMessage(ChatColor.AQUA + "Ender Chest Opening!");
            } else {
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You do not have permission to do this command!");
            }
        }
        return true;
    }
}
