package com.transportation.Persistence;

import com.transportation.application.IArea;
import com.transportation.application.IRide;
import com.transportation.application.IUser;
import com.transportation.core.Area;
import com.transportation.core.Ride;

import java.util.ArrayList;

public interface ISaving {
    boolean saveUser(IUser user);

    boolean savePended(IUser pended);

    boolean saveArea(Area area);

    boolean saveRide(Ride ride);

    ArrayList<IUser> retrieveUsers();

    boolean addAdmin(IUser admin);

    ArrayList<IUser> retrievePended();

    ArrayList<Area> retrieveArea();

    ArrayList<Ride> retrieveRide();

    IUser searchIUser(String userName, String Password);

    IUser searchAdmin(String userName, String Password);

    IRide searchRide(Area source, Area destination);

    IArea searchArea(String name);
}