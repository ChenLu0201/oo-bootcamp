package com.thoughworks.oobootcamp.parkinglot.helper;

import com.thoughworks.oobootcamp.parkinglot.domain.ParkAndPickable;
import com.thoughworks.oobootcamp.parkinglot.domain.ParkingBoy;
import com.thoughworks.oobootcamp.parkinglot.domain.ParkingLot;

import java.util.Collections;
import java.util.List;

public class ParkingBoyFirstSorter implements ParkAndPickableSorter {

    @Override
    public List<ParkAndPickable> sortedParkAndPickable(List<ParkAndPickable> parkAndPickables) {
        Collections.sort(parkAndPickables, (o1, o2) -> {
            if (o1 instanceof ParkingBoy && o2 instanceof ParkingLot) {
                return -1;
            }
            else {
                return 0;
            }
        });
        return parkAndPickables;
    }
}
