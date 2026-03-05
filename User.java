<<<<<<< Updated upstream

abstract class User {

    private String id;
=======
import java.util.List;
import java.util.ArrayList; // Added missing import
import java.util.Scanner; // Added missing import

public abstract class User {
>>>>>>> Stashed changes
    private String name;

    User(String id, String name) {
        this.id = id;
        setName(name);
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public abstract void displayMenu();

    // Getter for the name
    public String getName() {
        return name;
    }

}

////////////////////////////////////////////////////////////////

class Customer extends User {

<<<<<<< Updated upstream
    public Customer(String id, String name) {
        super(id, name);
=======
    private List<Ticket> tickets;
    private boolean isSeniorOrPWD;

    // Fixed constructor to initialize list and variables
    public Customer(String name, boolean isSeniorOrPWD) {
        super(name);
        this.isSeniorOrPWD = isSeniorOrPWD;
        this.tickets = new ArrayList<>();
    }

    public List<Ticket> getTickets() {
        return this.tickets;
>>>>>>> Stashed changes
    }

    @Override
    public void displayMenu() {
        System.out.println("\n--- CUSTOMER MENU ---");
        System.out.println("1. View Movies & Showtimes");
        System.out.println("2. Book Tickets");
        System.out.println("3. View My Tickets");
        System.out.println("4. Back to Main");

    }

<<<<<<< Updated upstream
}

class Cashier extends User {

    public Cashier(String id, String name) {
        super(id, name);
    }

    public void displayMenu() {
        System.out.println("--- CASHIER SYSTEM ---");
        System.out.println("1. Process Customer Booking");
        System.out.println("2. Quick Book (name + seats)");
        System.out.println("3. View Today's Sales");
        System.out.println("4. Back to Main");
    }

=======
    public void handleMenu(int choice, Showtime[] showtimes, Scanner sc) {
        switch (choice) {
            case 1:
                System.out.println("\n--- Available Movies & Showtimes ---");
                if (showtimes == null || showtimes.length == 0) {
                    System.out.println("No movies currently showing.");
                    return;
                }

                for (int i = 0; i < showtimes.length; i++) {
                    System.out.println((i + 1) + ". " + showtimes[i].getMovie().toString());
                }
                break;

            case 2:
                System.out.println("\n--- BOOKING TICKETS ---");
                if (showtimes == null || showtimes.length == 0) {
                    System.out.println("No shows available to book.");
                    break;
                }

                Showtime selectedST = showtimes[0];
                System.out.print("Confirm booking for " + selectedST.getMovie().getTitle() + "? (Y/N): ");
                if (sc.next().equalsIgnoreCase("Y")) {
                    Payment pay = new Payment(1, isSeniorOrPWD);
                    pay.processTransaction(1, pay.getTotalAmount());

                    Ticket t = new Ticket("T-" + (tickets.size() + 1), selectedST.getMovie().getTitle(), selectedST,
                            new Seat("A1"));
                    tickets.add(t);
                }
                break;

            case 3:
                System.out.println("\n--- MY TICKETS ---");
                if (tickets.isEmpty()) {
                    System.out.println("No tickets found.");
                } else {
                    for (Ticket t : tickets) {
                        t.printTicket();
                    }
                }
                break;

            case 4:
                System.out.println("Logging out...");
                break;
        }
    }
>>>>>>> Stashed changes
}

/////////////////////////////////////////////////////////////////////////

class Admin extends User {

<<<<<<< Updated upstream
    Admin(String id, String name) {
        super(name, id);
=======
    Payment payment;

    public Admin(String name) {
        super(name);
>>>>>>> Stashed changes
    }

    public void displayMenu() {
<<<<<<< Updated upstream

        System.out.println("--- ADMIN DASHBOARD ---");
        System.out.println("Total tickets: ");
        System.out.println("Total Revenue: ");
        System.out.println(" "); // Avengers: (movie) + number of tickets + total revenue

=======
        System.out.println("\n=====================================");
        System.out.println("ADMIN DASHBOARD: " + getName().toUpperCase());
        System.out.println("=====================================");
        System.out.println("1. View Total Revenue");
        System.out.println("2. View All Sold Tickets");
        System.out.println("3. Back to Main");
    }

    public void handleMenu(int choice, SalesReport report, List<Ticket> allTickets) {
        switch (choice) {
            case 1:
                report.displayDailyReport();
                break;

            case 2:
                System.out.println("\n--- ALL SOLD TICKETS ---");
                if (allTickets.isEmpty()) {
                    System.out.println("No tickets have been sold yet.");
                } else {
                    for (Ticket t : allTickets) {
                        t.printTicket();
                        System.out.println("----------------------");
                    }
                }
                break;

            case 3:
                System.out.println("Exiting Admin Dashboard...");
                break;

            default:
                System.out.println("Invalid Option.");
        }
>>>>>>> Stashed changes
    }
}