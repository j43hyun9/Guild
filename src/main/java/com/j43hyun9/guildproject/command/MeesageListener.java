package com.j43hyun9.guildproject.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.yaml.snakeyaml.Yaml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MeesageListener implements CommandExecutor {

    public MeesageListener(Plugin plugin) {
        this.plugin = plugin;
    }
    Plugin plugin;
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {


        if (!(commandSender instanceof Player))
            return false;

        Player p = ((Player) commandSender).getPlayer();
        /**             X   [0]   [1]
         *  @sample  /길드 초대 J43hyun9
         *  @length 0    1     2
         */

        if(args.length == 0) {
            p.sendMessage("길드 명령어");
            p.sendMessage("/길드 생성 <길드명>");
        } else if(args.length == 1 && args[0].equals("생성")) {
            Bukkit.broadcastMessage("§c→ §f길드명을 입력해주시길 바랍니다.");
        } else if(args.length == 2 && args[0].equals("생성")) {
            Map<String, Object> data1 = new HashMap<>();
            data1.put("name", p.getUniqueId());
            Yaml yaml = new Yaml();
            try {
                FileWriter writer = new FileWriter("C:\\Users\\noble\\OneDrive\\바탕 화면\\TestServer\\plugins\\GuildProject\\"+args[1]);
                yaml.dump(data1, writer);
                Bukkit.broadcastMessage("§c→ §f길드가 생성되었습니다.ㄴ" + "§c" + args[1]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if(args.length == 1 && args[0].equals("해체")) {
            Bukkit.broadcastMessage("§c→ §f길드명을 입력해주시길 바랍니다.");
        } else if(args.length == 2 && args[0].equals("해체")) {
            //if(p.getName().equals())  플레이어 명과 file 네임 명이 일치하는지 확인해야함.
            Yaml yaml = new Yaml();
            InputStream inputStream = plugin.getClass()
                    .getClassLoader()
                    .getResourceAsStream("C:\\Users\\noble\\OneDrive\\바탕 화면\\TestServer\\plugins\\GuildProject\\"+args[1]);
            Map<String, UUID> obj = yaml.load(inputStream);
            Bukkit.broadcastMessage(obj.toString());

        }

        return true;
    }
}
