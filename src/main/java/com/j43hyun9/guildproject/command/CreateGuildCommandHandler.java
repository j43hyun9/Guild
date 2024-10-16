package com.j43hyun9.guildproject.command;

import com.j43hyun9.guildproject.data.Guild;
import com.j43hyun9.guildproject.data.User;
import com.j43hyun9.guildproject.file.FileManager;
import com.j43hyun9.guildproject.utils.MyYaml;
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
    Map<String, Object> guild_data = new HashMap<>();
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
            User user = FileManager.getUserdata().get(player);
            Guild guild = new Guild(player, args[1]);
            user.setHasGuild(true);
            user.setName(player.getName());
            user.setGuildName(args[1]);
            //FileManager.getGuildfileMap().put(player, guild_data);
            FileManager.getUserdata().put(player, user); // 만약 이미 있어서 오류가난다면 기존 Map에 있는 player 데이터를 삭제처리 해주면 될거임.
            FileManager.getGuilddata().put(player, guild);
            player.setPlayerListName(player.getName() + " §a" + args[1] + "§2길드" + "길드장: "+ user.getName());
            player.sendMessage(" ");
            player.sendMessage("§c→ §f길드가 생성되었습니다." + "§c " + args[1]);
            player.sendMessage(" ");
            player.sendMessage(" ");


        }
    }
}
