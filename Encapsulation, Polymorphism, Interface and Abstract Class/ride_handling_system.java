package aadi;

import java.util.*;

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate/km: " + ratePerKm + ", Location: " + currentLocation;
    }

    public abstract double calculateFare(double distance);
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    public void updateLocation(String location) {
        setCurrentLocation(location);
    }
}

class Bike extends Vehicle implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    public void updateLocation(String location) {
        setCurrentLocation(location);
    }
}

class Auto extends Vehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    public void updateLocation(String location) {
        setCurrentLocation(location);
    }
}

public class ride_handling_system {
    public static void processRides(List<Vehicle> vehicles, double distance) {
        for (Vehicle v : vehicles) {
            System.out.println(v.getVehicleDetails() + ", Fare for " + distance + " km: " + v.calculateFare(distance));
        }
    }

    public static void main(String[] args) {
        List<Vehicle> rides = new ArrayList<>();
        Car car = new Car("C001", "Ramesh", 15, "Downtown");
        Bike bike = new Bike("B001", "Suresh", 8, "Airport");
        Auto auto = new Auto("A001", "Mahesh", 10, "Station");
        rides.add(car);
        rides.add(bike);
        rides.add(auto);
        processRides(rides, 12.5);
    }
}
