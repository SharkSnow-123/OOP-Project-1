
//Guys use lang to og camel case sa naming

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Showtime currentShowtime = new Showtime(); 
        SalesReport dailyReport = new SalesReport("2026-03-05");
        
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=================================================================");
            System.out.println("                    CREZA PERSONAL AWESOME THEATRE               ");
            System.out.println("=================================================================");
            System.out.println("What type of user are you? ");
            System.out.println("1. Customer \t (Book your own tickets)");
            System.out.println("2. Cashier \t (Book for customers)");
            System.out.println("3. Admin \t (View Reports)");
            System.out.println("4. Exit: ");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            User currentUser = null;

            switch (choice) {
                case 1:
                    currentUser = new Customer("Careza", "C101");
                    break;
                case 2:
                    currentUser = new Cashier("Cyrus", "E101");
                    break;
                case 3:
                    currentUser = new Admin("Dirk", "A001");
                    break;
                case 4:
                    System.out.println("Shutting Down...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

            if (currentUser != null) {
                
                boolean inSubMenu = true;
                while (inSubMenu) {

                    currentUser.displayMenu(); 
                    System.out.print("Enter Action: ");
                    int action = sc.nextInt();

                    if (action == 4) {

                        inSubMenu = false; 

                    }else {
            
                        if (currentUser instanceof Cashier) {
                            ((Cashier) currentUser).handleMenu(action, dailyReport, currentShowtime, sc);
                        }
                    }
                }
            }
        }
        sc.close();
    }
}