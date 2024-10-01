package com.j43hyun9.guildproject.command;

import com.j43hyun9.guildproject.command.GuildCommand;
import com.j43hyun9.guildproject.command.GuildCommandHandler;
import org.bukkit.entity.Player;

import java.util.function.Supplier;

public class UnSignGuildCommandHandler extends GuildCommand implements GuildCommandHandler, Supplier<GuildCommandHandler> {

    protected UnSignGuildCommandHandler() {
        super("탈퇴");
    }

    @Override
    public void execute(Player player, String[] args) {

    }

    @Override
    public GuildCommandHandler get() {
        return null;
    }
}
