package brainacad.org.Converter;

import brainacad.org.Models.Converter.Currency;
import brainacad.org.Models.Converter.CurrencyConverter;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


class CurrencyConverterTest
{
    private HashMap<String, Currency> createCurrencyMap()
    {
        HashMap<String, Currency> currencies = new HashMap<>();
        currencies.put("USD", new Currency("USD", 1.0));     // Долар США
        currencies.put("EUR", new Currency("EUR", 0.94));    // Євро
        currencies.put("GBP", new Currency("GBP", 0.78));    // Фунт стерлінгів
        currencies.put("JPY", new Currency("JPY", 141.85));  // Йена
        currencies.put("UAH", new Currency("UAH", 37.45));   // Українська гривня
        return currencies;
    }

    @Test
    void testGetCurrency_ValidCode()
    {
        CurrencyConverter converter = new CurrencyConverter(createCurrencyMap());
        assertNotNull(converter.getCurrency("USD"), "Повинна бути валюта USD");
        assertEquals("USD", converter.getCurrency("USD").getCode(), "Код валюти має бути USD");
    }

    @Test
    void testGetCurrency_InvalidCode()
    {
        CurrencyConverter converter = new CurrencyConverter(createCurrencyMap());
        assertNull(converter.getCurrency("INVALID"), "Для невірного коду має повертатися null");
    }

    @Test
    void testConvert_ValidCurrencies()
    {
        CurrencyConverter converter = new CurrencyConverter(createCurrencyMap());
        double result = converter.convertMoney("USD", "EUR", 100.0);
        assertEquals(94.0, result, 0.001, "Конвертація 100 USD в EUR має дорівнювати 94.0");
    }

    @Test
    void testConvert_InvalidFromCurrency()
    {
        CurrencyConverter converter = new CurrencyConverter(createCurrencyMap());
        assertThrows(IllegalArgumentException.class,
                () -> converter.convertMoney("INVALID", "EUR", 100.0),
                "Повинно бути виключення для невірної вихідної валюти");
    }

    @Test
    void testConvert_InvalidToCurrency()
    {
        CurrencyConverter converter = new CurrencyConverter(createCurrencyMap());
        assertThrows(IllegalArgumentException.class,
                () -> converter.convertMoney("USD", "INVALID", 100.0),
                "Повинно бути виключення для невірної цільової валюти");
    }

    @Test
    void testConvert_ZeroAmount()
    {
        CurrencyConverter converter = new CurrencyConverter(createCurrencyMap());
        double result = converter.convertMoney("USD", "GBP", 0.0);
        assertEquals(0.0, result, "Конвертація 0 має повертати 0");
    }

    @Test
    void testConvert_SameCurrency()
    {
        CurrencyConverter converter = new CurrencyConverter(createCurrencyMap());
        double result = converter.convertMoney("EUR", "EUR", 100.0);
        assertEquals(100.0, result, "Конвертація в ту ж валюту має повертати ту ж суму");
    }
}
