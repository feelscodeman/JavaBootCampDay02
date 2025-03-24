abstract public class Animal {

    private final String name;
    private int age;
    private double weight;

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public double getWeight() { return weight; }

    abstract public String toString();
    abstract public double getFeedingInfo();
}