package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownCommand implements Command {

    private final SendBotMessageService sendBotMS;

    public static final String UNKNOWN_MESSAGE = "Не понимаю вас \uD83D\uDE1F, напишите /help " +
            "чтобы узнать что я понимаю.";


    // Здесь не добавляем сервис через получение из Application Context.
    // Потому что если это сделать так, то будет циклическая зависимость, которая
    // ломает работу приложения.
    public UnknownCommand(SendBotMessageService sendBotMS){
        this.sendBotMS = sendBotMS;
    }

    @Override
    public void execute(Update update) {
        sendBotMS.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}
