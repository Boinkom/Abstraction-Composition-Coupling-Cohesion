package org.homework.di;

import org.homework.api.CommandService;
import org.homework.services.CommandServiceImpl;
import org.homework.services.CurrencyServiceImpl;
import org.homework.bot.Bot;

public class DIContainer {
    public static <CommandService> Bot createBot() {
        CurrencyServiceImpl currencyService = new CurrencyServiceImpl();
        CommandService commandService = (CommandService) new CommandServiceImpl(currencyService);
        return new Bot((org.homework.api.CommandService) commandService);
    }
}
