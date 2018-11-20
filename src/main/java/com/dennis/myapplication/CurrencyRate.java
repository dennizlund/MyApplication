package com.dennis.myapplication;

public class CurrencyRate {

    public CurrencyRate(String fullname, String name, Double rate, int imageUrl) {
        this.fullname = fullname;
        this.name = name;
        this.rate = rate;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {

        return getName() + " (" + getRate() + ")";
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }


    private String fullname;
    private String name;
    private Double rate;
    private int imageUrl;


}
