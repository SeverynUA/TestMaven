package brainacad.org.Models.Converter;

public class Currency
{
    private String code;   // Код валюти (наприклад, USD, EUR)
    private double rateToStandard;

    public Currency(String code, double rateToStandard)
    {
        this.code = code;
        this.rateToStandard = rateToStandard;
    }

    public String getCode()
    {
        return code;
    }

    public double getRateToStandard()
    {
        return rateToStandard;
    }

    public void setRateToStandard(double newRateToStandard)
    {
        if (newRateToStandard > 0) {
            this.rateToStandard = newRateToStandard;
        } else {
            throw new IllegalArgumentException("Rate must be greater than 0: " + newRateToStandard);
        }
    }
}