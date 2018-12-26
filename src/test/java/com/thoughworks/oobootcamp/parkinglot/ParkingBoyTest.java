package com.thoughworks.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingBoyTest {

    @Test
    void shouldReturnTicketWhenParkingBoyParkCarGivenSingleParkingLotHasRemainingSpace() {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        assertNotNull(parkingBoy.parkCar(new Car()));
    }
}
