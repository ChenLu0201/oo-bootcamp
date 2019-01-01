package com.thoughworks.oobootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class ParkingBoy {
    protected final List<ParkingLot> parkingLots;

    public ParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    abstract Ticket parkCar(Car car);

    public Car pickCar(Ticket ticket) {
        Optional<ParkingLot> optionalLot = parkingLots.stream().filter((parkingLot) -> parkingLot.isTicketAvailable(ticket)).findAny();
        if (optionalLot.isPresent()) {
            return optionalLot.get().pickCar(ticket);
        }
        throw new InvalidTicketException();
    }
}
