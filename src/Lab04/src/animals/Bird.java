package animals;

import java.util.Random;

public class Bird extends Animal {
    public Bird() {

    }

    boolean hasFur;

    { iloscNog = 2; hasFur = (System.currentTimeMillis())%2!=0; }
    public String getName() {
        return "bird";
    }
    public void fly() {
        System.out.printf("I believe I can fly!");
    }
}
