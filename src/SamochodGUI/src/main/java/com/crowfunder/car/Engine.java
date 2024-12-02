package com.crowfunder.car;

import com.crowfunder.car.Component;

public class Engine extends Component {
    private boolean running = false;
    private int rpm = 0;
    private int rpm_max = 5600;

    public void engineRun() {
        running = true;
    }

    public void engineStop() {
        running = false;
        rpm = 0;
    }

    public void increaseRPM(int rpm_delta) {
        if (running) {
            rpm += rpm_delta;
            if (rpm + rpm_delta > rpm_max) {
                rpm = rpm_max;
            }
        }
    }

    public void decreaseRPM(int rpm_delta) {
        if (running) {
            rpm -= rpm_delta;
            if (rpm < 0) {
                rpm = 0;
            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public int getRpm() {
        return rpm;
    }

    public int getRpm_max() {
        return rpm_max;
    }

    public Engine(int rpm_max, String name, float weight, float price) {
        super(name, weight, price);
        this.rpm_max = rpm_max;
    }
    public Engine() {
        super();
    }
}
