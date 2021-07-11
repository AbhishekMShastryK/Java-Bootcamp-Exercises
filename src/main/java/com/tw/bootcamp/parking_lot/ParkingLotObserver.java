package com.tw.bootcamp.parking_lot;

public interface ParkingLotObserver {
    void notifyFull();

    void notifyIsAvailable();
}

