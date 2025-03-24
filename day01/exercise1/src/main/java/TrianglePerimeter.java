import java.util.Scanner;
import java.util.Arrays;


class TrianglePerimeter {
    /**
     * @param c1 - the first pair of coordinates
     * @param c2 - the second of coordinates
     * @return - the calculated distance, using formula : sqrt((x2 - x1)^2 + (y2 - y1)^2);
     */
    public static double getDistance(double[] c1, double[] c2) {
        double dx = c2[0] - c1[0];
        double dy = c2[1] - c1[1];
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {

        final int COORD_COUNT = 6;

        Scanner input = new Scanner(System.in);
        double[] coordinates = new double[COORD_COUNT];
        int coordIndex = 0;

        while (coordIndex < coordinates.length) {
            if (input.hasNextDouble())
                coordinates[coordIndex++] = input.nextDouble();
            else {
                System.out.println("Couldn't parse a number. Please, try again: ");
                input.next();
            }
        }

        double[] sides = new double[COORD_COUNT / 2];

        for (int i = 0; i < sides.length; i++)
            sides[i] = getDistance(new double[]{coordinates[2 * i], coordinates[2 * i + 1]},
                    new double[]{coordinates[(2 * i + 2) % COORD_COUNT], coordinates[(2 * i + 3) % COORD_COUNT]});

        Arrays.sort(sides);

        if (sides[2] < sides[0] + sides[1]) {
            System.out.printf("Perimeter: %.3f", (sides[0] + sides[1] + sides[2]));
        } else
            System.out.println("It isn't a triangle");
    }
}