public class GuineaPig extends Animal implements Herbivore {

    private final int CHILL_HOURS = 12;
    public GuineaPig(String name, int age) {
        super(name, age);
    }

    public String toString() {
        return getClass().getName() + " name = " + getName() + ", age = " + getAge() + ". " + chill();
    }

    public String chill() {
        return "I can chill for " + CHILL_HOURS + " hours";
    }

}