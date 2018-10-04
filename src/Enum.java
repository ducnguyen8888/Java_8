/**
 * Created by Duc.Nguyen on 8/1/2018.
 */
public class Enum {
    public enum  Season {
        WINTER, SPRING, SUMMER, FALL
    }

    public static void main(String [] args) {
        System.out.println(Season.WINTER);
        for(Season season : Season.values() ) {
            System.out.println( season.name() );
            System.out.println( season.ordinal() );
        }

        Season s1 = Season.valueOf("WINTER");
        Season s2 = Season.SPRING;

        System.out.println(s1.name());
        System.out.println(s2.name());
    }
}
