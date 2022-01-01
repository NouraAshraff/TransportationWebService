package com.transportation.application;

import java.util.ArrayList;

public class Rate {
     private static ArrayList<Integer>rates=new ArrayList<>();

     public ArrayList<Integer> getRates() {
          return rates;
     }

     public Rate() {
     }

     public double averageRating(){
          double sum=0.0;
          int i=0;
          for (int rate:rates){
               sum+=rate;
               i++;
          }
          return sum/i;

     }
     public boolean addRate(int rate){
           return rates.add(rate);
     }



}