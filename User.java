import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String name;

    // Constructor
    public User(String name) {
        this.name = name;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    // Getters
    public String getName() {
        return name;
    }

    // Methods
    public abstract void displayMenu();

    public abstract boolean isSeniorOrPWD();
}

//////////////////////////////////////////////////////////////////////////////////////////////

class Customer extends User {
    private List<Ticket> tickets;
    private boolean isSeniorOrPWD;

    public Customer(String name, boolean isSeniorOrPWD) {
        super(name);
        this.isSeniorOrPWD = isSeniorOrPWD;
        this.tickets = new ArrayList<>();
    }

    @Override
    public void displayMenu() {
        System.out.println("\n--- CUSTOMER MENU ---");
        System.out.println("1. View Movies & Showtimes");
        System.out.println("2. Book Tickets");
        System.out.println("3. View My Tickets");
        System.out.println("4. Logout");
    }

    // FOR OPTION 1
    public void viewMovies(Showtime[] showtimes) {
        System.out.println("\n--- Available Movies & Showtimes ---");
        if (showtimes.length == 0) {
            System.out.println("No movies currently showing.");
            return;
        }
        for (int i = 0; i < showtimes.length; i++) {
            System.out.println((i + 1) + ". " + showtimes[i].getMovie().toString());
        }
    }

    // For Booking tickets
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    // for viewingtickets

    public void viewMyTickets() {
        System.out.println("=====================================");
        System.out.println("          MY BOOKED TICKETS          ");
        System.out.println("=====================================");

        for (Ticket t : tickets) {
            t.printTicket();
            System.out.println("-------------------------------------");

        }
    }

    // The discount on granny
    public boolean isSeniorOrPWD() {
        return isSeniorOrPWD;
    }
}

// ADMIN

class Admin extends User {
    private List<Ticket> allSoldTickets;
    private double totalRevenue;

    public Admin(String name) {
        super(name);
        this.allSoldTickets = new ArrayList<>();
        this.totalRevenue = 0.0;
    }

    public void recordSale(Ticket ticket, Payment payment) {
        allSoldTickets.add(ticket);
        this.totalRevenue += payment.getTotalAmount();
    }

    @Override
    public void displayMenu() {
        System.out.println("\n*************************************");
        System.out.println("--- ADMIN DASHBOARD ---");
        System.out.println("Total Tickets Sold: " + allSoldTickets.size());
        System.out.println("Total Revenue: ₱" + String.format("%.2f", totalRevenue));
        System.out.println("*************************************");

        displayMovieStats();
    }

    private void displayMovieStats() {
        System.out.println("\nMovie Sales Breakdown:");
        for (Ticket t : allSoldTickets) {
            System.out.println("- " + t.getMovieName() + " (Ticket ID: " + t.getTicketId() + ")");
        }
    }

    public boolean isSeniorOrPWD() {
        return false;
    }
}
