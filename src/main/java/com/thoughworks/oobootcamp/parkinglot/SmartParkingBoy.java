package com.thoughworks.oobootcamp.parkinglot;

import java.util.ArrayList;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    Ticket parkCar(Car car) {
        return null;
    }
}
