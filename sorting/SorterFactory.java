package sorting;

public class SorterFactory {
    String[] args;

    public SorterFactory(String[] args) {
        this.args = args;
        checkArray(args);
    }

    private void checkArray(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-sortingType")) {
                if (i + 1 >= args.length || (!(args[i + 1].equals("natural") && !args[i].equals("byCount")))) {
                    throw new IllegalArgumentException("No sorting type defined!");
                }
            } else if (args[i].equals("-dataType")) {
                if (i + 1 >= args.length || (!args[i].equals("long") && !args[i].equals("word") && !args[i].equals("line"))) {
                    throw new IllegalArgumentException("No data type defined!");
                }
            } else if (args[i].startsWith("-")) {
                System.out.println("\"" + args[i] + "\" is not a valid parameter. It will be skipped.");
            }
        }

    }


    Sorter makeSorter() {
        String dataType = getDataType();
        String sortingType = getSortingType();
        switch (dataType) {
            case "long":
                if (sortingType.equals("natural")) {
                    return new SorterIntegerNaturally();
                } else if (sortingType.equals("byCount")) {
                    return new SorterIntegersByCount();
                }
                break;
            case "word":
                if (sortingType.equals("natural")) {
                    return new SorterStringNaturally();
                } else if (sortingType.equals("byCount")) {
                    return new SorterStrigsByCount();
                }
                break;
            case "line":
                if (sortingType.equals("natural")) {
                    return new SorterLinesNaturally();
                } else if (sortingType.equals("byCount")) {
                    return new SorterLinesByCount();
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
