package com.thoughworks.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
        Ticket myTicket = parkingBoy.parkCar(new Car());
        assertNotNull(myTicket);
        assertNotNull(firstParkingLot.pickCar(myTicket));
    }

}
