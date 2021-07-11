package com.tw.bootcamp.cab_invoice;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FareCalculatorTest {

    @Test
    void shouldBeFareRsFiftyWhenDistanceIsFiveKilometer() {
        FareCalculator fareCalculator = new FareCalculator();

        int fiveKmFare = fareCalculator.fare(5, 0);

        assertEquals(50, fiveKmFare);
    }

    @Test
    void shouldBeFareRsFourWhenWaitingTimeIsTwoMinutesAndDistanceIsZero() {
        FareCalculator fareCalculator = new FareCalculator();

        int twoMinutesFare = fareCalculator.fare(0, 2);

        assertEquals(40, twoMinutesFare);
    }

    @Test
    void minimumFareShouldBe40(){
        FareCalculator fareCalculator = new FareCalculator();

        int fare = fareCalculator.fare(1,2);

        assertEquals(40, fare);
    }

    @Test
    void fareGreaterThan40(){
        FareCalculator fareCalculator = new FareCalculator();

        int fare = fareCalculator.fare(4,2);

        assertEquals(44, fare);
    }

    @Test
    void fareForTwoRides(){
        FareCalculator fareCalculator = new FareCalculator();
        List<Integer> listOfFares = new ArrayList<>();
        int fare1 = fareCalculator.fare(4,2);
        int fare2 = fareCalculator.fare(5,5);
        listOfFares.add(fare1);
        listOfFares.add(fare2);
        assertEquals(104, fareCalculator.sumOfFare(listOfFares));
    }

    @Test
    void testInvoiceGeneraterForTwoRides(){
        FareCalculator fareCalculator = new FareCalculator();
        List<Integer> listOfFares = new ArrayList<>();
        int fare1 = fareCalculator.fare(4,2);
        int fare2 = fareCalculator.fare(5,5);
        listOfFares.add(fare1);
        listOfFares.add(fare2);
        assertEquals("2-104-52", fareCalculator.invoiceGenerator(listOfFares));
    }

    @Test
    void testInvoiceGeneraterForFourRides(){
        FareCalculator fareCalculator = new FareCalculator();
        List<Integer> listOfFares = new ArrayList<>();
        int fare1 = fareCalculator.fare(4,2);
        int fare2 = fareCalculator.fare(5,5);
        int fare3 = fareCalculator.fare(10,0);
        int fare4 = fareCalculator.fare(8,20);
        listOfFares.add(fare1);
        listOfFares.add(fare2);
        listOfFares.add(fare3);
        listOfFares.add(fare4);
        assertEquals("4-324-81", fareCalculator.invoiceGenerator(listOfFares));
    }

}
