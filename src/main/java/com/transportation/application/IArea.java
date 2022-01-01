package com.transportation.application;

import com.transportation.core.Driver;
import com.transportation.core.Ride;

public interface IArea {
    void notifyDriver(Ride ride);
    boolean addDriver(Driver driver);
    boolean removeDriver(Driver driver);
    void setName(String name);
}