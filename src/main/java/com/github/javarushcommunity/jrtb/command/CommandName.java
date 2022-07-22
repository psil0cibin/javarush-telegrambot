package com.github.javarushcommunity.jrtb.command;

public enum CommandName {

    START ("/start"),
    STOP ("/stop"),
    HELP ("/help"),
    STAT("/stat"),
    NO ("nocommand");

    private final String commandName;

    CommandName(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
