package brainacad.org.Converter;

import brainacad.org.Models.Converter.Currency;
import brainacad.org.Models.Converter.CurrencyConverter;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LengthConverterTest
{
    private HashMap<String, Currency> createUnitsMap() {
        HashMap<String, Currency> units = new HashMap<>();
        units.put("MM", new Currency("MM", 1.0));     // міліметри в міліметри
        units.put("SM", new Currency("SM", 10.0));    // сантиметри в міліметри
        units.put("M", new Currency("M", 1000.0));    // метри в міліметри
        units.put("KM", new Currency("KM", 1000000.0));    // кілометри в міліметри
        return units;
    }

    @Test
    public void testConvertMetersToCentimeters()
    {
        CurrencyConverter converter = new CurrencyConverter(createUnitsMap());
        assertEquals(100.0, converter.convertMeasurement("M", "SM", 1), "1 метр має бути 100 сантиметрів");
    }

    @Test
    public void testConvertMillimetersToMeters()
    {
        CurrencyConverter converter = new CurrencyConverter(createUnitsMap());
        assertEquals(1.0, converter.convertMeasurement("MM", "M", 1000), "1000 міліметрів має бути 1 метр");
    }

    @Test
    public void testConvertKilometersToMillimeters()
    {
        CurrencyConverter converter = new CurrencyConverter(createUnitsMap());
        assertEquals(2000000.0, converter.convertMeasurement("KM", "MM", 2), "2 кілометри мають бути 2000000 міліметрів");
    }

    @Test
    public void testInvalidUnit()
    {
        CurrencyConverter converter = new CurrencyConverter(createUnitsMap());
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convertMeasurement("XYZ", "SM", 1);
        }, "Невірна одиниця вимірювання");
    }
}