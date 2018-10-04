/**
 * Created by Duc.Nguyen on 8/17/2018.
 */
import java.util.*;
public class Unbounded {
    public static void printList(List<?> list){
        for (Object x : list ) {
            System.out.println(x);
        }
    }

    public static void printNumber(List<?>list){
        for (Object number : list){
            System.out.println(number);
        }
    }

    public static int total(List<? extends Object>list){
        int count = 0;
        for (Object number : list){
            count += (int)number;
        }

        return count;
    }

    public static void main(String [] args){
        List<String> words = new ArrayList<>();
        words.add("Hello World");
        words.add("Welcome");
        printList(words);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(6);

        //printNumber(numbers);

        System.out.println( total(numbers) );
    }
}
