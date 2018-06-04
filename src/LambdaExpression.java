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
    class Employee {
        String name;

        Employee(String name) {
            this.name = name;

        }


        public static int nameCompare(Employee e1, Employee e2) {
            return e1.name.compareTo(e2.name);
        }

        public String toString() {
            return name;
        }
    }

