package car;

public abstract class Component {
    String name;
    float weight;
    float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Component(String name, float weight, float price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }
}
