import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) {

        int noOfBookingReq=5;

        ExecutorService pool= Executors.newFixedThreadPool(3);

        for(int i=1;i<=noOfBookingReq;i++){

            String bookingId= "BID" + i;
            pool.execute(new BookingTask(bookingId));
        }
        pool.shutdown();


    }
}