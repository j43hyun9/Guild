package com.j43hyun9.guildproject;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogManager {
    private static final String LOG_FILE_PATH = GuildProject.getInstance().getDataFolder() + "log.txt";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void logException(Exception e) {
        try (FileWriter writer = new FileWriter(LOG_FILE_PATH, true)) {
            writer.write(dateFormat.format(new Date()) + " - " + e.getClass().getSimpleName() + ": " + e.getMessage() + "\n");
            writer.flush();
        } catch (IOException ex) {
            System.err.println("로그 기록 실패: " + ex.getMessage());
        }
    }
}