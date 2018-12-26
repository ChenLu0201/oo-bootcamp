package com.thoughworks.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingBoyTest {

    @Test
    void shouldReturnTicketWhenParkCarGivenSingleParkingLotHasRemainingSpace() {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(newArrayList(parkingLot));

        assertNotNull(parkingBoy.parkCar(new Car()));
    }

    @Test
    void shouldThrowExceptionWhenParkCarGivenSingleParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.parkCar(new Car());
        parkingLot.parkCar(new Car());
        ParkingBoy parkingBoy = new ParkingBoy(newArrayList(parkingLot));

        assertThrows(NoSpaceException.class, () -> parkingBoy.parkCar(new Car()));
    }

    @Test
    void shouldReturnTicketWhenParkCarGivenTwoParkingLotsBothHasRemainingSpace() {
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(newArrayList(firstParkingLot, secondParkingLot));
        Car myCar = new Car();
        Ticket myTicket = parkingBoy.parkCar(myCar);
        assertNotNull(myTicket);
        assertSame(myCar, firstParkingLot.pickCar(myTicket));
    }

    @Test
    void shouldReturnTicketWhenParkCarGivenTwoParkingLotsWithOneIsFull() {
        ParkingLot firstParkingLot = new ParkingLot(2);
        firstParkingLot.parkCar(new Car());
        firstParkingLot.parkCar(new Car());
        ParkingLot secondParkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(newArrayList(firstParkingLot, secondParkingLot));
        Car myCar = new Car();
        Ticket myTicket = parkingBoy.parkCar(myCar);
        assertNotNull(myTicket);
        assertSame(myCar, secondParkingLot.pickCar(myTicket));
    }

    @Test
    void shouldThrowExceptionWhenParkCarGivenTwoParkingLotsBothFull() {
        ParkingLot firstParkingLot = new ParkingLot(2);
        firstParkingLot.parkCar(new Car());
        firstParkingLot.parkCar(new Car());
        ParkingLot secondParkingLot = new ParkingLot(2);
        secondParkingLot.parkCar(new Car());
        secondParkingLot.parkCar(new Car());
        ParkingBoy parkingBoy = new ParkingBoy(newArrayList(firstParkingLot, secondParkingLot));

        assertThrows(NoSpaceException.class, () -> parkingBoy.parkCar(new Car()));
    }

    @Test
    void shouldGetMyCarWhenPickCarGivenSingleParkingLot() {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(newArrayList(parkingLot));
        Car myCar = new Car();
        Ticket myTicket = parkingBoy.parkCar(myCar);

        assertSame(myCar, parkingBoy.pickCar(myTicket));
    }

    @Test
    void shouldGetMyCarWhenPickCarGivenTwoParkingLots() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        firstParkingLot.parkCar(new Car());
        ParkingLot secondParkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(newArrayList(firstParkingLot, secondParkingLot));
        Car myCar = new Car();
        Ticket myTicket = parkingBoy.parkCar(myCar);

        assertSame(myCar, parkingBoy.pickCar(myTicket));
    }

    @Test
    void shouldThrowExcpetionWhenPickCarGivenInvalidTicket() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        firstParkingLot.parkCar(new Car());
        ParkingLot secondParkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(newArrayList(firstParkingLot, secondParkingLot));
        Car myCar = new Car();
        parkingBoy.parkCar(myCar);

        assertThrows(InvalidTicketException.class, () -> parkingBoy.pickCar(new Ticket()));
    }

}
