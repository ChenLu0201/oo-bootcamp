package com.thoughworks.oobootcamp.parkinglot.domain;

import com.thoughworks.oobootcamp.parkinglot.excpetion.NoSpaceException;

import java.util.ArrayList;
import java.util.Optional;

public class CommonParkingBoy extends ParkingBoy {

    public CommonParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket parkCar(Car car) {
        Optional<ParkingLot> optionalLot = parkingLots.stream().filter(ParkingLot::hasSpace).findFirst();
        if (optionalLot.isPresent()) {
            return optionalLot.get().parkCar(car);
        }
        throw new NoSpaceException();
    }
}
