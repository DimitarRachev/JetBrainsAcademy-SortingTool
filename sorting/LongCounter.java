package sorting;

import java.util.Scanner;

public class LongCounter extends Counter {
    Scanner scanner = new Scanner(System.in);

    @Override
    String count() {
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
//        StringBuilder sb = new StringBuilder();
//        sb.append("Total numbers: ").append(counter).append(System.lineSeparator())
//                .append("The greatest number: ").append(max).append(" (").append(counterMax)
//                .append()
        return String.format("Total numbers: %d.%nThe greatest number: %d (%d time(s), %.0f).", counter, max, counterMax, (double) counterMax / counter * 100);
    }
}
