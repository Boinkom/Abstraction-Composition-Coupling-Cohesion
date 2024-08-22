package org.homework.api;

import java.io.IOException;

public interface CurrencyService {
    double getExchangeRate(String from, String to) throws IOException;
}
