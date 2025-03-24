public class Dog extends Animal {

    private final double feedCoef = 0.3;
    public Dog(String name, int age, double weight) {
        super(name, age, weight);
    }

    public String toString() {
        return String.format("Dog name = %s, age = %d, mass = %.2f, feed = %.2f", getName(), getAge(), getWeight(), getFeedingInfo());
    }

    public double getFeedingInfo() {
        return getWeight() * feedCoef;
    }
}