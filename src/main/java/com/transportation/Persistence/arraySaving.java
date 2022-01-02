package com.transportation.Persistence;

import com.transportation.application.IArea;
import com.transportation.application.IRide;
import com.transportation.application.IUser;
import com.transportation.core.Area;
import com.transportation.core.Ride;

import java.util.ArrayList;

public class arraySaving implements ISaving {

    static ArrayList<IUser> iusers = new ArrayList<>();
    static ArrayList<Area> areas = new ArrayList<>();
    static ArrayList<Ride> rides = new ArrayList<>();
    static ArrayList<IUser> pending = new ArrayList<>();
    static ArrayList<IUser> admins = new ArrayList<>();

    @Override
    public boolean saveUser(IUser user) {
        if (!iusers.contains(user))
           return iusers.add(user);
        return  false;
    }
    @Override
    public boolean addAdmin(IUser admin) {
        if (!admins.contains(admin))
           return admins.add(admin);
        else
            return false;
    }

    @Override
    public boolean savePended(IUser pended) {
        if (!pending.contains(pended))
           return pending.add(pended);
        else
            return  false;
    }

    @Override
    public boolean saveArea(Area area) {
        if (!areas.contains(area))
           return areas.add(area);
        else
            return  false;
    }

    @Override
    public boolean saveRide(Ride ride) {
        if (!rides.contains(ride)) {
            rides.add(ride);
            this.saveArea((Area) ride.getSource());
            this.saveArea((Area) ride.getDestenation());
        }
        return false;
    }

    @Override
    public ArrayList<IUser> retrieveUsers() {
        return iusers;
    }

    @Override
    public ArrayList<IUser> retrievePended() {
        return pending;
    }

    @Override
    public ArrayList<Area> retrieveArea() {
        return areas;
    }

    @Override
    public ArrayList<Ride> retrieveRide() {
        return rides;
    }

    @Override
    public IUser searchIUser(String userName, String Password) {
        for (IUser user : iusers) {
            if (userName.equals(user.getUserName()) && Password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
    @Override
    public IUser searchPended(String userName, String Password) {
        for (IUser user : pending) {
            if (userName.equals(user.getUserName()) && Password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
    @Override
    public IRide searchRide(Area source, Area destination) {
        for (IRide ride : rides) {
            if (source.equals(((Ride)ride).getSource()) && destination.equals(((Ride)ride).getDestenation())) {
                return ride;
            }
        }
        IRide ride = new Ride(source,destination);
        saveRide((Ride) ride);
        return ride;
    }
    @Override
    public IArea searchArea(String name) {
        for (IArea area : this.retrieveArea()) {
            if (((Area) area).getName().equals(name)) {
                return area;
            }
        }
        IArea nwArea = new Area(name);
        saveArea((Area) nwArea);
        return nwArea;
    }

    @Override
    public IUser searchAdmin(String userName, String Password) {
        for (IUser user : admins) {
            if (userName.equals(user.getUserName()) && Password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}