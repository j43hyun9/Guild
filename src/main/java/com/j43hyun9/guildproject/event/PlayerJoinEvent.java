package com.j43hyun9.guildproject.event;

import com.j43hyun9.guildproject.file.UserFile;
import net.kyori.adventure.text.ComponentBuilder;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PlayerJoinEvent implements Listener {

    Plugin plugin;
    UserFile userfile;
    Map<Player, Map> playerYamlMap;

    public PlayerJoinEvent(Plugin plugin, UserFile userfile) {
        this.plugin = plugin;
        this.userfile = userfile;
        playerYamlMap = new HashMap<>();
    }

    @EventHandler
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String player_uuid = player.getUniqueId().toString();
        File userfolder = userfile.getFile("userfile");
        File userfile = new File(userfolder.toString() + "\\" + player_uuid + ".yaml");

        if(userfile.exists()) {
            for(int i=0; i<5; i++) player.sendMessage(" ");
            player.sendMessage("§b<System> §e" + player.getName() + "님 재방문을 환영합니다.§f");
            for(int i=0; i<5; i++) player.sendMessage(" ");
        } else {
            for(int i=0; i<5; i++) player.sendMessage(" ");
            player.sendMessage("§b<System> §e" + player.getName() + "님 첫방문을 환영합니다.§f");
            for(int i=0; i<5; i++) player.sendMessage(" ");
            /*DumperOptions options = new DumperOptions();
            options.setIndent(4); // YAML 파일의 들여쓰기를 4로 설정
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK); // 블록 스타일 사용

            Yaml yaml = new Yaml(options);*/
            // YAML에 쓸 데이터 생성
            Map<String, Object> data = new HashMap<>();
            data.put("name", player.getName());
            data.put("guild", "none");

            // YAML 파일에 데이터 작성
            try (FileWriter writer = new FileWriter(userfile)) {
//                yaml.dump(data, writer);
                playerYamlMap.put(player, data);
                System.out.println("YAML 파일이 성공적으로 생성되었습니다.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
