public class Cat extends Animal {

    private final double feedCoef = 0.1;
    public Cat(String name, int age, double weight) {
        super(name, age, weight);
    }

    public String toString() {
        return String.format("Cat name = %s, age = %d, mass = %.2f, feed = %.2f", getName(), getAge(), getWeight(), getFeedingInfo());
    }

    public double getFeedingInfo() {
        return getWeight() * feedCoef;
    }

}