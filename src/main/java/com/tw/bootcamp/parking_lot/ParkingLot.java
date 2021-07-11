package com.tw.bootcamp.parking_lot;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    public static final ParkingLotObserver NULL_OBSERVER = new ParkingLotObserver() {
        @Override
        public void notifyFull() {
            //no op
        }

        @Override
        public void notifyIsAvailable() {
            //no op
        }
    };
    private final int capacity;
    private final Set<Vehicle> parkedVehicles = new HashSet<>();
    private ParkingLotObserver observer;

    public ParkingLot(int capacity) {
        this(capacity, NULL_OBSERVER);

    }

    public ParkingLot(int capacity, ParkingLotObserver parkingLotObserver) {
        this.capacity = capacity;
        this.observer = parkingLotObserver;
    }

    public void park(Vehicle vehicle) throws AlreadyParkedException, ParkingLotFullException {
        if (parkedVehicles.contains(vehicle)) {
            throw new AlreadyParkedException();
        }
        if (isFull()) {
            throw new ParkingLotFullException();
        }
        parkedVehicles.add(vehicle);
        if(isFull()) {
            observer.notifyFull();
        }
    }

    private boolean isFull() {
        return capacity == parkedVehicles.size();
    }

    public void unPark(Vehicle vehicle) throws NotParkedException {
        if (!parkedVehicles.contains(vehicle)) {
            throw new NotParkedException();
        }
        parkedVehicles.remove(vehicle);
        if(isAvailable()) {
            observer.notifyIsAvailable();
        }

    }

    private boolean isAvailable() {
        return parkedVehicles.size() < capacity;
    }

}

