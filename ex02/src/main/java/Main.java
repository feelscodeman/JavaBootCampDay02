import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void eatNonIntInput(Scanner in) {
        while(!in.hasNextInt()) {
            System.out.println("Couldn't parse a number. Please, try again");
            in.next();
        }
    }

    public static void eatNonDoubleInput(Scanner in) {
        while(!in.hasNextDouble()) {
            System.out.println("Couldn't parse a number. Please, try again");
            in.next();
        }
    }

    public static String handleInput(int errType) {

        return "Input error. " + switch(errType) {
            case 0 -> "Size <= 0";
            case 1 -> "Unsupported pet type";
            case 2 -> "Age <= 0";
            case 3 -> "Weight <= 0";
            default -> "unknown err";
        };
    }

    public static void insertAnimal(List<Animal> li, String type, String name, int age, double weight) {
        switch(type) {
            case "cat" -> li.add(new Cat(name, age, weight));
            case "dog" -> li.add(new Dog(name, age, weight));
        }
    }

    public static void main(String[] s) {

        final int SIZE_ERR = 0;
        final int PET_TYPE_ERR = 1;
        final int AGE_ERR = 2;
        final int WEIGHT_ERR = 3;

        Scanner input = new Scanner(System.in);

        eatNonIntInput(input);

        int count = input.nextInt();

        if (count <= 0)
            System.out.println(handleInput(SIZE_ERR));
        else {
            List<Animal> pets = new ArrayList<>();
            String petTypes = "catdog";

            while(count > 0) {

                String petType = input.next();
                if (!petTypes.contains(petType))
                    System.out.println(handleInput(PET_TYPE_ERR));
                else {
                    String name = input.next();
                    eatNonIntInput(input);
                    int age = input.nextInt();

                    if (age <= 0)
                        System.out.println(handleInput(AGE_ERR));
                    else {
                        eatNonDoubleInput(input);
                        double weight = input.nextDouble();

                        if (weight <= 0)
                            System.out.println(handleInput(WEIGHT_ERR));
                        else
                            insertAnimal(pets, petType, name, age, weight);
                    }
                }
                count--;
            }

            if (!pets.isEmpty())
                pets.forEach(System.out::println);
        }
    }
}


