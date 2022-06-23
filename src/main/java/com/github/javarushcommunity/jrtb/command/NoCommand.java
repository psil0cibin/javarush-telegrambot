package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class NoCommand implements Command {

    private final SendBotMessageService sendBotMS;

    public static final String NO_MESSAGE = "Я поддерживаю команды, начинающиеся со слеша(/).\n"
            + "Чтобы посмотреть список команд введите /help";

    // Здесь не добавляем сервис через получение из Application Context.
    // Потому что если это сделать так, то будет циклическая зависимость, которая
    // ломает работу приложения.
    public NoCommand(SendBotMessageService sendBotMS){
        this.sendBotMS = sendBotMS;
    }

    @Override
    public void execute(Update update) {
        sendBotMS.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}
