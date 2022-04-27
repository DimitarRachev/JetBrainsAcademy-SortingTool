package sorting;

public class Main {
    public static void main(final String[] args) {

        CounterFactory factory = new CounterFactory(args);
        Counter counter = factory.makeCounter();
        System.out.println(counter.count());

    }
}
