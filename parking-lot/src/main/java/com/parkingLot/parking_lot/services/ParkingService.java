package com.parkingLot.parking_lot.services;

import com.parkingLot.parking_lot.model.Parking;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingService {

    Integer ParkingLeftForFourWheelers = 100;
    Integer ParkingLeftForTwoWheelers = 100;

    final Map<String, Parking> parkingMap = new ConcurrentHashMap<>();


    public boolean isParkingSpaceAvailable(String type){
        if(type.equalsIgnoreCase("2wheeler")){
            if(ParkingLeftForTwoWheelers > 0){
                return true;
            }
        } else {
            if(ParkingLeftForFourWheelers > 0){
                return true;
            }
        }
        return false;
    }

    public Parking checkInVehicle(Parking parking) {
        if(parkingMap.containsKey(parking.getRegNo())){
            throw new RuntimeException("The vehicle with regNo " + parking.getRegNo() + " is already checked-in");
        }
        parkingMap.put(parking.getRegNo(), new Parking(parking.getRegNo(), parking.getName(),
                                                        parking.getType(), LocalDateTime.now(),
                                                        parking.getCheckOutTime()));

        if(parking.getType().equalsIgnoreCase("2wheeler")){
            ParkingLeftForTwoWheelers--;
        } else {
            ParkingLeftForFourWheelers--;
        }
        return parkingMap.get(parking.getRegNo());
    }

    public Double checkOutVehicle(String regNo) {
        if(!parkingMap.containsKey(regNo)){
            throw new RuntimeException("The vehicle with regNo " + regNo + " is not checked-in");
        }
        LocalDateTime checkOutTime = LocalDateTime.now();
        parkingMap.get(regNo).setCheckOutTime(checkOutTime);
        double price = 0.0;
        Duration duration = Duration.between(parkingMap.get(regNo).getCheckInTime(), checkOutTime);
        long totalSecondsParked = duration.getSeconds();
        if(parkingMap.get(regNo).getType().equalsIgnoreCase("2Wheeler")){
            price = totalSecondsParked * 0.001;
        } else {
            price = totalSecondsParked * 0.002;
        }
        return price;
    }

}
