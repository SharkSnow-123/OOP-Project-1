import java.util.Scanner;

public class Cashier extends User {
    private String employeeID;

    public Cashier(String name, String employeeID) {
        super(name);
        this.employeeID = employeeID;
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=====================================");
        System.out.println("CASHIER: " + getName().toUpperCase());
        System.out.println("ID: " + employeeID);
        System.out.println("=====================================");
        System.out.println("1. Process Customer Booking");
        System.out.println("2. Quick Book");
        System.out.println("3. View Today's Sales");
        System.out.println("4. Back to Main");
    }

    public void handleMenu(int choice, SalesReport report, Showtime showtime) {
        Scanner sc = new Scanner(System.in);
        double ticketPrice = 350.00; 

        switch (choice) {
            case 1:
                System.out.println("\n--- PROCESSING CUSTOMER BOOKING ---");
                if (showtime == null || showtime.getMovieStart().equals("TBA")) {
                    System.out.println("Error: There is no show currently scheduled.");
                } 
                else if (showtime.availableSeats() <= 0) {
                    System.out.println("Status: SOLD OUT! No seats available for " + showtime.getMovieStart());
                } 
                else {
                    System.out.println("Show: " + showtime.getMovieStart());
                    System.out.println("Seats Available: " + showtime.availableSeats());
                    System.out.print("Enter seat number to book: ");
                    sc.next(); 
                    
                    report.addSale(ticketPrice); 
                    System.out.println("Booking successful for " + showtime.getMovieStart());
                }
                break;

            case 2:
                System.out.println("\n--- QUICK BOOK: ONGOING SHOWS ---");
                if (showtime == null || showtime.getMovieStart().equals("TBA")) {
                    System.out.println("Status: No ongoing shows found.");
                } 
                else {
                    System.out.println("Current Show: " + showtime.toString());
                    
                    if (showtime.availableSeats() <= 0) {
                        System.out.println("Result: This show is SOLD OUT. Cannot quick book.");
                    } else {
                        System.out.print("Proceed with Quick Book for 1 seat? (Y/N): ");
                        String confirm = sc.next();
                        
                        if (confirm.equalsIgnoreCase("Y")) {
                            report.addSale(ticketPrice);
                            System.out.println("Success! 1 Ticket issued for " + showtime.getMovieStart());
                        }
                    }
                }
                break;

            case 3:
                report.displayDailyReport();
                break;

            case 4:
                System.out.println("Returning to main menu...");
                break;

            default:
                System.out.println("Invalid option.");
        }
    }
}