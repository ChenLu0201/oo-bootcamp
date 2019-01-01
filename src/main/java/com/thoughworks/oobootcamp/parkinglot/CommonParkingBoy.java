package com.thoughworks.oobootcamp.parkinglot;

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

    public Car pickCar(Ticket ticket) {
        Optional<ParkingLot> optionalLot = parkingLots.stream().filter((parkingLot) -> parkingLot.isTicketAvailable(ticket)).findAny();
        if (optionalLot.isPresent()) {
            return optionalLot.get().pickCar(ticket);
        }
        throw new InvalidTicketException();
    }
}
