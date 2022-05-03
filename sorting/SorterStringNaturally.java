package sorting;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SorterStringNaturally extends Sorter{
    Scanner scanner;
    List<String> list;

    public SorterStringNaturally() {
        list = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    @Override
    String sort() {
        populateList();
        Collections.sort(list);
        return getString();
    }

    @NotNull
    private String getString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Total words: ").append(list.size()).append(".").append(System.lineSeparator());
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }
        return sb.toString();
    }

    private void populateList() {
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
    }
}
