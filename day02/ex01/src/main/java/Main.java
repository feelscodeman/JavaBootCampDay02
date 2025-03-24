import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static boolean insertAnimal(List<Animal> li, String type, String name, int age) {
        return switch (type) {
            case "cat" -> li.add(new Cat(name, age));
            case "dog" -> li.add(new Dog(name, age));
            default -> false;
        };
    }

    public static void eatNonIntInput(Scanner in) {
        while (!in.hasNextInt()) {
            System.out.println("Couldn't parse a number. Please, try again");
            in.next();
        }
    }

    public static void main(String[] s) {
        Scanner input = new Scanner(System.in);

        eatNonIntInput(input);

        int count = input.nextInt();

        if (count <= 0)
            System.out.println("Incorrect input. Size <= 0");
        else {
            input.nextLine();
            List<Animal> animals = new ArrayList<>();
            List<String> animTypes = List.of("cat", "dog");

            while (count > 0) {
                String animType = input.next();
                if (!animTypes.contains(animType.toLowerCase().trim())) {
                    System.out.println("Incorrect input. Unsupported pet type");
                } else {
                    String name = input.next();
                    eatNonIntInput(input);

                    int age = input.nextInt();
                    if (age <= 0)
                        System.out.println("incorrect input. age <= 0");
                    else
                        insertAnimal(animals, animType, name, age);
                }
                count--;
            }

            if (!animals.isEmpty())
                animals.forEach(System.out::println);
        }
    }
}