package sorting;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SorterLinesNaturally extends Sorter{
    Scanner scanner;
    List<String> list;

    public SorterLinesNaturally() {
        scanner = new Scanner(System.in);
        list = new ArrayList<>();
    }


    @Override
    String sort() {
        populateList();
        Collections.sort(list);
        return getString();
    }

    private void populateList() {
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            list.add(s);
        }
    }

    @NotNull
    private String getString() {
        StringBuilder sb = new StringBuilder();
        //TODO check if "." is needed before line separator append
        sb.append("Total lines: ").append(list.size()).append(System.lineSeparator())
                .append("Sorted data:").append(System.lineSeparator());
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
