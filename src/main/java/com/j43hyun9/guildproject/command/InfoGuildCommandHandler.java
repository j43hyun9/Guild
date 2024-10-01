package com.j43hyun9.guildproject.command;

import com.j43hyun9.guildproject.file.UserFile;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.function.Supplier;

public class InfoGuildCommandHandler extends GuildCommand implements GuildCommandHandler, Supplier<GuildCommandHandler> {
    public InfoGuildCommandHandler() {
        super("정보");
    }


    @Override
    public void execute(Player player, String[] args) {
        Yaml yaml = new Yaml();
        Map<String, Object> data = null;
        Map<String, Object> guild_data = null;
        try {
            data = yaml.load(new FileInputStream(new File(UserFile.userfile.toString() + "\\" + player.getUniqueId().toString())+".yml"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Boolean hasGuild = (Boolean) data.get("hasGuild");
        if (!hasGuild) {
            if (args.length == 1) {
                player.sendMessage(" ");
                player.sendMessage("§c→ §f길드명을 입력해주시길 바랍니다.");
                player.sendMessage(" ");
            } else if (args.length == 2) {
                try {
                    guild_data = yaml.load(new FileInputStream(new File(UserFile.guildfile.toString() +"\\" + args[1] +".yml")));
                } catch (FileNotFoundException e) {
                    player.sendMessage("존재하지 않는 길드명입니다. ");
                }
                if(guild_data != null) {
                    player.sendMessage(" ");
                    player.sendMessage("§b→ §f길드명: "+ args[2]);
                    player.sendMessage("§b→ §f길드장 "+ guild_data.get("guild_Master"));
                } else {
                    Bukkit.getConsoleSender().sendMessage("guild_data is null");
                }
            }
        } else if (hasGuild) {
            try {
                guild_data = yaml.load(new FileInputStream(new File(UserFile.guildfile.toString() +"\\" + (String) data.get("guildName"))+".yml"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            String guild_Name = (String) data.get("guildName");
            String guild_Master = (String) guild_data.get("guild_Master");
            if (args.length == 1) {
                player.sendMessage(" ");
                player.sendMessage("§b→ §f길드명: "+guild_Name);
                player.sendMessage("§b→ §f길드장: "+ guild_Master);
                player.sendMessage(" ");
            } else if (args.length == 2) {
                try {
                    guild_data = yaml.load(new FileInputStream(new File(UserFile.guildfile.toString() +"\\" + args[1] +".yml")));
                } catch (FileNotFoundException e) {
                    player.sendMessage("존재하지 않는 길드명입니다. ");
                    return;
                }
                if(guild_data != null) {
                    player.sendMessage(" ");
                    player.sendMessage("§b→ §f길드명: "+ args[1]);
                    player.sendMessage("§b→ §f길드장 "+ guild_data.get("guild_Master"));
                } else {
                    Bukkit.getConsoleSender().sendMessage("guild_data is null");
                }
            }
        }
    }

    @Override
    public GuildCommandHandler get() {
        return this;
    }
}
