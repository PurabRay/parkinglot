package com.scaler.parkinglot.strategy.spotassignmentstrategy;

import com.scaler.parkinglot.models.Gate;
import com.scaler.parkinglot.models.ParkingSpot;
import com.scaler.parkinglot.models.VehicleType;

public interface SpotAssignmentStrategy {

    ParkingSpot assignSpot(VehicleType vehicleType, Gate gate);
}
