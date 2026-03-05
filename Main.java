import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- 1. SETUP DATA (Fixing the Showtime Constructor Error) ---
        Movie movie1 = new Movie("Avengers: Endgame", "Action", 181, 250.0);
        // Create Cinema object first
        Cinema cinema1 = new Cinema("Creza Theatre", "Cinema 1", 50);
        // Pass the Cinema OBJECT, not a String
        Showtime st1 = new Showtime(movie1, cinema1, "13:00", 50);

        List<Showtime> activeShowtimes = new ArrayList<>();
        activeShowtimes.add(st1);

        User currentUser = null;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=================================================================");
            System.out.println("                CREZA PERSONAL AWESOME THEATRE                 ");
            System.out.println("=================================================================");
            System.out.println("1. Customer \t (Book your own tickets)");
            System.out.println("2. Cashier \t (Assist Customers)");
            System.out.println("3. Admin \t (View Reports)");
            System.out.println("4. Exit");
            System.out.print("\nSelect User Type: ");

            int userChoice = sc.nextInt();
            sc.nextLine();

            if (userChoice == 4)
                break;

            // LOGIN PART
            switch (userChoice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String custName = sc.nextLine();
                    System.out.print("Senior/PWD? (true/false): ");
                    boolean isSr = sc.nextBoolean();
                    currentUser = new Customer(custName, isSr);
                    break;
                case 2:
                    // Fix: Assign to currentUser so the menu loop sees it
                    currentUser = new Cashier("Cyrus", "EMP-1001");
                    break;
                case 3:
                    currentUser = new Admin("Dirk");
                    break;
                default:
                    System.out.println("Invalid Choice!");
                    continue;
            }

            // --- 3. SUB-MENU LOOP ---
            boolean loggedIn = true;
            while (loggedIn && currentUser != null) {
                currentUser.displayMenu();
                System.out.print("Enter Action: ");
                int action = sc.nextInt();

                if (currentUser instanceof Customer) {
                    Customer c = (Customer) currentUser;
                    if (action == 1)
                        c.viewMovies(activeShowtimes.toArray(new Showtime[0]));
                    else if (action == 2) {
                        // Simplified booking logic
                        processBooking(sc, c, activeShowtimes.get(0));
                    } else if (action == 4)
                        loggedIn = false;

                } else if (currentUser instanceof Cashier) {
                    Cashier cash = (Cashier) currentUser;
                    if (action == 1) {
                        System.out.println("\n--- Cashier Booking Assistance ---");
                        cash.assistBooking(activeShowtimes.get(0));
                        // You can reuse the same processBooking logic here
                    } else if (action == 4)
                        loggedIn = false;

                } else if (currentUser instanceof Admin) {
                    if (action == 4)
                        loggedIn = false;
                }
            }
        }
        System.out.println("Goodbye!");
        sc.close();
    }

    // Helper method to keep main clean
    public static void processBooking(Scanner sc, User u, Showtime st) {
        System.out.println("Processing for: " + st.getMovie().getTitle());
        Payment pay = new Payment(1, u.isSeniorOrPWD());
        System.out.print("Payment Method (1-Cash, 2-Card, 3-GCash): ");
        int method = sc.nextInt();
        pay.processTransaction(method, pay.getTotalAmount()); // Auto-pay for demo
        System.out.println("Ticket Issued!");
    }
}