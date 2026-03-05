import java.util.Scanner;
import java.util.ArrayList;
<<<<<<< Updated upstream

class Main {
=======
import java.util.List;
>>>>>>> Stashed changes

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
<<<<<<< Updated upstream

        int choice;

        User currentUser = null;

        System.out.println("=================================================================");
        System.out.println("                    DIRK PERSONAL AWESOME THEATRE              ");
        System.out.println("=================================================================");
        System.out.println("What type of user are you? ");
        System.out.println("1. Customer \t (Book your own tickets)");
        System.out.println("2. Cashier \t (Book for customers)");
        System.out.println("3. Admin \t (View Reports)");
        System.out.println("4. Exit: ");

        System.out.print("Enter Choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                currentUser = new Customer("1000", "Careza");
                break;

            case 3:
                currentUser = new Admin("3000", "Dirk");
                break;

            case 4:
                System.out.println("Shutting Down...");
                System.exit(0);

            default:
                System.out.println("Invalid Choice!");
        }

        if (currentUser != null) {
            System.out.println("Login Successful as " + currentUser.getName());
            currentUser.displayMenu();
        }

=======

        // --- 1. GLOBAL SYSTEM DATA (Shared across all users) ---
        Cinema cinema1 = new Cinema("SM Cinema Cebu", "Room 1", 100);
        Movie avengers = new Movie("Avengers", "Action", 150, 250.0);
        Movie spiderman = new Movie("Spider-Man", "Action", 130, 220.0);

        Showtime avengers7pm = new Showtime(avengers, cinema1, "7:00 PM", 100);
        Showtime spiderman9pm = new Showtime(spiderman, cinema1, "9:30 PM", 100);

        cinema1.addShowtime(avengers7pm);
        cinema1.addShowtime(spiderman9pm);

        // Convert showtimes to array for the Customer/Cashier handleMenu methods
        Showtime[] allShows = cinema1.getShowtimes();

        // Shared reporting and tracking
        SalesReport dailyReport = new SalesReport("2026-03-05");
        List<Ticket> masterTicketList = new ArrayList<>();

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=================================================================");
            System.out.println("                    CREZA PERSONAL AWESOME THEATRE               ");
            System.out.println("=================================================================");
            System.out.println("1. Customer \t (Book your own tickets)");
            System.out.println("2. Cashier \t (Book for customers)");
            System.out.println("3. Admin \t (View Reports)");
            System.out.println("4. Exit");
            System.out.print("\nEnter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            User currentUser = null;

            // --- 2. USER LOGIN ---
            switch (choice) {
                case 1:
                    System.out.print("Are you Senior/PWD? (true/false): ");
                    boolean isSenior = sc.nextBoolean();
                    sc.nextLine(); // Clear buffer
                    currentUser = new Customer("Careza", isSenior);
                    break;
                case 2:
                    currentUser = new Cashier("Cyrus", "E101");
                    break;
                case 3:
                    currentUser = new Admin("Dirk");
                    break;
                case 4:
                    System.out.println("Shutting Down...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

            // --- 3. SUB-MENU HANDLING ---
            if (currentUser != null && isRunning) {
                boolean inSubMenu = true;
                while (inSubMenu) {
                    currentUser.displayMenu();
                    System.out.print("Enter Action: ");
                    int action = sc.nextInt();

                    if (action == 4) {
                        inSubMenu = false;
                    } else {
                        // CUSTOMER LOGIC
                        if (currentUser instanceof Customer) {
                            Customer cust = (Customer) currentUser;
                            cust.handleMenu(action, allShows, sc);

                            // If a booking happened (Action 2), we sync it to the master report
                            if (action == 2 && !cust.getTickets().isEmpty()) {
                                Ticket lastTicket = cust.getTickets().get(cust.getTickets().size() - 1);
                                if (!masterTicketList.contains(lastTicket)) {
                                    masterTicketList.add(lastTicket);
                                    dailyReport.addSale(lastTicket.getShowtime().getMovie().getTicketPrice());
                                }
                            }
                        }
                        // CASHIER LOGIC
                        else if (currentUser instanceof Cashier) {
                            ((Cashier) currentUser).handleMenu(action, dailyReport, allShows[0], sc);
                        }
                        // ADMIN LOGIC
                        else if (currentUser instanceof Admin) {
                            ((Admin) currentUser).handleMenu(action, dailyReport, masterTicketList);
                        }
                    }
                }
            }
        }
        System.out.println("\nSystem closed. Have a great day!");
>>>>>>> Stashed changes
        sc.close();

    }

}
