package com.crowfunder.car;

import com.crowfunder.car.Clutch;
import com.crowfunder.car.Component;
import com.crowfunder.car.GearboxException;

public class Gearbox extends Component {

    private int currentGear = 0;
    private int maxGears = 6;
    public final Clutch clutch;

    public Gearbox(String name, float weight, float price, int maxGears, Clutch clutch) {
        super(name, weight, price);
        this.maxGears = maxGears;
        this.clutch = clutch;
    }
    public Gearbox(int maxGears, Clutch clutch) {
        super();
        this.clutch = clutch;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(int gear) throws GearboxException {
        if (!clutch.isClutchPressed()) {
            throw new GearboxException();
        }
        if (currentGear != gear && maxGears > gear && gear > 0) {
            clutch.clutchPress();
            currentGear = gear;
            clutch.clutchRelease();
        }
    }


    public int getMaxGears() {
        return maxGears;
    }

    public double getCurrentGearRatio() {
        if (currentGear == 0) { return 0; }
        return 0.12 + 0.04*currentGear;
    }

    public float getWeight() {
        return super.getWeight() + clutch.getWeight();
    }

    public float getPrice() {
        return super.getPrice() + clutch.getPrice();
    }

}
