package sorting;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrinterFactory {

    public static PrintWriter makePrinter(String[] args) throws FileNotFoundException {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-outputFile")) {
                return new PrintWriter(args[i +1]);
            }
        }
        return new PrintWriter(System.out);
    }
}
