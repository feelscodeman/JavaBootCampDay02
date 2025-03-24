import java.util.Scanner;

class NegativeSum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()) {
            System.out.println("Couldn't parse a number. Please, try again");
            input.next();
        }

        int count = input.nextInt();

        if (count <= 0)
            System.out.println("Input error. Size <= 0 (" + count + ")");
        else {
            int[] arrayNum = new int[count];
            int negSum = 0;
            int negCount = 0;
            for (int i = 0; i < count; ) {
                if (!input.hasNextInt()) {
                    System.out.println("Couldn't parse a number. Please, try again");
                    input.next();
                } else
                    arrayNum[i++] = input.nextInt();
            }

            for (var el : arrayNum) {
                if (el < 0) {
                    negCount++;
                    negSum += el;
                }
            }

            System.out.println((negCount == 0) ? "There are no negative numbers" : 1.0 * negSum / negCount);
        }
    }
}
