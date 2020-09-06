package com.thoughworks.oobootcamp.parkinglot.domain;

import com.thoughworks.oobootcamp.parkinglot.excpetion.InvalidTicketException;
import java.util.List;
import java.util.Optional;

public abstract class ParkingBoy implements ParkAndPickable {
  protected final List<ParkingLot> parkingLots;

  public ParkingBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  @Override
  public Car pickCar(Ticket ticket) {
    Optional<ParkingLot> optionalLot =
        parkingLots.stream().filter((parkingLot) -> parkingLot.isTicketAvailable(ticket)).findAny();
    if (optionalLot.isPresent()) {
      return optionalLot.get().pickCar(ticket);
    }
    throw new InvalidTicketException();
  }

  @Override
  public boolean hasSpace() {
    return parkingLots.stream().anyMatch(ParkingLot::hasSpace);
  }
}
