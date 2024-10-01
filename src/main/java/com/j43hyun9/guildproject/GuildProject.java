package com.j43hyun9.guildproject;

import com.j43hyun9.guildproject.command.GuildCommandHandlerFactory;
import com.j43hyun9.guildproject.command.MeesageListener;
import com.j43hyun9.guildproject.event.PlayerJoinEvent;
import com.j43hyun9.guildproject.event.PlayerQuitEvent;
import com.j43hyun9.guildproject.file.UserFile;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class GuildProject extends JavaPlugin implements Listener {

    private File customConfigFile;
    private FileConfiguration customConfig;
    private UserFile filedir = new UserFile(this);
    private GuildCommandHandlerFactory factory;
    private static GuildProject instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(this, filedir), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitEvent(), this);
        filedir.createDirectory();

        try {
            factory = new GuildCommandHandlerFactory(this);
        } catch (ClassNotFoundException e) {
            Bukkit.getConsoleSender().sendMessage("ClassNotFoundException: GuildProject");
            throw new RuntimeException(e);
        }
        getCommand("길드").setExecutor(new MeesageListener(this, factory));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static GuildProject getInstance() {
        return instance;
    }
}
