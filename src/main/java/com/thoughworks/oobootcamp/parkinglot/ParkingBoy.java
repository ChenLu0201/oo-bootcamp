package com.thoughworks.oobootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private final List<ParkingLot> parkingLots;

    public ParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasSpace()) {
                return parkingLot.parkCar(car);
            }
        }
        throw new NoSpaceException("Parking lots are full");
    }
}
