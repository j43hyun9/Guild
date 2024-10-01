package com.j43hyun9.guildproject.file;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UserFile {

    Plugin plugin;
    File file;
    static public File userfile;
    static public File guildfile;
    static private Map<Player, Map> userfileMap;
    static private Map<Player, Map> guildfileMap;

    public UserFile(Plugin plugin) {
        this.plugin = plugin;
        file = plugin.getDataFolder();
        userfile = new File(plugin.getDataFolder() +"\\"+"userfile");
        guildfile = new File(plugin.getDataFolder() +"\\"+"guildfile");
        userfileMap = new HashMap<>();
        guildfileMap = new HashMap<>();
    }
    public static Map<Player, Map> getUserfileMap() {
        return userfileMap;
    }
    public static Map<Player, Map> getGuildfileMap() {
        return guildfileMap;
    }
    public void createDirectory() {

        if(file.exists()) {
            Bukkit.getConsoleSender().sendMessage(file.getName() + "이 이미 존재합니다.");
        }
        else {
            if(file.mkdir()) {
                Bukkit.getConsoleSender().sendMessage(file.getName() +"파일 생성에 성공하였습니다.");
            }
            else {
                Bukkit.getConsoleSender().sendMessage(file.getName() + "파일 생성에 실패하였습니다.");
                return;
            }
        }

        if(userfile.exists()) {
            Bukkit.getConsoleSender().sendMessage(userfile.getName() + "이 이미 존재합니다.");
        }
        else {
            if(userfile.mkdir()) {
                Bukkit.getConsoleSender().sendMessage(userfile.getName() + "파일 생성에 성공하였습니다.");
            }
            else {
                Bukkit.getConsoleSender().sendMessage(userfile.getName() + "파일 생성에 실패하였습니다.");
                return;
            }
        }

        if(guildfile.exists()) {
            Bukkit.getConsoleSender().sendMessage(guildfile.getName() + "이 이미 존재합니다.");
        }
        else {
            if(guildfile.mkdir()) {
                Bukkit.getConsoleSender().sendMessage(guildfile.getName() + "파일 생성에 성공하였습니다.");
            }
            else {
                Bukkit.getConsoleSender().sendMessage(guildfile.getName() + "파일 생성에 실패하였습니다.");
                return;
            }
        }
    }

    public File getFile(String filename) {
        if(filename.equals("userfile")) {
            return userfile;
        } else if(filename.equals("guildfile")) {
            return guildfile;
        } else {
            return file;
        }
    }


}



