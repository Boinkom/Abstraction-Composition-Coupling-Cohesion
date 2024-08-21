package org.homework.services;

import org.homework.logger.Logger;
import org.homework.logger.LoggerImpl;

import java.io.IOException;

public class CurrencyServiceImpl implements CurrencyService {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";
    private final Logger logger = new LoggerImpl(CurrencyServiceImpl.class);

    @Override
    public double getExchangeRate(String from, String to) throws IOException {
        logger.info("Getting exchange rate for " + from + " to " + to);
        String url = API_URL + from;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(request);
            String jsonResponse = EntityUtils.toString(response.getEntity());

            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            double rate = jsonObject.getAsJsonObject("rates").get(to).getAsDouble();
            logger.debug("Exchange rate: " + rate);
            return rate;
        } catch (IOException e) {
            logger.error("Failed to get exchange rate", e);
            throw e;
        }
    }
}
