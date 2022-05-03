package sorting;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArgumentChecker {
    String[] args;

    public ArgumentChecker(String[] args) {
        this.args = args;
    }

    void checkArray(String[] args) {
        Pattern pattern = Pattern.compile(".*\\..*");
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-sortingType")) {
                if (i + 1 >= args.length || (!args[i + 1].equals("natural") && !args[i + 1].equals("byCount"))) {
                    throw new IllegalArgumentException("No sorting type defined!");
                }
            } else if (args[i].equals("-dataType")) {
                if (i + 1 >= args.length || (!args[i + 1].equals("long") && !args[i + 1].equals("word") && !args[i + 1].equals("line"))) {
                    throw new IllegalArgumentException("No data type defined!");
                }
            } else if (args[i].equals("-inputFile")) {
                if (i + 1 >= args.length) {
                    throw new IllegalArgumentException("No input file defined!");
                }
                Matcher matcher = pattern.matcher(args[i + 1]);
                if (!matcher.matches()) {
                    throw new IllegalArgumentException("No input file defined!");
                }
            } else if (args[i].equals("-outputFile")) {
                if (i + 1 >= args.length) {
                    throw new IllegalArgumentException("No output file defined!");
                }
                Matcher matcher = pattern.matcher(args[i + 1]);
                if (!matcher.matches()) {
                    throw new IllegalArgumentException("No output file defined!");
                }
            } else if (args[i].startsWith("-")) {
                System.out.println("\"" + args[i] + "\" is not a valid parameter. It will be skipped.");
            }
        }

    }
}
