import java.util.ArrayList;
import java.util.List;

public class Booking {
    private String bookingId;
    private String customerName;
    private List<Ticket> tickets;
    private double totalAmount;
    private Payment payment; 

    public Booking(String bookingId, String customerName) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.tickets = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
      
    }

    public void processCheckout(boolean isSeniorOrPWD) {
        this.payment = new Payment(tickets.size(), isSeniorOrPWD);
        
        this.totalAmount = payment.getTotalAmount();
    }

    public void confirmBooking() {
        System.out.println("Booking confirmed for " + customerName);
        System.out.println("Total Amount: ₱" + totalAmount);
    }
}