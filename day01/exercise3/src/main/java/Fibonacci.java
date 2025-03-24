import java.util.Scanner;

class Fibonacci {

    public static int fibFind(int nth) {
        return switch (nth) {
            case 1 -> 0;
            case 2 -> 1;
            default -> {
                int n1 = 0;
                int n2 = 1;
                int cur = 0;

                for (int i = 0; i < nth - 2; i++) {
                    cur = n1 + n2;
                    n1 = n2;
                    n2 = cur;
                }
                yield cur;
            }
        };
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()) {
            System.out.println("Couldn't parse a number. Please, try again");
            input.next();
        }

        int nFib = input.nextInt();

        if (nFib > 48)
            System.out.println("Too large number");
        else
            System.out.println((long) fibFind(nFib) & 0xffffffffL);

    }
}