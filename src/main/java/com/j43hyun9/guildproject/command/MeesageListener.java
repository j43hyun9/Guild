package com.j43hyun9.guildproject.command;

import com.j43hyun9.guildproject.GuildProject;
import com.j43hyun9.guildproject.utils.Debugger;
import com.j43hyun9.guildproject.file.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class MeesageListener implements CommandExecutor {

    GuildProject plugin;
    Map<Player, Map> guild_Data;
    Map<Player, Map> user_Data;
    private GuildCommandHandlerFactory factory;

    public MeesageListener(GuildProject plugin, GuildCommandHandlerFactory factory) {
        this.factory = factory;
        this.plugin = plugin;
        this.guild_Data = FileManager.getGuildfileMap();
        this.user_Data = FileManager.getUserfileMap();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(commandSender instanceof Player))
            return false;
        Player player = ((Player) commandSender).getPlayer();
        boolean hasGuild = guild_Data.containsKey(player);
        if (args.length == 0) {
            if (!hasGuild) {
                for (int i = 0; i < 3; i++)
                player.sendMessage(" ");
                player.sendMessage("§b→ §f길드 명령어");
                player.sendMessage(" ");
                player.sendMessage("§b→ §f/길드 정보 <길드명>");
                player.sendMessage("§b→ §f/길드 후원금 <길드명> <금액>");
                player.sendMessage("§b→ §f/길드 가입신청 <길드명>");
                player.sendMessage(" ");
                player.sendMessage("§b→ §f/길드 생성 <길드명>");
                player.sendMessage("§b→ §f/길드 상점 <길드명>");
                player.sendMessage(" ");
                player.sendMessage("§b→ §f/길드 랭킹 <길드명>");
                player.sendMessage("§b→ §f/길드 목록 <페이지>");
                player.sendMessage(" ");
                player.sendMessage("§b→ §f '/파티' 명령어를 통해서도 간단히 팀을 맺을 수 있습니다. ");
                return true;
            } else if (hasGuild) {
                Map<Player, Object> guild_user = guild_Data.get(player);
                if (guild_user != null) {
                    boolean isMaster = guild_user.get("guild_Master").equals(player.getName());
                    if (isMaster) {
                        player.sendMessage("§b→ §f길드 명령어");
                        player.sendMessage("§b→ §f/길드 초대 <닉네임>");
                        player.sendMessage("§b→ §f/길드 정보");
                        player.sendMessage("§b→ §f/길드 해체 <길드명>");
                    }
                    else {
                        Bukkit.getConsoleSender().sendMessage("MessageListener: (var) isMaster is NULL");
                    }
                }
                else {
                    Debugger.send("MessageListener: (Map) guild_user is null");
                }
            } else {
                player.sendMessage("사용법: /길드");
            }


            return true;
        } else {
            GuildCommandHandler handler = factory.getCommandHandler(args[0]);
            if (handler != null) {
                handler.execute(player, args);
            } else {
                Bukkit.getConsoleSender().sendMessage("MessageListener: handler is null");
                player.sendMessage("사용법: /길드");
            }
        }
        return true;
    }
}