package org.homework.di;

import org.homework.services.CommandServiceImpl;
import org.homework.services.CurrencyServiceImpl;
import org.homework.bot.Bot;
import org.homework.services.CommandService;

public class DIContainer {
    public static Bot createBot() {
        CurrencyServiceImpl currencyService = new CurrencyServiceImpl();
        CommandService commandService = new CommandServiceImpl(currencyService);
        return new Bot(commandService);
    }
}
