package com.transportation.application;

public class FivePresentDiscount extends Discount{
    public FivePresentDiscount() {
    }

    public FivePresentDiscount(IOffer ioffer) {
        super(ioffer);
    }
    @Override
    public double calculatePrice() {
        iOffer.calculatePrice();

        //iOffer.setPrice(iOffer.calculatePrice() - (0.05 * iOffer.calculatePrice()));
        return iOffer.calculatePrice() - (0.05 * iOffer.calculatePrice());
    }

}