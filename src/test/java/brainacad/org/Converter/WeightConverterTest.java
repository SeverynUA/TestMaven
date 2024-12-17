package brainacad.org.Converter;

import brainacad.org.Models.Converter.Currency;
import brainacad.org.Models.Converter.CurrencyConverter;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public class WeightConverterTest
{
    // Створення мапи одиниць вимірювання для ваги
    private HashMap<String, Currency> createWeightUnitsMap() {
        HashMap<String, Currency> units = new HashMap<>();
        units.put("MG", new Currency("MG", 1.0));     // Міліграм в міліграм
        units.put("G", new Currency("G", 1000.0));    // Грам в міліграм
        units.put("KG", new Currency("KG", 1000000.0));    // Кілограм в міліграм
        units.put("C", new Currency("C", 100000000.0));    // Центнер в міліграм
        units.put("T", new Currency("T", 1000000000.0));    // Тонна в міліграм
        return units;
    }

    @Test
    public void testConvertGramsToKilograms()
    {
        CurrencyConverter converter = new CurrencyConverter(createWeightUnitsMap());
        assertEquals(1.0, converter.convertMeasurement("G", "KG", 1000), 0.01, "1000 грамів має бути 1 кілограм");
    }

    @Test
    public void testConvertKilogramsToCentners()
    {
        CurrencyConverter converter = new CurrencyConverter(createWeightUnitsMap());
        assertEquals(0.1, converter.convertMeasurement("KG", "C", 10), 0.01, "10 кілограмів має бути 0.1 центнера");
    }

    @Test
    public void testConvertMilligramsToGrams()
    {
        CurrencyConverter converter = new CurrencyConverter(createWeightUnitsMap());
        assertEquals(1.0, converter.convertMeasurement("MG", "G", 1000), 0.01, "1000 міліграмів має бути 1 грам");
    }

    @Test
    public void testConvertTonnesToKilograms()
    {
        CurrencyConverter converter = new CurrencyConverter(createWeightUnitsMap());
        assertEquals(1000.0, converter.convertMeasurement("T", "KG", 1), 0.01, "1 тонна має бути 1000 кілограмів");
    }

    @Test
    public void testInvalidUnit()
    {
        CurrencyConverter converter = new CurrencyConverter(createWeightUnitsMap());
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convertMeasurement("XYZ", "G", 1);
        }, "Невірна одиниця вимірювання");
    }
}
