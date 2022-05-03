package sorting;

@Deprecated
//not used since stage 4/6
public class CounterFactory {
    String[] args;

    public CounterFactory(String[] args) {
        this.args = args;
    }


    public Counter makeCounter() {
        if (args.length == 0) {
            return new StringCounter();
        }
        for (String s : args) {
            if (s.equals("-sortIntegers")) {
//                return new SortedIntegerNaturally();
            }
        }

        if (args[0].equals("-dataType")) {
            switch (args[1]) {
                case "long":
                    return new LongCounter();
                case "line":
                    return new LineCounter();
                case "word":
                    return new StringCounter();
                default:
                    return null;
            }
        }
        return null;
    }
}
