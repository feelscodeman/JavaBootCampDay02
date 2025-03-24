import java.util.Scanner;

class AscendingOrderSeq {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        if (!input.hasNextInt())
            System.out.println("Input Error");
        else {

            int value = input.nextInt();
            int countNums = 1;
            int wrongNumber = 0;

            while (input.hasNextInt()) {
                int temp = value;
                value = input.nextInt();

                if (wrongNumber == 0 && value < temp)
                    wrongNumber = countNums;

                countNums++;
            }
            System.out.println((wrongNumber == 0) ? "The sequence is ordered in ascending order" : "The sequence is not ordered from the ordinal number of the number " + wrongNumber);
        }
    }
}