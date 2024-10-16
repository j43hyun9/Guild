package com.j43hyun9.guildproject.event;

import com.j43hyun9.guildproject.file.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Map;

public class PlayerQuitEvent implements Listener {

    Map<Player, Map> user_Data;

    public PlayerQuitEvent() {
        user_Data = FileManager.getUserfileMap();
    }


    @EventHandler
    public void onPlayerQuit(org.bukkit.event.player.PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if(user_Data.containsKey(player)) {
            user_Data.remove(player);
            Bukkit.getConsoleSender().sendMessage("Player Map Key Delete Success");
        } else {
            Bukkit.getConsoleSender().sendMessage("플레이어의 정보는 Map에 담겨야는데 없는 사람이 있음" + player.getName());
        }
    }

}
