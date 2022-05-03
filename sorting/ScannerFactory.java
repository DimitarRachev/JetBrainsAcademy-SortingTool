package sorting;

import java.util.Scanner;

public class ScannerFactory {
    public static Scanner makeScanner(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-inputFile")) {
                return new Scanner(args[i + 1]);
            }
        }
        return new Scanner(System.in);
    }
}
