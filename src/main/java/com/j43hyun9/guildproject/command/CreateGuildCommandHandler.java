package com.j43hyun9.guildproject.command;

import com.j43hyun9.guildproject.event.GuildJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CreateGuildCommandHandler extends GuildCommand implements  GuildCommandHandler, Supplier<GuildCommandHandler> {

    Map<String, Object> guild = new HashMap<>();
    Plugin plugin;
    public CreateGuildCommandHandler(Plugin plugin) {
        super("생성");
        this.plugin = plugin;
    }

    @Override
    public GuildCommandHandler get() {
        return this;
    }

    @Override
    public void execute(Player player, String[] args) {
        if (args.length == 1) {
            player.sendMessage(" ");
            player.sendMessage("§c→ §f길드명을 입력해주시길 바랍니다.");
            player.sendMessage(" ");
        } else if (args.length == 2) {
            guild.put("hasGuild", true);
            guild.put("userName", player.getName());
            guild.put("guildName", args[1]);
            DumperOptions options = new DumperOptions();
            options.setIndent(4); // YAML 파일의 들여쓰기를 4로 설정
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK); // 블록 스타일 사용
            Yaml yaml = new Yaml(options);
            //FileWriter writer = null;

            try {
                FileWriter writer = new FileWriter(plugin.getDataFolder() + "\\userfile\\" + player.getUniqueId().toString() + ".yml");
                yaml.dump(guild, writer);
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            player.setPlayerListName(player.getName() + " §a" + args[1] + "§2길드");
            player.sendMessage(" ");
            player.sendMessage("§c→ §f길드가 생성되었습니다." + "§c " + args[1]);
            player.sendMessage(" ");
            player.sendMessage(" ");


        }
    }
}
