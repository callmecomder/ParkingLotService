# ParkingLotService
A Spring Boot-based Parking Lot Management System for tracking and charging parking fees for both two-wheelers and four-wheelers. The ParkingService class provides functionalities to check vehicle parking availability, check-in vehicles, and calculate parking fees upon checkout.

## Features

1. Parking Availability Check: Confirms if parking space is available based on vehicle type.
2. Vehicle Check-In: Registers vehicle check-in, decreasing the available parking spots accordingly.
3. Vehicle Check-Out: Calculates and returns the parking fee based on the duration of parking.

## Installation

1. Clone the repository:
   git clone https://github.com/username/parking-lot-service.git
   
2. Navigate to the project directory:
   cd parking-lot-service
   
3. Open the project in your preferred IDE and ensure you have Java and Spring Boot installed.

## Usage
### ParkingService Class
The ParkingService class manages parking operations, such as checking in and checking out vehicles, and calculates fees based on time parked.

### Key Methods
1.     isParkingSpaceAvailable(String type): Checks if there is available space for the given vehicle type ("2Wheeler" or "4Wheeler").

2.     boolean available = parkingService.isParkingSpaceAvailable("2wheeler");
       checkInVehicle(Parking parking): Checks in a vehicle, records check-in time, and updates available spaces. Throws an exception if the vehicle is already checked in.

3.     Parking vehicle = new Parking("ABC123", "John Doe", "4wheeler", null, null);
   
       Parking checkInVehicle = parkingService.checkInVehicle(vehicle);
       checkOutVehicle(String regNo): Checks out the vehicle, calculates parking fee based on duration, and removes the vehicle from the parking map. Throws an exception if the vehicle 
       is not found.

4.     double fee = parkingService.checkOutVehicle("ABC123");

## Data Structure
The ParkingService class uses a ConcurrentHashMap to store Parking instances, which helps ensure thread safety during concurrent check-ins and check-outs.

### Parking Class Structure
  The Parking class should include the following fields:

1. String regNo: Vehicle registration number
2. String name: Owner’s name
3. String type: Vehicle type (either "2wheeler" or "4wheeler")
4. LocalDateTime checkInTime: Time of vehicle check-in
5. LocalDateTime checkOutTime: Time of vehicle check-out

## License
  This project is licensed under the MIT License.





