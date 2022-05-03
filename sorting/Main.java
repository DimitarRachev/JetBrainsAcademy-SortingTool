package sorting;

import java.io.*;

public class Main {
    public static void main(final String[] args) {


        ArgumentChecker checker = new ArgumentChecker(args);
        try {
            checker.checkArray(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        try {
            SorterFactory factory1 = new SorterFactory(args);
            Sorter sorter = factory1.makeSorter();
            PrintWriter printer = PrinterFactory.makePrinter(args);
            printer.print(sorter.sort());
            printer.flush();
            sorter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
