import java.util.concurrent.*;

/**
 * Created by Duc.Nguyen on 10/4/2018.
 */
public class Concurrency  {
    public static void ConcurrencyPool()throws InterruptedException, ExecutionException{
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

    public static void main(String [] args) throws InterruptedException, ExecutionException {

    }

    private static void sleep(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            throw  new RuntimeException(e);
        }
    }
}
