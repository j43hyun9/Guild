package com.j43hyun9.guildproject.utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Debugger extends JavaPlugin {


    public static void send(String string) {
        String prefix = "§4";
        Bukkit.getConsoleSender().sendMessage(prefix+string);
    }
}
