package com.crowfunder.car;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Car extends Thread {
    private boolean isRunning = false;
    private int plateNumber;
    private String modelName;
    private float maxSpeed;
    public final Gearbox gearbox;
    public final Engine engine;
    private Position position;
    private Position target;
    private List<Listener> listeners = new ArrayList<>();

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
    public void goToPosition(Position target) {
        this.target = target;

    }

    public void run() {
        double deltat = 0.1;
        while (true) {
            if (this.target != null) {
                double dist = Math.sqrt(Math.pow(target.x - position.x, 2) +
                        Math.pow(target.y - position.y, 2));
                double dx = getCurrentSpeed() * deltat * (target.x - position.x) /
                        dist;
                double dy = getCurrentSpeed() * deltat * (target.y - position.y) /
                        dist;
                position.x += (float) dx;
                position.y += (float) dy;
                notifyListeners();
                if (this.target.equals(this.position)) {
                    this.target = null;
                    this.position.posEqualize();
                }
            }
            try {
                sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        for (Listener listener : listeners) {
            listener.update();
        }
    }

    public float getWeight() {
        return engine.getWeight() + gearbox.getWeight();
    }

    public double getCurrentSpeed() {
        double speed = gearbox.getCurrentGearRatio() * 1/4* engine.getRpm();
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

    public Position getTarget() {
        return target;
    }

    public Car(int plateNumber, String modelName, Gearbox gearbox, Engine engine) {
        this.plateNumber = plateNumber;
        this.modelName = modelName;
        this.gearbox = gearbox;
        this.engine = engine;
        this.position = new Position(0,0);
        this.maxSpeed = 200;
        start();
    }
    public Car(int plateNumber, String modelName, Gearbox gearbox, Engine engine, float maxSpeed) {
        this.plateNumber = plateNumber;
        this.modelName = modelName;
        this.gearbox = gearbox;
        this.engine = engine;
        this.position = new Position(0,0);
        this.maxSpeed = maxSpeed;
        start();

    }
    public Car(Gearbox gearbox, Engine engine) {
        this.gearbox = gearbox;
        this.engine = engine;
        start();

    }
}
