/**
 * Created by Duc.Nguyen on 8/23/2018.
 */
public class Operator {

    public static void main(String[] args){

        int b   =7;
        int c   = 0;


        // |= is equivalent to +=
        for (int i =1; i< 9 ; i++) {
            int a   =0;
            System.out.println(a |= i);
        }

        // &= is equivalent to -=
        for (int i =1; i< 9 ; i++) {
            System.out.print(c &= ~i);
        }
    }
}
