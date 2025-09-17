package aadi;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {

    interface Insurable {
        double calculateInsurance();
        String getInsuranceDetails();
    }

    abstract static class Vehicle {
        private String vehicleNumber;
        private String type;
        private double rentalRate;

        public Vehicle(String vehicleNumber, String type, double rentalRate) {
            this.vehicleNumber = vehicleNumber;
            this.type = type;
            this.rentalRate = rentalRate;
        }

        public String getVehicleNumber() {
            return vehicleNumber;
        }

        public void setVehicleNumber(String vehicleNumber) {
            this.vehicleNumber = vehicleNumber;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getRentalRate() {
            return rentalRate;
        }

        public void setRentalRate(double rentalRate) {
            this.rentalRate = rentalRate;
        }

        public abstract double calculateRentalCost(int days);
    }

    static class Car extends Vehicle implements Insurable {
        private String policyNumber;

        public Car(String vehicleNumber, double rentalRate, String policyNumber) {
            super(vehicleNumber, "Car", rentalRate);
            this.policyNumber = policyNumber;
        }

        @Override
        public double calculateRentalCost(int days) {
            return getRentalRate() * days;
        }

        @Override
        public double calculateInsurance() {
            return getRentalRate() * 0.1;
        }

        @Override
        public String getInsuranceDetails() {
            return "Car Insurance Policy: " + policyNumber;
        }
    }

    static class Bike extends Vehicle implements Insurable {
        private String policyNumber;

        public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
            super(vehicleNumber, "Bike", rentalRate);
            this.policyNumber = policyNumber;
        }

        @Override
        public double calculateRentalCost(int days) {
            return getRentalRate() * days * 0.8;
        }

        @Override
        public double calculateInsurance() {
            return getRentalRate() * 0.05;
        }

        @Override
        public String getInsuranceDetails() {
            return "Bike Insurance Policy: " + policyNumber;
        }
    }

    static class Truck extends Vehicle implements Insurable {
        private String policyNumber;

        public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
            super(vehicleNumber, "Truck", rentalRate);
            this.policyNumber = policyNumber;
        }

        @Override
        public double calculateRentalCost(int days) {
            return getRentalRate() * days * 1.5;
        }

        @Override
        public double calculateInsurance() {
            return getRentalRate() * 0.2;
        }

        @Override
        public String getInsuranceDetails() {
            return "Truck Insurance Policy: " + policyNumber;
        }
    }

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("CAR123", 2000, "C-INS-111"));
        vehicles.add(new Bike("BIKE567", 800, "B-INS-222"));
        vehicles.add(new Truck("TRUCK890", 3500, "T-INS-333"));

        int days = 5;
        for (Vehicle v : vehicles) {
            double rentalCost = v.calculateRentalCost(days);
            System.out.println("Vehicle: " + v.getType());
            System.out.println("Number: " + v.getVehicleNumber());
            System.out.println("Rental Cost (" + days + " days): " + rentalCost);
            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.println("Insurance: " + ins.calculateInsurance());
                System.out.println(ins.getInsuranceDetails());
            }
            System.out.println("---------------------");
        }
    }
}
	