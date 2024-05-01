package com.scaler.parkinglot.strategy.spotassignmentstrategy;

import com.scaler.parkinglot.models.*;
import com.scaler.parkinglot.repositories.ParkingLotRepository;

import java.util.List;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {
    ParkingLotRepository parkingLotRepository;

    public RandomSpotAssignmentStrategy(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate) {
        //Logic to assign the available slot.
//        ParkingLot parkingLot = parkingLotRepository.getParkingLot(gate);
//        List<ParkingSpot> parkingSpots = parkingSpotRepository.getParkingSpots();
//
//        for(ParkingSpot parkingSpot : parkingSpots) {
//            if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)) {
//                return parkingSpot;
//            }
//        }

        return null;
    }
}
