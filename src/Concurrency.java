import java.util.concurrent.*;

/**
 * Created by Duc.Nguyen on 10/4/2018.
 */
public class Concurrency  {
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

    public static void singleThread() throws InterruptedException{
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

    public static void main(String [] args) throws InterruptedException, ExecutionException {
        result();
    }

    private static void sleep(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            throw  new RuntimeException(e);
        }
    }
}
