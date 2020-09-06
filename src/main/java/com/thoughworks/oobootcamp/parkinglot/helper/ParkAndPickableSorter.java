package com.thoughworks.oobootcamp.parkinglot.helper;

import com.thoughworks.oobootcamp.parkinglot.domain.ParkAndPickable;
import java.util.List;

public interface ParkAndPickableSorter {
  List<ParkAndPickable> sortedParkAndPickable(List<ParkAndPickable> parkAndPickables);
}
