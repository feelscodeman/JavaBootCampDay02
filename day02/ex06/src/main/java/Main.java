import java.util.Collections;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Main {

    private enum InputErrors {
        SIZE_ERR, PET_TYPE_ERR, AGE_ERR
    }


    static void eatNonIntInput(Scanner in) {
        while (!in.hasNextInt()) {
            System.out.println("Couldn't parse a number. Please, try again");
            in.next();
        }
    }

    static String handleErrors(InputErrors errCode) {
        return "Input error. " + switch (errCode) {
            case SIZE_ERR -> "Size <= 0";
            case PET_TYPE_ERR -> "Unsupported pet type";
            case AGE_ERR -> "Age <= 0";
        };
    }

    static void insertAnimal(List<Animal> li, String petType, String name, int age) {

        switch (petType) {
            case "dog" -> li.add(new Dog(name, age));
            case "cat" -> li.add(new Cat(name, age));
        }
    }

    public static void main(String[] s) {
        Scanner input = new Scanner(System.in);

        eatNonIntInput(input);

        int count = input.nextInt();

        if (count <= 0)
            System.out.println(handleErrors(InputErrors.SIZE_ERR));
        else {
            List<Animal> pets = new ArrayList<>();
            String petTypes = "catdog";

            while (count > 0) {
                String petType = input.next().toLowerCase();
                if (!petTypes.contains(petType))
                    System.out.println(handleErrors(InputErrors.PET_TYPE_ERR));
                else {
                    String name = input.next();
                    eatNonIntInput(input);

                    int age = input.nextInt();
                    if (age <= 0)
                        System.out.println(handleErrors(InputErrors.AGE_ERR));
                    else
                        insertAnimal(pets, petType, name, age);

                }
                count--;
            }

            for (AnimalIterator it = new AnimalIterator(Collections.unmodifiableList(pets)); it.hasNext(); )
                System.out.println(it.next());
        }
    }
}

