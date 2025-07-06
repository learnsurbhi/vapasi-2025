public class BookingTask implements Runnable{

    private String bookingId;

    public BookingTask(String bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public synchronized void run(){
        System.out.println("Booking Request received: "+bookingId);
        processPayment();
        confirmTicket();
    }

    synchronized void processPayment()  {
        System.out.println("Processing payment for booking : "+ bookingId);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized void confirmTicket(){
        System.out.println("Ticket confirmed for booking : "+bookingId);
    }
}
