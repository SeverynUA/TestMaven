package brainacad.org.Models.Converter;

import java.util.HashMap;

public class CurrencyConverter
{
    private HashMap<String, Currency> currencies;

    public CurrencyConverter(HashMap<String, Currency> currencies)
    {
        this.currencies = currencies;
    }

    public Currency getCurrency(String code)
    {
        return currencies.get(code.toUpperCase());
    }

    public double convertMoney(String fromCurrency, String toCurrency, double value)
    {
        Currency from = getCurrency(fromCurrency);
        Currency to = getCurrency(toCurrency);

        if (from == null || to == null) {
            throw new IllegalArgumentException("Вказано невірну значення.");
        }

        double valueInStandard = value / from.getRateToStandard();

        return valueInStandard * to.getRateToStandard();
    }

    public double convertMeasurement(String fromCurrency, String toCurrency, double value)
    {
        Currency from = getCurrency(fromCurrency);
        Currency to = getCurrency(toCurrency);

        if (from == null || to == null) {
            throw new IllegalArgumentException("Вказано невірну значення.");
        }

        double rateInStandard = value * from.getRateToStandard();

        return rateInStandard / to.getRateToStandard();
    }
}
