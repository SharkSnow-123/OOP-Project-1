public class Cashier extends User {
    private String employeeId;

    public Cashier(String name, String employeeId) {
        super(name); 
        this.employeeId = employeeId;
    }

    public void displayCashierMenu() {
        System.out.println("=====================================");
        System.out.println("CASHIER: " + getName().toUpperCase() + " (" + employeeId + ")");
        System.out.println("=====================================");
        System.out.println("1. Process Customer Booking");
        System.out.println("2. Quick Book (name + seats)");
        System.out.println("3. View Today's Sales");
        System.out.println("4. Back to Main");
    }

    public void printTicket(String customerName, String movie, String seats, String ticketId) {
        System.out.println("TICKET #" + ticketId + " PRINTED");
        System.out.println("CASHIER: " + getName());
    }
}