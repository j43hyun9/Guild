package com.j43hyun9.guildproject.command;

import org.bukkit.entity.Player;

public interface GuildCommandHandler {
    void execute(Player player, String [] args);
}
