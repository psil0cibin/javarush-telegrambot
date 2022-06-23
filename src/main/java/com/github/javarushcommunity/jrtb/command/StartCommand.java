package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMS;

    public static final String START_MESSAGE = "Привет. Я Javarush Telegram Bot. Я помогу тебе быть в курсе " +
            "последних статей тех авторов, которые тебе интересны. Я еще маленький и только учусь.";

    // Здесь не добавляем сервис через получение из Application Context.
    // Потому что если это сделать так, то будет циклическая зависимость, которая
    // ломает работу приложения.
    public StartCommand(SendBotMessageService sendBotMS){
        this.sendBotMS = sendBotMS;
    }

    @Override
    public void execute(Update update) {
        sendBotMS.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
