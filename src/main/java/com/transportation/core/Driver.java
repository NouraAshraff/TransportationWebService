package com.transportation.core;

import com.transportation.application.*;

import java.util.ArrayList;

public class Driver extends IUser implements IDriver {

    private String drivingLicense;
    private String nationalId;
    private String phoneNum;
    private String email;

    private boolean verified;
    private double balance;
    private boolean busy;

    private int noOfPass;
    public final int MAX_PASS = 4;

    private Ride choosenRide;
    private Rate rate = new Rate();

    private ArrayList<Area> favoriteAreas = new ArrayList<>();
    private ArrayList<Ride> rides = new ArrayList<>();
    ArrayList<RideRequest> driverRequsets = new ArrayList<>();

    public boolean addDriverReq(RideRequest nwRequest) {
        return driverRequsets.add(nwRequest);
    }

    public Driver() {
        super();
        noOfPass = 0;
        balance = 0;
    }

    public Driver(String userName, String password, String drivingLicense,
                  String nationalId, String phoneNum, String email) {
        super(userName, password);
        this.drivingLicense = drivingLicense;
        this.nationalId = nationalId;
        this.phoneNum = phoneNum;
        this.email = email;
        this.balance = 0;

    }

    public ArrayList<RideRequest> getDriverRequsets() {
        return driverRequsets;
    }

    public int getNoOfPass() {
        return noOfPass;
    }

    public void setNoOfPass(int noOfPass) {
        this.noOfPass = noOfPass;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public double calcbalance(double price) {
        balance += price;
        return balance;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean getVerified() {
        return verified;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setBusy(boolean b) {
        this.busy = true;
    }

    public boolean getBusy() {
        return busy;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public boolean isVerified() {
        return verified;
    }

    @Override
    public double getAvgRating() {
        return rate.averageRating();
    }

    @Override
    public boolean rateMe(int rate, User user) {
        calcbalance(user.getOffer().getdriverPrice());
        endRide(user);
        return this.rate.addRate(rate);
    }

    @Override
    public void makeOffer(Ride ride, double price) {
        choosenRide = ride;
        Offer newOffer = new Offer();
        for (RideRequest r : ride.getRequests()) {
            if (MAX_PASS >= r.getNoOfPass() + noOfPass) {
                noOfPass += r.getNoOfPass();
                newOffer.setDriver(this);
                newOffer.setdriverPrice(price);
                newOffer.to_String();
                r.addOffer(newOffer);
                Event event = new PriceEvent(newOffer);
                r.addEvent(event);
                addDriverReq(r);

            }
        }

    }

    @Override
    public boolean AddNewFavArea(Area area) {
        area.addDriver(this);

        return favoriteAreas.add(area);
    }

    @Override
    public ArrayList<Area> getFavAreas() {
        return favoriteAreas;
    }

    @Override
    public ArrayList<String> listRides() {
        ArrayList<String>out= new ArrayList<>();
        for (int i = 0; i < rides.size(); i++) {
            out.add("Ride " + (i + 1) + " : " + rides.get(i));
        }
        return out;
    }
    @Override
    public ArrayList<Ride> getRides() {
        return rides;
    }

    public Rate getRate() {
        return rate;
    }

    @Override
    public boolean addRide(Ride ride) {
        return rides.add(ride);
    }

    @Override
    public boolean startRide(User user) {
        user.getUserRequest().setStart(true);
        user.getUserRequest().setEnd(false);
        Event event = new locationEvent(user, this, "Captain arrived to user location");
        user.getUserRequest().addEvent(event);
        return true;
    }

    @Override
    public boolean endRide(User user) {
        Event event = new locationEvent(user, this, "Captain arrived to user destination");
        user.getUserRequest().addEvent(event);
        user.getUserRequest().setStart(false);
        user.getUserRequest().setEnd(true);
        return true;
    }
}