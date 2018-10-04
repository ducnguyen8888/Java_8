/**
 * Created by Duc.Nguyen on 8/22/2018.
 */

import java.util.*;
public class Comparator {

    public static void main(String[] args){
        Employee e1 = new Employee("Dustin","Nguyen","Male",123,30);
        Employee e2 = new Employee("Allan","Nguyen", "Male",456,25);
        Employee e3 = new Employee("Vincent","Nguyen","Male",789,23);
        Employee e4 = new Employee("Alex","Nguyen","Male",788,21);
        Employee e5 = new Employee("Nguyet","Nguyen","Female",765,19);

        List<Employee> employees = Arrays.asList(e1,e2,e3,e4,e5);
        employees.sort(java.util.Comparator.comparing(Employee::getFirst).thenComparing(Employee::getAge).reversed());







    }
}
