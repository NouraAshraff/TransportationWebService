package com.transportation.application;

import com.transportation.core.Area;
import com.transportation.core.Ride;
import com.transportation.core.User;

import java.util.ArrayList;

public interface IDriver {
    double getAvgRating();
    void rateMe(int rate , User user);
    void makeOffer(Ride ride , double price);
    void AddNewFavArea(Area area);
    ArrayList<Ride> getRides();
    void addRide(Ride ride);
    void listRides();
    ArrayList<Area> getFavAreas();
}