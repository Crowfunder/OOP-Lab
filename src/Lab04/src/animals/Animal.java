package animals;

public abstract class Animal {
    protected int iloscNog;

    public String getName() {
        return "animal";
    }

    public void live() {
        System.out.println("It's alive!");
    }
    public int getIloscNog() {
        return iloscNog;
    }

}
