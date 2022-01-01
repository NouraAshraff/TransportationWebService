package com.transportation.application;

import com.transportation.core.Area;
import com.transportation.core.Ride;
import com.transportation.core.RideRequest;
import com.transportation.core.User;

import java.util.ArrayList;

public interface IDriver {

    double getAvgRating();

    boolean rateMe(int rate, User user);

    void makeOffer(Ride ride, double price);

    boolean AddNewFavArea(Area area);

    ArrayList<Ride> getRides();

    boolean addRide(Ride ride);

    ArrayList<String> listRides();

    ArrayList<Area> getFavAreas();

    double calcbalance(double price);

    ArrayList<RideRequest> getDriverRequsets();

    boolean addDriverReq(RideRequest nwRequest);

    boolean startRide(User user);

    boolean endRide(User user);
}