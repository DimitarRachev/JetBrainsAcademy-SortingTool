package sorting;

import java.util.Scanner;

public class StringCounter extends Counter {
    Scanner scanner = new Scanner(System.in);


    @Override
    String count() {
        String max = "";
        int counterMax = 0;
        int counter = 0;
        while (scanner.hasNext()) {
            String next = scanner.next();
            counter++;
            if (next.length() > max.length()) {
                max = next;
                counterMax = 1;
            } else if (next.length() == max.length()) {
                if (next.equals(max)) {
                    counterMax++;
                } else if (next.compareTo(max) > 0) {
                    max = next;
                    counterMax = 1;
                }
            }
        }
        return String.format("Total words: %d.%nThe longest word: %s (%d time(s), %.0f).", counter, max, counterMax, (double) counterMax / counter * 100);
    }
}
