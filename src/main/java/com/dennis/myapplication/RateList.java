package com.dennis.myapplication;

import java.util.ArrayList;

public class RateList {

    private static ArrayList<CurrencyRate> rateList;

    public static ArrayList<CurrencyRate> getRates() {
        if(rateList == null){
            initCurrencyRateData();
        }

        return rateList;
    }

    private static void initCurrencyRateData() {
        rateList = new ArrayList<>();

        CurrencyRate currencyRate = new CurrencyRate("Sweden","SEK", 10.1, R.drawable.iconsweden);
        rateList.add(currencyRate);

        currencyRate = new CurrencyRate("United states","USD", 1.0, R.drawable.iconusa);
        rateList.add(currencyRate);

        currencyRate = new CurrencyRate("Europe","EUR", 9.1, R.drawable.iconeurope);
        rateList.add(currencyRate);

        currencyRate = new CurrencyRate("Great Brittian","GBP", 8.1, R.drawable.iconbritain);
        rateList.add(currencyRate);

        currencyRate = new CurrencyRate("Japan","JPY", 7.1, R.drawable.iconjapan);
        rateList.add(currencyRate);

        currencyRate = new CurrencyRate("China","CNY", 6.1, R.drawable.iconchina);
        rateList.add(currencyRate);

        currencyRate = new CurrencyRate("Korea","KRW", 5.1, R.drawable.iconsouthkorea);
        rateList.add(currencyRate);
    }
}
