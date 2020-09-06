package com.thoughworks.oobootcamp.parkinglot;

import com.thoughworks.oobootcamp.parkinglot.domain.Car;
import com.thoughworks.oobootcamp.parkinglot.domain.ParkingLot;
import com.thoughworks.oobootcamp.parkinglot.domain.Ticket;
import com.thoughworks.oobootcamp.parkinglot.excpetion.InvalidTicketException;
import com.thoughworks.oobootcamp.parkinglot.excpetion.NoSpaceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingLotTest {

  @Test
  void shouldReturnTicketWhenParkingGivenHas1AvailableSpace() {
    ParkingLot parkingLot = new ParkingLot(1);
    Car car = new Car();

    Ticket ticket = parkingLot.parkCar(car);

    assertNotNull(ticket);
  }

  @Test
  void shouldThrowExceptionWhenParkingGivenNoAvailableSpace() {
    ParkingLot parkingLot = new ParkingLot(1);
    Car car = new Car();
    parkingLot.parkCar(car);

    assertThrows(NoSpaceException.class, () -> parkingLot.parkCar(new Car()));
  }

  @Test
  void shouldReturnCarWhenPickCarGivenValidTicket() {
    ParkingLot parkingLot = new ParkingLot(1);
    Car car = new Car();
    Ticket ticket = parkingLot.parkCar(car);

    assertSame(car, parkingLot.pickCar(ticket));
  }

  @Test
  void shouldThrowExceptionWhenPickCarGivenInvalidTicket() {
    ParkingLot parkingLot = new ParkingLot(2);
    parkingLot.parkCar(new Car());

    assertThrows(InvalidTicketException.class, () -> parkingLot.pickCar(new Ticket()));
  }

  @Test
  void shouldReturnTicketWhenParkCarGivenOneCarPickedFromFullParkingLot() {
    ParkingLot parkingLot = new ParkingLot(2);
    parkingLot.parkCar(new Car());
    Ticket ticket = parkingLot.parkCar(new Car());
    parkingLot.pickCar(ticket);

    assertNotNull(parkingLot.parkCar(new Car()));
  }
}
