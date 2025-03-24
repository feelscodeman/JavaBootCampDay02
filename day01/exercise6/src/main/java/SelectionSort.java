import java.util.Scanner;

class SelectionSort {

    static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sortArrayBySelection(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[i])
                    swap(arr, i, j);
            }
        }
    }

    static void printArr(double[] arr) {
        for (var el : arr)
            System.out.print(el + " ");
        System.out.println();
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
            double[] arrNum = new double[count];

            for (int i = 0; i < count; ) {
                if (!input.hasNextDouble()) {
                    System.out.println("Couldn't parse a number. Please, try again");
                    input.next();
                } else
                    arrNum[i++] = input.nextDouble();
            }
            sortArrayBySelection(arrNum);
            printArr(arrNum);
        }
    }
}