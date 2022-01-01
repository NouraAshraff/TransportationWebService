package com.transportation.application;

import com.transportation.core.Driver;
import com.transportation.core.Ride;

public interface IArea {

    void notifyDriver(Ride ride);
    void addDriver(Driver driver);
    void removeDriver(Driver driver);
    void setName(String name);
}