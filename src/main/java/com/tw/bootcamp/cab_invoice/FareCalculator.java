package com.tw.bootcamp.cab_invoice;

import java.util.List;

public class FareCalculator {

    public static final int COST_PER_KM = 10;

    public int fare(int distanceInKm, int timeInMinutes) {
        int fare = distanceInKm * COST_PER_KM + timeInMinutes * 2;
        return Math.max(40,fare); //Minimum Fare = 40
    }

    public int sumOfFare(List<Integer> listOfFares) {
        return listOfFares.stream().mapToInt(Integer::intValue).sum();
    }

    public String invoiceGenerator(List<Integer> listOfFares) {
        int sum = sumOfFare(listOfFares);
        int totalRides = listOfFares.size();
        int avgPerRide = sum/totalRides;
        return totalRides + "-" + sum + "-" + avgPerRide;
    }
}
