package net.saikatsune.aurityuhc.commands;

import net.saikatsune.aurityuhc.AurityUHC;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCommand implements CommandExecutor {

    private AurityUHC aurityUHC = AurityUHC.getInstance();

    private String prefix = aurityUHC.getPrefix();

    private String mColor = aurityUHC.getmColor();
    private String sColor = aurityUHC.getsColor();

    @Override
    public boolean onCommand(CommandSender player, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("list")) {

            List<String> moderators = new ArrayList<>();

            for (Player allSpectators : aurityUHC.getSpectators()) {
                if(allSpectators.hasPermission("uhc.host")) {
                    moderators.add(allSpectators.getName());
                }
            }

            String[] stringArray = moderators.toArray(new String[moderators.size()]);

            player.sendMessage("§8§m---------------------------");
            player.sendMessage(prefix + sColor + "Online Players: " + mColor + Bukkit.getOnlinePlayers().size());
            player.sendMessage(prefix + sColor + "Alive Players: " + mColor + aurityUHC.getPlayers().size());
            player.sendMessage("");
            player.sendMessage(prefix + sColor + "Spectators: " + mColor + aurityUHC.getSpectators().size());
            player.sendMessage(prefix + sColor + "Moderators: " + mColor + Arrays.toString(stringArray));
            player.sendMessage("§8§m---------------------------");
        }
        return false;
    }
}