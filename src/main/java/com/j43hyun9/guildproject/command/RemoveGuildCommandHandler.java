package com.j43hyun9.guildproject.command;

import com.j43hyun9.guildproject.GuildProject;
import com.j43hyun9.guildproject.file.FileManager;
import org.bukkit.entity.Player;

import java.util.function.Supplier;

public class RemoveGuildCommandHandler extends GuildCommand implements GuildCommandHandler, Supplier<GuildCommandHandler> {

    private GuildProject pluginB = GuildProject.getPlugin(GuildProject.class);
    private GuildProject pluginA;
    public RemoveGuildCommandHandler() {
        super("해체");
        this.pluginA = GuildProject.getInstance();
    }

    @Override
    public void execute(Player player, String[] args) {
        String guild_Master = (String) FileManager.getGuildfileMap().get(player).get("guild_Master");
        String playerName = player.getName();
        String guildName = (String) FileManager.getUserfileMap().get(player).get("guildName");
//        if(playerName.equals(guild_Master)){
//            if (args.length == 1) {
//                player.sendMessage("ex) /길드 해체 §4"+guildName);

//            } else if (args.length == 2) {
//                String Target_guild_Name = args[1];
//                if(guildName.equals(Target_guild_Name)) {
//                    // 길드 해체 로직
//                    if(UserFile.getGuildfileMap().containsKey(player)) {
//                        UserFile.getGuildfileMap().get(player).remove(player);
//                        UserFile.getUserfileMap().get(player).replace("guildName", false);
//                        UserFile.getUserfileMap().get(player).replace("hasGuild", false);
//                        player.setPlayerListName(player.getName());
//                        player.sendMessage(Target_guild_Name + "길드가 해체되었습니다.");
//                    } else {
//                        Debugger.send("guildMap 을 확인하자.");
//                    }
//                } else {
//                    player.sendMessage("ex) 잘못된 접근입니다.");
//                }
//        } else {
//            player.sendMessage("접근 권한이 없습니다.");
//        }
//    }
}
    @Override
    public GuildCommandHandler get() {
        return this;
    }
}
