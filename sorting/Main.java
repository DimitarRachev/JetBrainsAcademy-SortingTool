package sorting;

public class Main {
    public static void main(final String[] args) {

//        CounterFactory factory = new CounterFactory(args);
//        Counter counter = factory.makeCounter();
        try {
            SorterFactory factory1 = new SorterFactory(args);
            Sorter sorter = factory1.makeSorter();
            System.out.println(sorter.sort());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
