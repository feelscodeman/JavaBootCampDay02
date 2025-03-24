import java.util.Scanner;

class DigMatch {
    static int countDigits(int value) {
        if (value < 0)
            value *= -1;

        int result = (value == 0) ? 1 : 0;

        while (value != 0) {
            value /= 10;
            result++;
        }

        return result;
    }

    static boolean isMatch(int value) {
        return value / (int) (Math.pow(10, countDigits(value) - 1)) == value % 10;
    }

    static void printArr(int[] arr) {

        if (arr.length == 0)
            System.out.println("There are no such elements");

        else {
            for (var el : arr)
                System.out.print(el + " ");
            System.out.println();
        }
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
            int[] arrayNum = new int[count];
            int index = 0;
            int matchCount = 0;

            while (index < count) {

                if (!input.hasNextInt()) {
                    System.out.println("Couldn't parse a number. Please, try again");
                    input.next();
                } else {
                    int value = input.nextInt();
                    if (isMatch(value)) {
                        matchCount++;
                    }
                    arrayNum[index++] = value;
                }
            }

            int[] matchNums = new int[matchCount];
            index = 0;

            for (var el : arrayNum)
                if (isMatch(el))
                    matchNums[index++] = el;

            System.out.println("The size is " + matchNums.length);

            printArr(matchNums);
        }
    }
}