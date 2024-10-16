package com.j43hyun9.guildproject.file;

import com.j43hyun9.guildproject.GuildProject;
import com.j43hyun9.guildproject.LogManager;
import com.j43hyun9.guildproject.data.Guild;
import com.j43hyun9.guildproject.data.User;
import org.bukkit.entity.Player;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FileManager {
    static public File userFolder  = new File(GuildProject.getInstance().getDataFolder(), "userfile");
    static public File guildFolder = new File(GuildProject.getInstance().getDataFolder(), "guildfile");
    static private Map<Player, Map> userfileMap = new HashMap<>();
    static private Map<Player, Map> guildfileMap = new HashMap<>();
    static private Map<Player, User> userdata = new HashMap<>();
    static private Map<Player, Guild> guilddata = new HashMap<>();
    static private Map<Guild, Player> reverse_guilddata = new HashMap<>();
    public FileManager(){}

    public static Map<Player, Map> getUserfileMap() {
        return userfileMap;
    }
    public static Map<Player, Map> getGuildfileMap() {
        return guildfileMap;
    }
    public static Map<Player, User> getUserdata() {
        return Collections.unmodifiableMap(userdata);
    }
    public static Map<Player, Guild> getGuilddata() {
        return Collections.unmodifiableMap(guilddata);
    }
    public static void registerGuildData(Player player, Guild guild) {
        guilddata.put(player, guild);
        reverse_guilddata.put(guild, player);
    }
    public static File getUserFolder() {
        return userFolder;
    }
    public static File getGuildFolder() {
        return guildFolder;
    }
    public static void ___initialize___() {

        if(userFolder.exists()) {
            //...
        } else if(userFolder.mkdir()) {
            //...
        } else {
            try{
                throw new NoSuchFileException(userFolder.toString());
            } catch(Exception e) {
                LogManager.logException(e);
            }
        } 
    }
}



