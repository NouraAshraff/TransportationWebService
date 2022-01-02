package com.transportation.core;

import com.transportation.application.IArea;
import com.transportation.application.IDriver;

import java.util.ArrayList;

public class Area implements IArea {

    private ArrayList<IDriver> drivers = new ArrayList<>();
    private String name;
    private boolean hasAdminDiscount;
    public Area(){ super();}

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
    @Override
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
    public boolean addDriver(Driver driver) {
        if(!drivers.contains(driver)){
            return drivers.add(driver);
        }
        return false;
    }
    @Override
    public boolean removeDriver(Driver driver) {
        return drivers.remove(driver);
    }

    /*@Override
    public String toString() {
        return name ;
    }*/


}