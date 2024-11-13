package car;

public class Gearbox extends Component {

    private int currentGear = 0;
    private final int maxGears;
    private final Clutch clutch;

    public Gearbox(String name, float weight, float price, int maxGears, Clutch clutch) {
        super(name, weight, price);
        this.maxGears = maxGears;
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
