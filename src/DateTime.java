/**
 * Created by Duc.Nguyen on 6/7/2018.
 */
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class DateTime {
    // LocalDate class represent a date

    public static void main(String[] args) {
        //LocalDate represents a date
        // Specify the specific date
        LocalDate localDate = LocalDate.of(2018, 6, 9);
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

        //LocalTime
        // Current time
        //LocalTime localTime = LocalTime.now();
        // Specify the specific date
        LocalTime localTime = LocalTime.of(14,55,55);
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

    }

}
