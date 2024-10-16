package com.j43hyun9.guildproject.data;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String master;
    private String guildName;
    private List<Player> members = new ArrayList<>();
    private int level;
    private int funds;
    private int population;

    public Guild(Player player, String guildName) {
        this.master = player.getName();
        this.guildName = guildName;
        this.members.add(player);
        this.level = 1;
        this.funds = 0;
        this.population = this.members.size();

    }

    public String getGuildName() {
        return this.guildName;
    }
}
