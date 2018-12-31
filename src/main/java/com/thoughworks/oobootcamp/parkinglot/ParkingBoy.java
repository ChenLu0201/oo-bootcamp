package com.thoughworks.oobootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingBoy {

    private final List<ParkingLot> parkingLots;

    public ParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) {
        Optional<ParkingLot> optionalLot = parkingLots.stream().filter((parkingLot) -> parkingLot.hasSpace()).findFirst();
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
