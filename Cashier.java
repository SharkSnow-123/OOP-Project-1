public class Cashier extends User {
    private String employeeID;

    public Cashier(String name, String employeeID) {
        super(name); 
        this.employeeID = employeeID;
    }

    public void displayCashierMenu() {
        System.out.println("\n=====================================");
        System.out.println("CASHIER: " + getName().toUpperCase());
        System.out.println("ID: " + employeeID);
        System.out.println("=====================================");
        System.out.println("1. Process Customer Booking");
        System.out.println("2. Quick Book");
        System.out.println("3. View Today's Sales");
        System.out.println("4. Back to Main");
    }

    
    public void assistBooking(Showtime showtime) {
        System.out.println("Assisting booking for: " + showtime.getMovieStart());
        System.out.println("Available Seats: " + showtime.availableSeats());
    }
}