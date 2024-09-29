package com.j43hyun9.guildproject.command;

import org.bukkit.entity.Player;

import java.util.function.Supplier;

public class SignUpGuildCommandHandler extends GuildCommand implements GuildCommandHandler, Supplier<GuildCommandHandler> {

    public SignUpGuildCommandHandler() {
        super("가입신청");
    }

    @Override
    public void execute(Player player, String[] args) {
        if(args.length == 1) {
            player.sendMessage(" ");
            player.sendMessage("§c→ §f길드명을 입력해주시길 바랍니다.");
            player.sendMessage(" ");
        } else if(args.length == 2) {
            player.sendMessage(" ");
            player.sendMessage("§c→ §f가입신청을 성공적으로 보냈습니다.");
            player.sendMessage(" ");
        }
    }

    @Override
    public GuildCommandHandler get() {
        return this;
    }
}
