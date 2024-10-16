package com.j43hyun9.guildproject.data;

import org.bukkit.entity.Player;

public class User {
    private Boolean hasGuild;
    private String userName;
    private String guildName;
    private Boolean isMaster;

    public User(Player player, Boolean hasGuild, String guildName) {
        this.userName = player.getName();
        this.hasGuild = hasGuild;
        this.guildName = guildName;
        this.isMaster = false;
    }
    //getter 메소드
    public Boolean isMaster() {
        return isMaster;
    }
    public String getName() {
        return userName;
    }

    public Boolean hasGuild() {
        return hasGuild;
    }

    public String getGuildName() {
        if(guildName.equals("false")) {
            return "none";
        }
        return guildName;
    }
    // setter 메소드
    public void setName(String name) {
        this.userName = name;
    }

    public void setHasGuild(Boolean hasGuild) {
        this.hasGuild = hasGuild;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }


}
