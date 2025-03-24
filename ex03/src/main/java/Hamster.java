public class Hamster extends Animal implements Herbivore {

    private final int CHILL_HOURS = 8;

    public Hamster(String name, int age) {
        super(name, age);
    }

    public String toString() {
        return getClass().getName() + " name = " + getName() + ", age = " + getAge() + ". " + chill();
    }

    public String chill() {
        return "I can chill for " + CHILL_HOURS + " hours";
    }

}