package sorting;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SorterStrigsByCount extends Sorter {
    Scanner scanner;
    Map<String, Integer> map;
    int count;

    public SorterStrigsByCount() {
        scanner = new Scanner(System.in);
        map = new TreeMap<>();
        count = 0;
    }

    @Override
    String sort() {
        populateMap();
        Map<String, Integer> sorted = sortMap();
        return getString(sorted);
    }

    @NotNull
    private Map<String, Integer> sortMap() {
        Map<String, Integer> sorted = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(e -> sorted.put(e.getKey(), e.getValue()));
        return sorted;
    }

    @NotNull
    private String getString(Map<String, Integer> sorted) {
        StringBuilder sb = new StringBuilder();
        sb.append("Total words: ").append(count).append(".").append(System.lineSeparator());
        int index = 1;
        for (var entry : sorted.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue())
                    .append(" time(s), ").append((int) ((double) entry.getValue() / sorted.size() * 100))
                    .append("%");
            if (index != sorted.size()) {
                sb.append(System.lineSeparator());
            }
            index++;
        }
        return sb.toString();
    }

    private void populateMap() {
        while (scanner.hasNext()) {
            String s = scanner.next();
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
            count++;
        }
    }
}
