package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        long max = Long.MIN_VALUE;
        int counterMax = 0;
        int counter = 0;
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            counter++;
            if (number > max) {
                max = number;
                counterMax = 1;
            } else if (number == max) {
                counterMax++;
            }
        }
        System.out.println("Total numbers: " + counter + ".");
        System.out.println("The greatest number: " + max + " (" + counterMax + " time(s)).");
    }
}
