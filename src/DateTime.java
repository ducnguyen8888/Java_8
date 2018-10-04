/**
 * Created by Duc.Nguyen on 6/7/2018.
 */
import java.security.KeyStore;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class DateTime {
    // LocalDate class represent a date
    private LocalDate startDate = null;
    private LocalDate endDate   = null;

    public static void biWeeklySchedule(LocalDate start, LocalDate end ){
        LocalDate nextSchedule = start;
        while( nextSchedule.isBefore(end) ) {
            System.out.println("Your next biweekly schedule "+ nextSchedule);
            nextSchedule = nextSchedule.plus(Period.ofWeeks(2));

        }

    }
    public static void monthlySchedule(LocalDate start, LocalDate end ){
        LocalDate nextSchedule = start;
        while( nextSchedule.isBefore(end) ) {
            System.out.println("Your next monthly schedule "+ nextSchedule);
            nextSchedule = nextSchedule.plus(Period.ofMonths(1));
        }

    }

    public static void biMonthlySchedule(LocalDate start, LocalDate end ){
        LocalDate nextSchedule = start;
        while( nextSchedule.isBefore(end) ) {
            System.out.println("Your next bimonthly schedule "+ nextSchedule);
            nextSchedule = nextSchedule.plus(Period.ofMonths(2));
        }

    }


    public static void quarterlySchedule(LocalDate start, LocalDate end ){
        LocalDate nextSchedule = start;
        while( nextSchedule.isBefore(end) ) {
            System.out.println("Your next quarterly schedule "+ nextSchedule);
            nextSchedule = nextSchedule.plus(Period.ofMonths(3));
        }

    }

    public static void main(String[] args) {
        //LocalDate represents a date
        // Specify the specific date
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE.ofPattern("yyyy MMM dd");
        LocalDate endOfMonth        = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println( endOfMonth);
        LocalDate nextDay           = localDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println( nextDay);
        System.out.println(localDate.format(formatter));
        // Current data LocalDate.now()
        System.out.println(localDate.toString());
        System.out.println(localDate.getDayOfWeek().toString());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.isLeapYear());
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());

        // Manipulate the dates
        localDate = localDate.plusDays(3);
        System.out.println("New date(plus day):"+localDate);
        localDate = localDate.plusWeeks(1);
        System.out.println("New date(plus week):"+localDate);
        localDate = localDate.plusMonths(1);
        System.out.println("New date(plus month)"+localDate);
        localDate = localDate.plusYears(1);
        System.out.println("New date(plus year)"+ localDate);

        //LocalTime
        // Current time
        //LocalTime localTime = LocalTime.now();
        // Specify the specific date
        LocalTime localTime = LocalTime.now();
        System.out.println( localTime.toString() );
        System.out.println( localTime.getHour());
        System.out.println( localTime.getMinute() );
        System.out.println( localTime.getSecond() );
        System.out.println( localTime.MIDNIGHT);
        System.out.println( localTime.NOON);

        //Local Date Time
        //Current date time
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println( localDateTime );
        System.out.println( localDateTime.getMonth());
        System.out.println( localDateTime.getDayOfMonth());
        System.out.println( localDateTime.getHour());

        Month month = Month.APRIL;

        System.out.println( 4 == month.getValue());

        LocalDate start = LocalDate.now();
        LocalDate end   = start.plusYears(1);

        biWeeklySchedule(start, end);
        monthlySchedule(start, end );
        biMonthlySchedule(start, end);
        quarterlySchedule(start, end );

    }

}
