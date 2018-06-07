import java.util.function.Predicate;

/**
 * Created by Duc.Nguyen on 6/5/2018.
 */

import java.util.*;
import java.util.stream.Collectors;

public class employeePredicate {
    // a functional interface. it means we can pass lambda expression wherever predicate is expected
    // use them anywhere you need to evaluate a condition on group
    // or collection of similar objects such that evaluation can result either in true or false

    public static Predicate<Employee> isAdultMale(){
        return employee -> employee.getAge() > 18 && employee.getGender().equalsIgnoreCase("M");
    }

    public static Predicate<Employee> isAdultFemale(){
        return employee -> employee.getAge() > 18 && employee.getGender().equalsIgnoreCase("F");
    }

    public static Predicate<Employee> isAgeMoreThan( int age){
        return employee -> employee.getAge() > age;
    }

    public static List<Employee> filterEmployees(List<Employee>employees,
                                                    Predicate<Employee>predicate) {
        return employees.stream().filter(predicate).collect(Collectors.<Employee>toList());
    }

    public static void main(String [] args){
        List<Employee>employees = new ArrayList<Employee>();
        employees.addAll(Arrays.asList( new Employee("Duc", "Nguyen", "M", 1,29),
                                                 new Employee("Daniel","Hung", "M", 2, 28),
                                                 new Employee("Chloe","Kim","F",3,26),
                                                 new Employee("Mila","Kim","F",4,25),
                                                 new Employee("Lily","Wong","F",5,19)));
        System.out.println( filterEmployees(employees,isAdultMale() ) );
        System.out.println( filterEmployees(employees,isAdultFemale() ) );
        System.out.println( filterEmployees(employees, isAgeMoreThan(21)));
    }
}
