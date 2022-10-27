package com.example.currencyconverter;

public class currency {
    private float currency_value;

    public float getCurrency_value() {
        return currency_value;
    }

    public void setCurrency_value(float currency_value) {
        this.currency_value = currency_value;
    }
    public float ConvertToPound()
    {
        return (float) (currency_value*19.70);
    }
    public float ConvertToDollar()
    {
        return (float) (currency_value/19.70);
    }
}
