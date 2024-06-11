package com.j43hyun9.guildproject.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class guildmessage implements CommandExecutor {

    Plugin plugin;
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(commandSender instanceof Player))
            return false;
        /**             X   [0]   [1]
         *  @sample  /길드 초대 J43hyun9
         *  @length 0    1     2
         */


        createDirectory1();


        return true;
    }

    public void createDirectory1() {
        File file = new File("C:\\Users\\noble\\OneDrive\\바탕 화면\\TestServer\\plugins\\new");

        if(!file.mkdir()) {
            Bukkit.broadcastMessage("파일");
        }

    }
}
