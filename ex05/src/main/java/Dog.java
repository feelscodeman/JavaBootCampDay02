public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    public String toString() {
        return getClass().getName() + " name = " + getName() + ", age = " + getAge();
    }

    public double goToWalk() {
        return 0;
    }
}