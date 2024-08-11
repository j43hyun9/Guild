package com.j43hyun9.guildproject.save;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.yaml.snakeyaml.Yaml;

import java.util.HashMap;
import java.util.Map;

public class SaveUserFile extends SaveYamlNormal{

    Plugin plugin;
    public SaveUserFile(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void save(Object... args) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (args.length > 0 && args[0] instanceof HashMap) {
                    HashMap<?, ?> tempMap = (HashMap<?, ?>) args[0];

                    // HashMap의 키와 값의 타입을 확인
                    if (tempMap.keySet().stream().allMatch(key -> key instanceof Player) &&
                            tempMap.values().stream().allMatch(value -> value instanceof Map)) {

                        // 안전하게 캐스팅
                        HashMap<Player, Map> playerYamlHashMap = (HashMap<Player, Map>) tempMap;
                        // playerYamlHashMap을 사용하여 작업 수행
                        System.out.println("Successfully casted to HashMap<Player, Map>");

                        // 예를 들어, playerYamlHashMap을 사용하여 각 플레이어의 YAML을 저장하는 작업 수행
                        for (Map.Entry<Player, Map> entry : playerYamlHashMap.entrySet()) {
                            Player player = entry.getKey();
                            Map map = entry.getValue();
                            // 저장 로직을 여기에 추가

                            System.out.println("Saving YAML for player: " + player.getName());
                        }
                    } else {
                        System.out.println("The provided object does not match the expected types.");
                    }
                } else {
                    System.out.println("No valid HashMap<Player, Yaml> provided.");
                }

            }
        }.runTaskTimer(plugin, 50L, 50L);
        // args 배열의 첫 번째 요소가 HashMap<Player, Yaml>인지 확인
    }
}
