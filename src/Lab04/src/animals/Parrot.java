package animals;

public class Parrot extends Bird {

    public Parrot() {
    super();
    }
    { iloscNog = 2; hasFur = (System.currentTimeMillis())%2!=0;}
    public String getName() {
        return "Parrot";
    }
}
