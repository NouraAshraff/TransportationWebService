package com.transportation.core;


import com.transportation.application.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class User extends IUser {
    private String phoneNum;
    private String email;
    private Offer offer;
    private boolean verified;
    private RideRequest userRequest;
    private String birthDate;
    public Ride chosenRide;
    private ArrayList<Offer> savedOffers = new ArrayList<>();

    public User() {
        super();
    }

    public User(String userName, String password, String phoneNum, String email) {
        super(userName, password);
        this.phoneNum = phoneNum;
        this.email = email;

    }

    public IRide getChosenRide() {
        return chosenRide;
    }

    public void setChosenRide(Ride chosenRide) {
        this.chosenRide = chosenRide;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getVerified() {
        return verified;
    }

    public String getEmail() {
        return email;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public RideRequest getUserRequest() {
        return userRequest;
    }

    public void setUserRequest(RideRequest userRequest) {
        this.userRequest = userRequest;
    }


    public Ride requestRide(IRide ride, int noOfPass) {
        RideRequest nwRequest = new RideRequest();
        if (userRequest == null) {
            LocalDate date = LocalDate.now();
            nwRequest.setDate(date.toString());
            nwRequest.setNoOfPass(noOfPass);
            ((Ride) ride).addRequest(nwRequest);
            userRequest = nwRequest;
            //ride.checkSourceArea(((Ride) ride).getSource());
            if(((Ride) ride).getSource()!=null)((Ride) ride).getSource().notifyDriver((Ride) ride);
        }
        return (Ride) ride;
    }
    public ArrayList<Offer> getUserReqOffers(){
        if(userRequest!=null)return userRequest.getOffers();
        return null;
    }
    public Offer chooseOffer(Ride ride,Offer offer) {
        this.setOffer(offer);
        this.setChosenRide(ride);
        calcprice();
        //System.out.println("Price after discount : " + offer.getUserPrice());
        Event event1 = new AcceptanceEvent(this);
        userRequest.addEvent(event1);
        offer.getDriver().startRide(this);
        savedOffers.add(offer);

        return offer;
    }

    public void calcprice() {
        IOffer offer = new Discount(this.offer);
        if (chosenRide.getDestenation().getAdminDiscount() == true) {
            offer = new TenPresentDiscount(offer);
        }
        if (birthDate == userRequest.getDate()) {
            offer = new TenPresentDiscount(offer);
        }
        if (userRequest.getNoOfPass() >= 2) {
            offer = new FivePresentDiscount(offer);
        }
        if (savedOffers.size() == 0) {
            //System.out.println("cccccccc");
            offer = new TenPresentDiscount(offer);
        }
        if (chosenRide.checkHoliday() == true) {
            offer = new FivePresentDiscount(offer);
        }
        this.offer.setUserPrice(offer.calculatePrice());
        /*System.out.println("-----------------user--------------------");
        System.out.println(this.offer.getUserPrice());
        System.out.println("------------------driver-------------------");
        System.out.println(this.offer.getdriverPrice());*/
    }

    @Override
    public String toString() {
        return "User(username= " + userName + " ," + "email= " + email + ", offer=" + offer + ", phoneNum=" + phoneNum + ")" + "\n";
    }


}