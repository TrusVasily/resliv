package com.resliv.service.impl;

import com.resliv.exception.CustomValidation;
import com.resliv.service.CityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TelegramBotService extends TelegramLongPollingBot {

    private static final String START = "/start";

    private final CityService cityService;

    public TelegramBotService(CityService cityService) {
        this.cityService = cityService;
    }

    @Value("${bot.name}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    @Override
    public void onUpdateReceived(Update update) {
        String request = update.getMessage().getText();

        if (START.equals(request)) {
            sendMessage(update, "Hello! \n Enter a city name to get information about the city.");
        } else {
            try {
                String response = cityService.getCityByName(request).getDescription();
                sendMessage(update, response);
            } catch (NullPointerException e) {
                sendMessage(update, "Cities with that name have not been found :(");
            }
        }
    }

    private void sendMessage(Update update, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
