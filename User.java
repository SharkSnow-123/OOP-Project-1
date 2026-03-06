import java.util.List;

public abstract class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void displayMenu();
}

/////////////////////////////////////////////////////////////////////////////////////

class Customer extends User {
    private boolean isSeniorOrPWD;

    public Customer(String name, boolean isSeniorOrPWD) {
        super(name);
        this.isSeniorOrPWD = isSeniorOrPWD;
    }

    public boolean isSeniorOrPWD() {
        return isSeniorOrPWD;
    }

    @Override
    public void displayMenu() {
        System.out.println("\n--- CUSTOMER MENU: " + getName().toUpperCase() + " ---");
        System.out.println("1. View Movies & Showtimes");
        System.out.println("2. Book a Ticket");
        System.out.println("3. View Available Seats");
        System.out.println("4. Back to Main");
    }
}

//////////////////////////////////////////////////////////

class Admin extends User {

    Admin(String name) {
        super(name);
    }

    public void displayMenu() {
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
                System.out.println("Invalid Operation!");
        }
    }
}