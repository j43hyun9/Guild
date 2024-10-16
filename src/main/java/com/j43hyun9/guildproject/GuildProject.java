package com.j43hyun9.guildproject;

import com.j43hyun9.guildproject.command.GuildCommandHandlerFactory;
import com.j43hyun9.guildproject.command.MeesageListener;
import com.j43hyun9.guildproject.event.PlayerJoinEvent;
import com.j43hyun9.guildproject.event.PlayerQuitEvent;
import com.j43hyun9.guildproject.file.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class GuildProject extends JavaPlugin implements Listener {

    private GuildCommandHandlerFactory factory;
    private static GuildProject instance;

    @Override
    public void onEnable() {
        instance = this;
        FileManager.___initialize___();
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitEvent(), this);
        try {
            factory = new GuildCommandHandlerFactory(this);
        } catch (ClassNotFoundException e) {
            Bukkit.getConsoleSender().sendMessage("ClassNotFoundException: GuildProject");
            throw new RuntimeException(e);
        }
        getCommand("길드").setExecutor(new MeesageListener(this, factory));
        String str = ()->{Bukkit.broadcastMessage("a");};
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static GuildProject getInstance() {
        return instance;
    }


}
