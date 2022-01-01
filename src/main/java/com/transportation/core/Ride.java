package com.transportation.core;

import com.transportation.application.IArea;
import com.transportation.application.IRide;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;

public class Ride implements IRide {

    private IArea source;
    private IArea Destenation ;
    private ArrayList<RideRequest> requests=new ArrayList<RideRequest>();


    public Ride(IArea source, IArea Destenation) {
        this.source = source;
        this.Destenation = Destenation;
    }

    public Ride() {

    }

    public boolean addRequest(RideRequest nwRequest){
        return requests.add(nwRequest);
    }

    public boolean checkHoliday(){
        LocalDate date= LocalDate.now();
        DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
        if (day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY){
            return true;
        }
        return false;
    }

    public ArrayList<RideRequest> getRequests() {
        return requests;
    }


    public Area getSource() {
        return (Area) source;
    }

    public void setSource(IArea source) {
        this.source = source;
    }

    public Area getDestenation() {
        return(Area) Destenation;
    }

    public void setDestenation(IArea Destenation) {
        this.Destenation = Destenation;
    }

    // may we put this fun in the constractor of the ride
    public void checkSourceArea (IArea area){
        if(area instanceof Area){
            area.notifyDriver(this);
        }
    }

    @Override
    public String toString() {
        return "Ride [source = " + source+ " Destenation = " + Destenation +"]";
    }


}
