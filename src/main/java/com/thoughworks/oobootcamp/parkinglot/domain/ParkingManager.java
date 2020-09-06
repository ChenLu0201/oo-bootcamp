package com.thoughworks.oobootcamp.parkinglot.domain;

import com.thoughworks.oobootcamp.parkinglot.excpetion.NoSpaceException;
import com.thoughworks.oobootcamp.parkinglot.helper.ParkAndPickableSorter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingManager {

  private final List<ParkAndPickable> parkAndPickables = new ArrayList<>();
  private ParkAndPickableSorter sorter;

  public ParkingManager() {}

  public ParkingManager(ParkAndPickableSorter sorter) {
    this.sorter = sorter;
  }

  public Ticket parkCar(Car car) {
    if (!parkAndPickables.isEmpty()) {
      Optional<ParkAndPickable> availableParkingBoy =
          parkAndPickables.stream().filter(ParkAndPickable::hasSpace).findFirst();
      if (availableParkingBoy.isPresent()) {
        return availableParkingBoy.get().parkCar(car);
      }
    }
    throw new NoSpaceException();
  }

  public void registerPickAndParkable(ParkAndPickable parkAndPickable) {
    parkAndPickables.add(parkAndPickable);
    if (sorter != null) {
      sorter.sortedParkAndPickable(parkAndPickables);
    }
  }
}
