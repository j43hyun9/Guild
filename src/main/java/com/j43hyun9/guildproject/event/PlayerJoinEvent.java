package com.j43hyun9.guildproject.event;

import com.j43hyun9.guildproject.data.Guild;
import com.j43hyun9.guildproject.data.User;
import com.j43hyun9.guildproject.file.FileManager;
import com.j43hyun9.guildproject.utils.MyYaml;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class PlayerJoinEvent implements Listener {


    public PlayerJoinEvent() {

    }

    @EventHandler
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String PLAYER_UUID = player.getUniqueId().toString();
        File userFolder = FileManager.getUserFolder();
        Path userFilePath = userFolder.toPath().resolve(PLAYER_UUID + ".yml");
        File userfile = userFilePath.toFile();

        Yaml yaml = MyYaml.getYaml();

        if (userfile.exists()) {
            for (int i = 0; i < 5; i++) player.sendMessage(" ");
            player.sendMessage("§b<System> §e" + player.getName() + "님 재방문을 환영합니다.§f");
            try {
                User user = yaml.loadAs(new FileInputStream(userfile), User.class);
                FileManager.getUserdata().put(player, user);
                if (user.hasGuild()) {
                    player.setPlayerListName(player.getName() + " §a" + user.getGuildName() + "§2길드");
                    if(user.isMaster()) {
                        File guildFolder = FileManager.getGuildFolder();
                        Path guildFilePath = guildFolder.toPath().resolve(user.getGuildName() + ".yml");
                        File guildfile = guildFilePath.toFile();
                        Guild guild = yaml.loadAs(new FileInputStream(guildfile), Guild.class);
                        FileManager.getGuilddata().put(player, guild);
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            for (int i = 0; i < 5; i++) player.sendMessage(" ");
        } else {
            for (int i = 0; i < 5; i++) player.sendMessage(" ");
            player.sendMessage("§b<System> §e" + player.getName() + "님 첫방문을 환영합니다.§f");
            for (int i = 0; i < 5; i++) player.sendMessage(" ");

            User user = new User(player, false, "none");
            FileManager.getUserdata().put(player, user);

        }
    }
}
