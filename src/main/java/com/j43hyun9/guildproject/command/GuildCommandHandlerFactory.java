package com.j43hyun9.guildproject.command;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.reflections.Reflections;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class GuildCommandHandlerFactory {
    private final Map<String, Supplier<GuildCommandHandler>> commandHandlers;
    List<Class<?>> subclasses;
    Plugin plguin;

    public GuildCommandHandlerFactory(Plugin plugin) throws ClassNotFoundException {

        new CreateGuildCommandHandler(plugin);
        new DonateGuildCommandHandler();
        new InfoGuildCommandHandler();
        new SignUpGuildCommandHandler();

        commandHandlers = GuildCommand.getCommandHandlerList();
    }

    public GuildCommandHandler getCommandHandler(String command) {
        if(command==null) {
            Bukkit.getConsoleSender().sendMessage("command is null");
        } else {
            Bukkit.getConsoleSender().sendMessage(command);
        }
        Supplier<GuildCommandHandler> supplier = commandHandlers.get(command);

        return supplier != null ? supplier.get() : null;
    }
}
