package com.thoughworks.oobootcamp.parkinglot;

import com.thoughworks.oobootcamp.parkinglot.domain.Car;
import com.thoughworks.oobootcamp.parkinglot.domain.CommonParkingBoy;
import com.thoughworks.oobootcamp.parkinglot.domain.ParkAndPickable;
import com.thoughworks.oobootcamp.parkinglot.domain.ParkingLot;
import com.thoughworks.oobootcamp.parkinglot.domain.ParkingManager;
import com.thoughworks.oobootcamp.parkinglot.domain.SmartParkingBoy;
import com.thoughworks.oobootcamp.parkinglot.domain.Ticket;
import com.thoughworks.oobootcamp.parkinglot.excpetion.NoSpaceException;
import com.thoughworks.oobootcamp.parkinglot.helper.ParkingBoyFirstSorter;
import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingManagerTest {
    @Test
    void should_return_ticket_when_park_car_given_manager_only_has_parking_lots() {
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.registerPickAndParkable(firstParkingLot);
        parkingManager.registerPickAndParkable(secondParkingLot);

        Car myCar = new Car();
        Ticket ticket = parkingManager.parkCar(myCar);
        assertNotNull(ticket);
        assertSame(myCar, firstParkingLot.pickCar(ticket));
    }

    @Test
    void should_throw_exception_when_park_car_given_manager_only_has_full_parking_lots() {
        ParkingLot firstParkingLot = new ParkingLot(2);
        firstParkingLot.parkCar(new Car());
        firstParkingLot.parkCar(new Car());
        ParkingLot secondParkingLot = new ParkingLot(2);
        secondParkingLot.parkCar(new Car());
        secondParkingLot.parkCar(new Car());
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.registerPickAndParkable(firstParkingLot);
        parkingManager.registerPickAndParkable(secondParkingLot);

        assertThrows(NoSpaceException.class, () -> parkingManager.parkCar(new Car()));
    }

    @Test
    void should_return_ticket_when_park_car_given_manager_has_one_parking_boy_and_parking_lots() {
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        ParkingManager parkingManager = new ParkingManager();
        ParkAndPickable parkingBoy= new CommonParkingBoy(newArrayList(firstParkingLot, secondParkingLot));
        ParkingLot parkingLot = new ParkingLot(2);
        parkingManager.registerPickAndParkable(parkingBoy);
        parkingManager.registerPickAndParkable(parkingLot);
        Car myCar = new Car();
        Ticket ticket = parkingManager.parkCar(myCar);
        assertNotNull(ticket);
        assertSame(myCar, firstParkingLot.pickCar(ticket));
    }

    @Test
    void should_park_by_boy_first_when_park_car_given_manager_has_one_parking_boy_and_parking_lots() {
        ParkingManager parkingManager = new ParkingManager(new ParkingBoyFirstSorter());
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        ParkAndPickable parkingBoy= new CommonParkingBoy(newArrayList(firstParkingLot, secondParkingLot));

        ParkingLot parkingLot = new ParkingLot(2);
        parkingManager.registerPickAndParkable(parkingLot);
        parkingManager.registerPickAndParkable(parkingBoy);

        Car myCar = new Car();
        Ticket ticket = parkingManager.parkCar(myCar);
        assertNotNull(ticket);
        assertSame(myCar, firstParkingLot.pickCar(ticket));
    }

    @Test
    void should_park_by_first_boy_when_park_car_given_manager_has_multiple_parking_boy() {
        ParkingManager parkingManager = new ParkingManager(new ParkingBoyFirstSorter());
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        ParkAndPickable parkingBoyA= new CommonParkingBoy(newArrayList(firstParkingLot, secondParkingLot));

        ParkingLot thirdParkingLot = new ParkingLot(2);
        ParkingLot fourthParkingLot = new ParkingLot(2);
        ParkAndPickable parkingBoyB= new SmartParkingBoy(newArrayList(thirdParkingLot, fourthParkingLot));

        ParkingLot parkingLot = new ParkingLot(2);
        parkingManager.registerPickAndParkable(parkingLot);
        parkingManager.registerPickAndParkable(parkingBoyB);
        parkingManager.registerPickAndParkable(parkingBoyA);

        Car myCar = new Car();
        Ticket ticket = parkingManager.parkCar(myCar);
        assertNotNull(ticket);
        assertSame(myCar, thirdParkingLot.pickCar(ticket));
    }
}
