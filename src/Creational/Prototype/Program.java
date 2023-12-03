package Creational.Prototype;

public class Program {
}

interface Prototype{
    Vehicle clone();
}

class Vehicle implements Prototype{
    int wheels;
    String name;

    String number;
    public void start(){

    }

    public Vehicle(Vehicle vehicle){
        this.name = vehicle.name;
        this.number = vehicle.number;
    }

    @Override
    public Vehicle clone() {
        return new Vehicle(this);
    }
}

class Bike extends Vehicle{

    String engine;
    Boolean isStarter;

    public Bike(Bike bike) {
        super(bike);
        this.engine = bike.engine;
        this.isStarter = bike.isStarter;
    }

    @Override
    public Bike clone() {
        return new Bike(this);
    }
}

class Car extends Vehicle{
    String carEngine;
    Boolean isPowerSteering;

    GpsSystem gpsSystem;

    public Car(Car car) {
        super(car);
        this.carEngine = car.carEngine;
        this.isPowerSteering = car.isPowerSteering;
        this.gpsSystem = car.gpsSystem; // Shallow copy
        this.gpsSystem = gpsSystem.clone(); // Deep copy
    }
    @Override
    public Car clone() {
        return new Car(this);
    }

}

interface GpsPrototype{
    GpsSystem clone();
}
class GpsSystem implements GpsPrototype{
    int version;
    int range;

    public GpsSystem(GpsSystem gps){
        this.version = gps.version;
        this.range = gps.range;
    }

    @Override
    public GpsSystem clone() {
        return new GpsSystem(this);
    }
}