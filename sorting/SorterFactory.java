package sorting;

import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SorterFactory {
    String[] args;
    Scanner scanner;



    public SorterFactory(String[] args) throws FileNotFoundException {
        this.args = args;
        scanner = ScannerFactory.makeScanner(args);

    }


    Sorter makeSorter() {
        String dataType = getDataType();
        String sortingType = getSortingType();
        switch (dataType) {
            case "long":
                if (sortingType.equals("natural")) {
                    return new SorterIntegerNaturally(scanner);
                } else if (sortingType.equals("byCount")) {
                    return new SorterIntegersByCount(scanner);
                }
                break;
            case "word":
                if (sortingType.equals("natural")) {
                    return new SorterStringNaturally(scanner);
                } else if (sortingType.equals("byCount")) {
                    return new SorterStrigsByCount(scanner);
                }
                break;
            case "line":
                if (sortingType.equals("natural")) {
                    return new SorterLinesNaturally(scanner);
                } else if (sortingType.equals("byCount")) {
                    return new SorterLinesByCount(scanner);
                }
                break;
        }
        return null;
    }

    private String getSortingType() {
        int index = -1;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-sortingType")) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            return args[index + 1];
        }
        return "natural";
    }

    private String getDataType() {
        int index = -1;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-dataType")) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            return args[index + 1];
        }
        return "word";
    }

}
