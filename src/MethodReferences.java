/**
 * Created by Duc.Nguyen on 6/4/2018.
 */
import java.util.*;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MethodReferences {
    public static void main(String [] args) {
        List<Integer> numbers       = Arrays.asList(8,2,9,4,5,6,7,3,1);
        List<Integer> sortedNumbers = numbers.stream().sorted((number1, number2)-> number1.compareTo(number2)).collect(Collectors.toList());
        System.out.println( sortedNumbers );

        // Reference to static method
        Optional<Integer> maxNumber = numbers.stream().reduce(Math :: max);
        maxNumber.ifPresent( System.out::println);

        // Reference to instance method from  class type
        List<Integer> sortedNumbersAtl    = numbers.stream().sorted(Integer :: compareTo).collect(Collectors.toList());
        System.out.println( sortedNumbersAtl);

        // Reference to Constructor
        List<Integer> integers = IntStream.range(1,1000).boxed().collect(Collectors.toCollection(ArrayList::new));
        Optional<Integer> max  = integers.stream().reduce(Math::max);
        max.ifPresent( System.out::println);
    }
}
