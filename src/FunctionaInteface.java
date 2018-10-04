/**
 * Created by Duc.Nguyen on 9/25/2018.
 */
import java.time.LocalDate;
import java.util.function.*;
public class FunctionaInteface {
    public static Function<String, String> nvl = x -> x.length() > 0 && x!= null  ? x : "";
    public static BiFunction<String, String, String> nvl2 = (x,y)-> x.length()>0 && x!= null  ? x : y;
    public static void main(String [] args){
        String value = "";
        System.out.println(nvl.apply(value));
        System.out.println(nvl2.apply(value,"HelloWorld"));


    }
}

