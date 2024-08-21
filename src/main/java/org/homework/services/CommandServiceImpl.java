package org.homework.services;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.IOException;

public class CommandServiceImpl implements CommandService {

    private final CurrencyService currencyService;

    public CommandServiceImpl(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Override
    public SendMessage processCommand(Message message) {
        String text = message.getText();
        String[] parts = text.split(" ");

        if (parts[0].equalsIgnoreCase("/convert")) {
            try {
                double amount = Double.parseDouble(parts[1]);
                double rate = currencyService.getExchangeRate(parts[2].toUpperCase(), parts[3].toUpperCase());
                double convertedAmount = amount * rate;
                return new SendMessage(message.getChatId().toString(), "Converted amount: " + convertedAmount);
            } catch (IOException | NumberFormatException e) {
                return new SendMessage(message.getChatId().toString(), "Error processing the conversion.");
            }
        }

        return new SendMessage(message.getChatId().toString(), "Unknown command.");
    }
}
