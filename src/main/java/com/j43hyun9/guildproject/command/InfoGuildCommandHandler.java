package com.j43hyun9.guildproject.command;

import com.j43hyun9.guildproject.GuildProject;
import com.j43hyun9.guildproject.command.exception.NullGuildCommandException;
import com.j43hyun9.guildproject.data.Guild;
import com.j43hyun9.guildproject.data.User;
import com.j43hyun9.guildproject.file.FileManager;
import com.j43hyun9.guildproject.utils.Debugger;
import com.j43hyun9.guildproject.utils.MyYaml;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class InfoGuildCommandHandler extends GuildCommand implements GuildCommandHandler, Supplier<GuildCommandHandler> {
    public InfoGuildCommandHandler() {
        super("정보");
    }


    @Override
    public void execute(Player player, String[] args) {
        Yaml yaml = MyYaml.getYaml();
        User user = FileManager.getUserdata().get(player);
        if(user == null) {
            throw new NullPointerException();
            return;
        }
        //data = yaml.load(new FileInputStream(new File(FileManager.userfile.toString() + "\\" + player.getUniqueId().toString())+".yml"));

        if (!(user.hasGuild())) {
            if (args.length == 1) {
                player.sendMessage(" ");
                player.sendMessage("§c→ §f길드명을 입력해주시길 바랍니다.");
                player.sendMessage(" ");
            } else if (args.length == 2) {
                String targetValue = args[1];
                for (Map.Entry<Player, Guild> entry : FileManager.getGuilddata().entrySet()) {
                    Guild comp_target = entry.getValue();
                    if(targetValue.equals(comp_target.getGuildName())) {
                        String guildName = comp_target.getGuildName();
                        String guildMaster = entry.getKey().getName();
                        player.sendMessage(" ");
                        player.sendMessage("§b→ §f길드명: "+ guildName);
                        player.sendMessage("§b→ §f길드장: "+ guildMaster);
                        player.sendMessage(" ");
                        return;
                    }
                }
                player.sendMessage("존재하지 않는 길드입니다.");
            }
        } else if (user.hasGuild()) {
            if (args.length == 1) {
                player.sendMessage(" ");
                player.sendMessage("§b→ §f길드명: "+ user.getGuildName());
                player.sendMessage("§b→ §f길드장: "+ guild_Master);
                player.sendMessage(" ");
            } else if (args.length == 2) {




                Player found_player_master = reverseGuild_Data.get(targetValue);
                System.out.println("키: " + foundKey);
            }
                if()
                player.sendMessage(" ");
                player.sendMessage("§b→ §f길드명: "+guild_Name);
                player.sendMessage("§b→ §f길드장: "+ guild_Master);
                player.sendMessage(" ");
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
