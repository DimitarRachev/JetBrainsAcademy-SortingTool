package sorting;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SorterIntegersByCount extends Sorter {
    private Map<Integer, Integer> map;
    private Scanner scanner;
    int count;

    public SorterIntegersByCount() {
        map = new TreeMap<>();
        this.scanner = new Scanner(System.in);
        count = 0;
    }


    private void getInts() {
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            map.putIfAbsent(n, 0);
            map.put(n, map.get(n) + 1);
            count++;
        }
    }

    @Override
    String sort() {
        getInts();
        Map<Integer, Integer> sorted = sortMap();
        return getString(sorted);
    }

    @NotNull
    private String getString(Map<Integer, Integer> sorted) {
        StringBuilder sb = new StringBuilder();
        sb.append("Total numbers: ").append(count).append(".")
                .append(System.lineSeparator());
        int index = 1;
        for (var entry : sorted.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue())
                    .append(" time(s), ").append((int)((double)entry.getValue() / sorted.size() * 100))
                    .append("%");
            if (index != sorted.size()) {
                sb.append(System.lineSeparator());
            }
            index++;
        }

        return sb.toString();
    }

    @NotNull
    private Map<Integer, Integer> sortMap() {
        Map<Integer, Integer> sorted = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(e ->sorted.put(e.getKey(), e.getValue()));
        return sorted;
    }
}
