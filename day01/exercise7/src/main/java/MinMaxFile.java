import java.io.IOException;
import java.nio.file.Files;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

class MinMaxFile {

    static void writeValues(String strToWrite) {

        try {
            Path p = Paths.get("./result.txt").toAbsolutePath();
            if (!Files.exists(p))
                Files.createFile(p);
            Files.write(p, strToWrite.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void printArr(double[] arr) {
        for (var el : arr)
            System.out.print(el + " ");
        System.out.println();
    }

    static String findMinMax(double[] arr) {
        double min = arr[0];
        double max = arr[0];

        for (var el : arr) {
            if (el > max)
                max = el;
            else if (el < min)
                min = el;
        }
        System.out.println("Saving min and max values in file");
        return min + " " + max;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Path pathToFile = Paths.get(input.nextLine().trim()).toAbsolutePath();

        if (!pathToFile.toFile().exists())
            System.out.println("Input error. File doesn't exist");
        else {
            try {
                input = new Scanner(pathToFile);
                while (!input.hasNextInt())
                    input.next();

                int count = input.nextInt();

                if (count <= 0)
                    System.out.println("Input error. Size <= 0");
                else {
                    double[] numArr = new double[count];

                    for (int i = 0; i < count; ) {
                        if (input.hasNextDouble())
                            numArr[i++] = input.nextDouble();
                        else
                            input.next();
                    }
                    System.out.println(count);
                    printArr(numArr);
                    writeValues(findMinMax(numArr));
                }
            } catch (NoSuchElementException e) {
                System.out.println("Input error. Insufficient number of elements");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}