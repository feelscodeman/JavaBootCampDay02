import java.util.Scanner;

class TimeConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()) {
            System.out.println("Couldn't parse a number");
            input.next();
        }

        int seconds = input.nextInt();

        if (seconds < 0)
            System.out.println("Incorrect time");
        else
            System.out.printf("%02d:%02d:%02d", seconds / 3600, seconds / 60 % 60, seconds - (seconds / 60 * 60));
    }
}