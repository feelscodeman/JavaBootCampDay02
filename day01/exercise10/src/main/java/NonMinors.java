import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class NonMinors {

    static void findAndPrintNonMinors(List<User> li) {
        String output = li.stream()
                .filter(u -> u.getAge() >= 18)
                .map(User::getName)
                .collect(Collectors.joining(", "));

        System.out.println(output);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()) {
            System.out.println("Couldn't parse a number. Please, try again");
            input.next();
        }

        int count = input.nextInt();

        if (count <= 0)
            System.out.println("Input error. Size <= 0");
        else {
            List<User> users = new ArrayList<>();

            for (int i = 0; i < count; ) {
                String name = input.next();
                if (input.hasNextInt()) {
                    int age = input.nextInt();
                    if (age <= 0)
                        System.out.println("Incorrect input. Age <= 0");
                    else {
                        users.add(new User(name, age));
                        i++;
                    }
                } else {
                    System.out.println("Couldn't parse a number. Please, try again");
                    input.next();
                }
            }
            findAndPrintNonMinors(users);
        }
    }
}