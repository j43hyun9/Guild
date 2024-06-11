package com.j43hyun9.guildproject;

import com.j43hyun9.guildproject.command.MeesageListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class GuildProject extends JavaPlugin {


    @Override
    public void onEnable() {
        getCommand("길드").setExecutor(new MeesageListener(this));
//        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        createDirectory1();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void createDirectory1() {
        File file = new File("C:\\Users\\noble\\OneDrive\\바탕 화면\\TestServer\\plugins\\GuildProject");

        if(!file.mkdir()) {
            return;
        }

    }

}
