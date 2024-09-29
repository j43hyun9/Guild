package com.j43hyun9.guildproject;

import com.j43hyun9.guildproject.command.GuildCommandHandlerFactory;
import com.j43hyun9.guildproject.command.MeesageListener;
import com.j43hyun9.guildproject.event.PlayerJoinEvent;
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


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(this, filedir), this);
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


    // Not yet used.
    /*private void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), "custom.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("custom.yml", false);
        }

        customConfig = new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch ( IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }*/
}
