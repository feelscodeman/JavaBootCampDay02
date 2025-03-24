public class Dog extends Animal implements Omnivore {
    private final String HUNT_TARGET = "robbers";

    Dog(String name, int age) {
        super(name, age);
    }

    public String toString() {
        return getClass().getName() + " name = " + getName() + ", age = " + getAge() + ". " + hunt();
    }

    public String hunt() {
        return "I can hunt for " + HUNT_TARGET;
    }
}