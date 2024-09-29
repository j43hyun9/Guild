package com.j43hyun9.guildproject.command;

import org.bukkit.entity.Player;

import java.util.function.Supplier;

public class InfoGuildCommandHandler extends GuildCommand implements GuildCommandHandler, Supplier<GuildCommandHandler> {
    public InfoGuildCommandHandler() {
        super("정보");
    }

    @Override
    public void execute(Player player, String[] args) {
            if(args.length == 1) {
                player.sendMessage(" ");
                player.sendMessage("§c→ §f길드명을 입력해주시길 바랍니다.");
                player.sendMessage(" ");
            } else if(args.length == 2) {
                player.sendMessage(" ");
                player.sendMessage("§b→ §f길드명:  <길드장 이름>");
                player.sendMessage("§b→ §f길드>");
            }
    }

    @Override
    public GuildCommandHandler get() {
        return this;
    }
}
