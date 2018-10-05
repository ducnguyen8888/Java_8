import java.time.LocalTime;
import java.util.Locale;
import java.util.concurrent.*;
import java.util.*;

/**
 * Created by Duc.Nguyen on 10/4/2018.
 */
public class Concurrency  {
    static   int counter = 0;
    public static void concurrencyPool()throws InterruptedException, ExecutionException{
        ExecutorService service = Executors.newFixedThreadPool(15);
        long start = System.currentTimeMillis();
        System.out.println("Start at: "+ start);
        for ( int i = 0; i< 10; i++){
            final int number = i ;
            try {
                Future<?> result = service.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Processing number: " + number);
                        for (int j = 0; j < 200000; j++) {
                            System.out.println("Still processing number " + number);
                        }
                        sleep();
                        System.out.println("Complete processing number: " + number);

                    }
                });
                result.get(100,TimeUnit.MILLISECONDS);
            } catch (TimeoutException e){
                System.out.println(number + "Not complted in time");
            }
        }

        System.out.println("Waiting...");
        service.shutdown();
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
        System.out.println("End at: " + (System.currentTimeMillis()-start));
    }

    public static void result() throws InterruptedException, ExecutionException{
        ExecutorService service = null;
        try {
            service= Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(()->{
                for (int i = 0; i<1000; i++){
                    System.out.println("Still processing");
                }
            });
            result.get(500, TimeUnit.MILLISECONDS);
            System.out.println("Complete processing");
        } catch (TimeoutException e){
            System.out.println("Not completed in time");
        } finally {
            if (service != null){
                service.shutdown();
            }
        }
    }

    public static void singleThread() throws InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("Start");
            service.execute(()->{for(int i = 0; i <30; i++){System.out.println("Processing number "+i);}});
            System.out.println("Are numbers processed completely");

        } finally {
            if ( service != null){ service.shutdown();}
        }
    }

    public static void scheduleAtFixedRate() throws InterruptedException{
       ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);
        Runnable beeper = () -> System.out.println("Hello at "+LocalTime.now().toString());
        ScheduledFuture<?> beeperHandle =
                scheduler.scheduleAtFixedRate(beeper, 10, 10, TimeUnit.SECONDS);
        Runnable canceller = () -> beeperHandle.cancel(true);
        scheduler.schedule(canceller, 1, TimeUnit.HOURS);


    }

    public static synchronized void add(){
        System.out.println(counter++);
    }

    public static void incrementCounter() throws InterruptedException{
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(5);
            for ( int i = 0; i < 20; i++){
                service.execute(new Runnable() {
                    @Override
                    public void run() {
                        add();
                    }
                });
            }

            service.shutdown();
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

        } finally {
            if ( service != null ){
                service.shutdown();
            }
        }
    }

    public static void main(String [] args) throws InterruptedException, ExecutionException {
        incrementCounter();
    }

    private static void sleep(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            throw  new RuntimeException(e);
        }
    }
}
