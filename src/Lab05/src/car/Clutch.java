package car;

public class Clutch extends Component {
    private boolean clutchPressed = false;

    public Clutch(String name, float weight, float price) {
        super(name, weight, price);
    }

    public void clutchPress() {
        clutchPressed = true;
    }

    public void clutchRelease() {
        clutchPressed = false;
    }

    public boolean isClutchPressed() {
        return clutchPressed;
    }
}
