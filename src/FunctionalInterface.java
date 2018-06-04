/**
 * Created by Duc.Nguyen on 6/4/2018.
 */
public interface FunctionalInterface {
    // SAM Single Abstract Method interfaces
    // These can be represented using Lambda expressions
    // Only one abstract method is allowed in any functional interface
    // Second abstract method is not permitted in a functional interface
    // Default methods have an implementation, they are not abstract

    public void firstWork();
    default void doSomeWork(){
        System.out.println("Do some homework");
    }

}
