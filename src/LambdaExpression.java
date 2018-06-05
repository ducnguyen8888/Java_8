/**
 * Created by Duc.Nguyen on 6/4/2018.
 */
import java.util.*;
public class LambdaExpression {
    public static void main(String[] args) {
        Employee[] employees = {new Employee("d"), new Employee("c"), new Employee("b"), new Employee("a")};
        Arrays.sort(employees, Employee::nameCompare);
        System.out.println( Arrays.toString(employees));
    }
}
