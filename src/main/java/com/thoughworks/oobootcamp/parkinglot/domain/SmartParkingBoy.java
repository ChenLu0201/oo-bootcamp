package com.thoughworks.oobootcamp.parkinglot.domain;

import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalInt;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }


    public Ticket parkCar(Car car) {
        OptionalInt max = parkingLots.stream().mapToInt(ParkingLot::getRemainingSpace).max();
        Optional<ParkingLot> availableLot = parkingLots.stream().filter(parkingLot -> max.getAsInt() == parkingLot.getRemainingSpace()).findFirst();
        if (availableLot.isPresent()) {
            return availableLot.get().parkCar(car);
        }
        return null;
    }
}
