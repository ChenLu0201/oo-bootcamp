package com.thoughworks.oobootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;

public abstract class ParkingBoy {
    protected final List<ParkingLot> parkingLots;

    public ParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    abstract Ticket parkCar(Car car);
}
