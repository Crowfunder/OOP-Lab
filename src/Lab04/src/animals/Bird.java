package animals;

import java.util.Random;

public class Bird extends Animal {
    public Bird() {
    }

    public boolean hasFur;

    { iloscNog = 2; hasFur = (System.currentTimeMillis())%2!=0; }
    public String getName() {
        return "bird";
    }
}
