import car.Car;
import car.Clutch;
import car.Engine;
import car.Gearbox;
import car.Position;

import java.util.Date;

public class Zawody {
    private String name;
    private Date date;

    public static void main(String[] args) {
        Clutch clutch = new Clutch("clutch", 10, 200);
        Gearbox gearbox = new Gearbox("grbx", 20, 100, 6, clutch);
        Engine engine = new Engine(100, "nginx", 20, 1000);
        Position position = new Position(0,0);
        Car car = new Car(23, "aughh", gearbox, engine, position);
        System.out.printf("1");
    }
}
