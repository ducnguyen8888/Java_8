/**
 * Created by Duc.Nguyen on 8/3/2018.
 */
import java.util.*;
interface Flyer{ void fly(); }
class HangGlier implements Flyer {
    public void fly(){
        System.out.println("Hangglier fly");
    }
}

class Goose implements Flyer {
    public void fly(){
        System.out.println("Goose fly");
    }
}

public class WildCard {
    public static long total(List< ? extends Number> list){
        long count = 0;
        for (Number number : list ) {
            count += number.longValue();
        }

        return count;
    }

    public void anyFlyer( List<Flyer>listFlyer){
        for (Flyer flyer : listFlyer ) {
            flyer.fly();
        }
    }

    public void groupOfFlyer( List< ? extends Flyer>listFlyer){
        for(Flyer flyer : listFlyer ) {
            flyer.fly();
        }
    }

    public static long total2(List list) {
        long count = 0;
        for(Object object : list){
            Number number = (Number) object;
            count += number.longValue();
        }

        return count;
    }

    public static void main(String [] args){
        List<Integer> myNumber = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println( WildCard.total(myNumber) );

        Flyer hanglier = new HangGlier();
        Flyer goose    = new Goose();

        List<Flyer> list = Arrays.asList(hanglier, goose);
        List<? extends Flyer> list2 = Arrays.asList(hanglier, goose);

        for (Flyer flyer : list) {
            flyer.fly();
        }

        for (Flyer flyer : list2) {
            flyer.fly();
        }

        // lower bounder wildcards

    }
}
