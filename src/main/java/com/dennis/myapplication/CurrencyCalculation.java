package com.dennis.myapplication;
import java.text.DecimalFormat;

public class CurrencyCalculation {

    public double getFromRate() {
        return fromRate;
    }

    public void setFromRate(double fromRate) {
        this.fromRate = fromRate;
    }

    public double getToRate() {
        return toRate;
    }

    public void setToRate(double toRate) {
        this.toRate = toRate;
    }

    private double fromRate;
    private double toRate;

    public CurrencyCalculation() {
        fromRate = 0;
        toRate = 0;
    }

    public double Calculate(double value, boolean toToFrom){

        if (fromRate == 0 || toRate == 0){
            return 0;
        }
        DecimalFormat df = new DecimalFormat("#.####");
        return  Double.parseDouble(df.format(toToFrom ? value/fromRate * toRate : value/toRate * fromRate));
    }
}
