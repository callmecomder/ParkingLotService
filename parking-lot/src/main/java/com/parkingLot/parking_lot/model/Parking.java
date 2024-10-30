package com.parkingLot.parking_lot.model;
import java.time.LocalDateTime;

public class Parking {
    private String regNo;
    private String name;
    private String type;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    public Parking(String r, String n, String t, LocalDateTime cIn, LocalDateTime cOut){
        this.regNo = r;
        this.name = n;
        this.type = t;
        this.checkInTime = cIn;
        this.checkOutTime = cOut;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}
