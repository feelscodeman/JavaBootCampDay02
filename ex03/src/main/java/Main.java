import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Main {

    private static final int SIZE_ERR = 0;
    private static final int PET_TYPE_ERR = 1;
    private static final int AGE_ERR = 2;


    static void eatNonIntInput(Scanner in) {
        while(!in.hasNextInt()) {
            System.out.println("Couldn't parse a number. Please, try again");
            in.next();
        }
    }

    static String handleErrors(int errCode) {
        return "Input error. " + switch(errCode) {
            case SIZE_ERR -> "Size <= 0";
            case PET_TYPE_ERR -> "Unsupported pet type";
            case AGE_ERR -> "Age <= 0";
            default -> "";
        };
    }

    static void insertAnimal(List<Animal> li, String petType, String name, int age) {

        switch(petType) {
            case "dog" -> li.add(new Dog(name, age));
            case "cat" -> li.add(new Cat(name, age));
            case "hamster" -> li.add(new Hamster(name, age));
            case "guinea" -> li.add(new GuineaPig(name, age));
        }
    }

    static void printPets(List<Animal> pets) {
        pets.stream().filter(p -> p instanceof Herbivore).forEach(System.out::println);
        pets.stream().filter(p -> p instanceof Omnivore).forEach(System.out::println);
    }


    public static void main(String[] s) {
        Scanner input = new Scanner(System.in);

        eatNonIntInput(input);

        int count = input.nextInt();

        if (count <= 0)
            System.out.println(handleErrors(SIZE_ERR));
        else {
            List<Animal> pets = new ArrayList<>();
            String pettypes = "catdogguineahamster";

            while(count > 0) {
                String petType = input.next();
                if (!pettypes.contains(petType))
                    System.out.println(handleErrors(PET_TYPE_ERR));
                else {
                    String name = input.next();
                    eatNonIntInput(input);

                    int age = input.nextInt();
                    if (age <= 0)
                        System.out.println(handleErrors(AGE_ERR));
                    else
                        insertAnimal(pets, petType, name, age);

                }
                count--;
            }

            if (!pets.isEmpty())
                printPets(pets);
        }
    }
}
