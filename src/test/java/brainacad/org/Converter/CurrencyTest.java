package brainacad.org.Converter;

import brainacad.org.Models.Converter.Currency;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyTest
{

    @Test
    void testGetCode()
    {
        Currency currency = new Currency("USD", 1.0);
        assertEquals("USD", currency.getCode(), "Код валюти має бути USD");
    }

    @Test
    void testGetRateToStandard()
    {
        Currency currency = new Currency("EUR", 0.94);
        assertEquals(0.94, currency.getRateToStandard(), "Курс до стандарту має бути 0.94");
    }

    @Test
    void testSetRateToStandard_ValidValue()
    {
        Currency currency = new Currency("GBP", 0.78);
        currency.setRateToStandard(0.85);
        assertEquals(0.85, currency.getRateToStandard(), "Курс до стандарту має бути 0.85 після оновлення");
    }

    @Test
    void testSetRateToStandard_InvalidValue()
    {
        Currency currency = new Currency("JPY", 141.85);
        assertThrows(IllegalArgumentException.class, () -> currency.setRateToStandard(-10.0),
                "Повинно бути виключення для від'ємного курсу");
    }
}
