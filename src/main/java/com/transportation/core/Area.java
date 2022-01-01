package com.transportation.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.transportation.application.IArea;
import com.transportation.application.IDriver;

import java.util.ArrayList;

public class Area implements IArea {

    private ArrayList<IDriver> drivers = new ArrayList<>();
    private String name;
    private boolean hasAdminDiscount;
    public Area(){

    }

    public Area( String name) {
        this.name = name;
    }

    public boolean getAdminDiscount() {
        return hasAdminDiscount;
    }

    public void setHasAdminDiscount(boolean hasAdminDiscount) {
        this.hasAdminDiscount = hasAdminDiscount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void notifyDriver(Ride ride) {
        for (int i = 0; i < drivers.size(); i++) {
            if(((Driver)drivers.get(i)).MAX_PASS>((Driver)drivers.get(i)).getNoOfPass())
                drivers.get(i).addRide(ride);
        }


    }

    @Override
    public void addDriver(Driver driver) {
        if(!drivers.contains(driver)) drivers.add(driver);

    }
    @Override
    public void removeDriver(Driver driver) {
        drivers.remove(driver);

    }

    @Override
    public String toString() {
        return name ;
    }







}