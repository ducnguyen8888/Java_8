/**
 * Created by Duc.Nguyen on 6/5/2018.
 */
public class Employee {
    public String firstName;
    public String lastName;
    private String gender;
    private int id;
    private int age;

    public Employee(){}
    public Employee(String firstName,
                    String lastName) {
      setName(firstName, lastName);
    }

    public Employee(String firstName,
                    String lastName,
                    String gender,
                    int id,
                    int age) {

        setName(firstName, lastName);
        setId(id);
        setAge(age);
        setGender(gender);
    }

    public Employee setName(String firstName,
                            String lastName) {
        this.firstName = firstName;
        this.lastName  = lastName;

        return  this;
    }

    public Employee setGender(String gender) {
        this.gender = gender;
        return  this;
    }


    public Employee setId( int id) {
        this.id = id;
        return this;
    }

    public  Employee setAge( int age) {
        this.age = age;
        return this;
    }


    public String getFirst(){
        return firstName;
    }

    public String getLast(){
        return  lastName;
    }

    public int getAge(){
        return age;
    }

    public String getGender(){
        return gender;
    }


    public static int nameCompare(Employee e1, Employee e2) {
        return e1.firstName.compareTo(e2.firstName);
    }

    @Override
    public String toString() {
        return firstName + " " +lastName;
    }

    @Override
    public boolean equals( Object object ) {
        if ( !(object instanceof Employee) ) return false;
        Employee employee = (Employee)object;
        return this.getAge() == employee.getAge();
    }

    public int hashCode( String val){
        return val.hashCode();
    }


    public static void main( String [] args ) {
        Employee employee = new Employee("Duc", "Nguyen");
        System.out.println(employee);

        Employee e1 = new Employee("Dustin", "Nguyen", "M", 123, 18);
        Employee e2 = new Employee("Vincent", "Nguyen", "M", 234, 18);

        System.out.println( e1.equals(e2));
        System.out.println(employee.hashCode(e1.firstName+e1.lastName));
    }

}
