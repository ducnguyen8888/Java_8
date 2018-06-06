/**
 * Created by Duc.Nguyen on 6/4/2018.
 */
import java.util.*;
public class LambdaExpression {
    public static void main(String[] args) {
        List <Employee>employees = Arrays.asList( new Employee("a", "d"), new Employee("f","b"), new Employee("b","c"), new Employee("n","m") );
        Comparator<Employee>groupByComparator = Comparator.comparing(Employee::getFirst).thenComparing(Employee::getLast);
        employees.sort(groupByComparator);

        employees.stream().forEach(a -> System.out.println(a.firstName+"_"+a.getLast()));

    }
}
