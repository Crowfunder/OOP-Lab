package com.crowfunder.car;

public class Car extends Thread {
    private boolean isRunning = false;
    private int plateNumber;
    private String modelName;
    private float maxSpeed;
    public final Gearbox gearbox;
    public final Engine engine;
    private Position position;

    public String toString() {
        return modelName;
    }

    public void startCar() {
        isRunning = true;
        this.engine.engineRun();
    }
    public void stopCar() {
        isRunning = false;
        this.engine.engineStop();
    }
    public void goToPosition(float x, float y) {

        this.position.setPosition(x, y);
    }

    public float getWeight() {
        return engine.getWeight() + gearbox.getWeight();
    }

    public double getCurrentSpeed() {
        double speed = gearbox.getCurrentGearRatio() * engine.getRpm();
        if (speed < maxSpeed) {
            return speed;
        } else {
            return maxSpeed;
        }
    }

    public double getPrice() {
        return engine.getPrice() + gearbox.getPrice();
    }

    public Position getPosition() {
        return position;
    }

    public String getModelName() { return modelName; }
    public int getPlateNumber() { return plateNumber; }

    public Car(int plateNumber, String modelName, Gearbox gearbox, Engine engine) {
        this.plateNumber = plateNumber;
        this.modelName = modelName;
        this.gearbox = gearbox;
        this.engine = engine;
        this.position = new Position(0,0);
        this.maxSpeed = 200;
    }
    public Car(Gearbox gearbox, Engine engine) {
        this.gearbox = gearbox;
        this.engine = engine;
    }
}
