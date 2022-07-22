package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import com.github.javarushcommunity.jrtb.service.TelegramUserService;
import com.google.common.collect.ImmutableMap;

import static com.github.javarushcommunity.jrtb.command.CommandName.*;

public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService botMessageService, TelegramUserService telegramUserService){
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(botMessageService, telegramUserService))
                .put(STOP.getCommandName(), new StopCommand(botMessageService, telegramUserService))
                .put(HELP.getCommandName(), new HelpCommand(botMessageService))
                .put(STAT.getCommandName(), new StatCommand(botMessageService, telegramUserService))
                .put(NO.getCommandName(), new NoCommand(botMessageService))
                .build();

        unknownCommand = new UnknownCommand(botMessageService);
    }

    public Command retrieveCommand(String commandIdentifier){
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
