import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) {

        ExecutorService pool= Executors.newFixedThreadPool(3);

        for(int i=1;i<=5;i++){

            String bookingId= "BID" + i;
            pool.execute(new BookingTask(bookingId));
        }
        pool.shutdown();


    }
}