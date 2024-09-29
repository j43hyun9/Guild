package com.j43hyun9.guildproject.command;

import org.bukkit.entity.Player;

import java.util.function.Supplier;

public class DonateGuildCommandHandler extends GuildCommand implements GuildCommandHandler, Supplier<GuildCommandHandler> {
    public DonateGuildCommandHandler() {
        super("후원금");
    }

    @Override
    public void execute(Player player, String[] args) {
        if (args.length == 1) {
            player.sendMessage(" ");
            player.sendMessage("§c→ §f길드명을 입력해주시길 바랍니다.");
            player.sendMessage(" ");
        } else if (args.length == 2) {
            player.sendMessage(" ");
            player.sendMessage("§c→ §f금액을 입력해주시길 바랍니다.");
            player.sendMessage(" ");
        } else if (args.length == 3) {
            player.sendMessage(" ");
            player.sendMessage("§c→ §f길드 후원금을 성공적으로 보냈습니다.");
            player.sendMessage(" ");
        }
    }

    @Override
    public GuildCommandHandler get() {
        return this;
    }
}
