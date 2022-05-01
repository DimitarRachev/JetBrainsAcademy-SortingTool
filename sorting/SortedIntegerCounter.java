package sorting;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortedIntegerCounter extends Counter {
    Scanner scanner;
    List<Integer> list;

    public SortedIntegerCounter() {
        this.scanner = new Scanner(System.in);
        this.list = new ArrayList<>();
    }

    @Override
    String count() {
        getAndSortIntegers();
        return getStringBuilder().toString();
    }

    @NotNull
    private StringBuilder getStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append("Total numbers: ").append(list.size()).append(".")
                .append(System.lineSeparator()).append("Sorted data: ");
        for (Integer integer : list) {
            sb.append(integer).append(" ");
        }
        return sb;
    }

    private void getAndSortIntegers() {
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            boolean notInserted = true;
            if (list.size() == 0) {
                list.add(n);
                notInserted = false;
            }
            if (notInserted) {
                for (int i = 0; i < list.size() - 1; i++) {
                    if (n < list.get(i)) {
                        list.add(i, n);
                        notInserted = false;
                        break;
                    }
                }
            }
            if (notInserted && n < list.get(list.size() - 1)) {
                list.add(list.size() - 1, n);
            } else if (notInserted) {
                list.add(n);
            }
        }
    }
}
