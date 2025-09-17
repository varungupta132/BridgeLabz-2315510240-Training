package snippet;

class Vehicle {
 int maxSpeed;
 String fuelType;

 Vehicle(int maxSpeed, String fuelType) {
     this.maxSpeed = maxSpeed;
     this.fuelType = fuelType;
 }

 void displayInfo() {
     System.out.println("Max Speed: " + maxSpeed + " km/h");
     System.out.println("Fuel Type: " + fuelType);
 }
}
class Car extends Vehicle {
 int seatCapacity;

 Car(int maxSpeed, String fuelType, int seatCapacity) {
     super(maxSpeed, fuelType);
     this.seatCapacity = seatCapacity;
 }
 void displayInfo() {
     super.displayInfo();
     System.out.println("Seat Capacity: " + seatCapacity);
     System.out.println("--------------------------");
 }
}

class Truck extends Vehicle {
 int loadCapacity;  

 Truck(int maxSpeed, String fuelType, int loadCapacity) {
     super(maxSpeed, fuelType);
     this.loadCapacity = loadCapacity;
 }
 void displayInfo() {
     super.displayInfo();
     System.out.println("Load Capacity: " + loadCapacity + " kg");
     System.out.println("--------------------------");
 }
}

class Motorcycle extends Vehicle {
 String type;  

 Motorcycle(int maxSpeed, String fuelType, String type) {
     super(maxSpeed, fuelType);
     this.type = type;
 }
 void displayInfo() {
     super.displayInfo();
     System.out.println("Motorcycle Type: " + type);
     System.out.println("--------------------------");
 }
}
public class VehicleTransportSystem {
 public static void main(String[] args) {
     Vehicle[] vehicles = new Vehicle[3];

     vehicles[0] = new Car(180, "Petrol", 5);
     vehicles[1] = new Truck(120, "Diesel", 10000);
     vehicles[2] = new Motorcycle(200, "Petrol", "Sports");
     for (Vehicle v : vehicles) {
         v.displayInfo();
     }
 }
}
