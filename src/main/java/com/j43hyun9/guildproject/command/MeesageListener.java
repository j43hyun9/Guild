package com.j43hyun9.guildproject.command;

import com.j43hyun9.guildproject.GuildProject;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MeesageListener implements CommandExecutor {

    GuildProject plugin;
    Map<String, Object> guild = new HashMap<>();
    public MeesageListener(GuildProject plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(commandSender instanceof Player))
            return false;
        Player p = ((Player) commandSender).getPlayer();
        commandRecieve(p, args);
        /**             X   [0]   [1]
         *  @sample  /길드 초대 J43hyun9
         *  @length 0    1     2
         */
        return true;
    }

    private void commandRecieve(Player p, String [] args) {
        if(args.length == 0) {
            for(int i=0; i<3; i++) p.sendMessage(" ");
            p.sendMessage("§b→ §f길드 명령어");
            p.sendMessage(" ");
            p.sendMessage("§b→ §f/길드 정보 <길드명>");
            p.sendMessage("§b→ §f/길드 후원금 <길드명>");
            p.sendMessage("§b→ §f/길드 가입신청 <길드명>");
            p.sendMessage(" ");
            p.sendMessage("§b→ §f/길드 생성 <길드명>");
            p.sendMessage("§b→ §f/길드 상점 <길드명>");
            p.sendMessage(" ");
            p.sendMessage("§b→ §f/길드 랭킹 <길드명>");
            p.sendMessage("§b→ §f/길드 목록 <페이지>");
            p.sendMessage(" ");
            p.sendMessage("§b→ §f '/파티' 명령어를 통해 간단히 팀을 맺을 수 있습니다. ");
            for(int i=0; i<3; i++) p.sendMessage(" ");

        } else if(args.length == 1 && args[0].equals("생성")) {

            p.sendMessage("§c→ §f길드명을 입력해주시길 바랍니다.");

        } else if(args.length == 2 && args[0].equals("생성")) {

            guild.put("name", p.getUniqueId().toString());
            Yaml yaml = new Yaml();
            //FileWriter writer = null;

            try {
                FileWriter writer = new FileWriter(plugin.getDataFolder()+ "\\" +args[1]+".yml");
                yaml.dump(guild, writer);
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            p.setPlayerListName(p.getName() + " §a" + args[1] + "§2길드");
            p.sendMessage("§c→ §f길드가 생성되었습니다." + "§c " + args[1]);


        } else if(args.length == 1 && args[0].equals("해체")) {

            p.sendMessage("§c→ §f길드명을 입력해주시길 바랍니다.");

        } else if(args.length == 2 && args[0].equals("해체")) {

            try {
                Reader yamlFile = new FileReader(plugin.getDataFolder() + "\\" +args[1]+".yml");
                Yaml yaml = new Yaml();
                Map<String, Object> obj = yaml.load(yamlFile);
                if(String.valueOf(obj.get("name")).equals(p.getUniqueId().toString())) {
                    File file = new File(plugin.getDataFolder() + "\\" + args[1]+".yml");
                    obj.remove("name");
                    obj.put("name", "X");
                    FileWriter writer = new FileWriter(plugin.getDataFolder() + "\\" + args[1] + ".yml");
                    yaml.dump(obj, writer);
                    p.setPlayerListName(p.getName());
                    Bukkit.broadcastMessage("§c→ §f길드가 해체되었습니다. §c" + args[1]);
                } else {
                    p.sendMessage("§c 접근 권한이 없습니다.");
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
