package car;

public class Car {
    private boolean isRunning = false;
    private int plateNumber;
    private String modelName;
    private float maxSpeed;
    private final Gearbox gearbox;
    private final Engine engine;
    private Position position;

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
        return gearbox.getCurrentGearRatio() * engine.getRpm();
    }

    public double getPrice() {
        return engine.getPrice() + gearbox.getPrice();
    }

    public Position getPosition() {
        return position;
    }

    public Car(int plateNumber, String modelName, Gearbox gearbox, Engine engine, Position position) {
        this.plateNumber = plateNumber;
        this.modelName = modelName;
        this.gearbox = gearbox;
        this.engine = engine;
        this.position = position;
    }
}
