package com.transportation.application;

public class TenPresentDiscount extends Discount {

    public TenPresentDiscount(IOffer ioffer) {
        super(ioffer);
    }

    public TenPresentDiscount() {
    }

    @Override
    public double calculatePrice() {
        iOffer.calculatePrice();

        //iOffer.setPrice(iOffer.calculatePrice() - (0.05 * iOffer.calculatePrice()));
        return iOffer.calculatePrice() - (0.05 * iOffer.calculatePrice());
    }

}