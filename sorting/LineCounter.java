package sorting;

import java.util.Scanner;

@Deprecated
//not used since stage 4/6
public class LineCounter extends Counter{
    Scanner scanner = new Scanner(System.in);

    @Override
    String count() {
        String max = "";
        int counterMax = 0;
        int counter = 0;
        while (scanner.hasNextLine()) {
            String next = scanner.nextLine();
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
        return String.format("Total lines:  %d.%nThe longest line:%n%s%n(%d time(s), %.0f).", counter, max, counterMax, (double) counterMax / counter * 100);
    }
}
