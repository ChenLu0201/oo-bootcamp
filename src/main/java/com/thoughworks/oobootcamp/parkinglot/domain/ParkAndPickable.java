package com.thoughworks.oobootcamp.parkinglot.domain;

public interface ParkAndPickable {
  Ticket parkCar(Car car);

  Car pickCar(Ticket ticket);

  boolean hasSpace();
}
