/**
 * Created by Duc.Nguyen on 6/8/2018.
 */
import java.util.*;
import java.lang.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamBuilder {

    public static void main(String[] args) {
       // stream from collection
        Stream<Integer> stream = Stream .of(1,2,3,4,5,6,7,8,9);
        stream.forEach(number -> System.out.print(number));

        // stream from array
        Integer[] numbers = new Integer[]{1,2,3,4,5,6,7,8,9};
        Stream<Integer>stream1 = Stream.of(numbers);
        stream1.forEach(number -> System.out.println(number));

        // stream from list
        List<Integer> numbers2 = Arrays.asList(1,2,3,4,5,6,7,8);
        Stream<Integer>stream2 = numbers2.stream();
        stream2.forEach(number -> System.out.println(number));

        // how to use Stream.generate() or Stream.iterate();
        Stream<Date>stream3 = Stream.generate(() -> { return new Date();}).limit(10);
        stream3.forEach(date -> System.out.println(date) );

        // Using String chars or String tokens
        IntStream stream4 = "123456789asdfghjk".chars();
        stream4.forEach(c -> System.out.println(c));

        // Convert Stream to List using stream.collect


    }

}
