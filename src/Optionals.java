/**
 * Created by Duc.Nguyen on 6/4/2018.
 */
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Optionals {
    // Optional is a way of replacing a nullable T reference with a non null value
    // An optional can contain a non - null T reference
    // or it may contain nothing
    //

    public static Optional<Double>avarage(double value1, double value2){
        if (value2 == 0) return Optional.empty();
        return Optional.of(value1/value2);
    }

    public static  void main(String [] args) {
        // Create empty optional
        Optional<Integer> number = Optional.empty();

        // Create optional with default non-null value
            number = Optional.of(1);

        number.ifPresent(a -> System.out.println(a+10) );

        // Default/absent values and actions

        Optional<Company>companyOptional = Optional.of( new Company("Finance"));
        System.out.println(companyOptional.isPresent());
        companyOptional.ifPresent(company -> System.out.println( company.getName()));

        Optional<String> s = Optional.of("input");

        List<Company> companies = Arrays.asList( new Company("Finance"), new Company("Accounting"), new Company("Production"));
        List<Company> foundCompanies =  new ArrayList<Company>();
        foundCompanies               = companies.stream().filter(company -> "Finance".equals(company.getName())).collect(Collectors.toList());

        // Optional.map and flatMap
        // flat map return optional
        // map return object

        Optional<Computer>computer = Optional.empty();
        String version = computer.flatMap(Computer::getSoundCard).flatMap(SoundCard::getUsb).map(USB::getVersion).orElse("Unknown");
        System.out.println( version );

        System.out.println("Average: "+avarage(4,30).get() );
        Locale locale = new Locale("en", "US");

        System.out.println(NumberFormat.getCurrencyInstance(locale).format(2369.23));
    }


    static String getOutput(String input) {
        return input == null ? null : "output for " + input;
    }

}
