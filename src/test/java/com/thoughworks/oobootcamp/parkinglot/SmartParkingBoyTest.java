package com.thoughworks.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SmartParkingBoyTest {

    @Test
    void should_park_car_into_A_when_park_car_given_two_parking_lots_and_A_has_more_space() {
        ParkingLot firstLot = new ParkingLot(4);
        ParkingLot secondLot = new ParkingLot(3);
        ParkingBoy parkingBoy = new SmartParkingBoy(newArrayList(firstLot, secondLot));
        Car myCar = new Car();
        Ticket myTicket = parkingBoy.parkCar(myCar);

        assertNotNull(myTicket);
        assertSame(myCar, firstLot.pickCar(myTicket));
    }

    @Test
    void should_park_car_into_A_when_park_car_given_two_parking_lots_and_have_same_space() {
        ParkingLot firstLot = new ParkingLot(3);
        ParkingLot secondLot = new ParkingLot(3);
        ParkingBoy parkingBoy = new SmartParkingBoy(newArrayList(firstLot, secondLot));
        Car myCar = new Car();
        Ticket myTicket = parkingBoy.parkCar(myCar);

        assertNotNull(myTicket);
        assertSame(myCar, firstLot.pickCar(myTicket));
    }

    @Test
    void should_park_car_into_B_when_park_car_given_two_parking_lots_and_B_has_more_space() {
        ParkingLot firstLot = new ParkingLot(3);
        ParkingLot secondLot = new ParkingLot(4);
        ParkingBoy parkingBoy = new SmartParkingBoy(newArrayList(firstLot, secondLot));
        Car myCar = new Car();
        Ticket myTicket = parkingBoy.parkCar(myCar);

        assertNotNull(myTicket);
        assertSame(myCar, secondLot.pickCar(myTicket));
    }
}
