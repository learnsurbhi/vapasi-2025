public class BookingTask implements Runnable{

    private String bookingId;

    public BookingTask(String bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public void run() {
        System.out.println("Booking Request received: "+bookingId);
        processPayment();
        confirmTicket();
    }

    public void processPayment()  {
        System.out.println("Processing payment for booking : "+ bookingId);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void confirmTicket(){
        System.out.println("Ticket confirmed for booking : "+bookingId);
    }
}
