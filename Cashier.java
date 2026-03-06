import java.util.Scanner;

public class Cashier extends User {
    private String employeeID;

    public Cashier(String name, String employeeID) {
        super(name);
        this.employeeID = employeeID;
    }

    @Override
    public void displayMenu() {
        System.out.println("\n--- CASHIER: " + getName().toUpperCase() + " (ID: " + employeeID + ") ---");
        System.out.println("1. Process Customer Booking");
        System.out.println("2. Quick Book");
        System.out.println("3. View Today's Sales");
        System.out.println("4. Back to Main");
    }

    public void handleMenu(int choice, SalesReport report, Showtime[] movieList, Showtime currentShow, Scanner sc) {
        double basePrice = 350.00; 

        switch (choice) {
            case 1:
                if (movieList != null && movieList.length > 0) {
                    System.out.print("Select Movie (1-" + movieList.length + "): ");
                    int mIndex = sc.nextInt() - 1;
                    
                    if (mIndex >= 0 && mIndex < movieList.length) {
                        System.out.print("Senior/PWD Discount? (1: Yes, 0: No): ");
                        double price = (sc.nextInt() == 1) ? basePrice * 0.8 : basePrice;
                        
                        if (movieList[mIndex].bookSeat()) {
                            report.addSale(price); 
                            System.out.println("Success! Total: P" + price);
                        }
                    }
                }
                break;
            case 2:
                System.out.println("\n--- QUICK BOOK: ONGOING SHOWS ---");
                if (movieList != null && movieList.length > 0) {
                    Showtime ongoing = movieList[0]; 
                    System.out.print("Proceed with Quick Book for 1 seat? (Y/N): ");
                    if (sc.next().equalsIgnoreCase("Y")) {
                        if (ongoing.bookSeat()) {
                            report.addSale(basePrice); 
                            System.out.println("Success! Ticket issued for " + ongoing.getMovie().getTitle());
                        } else {
                            System.out.println("FAILED: The theater for " + ongoing.getMovie().getTitle() + " is full!");
                        }
                    } else {
                        System.out.println("Quick Book cancelled.");
                    }
                } else {
                    
                    System.out.println("Error: No movies are currently loaded in the system.");
                }
                break;
            case 3:
                report.displayDailyReport();
                break;
        }
    }
}