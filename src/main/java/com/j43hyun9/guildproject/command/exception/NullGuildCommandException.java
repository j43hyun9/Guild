package com.j43hyun9.guildproject.command.exception;

public class NullGuildCommandException extends RuntimeException{
    public NullGuildCommandException() {
        super("길드 커맨드가 null입니다.");
    }
}
