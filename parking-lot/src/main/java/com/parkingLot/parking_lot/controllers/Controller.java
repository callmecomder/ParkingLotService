package com.parkingLot.parking_lot.controllers;

import com.parkingLot.parking_lot.model.Parking;
import com.parkingLot.parking_lot.services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/park")
@RestController
public class Controller {

    @Autowired
    private ParkingService parkingService;

    @GetMapping(value = "/isSpaceAvailable/{type}")
    public boolean isSpaceAvailable(@PathVariable(value = "type") String typeofVehicle){
        return parkingService.isParkingSpaceAvailable(typeofVehicle);
    }

    @PostMapping(value = "/checkIn")
    public Parking checkInVehicle(@RequestBody Parking checkIn){
        return parkingService.checkInVehicle(checkIn);
    }

    @PostMapping(value = "/checkOut/{regNo}")
    public Double checkOutVehicle(@PathVariable(value = "regNo") String regNo){
        return parkingService.checkOutVehicle(regNo);
    }
}
