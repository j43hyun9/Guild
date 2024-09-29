package com.j43hyun9.guildproject.command;

import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GuildCommand {
    private static final Map<String, Supplier<GuildCommandHandler>> commandHandlers = new HashMap<>();

    protected GuildCommand(String command) {
        if(command != null)
            registerGuildCommand(command);
    }

    private void registerGuildCommand(String command) {
        Bukkit.getConsoleSender().sendMessage(command+ "등록");
        commandHandlers.put(command, (Supplier<GuildCommandHandler>) this); // 한글 명령어 사용
    }

    public static Map<String, Supplier<GuildCommandHandler>> getCommandHandlerList() {
        return commandHandlers;
    }
}
