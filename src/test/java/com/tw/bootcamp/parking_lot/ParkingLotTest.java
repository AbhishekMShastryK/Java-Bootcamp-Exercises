package com.tw.bootcamp.parking_lot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ParkingLotTest {
    private ParkingLot parkingLotOne;
    private ParkingLot parkingLotTwo;

    private Vehicle carOne;
    private Vehicle carTwo;

    @BeforeEach
    void beforeEach() {
        carOne = vehicle();
        carTwo = vehicle();

        parkingLotOne = new ParkingLot(1);
        parkingLotTwo = new ParkingLot(2);

    }

    private Vehicle vehicle() {
        return new Vehicle();
    }

    @Test
    void should_park_a_car_into_a_lot_with_space() {
        try {
            parkingLotOne.park(carOne);
        } catch (AlreadyParkedException | ParkingLotFullException e) {
            fail("Should park a car if space available");
        }
    }

    @Test
    void should_not_allow_to_park_an_already_parked_car() throws Exception {
        parkingLotTwo.park(carOne);

        assertThrows(AlreadyParkedException.class, () -> parkingLotTwo.park(carOne));
    }

    @Test
    void should_not_allow_to_park_a_car_if_the_lot_is_full() throws Exception {
        parkingLotOne.park(carOne);

        assertThrows(ParkingLotFullException.class, () -> parkingLotOne.park(carTwo));
    }


    @Test
    void should_unPark_a_parked_car() throws Exception {
        try {
            parkingLotOne.park(carOne);
            parkingLotOne.unPark(carOne);
        } catch (NotParkedException e) {
            fail("Should unPark a car if it's parked in lot");
        }
    }

    @Test
    void should_not_unPark_a_car_which_is_not_parked() throws Exception {
        parkingLotOne.park(carOne);
        parkingLotOne.unPark(carOne);
        assertThrows(NotParkedException.class, () -> parkingLotOne.unPark(carOne));
    }


    @Test
    void should_notify_the_owner_if_the_lot_with_size_one_is_full_after_parking() throws Exception {
        ParkingLotObserver parkingLotObserver = mock(ParkingLotObserver.class);
        parkingLotOne = new ParkingLot(1, parkingLotObserver);
        parkingLotOne.park(carOne);

        verify(parkingLotObserver, times(1)).notifyFull();
    }

    @Test
    void should_notify_the_owner_if_any_lot_is_full_after_parking() throws Exception {
        ParkingLotObserver parkingLotObserver = mock(ParkingLotObserver.class);
        parkingLotTwo = new ParkingLot(2, parkingLotObserver);
        parkingLotTwo.park(carOne);
        parkingLotTwo.park(carTwo);

        verify(parkingLotObserver, times(1)).notifyFull();
    }

    @Test
    void should_notify_the_owner_if_any_lot_is_available_after_unParking() throws Exception {
        ParkingLotObserver parkingLotObserver = mock(ParkingLotObserver.class);
        parkingLotTwo = new ParkingLot(2, parkingLotObserver);
        parkingLotTwo.park(carOne);
        parkingLotTwo.park(carTwo);

        parkingLotTwo.unPark(carOne);
        verify(parkingLotObserver, times(1)).notifyIsAvailable();

    }

}


