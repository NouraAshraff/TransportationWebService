package com.transportation.application;

public  class Discount implements IOffer {
    protected IOffer iOffer;

    public Discount() {
    }

    public Discount(IOffer ioffer)
    {
        this.iOffer = ioffer;
    }

    public double calculatePrice() {
        return iOffer.calculatePrice();
    }
}