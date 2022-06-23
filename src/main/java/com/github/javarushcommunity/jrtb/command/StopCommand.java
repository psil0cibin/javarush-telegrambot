package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command {

    private final SendBotMessageService sendBotMS;

    public static final String STOP_MESSAGE = "Деактивировал все ваши подписки \uD83D\uDE1F";

    // Здесь не добавляем сервис через получение из Application Context.
    // Потому что если это сделать так, то будет циклическая зависимость, которая
    // ломает работу приложения.
    public StopCommand(SendBotMessageService sendBotMS){
        this.sendBotMS = sendBotMS;
    }

    @Override
    public void execute(Update update) {
        sendBotMS.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}
