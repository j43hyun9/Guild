package com.j43hyun9.guildproject.save;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.yaml.snakeyaml.Yaml;

import java.util.HashMap;
import java.util.Map;

public class SaveUserFile extends SaveYamlNormal implements AutoSave{

    Plugin plugin;
    public SaveUserFile(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void save(Object... args) {
        new BukkitRunnable() {
            @Override
            public void run() {


            }
        }.runTaskTimer(plugin, 50L, 50L);
        // args 배열의 첫 번째 요소가 HashMap<Player, Yaml>인지 확인
    }
}
