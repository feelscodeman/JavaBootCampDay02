import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class StringFilter {

    static boolean containsSubstr(String src, String target) {
        for (int i = 0, j = 0; i <= src.length() - target.length(); i++) {
            if (src.charAt(i) != target.charAt(j++))
                j = 0;

            if (j == target.length())
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()) {
            System.out.println("Couldn't parse a number. Please, try again");
            input.next();
        }

        Integer count = input.nextInt();

        if (count <= 0)
            System.out.println("Input error. Size <= 0");
        else {
            input.nextLine();
            List<String> strList = new ArrayList<>();

            for (int i = 0; i < count; i++)
                strList.add(input.nextLine().trim());

            String substr = input.nextLine().trim();

            boolean isFirstString = true;

            for (var el : strList) {
                if (containsSubstr(el, substr)) {
                    System.out.print((isFirstString ? "" : ", ") + el);
                    isFirstString = false;
                }
            }
            System.out.println();
        }
    }
}
