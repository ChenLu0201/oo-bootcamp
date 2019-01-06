package com.thoughworks.oobootcamp.parkinglot.domain;

import com.thoughworks.oobootcamp.parkinglot.excpetion.NoSpaceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingManager {

    private final List<ParkingLot> parkingLots;
    private final List<ParkingBoy> parkingBoys = new ArrayList<>();

    public ParkingManager(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) {
        if (!parkingBoys.isEmpty()) {
            Optional<ParkingBoy> availableParkingBoy = parkingBoys.stream().filter(CheckSpace::hasSpace).findFirst();
            return availableParkingBoy.get().parkCar(car);
        }
        if (parkingLots != null) {
            Optional<ParkingLot> availableParkingLot = parkingLots.stream().filter(CheckSpace::hasSpace).findFirst();
            if (availableParkingLot.isPresent()) {
                return availableParkingLot.get().parkCar(car);
            }
        }
        throw new NoSpaceException();
    }

    public void registerParkingBoy(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }
}
